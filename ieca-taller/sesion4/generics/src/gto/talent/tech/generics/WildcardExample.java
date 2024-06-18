package gto.talent.tech.generics;

import java.util.List;

public class WildcardExample {
    public static void printList(List<?> list) {
        for (Object s : list) {
            System.out.println(s);
        }
    }
}
