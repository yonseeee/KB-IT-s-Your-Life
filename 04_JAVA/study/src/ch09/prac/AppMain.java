package ch09.prac;

public class AppMain {
    public static void main(String[] args) {
        GenrePlaybackManager manager = new GenrePlaybackManager();

        // HIPHOP 전략
        manager.setPlayer(new GenrePlaybackManager.GenrePlayer() {
            @Override
            public void play(String title, String artist) {
                if(title.length()>=8) System.out.print("💥💥💥 ");
                else System.out.print("💥 ");

            }
            // TODO: 제목 길이가 8자 이상이면 💥💥💥, 아니면 💥 출력
        });
        manager.play("Drowning", "WOODZ");

        // BALLAD 전략
        manager.setPlayer(new GenrePlaybackManager.GenrePlayer() {
            @Override
            public void play(String title, String artist) {
                if(artist.contains(" ")){
                    System.out.print("🎵🎵 ");
                }else {
                    System.out.print("🎵 ");
                }
//                System.out.println(title+" - "+artist);
            }
            // TODO: 아티스트 이름에 공백이 있으면 🎵🎵, 없으면 🎵 출력
        });
        manager.play("그녀가 웃잖아", "LUCY");

        // POP 전략
        manager.setPlayer(new GenrePlaybackManager.GenrePlayer() {
            // TODO: 제목 + 아티스트 글자 수가 짝수면 🎧🎧, 홀수면 🎧 출력
            @Override
            public void play(String title, String artist) {
                if((title.length()+artist.length())%2==0){
                    System.out.print("🎧🎧 ");
                }
                else System.out.print("🎧 ");

            }
        });
        manager.play("오늘만 I LOVE YOU", "BOYNEXTDOOR");
    }
}
