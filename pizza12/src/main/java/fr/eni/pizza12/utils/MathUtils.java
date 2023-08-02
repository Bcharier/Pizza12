package fr.eni.pizza12.utils;

public class MathUtils {

  public Boolean isEven(int i) {
    return (i % 2) == 0;
  }

  public Boolean isOdd(int i) {
    return !isEven(i);
  }
}
