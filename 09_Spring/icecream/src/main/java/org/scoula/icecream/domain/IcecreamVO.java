package org.scoula.icecream.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IcecreamVO {
    private Long no;//wrapper type으로 잡은 이유: null 배정하기 위해
    private String name;
    private String flavor;
    private Long price;
    private Date regDate;
}
