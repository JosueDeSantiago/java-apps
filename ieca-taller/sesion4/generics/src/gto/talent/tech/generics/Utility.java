package gto.talent.tech.generics;

public class Utility {
    public static <T> void printArray(T[] array) {
        for(T element : array){
            System.out.println(array);
       }
    }
}
