package hello.hellospring.domain;


//도메인: 비즈니스 도메인 객체,
// (객체형태를 만듦: 예를 들어 사람이라는 객체 안에 아이디, 이름이라는 내부 구성을 만듦
// 물론 getter and setter로 만듦)
public class Member {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
