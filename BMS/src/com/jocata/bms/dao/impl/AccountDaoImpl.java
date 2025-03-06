package com.jocata.bms.dao.impl;

import java.util.List;

import com.jocata.bms.bean.AccountDetailsBean;
import com.jocata.bms.dao.AccountDao;
import com.jocata.bms.entity.AccountDetails;

public class AccountDaoImpl implements AccountDao {
	public String createAcc(AccountDetails acc){
		return "Account Created";
	}
	public String deleteAcc(String accNo) {
		return "Account Deleted";
	}
	public String updateAcc(AccountDetails acc) {
		return "Account Updated";
	}
	public AccountDetails getAcc(String accNo) {
		return null;
	}
	public List<AccountDetails> getAll(){
		return null;	
	}
}
