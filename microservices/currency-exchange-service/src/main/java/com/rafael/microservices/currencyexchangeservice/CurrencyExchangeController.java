package com.rafael.microservices.currencyexchangeservice;

import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.LoggerFactoryFriend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private CurrencyExchangeRepository repository;

    //add log
    private final Logger log = LoggerFactory.getLogger(CurrencyExchangeController.class);

    //classe Environment ajuda a pegar o valor da porta
    @Autowired
    private Environment environment;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangevalue(@PathVariable String from, @PathVariable String to) {

        //add log
        log.info("retrieveExchangevalue called with {} to {}", from, to);

        //passo o "endereco" de onde a classe Environment vai pegar a porta correta e depois passo como
        //parametro no metodo setEnvironment da classe CurrencyExchange
        CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);

        if(currencyExchange == null) {
            throw new  RuntimeException("Unable data from " + from + " to " + to);
        }

        String port = environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(port);

        return currencyExchange;
    }
}
