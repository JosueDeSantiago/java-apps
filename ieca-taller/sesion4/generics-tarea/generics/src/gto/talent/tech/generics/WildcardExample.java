package gto.talent.tech.generics;

import java.util.Set;

public class WildcardExample {
    public static void printElements(Set<?> set) {
        for (Object element : set) {
            System.out.println("Element: " + element);
        }
    }
}