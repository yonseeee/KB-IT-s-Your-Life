package builder.builder2;

public class Main {
    public static void main(String[] args) {
        User user=User.builder()
                .name("홍길동")
                .email("sdfd@gmail.com")
                .password("123456")
                .phone("010-1111-2222")
                .address("서울시")
                .sex(true)
                .age(16) //여기까지 builder
                .build();//return User

        System.out.println(user);
    }
}
