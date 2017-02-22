package com.jdglazer.web.crawler;

import java.util.regex.Pattern;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.url.WebURL;

public class WebCollector extends WebCrawler {
	
	private WebCollectorConfig webCollectorConfig;
	
	public WebCollector( WebCollectorConfig config ) {
		this.webCollectorConfig = config;
	}
		
	@Override
	public boolean shouldVisit( Page page, WebURL url ) {
		String href = url.getURL().toLowerCase();
		boolean matches = true;
		for( String regex : webCollectorConfig.getUrlRegexes() ) {
			try {
				if( !Pattern.matches( regex,  href ) ) {
					matches = false;
					break;
				}
			} catch( Exception e ) {
			}
		}
		return matches;
	}
	
	@Override
	public void visit( Page page ) {
		webCollectorConfig
			.getParser()
			.parseCrawlerData(
					page.getContentType(), 
					page.getWebURL(), 
					page.getParseData() 
				);
	}
}
