package org.scoula.phishing.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.phishing.dto.MessageDTO;
import org.scoula.phishing.exception.PhishingDetectedException;
import org.scoula.phishing.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/api")
public class MessageController {

    private final MessageService service;

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody MessageDTO dto) {

        String result = service.sendMessage(dto);
        return ResponseEntity.ok().body(result);
    }
}
