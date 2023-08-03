package fr.eni.pizza12.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fr.eni.pizza12.controller.CartHelper;

import fr.eni.pizza12.controller.MenuHelper;
import fr.eni.pizza12.controller.OrderListHelper;

@Configuration
public class BeanDictionnary {

  @Bean
  public MenuHelper menuHelper() {
    return new MenuHelper();
  }

  @Bean
  public MathUtils mathHelper() {
    return new MathUtils();
  }

  @Bean
  public CartHelper cartHelper() {
    return new CartHelper();
  }

  @Bean
  public OrderListHelper orderListHelper() {
    return new OrderListHelper();
  }

}
