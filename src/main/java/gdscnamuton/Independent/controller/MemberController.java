package gdscnamuton.Independent.controller;


import gdscnamuton.Independent.dto.LoginDto;
import gdscnamuton.Independent.dto.RegisterDto;
import gdscnamuton.Independent.entity.Member;
import gdscnamuton.Independent.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;


    @PostMapping("/register")
    public String register(@RequestBody RegisterDto registerDto){
        MemberSave(registerDto);
        log.info("회원정보 저장 완료");

        return "회원 정보가 저장되었습니다.";
    }

    @GetMapping("/id/check/{checkmemberid}")
    public String checkMemberId(@PathVariable(name="checkmemberid") String id){
        List<Member> member = memberRepository.findByMemberId(id);
        if(!member.isEmpty()){
            log.info("중복된 아이디 존재");
            return "이미 등록된 아이디입니다.";
        }
        return "사용 가능한 아이디입니다.";
    }

    @PostMapping("/login")
    public String memberLogin(@RequestBody LoginDto loginDto){
        List<Member> memberIdCheck = memberRepository.findByMemberId(loginDto.getMemberId());
        if(memberIdCheck.isEmpty()){
            log.info("미등록 사용자 접근.");
            return "등록되지 않은 사용자입니다.";
        }

        List<Member> memberPasswordCheck = memberRepository.findByPassword(loginDto.getPassword());
        if(memberPasswordCheck.isEmpty()){
            log.info("비밀번호 오류.");
            return "비밀번호가 일치하지 않습니다";
        }

        log.info("등록된 사용자 접근.");
        return "등록된 사용자입니다.";
    }



    @Transactional
    private void MemberSave(RegisterDto registerDto) {
        Member member = new Member();
        member.setMemberId(registerDto.getMemberId());
        member.setName(registerDto.getName());
        member.setPassword(registerDto.getPassword());

        memberRepository.save(member);
    }


}