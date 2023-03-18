package memory;

import lombok.extern.slf4j.Slf4j;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

@Slf4j
public class MemoryCondition implements Condition {
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		// 자바 시스템 속성이 memory=on 이라고 되어 있을 때만 메모리 기능이 동작
		String memory = context.getEnvironment().getProperty("memory");
		log.info("memory={}", memory);
		return "on".equals(memory);
	}
}