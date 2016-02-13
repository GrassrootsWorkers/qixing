package com.dream.qixing.mobile.business.impl.vender;

import org.springframework.beans.factory.annotation.Autowired;

import com.dream.qixing.mobile.interfaces.vender.IVenderService;
import com.dream.qixing.mobile.model.vender.Vender;
import com.dream.qixing.mobile.persistence.interfaces.vender.IVenderDao;

public class VenderServiceImpl implements IVenderService{

	@Autowired
	IVenderDao venderDao;
	public Vender getVenderByVenderId(String venderId) {
		return venderDao.findVenderByVenderId(venderId);
	}

}
