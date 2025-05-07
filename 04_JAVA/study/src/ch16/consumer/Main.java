package ch16.consumer;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        PhotoAlbum photoAlbum = new PhotoAlbum();
        Consumer<Photo> consumer=photo -> System.out.println(photo);
        Photo photo1=new Photo("지우", "브이✌");
        Photo photo2=new Photo("이슬이", "하트❤");
        Photo photo3=new Photo("웅이", "메타몽 모자🎩");

        System.out.println("[📸 사진 촬영 중...]");
        photoAlbum.addPhoto(photo1,consumer);
        photoAlbum.addPhoto(photo2,consumer);
        photoAlbum.addPhoto(photo3,consumer);

        System.out.println();
        System.out.println("[📤 SNS에 업로드된 사진 목록]");
        Predicate<Photo> predicate=photo -> photo.getPose().equals("하트❤");
        photoAlbum.printFiltered(predicate,consumer);



    }
}
