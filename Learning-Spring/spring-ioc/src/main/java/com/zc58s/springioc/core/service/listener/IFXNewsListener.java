package com.zc58s.springioc.core.service.listener;

import com.zc58s.springioc.pojo.FXNewsBean;

public interface IFXNewsListener {

	String[] getAvailableNewsIds();

	FXNewsBean getNewsByPK(String newsId);

	void postProcessIfNecessary(String newsId);
}
