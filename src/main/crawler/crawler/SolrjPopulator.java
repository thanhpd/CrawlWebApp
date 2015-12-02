package crawler;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;

import helper.ConfigHandler;
import models.CrawlerSetting;
import models.Property;

public class SolrjPopulator {
	private static SolrjPopulator instance = null;
	private HttpSolrServer server;
	
	private static ConfigHandler configHandler = ConfigHandler.getInstance();
	private static CrawlerSetting prop = configHandler.getConfigInfo();
	
	private SolrjPopulator() {
		String solrServer = prop.getSolrServerHost();		
		server = new HttpSolrServer(solrServer);
	}
		
	public static SolrjPopulator getInstance() {
		if(instance == null) instance = new SolrjPopulator();
		return instance;
	}
	
	public void addNewDocument(SolrInputDocument doc) throws SolrServerException, IOException {
		server.add(doc);
	}
	
	public void addNewDocument(List<SolrInputDocument> docList) {
		try {
			server.add(docList);
			server.commit();
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void serverCommit() throws SolrServerException, IOException {
		server.commit();
	}	
}
