package me.whiteship.refactoring._15_speculative_generality._35_remove_dead_code._01_before;

import java.time.LocalDateTime;

/**
 * 뭐 테스트 코드에서만 사용되는거 삭제하든 ~~ ㅋㅋ
 * 여기서 참고로 inlay 에서 usage 설정하는 법을 보여줌
 */
public class Reservation {

    private String title;

    private LocalDateTime from;

    private LocalDateTime to;

    private LocalDateTime alarm;

    public Reservation(String title, LocalDateTime from, LocalDateTime to) {
        this.title = title;
        this.from = from;
        this.to = to;
    }

    public void setAlarmBefore(int minutes) {
        this.alarm = this.from.minusMinutes(minutes);
    }

    public LocalDateTime getAlarm() {
        return alarm;
    }
}
