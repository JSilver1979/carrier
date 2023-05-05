package ru.JSilver.asterisk.carrier.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.JSilver.asterisk.carrier.services.ScheduleService;

@RestController
@RequestMapping("/schedule")
@RequiredArgsConstructor
@Slf4j
public class ScheduleController {

    private final ScheduleService service;

    private int day = 1;

    @Scheduled(fixedRate = 20000)
    public void show() {
        log.info("Day: " + day);
        service.getCalls(day);
        day++;
        if (day > 30) day = 1;
    }
}
