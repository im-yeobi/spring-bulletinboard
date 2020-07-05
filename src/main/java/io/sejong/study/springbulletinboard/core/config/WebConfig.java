package io.sejong.study.springbulletinboard.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  /** freemarker path definition */
  @Bean
  public FreeMarkerConfigurer freemarkerConfig() {
    FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
    freeMarkerConfigurer.setTemplateLoaderPath("classpath:/templates/");
    return freeMarkerConfigurer;
  }

  /** freemarker web configuration */
  @Bean
  public FreeMarkerViewResolver freemarkerViewResolver() {
    FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
    resolver.setCache(true);
    resolver.setSuffix(".ftl");
    resolver.setContentType("text/html;charset=UTF-8");
    return resolver;
  }

  /* 브라우저에서 한글 인코딩 깨지는 문제 해결 두 번째 방법
  @Bean
  CharacterEncodingFilter characterEncodingFilter() {
      CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
      characterEncodingFilter.setEncoding("UTF-8");
      characterEncodingFilter.setForceEncoding(true);

      return characterEncodingFilter;
  }
  */

  /** static resource configuration */
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/**")
            .addResourceLocations("classpath:/static/");
  }
}
