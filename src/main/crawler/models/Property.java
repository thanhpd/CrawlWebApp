package models;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("configuration")
public class Property {
	private String serverHost;
	private String port;
	private String core;
	private String solrPath;
	private String crawlStorageFolder;
	private int numberOfCrawler;
	public List<Crawler> crawlers = new ArrayList();
	
	public Property() {
		
	}
	
	public Property(String host, String port, String core, String solrPath) {
		this.serverHost = host;
		this.port = port;
		this.core = core;
		this.solrPath = solrPath;
	}
	
	public void setProperty(String host, String port, String core, String solrPath) {
		this.serverHost = host;
		this.port = port;
		this.core = core;
		this.solrPath = solrPath;
	}
	
	public void setServerHost(String serverHost) {
		this.serverHost = serverHost;
	}
	
	public void setPort(String port) {
		this.port = port;
	}
	
	public void setCore(String coreName) {
		this.core = coreName;
	}
	
	public void setSolrPath(String solrPath) {
		this.solrPath = solrPath;
	}
	
	public void setStorageFolder(String input) {
		this.crawlStorageFolder = input;
	}
	
	public void setNumberOfCrawlers(String numberOfCrawlers) {
		this.numberOfCrawler = Integer.parseInt(numberOfCrawlers);
	}
	
	public String getServerHost() {
		return this.serverHost;
	}
	
	public String getPort() {
		return this.port;
	}
	
	public String getCore() {
		return this.core;
	}
	
	public String getSolrPath() {
		return this.solrPath;
	}
	
	public String getStorageFolder() {
		return this.crawlStorageFolder;
	}
	
	public int getNumberOfCrawlers() {
		return this.numberOfCrawler;
	}
	
	public String getFullServerHost() {
		String result = "http://" + serverHost + ":" + port + "/" + solrPath + "/" + core;
		return result;
	}
}
