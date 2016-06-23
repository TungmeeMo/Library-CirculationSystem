package szu.library.cs.service;

import java.util.List;

import szu.library.cs.pojo.ReaderCirculation;

public interface IReaderCirculationService {
	ReaderCirculation getByBorrowId(Integer borrowId);
	
	

}
