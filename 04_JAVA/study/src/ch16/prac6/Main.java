package ch16.prac6;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Set<String> emotion=new HashSet<>();
        emotion.add("미안");
        emotion.add("사랑");
        emotion.add("소중");
        emotion.add("고마워");
        emotion.add("행복");
        emotion.add("고맙");
        emotion.add("영원");
        emotion.add("믿어");

        Function<String,Message> function=s -> Message::new;
}
