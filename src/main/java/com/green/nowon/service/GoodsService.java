package com.green.nowon.service;

import org.springframework.ui.Model;

import com.green.nowon.domain.dto.goods.GoodsInsertDTO;

public interface GoodsService {

	void save(GoodsInsertDTO dto);

	void categoryList(Model model);

	void categoryList(long cno, Model model);

}
