package ru.JSilver.asterisk.carrier.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.JSilver.asterisk.carrier.integrations.CallQueueDto;
import ru.JSilver.asterisk.carrier.integrations.CallServiceIntegration;
import ru.JSilver.asterisk.carrier.integrations.SearchObject;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ScheduleService {

    private final CallServiceIntegration integration;

    private final CompareService compareService;
    private final DatabaseService dbService;

    public void getCalls(int day) {
        LocalDate searchDate = LocalDate.of(2023, 4, day);
        SearchObject so = new SearchObject(searchDate.toString());
        List<CallQueueDto> PBXList = integration.getList(so);
        log.info("PBX Calls: " + PBXList.size());
        List<CallQueueDto> dbList = dbService.getCallsList(searchDate);
        log.info("Database Calls: " + dbList.size());

        if (!PBXList.isEmpty()) {
            if (dbList.isEmpty()) {
                dbService.insertEntities(PBXList);
            } else {
                compareService.compareLists(PBXList, dbList);
            }
        }
    }
}
