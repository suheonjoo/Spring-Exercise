package me.whiteship.designpatterns._03_behavioral_patterns._19_observer._02_after;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatServer {

    private Map<String, List<Subscriber>> subscribers = new HashMap<>();

    public void register(String subject, Subscriber subscriber) {
        if (this.subscribers.containsKey(subject)) {
            this.subscribers.get(subject).add(subscriber);
        } else {
            List<Subscriber> list = new ArrayList<>();
            list.add(subscriber);
            this.subscribers.put(subject, list);// 위에 2줄을 줄일려고 List.of를 사용하면 안됨 그러면 리스트가 변경 불가능해짐 add 사용 불가!, immutable
        }
    }

    public void unregister(String subject, Subscriber subscriber) {
        if (this.subscribers.containsKey(subject)) {
            this.subscribers.get(subject).remove(subscriber);
        }
    }

    public void sendMessage(User user, String subject, String message) {
        //루프를 돌면서 각 Observer 를 Update
        if (this.subscribers.containsKey(subject)) {
            String userMessage = user.getName() + ": " + message;
            this.subscribers.get(subject).forEach(s -> s.handleMessage(userMessage));
        }
    }

}





















