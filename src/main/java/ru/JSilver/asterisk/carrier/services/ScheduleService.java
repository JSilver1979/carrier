package ru.JSilver.asterisk.carrier.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.JSilver.asterisk.carrier.integrations.CallQueueDto;
import ru.JSilver.asterisk.carrier.integrations.CallServiceIntegration;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ScheduleService {

    private final CallServiceIntegration integration;


    public void show() {
        List<CallQueueDto> list = integration.getList();
        for (CallQueueDto item: list) {
            log.error("Item: " + item.getCallTime() + " : " + item.getNumber());
        }
    }

}
