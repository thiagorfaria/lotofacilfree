package br.com.lotofacilfree;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration
public class LotofacilfreeViewConfiguration {

    @Bean
    public FreeMarkerViewResolver freeMarkerViewResolver() {
        final FreeMarkerViewResolver freeMarkerViewResolver = new FreeMarkerViewResolver();
        freeMarkerViewResolver.setContentType("text/html;charset=UTF-8");
        freeMarkerViewResolver.setCache(false);
        freeMarkerViewResolver.setPrefix("");
        freeMarkerViewResolver.setSuffix(".html");

        return freeMarkerViewResolver;
    }
}
