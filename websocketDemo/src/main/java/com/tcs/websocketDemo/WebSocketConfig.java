package com.tcs.websocketDemo;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import com.tcs.websocketDemo.interceptors.HttpHandshakeInterceptor;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/stomp-endpoint").addInterceptors(new HttpHandshakeInterceptor()).withSockJS();
		
		
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
	
		registry.enableSimpleBroker("/topic");
		registry.setApplicationDestinationPrefixes("/app"); 
	}
	
	

}
  