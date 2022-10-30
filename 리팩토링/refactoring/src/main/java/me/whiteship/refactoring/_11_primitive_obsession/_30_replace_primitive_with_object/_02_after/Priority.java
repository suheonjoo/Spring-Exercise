package me.whiteship.refactoring._11_primitive_obsession._30_replace_primitive_with_object._02_after;

import java.util.List;

/**
 * Priority 라는 타입을 만듬
 */
public class Priority {

    private String value;


    /**
     * type safety 를 위해 만든거임
     */
    private List<String> legalValue = List.of("low", "normal", "high", "rush");

    public Priority(String value) {
        if (legalValue.contains(value)) {
            this.value = value;
        } else {
            throw new IllegalArgumentException("illegal value for priority "+ value);
        }
    }

    /**
     * 어차피 어차피 값도 string 값이 이라 이렇게 그냥 value 리턴해도 되지 않냐 함.
     * -> 이거는 좀 참신하네
     *
     * @return
     */
    @Override
    public String toString() {
        return this.value;
    }

    private int index() {
        return this.value.indexOf(this.value);
    }

    public boolean higherThan(Priority other) {
        return this.index() > other.index();
    }
}
