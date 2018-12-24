package com.hdsx.common;

import com.hdsx.common.config.CrossDomainFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ZsxzCommonApplication {

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
        SpringApplication.run(ZsxzCommonApplication.class, args);
    }

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //单个文件最大
        factory.setMaxFileSize("10240MB"); //KB,MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize("102400MB");
        return factory.createMultipartConfig();
    }
}

