package org.scoula.security.account.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
@Setter
public class CustomUser extends User {

    private MemberVO member;//실질적인 사용자 데이터


//    이ㅣㄹ반 생성자:username, password, 권한 리스트 직접 전달
    public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities){
        super(username, password, authorities);//부모 클래스(User)의 생성자 호출
    }

//    우리가 주로 쓰는 생성자는 이거
    public CustomUser(MemberVO vo){
        super(vo.getUsername(),vo.getPassword(),vo.getAuthList());//User 생성자 호출
        this.member = vo;//전체 사용자 정보 보관
    }
}
