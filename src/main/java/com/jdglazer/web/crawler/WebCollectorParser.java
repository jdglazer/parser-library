package com.jdglazer.web.crawler;

import edu.uci.ics.crawler4j.parser.ParseData;
import edu.uci.ics.crawler4j.url.WebURL;

public interface WebCollectorParser {
	public void parseCrawlerData( String contentType, WebURL url, ParseData parseData );
}
