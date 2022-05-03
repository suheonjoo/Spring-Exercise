package hello.advanced.trace.threadlocal;


import hello.advanced.trace.threadlocal.code.FieldService;
import hello.advanced.trace.threadlocal.code.TreadLocalService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j//지금 테스트폴더에 FieldService클래스 만들고 테스트 하는 것임
public class ThreadLocalServiceTest {

    private TreadLocalService service = new TreadLocalService();
    
    @Test
    void field(){
        log.info("main start"); //쓰레드 실행로직은 Runnable임


        Runnable userA = () -> {
            service.logic("userA");
        };

        Runnable userB = () -> {
            service.logic("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");

        Thread threadB = new Thread(userB);
        threadA.setName("thread-B");

        threadA.start();//이걸 실행하면 위에 이쓴 Runnable userA를 실행하는 것임
        //sleep(2000);    //2초를 쉬기 대문에 동시성 문제가 발생안하는 코드임
        sleep(100); //동시성 문제 발생 -> 2번째가 첫번째 안끝났느데 들어가는 것임
        threadB.start();

        sleep(3000);
        log.info("main exit");



    }

    private void sleep(int millis) {

        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}









