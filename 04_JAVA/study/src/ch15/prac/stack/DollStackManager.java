package ch15.prac.stack;

import java.util.Stack;

public class DollStackManager {
    private static Stack<String> stack=new Stack<>();
    private static final String[] dolls={
            "피카츄", "리자몽", "꼬부기", "쿠로미", "헬로키티",
            "뽀로로", "짱구", "도라에몽", "스폰지밥", "미니언"
    };

    public void storeRandomDoll(){
        int index=(int)(Math.random()*dolls.length);
        stack.push( dolls[index]);
        System.out.println("🧸 "+stack.peek()+" 인형이 보관함에 추가되었습니다.");
    }
    public void showStack(){
        System.out.print("🧸 현재 보관 중인 인형: ");
        System.out.println(stack);
//        String[] arr = (String[]) stack.toArray();
//        for(int i=0;i<arr.length;i++){
//            System.out.println(arr[i]);
//
//        }
    }
}
