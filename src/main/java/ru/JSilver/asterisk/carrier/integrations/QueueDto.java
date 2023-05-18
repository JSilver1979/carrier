package ru.JSilver.asterisk.carrier.integrations;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class QueueDto {

    private Integer id;
    private String number;
    private String description;
    private Integer delay;
}
