package com.isanuric.movie.service;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PdfService {

    public Mono<String> getTest() {

        WebClient webClient = WebClient.builder()
                .baseUrl("http://localhost:8081")
                .build();

        CustomResponse customResponse = new CustomResponse();
        customResponse.setName("abc");
        customResponse.setAge("20");

        Mono<String> httpServletResponse = webClient.post()
                .uri("/test")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(customResponse), CustomResponse.class)
                .retrieve()
                .bodyToMono(String.class);

        return httpServletResponse;
    }

    public Mono<InputStreamResource> getPdf() {
        return null;
    }

    void fluxValues() {
        Flux<String> stringFlux = Flux.just("1", "2", "3", "4");
        stringFlux.log()
                .subscribe(System.out::println);
    }
}
