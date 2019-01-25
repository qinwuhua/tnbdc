package com.hdsx.tjbb;

import com.hdsx.tjbb.config.CrossDomainFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class ZsxzTjbbApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZsxzTjbbApplication.class, args);
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

