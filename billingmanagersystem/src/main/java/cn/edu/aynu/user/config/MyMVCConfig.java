package cn.edu.aynu.user.config;

import cn.edu.aynu.user.component.MyLocaleResolver;
import cn.edu.aynu.user.interceptor.LoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

/**
 * company: www.abc.com
 * Author: KevinLee
 * Create Data: 2019/3/14
 */
@Configuration
public class MyMVCConfig {
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {

            @Override
            public void configurePathMatch(PathMatchConfigurer pathMatchConfigurer) {

            }

            @Override
            public void configureContentNegotiation(ContentNegotiationConfigurer contentNegotiationConfigurer) {

            }

            @Override
            public void configureAsyncSupport(AsyncSupportConfigurer asyncSupportConfigurer) {

            }

            @Override
            public void configureDefaultServletHandling(DefaultServletHandlerConfigurer defaultServletHandlerConfigurer) {

            }

            @Override
            public void addFormatters(FormatterRegistry formatterRegistry) {

            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerInterceptor())
                        //要拦截的请求
                        .addPathPatterns("/**")
                        //排除的请求
                        .excludePathPatterns("/","/index.html","/login");
            }

            @Override
            public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {

            }

            @Override
            public void addCorsMappings(CorsRegistry corsRegistry) {

            }

            @Override
            public void addViewControllers(ViewControllerRegistry viewControllerRegistry) {
                viewControllerRegistry.addViewController("/").setViewName("main/login");
                viewControllerRegistry.addViewController("/index.html").setViewName("main/login");
            }

            @Override
            public void configureViewResolvers(ViewResolverRegistry viewResolverRegistry) {

            }

            @Override
            public void addArgumentResolvers(List<HandlerMethodArgumentResolver> list) {

            }

            @Override
            public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> list) {

            }

            @Override
            public void configureMessageConverters(List<HttpMessageConverter<?>> list) {

            }

            @Override
            public void extendMessageConverters(List<HttpMessageConverter<?>> list) {

            }

            @Override
            public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {

            }

            @Override
            public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {

            }

            @Override
            public Validator getValidator() {
                return null;
            }

            @Override
            public MessageCodesResolver getMessageCodesResolver() {
                return null;
            }
        };
    }
    //自己的区域解析器
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
