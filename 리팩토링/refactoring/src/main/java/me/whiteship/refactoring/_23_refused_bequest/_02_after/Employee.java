package me.whiteship.refactoring._23_refused_bequest._02_after;

public class Employee {

    protected Quota quota;

    protected Quota getQuota() {
        return new Quota();
    }

}
