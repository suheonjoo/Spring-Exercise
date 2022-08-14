package me.whiteship.designpatterns._01_creational_patterns._02_factory_method._02_after;

public interface ShipFactory {

    default Ship orderShip(String name, String email) {
        validate(name, email);
        prepareFor(name);
        Ship ship = createShip();
        sendEmailTo(email, ship);
        return ship;
    }

    void sendEmailTo(String email, Ship ship);//이것도 접근 지정자를 default로 해서 하위 클래스가 무조건 정의하도록 함

    Ship createShip();// 접근 지정자를 default로 두어서 하위 클래스가 무조건 정의를 해야하는 방식으로 선언함

    private void validate(String name, String email) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("배 이름을 지어주세요.");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("연락처를 남겨주세요.");
        }
    }

    private void prepareFor(String name) {
        System.out.println(name + " 만들 준비 중");
    }

}
