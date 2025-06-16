package org.scoula.stock.mapper;

import org.scoula.stock.domain.BuyVO;

public interface BuyMapper {
    insert(BuyVO vo);
    getList();
    delete(Long id);
}
