package me.whiteship.refactoring._18_middle_man._40_replace_subclass_with_delegate._01_before;

import java.time.LocalDateTime;

/**
 * 지금 위임이 아니라 상속 구조를 사용해서 유연하지가 않음 static 함 정적임
 * 만얄 그냥 booking 에서 premiumbooking 을 변환을 원하는 기능을 만들려면 많이 고쳐야 함
 */
public class PremiumBooking extends Booking {

    private PremiumExtra extra;

    public PremiumBooking(Show show, LocalDateTime time, PremiumExtra extra) {
        super(show, time);
        this.extra = extra;
    }

    @Override
    public boolean hasTalkback() {
        return this.show.hasOwnProperty("talkback");
    }

    @Override
    public double basePrice() {
        return Math.round(super.basePrice() + this.extra.getPremiumFee());
    }

    /**
     * PremiumBooking 만 dinner 를 할수 있는 기회가 있음, 근데 peekday 에는 안되고
     * @return
     */
    public boolean hasDinner() {
        return this.extra.hasOwnProperty("dinner") && !this.isPeakDay();
    }
}
