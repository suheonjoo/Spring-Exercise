package me.whiteship.refactoring._07_divergent_change._25_move_function._01_before;

public class Account {

    private int daysOverdrawn;

    private AccountType type;

    public Account(int daysOverdrawn, AccountType type) {
        this.daysOverdrawn = daysOverdrawn;
        this.type = type;
    }

    public double getBankCharge() {
        double result = 4.5;
        if (this.daysOverdrawn() > 0) {
            result += this.overdraftCharge();
        }
        return result;
    }

    private int daysOverdrawn() {
        return this.daysOverdrawn;
    }

    /**
     * daysOverdrawn 은 Account 에 속한 것이고
     * isPremium 은 AccountType 에 속한 것이여서 속한 정도는 반반임
     * 지금 보면 this. 으로 해당 클래스(AccountType)에 상속된 것이 많아서 이 매서드를 AccountType 으로 옮길 것임
     * @return
     */
    private double overdraftCharge() {
        if (this.type.isPremium()) {
            final int baseCharge = 10;
            if (this.daysOverdrawn <= 7) {
                return baseCharge;
            } else {
                return baseCharge + (this.daysOverdrawn - 7) * 0.85;
            }
        } else {
            return this.daysOverdrawn * 1.75;
        }
    }
}
