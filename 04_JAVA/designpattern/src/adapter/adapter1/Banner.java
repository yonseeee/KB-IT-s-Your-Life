package adapter.adapter1;

public class Banner {//소스 역할(이용하고자 하는 코드)
    private String string;

    public Banner(String string) {
        this.string = string;
    }
    public void showWithParen(){
        System.out.println("("+string+")");
    }
    public void showWithAster(){
        System.out.println("*"+string+"*");
    }
}
