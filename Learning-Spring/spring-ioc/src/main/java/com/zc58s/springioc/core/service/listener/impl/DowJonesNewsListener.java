package com.zc58s.springioc.core.service.listener.impl;

import org.springframework.stereotype.Component;

import com.zc58s.springioc.core.service.listener.IFXNewsListener;
import com.zc58s.springioc.pojo.FXNewsBean;

@Component
public class DowJonesNewsListener implements IFXNewsListener {

	@Override
	public String[] getAvailableNewsIds() {
		// TODO Auto-generated method stub
		return new String[] { "zhangsan", "lisi" };
	}

	@Override
	public FXNewsBean getNewsByPK(String newsId) {
		// TODO Auto-generated method stub
		return new FXNewsBean();
	}

	@Override
	public void postProcessIfNecessary(String newsId) {
		System.out.println("postProcessIfNecessary");

	}

}
