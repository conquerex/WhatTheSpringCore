package what.the.springcore.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // ThreadA : a 사용자 10000원 주문
        int a = statefulService1.order("userA", 10000);
        // ThreadB : b 사용자 20000원 주문
        int b = statefulService1.order("userB", 20000);

        // 사용자A 주문 금액 조회
//        System.out.println("A getPrice() = " + statefulService1.getPrice());
        System.out.println("A getPrice() = " + a    );

//        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}