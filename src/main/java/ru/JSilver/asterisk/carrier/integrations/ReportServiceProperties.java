package ru.JSilver.asterisk.carrier.integrations;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;


@ConfigurationProperties(prefix = "integrations.report-service")
@Data
public class ReportServiceProperties {
    private String url;
    private Integer readTimeout;
    private Integer writeTimeout;
    private Integer connectTimeout;
}
