package com.tcs.websocketDemo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import com.google.gson.Gson;
import com.tcs.websocketDemo.Model.Greeting;
import com.tcs.websocketDemo.Model.HelloMessage;

@Controller
@EnableScheduling
public class GreetingController {

	@Autowired
	private SimpMessageSendingOperations messagingTemplate;
	
	@MessageMapping("/hello")
	public void greet(@Payload String message, SimpMessageHeaderAccessor  headerAccessor)
	{
		String sessionId = headerAccessor.getSessionAttributes().get("sessionId").toString();
		System.out.println(sessionId);
		headerAccessor.setSessionId(sessionId);
		messagingTemplate.convertAndSend("/topic/reply", new Gson().fromJson(message, Map.class).get("name"));
		System.out.println("Message sent");
	}
	

}
