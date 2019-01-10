package com.hdsx.zxyh;

import com.hdsx.zxyh.config.CrossDomainFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class ZsxzZxyhApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZsxzZxyhApplication.class, args);
    }

    /**
     * 支持跨域
     * @return
     */
    @Bean
    public FilterRegistrationBean addCrossDomainFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new CrossDomainFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(Integer.MAX_VALUE - 1);
        return registrationBean;
    }

}

