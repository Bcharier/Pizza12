package fr.eni.pizza12.utils;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import fr.eni.pizza12.bo.ProductEntity;

@Configuration
public class MyConfiguration {

  @Bean(name = "MenuHelper")
  public MenuHelper menuHelper() {

    public final boolean checkIfDisplayCategoryName(List<ProductEntity> list, int currentIndex) {
      boolean result = false;
      if (currentIndex <= 1) {
        result = true;
      } else {
        if (list != null && !list.isEmpty()) {
          if (list.get(currentIndex - 1).getCategory().getCategoryId() != list.get(currentIndex).getCategory()
              .getCategoryId()) {
            result = true;
          }
        }
      }
      return result;
    }
  }

  public interface MenuHelper {
    boolean checkIfDisplayCategoryName(List<ProductEntity> list, int currentIndex);
  }
}
