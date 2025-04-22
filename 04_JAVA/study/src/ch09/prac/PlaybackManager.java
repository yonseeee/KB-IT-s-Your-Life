package ch09.prac;

public class PlaybackManager {
    public interface Player {
        void play();
    }

    public void start() {
//        int count = 0;

        class Logger implements Player {
            static int count=0;
            public void play() {
                count++; // ❌ 컴파일 에러 발생
                System.out.println("🎶 재생 횟수: " + count);
            }
        }

        Logger logger = new Logger();
        logger.play();
        logger.play();
    }

    public static void main(String[] args) {
        new PlaybackManager().start();
    }
}
