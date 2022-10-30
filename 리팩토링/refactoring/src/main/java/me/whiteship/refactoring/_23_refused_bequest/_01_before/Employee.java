package me.whiteship.refactoring._23_refused_bequest._01_before;

/**
 * 아래 메서드들이 Engineer 에 특화되기 보다는 Salesman 에 특화된거라고 볼 수 있음
 */
public class Employee {

    protected Quota quota;

    protected Quota getQuota() {
        return new Quota();
    }

}
