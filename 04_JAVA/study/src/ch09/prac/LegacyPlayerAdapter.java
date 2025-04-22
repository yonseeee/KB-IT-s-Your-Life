package ch09.prac;

public class LegacyPlayerAdapter implements Playable{
    private LegacyPlayer player;
    public LegacyPlayerAdapter(LegacyPlayer legacyPlayer) {
        this.player = legacyPlayer;
    }

    @Override
    public void play(String musicTitle) {
        if(musicTitle.toLowerCase().contains("bad")){
            System.out.println("금지어가 포함된 곡은 재생할 수 없습니다: "+musicTitle);
        }else{
            player.startPlay(musicTitle);
        }
    }
}
