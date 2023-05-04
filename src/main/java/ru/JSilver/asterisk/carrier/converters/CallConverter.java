package ru.JSilver.asterisk.carrier.converters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.JSilver.asterisk.carrier.data.CallEntity;
import ru.JSilver.asterisk.carrier.integrations.CallQueueDto;

@Component
@RequiredArgsConstructor
public class CallConverter {

    public CallEntity convertToEntity(CallQueueDto item) {
        return new CallEntity(
                item.getCallId(),
                item.getNumber(),
                item.getDate(),
                item.getCallTime(),
                item.getQueueTime(),
                item.getWaitTime(),
                item.getAgentNumber(),
                item.getAnswerTime(),
                item.getAnswerDuration(),
                item.getCallStatus(),
                item.getQueueStatus(),
                item.getAudioPath(),
                item.isRedirected(),
                false,
                "",
                item.getQueue()
        );
    }

    public CallQueueDto convertToDto(CallEntity entity) {
        CallQueueDto dto = new CallQueueDto();

        dto.setCallId(entity.getCallId());
        dto.setNumber(entity.getNumber());
        dto.setDate(entity.getDate());
        dto.setCallTime(entity.getCallTime());
        dto.setQueueTime(entity.getQueueTime());
        dto.setWaitTime(entity.getWaitTime());
        dto.setAgentNumber(entity.getAgentNumber());
        dto.setAnswerTime(entity.getAnswerTime());
        dto.setAnswerDuration(entity.getAnswerDuration());
        dto.setCallStatus(entity.getCallStatus());
        dto.setQueueStatus(entity.getQueueStatus());
        dto.setAudioPath(entity.getAudioPath());
        dto.setRedirected(entity.isRedirected());
        dto.setQueue(entity.getQueueNumber());

        return dto;
    }

    public CallEntity updateEntity(CallEntity entity, CallQueueDto dto) {
        entity.setCallId(dto.getCallId());
        entity.setNumber(dto.getNumber());
        entity.setDate(dto.getDate());
        entity.setCallTime(dto.getCallTime());
        entity.setQueueTime(dto.getQueueTime());
        entity.setWaitTime(dto.getWaitTime());
        entity.setAgentNumber(dto.getAgentNumber());
        entity.setAnswerTime(dto.getAnswerTime());
        entity.setAnswerDuration(dto.getAnswerDuration());
        entity.setCallStatus(dto.getCallStatus());
        entity.setQueueStatus(dto.getQueueStatus());
        entity.setAudioPath(dto.getAudioPath());
        entity.setRedirected(dto.isRedirected());
        entity.setQueueNumber(dto.getQueue());

        return entity;
    }
}
