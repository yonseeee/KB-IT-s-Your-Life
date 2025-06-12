package org.scoula.icecream.mapper;

import org.scoula.icecream.domain.IcecreamVO;

import java.util.List;

public interface IcecreamMapper {

    public void create(IcecreamVO icecream);
    public List<IcecreamVO> getList();
}
