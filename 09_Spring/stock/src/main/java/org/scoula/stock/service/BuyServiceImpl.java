package org.scoula.stock.service;

import org.scoula.stock.dto.BuyDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyServiceImpl implements BuyService {
    @Override
    public void buy(BuyDTO dto) {

    }

    @Override
    public List<BuyDTO> getList() {
        return List.of();
    }

    @Override
    public void sell(Long id) {

    }
}
