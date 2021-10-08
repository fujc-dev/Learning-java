package com.zc58s.springioc.core.service.persister.impl;

import org.springframework.stereotype.Component;

import com.zc58s.springioc.core.service.persister.IFXNewsPersister;
import com.zc58s.springioc.pojo.FXNewsBean;

@Component
public class DowJonesNewsPersister implements IFXNewsPersister {

	@Override
	public void persistNews(FXNewsBean bean) {
		System.out.println("persistNews");
		
	}

}
