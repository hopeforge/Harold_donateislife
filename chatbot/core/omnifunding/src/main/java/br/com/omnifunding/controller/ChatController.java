package br.com.omnifunding.controller;

import java.util.Calendar;

import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import br.com.omnifunding.dto.MessageDTO;
import br.com.omnifunding.dto.ResponseDTO;

@Controller
public class ChatController {

	@MessageMapping("/chat/message")
	@SendTo("/topic/messages")
	public ResponseDTO send(@Payload MessageDTO message) throws Exception {
		System.out.println(message.getMessage());
		return ResponseDTO.builder().from(message.getFrom()).message(message.getMessage()).time(Calendar.getInstance())
				.build();
	}

	@MessageExceptionHandler
	@SendToUser("/topic/errors")
	public String handleException(Throwable exception) {
		return exception.getMessage();
	}
}
