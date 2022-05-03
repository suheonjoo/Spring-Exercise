package hello.advanced.trace.template;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;

public abstract class AbstractTemplate<T> {

    private final LogTrace trace;
    //생성자 주입
    public AbstractTemplate(LogTrace trace) {
        this.trace = trace;
    }

    //타입을 다양하게 지정할거라 제네릭을 사용함
    public T execute(String message) {
        TraceStatus status = null;
        try {
            status = trace.begin(message);

            //로직 호출
            T result = call();

            trace.end(status);
            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e; }


    }

    protected abstract T call();
}

















