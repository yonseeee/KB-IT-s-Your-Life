package org.scoula.icecream.service;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.scoula.icecream.domain.IcecreamVO;
import org.scoula.icecream.dto.IcecreamDTO;
import org.scoula.icecream.mapper.IcecreamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Log4j2
@Service
@RequiredArgsConstructor
public class IcecreamServiceImpl implements IcecreamService {

    final private IcecreamMapper mapper;

    @Override
    public void create(IcecreamDTO icecream) {
        log.info("create" + icecream);
        IcecreamVO icecreamVO = icecream.tovo();
        mapper.create(icecreamVO);
        icecream.setNo(icecreamVO.getNo());
    }

    @Override
    public List<IcecreamDTO> getList() {
        return mapper.getList().stream()
                .map(IcecreamDTO::of)
                .toList();
    }
}
