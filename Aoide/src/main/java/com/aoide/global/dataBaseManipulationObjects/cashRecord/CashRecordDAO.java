package com.aoide.global.dataBaseManipulationObjects.cashRecord;

import java.util.List;

public interface CashRecordDAO {
	public void insert(CashRecordVO CashRecordVO);
	public void update(CashRecordVO CashRecordVO);
	public void delete(Integer cashRecordId);
	public CashRecordVO findByPrimaryKey(Integer cashRecordId);
	public List<CashRecordVO> getAll();
}
