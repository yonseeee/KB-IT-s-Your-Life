package org.scoula.controller;

import lombok.extern.log4j.Log4j2;
import org.scoula.domain.ChatMessage;
import org.scoula.domain.GreetingMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;


@Controller
@Log4j2
public class ChatController {

    @MessageMapping("/hello")//수신
    @SendTo("/topic/greetings")//발신
    public GreetingMessage greeting(GreetingMessage message) throws Exception {
        log.info("greeting: "+message);
        return message;
    }

    @MessageMapping("/chat")
    @SendTo("/topic/chat")
    public ChatMessage chat(ChatMessage message) throws Exception {
        log.info("chat received: " +message);
        return message;
    }
}
