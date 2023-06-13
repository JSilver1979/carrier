package ru.JSilver.asterisk.carrier.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.JSilver.asterisk.carrier.integrations.CallQueueDto;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompareService {

    private final DatabaseService dbService;

    public void compareLists(List<CallQueueDto> PBXList, List<CallQueueDto> dbList) {
        List<CallQueueDto> diff = PBXList.stream()
                .filter((CallQueueDto item) -> !dbList.contains(item))
                .collect(Collectors.toList());

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

//            if (!updateList.isEmpty()) {
//                for (int i = 0; i < updateList.size(); i++) {
//                    log.info("Updated item: " + updateList.get(i).getCallId() + "; " + updateList.get(i).getQueueTime() + "; " + updateList.get(i).getQueue());
//                }
//            }

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
