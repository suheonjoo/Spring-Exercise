package me.whiteship.refactoring._06_mutable_data._18_split_variable._02_after;

public class Rectangle {

    private double perimeter;
    private double area;

    public void updateGeometry(double height, double width) {
        /**
         * 여기서 temp 임시 변수를 수정함 perimeter, area 로
         * 여기서는 final 사용하는게 좋음~~~ 한역할을 변경없이 한번만 할당 받았으니깐
         */
        final double perimeter = 2 * (height + width);
        System.out.println("Perimeter: " + perimeter);
        this.perimeter = perimeter;

        final double area = height * width;
        System.out.println("Area: " + area);
        this.area = area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getArea() {
        return area;
    }
}
