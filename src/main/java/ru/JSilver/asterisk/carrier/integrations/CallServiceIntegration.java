package ru.JSilver.asterisk.carrier.integrations;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CallServiceIntegration {

    private final WebClient callServiceWebClient;

    public List<CallQueueDto> getList() {
        SearchObject so = new SearchObject("2023-04-05", "2023-04-05", "1115");
        Mono<List<CallQueueDto>> response = callServiceWebClient.post()
                .uri("/detailed")
                .body(Mono.just(so), SearchObject.class)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {});

        List<CallQueueDto> list = response.block();

        return list;
    }
}
