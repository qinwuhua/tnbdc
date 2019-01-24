package com.hdsx.yjqx;

import com.hdsx.yjqx.config.CrossDomainFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ZsxzYjqxApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZsxzYjqxApplication.class, args);
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

