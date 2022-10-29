package me.whiteship.refactoring._08_shotgun_surgery._28_inline_function._01_before;

public class Rating {

    public int rating(Driver driver) {
        return moreThanFiveLateDeliveries(driver) ? 2 : 1;
    }

    /**
     * 함수 이름하고 구현내용을 보면 굳이 이거 메서드를 감쌀필요는 없었음 구현 내용만 봐도 이해가 감
     * @param driver
     * @return
     */
    private boolean moreThanFiveLateDeliveries(Driver driver) {
        return driver.getNumberOfLateDeliveries() > 5;
    }
}
