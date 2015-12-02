package crawler;

import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import org.apache.solr.common.SolrInputDocument;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;

public class MyCrawler extends WebCrawler {
	private SolrjPopulator server = SolrjPopulator.getInstance();
	
    private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|gif|jpg"
                                                           + "|png|mp3|mp3|zip|gz))$");
    private final static Pattern FILTERS2 = Pattern.compile("redlink=1|veaction=edit|action=edit|action=history|action=info|returnto|oldid|printable=yes|Wikipedia:|Trang_Ch%C3%ADnh:|%C4%90%E1%BA%B7c_bi%E1%BB%87t:|Ch%E1%BB%A7_%C4%91%E1%BB%81:");    
    private String[] myCrawlDomains;    
    
    @Override
    public void onStart() {
      myCrawlDomains = (String[]) myController.getCustomData();
//      ignoreURLs = Util.getUrlIgnoreList();           
    }
        
     @Override
     public boolean shouldVisit(Page referringPage, WebURL url) {
    	 String hrefOrigin = url.getURL();
    	 if (FILTERS2.matcher(hrefOrigin).matches()) {
   	      	return false;
		 }
    	 String href = url.getURL().toLowerCase();
    	    if (FILTERS.matcher(href).matches()) {
    	      return false;
    	    }
    	    
    	    for (String crawlDomain : myCrawlDomains) {
    	      if (href.startsWith(crawlDomain)) {
    	        return true;
    	      }
    	    }

    	    return false;                  
     }

     /**
      * This function is called when a page is fetched and ready
      * to be processed by your program.
      */
     @Override
     public void visit(Page page) {
    	 
    	 int docid = page.getWebURL().getDocid();
    	 String url = page.getWebURL().getURL();
    	 int parentDocid = page.getWebURL().getParentDocid();
         
         logger.debug("Docid: {}", page.getWebURL().getDocid());
         logger.info("URL: {}", url);
         logger.debug("Docid of parent page: {}", parentDocid);
         
         if (page.getParseData() instanceof HtmlParseData) {        	 
             HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();             
             String text = htmlParseData.getText();
             String html = htmlParseData.getHtml();
             String title = htmlParseData.getTitle();
             Set<WebURL> links = htmlParseData.getOutgoingUrls();                         
             
//             System.out.println("Text length: " + text.length());
//             System.out.println("Html length: " + html.length());
//             System.out.println("Number of outgoing links: " + links.size());
             
             RawDocument document = new RawDocument();
             document.setLink(url);
             document.setTitle(title);
             document.setContent(text);
             
             List<SolrInputDocument> result = SolrDocument.createSolrDocument(document);
             server.addNewDocument(result);             
         }
    }
     
     
}
