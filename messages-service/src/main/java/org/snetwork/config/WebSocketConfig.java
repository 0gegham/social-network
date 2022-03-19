package org.snetwork.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Value("${spring.amqp.host}")
    private String host;

    @Value("${spring.amqp.port}")
    private Integer port;

    @Value("${spring.amqp.login}")
    private String login;

    @Value("${spring.amqp.password}")
    private String password;

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/messages-service")
                .setAllowedOrigins("*") // This is an awful example
                .withSockJS()
                .setWebSocketEnabled(true);
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableStompBrokerRelay("/amq.topic")
                .setRelayHost(host)
                .setRelayPort(port)
                .setClientLogin(login)
                .setClientPasscode(password);

    }
}
