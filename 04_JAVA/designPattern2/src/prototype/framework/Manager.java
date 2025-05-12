package prototype.framework;

import java.util.HashMap;
import java.util.Map;

public class Manager {
    private Map<String, Product> showCase=new HashMap<>();

//    원본 등록 메소드
    public void register(String name, Product prototype){
//        name: 프로토타입의 이름
        showCase.put(name,prototype);
    }

    public Product create(String prototypeName){
        Product p=showCase.get(prototypeName);
        return p.createCopy();
    }
}
