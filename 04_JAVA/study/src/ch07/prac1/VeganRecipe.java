package ch07.prac1;

public class VeganRecipe extends Recipe {
    public VeganRecipe() {
        super("두부 샐러드",10,true);
    }

    @Override
    public String getDescription() {
        return "신선한 두부 샐러드를 추천합니다!";
    }

//    @Override
//    public String toString() {
//        String result="";
//        if(this.isVegan)result="비건";
//        else result="비건 아님";
//        return this.title+"("+this.cookTime+") - "+result;
//    }
}
