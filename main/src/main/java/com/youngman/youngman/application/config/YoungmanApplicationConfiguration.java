package com.youngman.youngman.application.config;

import com.youngman.model.business.configuration.CoreApplicationConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.event.EventListener;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@ComponentScan({"com.youngman.youngman"})
@ServletComponentScan
@Import({CoreApplicationConfiguration.class}) // import model configurations
@EnableWebSecurity
public class YoungmanApplicationConfiguration implements WebMvcConfigurer {

    protected final Log logger = LogFactory.getLog(getClass());

    @EventListener(ApplicationReadyEvent.class)
    public void applicationReadyCode() {
        String workingDir = System.getProperty("user.dir");
        logger.info("Current working directory : " + workingDir);
    }

   /* *//** Configure TilesConfigurer. *//*
    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions(
               // "/WEB-INF/tiles/tiles-admin.xml",
               // "/WEB-INF/tiles/tiles-crm.xml",
               // "/WEB-INF/tiles/tiles-portal.xml"
                );
        tilesConfigurer.setCheckRefresh(true);
        return tilesConfigurer;
    }*/

  /*  *//** Configure ViewResolvers to deliver preferred views. *//*
    @Bean
    public TilesViewResolver tilesViewResolver() {
        final TilesViewResolver resolver = new TilesViewResolver();
        resolver.setViewClass(TilesView.class);
        resolver.setOrder(0);
        return resolver;
    }
*/

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new MappingJackson2HttpMessageConverter());
    }


}
