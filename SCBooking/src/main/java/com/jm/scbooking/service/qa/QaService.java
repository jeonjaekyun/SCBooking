package com.jm.scbooking.service.qa;

import java.util.List;

import com.jm.scbooking.model.qa.dto.QaDTO;

public interface QaService {
	
	public List<QaDTO> list();
	public void newBoard(QaDTO dto);
	public QaDTO readBoard(int bno);
}
