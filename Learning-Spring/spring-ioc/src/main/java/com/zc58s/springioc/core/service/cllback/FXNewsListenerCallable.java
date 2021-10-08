package com.zc58s.springioc.core.service.cllback;

import com.zc58s.springioc.core.service.listener.IFXNewsListener;

public interface FXNewsListenerCallable {

	void injectNewsListener(IFXNewsListener listener);
}
