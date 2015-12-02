package helper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import models.Crawler;
import models.CrawlerSetting;
import models.Property;

public class ConfigHandler {
	private static ConfigHandler instance = null;
	
	private ConfigHandler() {
		
	}
	
	public static ConfigHandler getInstance() {
		if(instance == null) instance = new ConfigHandler();	
		createConfigFile();		
		return instance;
	}
	
	public CrawlerSetting getConfigInfo() {
		return getCrawlerSetting();
	}
	
	private static void createConfigFile() {
//		try {
//			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
//			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
//
//			// root elements
//			Document doc = docBuilder.newDocument();
//			Element rootElement = doc.createElement("configuration");
//			doc.appendChild(rootElement);
//			
//			// server host element
//			Element serverHost = doc.createElement("serverHost");
//			serverHost.appendChild(doc.createTextNode("localhost"));
//			rootElement.appendChild(serverHost);
//			
//			// port element
//			Element port = doc.createElement("port");
//			port.appendChild(doc.createTextNode("8983"));
//			rootElement.appendChild(port);
//			
//			// core element
//			Element core = doc.createElement("core");
//			core.appendChild(doc.createTextNode("new_core"));
//			rootElement.appendChild(core);
//			
//			// solr path
//			Element solrPath = doc.createElement("solrPath");
//			solrPath.appendChild(doc.createTextNode("solr"));
//			rootElement.appendChild(solrPath);
//			
//			// storage folder
//			Element crawlStorageFolder = doc.createElement("crawlStorageFolder");
//			crawlStorageFolder.appendChild(doc.createTextNode("/data/crawl/root"));
//			rootElement.appendChild(crawlStorageFolder);
//			
//			// number of crawlers
//			Element numberOfCrawler = doc.createElement("numberOfCrawler");
//			numberOfCrawler.appendChild(doc.createTextNode("3"));
//			rootElement.appendChild(numberOfCrawler);
//			
//			Element crawlers = doc.createElement("crawlers");
//			rootElement.appendChild(crawlers);
//			
//			// first crawler
//			Element crawler_1 = doc.createElement("crawler");
//			crawlers.appendChild(crawler_1);
//			
//			Element maxPagesToFetch_1 = doc.createElement("maxPagesToFetch");
//			maxPagesToFetch_1.appendChild(doc.createTextNode("1000"));
//			
//			Element individualFolder_1 = doc.createElement("individualFolder");
//			individualFolder_1.appendChild(doc.createTextNode("crawler1"));
//			
//			Element delay_1 = doc.createElement("delay");
//			delay_1.appendChild(doc.createTextNode("1000"));
//			
//			Element crawlersDomain_1 = doc.createElement("crawlersDomain");					
//			crawlersDomain_1.appendChild(doc.createElement("domain").appendChild(doc.createTextNode("http:///www.ics.uci.edu/")));
//			crawlersDomain_1.appendChild(doc.createElement("domain").appendChild(doc.createTextNode("http://www.cnn.com/")));
//			
//			Element concurrentThreads_1 = doc.createElement("concurrentThreads");
//			concurrentThreads_1.appendChild(doc.createTextNode("5"));
//			
//			Element domainSeeders_1 = doc.createElement("domainSeeders"); 
//			domainSeeders_1.appendChild(doc.createElement("seeder").appendChild(doc.createTextNode("http:///www.ics.uci.edu/")));
//			domainSeeders_1.appendChild(doc.createElement("seeder").appendChild(doc.createTextNode("http://www.cnn.com/")));
//			domainSeeders_1.appendChild(doc.createElement("seeder").appendChild(doc.createTextNode("http://www.ics.uci.edu/~lopes/")));
//			domainSeeders_1.appendChild(doc.createElement("seeder").appendChild(doc.createTextNode("http://www.cnn.com/POLITICS/")));
//			
//			Element maxDepth_1 = doc.createElement("maxDepth");
//			maxDepth_1.appendChild(doc.createTextNode("-1"));
//			
//			Element includeBinary_1 = doc.createElement("includeBinary");
//			includeBinary_1.appendChild(doc.createTextNode("1"));
//			
//			Element maxTimeoutSocket_1 = doc.createElement("maxTimeoutSocket");
//			maxTimeoutSocket_1.appendChild(doc.createTextNode("10000"));
//			
//			Element maxTimeoutConnection_1 = doc.createElement("maxTimeoutConnection");
//			maxTimeoutConnection_1.appendChild(doc.createTextNode("10000"));
//			
//			crawler_1.appendChild(maxPagesToFetch_1);
//			crawler_1.appendChild(maxDepth_1);
//			crawler_1.appendChild(maxTimeoutConnection_1);
//			crawler_1.appendChild(maxTimeoutSocket_1);
//			crawler_1.appendChild(includeBinary_1);
//			crawler_1.appendChild(individualFolder_1);
//			crawler_1.appendChild(domainSeeders_1);
//			crawler_1.appendChild(concurrentThreads_1);
//			crawler_1.appendChild(delay_1);
//			crawler_1.appendChild(crawlersDomain_1);
//			
//			// write the content into xml file
//			TransformerFactory transformerFactory = TransformerFactory.newInstance();
//			Transformer transformer = transformerFactory.newTransformer();
//			DOMSource source = new DOMSource(doc);
//			StreamResult result = new StreamResult(new File("file.xml"));
//
//			// Output to console for ing
//			// StreamResult result = new StreamResult(System.out);
//
//			transformer.transform(source, result);
//
//			System.out.println("File saved!");
//
//		  } catch (ParserConfigurationException pce) {
//			pce.printStackTrace();
//		  } catch (TransformerException tfe) {
//			tfe.printStackTrace();
//		  }		
//		Properties prop = new Properties();
//		OutputStream output = null;
//
//		try {
//			output = new FileOutputStream("config.properties");
//
//			// set the properties value to connect solr server
//			prop.setProperty("serverhost", "localhost");
//			prop.setProperty("port", "8983");
//			prop.setProperty("core", "new_core");
//			prop.setProperty("solrPath", "solr");
//			
//			prop.setProperty("crawlStorageFolder", "/data/crawl/root");
//			
//			// set the properties for multiple page crawler
//			prop.setProperty("numberOfCrawler", "3");
//			prop.setProperty("maxPagesToFetch", "30000|30000|30000");
//			prop.setProperty("individualFolder", "crawler1|crawler2|crawler3");
//			prop.setProperty("delay", "1000|1000|1000");
//			prop.setProperty("crawlersDomain", "http:///www.ics.uci.edu/ http://www.cnn.com/|http://en.wikipedia.org/|http://www2.uet.vnu.edu.vn/");
//			prop.setProperty("concurrentThreads", "5|5|5");
//			prop.setProperty("domainSeeders", "http://www.ics.uci.edu/ http://www.cnn.com/ http://www.ics.uci.edu/~lopes/ http://www.cnn.com/POLITICS/|http://en.wikipedia.org/wiki/Main_Page http://en.wikipedia.org/wiki/Obama http://en.wikipedia.org/wiki/Bing|http://www2.uet.vnu.edu.vn/" );
//			prop.setProperty("maxDepth", "-1|-1|-1");
//			prop.setProperty("includeBinaryContent", "1|0|1");
//			// save properties to project root folder
//			prop.store(output, null);
//
//		} catch (IOException io) {
//			io.printStackTrace();
//		} finally {
//			if (output != null) {
//				try {
//					output.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}	  
	}
	
	public CrawlerSetting getCrawlerSetting() {
		CrawlerSetting setting = new CrawlerSetting();
		
		return setting;
	}
	
	public Property getProperty() {
		Property prop = new Property();
		try {	
	         File inputFile = new File("config.xml");
	         DocumentBuilderFactory dbFactory 
	            = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         Document doc = dBuilder.parse(inputFile);
	         doc.getDocumentElement().normalize();
	         
	         NodeList serverHost = doc.getElementsByTagName("serverHost");
	         prop.setServerHost(serverHost.item(0).getTextContent());
	         
	         NodeList port = doc.getElementsByTagName("port");
	         prop.setPort(port.item(0).getTextContent());
	         
	         NodeList core = doc.getElementsByTagName("core");
	         prop.setCore(core.item(0).getTextContent());
	         
	         NodeList solrPath = doc.getElementsByTagName("solrPath");
	         prop.setSolrPath(solrPath.item(0).getTextContent());
	         
	         NodeList storage = doc.getElementsByTagName("crawlStorageFolder");
	         prop.setStorageFolder(storage.item(0).getTextContent());
	         
	         NodeList numberOfCrawler = doc.getElementsByTagName("numberOfCrawler");	         
	         prop.setNumberOfCrawlers(numberOfCrawler.item(0).getTextContent());
	         
	         NodeList nList = doc.getElementsByTagName("crawler");
	         System.out.println("----------------------------");
	         for (int temp = 0; temp < nList.getLength(); temp++) {
	            Node nNode = nList.item(temp);
//	            System.out.println("\nCurrent Element :" 
//	               + nNode.getNodeName());
	            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	                Element eElement = (Element) nNode;
	                int maxPagesToFetch = Integer.parseInt(eElement.getElementsByTagName("maxPagesToFetch").item(0).getTextContent());
	            	int delay = Integer.parseInt(eElement.getElementsByTagName("delay").item(0).getTextContent());
	            	int concurrentThreads = Integer.parseInt(eElement.getElementsByTagName("concurrentThreads").item(0).getTextContent());
	            	int maxDepth = Integer.parseInt(eElement.getElementsByTagName("maxDepth").item(0).getTextContent());
	            	int maxTimeoutConnection = Integer.parseInt(eElement.getElementsByTagName("maxTimeoutConnection").item(0).getTextContent());
	            	int maxTimeoutSocket = Integer.parseInt(eElement.getElementsByTagName("maxTimeoutSocket").item(0).getTextContent());
	            	boolean isIncludeBinary = Integer.parseInt(eElement.getElementsByTagName("includeBinary").item(0).getTextContent()) == 1;
	            	String individualFolder = eElement.getElementsByTagName("individualFolder").item(0).getTextContent();
	            	NodeList domainResult = eElement.getElementsByTagName("domain");
	            	NodeList seedersResult = eElement.getElementsByTagName("seeder");
	            	
	            	List<String> domainSeeders = new ArrayList<String>();
	            	List<String> crawlersDomain = new ArrayList<String>();
	            	
	            	for(int k = 0; k < domainResult.getLength(); k++) {
	            		Node node = domainResult.item(k);
	            		domainSeeders.add(node.getTextContent());
	            	}
	            	
	            	for(int k = 0; k < seedersResult.getLength(); k++) {
	            		Node node = seedersResult.item(k);
	            		crawlersDomain.add(node.getTextContent());
	            	}
//	            	for(int k = 0; k < crawlersDomainResult.getLength(); k++) {
//	            		Node item = crawlersDomainResult.item(k);
//	            		if(item.getNodeType() == Node.ELEMENT_NODE) {
//	            			Element element = (Element) item;
//	            		}
//	            	}
	            	
	            	Crawler crawl = new Crawler();
	            	crawl.setMaxPagesToFetch(maxPagesToFetch);
	            	crawl.setDelay(delay);
	            	crawl.setMaxDepth(maxDepth);
	            	crawl.setConcurrentThreads(concurrentThreads);
	            	crawl.setMaxTimeoutConnection(maxTimeoutConnection);
	            	crawl.setMaxTimeoutSocket(maxTimeoutSocket);
	            	crawl.setIncludeBinary(isIncludeBinary);
	            	crawl.setIndividualFolder(individualFolder);	            		            	
	            	crawl.setDomainSeeders(domainSeeders);
	            	crawl.setCrawlersDomain(crawlersDomain);
	            	
	            	prop.crawlers.add(crawl);
	             }
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }	   		
		return prop;
	}	
}
