package org.scoula.phishing.service;


import lombok.extern.log4j.Log4j2;
import org.scoula.phishing.dto.MessageDTO;
import org.scoula.phishing.exception.PhishingDetectedException;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class MessageService {
    public String sendMessage(MessageDTO dto) {
        String[] forbidden={"계좌번호", "보안카드", "대출"};
        log.info("Service");
        for(String s:forbidden){
            if(dto.getContent().contains(s)){
                throw new PhishingDetectedException(s);
            }
        }
        return "📧 메시지 전송됨:" + dto.getContent();
    }
}
