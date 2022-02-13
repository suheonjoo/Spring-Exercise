package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.repository.MemberRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;



public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;

    }

    /**
     * 회원가입
     */
    @Transactional
    public Long join(Member member) {
        validateDuplicateMember(member);//이미 존재하는 멤버인지 확인
        memberRepository.save(member);  //그리고 나서 멤버를 저장
        return member.getId();//저장된 멤버의 id를 반환한다
    }

    private void validateDuplicateMember(Member member) {   //이미 존재하는지 확인하는 함수임
        memberRepository.findByName(member.getName()).ifPresent(m -> {
                    throw new IllegalArgumentException("이미 존재하는 회원입니다");
                }); //이미 존재하면 예외로ㅊ던져버리기
    }


    /**
     * 전체 회원 조회
     */

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}