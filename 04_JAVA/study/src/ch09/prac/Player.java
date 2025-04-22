package ch09.prac;

public class Player {
    public void logTitle(String title2) {

        class Logger {
            String title;  // ❗ title이 가려짐

            public void print() {
                System.out.println("제목: " + title2);
            }
        }

        Logger logger = new Logger();
        logger.print();
    }

    public static void main(String[] args) {
        new Player().logTitle("사건의 지평선");
    }
}
