package com.zc58s.springioc.core;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zc58s.springioc.core.service.cllback.FXNewsListenerCallable;
import com.zc58s.springioc.core.service.cllback.FXNewsPersisterCallable;
import com.zc58s.springioc.core.service.listener.IFXNewsListener;
import com.zc58s.springioc.core.service.listener.impl.DowJonesNewsListener;
import com.zc58s.springioc.core.service.persister.IFXNewsPersister;
import com.zc58s.springioc.core.service.persister.impl.DowJonesNewsPersister;
import com.zc58s.springioc.pojo.FXNewsBean;

/**
 * 
 * 假如默认使用道琼斯新闻社的新闻，那么我们相应的提供了{@link DowJonesNewsListener}和{@link DowJonesNewsPersister}两个实现。<br/>
 * 通常情况下，需要在构造函数中构造{@link IFXNewsListener}和
 * {@link IFXNewsPersister}，也就是{@link FXNewsProvider}
 * 依赖的两个类（我们将这种其他类依赖的类或者对象，我们简称为“依赖类”、“依赖对象”）。
 * 
 * <p>
 * 1、在类是实现中，{@link FXNewsProvider}需要依赖{@link IFXNewsListener}来帮助抓取新闻内容，并依赖{@link IFXNewsPersister}存储抓取的新闻。
 * </p>
 * 
 * <p>
 * 2、突然有一天，客户告诉你，我们又搞定一家新闻社，现在可以使用他们的新闻服务了，这家新闻社叫做MarketWin24.这时候，该如何处理呢？<br/>
 * </p>
 * <p>
 * 首先，应该根据MarketWin24的服务，增加{@link MarketWin24NewsListener}实现，用来接收新的新闻数据；<br/>
 * 其次，我们都是相同的数据访问逻辑，所有原来的DowJonesNewPersister可以重用，我们先放一遍不管；<br/>
 * 最后，最主要的业务处理对象{@link FXNewsProvider}了。
 * </p>
 * 
 * @ClassName FXNewsProvider
 * @Description TODO
 * @author fjc.dane@gmail.com
 * @date 2021年7月26日 上午11:59:34
 *
 */
@Component
public class FXNewsProvider implements FXNewsListenerCallable, FXNewsPersisterCallable {

	@Autowired
	private IFXNewsListener listener;
	@Autowired
	private IFXNewsPersister persister;

	public FXNewsProvider() {
		
	}
	
	/**
	 * 在没有引入依赖注入时，我们通常的解决依赖的方式是使用new新建依赖对象。
	 */
	public FXNewsProvider(IFXNewsListener listener, IFXNewsPersister persister) {
		this.listener = listener;
		this.persister = persister;
	}

	public void getAndPersistNews() {
		String[] newsIdStrings = listener.getAvailableNewsIds();
		if (ArrayUtils.isEmpty(newsIdStrings))
			return;
		for (String newsId : newsIdStrings) {
			FXNewsBean bean = listener.getNewsByPK(newsId);
			persister.persistNews(bean);
			listener.postProcessIfNecessary(newsId);
		}
	}

	@Override
	public void injectNewsListener(IFXNewsListener listener) {
		this.listener = listener;

	}

	@Override
	public void injectNewsPersister(IFXNewsPersister persister) {
		this.persister = persister;

	}

	public void setListener(IFXNewsListener listener) {
		this.listener = listener;
	}

	public void setPersister(IFXNewsPersister persister) {
		this.persister = persister;
	}

	
	
}
