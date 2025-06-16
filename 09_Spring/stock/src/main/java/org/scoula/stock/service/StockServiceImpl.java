package org.scoula.stock.service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.stock.domain.StockDTO;
import org.scoula.stock.mapper.StockMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService{

    private final StockMapper mapper;
    @Override
    public List<StockDTO> getList() {
        return mapper.getList().stream().map(StockDTO::of).toList();
    }

    @Override
    public StockDTO get(Long no) {
        return StockDTO.of(mapper.get(no));
    }
}
