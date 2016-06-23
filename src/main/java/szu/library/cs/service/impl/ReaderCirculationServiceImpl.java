package szu.library.cs.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import szu.library.cs.dao.ReaderCirculationMapper;
import szu.library.cs.pojo.ReaderCirculation;
import szu.library.cs.service.IReaderCirculationService;

@Service("readerCirculationService")
public class ReaderCirculationServiceImpl implements IReaderCirculationService {
	
	@Resource
	private ReaderCirculationMapper dao;

	public ReaderCirculation getByBorrowId(Integer borrowId) {
		return dao.getByBorrowId(borrowId);
	}

	
}
