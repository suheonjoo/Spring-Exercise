package me.whiteship.refactoring._18_middle_man._40_replace_subclass_with_delegate._02_after;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class Booking {

    protected Show show;

    protected LocalDateTime time;

    /**
     * 여기 필드 추가됨
     * 이 필드 추가되면서 하위 클래스 였던 PremiumBooking 클래스는 없앰
     */
    protected PremiumDelegate premiumDelegate;

    public Booking(Show show, LocalDateTime time) {
        this.show = show;
        this.time = time;
    }

    /**
     * 여기서 "팩토리 메서드 사용할 것임"
     * 아래와 같이 static 한 팩토리 메서드를 만들때는 얼마든지 이름을 자유롭게 표현할수 있음!
     *
     * @param show
     * @return
     */
    public static Booking createBook(Show show, LocalDateTime time) {
        return new Booking(show, time);
    }

    public static Booking createPremiumBooking(Show show, LocalDateTime time, PremiumExtra extra) {

        /**
         * 여기서 좋은 점이 PremiumBooking  객체를 생성할 필요가 없음
         */
        Booking booking = createBook(show, time);
        /**
         * 이렇게 리털 타입을 자유롭게 반환 가능함! ***** 여기가 제일 중요함
         */
        //PremiumBooking booking = new PremiumBooking(show, time, extra);
        booking.premiumDelegate = new PremiumDelegate(booking, extra);
        return booking;
    }

    public boolean hasTalkback() {
        /**
         * premiumDelegate 이 있으면 "premiumDelegate 의 hasTalkback" 을 반환함
         */
        return (this.premiumDelegate != null) ? this.premiumDelegate.hasTalkback() :
                this.show.hasOwnProperty("talkback") && !this.isPeakDay();
    }

    protected boolean isPeakDay() {
        DayOfWeek dayOfWeek = this.time.getDayOfWeek();
        return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
    }

    /**
     * basePrice 도 hasTalkback 같이 리팩토링한 것임
     * premiumDelegate 가 null 이 아니면, premiumDelegate 의 extendBasePrice 메서드를 호출함
     *
     * @return
     */
    public double basePrice() {
        double result = this.show.getPrice();
        if (this.isPeakDay()) result += Math.round(result * 0.15);
        return (this.premiumDelegate != null) ? this.premiumDelegate.extendBasePrice(result) : result;
    }

    /**
     * 이것도 PremiumBooking 클래스에 있던거를 Booking으로 올려주고 "PremiumDelegate 로 hasDinner 를 만들어서" 위임해주는 것임
     * @return
     */
    public boolean hasDinner() {
        return this.premiumDelegate != null && this.premiumDelegate.hasDinner();
    }
}
