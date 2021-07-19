package com.tcs.websocketDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.util.HtmlUtils;

import com.tcs.websocketDemo.Model.Greeting;

@Configuration
@EnableScheduling
public class SchedulerConfiguration {
	
	@Autowired
	SimpMessagingTemplate template;
	/*
	@Scheduled(fixedDelay=1000)
	public void sendAdhocMessage()
	{
		 template.convertAndSend("/topic/reply", new Greeting("Hello, "+HtmlUtils.htmlEscape("Auto message")));
	}*/
	
}
