package com.pfe.cigma.PFE.config;

import org.hibernate.mapping.Map;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	

	  @Override
	  public void configureMessageBroker(MessageBrokerRegistry config) {
	    config.enableSimpleBroker("/socketBroker");
	    config.setApplicationDestinationPrefixes("/app");
	   
	  }

	  @Override
	  public void registerStompEndpoints(StompEndpointRegistry registry) {
	    registry.addEndpoint("/webSocket").setAllowedOrigins("http://localhost:4200").withSockJS();
	  }
	  

	   
}
