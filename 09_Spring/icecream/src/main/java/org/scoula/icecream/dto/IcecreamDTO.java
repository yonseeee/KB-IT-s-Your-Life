package org.scoula.icecream.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.scoula.icecream.domain.IcecreamVO;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IcecreamDTO {
    private Long no;//wrapper type으로 잡은 이유: null 배정하기 위해
    private String name;
    private String flavor;
    private Long price;
    private Date regDate;

    public static IcecreamDTO of(IcecreamVO icecream) {
        return icecream==null?null:IcecreamDTO.builder()
                .no(icecream.getNo())
                .name(icecream.getName())
                .flavor(icecream.getFlavor())
                .price(icecream.getPrice())
                .regDate(icecream.getRegDate())
                .build();
    }

    public IcecreamVO tovo(){
        return IcecreamVO.builder()
                .no(no)
                .name(name)
                .flavor(flavor)
                .price(price)
                .regDate(regDate)
                .build();
    }
}
