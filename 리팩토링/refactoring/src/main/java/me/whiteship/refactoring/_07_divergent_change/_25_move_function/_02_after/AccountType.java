package me.whiteship.refactoring._07_divergent_change._25_move_function._02_after;

public class AccountType {
    private boolean premium;

    public AccountType(boolean premium) {
        this.premium = premium;
    }

    public boolean isPremium() {
        return this.premium;
    }

    /**
     * daysOverdrawn 은 Account 에 속한 것이고
     * isPremium 은 AccountType 에 속한 것이여서 속한 정도는 반반임
     * 지금 보면 this. 으로 해당 클래스(AccountType)에 상속된 것이 많아서 이 매서드를 AccountType 으로 옮길 것임
     *
     * 또 여기서 파라미터워 원래 Account 를 넘겨 줬는데 그러면 또 어떻게 보면 Account에 의존도를 가진거니깐 필요한 데이터 daysOverdrawn 으로 파라미터를 넘져주려고 함
     * @return
     * @param account
     */
    public double overdraftCharge(int daysOverdrawn) {
        if (this.isPremium()) {
            final int baseCharge = 10;
            if (daysOverdrawn <= 7) {
                return baseCharge;
            } else {
                return baseCharge + (daysOverdrawn - 7) * 0.85;
            }
        } else {
            return daysOverdrawn * 1.75;
        }
    }
}
