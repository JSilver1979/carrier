package ru.JSilver.asterisk.carrier.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.JSilver.asterisk.carrier.services.ScheduleService;

import java.time.LocalDate;

@RestController
@RequestMapping("/schedule")
@RequiredArgsConstructor
@Slf4j
public class ScheduleController {

    private final ScheduleService service;

    @Value("${start-date}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @Scheduled(fixedRate = 10000)
    public void show() {

//        log.info("Date: " + startDate);
//        service.getCalls(startDate);
        log.info("Date: " + LocalDate.now());
        service.getCalls(LocalDate.now());

//        if (!startDate.equals(LocalDate.now())) {
//            startDate = startDate.plusDays(1);
//        }
    }
}
