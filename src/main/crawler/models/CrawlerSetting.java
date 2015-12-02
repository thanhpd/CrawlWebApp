package models;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement (name = "CrawlerSetting")
public class CrawlerSetting {
	private String serverHost;
	private String port = "8983";
	private String core;
	private String solrPath = "solr";
	private String crawlStorageFolder = "/data/crawl/root";
	private int numberOfCrawlers = 1;
	private List<CrawlerConfig> configs = new ArrayList<CrawlerConfig>();
	
	public CrawlerSetting() {
		
	}
	
	public String getSolrServerHost() {
		String result = "http://" + serverHost + ":" + port + "/" + solrPath + "/" + core;
		return result;
	}
	
	/**
	 * @return the serverHost
	 */
	public String getServerHost() {
		return serverHost;
	}
	/**
	 * @param serverHost the serverHost to set
	 */
	@XmlElement (name = "serverHost")
	public void setServerHost(String serverHost) {
		this.serverHost = serverHost;
	}
	/**
	 * @return the port
	 */
	public String getPort() {
		return port;
	}
	/**
	 * @param port the port to set
	 */
	@XmlElement (name = "port")
	public void setPort(String port) {
		this.port = port;
	}
	/**
	 * @return the core
	 */
	public String getCore() {
		return core;
	}
	/**
	 * @param core the core to set
	 */
	@XmlElement (name = "core")
	public void setCore(String core) {
		this.core = core;
	}
	/**
	 * @return the solrPath
	 */
	public String getSolrPath() {
		return solrPath;
	}
	/**
	 * @param solrPath the solrPath to set
	 */
	@XmlElement (name = "solrPath")
	public void setSolrPath(String solrPath) {
		this.solrPath = solrPath;
	}
	/**
	 * @return the crawlStorageFolder
	 */
	public String getCrawlStorageFolder() {
		return crawlStorageFolder;
	}
	/**
	 * @param crawlStorageFolder the crawlStorageFolder to set
	 */
	@XmlElement (name = "crawlStorageFolder")
	public void setCrawlStorageFolder(String crawlStorageFolder) {
		this.crawlStorageFolder = crawlStorageFolder;
	}
	/**
	 * @return the numberOfCrawlers
	 */
	public int getNumberOfCrawlers() {
		return numberOfCrawlers;
	}
	/**
	 * @param numberOfCrawlers the numberOfCrawlers to set
	 */
	@XmlElement (name = "numberOfCrawlers")
	public void setNumberOfCrawlers(int numberOfCrawlers) {
		this.numberOfCrawlers = numberOfCrawlers;
	}

	/**
	 * @return the configs
	 */	
	public List<CrawlerConfig> getConfigs() {
		return configs;
	}

	/**
	 * @param configs the configs to set
	 */
	@XmlElement (name = "CrawlerConfigs")
	public void setConfigs(List<CrawlerConfig> configs) {
		this.configs = configs;
	}

	
}
