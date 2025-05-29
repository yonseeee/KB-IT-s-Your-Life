package composite_prac;

public class BandProxy extends BandComponent {
    private Band targetBand;

    public BandProxy(Band targetBand){
        this.targetBand=null;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public void perform() {

    }

    @Override
    public void printStructure(String prefix) {

    }
}
