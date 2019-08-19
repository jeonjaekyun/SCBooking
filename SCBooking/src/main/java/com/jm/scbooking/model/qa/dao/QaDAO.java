package com.jm.scbooking.model.qa.dao;

import java.util.List;

import com.jm.scbooking.model.qa.dto.QaDTO;

public interface QaDAO {
	public List<QaDTO> list();
	public void newBoard(QaDTO dto);
	public QaDTO readBoard(int bno);
}
