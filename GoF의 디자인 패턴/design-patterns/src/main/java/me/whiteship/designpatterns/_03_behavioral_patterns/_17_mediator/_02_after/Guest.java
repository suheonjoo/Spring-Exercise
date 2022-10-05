package me.whiteship.designpatterns._03_behavioral_patterns._17_mediator._02_after;

import java.time.LocalDateTime;

/**
 * Guest 는 frontDesk 를 통해서 원하는 요구사항 요청함
 */
public class Guest {

    //FrontDesk 외에는 의존성을 떨어뜨리기 위해 객체의 id로 통신하고
    //FrontDesk 는 객체로 데이터를 전달받아 통신함
    private Integer id;

    private FrontDesk frontDesk = new FrontDesk();

    public void getTowers(int numberOfTowers) {
        this.frontDesk.getTowers(this, numberOfTowers);
    }

    private void dinner(LocalDateTime dateTime) {
        this.frontDesk.dinner(this, dateTime);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
