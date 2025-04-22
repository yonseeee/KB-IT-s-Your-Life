package ch09.sec07.exam03;

public class ButtonExample {
    public static void main(String[] args) {
        Button btnOk=new Button();

//        일회성으로 사용할 용도라면 익명 구현 객체 사용 권장
        btnOk.setClickListener(new Button.ClickListener() {
            @Override
            public void onClick() {
                System.out.println("Ok 버튼을 클릭했습니다.");
            }
        });
        btnOk.click();

        Button btnCancel=new Button();

        btnOk.setClickListener(new Button.ClickListener() {
            @Override
            public void onClick() {
                System.out.println("Cancel 버튼을 클릭했습니다.");
            }
        });
        btnOk.click();
    }
}
