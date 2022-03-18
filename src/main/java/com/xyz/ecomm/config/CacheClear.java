package com.xyz.ecomm.config;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CacheClear {

	/**
	 * this job is scheduled to run every two hours
	 */
	@Scheduled(cron = "0 0 */2 * * ?")
	@CacheEvict(allEntries = true)
	public void clearCache() {}
}
