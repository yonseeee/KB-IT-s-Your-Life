package ch14.exam;

public class ThreadExample {
    public static void main(String[] args) {

        MusicRunnable musicRunnable = new MusicRunnable();
        Thread thread = new Thread(musicRunnable);
        thread.start();

        MovieThread movieThread = new MovieThread();
    }
}
