package what.the.springcore.scan;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import what.the.springcore.AutoAppConfig;
import what.the.springcore.member.MemberService;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoAppConfigTest {

    // ClassPathBeanDefinitionScanner
    // singleton bean
    // Autowiring by

    @Test
    void basicScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
