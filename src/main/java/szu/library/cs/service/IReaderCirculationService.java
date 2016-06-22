package szu.library.cs.service;

import szu.library.cs.pojo.ReaderCirculation;

public interface IReaderCirculationService {
	ReaderCirculation getByBorrowId(Integer borrowId);

}
