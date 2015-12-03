package helper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import models.CrawlerConfig;
import models.CrawlerSetting;

public class ConfigHandler {
	private static ConfigHandler instance = null;
	
	private ConfigHandler() {
		
	}
	
	public static ConfigHandler getInstance() {
		if(instance == null) instance = new ConfigHandler();	
		checkIfConfigFileExisted();	
		return instance;
	}
	
	public CrawlerSetting getConfigInfo() {
		return getCrawlerSetting();
	}
	
	private static void checkIfConfigFileExisted() {
		File f = new File("setting.xml");
		if(!(f.exists() && !f.isDirectory())) { 
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
			config2.setIndividualStorageFolder("crawler1");
			config2.setMaxPagesToFetch(1000);
			config2.setMaxDepth(-1);			
			config2.setConcurrentThread(5);
			
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
