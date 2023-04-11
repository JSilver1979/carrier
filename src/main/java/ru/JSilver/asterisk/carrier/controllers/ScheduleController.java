package ru.JSilver.asterisk.carrier.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.JSilver.asterisk.carrier.services.ScheduleService;

@RestController
@RequestMapping("/schedule")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService service;

    @Scheduled(fixedRate = 20000)
    public void show() {
        service.show();
    }
}
