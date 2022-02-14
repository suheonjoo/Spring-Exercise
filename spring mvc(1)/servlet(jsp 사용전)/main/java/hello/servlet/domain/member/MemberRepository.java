package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
 */
public class MemberRepository {//command shift t로 테스트 코드 바로 만들어줌

    private static Map<Long, Member > store = new HashMap<>();
    private static long sequence = 0L;

    //우리 싱글톤 만들 것임
    private static final MemberRepository instance = new MemberRepository();

    //우리 싱글톤 만들때는 일단 private으로 생성자를 일단 막아야 함

    public static MemberRepository getInstance(){
        return instance;
    }// 아래 와 같이 접근 막아줘서 이 함수로 접근해줘야 한다

    private MemberRepository() {
    }

    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    public Member findById(Long id){
        return store.get(id);
    }

    public List<Member> findAll(){
        return new ArrayList<>(store.values()); //store에 있는 모든 값들을 array에 담아 넣어줘
        //new arraylist를 밖에서 값을 조작해도 store에 있는 value를 건들고 싶이 않아서
        //즉 store 자체를 보호하고 싶어서 그런거임
    }

    //store를 다 날려버림
    public void clearStore(){
        store.clear();
    }

}
