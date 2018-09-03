package com.x.cms.assemble.control;

import com.x.base.core.entity.JpaObject;
import com.x.base.core.project.cache.ApplicationCache;

/**
 * 缓存管理帮助类
 * @author liyi
 *
 */
public class CacheUtil {
	
	public static <T extends JpaObject> void notify( Class<T> clz ) throws Exception {
		ApplicationCache.notify( clz );
	}
	
}
