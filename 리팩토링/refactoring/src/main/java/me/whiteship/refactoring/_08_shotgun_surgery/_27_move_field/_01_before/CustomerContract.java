package me.whiteship.refactoring._08_shotgun_surgery._27_move_field._01_before;

import java.time.LocalDate;

public class CustomerContract {

    private LocalDate startDate;

    public CustomerContract(LocalDate startDate) {
        this.startDate = startDate;
    }
}
