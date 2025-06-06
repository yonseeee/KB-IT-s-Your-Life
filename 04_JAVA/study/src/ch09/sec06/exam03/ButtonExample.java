package ch09.sec06.exam03;

public class ButtonExample {
    public static void main(String[] args) {
        Button btnOk = new Button();

// main 내에 있는 로컬 클래스
        class OkListener implements Button.ClickListener {
            @Override
            public void onClick() {
                System.out.println("Ok 버튼을 클릭했습니다.");
            }
        }

//        외부에서 인터페이스 구현 객체 주입
        btnOk.setClickListener(new OkListener());
//          현재 받아온 clickListener의 onClick 호출
        btnOk.click();


        Button btnCancel = new Button();

        class CancelListener implements Button.ClickListener {
            @Override
            public void onClick() {
                System.out.println("Cancel 버튼을 클릭했습니다.");
            }
        }

        btnOk.setClickListener(new CancelListener());

        btnOk.click();
    }
}
