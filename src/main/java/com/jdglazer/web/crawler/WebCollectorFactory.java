package com.jdglazer.web.crawler;

import edu.uci.ics.crawler4j.crawler.CrawlController.WebCrawlerFactory;

public class WebCollectorFactory implements WebCrawlerFactory<WebCollector> {
	
	private WebCollectorConfig webCollectorConfig;
	
	public WebCollectorFactory( WebCollectorConfig webCollectorConfig) {
		this.webCollectorConfig = webCollectorConfig;
	}
	
	public WebCollector newInstance() throws Exception {
		if( webCollectorConfig != null )
			return new WebCollector( webCollectorConfig );
		else
			return null;
	}
}
