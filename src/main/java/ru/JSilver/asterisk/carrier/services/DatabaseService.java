package ru.JSilver.asterisk.carrier.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.JSilver.asterisk.carrier.converters.CallConverter;
import ru.JSilver.asterisk.carrier.data.CallEntity;
import ru.JSilver.asterisk.carrier.integrations.CallQueueDto;
import ru.JSilver.asterisk.carrier.repos.CallRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DatabaseService {

    private final CallRepository repository;

    private final CallConverter converter;

    @Transactional
    public void insertEntities (List<CallQueueDto> dtoList) {
        List<CallEntity> entityList = dtoList.stream()
                .map(item -> converter.convertToEntity(item))
                .collect(Collectors.toList());

        repository.saveAll(entityList);
    }

    @Transactional
    public void updateEntities (List<CallQueueDto> dtoList) {
        List<CallEntity> entityList = dtoList.stream()
                .map(item -> converter.updateEntity(repository.findByCallIdAndDate(item.getCallId(), item.getDate()),item))
                .collect(Collectors.toList());
        repository.saveAll(entityList);
    }

    public List<CallQueueDto> getCallsList(LocalDate date) {

        return repository.findAllByDate(date)
                .stream()
                .map(converter::convertToDto)
                .collect(Collectors.toList());
    }
}
