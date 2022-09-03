package me.whiteship.designpatterns._03_behavioral_patterns._19_observer._02_after;

public class Client {

    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();
        User user1 = new User("keesun");
        User user2 = new User("whiteship");

        //채팅 서버에 "오징어 게임"에 대한 주제로 구독자(유저) 등록
        chatServer.register("오징어게임", user1);
        chatServer.register("오징어게임", user2);

        //채팅 서버에 "디자인 패턴"에 대한 주제로 구독자 등록
        chatServer.register("디자인패턴", user1);

        //채팅 서버에서 "오징어개엠"주제로  user1한테 메세지를 보냄
        chatServer.sendMessage(user1, "오징어게임", "아.. 이름이 기억났어.. 일남이야.. 오일남");
        chatServer.sendMessage(user2, "디자인패턴", "옵저버 패턴으로 만든 채팅");

        chatServer.unregister("디자인패턴", user2);

        chatServer.sendMessage(user2, "디자인패턴", "옵저버 패턴 장, 단점 보는 중");
    }
}


