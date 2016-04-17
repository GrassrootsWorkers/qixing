package com.dream.qixing.persistence.interfaces.vender;

import com.dream.qixing.model.vender.Vender;

public interface IVenderDao {
	Vender findVenderByVenderId(String venderId);
}
