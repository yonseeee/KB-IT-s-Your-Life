package ch15.sec05.exam04;

import java.util.TreeSet;

public class ComparatorExample {
    public static void main(String[] args) {
//        Fruit이 Comparable 구현을 하지 않았기 때문에 comparator필요
        TreeSet<Fruit> treeSet = new TreeSet<Fruit>(new FruitComparator());

        treeSet.add(new Fruit("포도", 3000));
        treeSet.add(new Fruit("수박", 10000));
        treeSet.add(new Fruit("딸기", 6000));

        for(Fruit fruit : treeSet){
            System.out.println(fruit.name+":"+fruit.price);
        }
    }
}
