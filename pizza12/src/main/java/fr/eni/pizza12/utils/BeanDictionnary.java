package fr.eni.pizza12.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import fr.eni.pizza12.controller.MenuHelper;

@Configuration
public class BeanDictionnary {

  @Bean
  public MenuHelper menuHelper() {
    return new MenuHelper();

  }

}
