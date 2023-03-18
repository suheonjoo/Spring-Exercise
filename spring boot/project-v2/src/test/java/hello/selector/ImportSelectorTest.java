package hello.selector;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.*;

public class ImportSelectorTest {

	// 정적인 방법
	@Test
	void staticConfig() {
		AnnotationConfigApplicationContext appContext =
			new AnnotationConfigApplicationContext(StaticConfig.class);
		HelloBean bean = appContext.getBean(HelloBean.class);
		assertThat(bean).isNotNull();
	}

	//동적인 방법
	@Test
	void selectorConfig() {
		AnnotationConfigApplicationContext appContext =
			new AnnotationConfigApplicationContext(SelectorConfig.class);
		HelloBean bean = appContext.getBean(HelloBean.class);

		assertThat(bean).isNotNull();
	}

	@Configuration
	@Import(HelloConfig.class)
	public static class StaticConfig {
	}

	@Configuration
	@Import(HelloImportSelector.class)
	public static class SelectorConfig {
	}
}