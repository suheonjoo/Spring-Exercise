package me.whiteship.designpatterns._03_behavioral_patterns._22_template._01_method._02_after;

public class Multiply extends FileProcessor {

    public Multiply(String path) {
        super(path);
    }

    @Override
    protected int getResult(int result, int number) {
        int result2 = result *number;
        return result2;
    }

}












