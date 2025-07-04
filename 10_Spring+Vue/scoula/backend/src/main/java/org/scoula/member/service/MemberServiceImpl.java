package org.scoula.member.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.scoula.member.dto.ChangePasswordDTO;
import org.scoula.member.dto.MemberDTO;
import org.scoula.member.dto.MemberJoinDTO;
import org.scoula.member.dto.MemberUpdateDTO;
import org.scoula.member.exception.PasswordMissmatchException;
import org.scoula.member.mapper.MemberMapper;
import org.scoula.security.account.domain.AuthVO;
import org.scoula.security.account.domain.MemberVO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Optional;


@Log4j2
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    final MemberMapper mapper;

    @Override
    public boolean checkDuplicate(String username) {
        MemberVO member = mapper.findByUsername(username);
        return member != null;
    }

    @Override
    public MemberDTO get(String username) {
        MemberVO member= Optional.ofNullable(mapper.get(username))
                .orElseThrow(NoSuchElementException::new);
        return MemberDTO.of(member);


    }

    private void saveAvatar(MultipartFile avatar, String username){
        if(avatar!=null&&!avatar.isEmpty()){
            File dest=new File("c:/upload/avatar", username+".png");
            try{
                avatar.transferTo(dest);
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        }
    }


    @Transactional
    @Override
    public MemberDTO join(MemberJoinDTO dto) {
        MemberVO member=dto.toVO();

        member.setPassword(passwordEncoder.encode(member.getPassword()));
        mapper.insert(member);

        AuthVO auth=new AuthVO();
        auth.setUsername(member.getUsername());
        auth.setAuth("ROLE_MEMBER");
        mapper.insertAuth(auth);

        saveAvatar(dto.getAvatar(), member.getUsername());
//        log.info("test:"+get(member.getUsername()));
        return get(member.getUsername());
    }

    @Override
    public MemberDTO update(MemberUpdateDTO member) {
//        DB에서 기존 회원정보 조회
        MemberVO vo=mapper.get(member.getUsername());

//        입력된 비밀번호가 기존 비밀번호와 일치하는지 확인
        if(!passwordEncoder.matches(member.getPassword(), vo.getPassword())){
            throw new PasswordMissmatchException();
        }

//        회원 정보 업데이트
        mapper.update(member.toVO());

//        아바타 이미지 저장(ex: 파일 시스템 또는 클라우드 저장소)
        saveAvatar(member.getAvatar(), member.getUsername());

        System.out.println("test:"+get(member.getUsername()));

//        수정된 회원 정보 다시 조회 후 반환
        return get(member.getUsername());
    }

    @Override
    public void changePassword(ChangePasswordDTO changePassword) {
        MemberVO member=mapper.get(changePassword.getUsername());
        if(!passwordEncoder.matches(changePassword.getOldPassword(), member.getPassword())){
            throw new PasswordMissmatchException();
        }

        changePassword.setNewPassword(passwordEncoder.encode(changePassword.getNewPassword()));
        mapper.updatePassword(changePassword);
    }
}
