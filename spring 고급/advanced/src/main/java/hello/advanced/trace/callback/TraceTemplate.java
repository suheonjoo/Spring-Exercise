package hello.advanced.trace.callback;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;

public class TraceTemplate {

    private final LogTrace trace;

    public TraceTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public <T> T execute(String message, TraceCallback<T> callback){
        TraceStatus status = null;
        try {
            status = trace.begin(message); //로직 호출
            T result = callback.call();//-자식에서 호출한게 아니라 callback에서 넘어온거 호출
            trace.end(status);
            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e; }
    }

}
