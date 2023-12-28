package com.qifa.pileportal.config;


import com.qifa.pileportal.interceptor.HttpInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        /**
         * addMapping(): Enable cross-origin request handling for the specified path pattern.
         * allowedOrigins(): The list of allowed origins that be specific origins, e.g.
         * allowedMethods(): Set the HTTP methods to allow.
         * maxAge(): Configure how long in seconds the response from a pre-flight request can be cached by clients.
         */
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8088", "null")
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .maxAge(3600)
                .allowCredentials(true);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
                .addInterceptor(appInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/**/login","/**/register","/**/alipay/**")
                .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");
        WebMvcConfigurer.super.addInterceptors(registry);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Bean
    public HandlerInterceptor appInterceptor(){
        return new HttpInterceptor();
    }
}

