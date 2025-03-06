package com.jocata.bms.dao;

import java.util.List;

import com.jocata.bms.bean.AccountDetailsBean;
import com.jocata.bms.entity.AccountDetails;

public interface AccountDao {
	public String createAcc(AccountDetails acc);
	public String deleteAcc(String accNo);
	public String updateAcc(AccountDetails acc);
	public AccountDetails getAcc(String accNo);
	public List<AccountDetails> getAll();
	
}
