package com.jdglazer.web.crawler;

import java.util.List;

/**
 * Stores all setable parameters for a web crawler 
 * @author Glazer, Joshua D.
 *
 */
public class WebCollectorConfig {
	
	private int maxDepth;
	private int maxPages;
	private int maxPageSize;
	private String seedUrl;
	private List<String> urlRegexes;
	private WebCollectorParser parser;
	private String storageFolder;
	
	public int getMaxDepth() {
		return maxDepth;
	}

	public void setMaxDepth(int maxDepth) {
		this.maxDepth = maxDepth;
	}

	public int getMaxPages() {
		return maxPages;
	}

	public void setMaxPages(int maxPages) {
		this.maxPages = maxPages;
	}

	public int getMaxPageSize() {
		return maxPageSize;
	}

	public void setMaxPageSize(int maxPageSize) {
		this.maxPageSize = maxPageSize;
	}

	public String getSeedUrl() {
		return seedUrl;
	}

	public void setSeedUrl(String seedUrl) {
		this.seedUrl = seedUrl;
	}

	public List<String> getUrlRegexes() {
		return urlRegexes;
	}

	public void setUrlRegexes(List<String> urlRegexes) {
		this.urlRegexes = urlRegexes;
	}

	public WebCollectorConfig( String seedUrl ) {
		this.seedUrl = seedUrl;
	}

	public WebCollectorParser getParser() {
		return parser;
	}

	public void setParser(WebCollectorParser parser) {
		this.parser = parser;
	}

	public String getStorageFolder() {
		return storageFolder;
	}

	public void setStorageFolder(String storageFolder) {
		this.storageFolder = storageFolder;
	}
}
