package strategy_prac;

public class KawaiiFilter implements FilterStrategy {
    @Override
    public String apply(String input) {
        String ret="";
        for(int i=input.length()-1;i>=0;i--){
            char ch=input.charAt(i);
            ret+=ch;
        }
        return ret+"🌸";
    }
}
