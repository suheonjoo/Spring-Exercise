package hello.core.member;

//MemberServiceImpl라고 이름을 짓는 것은 관행같은 것인 인터페이명 뒤에 impl이라고 많이 씀
public class MemberServiceImpl implements MemberService{

    //여기서 구현 객체를 만들어줌 override된 함수에 객체를 넣어주기 위해
    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    //참고하는 자동완성 단축키인데 command shift enter로 마침표까지 자동 완성 해줌
    //그런데 이거는 로미오 역할이 디카프리오 선택하는 꼴이라 않좋음

    //생성자를 통해서 MemberRepository에 무엇이 들어갈지 구현임. 이제야 추상화에마 의존한 것임
    private final MemberRepository memberRepository;

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
}
