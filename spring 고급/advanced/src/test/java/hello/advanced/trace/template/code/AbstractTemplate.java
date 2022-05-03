package hello.advanced.trace.template.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractTemplate {


    public void execute(){
        long startTime = System.currentTimeMillis();
        //비지니스 로직 실행
        call(); //상속
        //비지니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}",resultTime);
    }

    //변하는 부분을 자식 클래스 만들어서 해결하는 것임
    protected abstract void call();

}











