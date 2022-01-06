package com.youngman.youngman.application.config;

import com.youngman.core.business.configuration.CoreApplicationConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.event.EventListener;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import java.util.List;

@Configuration
@ComponentScan({"com.youngman.youngman"})
@ServletComponentScan
@Import({CoreApplicationConfiguration.class}) // import core configurations
@EnableWebSecurity
public class YoungmanApplicationConfiguration implements WebMvcConfigurer {

    protected final Log logger = LogFactory.getLog(getClass());

    @EventListener(ApplicationReadyEvent.class)
    public void applicationReadyCode() {
        String workingDir = System.getProperty("user.dir");
        logger.info("Current working directory : " + workingDir);
    }

    /** Configure TilesConfigurer. */
    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions(
                "/WEB-INF/tiles/tiles-admin.xml",
                "/WEB-INF/tiles/tiles-crm.xml",
                "/WEB-INF/tiles/tiles-portal.xml");
        tilesConfigurer.setCheckRefresh(true);
        return tilesConfigurer;
    }

    /** Configure ViewResolvers to deliver preferred views. */
    @Bean
    public TilesViewResolver tilesViewResolver() {
        final TilesViewResolver resolver = new TilesViewResolver();
        resolver.setViewClass(TilesView.class);
        resolver.setOrder(0);
        return resolver;
    }

    //TODO
//    @Bean
//    public FilterRegistrationBean<XssFilter> croseSiteFilter(){
//        FilterRegistrationBean<XssFilter> registrationBean
//                = new FilterRegistrationBean<>();
//
//        registrationBean.setFilter(new XssFilter());
//        registrationBean.addUrlPatterns("/shop/**");
//        registrationBean.addUrlPatterns("/api/**");
//        registrationBean.addUrlPatterns("/customer/**");
//
//        return registrationBean;
//    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new MappingJackson2HttpMessageConverter());
    }

    //TODO
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        // Changes the locale when a 'locale' request parameter is sent; e.g. /?locale=de
//        registry.addInterceptor(localeChangeInterceptor());
//
//        registry
//                .addInterceptor(storeFilter())
//                // store web front filter
//                .addPathPatterns("/shop/**")
//                // customer section filter
//                .addPathPatterns("/customer/**");
//
//        registry
//                .addInterceptor(corsFilter())
//                // public services cors filter
//                .addPathPatterns("/services/**")
//                // REST api
//                .addPathPatterns("/api/**");
//
//        // admin panel filter
//        registry.addInterceptor(adminFilter()).addPathPatterns("/admin/**");
//    }

}
