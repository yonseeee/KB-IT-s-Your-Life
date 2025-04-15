package prac;

public class Practice {
    public static void main(String[] args) {
//        int sum=0;
//
//        for(int i=1;i<=100;i++){
//            if(i%3==0){
//                sum+=i;
//            }
//        }
//        System.out.println("sum: "+sum);


//        for(int i=1;i<=5;i++){
//            for(int j=0;j<i;j++){
//                System.out.print("*");
//            }
//            for(int j=0;j<5-i;j++){
//                System.out.print(" ");
//            }
//            System.out.println();
//        }


//        for (int i=5;i>0;i--){
//            for(int j=0;j<i;j++){
//                System.out.print("*");
//            }
//            System.out.println();
//        }

        int x,y;

        for(x=0;x<=10;x++){
            for(y=0;y<=10;y++){
                if(4*x+5*y==60){
                    System.out.println("("+x+","+y+")");
                }
            }
        }
    }
}
