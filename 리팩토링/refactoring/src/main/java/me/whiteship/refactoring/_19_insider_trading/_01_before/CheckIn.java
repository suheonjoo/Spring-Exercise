package me.whiteship.refactoring._19_insider_trading._01_before;

import java.time.LocalDate;

public class CheckIn {

    /**
     * 이 메서드를 보면 CheckIn 이 아니라 구현 내부를 보면, Ticket 클래스에 들어가는 것이 더 낫다고 볼수 있음
     * @param ticket
     * @return
     */
    public boolean isFastPass(Ticket ticket) {
        LocalDate earlyBirdDate = LocalDate.of(2022, 1, 1);
        return ticket.isPrime() && ticket.getPurchasedDate().isBefore(earlyBirdDate);
    }
}
