package me.whiteship.refactoring._06_mutable_data._23_change_reference_to_value._02_after.notUseRecord;

import java.util.Objects;

public class TelephoneNumber {

    private final String areaCode;

    private final String number;

    /**
     * 객체 생성과 동시에 필드값들 초기화
     * 그 이후로는 변경하지 못하게 함
     * @param areaCode
     * @param number
     */
    public TelephoneNumber(String areaCode, String number) {
        this.areaCode = areaCode;
        this.number = number;
    }

    public String areaCode() {
        return areaCode;
    }

    public String number() {
        return number;
    }


    /**
     * 이걸로 객체를 data 를 기준으로 동일여부를 판단해야함
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TelephoneNumber that = (TelephoneNumber) o;
        return Objects.equals(areaCode, that.areaCode) && Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(areaCode, number);
    }
}
