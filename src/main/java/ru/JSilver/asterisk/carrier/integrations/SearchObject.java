package ru.JSilver.asterisk.carrier.integrations;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchObject {
    private String dateFrom;
    private String dateTo;
    private String group;
}
