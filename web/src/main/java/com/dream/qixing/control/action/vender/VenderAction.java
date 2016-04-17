package com.dream.qixing.control.action.vender;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.dream.qixing.control.action.BaseAction;
import com.dream.qixing.config.ApiAction;
import com.dream.qixing.interfaces.vender.IVenderService;
import com.dream.qixing.mapping.ApiField;
import com.dream.qixing.mapping.ApiListField;
import com.dream.qixing.model.vender.Vender;

@ApiAction(value = "vendor")
public class VenderAction  extends BaseAction {
	
	@Resource
	private IVenderService venderService;
	private Vender vender = new Vender();
	@ApiListField("vendors")
	@ApiField("vendor")
	private List<Vender> venders;
	public String execute() throws Exception{
		venders = new ArrayList<Vender>();
		Vender v = venderService.getVenderByVenderId(vender.getVenderId());
		venders.add(v);
		venders.add(v);
		if(v != null){
			this.setIsSuccessful(true);
			this.setStatusCode(200);
		}else {
			this.setIsSuccessful(false);
			this.setStatusCode(401);
		}
		
		return null;
	}
	
	@Override
	public String getResponseName() {
		// TODO Auto-generated method stub
		return null;
	}

	public IVenderService getVenderService() {
		return venderService;
	}

	public void setVenderService(IVenderService venderService) {
		this.venderService = venderService;
	}

	public Vender getVender() {
		return vender;
	}

	public void setVender(Vender vender) {
		this.vender = vender;
	}

	
	
}
