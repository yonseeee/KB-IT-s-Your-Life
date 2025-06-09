package org.scoula.domain;

import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
@Component //스프링이 감지하여 빈으로 등록하도록 지정
public class Parrot {
    private String name;

    @PostConstruct//bean이 생성된 후 자동으로 호출->초기화
    public void init(){
        this.name="kiki";
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
