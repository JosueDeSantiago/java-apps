package gto.talent.tech;

import gto.talent.tech.generics.BoundedBox;
import gto.talent.tech.generics.Box;
import gto.talent.tech.generics.Utility;
import gto.talent.tech.generics.WildcardExample;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Box<String> box = new Box<>();
        box.setItem("cafe");
        System.out.println("box: " + box);

        Box<Integer> box2 = new Box<>();
        box2.setItem(123);
        System.out.println("box2: " + box2);

        BoundedBox<String> boundedBox = new BoundedBox<>();
        boundedBox.setItem("CharSequence type");
        //boundedBox.setItem(19.28); error!
        System.out.println("BoundedBox: " + boundedBox.getItem());

        String param = Utility.printParam("Param here!");

        Set<String> stringSet = new HashSet<>();
        stringSet.add("This...");
        WildcardExample.printElements(stringSet);

        Set<Double> doubleSet = new HashSet<>();
        doubleSet.add(1.0);
        WildcardExample.printElements(doubleSet);

        // Ejemplo de uso con diferentes tipos de sets
        Set<String> stringSet1 = Set.of("Hello", "World", "Java");
        Set<Integer> integerSet1 = Set.of(1, 2, 3, 4, 5);
        Set<Double> doubleSet1 = Set.of(1.1, 2.2, 3.3);

        System.out.println("String Set:");
        WildcardExample.printElements(stringSet1);

        System.out.println("Integer Set:");
        WildcardExample.printElements(integerSet1);

        System.out.println("Double Set:");
        WildcardExample.printElements(doubleSet1);

    }
}
