package org.scoula.member.service;

import org.scoula.member.dto.ChangePasswordDTO;
import org.scoula.member.dto.MemberDTO;
import org.scoula.member.dto.MemberJoinDTO;
import org.scoula.member.dto.MemberUpdateDTO;

public interface MemberService {

//    아이디 중복 여부 확인
    boolean checkDuplicate(String username);

//    username으로 회원 정보 조회
    MemberDTO get(String username);

//    회원가입(DTO->VO->DB저장->DTO 반환)
    MemberDTO join(MemberJoinDTO member);


    MemberDTO update(MemberUpdateDTO member);

    void changePassword(ChangePasswordDTO changePassword);
}
