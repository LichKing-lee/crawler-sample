package graymadonna;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

public class GrayMadonnaMain {

  public static void main(String[] args) throws Exception {
    int numberOfSrawlers = 1;
    CrawlConfig config = new CrawlConfig();
    // depth 가 곧 page number 수 이동도 연관된 것 같다.
    config.setMaxDepthOfCrawling(15);
    config.setCrawlStorageFolder("~/git/javatest/backup");
    config.setUserAgentString("wonder-shopping-crawler");
    //config.setMaxPagesToFetch(100);
    config.setPolitenessDelay(1500);

    PageFetcher pageFetcher = new PageFetcher(config);
    RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
    RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
    CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);
    controller.addSeed("http://www.graymadonna.com");

    System.out.println("id\ttitle\tprice_pc\tprice_mobile\tnormal_price\tlink\tmobile_link\timage_link\tcategory_name1");

    controller.start(GrayMadonnaCrawler.class, numberOfSrawlers);

  }
}
