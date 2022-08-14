package me.whiteship.designpatterns._03_behavioral_patterns._18_memento._02_after;

public final class GameSave {

    private final int blueTeamScore;    // final 키워드로 값이 변경되는 것을 막을 것임

    private final int redTeamScore;

    public GameSave(int blueTeamScore, int redTeamScore) {//값은 생성자 통해서만 만들수 있게 할것임
        this.blueTeamScore = blueTeamScore;
        this.redTeamScore = redTeamScore;
    }

    public int getBlueTeamScore() {
        return blueTeamScore;
    }

    public int getRedTeamScore() {
        return redTeamScore;
    }
}
