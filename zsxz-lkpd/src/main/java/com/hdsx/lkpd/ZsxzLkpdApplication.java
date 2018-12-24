package com.hdsx.lkpd;

import com.hdsx.lkpd.config.CrossDomainFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ZsxzLkpdApplication {

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

    public static void main(String[] args) {
        SpringApplication.run(ZsxzLkpdApplication.class, args);
    }

}

