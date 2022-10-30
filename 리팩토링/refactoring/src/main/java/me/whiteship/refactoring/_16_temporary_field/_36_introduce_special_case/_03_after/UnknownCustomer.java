package me.whiteship.refactoring._16_temporary_field._36_introduce_special_case._03_after;

/**
 * unknown 일 경우 따로 처리하기 위해 만든 클래스 임
 */
public class UnknownCustomer extends Customer {
    public UnknownCustomer() {
        super("unknown", new BasicBillingPlan(), new NullPaymentHistory());
    }

    /**
     * 여기서는 항상 true를 반환하도록 함
     *
     * @return
     */
    @Override
    public boolean isUnknown() {
        return true;
    }

    @Override
    public String getName() {
        return "occupant";
    }
}
