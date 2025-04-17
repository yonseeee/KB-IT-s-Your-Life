package ch07.prac1;

public class KoreanRecipe extends Recipe {
    public KoreanRecipe() {
        super("김치찌개", 20, false);
    }

    @Override
    public String getDescription() {
        return "매콤한 김치찌개를 추천합니다!";
    }
    public String getSpicinessLevel() {
        return "맵기: ★★★☆☆";
    }

//    @Override
//    public String toString() {
//        String result="";
//        if(this.isVegan)result="비건";
//        else result="비건 아님";
//        return this.title+"("+this.cookTime+") - "+result;
//    }
}
