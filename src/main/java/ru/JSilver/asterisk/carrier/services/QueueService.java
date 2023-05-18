package ru.JSilver.asterisk.carrier.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.JSilver.asterisk.carrier.converters.QueueConverter;
import ru.JSilver.asterisk.carrier.integrations.QueueDto;
import ru.JSilver.asterisk.carrier.repos.QueueRepository;

import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueueService {

    private final QueueRepository queueRepository;

    private final QueueConverter queueConverter;

    public Map<String, Integer> getQueueMap() {
        return queueRepository.findAll()
                .stream()
                .map(queueConverter::entityToDto)
                .collect(Collectors.toMap(QueueDto::getNumber, QueueDto::getDelay));
    }
}
