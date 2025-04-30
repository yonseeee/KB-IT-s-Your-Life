package ch15.sec03.exam03;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        Set<String>set=new HashSet<>();

        set.add("Java");
        set.add("JDBC");
        set.add("JSP");
        set.add("Spring");

        Iterator<String> it=set.iterator();

//        hasNext: 다음 값이 있는지 확인하는 메소드
        while(it.hasNext()){
//            next: 다음 값을 가져오는 메소드
            String element=it.next();
            System.out.println(element);
            if(element.equals("JSP")){
//                remove: 가져온 값을 컬렉션에서 제거하는 메소드
                it.remove();
            }
        }
        System.out.println();
        set.remove("JDBC");

        for(String s:set){
            System.out.println(s);
        }
    }
}
