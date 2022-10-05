package me.whiteship.designpatterns._01_creational_patterns._04_builder._02_after;

import me.whiteship.designpatterns._01_creational_patterns._04_builder._01_before.TourPlan;

public class App {

    public static void main(String[] args) {
        TourDirector director = new TourDirector(new DefaultTourBuilder());
        TourPlan tourPlan = director.cancunTrip();
        TourPlan tourPlan1 = director.longBeachTrip();

        System.out.println("tourPlan = " + tourPlan.toString());
        System.out.println("tourPlan1 = " + tourPlan1.toString());
        //가존꺼를 자기고 가면서 tourPlan1은 시작 날짜만 수정함, 또한 longBeachTrip 에서 일정 추가해도 tourPlan 에서도 추가됨
    }
}
