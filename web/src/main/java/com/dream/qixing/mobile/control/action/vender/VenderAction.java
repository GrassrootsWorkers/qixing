package com.dream.qixing.mobile.control.action.vender;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.dream.qixing.mobile.config.ApiAction;
import com.dream.qixing.mobile.control.action.BaseAction;
import com.dream.qixing.mobile.interfaces.vender.IVenderService;
import com.dream.qixing.mobile.mapping.ApiField;
import com.dream.qixing.mobile.mapping.ApiListField;
import com.dream.qixing.mobile.model.vender.Vender;

@ApiAction(value = "vender")
public class VenderAction  extends BaseAction{
	
	@Resource
	private IVenderService venderService;
	private Vender vender = new Vender();
	@ApiListField("venders")
	@ApiField("vender")
	private List<Vender> venders;
	public String execute() throws Exception{
		venders = new ArrayList<Vender>();
		Vender v = venderService.getVenderByVenderId(vender.getVenderId());
		venders.add(v);
		venders.add(v);
		if(v != null){
			this.setIssuccessful(true);
			this.setStatuscode(200);
		}else {
			this.setIssuccessful(false);
			this.setStatuscode(401);
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
