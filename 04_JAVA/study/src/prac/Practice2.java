package prac;

public class Practice2 {
    public static void main(String[] args) {

//        int[]array={1,5,3,8,2};
//
//        int max=-1;
//        for(int x=0;x<array.length;x++){
//            if(array[x]>max){
//                max=array[x];
//            }
//        }
//        System.out.println("max: "+max);


        int[][] array={
                {95,86},
                {83,92,96},
                {
                        78,83,93,87,88
                }
        };

//        System.out.println(array.length);
//        System.out.println(array[2].length);

        int sum=0;
        double avg=0.0;
        int cnt=0;
        for(int i=0;i< array.length;i++){

            for(int j=0;j< array[i].length;j++){
                sum+=array[i][j];
                cnt++;
            }

        }
        avg=sum/(double)cnt;
        System.out.println("total: "+sum+", avg: "+avg);
    }
}
