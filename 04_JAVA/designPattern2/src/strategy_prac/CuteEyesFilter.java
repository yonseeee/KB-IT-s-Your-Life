package strategy_prac;

public class CuteEyesFilter implements FilterStrategy {
    @Override
    public String apply(String input) {
        String ret="";
        for(int i=0;i<input.length();i++){
            char ch=input.charAt(i);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||
            ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U'){
                ret+="👀";
            }else{
                ret+=ch;
            }
        }
        return ret;

    }
}
