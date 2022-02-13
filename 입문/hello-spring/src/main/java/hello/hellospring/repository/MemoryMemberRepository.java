package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository {

    //회원관리를 해쉬맵틀로 만들어서 저장해줌
    private static Map<Long, Member> store = new HashMap<>();
    //공유되는 부분에 회원정보 동시성 문제로 concurrenthashMap해쉬같은 것을 써야 하는데 예제에서는 쓰지 않음
    //자세히 말하면 동시에 회원정보를 읽을 수 있지만 동시에 회원정보를 넣지 못하게 concurrenthashmap 씀
    private static long sequence=0L;
    //seqeunce는 0,1,2 등 키 값을 생성해줌


    //멤버 기록 저장

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        //위에 정의한 해쉬맵으로 들어온 멤버를 저장해줌
        return member;
    }


    //optional로 감싸진 멤버 클래스에서 사용자 아이디와 이름 찾기
    @Override
    public Optional<Member> findById(Long id) {

        return Optional.ofNullable(store.get(id));
        //store에서 회원 정보를 가져온다
        //찾는 함수는 optional 함수로 감싸져 있게 해서, 이를 또 회원정보 없을 때 사용함
    }
    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
        //findbyname에서는 filter를 써서 같은 값인지 저장된 map에서 걸러줌
    }


    @Override
    public List<Member> findAll() {

        return new ArrayList<>(store.values());
    }



    //이거는 테스트 코드를 위해 작성된것
    public void clearStore() {

        store.clear();
    }


}
