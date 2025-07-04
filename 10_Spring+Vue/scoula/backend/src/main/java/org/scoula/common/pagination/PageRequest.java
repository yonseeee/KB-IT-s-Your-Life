package org.scoula.common.pagination;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access= AccessLevel.PRIVATE)//of() 팩토리 메서드로만 객체 생성 유도
public class PageRequest {
    private int page;
    private int amount;

    public PageRequest(){
        page=1;
        amount=10;
    }

//    정적 팩토리 메서드: 원하는 page, amount로 객체 생성
    public static PageRequest of(int page, int amount){
        return new PageRequest(page,amount);
    }

//    OFFSET 계산
    public int getOffset(){
        return (page-1)*amount;
    }
}
