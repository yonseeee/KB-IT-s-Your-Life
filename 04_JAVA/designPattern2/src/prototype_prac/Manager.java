package prototype_prac;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Manager {

    private Map<String, Product> map=new HashMap<>();
    public void register(String name, Product p){
        map.put(name,p);
    }
    public Product create(String name){
        Product p=map.get(name);
        if(p==null){
            return null;
        }
        return  p.createCopy();
    }
    public void printRegisteredStyles(List<Product> products){
        System.out.println();
        System.out.println("📦 사용된 카드 목록 출력:");
        products.forEach(p->{p.use(((CardTemplate)p).getContent());
            System.out.println();
        });
    }
}
