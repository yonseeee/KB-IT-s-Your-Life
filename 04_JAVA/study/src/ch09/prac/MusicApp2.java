package ch09.prac;

public class MusicApp2 {
    private String user = "yura";

    public static class PlayerUI {
        public void show(MusicApp2 m) {
            System.out.println("🎧 현재 사용자: " + m.user); // ❌ 컴파일 에러 발생
        }
    }

    public static void main(String[] args) {
        MusicApp2 m = new MusicApp2();
        PlayerUI p = new PlayerUI();
        p.show(m);
    }
}
