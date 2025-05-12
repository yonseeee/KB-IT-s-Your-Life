package prototype_prac;


public class CardTemplate implements Product, Cloneable {
    private String title;
    private char frameChar;
    private String content;

    public String getContent(){
        return content;
    }
    public CardTemplate(String title, char frameChar){
        this.title=title;
        this.frameChar=frameChar;
    }
    @Override
    public void use(String content) {
        this.content=content;
        System.out.println("["+title+"]");
        for(int i=0;i<25;i++){
            System.out.print(frameChar);
        }
        System.out.println('\n'+content);
        for(int i=0;i<25;i++){
            System.out.print(frameChar);
        }
        System.out.println();
    }

    @Override
    public Product createCopy() {
        Product p=null;
        try{
            p=(Product) clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return p;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
