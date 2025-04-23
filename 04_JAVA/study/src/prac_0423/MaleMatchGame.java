package prac_0423;

public class MaleMatchGame extends MatchGame{
    public MaleMatchGame(Celebrity[] celebrities) {
        initializeCandidates(celebrities);
    }
    @Override
    public void initializeCandidates(Celebrity[] celebrities) {
//        for(int i=0;i<celebrities.length;i++){
//            this.candidates[i]=celebrities[i];
//        }
        this.candidates = celebrities;
    }

    @Override
    public Celebrity playGame() {
        return null;
    }

    @Override
    public void printCandidates() {
        System.out.println("[남자 연예인 월드컵 참가자 명단]");
        super.printCandidates();
    }
}
