package what.the.springcore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import what.the.springcore.member.MemberRepository;
import what.the.springcore.member.MemoryMemberRepository;

@Configuration
@ComponentScan(
//        basePackages = "what.the.springcore",
//        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

    // 아래 기입하면 'BeanDefinitionOverrideException'이 발생한다.
    // @Bean(name = "memoryMemberRepository")
    public MemberRepository memberRepository() {
        // 수동이 우선권을 가진다.
        return new MemoryMemberRepository();
    }
}
