package rex.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * 打包war包时Application代码
 */
//@SpringBootApplication
//public class DemoApplication extends SpringBootServletInitializer implements WebMvcConfigurer {
//    List<String> excludePathPatternsList = new ArrayList<>();
//
//    public void setExcludePathPatternsList() {
//        excludePathPatternsList.add("/User/loginUser");
//        excludePathPatternsList.add("/User/registerUser");
//        excludePathPatternsList.add("/User/modifyPassword");
//        excludePathPatternsList.add("/User/retrievePassword");
//        excludePathPatternsList.add("/User/getVerificationCode");
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        setExcludePathPatternsList();
//        InterceptorRegistration ir = registry.addInterceptor(new ServiceInterceptor());
//        ir.addPathPatterns("/*");
//        ir.excludePathPatterns(excludePathPatternsList);
//    }

//    public static void main(String[] args) {
//        SpringApplication.run(DemoApplication.class, args);
//    }
//
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(DemoApplication.class);
//    }
//}


/**
 * 调试时配置
 */
@SpringBootApplication
public class DemoApplication implements WebMvcConfigurer {
    private List<String> excludePathPatternsList = new ArrayList<>();

    public void setExcludePathPatternsList() {
        excludePathPatternsList.add("/User/loginUser");
        excludePathPatternsList.add("/User/registerUser");
        excludePathPatternsList.add("/User/modifyPassword");
        excludePathPatternsList.add("/User/retrievePassword");
        excludePathPatternsList.add("/User/getVerificationCode");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        setExcludePathPatternsList();
        InterceptorRegistration ir = registry.addInterceptor(new ServiceInterceptor());
        ir.addPathPatterns("/*");
        ir.excludePathPatterns(excludePathPatternsList);
    }
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
