package org.scoula.controller;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
@RequiredArgsConstructor //final멤버를 매개변수로 취하는 생성자
public class Restaurant {
    private final Chef chef;//Autowired보다 생성자 주입 권장
}
