package strategy_prac;

public class SmoothSkinFilter implements FilterStrategy {
    @Override
    public String apply(String input) {
        input=input.toLowerCase();
        return input+"🌟";
    }
}
