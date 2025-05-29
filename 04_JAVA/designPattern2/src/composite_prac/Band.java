package composite_prac;

import java.util.ArrayList;
import java.util.List;

public class Band extends BandComponent{
    private String name;
    private List<BandComponent> members=new ArrayList<>();

    public Band(String name){
        this.name = name;
    }
    public void add(BandComponent component){
        members.add(component);
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public void printStructure(String prefix) {
        System.out.println(prefix+"🎤 Band - "+name);
        for(BandComponent component : members){
            component.printStructure(prefix+"\t");
        }
    }

    @Override
    public void perform() {
        System.out.println("💡 무대 조명 ON");
        System.out.println("🎉 관객: 와아아아아!!!!");
        System.out.println("🎤 밴드 ["+name+"] 공연을 시작합니다!");
        for(BandComponent component : members){
            component.perform();
        }
        System.out.println("🎤 밴드 ["+name+"] 공연 종료!");
        System.out.println("🔌 무대 조명 OFF");
        System.out.println();
    }
}
