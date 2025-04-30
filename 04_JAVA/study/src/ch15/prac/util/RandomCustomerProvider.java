package ch15.prac.util;

public class RandomCustomerProvider {
    private static final String[] names={
            "권경현", "권세림", "김동윤", "김미정", "김세연", "김승원", "김예림",
            "문정우", "민중원", "박준영", "서상훈", "손영호", "안수연", "안현주",
            "양성욱", "염정우", "이찬양", "이찬희", "이채은", "전경환", "정다연",
            "정수경", "최명진", "최은서", "최이주", "최지형", "최화진", "홍승원"

    };
    public static String getRandomCustomerName(){
        int index=0;
        double random=Math.random();
        index = (int) Math.floor(random*names.length);
        return names[index];

    }
}
