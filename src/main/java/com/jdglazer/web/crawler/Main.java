package com.jdglazer.web.crawler;

import java.util.ArrayList;
import java.util.List;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

public class Main {
	public static void main(String[] args) throws Exception {
		WebCollectorConfig c = new WebCollectorConfig( "http://www.accuweather.com");
		c.setMaxDepth(1);
		c.setMaxPages(200);
		c.setMaxPageSize(5000000);
		List<String> list = new ArrayList<String>();
		list.add("http://www.accuweather.com");
        String crawlStorageFolder = "C:\\Users\\jglazer\\Documents";
        int numberOfCrawlers = 5;
        
        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(crawlStorageFolder);
        config.setMaxDepthOfCrawling(c.getMaxDepth());
        config.setMaxDownloadSize(c.getMaxPageSize());

        /*
         * Instantiate the controller for this crawl.
         */
        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);

        /*
         * For each crawl, you need to add some seed urls. These are the first
         * URLs that are fetched and then the crawler starts following links
         * which are found in these pages
         */
        controller.addSeed("http://www.accuweather.com");

        /*
         * Start the crawl. This is a blocking operation, meaning that your code
         * will reach the line after this only when crawling is finished.
         */
        WebCollectorFactory factory = new WebCollectorFactory( c );
        controller.start( factory, numberOfCrawlers );
	}
}
