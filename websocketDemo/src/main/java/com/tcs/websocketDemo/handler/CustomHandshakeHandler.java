package com.tcs.websocketDemo.handler;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import com.tcs.websocketDemo.Model.StompPrincipal;

import java.security.Principal;
import java.util.Map;
import java.util.UUID;
/**
 * Set anonymous user (Principal) in WebSocket messages by using UUID
 * This is necessary to avoid broadcasting messages but sending them to specific user sessions
 */
public class CustomHandshakeHandler extends DefaultHandshakeHandler {
    @Override
    protected Principal determineUser(ServerHttpRequest request,
                                      WebSocketHandler wsHandler,
                                      Map<String, Object> attributes) {
        System.out.println("User uuid "+UUID.randomUUID().toString());
        
        return new StompPrincipal(UUID.randomUUID().toString());
    }
}