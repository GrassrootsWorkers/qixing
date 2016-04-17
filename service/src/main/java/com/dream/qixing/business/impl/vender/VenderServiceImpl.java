package com.dream.qixing.business.impl.vender;

import com.dream.qixing.model.vender.Vender;
import org.springframework.beans.factory.annotation.Autowired;

import com.dream.qixing.interfaces.vender.IVenderService;
import com.dream.qixing.persistence.interfaces.vender.IVenderDao;

public class VenderServiceImpl implements IVenderService{

	@Autowired
	IVenderDao venderDao;
	public Vender getVenderByVenderId(String venderId) {
		return venderDao.findVenderByVenderId(venderId);
	}

}
