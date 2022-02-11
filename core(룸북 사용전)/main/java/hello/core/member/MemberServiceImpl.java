package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    //위에 component를 선언하면 컨테이너에 들어가서 주입 못하지 않냐?
    //이걸 붙여 주면 스프링이 생성자에다가 MemberRepository타입에 맞는 것을 찾아와서 자동으로 주입해줌
    @Autowired //마치 ac.getBean(MemberRepository.class)가 들어가는 것처럼 해줌
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
        //여기서 중요한게 save함구를 하면 들어가는 것은 MemberRepository가 아니라 MemoryMemberRepository객체로 들어감!!중요
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
