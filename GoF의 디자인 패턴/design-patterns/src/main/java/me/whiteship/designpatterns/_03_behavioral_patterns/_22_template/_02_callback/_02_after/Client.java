package me.whiteship.designpatterns._03_behavioral_patterns._22_template._02_callback._02_after;

public class Client {

    public static void main(String[] args) {
        FileProcessor fileProcessor = new Multiply("number.txt");

        /**
         * 템플릿 콜백 패턴
         *
         * 여기 주의해할게 FileProcessor 의 구현체로 Multiply 로 했는데 인자로 Plus 구현체같이 행동하도록 오버라이드 함
         */
        int result = fileProcessor.process(new Operator() {
            @Override
            public int getResult(int sum, int number) {
                return sum += number;
            }
        });
        /**
         * 이거는 위에 인자를 람다로 받은거임
         */
        //int result = fileProcessor.process((sum, number) -> sum += number);  //위에와 같은거임


        System.out.println(result);
    }
}





























