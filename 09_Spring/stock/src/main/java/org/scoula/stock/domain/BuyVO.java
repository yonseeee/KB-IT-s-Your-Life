package org.scoula.stock.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BuyVO {
    private Long id;
    private String stockCode;
    private String stockName;
    private int price;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date buyDate;
}
