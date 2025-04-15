package ch03.sec01;

public class IncreaseDecreaseOperatorExample {
    public static void main(String[] args) {
        int x=10;
        int y=10;
        int z;

        x++;
        ++x;
        System.out.println("x="+x);
        System.out.println("---------------");
//x:12
        y--;
        --y;
        System.out.println("y="+y);
        System.out.println("---------------");
//y:8
        z=x++;
        System.out.println("z="+z);
        System.out.println("x="+x);
        System.out.println("----------------");
//z:12 x:13


        z=++x;
        System.out.println("z="+z);
        System.out.println("x="+x);
        System.out.println("----------------");
//z:14 x:14


        z=++x + y++;
        System.out.println("z="+z);
        System.out.println("x="+x);
        System.out.println("y="+y);
//x:15 y:9 z:23
    }
}
