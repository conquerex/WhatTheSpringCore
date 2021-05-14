package what.the.springcore.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import what.the.springcore.common.MyLogger;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {
    private final LogDemoService logDemoService;
    private final MyLogger myLogger;
//    private final ObjectProvider<MyLogger> myLoggerObjectProvider;

    // request가 없는데 컨테이너가 뜬다면?
    // ScopeNotActiveException: Error creating bean with name 'myLogger'
    // request scope 빈은 생성되기 전 (실제 고객 요청이 있어야 생성)
    // 컨테이너 생성 이후, 그리고 고객 요청 이후로 생성을 지연시켜야 함
    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {
        System.out.println("myLogger = " + myLogger.getClass());

//        MyLogger myLogger = myLoggerObjectProvider.getObject();
        String requestURL = request.getRequestURL().toString();
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        logDemoService.logic("test_testId");
        return "OK";
    }
}
