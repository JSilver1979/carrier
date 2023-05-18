package ru.JSilver.asterisk.carrier.converters;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import ru.JSilver.asterisk.carrier.data.QueueEntity;
import ru.JSilver.asterisk.carrier.integrations.QueueDto;

@Component
@NoArgsConstructor
public class QueueConverter {

    public QueueDto entityToDto(QueueEntity entity) {
        QueueDto dto = new QueueDto();

        dto.setId(entity.getId());
        dto.setNumber(entity.getNumber());
        dto.setDescription(entity.getDescription());
        dto.setDelay(entity.getDelay());

        return dto;
    }
}
