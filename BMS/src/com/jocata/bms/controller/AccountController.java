package com.jocata.bms.controller;

import com.jocata.bms.bean.AccountDetailsBean;
import com.jocata.bms.entity.AccountDetails;
import com.jocata.bms.service.*;
import com.jocata.bms.service.impl.*;
import java.util.*;


public class AccountController {
	AccountService AccService=new AccountServiceImpl();
	public String createAcc(AccountDetailsBean acc){
		AccService.createAcc(acc);
		return "Account Created";
	}
	public String deleteAcc(String accNo) {
		AccService.deleteAcc(accNo);
		return "Account Deleted";
	}
	public String updateAcc(AccountDetailsBean acc) {
		AccService.updateAcc(acc);
		return "Account Uppdate";
	}
	public AccountDetails getAcc(String accNo) {
		AccService.getAcc(accNo);
		return null;
	}
	public List<AccountDetails> getAll(){
		AccService.getAll();
		return null;
	}
	 

}
