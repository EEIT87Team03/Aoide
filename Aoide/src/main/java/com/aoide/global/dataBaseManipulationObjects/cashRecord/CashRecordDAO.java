package com.aoide.global.dataBaseManipulationObjects.cashRecord;

import java.util.List;

public interface CashRecordDAO {
	public Integer insert(CashRecordVO CashRecordVO);
	public void update(CashRecordVO CashRecordVO);
	public void delete(Integer cashRecordId);
	public CashRecordVO findByPrimaryKey(Integer cashRecordId);
	public List<CashRecordVO> findById(Integer id);
	public List<CashRecordVO> getAll();
}
