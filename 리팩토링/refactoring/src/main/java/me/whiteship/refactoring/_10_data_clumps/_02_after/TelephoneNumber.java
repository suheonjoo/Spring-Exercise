package me.whiteship.refactoring._10_data_clumps._02_after;

public class TelephoneNumber {

    private String areaCode;

    private String number;

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public TelephoneNumber(String areaCode, String number) {
        this.areaCode = areaCode;
        this.number = number;
    }

    @Override
    public String toString() {
        return "TelephoneNumber{" +
                "personalAreaCode='" + areaCode + '\'' +
                ", personalNumber='" + number + '\'' +
                '}';
    }
}
