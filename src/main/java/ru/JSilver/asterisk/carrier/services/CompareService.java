package ru.JSilver.asterisk.carrier.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.JSilver.asterisk.carrier.integrations.CallQueueDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompareService {

    private final DatabaseService dbService;

    public void compareLists(List<CallQueueDto> PBXList, List<CallQueueDto> dbList, String queue) {
        List<CallQueueDto> diff = PBXList.stream()
                .filter(item -> !dbList.contains(item))
                .collect(Collectors.toList());

        if (!diff.isEmpty()) {
            List<CallQueueDto> updateList = new ArrayList<>();
            List<CallQueueDto> insertList = new ArrayList<>();

            for (CallQueueDto dto : diff) {
                if (containsCallId(dbList, dto.getCallId())) {
                    updateList.add(dto);
                } else {
                    insertList.add(dto);
                }
            }

            updateDB(updateList);
            insertIntoDB(insertList, queue);
        }
    }

    private void updateDB(List<CallQueueDto> list) {
        if (!list.isEmpty()) {
            dbService.updateEntities(list);
        }
    }

    private void insertIntoDB(List<CallQueueDto> list, String queue) {
        if (!list.isEmpty()) {
            dbService.insertEntities(list, queue);
        }
    }

    private boolean containsCallId(List<CallQueueDto> list, String callId) {
        return list.stream()
                .map(CallQueueDto::getCallId)
                .anyMatch(callId::equals);
    }
}
