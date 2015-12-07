package helper;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import models.CrawlerConfig;
import models.CrawlerSetting;

public class ConfigHandler {
	private static ConfigHandler instance = null;
	
	private static String SERVER_HOST = "serverHost";
	private static String PORT = "port";
	private static String SOLR_PATH = "solrPath";
	private static String CORE = "core";
	private static String CRAWL_STORAGE_FOLDER = "crawlStorageFolder";
	
	private static String NUMBER_OF_CRAWLERS = "numberOfCrawlers";
	private static String CONNECTION_TIMEOUT = "connectionTimeout";
	private static String SOCKET_TIMEOUT = "socketTimeout";
	private static String IS_FOLLOW_REDIRECT = "isFollowRedirect";
	private static String IS_INCLUDE_BINARY_CONTENT = "isIncludeBinaryContent";
	private static String IS_INCLUDE_HTTPS_PAGES = "isIncludeHttpsPages";
	
	private static String INDIVIDUAL_STORAGE_FOLDER = "individualStorageFolder";
	private static String POLITENESS_DELAY = "politenessDelay";
	private static String MAX_PAGES_TO_FETCH = "maxPagesToFetch";
	private static String MAX_DEPTH = "maxDepth";
	private static String MAX_OUTGOING_PAGES_TO_FOLLOW = "maxOutgoingPagesToFollow";
	private static String MAX_DOWNLOAD_SIZE = "maxDownloadSize";
	private static String MAX_CONNECTIONS_PER_HOST = "maxConnectionsPerHost";
	private static String MAX_TOTAL_CONNECTIONS = "maxTotalConnections";
	
	private static String PROXY_HOST = "proxyHost";
	private static String PROXY_USERNAME = "proxyUsername";
	private static String PROXY_PASSWORD = "proxyPassword";
	private static String PROXY_PORT = "proxyPort";
	
	private static String USER_AGENT_STRING = "userAgentString";
	private static String CONCURRENT_THREAD = "concurrentThread";
	private static String CRAWLERS_DOMAIN = "crawlersDomain";
	private static String DOMAIN_SEEDERS = "domainSeeders";
	
	private ConfigHandler() {
		
	}
	
	public static ConfigHandler getInstance() {
		if(instance == null) {instance = new ConfigHandler();}	
		checkIfConfigFileExisted();	
		return instance;
	}
	
	public CrawlerSetting getConfigInfo() {
		return getCrawlerSetting();
	}
	
	private static void checkIfConfigFileExisted() {
		File f = new File("setting.xml");
		if(!f.exists()) { 
			createConfigFile();
		}
	}
	
	private static void createConfigFile() {
		try {						
			// Create first crawler configuration
			CrawlerConfig config1 = new CrawlerConfig();
			config1.setIncludeBinaryContent(true);
			config1.setIndividualStorageFolder("crawler1");
			config1.setMaxPagesToFetch(1000);
			config1.setMaxDepth(-1);			
			config1.setConcurrentThread(5);
			
			List<String> crawlersDomain1 = new ArrayList<String>();
			crawlersDomain1.add("https://vi.wikipedia.org/");
			config1.setCrawlersDomain(crawlersDomain1);
			
			List<String> domainSeeders1 = new ArrayList<String>();
			domainSeeders1.add("https://vi.wikipedia.org/");
			domainSeeders1.add("https://vi.wikipedia.org/wiki/C%C3%B4ng_ngh%E1%BB%87");
			config1.setDomainSeeders(domainSeeders1);
			
			// Create second crawler configuration
			CrawlerConfig config2 = new CrawlerConfig();
			config2.setIncludeBinaryContent(true);
			config2.setIndividualStorageFolder("crawler2");
			config2.setMaxPagesToFetch(1000);
			config2.setMaxDepth(-1);			
			config2.setConcurrentThread(6);
			
			List<String> crawlersDomain2 = new ArrayList<String>();
			crawlersDomain2.add("http://www.ibm.com/developerworks/vn/");
			config2.setCrawlersDomain(crawlersDomain2);
			
			List<String> domainSeeders2 = new ArrayList<String>();
			domainSeeders2.add("http://www.ibm.com/developerworks/vn/");			
			config2.setDomainSeeders(domainSeeders2);	
			
			// Create crawler setting and add recent created crawlers' configuration
			CrawlerSetting setting = new CrawlerSetting();
			setting.setServerHost("localhost");
			setting.setCore("new_core");
			setting.setNumberOfCrawlers(2);
			
			List<CrawlerConfig> configs = new ArrayList<CrawlerConfig>();
			configs.add(config1);
			configs.add(config2);
			setting.setConfigs(configs);
			
			/* init jaxb marshaler */
			JAXBContext jaxbContext = JAXBContext.newInstance( CrawlerSetting.class );
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            
            /* set this flag to true to format the output */
            jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );
            
            /* marshaling of java objects in xml (output to file and standard output) */
            jaxbMarshaller.marshal( setting, new File( "setting.xml" ) );
            jaxbMarshaller.marshal( setting, System.out );
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}	  
	}
	
	public static void saveSettingBasedOnRequest(HttpServletRequest request) {
		int numberOfCrawlers = Integer.parseInt(request.getParameterValues(ConfigHandler.NUMBER_OF_CRAWLERS)[0]);										
		
		String[] connectionTimeout = request.getParameterValues(ConfigHandler.CONNECTION_TIMEOUT);
		String[] socketTimeout = request.getParameterValues(ConfigHandler.SOCKET_TIMEOUT);
		
		String[] isFollowRedirect = request.getParameterValues(ConfigHandler.IS_FOLLOW_REDIRECT);
		String[] isIncludeBinaryContent = request.getParameterValues(ConfigHandler.IS_INCLUDE_BINARY_CONTENT);
		String[] isIncludeHttpsPages = request.getParameterValues(ConfigHandler.IS_INCLUDE_HTTPS_PAGES);
		String[] individualStorageFolder = request.getParameterValues(ConfigHandler.INDIVIDUAL_STORAGE_FOLDER);
		
		String[] politenessDelay = request.getParameterValues(ConfigHandler.POLITENESS_DELAY);
		String[] maxPagesToFetch = request.getParameterValues(ConfigHandler.MAX_PAGES_TO_FETCH);
		String[] maxDepth = request.getParameterValues(ConfigHandler.MAX_DEPTH);
		String[] maxOutgoingPagesToFollow = request.getParameterValues(ConfigHandler.MAX_OUTGOING_PAGES_TO_FOLLOW);
		
		String[] maxDownloadSize = request.getParameterValues(ConfigHandler.MAX_DOWNLOAD_SIZE);
		String[] maxConnectionsPerHost = request.getParameterValues(ConfigHandler.MAX_CONNECTIONS_PER_HOST);
		String[] maxTotalConnections = request.getParameterValues(ConfigHandler.MAX_TOTAL_CONNECTIONS);
		String[] proxyHost = request.getParameterValues(ConfigHandler.PROXY_HOST);
		
		String[] proxyUsername = request.getParameterValues(ConfigHandler.PROXY_USERNAME);
		String[] proxyPassword = request.getParameterValues(ConfigHandler.PROXY_PASSWORD);
		String[] proxyPort = request.getParameterValues(ConfigHandler.PROXY_PORT);
		String[] userAgentString = request.getParameterValues(ConfigHandler.USER_AGENT_STRING);
		
		String[] concurrentThread = request.getParameterValues(ConfigHandler.CONCURRENT_THREAD);
		String[] crawlersDomain = request.getParameterValues(ConfigHandler.CRAWLERS_DOMAIN);
		String[] domainSeeders = request.getParameterValues(ConfigHandler.DOMAIN_SEEDERS);
		
		List<CrawlerConfig> configs = new ArrayList<CrawlerConfig>();
		for(int i = 0; i < numberOfCrawlers; i++) {
			CrawlerConfig tmp = new CrawlerConfig();
			
			tmp.setConnectionTimeout(Integer.parseInt(connectionTimeout[i]));
			tmp.setSocketTimeout(Integer.parseInt(socketTimeout[i]));
			tmp.setfollowRedirect(isFollowRedirect[i].equals("on"));
			tmp.setIncludeBinaryContent(isIncludeBinaryContent[i].equals("on"));
			tmp.setIncludeHttpsPages(isIncludeHttpsPages[i].equals("on"));
			tmp.setIndividualStorageFolder(individualStorageFolder[i]);
			
			tmp.setPolitenessDelay(Integer.parseInt(politenessDelay[i]));
			tmp.setMaxPagesToFetch(Integer.parseInt(maxPagesToFetch[i]));
			tmp.setMaxDepth(Integer.parseInt(maxDepth[i]));
			tmp.setMaxOutgoingPagesToFollow(Integer.parseInt(maxOutgoingPagesToFollow[i]));
			
			tmp.setMaxDownloadSize(Integer.parseInt(maxDownloadSize[i]));
			tmp.setMaxConnectionsPerHost(Integer.parseInt(maxConnectionsPerHost[i]));
			tmp.setMaxTotalConnections(Integer.parseInt(maxTotalConnections[i]));
			if(proxyHost[i] != null && !proxyHost[i].isEmpty()) {
				tmp.setProxyHost(proxyHost[i]);
				tmp.setProxyUsername(proxyUsername[i]);
				tmp.setProxyPassword(proxyPassword[i]);
				tmp.setProxyPort(Integer.parseInt(proxyPort[i]));
			}			
			
			tmp.setUserAgentString(userAgentString[i]);
			
			String[] tc = crawlersDomain[i].split("\\s+");
			String[] td = domainSeeders[i].split("\\s+");
									
			List<String> tmpCrawlersDomain = new ArrayList<String>();
			List<String> tmpDomainSeeders = new ArrayList<String>();
			
			for(int j = 0; j < tc.length; j++) {
				if(tc[j] != null && !tc[j].isEmpty()) {
					tmpCrawlersDomain.add(tc[j]);
				}
			}
			
			for(int m = 0; m < tc.length; m++) {
				if(tc[m] != null && !tc[m].isEmpty()) {
					tmpDomainSeeders.add(td[m]);
				}
			}
			
			tmp.setConcurrentThread(Integer.parseInt(concurrentThread[i]));
			tmp.setCrawlersDomain(tmpCrawlersDomain);
			tmp.setDomainSeeders(tmpDomainSeeders);
			configs.add(tmp);
		}
		
		// Create crawler setting
		CrawlerSetting setting = new CrawlerSetting();
		setting.setServerHost(request.getParameterValues(ConfigHandler.SERVER_HOST)[0]);
		setting.setPort(request.getParameterValues(ConfigHandler.PORT)[0]);
		setting.setCore(request.getParameterValues(ConfigHandler.CORE)[0]);
		setting.setSolrPath(request.getParameterValues(ConfigHandler.SOLR_PATH)[0]);
		setting.setNumberOfCrawlers(numberOfCrawlers);
		setting.setCrawlStorageFolder(request.getParameterValues(ConfigHandler.CRAWL_STORAGE_FOLDER)[0]);
		setting.setConfigs(configs);
		
		try {
			/* init jaxb marshaler */
			JAXBContext jaxbContext = JAXBContext.newInstance( CrawlerSetting.class );
	        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	        
	        /* set this flag to true to format the output */
	        jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );
	        
	        /* marshaling of java objects in xml (output to file and standard output) */
	        jaxbMarshaller.marshal( setting, new File( "setting.xml" ) );
	        jaxbMarshaller.marshal( setting, System.out );
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
	}
	
	public CrawlerSetting getCrawlerSetting() {
		CrawlerSetting setting = new CrawlerSetting();
		
		try
        {
            File file = new File( "setting.xml" );
            JAXBContext jaxbContext = JAXBContext.newInstance( CrawlerSetting.class );

            /**
             * the only difference with the marshaling operation is here
             */
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            setting = (CrawlerSetting)jaxbUnmarshaller.unmarshal( file );
            System.out.println( setting );

        }
        catch( JAXBException e )
        {
            e.printStackTrace();
        }
		
		return setting;
	}	
}
