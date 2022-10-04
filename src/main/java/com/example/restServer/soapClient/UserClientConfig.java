package com.example.restServer.soapClient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import static com.example.restServer.constants.Constants.CONTEXT_PATH;
import static com.example.restServer.constants.Constants.SOAP_URI;

@Configuration
public class UserClientConfig {

    // a Jaxb2Marshaller Bean to convert messages to and from XML.
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath(CONTEXT_PATH);
        return marshaller;
    }
    // userClient Bean which will wire in the marshaller bean:
    @Bean
    public UserClient userClient(Jaxb2Marshaller marshaller) {
        UserClient client = new UserClient();
        client.setDefaultUri(SOAP_URI);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
