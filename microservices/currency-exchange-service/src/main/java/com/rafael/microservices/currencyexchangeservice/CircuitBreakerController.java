package com.rafael.microservices.currencyexchangeservice;

import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-api")
    @Retry(name = "sample-api", fallbackMethod = "hardcodeResponse") //por default ele tenta executar por tres vezes o codigo e so depois
    //ele lanca o erro/excecao
    public String sampleApi() {
        logger.info("Sample Api call received");
        //criando um metodo com falhas para validar o @Retry
        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8000/some-dummy-url",
                String.class);
        return forEntity.getBody();
    }

    public String hardcodeResponse(Exception exception) {
        return "fallback-response";
    }

}
