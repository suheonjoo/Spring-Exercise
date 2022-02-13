package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.*;

public class SingletonWithPrototypeTest1 {

    @Test
    void prototypeFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        prototypeBean1.addCount();
        assertThat(prototypeBean1.getCount()).isEqualTo(1);

        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
        prototypeBean2.addCount();
        assertThat(prototypeBean2.getCount()).isEqualTo(1);

    }

    @Test
    void singletonClientUsePrototype(){
        AnnotationConfigApplicationContext ac =
                new AnnotationConfigApplicationContext(ClientBean.class,PrototypeBean.class);

        ClientBean clientBean1  = ac.getBean(ClientBean.class);
        int count1 = clientBean1.logic();
        assertThat(count1).isEqualTo(1);

        ClientBean clientBean2  = ac.getBean(ClientBean.class);
        int count2 = clientBean2.logic();
        assertThat(count2).isEqualTo(1);


    }

    @Scope("singleton")//안해줘도 되지만 확실히 해주기 위해서//이거 이름 조심하삼 이름 때문에 오류났음
    static class ClientBean{
        /*private final PrototypeBean prototypeBean;  //생성시점에 주임
        @Autowired//이것도 생량가능 생성자 하나니깐
        public ClientBean(PrototypeBean prototypeBean) {
            this.prototypeBean = prototypeBean;
        }*/

        @Autowired
        private ObjectProvider<PrototypeBean> prototypeBeanProvider;
        //ObjectProvider을 ObjectFactory로 바꿀수 있음
        //javax.inject gradle에 추가하고 ObjectProvider 대신 Provider을 사용할수 있고 밑에 getObject를 Get만으로 사용가능

        public int logic(){
            PrototypeBean prototypeBean = prototypeBeanProvider.getObject();
            //getObject()호출하면 그때서야 스프링 컨테이너에서 prototypeBean을 찾아서 반환해주는 것임//찾아주는 기능만 제공해줌
            prototypeBean.addCount();

            //아래 두줄 command option n으로 inline으로 합칠수 있음
            int count = prototypeBean.getCount();
            return count;
        }

    }

    @Scope("prototype")
    static class PrototypeBean {
        private int count =0;

        public void addCount(){
            count ++;
        }
        public int getCount(){
            return count;
        }
    }

    @PostConstruct
    public void init(){
        System.out.println("PrototypeBean.init " + this);
    }

    @PreDestroy
    public void destroy(){
        System.out.println("PrototypeBean.destroy");
    }

}
