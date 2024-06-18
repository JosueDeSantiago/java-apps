package gto.talent.tech.generics;

public class Utility {
  public static <T> T printParam(T param) {
    System.out.println("this is param: " + param);
    return param;
  }
}