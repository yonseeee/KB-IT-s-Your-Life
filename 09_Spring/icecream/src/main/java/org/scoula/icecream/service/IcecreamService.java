package org.scoula.icecream.service;

import org.scoula.icecream.dto.IcecreamDTO;

import java.util.List;

public interface IcecreamService {

    public void create(IcecreamDTO icecream);
    public List<IcecreamDTO>  getList();
}
