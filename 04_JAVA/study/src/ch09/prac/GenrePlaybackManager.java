package ch09.prac;

public class GenrePlaybackManager {
    public interface GenrePlayer{
        void play(String title,String artist);
    }

    private GenrePlayer genrePlayer;
    public void setPlayer(GenrePlayer player){
        this.genrePlayer=player;
    }
    public void play(String title, String artist){
        if (genrePlayer != null) {
            genrePlayer.play(title, artist);
            System.out.println(title + " - " + artist);
        }
        else{
            System.out.println("❌ 재생 전략이 설정되지 않았습니다.");
        }

        genrePlayer=null;
    }
}
