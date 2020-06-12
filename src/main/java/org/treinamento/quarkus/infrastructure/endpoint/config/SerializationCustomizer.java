package org.treinamento.quarkus.infrastructure.endpoint.config;

import io.quarkus.jsonb.JsonbConfigCustomizer;

import javax.inject.Singleton;
import javax.json.bind.JsonbConfig;

@Singleton
public class SerializationCustomizer implements JsonbConfigCustomizer {

    @Override
    public void customize(JsonbConfig config) {
        System.out.println("Jsonb Customizer");
    }
}
