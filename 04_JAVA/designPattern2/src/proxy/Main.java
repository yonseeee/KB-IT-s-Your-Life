package proxy;

public class Main {
    public static void main(String[] args) {
        Printable p=new PrintProxy("Alice");
        System.out.println("이름은 현재 "+p.getPrinterName()+"입니다.");
        p.setPrinterName("Bob");
        //여기까지는 proxy가 하는 일 ->바로 끝남

        p.print("Hello, world");//진짜 프린터 생성
    }
}
