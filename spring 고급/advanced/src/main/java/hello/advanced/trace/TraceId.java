package hello.advanced.trace;

import java.util.UUID;

public class TraceId {

    private String id;
    private int level;

    public TraceId() {
        this.id = createId();
        this.level = 0;
    }

    private TraceId(String id, int level) {//이거 내부에서만 쓰는 생서자이니깐 private으로 해놓음
        this.id = id;
        this.level = level;
    }


    private String createId() {

        return UUID.randomUUID().toString().substring(0,8);
    }

    public TraceId createNextId(){
        return new TraceId(id, level +1);
    }

    public TraceId createPreviousId() {

        return new TraceId(id, level - 1);//이렇게 생긴 생성자를 따로 만드어놓아서 쓸수 있는 것임
    }

    public boolean isFirstLevel() {
        return level == 0;
    }

    public String getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }

}









