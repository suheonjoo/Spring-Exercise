package me.whiteship.designpatterns._02_structural_patterns._07_bridge._02_after;

/**
 * Skin 은 champion 의 구체적인 세부사항임
 * 이게 없으면 before 처럼 skin 마다 champion 클래스를 만들어야 함
 */
public interface Skin {
    String getName();
}
