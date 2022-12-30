package com.rafael.microservices.limitsservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component //componente gerenciado pelo spring
@ConfigurationProperties("limits-service") //para q os valores sejam mapeados do application.properties. o argumento eh o nome do microservico
public class Configuration {

    //valores que quero pegar da configuracao
    private int minimum;
    private int maximum;

    public int getMinimum() {
        return minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }
}
