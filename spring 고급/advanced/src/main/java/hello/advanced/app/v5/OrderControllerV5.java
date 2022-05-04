package hello.advanced.app.v5;


import hello.advanced.trace.callback.TraceCallback;
import hello.advanced.trace.callback.TraceTemplate;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/////////////
@RestController
public class OrderControllerV5 {//템플릿 콜백으로 바꾼것

    private final OrderServiceV5 orderService;
    private final TraceTemplate template;

    //생성자 하나라 @Autowired 안해줘도 됨
    public OrderControllerV5(OrderServiceV5 orderService, LogTrace trace) {
        this.orderService = orderService;
        this.template = new TraceTemplate(trace);
    }

    @GetMapping("/v5/request")
    public String request(String itemId) {
        return template.execute("OrderController.request()", new
                TraceCallback<>() {
                    @Override
                    public String call() {
                        orderService.orderItem(itemId);
                        return "ok";
                    }
                });
    }
}














