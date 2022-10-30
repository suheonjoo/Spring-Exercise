package me.whiteship.refactoring._14_lazy_elements._34_collapse_hierarchy._02_after;

import java.time.LocalDateTime;
import java.util.List;

public class Reservation {

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

    private List<String> members;

    private String owner;

    private boolean paid;

    /**
     * CourtReservation 에 있는 필드를 여기 Reservation 으로 옮기고 CourtReservation 를 삭제 함
     */
    private String courtNumber;
}
