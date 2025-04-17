package ch06.sec11.exam02;

public class Earth {
//    상수의 이름은 보통 대문자로 표기
    static final double EARTH_RADIUS = 64000;
    static final double EARTH_SURFACE_AREA;
    static{
        EARTH_SURFACE_AREA = 4* Math.PI*EARTH_RADIUS*EARTH_RADIUS;
    }
}
