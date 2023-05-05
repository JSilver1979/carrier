package ru.JSilver.asterisk.carrier.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.JSilver.asterisk.carrier.integrations.CallQueueDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CompareService {

    private final DatabaseService dbService;

    public void compareLists(List<CallQueueDto> PBXList, List<CallQueueDto> dbList) {
        List<CallQueueDto> diff = PBXList.stream()
                .filter((CallQueueDto item) -> !dbList.contains(item))
                .collect(Collectors.toList());

        log.info("Difference: " + diff.size());

        if (!diff.isEmpty()) {
            List<CallQueueDto> updateList = new ArrayList<>();
            List<CallQueueDto> insertList = new ArrayList<>();

            for (CallQueueDto dto : diff) {
                if (dtoInDatabase(dbList, dto)) {
                    updateList.add(dto);
                } else {
                    insertList.add(dto);
                }
            }

            log.info("Update list: " + updateList.size());
            log.info("Insert List: " + insertList.size());

            updateDB(updateList);
            insertIntoDB(insertList);
        }
    }

    private void updateDB(List<CallQueueDto> list) {
        if (!list.isEmpty()) {
            dbService.updateEntities(list);
        }
    }

    private void insertIntoDB(List<CallQueueDto> list) {
        if (!list.isEmpty()) {
            dbService.insertEntities(list);
        }
    }

    private boolean dtoInDatabase(List<CallQueueDto> list, CallQueueDto dto) {
        for (CallQueueDto callQueueDto : list) {
            if (callQueueDto.getCallId().equals(dto.getCallId()) && callQueueDto.getQueue().equals(dto.getQueue())) {
                return true;
            }
        }
        return false;
    }
}
