package ch09.prac;

public class PlayerSettings {
    static class Mode{
        static boolean shuffle = false;
        static boolean repeat = false;
        static int volumeLevel=5;

        static void printSettings(){
            System.out.println(

            );
            System.out.println("현재 재생 설정 상태");
            System.out.println("  - Shuffle: "+(shuffle?"ON":"OFF"));
            System.out.println("  - Repeat: "+(repeat?"ON":"OFF"));
            System.out.println("  - Volume: "+volumeLevel);
            System.out.println();
        }
        static void setShuffle(boolean shuffle2){
            shuffle = shuffle2;
            System.out.println("Shuffle 모드가 "+(shuffle?"ON":"OFF")+"으로 설정되었습니다.");
        }
        static void setRepeat(boolean repeat2){
            repeat = repeat2;
            System.out.println("Repeat 모드가 "+(repeat?"ON":"OFF")+"으로 설정되었습니다.");
        }
        static void setVolumeLevel(int level){
            if(!(level>=0&&level<=10)){
                System.out.println("볼륨은 0~10 사이로 설정해야 합니다.");
            }else{
                System.out.println("볼륨이 "+level+"로 설정되었습니다.");
            }
        }
    }

}
