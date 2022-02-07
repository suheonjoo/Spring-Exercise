package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);
    //회원 정보 찾을 때, null값을 받아낼 때 optional을 감싸서 받으면 유용하게 쓸수 있다
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    //생성된 인터페이스 안에 optional은 회원을 찾을때 없으면 null을 받게할 수 있는데 요즘에는 optional로 감싸서 받게 됨
    List<Member> findAll();
}
