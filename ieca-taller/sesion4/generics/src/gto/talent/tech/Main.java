package gto.talent.tech;

import gto.talent.tech.generics.BoundedBox;
import gto.talent.tech.generics.Box;
import gto.talent.tech.generics.Utility;
import gto.talent.tech.generics.WildcardExample;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Box<String> box = new Box<>();
        Box<Integer> box2 = new Box<>();
        box.setItem("cafe");
        box2.setItem(123);
//        System.out.println("Box tiene: " + box.getItem());
//        System.out.println("Box2 tiene: " + box2.getItem());

        //limitado a Number
        BoundedBox<Double> boundedBox = new BoundedBox<>();
        boundedBox.setItem(12.34);
        //boundedBox.setItem("cafe");
        //System.out.println("BoundedBox tiene: " + boundedBox.getItem());

        String[] fruits = {"Apple", "Banana", "Orange", "Pineapple"};
        //Utility.printArray(fruits);

        //covariant
        Number[] doubleArray = new Integer[10];

        //invariant
        List<Integer> numbers;
        List<Integer> list = new ArrayList<>();

        List<Integer> listString = new ArrayList<>();
        listString.add(123);
        WildcardExample.printList(listString);
    }
}
