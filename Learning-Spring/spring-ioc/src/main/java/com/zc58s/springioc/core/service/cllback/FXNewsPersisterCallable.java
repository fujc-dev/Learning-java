package com.zc58s.springioc.core.service.cllback;

import com.zc58s.springioc.core.service.persister.IFXNewsPersister;

public interface FXNewsPersisterCallable {
	void injectNewsPersister(IFXNewsPersister persister);
}
