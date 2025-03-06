package com.jocata.bms.service.impl;

import java.util.List;

import com.jocata.bms.bean.AccountDetailsBean;

import com.jocata.bms.dao.AccountDao;
import com.jocata.bms.dao.impl.AccountDaoImpl;
import com.jocata.bms.entity.AccountDetails;
import com.jocata.bms.service.AccountService;

public class AccountServiceImpl implements AccountService {
	AccountDao accDao=new AccountDaoImpl();
	public String createAcc(AccountDetailsBean acc){
		AccountDetails accEntity=new AccountDetails();
		accEntity.setAccNo(acc.getAccNo());
		accEntity.setName(acc.getName());
		accEntity.setAdd(acc.getAdd());
		accEntity.setContact(acc.getContact());
		accEntity.setType(acc.getType());
		accDao.createAcc(accEntity);
		return "Account Created";
	}
	public String deleteAcc(String accNo) {
		accDao.deleteAcc(accNo);
		return "Account Deleted";
	}
	
	public String updateAcc(AccountDetailsBean acc) {
		AccountDetails accEntity=new AccountDetails();
		accEntity.setAccNo(acc.getAccNo());
		accEntity.setName(acc.getName());
		accEntity.setAdd(acc.getAdd());
		accEntity.setContact(acc.getContact());
		accEntity.setType(acc.getType());
		accDao.updateAcc(accEntity);
		return "Account updated";
		
	}
	public AccountDetailsBean getAcc(String acc) {
		accDao.getAcc(acc);
		return null;
	}
	public List<AccountDetails> getAll(){
		accDao.getAll();
		return null;
		
	}

}
