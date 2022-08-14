package me.whiteship.designpatterns._03_behavioral_patterns._17_mediator._02_after;

public class CleaningService {

    private FrontDesk frontDesk = new FrontDesk();

    //여기서 파라미터로 그냥 Guest 객체를 넘기는 것일 아니라 꼭 필요한 정보를 넘기는 것임
    public void getTowers(Integer guestId, int numberOfTowers) {

        String roomNumber = this.frontDesk.getRoomNumberFor(guestId);
        System.out.println("provide " + numberOfTowers + " to " + roomNumber);
    }
}
