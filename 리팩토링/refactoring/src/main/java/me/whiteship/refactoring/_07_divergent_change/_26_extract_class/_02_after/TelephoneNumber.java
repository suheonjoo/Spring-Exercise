package me.whiteship.refactoring._07_divergent_change._26_extract_class._02_after;

public class TelephoneNumber {
    /**
     * 클래스 이름을 추출후 이름이 문맥에 맞는지 봐야함
     */
    String areaCode;
    String number;

    public TelephoneNumber() {
    }

    public String getAreaCode() {
        return areaCode;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "TelephoneNumber{" +
                "areaCode='" + areaCode + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}