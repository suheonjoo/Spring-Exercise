package me.whiteship.refactoring._06_mutable_data._19_separate_query_from_modifier._02_after;

import java.util.List;

public class Criminal {

    /**
     * 테스트 코드에서 보면 어디서 알람 메세지 출력이 되었는건지 알기 어려움
     * 질의와 변경이 한번에 함쳐져서 발생하는 문제임
     * @param people
     * @return
     */
    public void alertForMiscreant(List<Person> people) {

        /**
         * 이렇게 알고리듬을 고칠수 있음!
         */
        if (!findMiscreant(people).isBlank()) {
            setOffAlarms();
        }

//        for (Person p : people) {
//            if (p.getName().equals("Don")) {
//                setOffAlarms();
//            }
//
//            if (p.getName().equals("John")) {
//                setOffAlarms();
//            }
//        }
    }

    /**
     * 조회하는 메서드
     * @param people
     * @return
     */
    public String findMiscreant(List<Person> people) {
        for (Person p : people) {
            if (p.getName().equals("Don")) {
                return "Don";
            }

            if (p.getName().equals("John")) {
                return "John";
            }
        }

        return "";
    }

    private void setOffAlarms() {
        System.out.println("set off alarm");
    }
}
