package com.dream.qixing.mobile.persistence.interfaces.vender;

import com.dream.qixing.mobile.model.vender.Vender;

public interface IVenderDao {
	Vender findVenderByVenderId(String venderId);
}
