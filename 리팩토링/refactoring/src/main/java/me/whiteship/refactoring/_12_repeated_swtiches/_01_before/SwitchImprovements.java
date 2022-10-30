package me.whiteship.refactoring._12_repeated_swtiches._01_before;

public class SwitchImprovements {

    public int vacationHours(String type) {

        /**
         * switch statement 은 아래임, switch expression -> 자바 17 부터 지원함
         */
        int result;
        switch (type) {
            case "full-time": result = 120;
            case "part-time": result = 80;
            case "temporal": result = 32;
            default: result = 0;
        }
        return result;
    }
}
