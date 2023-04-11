package ru.JSilver.asterisk.carrier.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.JSilver.asterisk.carrier.integrations.CallQueueDto;
import ru.JSilver.asterisk.carrier.integrations.CallServiceIntegration;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final CallServiceIntegration integration;

    private final CompareService compareService;
    private final DatabaseService dbService;

    public void show() {
        List<CallQueueDto> PBXList = integration.getList();
        List<CallQueueDto> dbList = dbService.getCallsList(LocalDate.of(2023,4,5), "1115");

        if (!PBXList.isEmpty()) {
            if (dbList.isEmpty()) {
                dbService.insertEntities(PBXList, "1115");
            } else {
                compareService.compareLists(PBXList, dbList, "1115");
            }
        }
    }
}
