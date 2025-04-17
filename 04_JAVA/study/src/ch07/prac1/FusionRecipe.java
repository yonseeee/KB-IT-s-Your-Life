package ch07.prac1;

public class FusionRecipe extends Recipe {
    public FusionRecipe() {
        super("불닭파스타",10,false);
    }
    @Override
    public String getDescription() {
        return "매콤달콤한 불닭파스타를 추천합니다!";

    }
}
