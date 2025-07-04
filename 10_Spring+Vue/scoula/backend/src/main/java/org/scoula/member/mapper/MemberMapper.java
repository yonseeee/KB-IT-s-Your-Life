package org.scoula.member.mapper;

import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.domain.BoardVO;
import org.scoula.member.dto.ChangePasswordDTO;
import org.scoula.security.account.domain.AuthVO;
import org.scoula.security.account.domain.MemberVO;

import java.util.List;

public interface MemberMapper {
    MemberVO get(String username);//회원 정보+권한 목록 조회(JOIN 포함)
    MemberVO findByUsername(String username);//ID 중복 체크용
    int insert(MemberVO member);//회원 정보 삽입
    int insertAuth(AuthVO auth);//권한 정보 삽입

    int update(MemberVO member);

    int updatePassword(ChangePasswordDTO changePasswordDTO);

}
