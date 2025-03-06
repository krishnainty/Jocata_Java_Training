package com.jocata.bms.service;
import java.util.*;

import com.jocata.bms.bean.AccountDetailsBean;

import com.jocata.bms.entity.AccountDetails;

public interface AccountService {
	public String createAcc(AccountDetailsBean acc);
	public String deleteAcc(String accNo);
	public String updateAcc(AccountDetailsBean acc);
	public AccountDetailsBean getAcc(String accNo);
	public List<AccountDetails> getAll();
}
