package ch16.consumer;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Photo {
    private String name;
    private String pose;

    @Override
    public String toString() {
        return name+"님이 \'"+pose+"\' 포즈로 사진을 찍었습니다.";
    }
}
