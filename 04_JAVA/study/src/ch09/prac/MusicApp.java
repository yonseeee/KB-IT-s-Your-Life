package ch09.prac;

public class MusicApp {
    private String title;
    private String artist;
    private String genre;
    public MusicApp(String title, String artist, String genre){
        this.title = title;
        this.artist = artist;
        this.genre = genre;
    }
    class MusicPlayer{
        void play(){
            System.out.println(getEffect(genre)+" "+title+" - "+artist+" 을(를) 재생합니다. "+getEffect(genre));

        }
        String getEffect(String genre){
            if(genre.equals("HIPHOP"))return "🔥";
            else if(genre.equals("BALLAD"))return "🎤";
            else return "🎧";
        }
    }
}
