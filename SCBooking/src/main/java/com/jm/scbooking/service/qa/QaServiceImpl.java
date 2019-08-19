package com.jm.scbooking.service.qa;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.jm.scbooking.model.qa.dao.QaDAO;
import com.jm.scbooking.model.qa.dto.QaDTO;

@Service
public class QaServiceImpl implements QaService {

	@Inject
	QaDAO qaDao;
	
	@Override
	public List<QaDTO> list() {
		return qaDao.list();
	}

	@Override
	public void newBoard(QaDTO dto) {
		qaDao.newBoard(dto);
	}

	@Override
	public QaDTO readBoard(int bno) {
		return qaDao.readBoard(bno);
	}

}
