package hello.core.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);

}//인터페이스를 만들고 구현체 만들어야지 당연히~
