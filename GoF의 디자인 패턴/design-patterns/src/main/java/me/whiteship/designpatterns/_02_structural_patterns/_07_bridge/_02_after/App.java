package me.whiteship.designpatterns._02_structural_patterns._07_bridge._02_after;

import me.whiteship.designpatterns._02_structural_patterns._07_bridge._01_before.Champion;

/**
 * 여기서 App 은 abstract 임, 그냥 class 이면 champion 인터페이스 내용 모두 상속 받아야 함
 * 추상 클래스를 상속 받으면 오버라이딩의 강제성이 없잖음, 추상클래스가 상속을 받아도 마찬가지고 부모 내용 오버라이딩 강제성이 없음
 */
public abstract class App implements Champion {

    public static void main(String[] args) {
        Champion kda아리 = new 아리(new KDA()); //실제로 new 부분을 인터페이스로 따로 만들어서 변경할 수 있음
        kda아리.skillQ();
        kda아리.skillW();

        Champion poolParty아리 = new 아리(new PoolParty());
        poolParty아리.skillR();
        poolParty아리.skillW();
    }
}
