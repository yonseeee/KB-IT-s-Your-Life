package ch09.prac;

public class ModernPlayerAdapter implements Playable{
    private ModernPlayer modernPlayer;
    public ModernPlayerAdapter(ModernPlayer modernPlayer) {
        this.modernPlayer = modernPlayer;
    }

    @Override
    public void play(String musicTitle) {
        if(musicTitle.toLowerCase().contains("bad")){
            System.out.println("🚫 금지어가 포함된 곡은 재생할 수 없습니다: "+musicTitle);
        }else{
            modernPlayer.begin(musicTitle);
        }
    }
}
