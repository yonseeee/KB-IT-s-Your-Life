package org.scoula.stock.service;

import org.scoula.stock.dto.BuyDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BuyService {
    void buy(BuyDTO dto);
    List<BuyDTO> getList();
    void sell(Long id);
}
