package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

//@XmlRootElement (name = "CrawlerConfig")
public class CrawlerConfig implements Serializable {
	private int connectionTimeout;
	
	private boolean isFollowRedirect;
	private boolean isIncludeBinaryContent;
	private boolean isIncludeHttpsPages;
	private boolean isResumableCrawling;
	
	private String individualStorageFolder;
	private int politenessDelay;
	
	private int maxPagesToFetch;
	private int maxDepth;
	private int maxOutgoingPagesToFollow;
	private int maxDownloadSize;
	private int maxConnectionsPerHost;
	private int maxTotalConnections;
	
	private int socketTimeout;
	
	private String proxyHost;
	private String proxyUsername;
	private String proxyPassword;
	private int proxyPort;
	
	private String userAgentString;
	
	private int concurrentThread = 5;
	private List<String> crawlersDomain = new ArrayList<String>();
	private List<String> domainSeeders = new ArrayList<String>();
	
	public CrawlerConfig() {
		connectionTimeout = 30000;
		
		isFollowRedirect = true;
		isIncludeBinaryContent = false;
		isIncludeHttpsPages = true;
		isResumableCrawling = false;
		
		individualStorageFolder = "";
		politenessDelay = 1000;
		
		maxPagesToFetch = 1000;
		maxDepth = 2;
		maxOutgoingPagesToFollow = 1000;
		maxDownloadSize = 1048576;
		maxConnectionsPerHost = 100;
		maxTotalConnections = 100;
		
		socketTimeout = 20000;
		
		proxyPort = 80;
		proxyUsername = null;
		proxyPassword = null;
		proxyHost = null;
		
		userAgentString = "crawler4j (http://code.google.com/p/crawler4j/)";
	}
	
	/**
	 * @return the connectionTimeout
	 */
	public int getConnectionTimeout() {
		return connectionTimeout;
	}

	/**
	 * @param connectionTimeout the connectionTimeout to set
	 */
//	@XmlElement (name = "connectionTimeout")
	public void setConnectionTimeout(int connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
	}

	/**
	 * @return the isIncludeBinaryContent
	 */
	public boolean isIncludeBinaryContent() {
		return isIncludeBinaryContent;
	}

	/**
	 * @param isIncludeBinaryContent the isIncludeBinaryContent to set
	 */
//	@XmlElement (name = "isIncludeBinaryContent")
	public void setIncludeBinaryContent(boolean isIncludeBinaryContent) {
		this.isIncludeBinaryContent = isIncludeBinaryContent;
	}

	/**
	 * @return the isFollowRedirect
	 */
	public boolean isFollowRedirect() {
		return isFollowRedirect;
	}

	/**
	 * @param isfollowRedirect the isfollowRedirect to set
	 */
//	@XmlElement (name = "isFollowRedirect")
	public void setfollowRedirect(boolean isfollowRedirect) {
		this.isFollowRedirect = isfollowRedirect;
	}

	/**
	 * @return the isIncludeHttpsPages
	 */
	public boolean isIncludeHttpsPages() {
		return isIncludeHttpsPages;
	}

	/**
	 * @param isIncludeHttpsPages the isIncludeHttpsPages to set
	 */
//	@XmlElement (name = "isIncludeHttpsPages")
	public void setIncludeHttpsPages(boolean isIncludeHttpsPages) {
		this.isIncludeHttpsPages = isIncludeHttpsPages;
	}

	/**
	 * @return the isResumableCrawling
	 */
	public boolean isResumableCrawling() {
		return isResumableCrawling;
	}

	/**
	 * @param isResumableCrawling the isResumableCrawling to set
	 */
//	@XmlElement (name = "isResumableCrawling")
	public void setResumableCrawling(boolean isResumableCrawling) {
		this.isResumableCrawling = isResumableCrawling;
	}

	/**
	 * @return the individualStorageFolder
	 */
	public String getIndividualStorageFolder() {
		return individualStorageFolder;
	}

	/**
	 * @param individualStorageFolder the individualStorageFolder to set
	 */
//	@XmlElement (name = "individualStorageFolder")
	public void setIndividualStorageFolder(String individualStorageFolder) {
		this.individualStorageFolder = individualStorageFolder;
	}

	/**
	 * @return the politenessDelay
	 */
	public int getPolitenessDelay() {
		return politenessDelay;
	}

	/**
	 * @param politenessDelay the politenessDelay to set
	 */
//	@XmlElement (name = "politenessDelay")
	public void setPolitenessDelay(int politenessDelay) {
		this.politenessDelay = politenessDelay;
	}

	/**
	 * @return the maxPagesToFetch
	 */
	public int getMaxPagesToFetch() {
		return maxPagesToFetch;
	}

	/**
	 * @param maxPagesToFetch the maxPagesToFetch to set
	 */
//	@XmlElement (name = "maxPagesToFetch")
	public void setMaxPagesToFetch(int maxPagesToFetch) {
		this.maxPagesToFetch = maxPagesToFetch;
	}

	/**
	 * @return the maxDepth
	 */
	public int getMaxDepth() {
		return maxDepth;
	}

	/**
	 * @param maxDepth the maxDepth to set
	 */
//	@XmlElement (name = "maxDepth")
	public void setMaxDepth(int maxDepth) {
		this.maxDepth = maxDepth;
	}

	/**
	 * @return the maxOutgoingPagesToFollow
	 */
	public int getMaxOutgoingPagesToFollow() {
		return maxOutgoingPagesToFollow;
	}

	/**
	 * @param maxOutgoingPagesToFollow the maxOutgoingPagesToFollow to set
	 */
//	@XmlElement (name = "maxOutgoingPagesToFollow")
	public void setMaxOutgoingPagesToFollow(int maxOutgoingPagesToFollow) {
		this.maxOutgoingPagesToFollow = maxOutgoingPagesToFollow;
	}

	/**
	 * @return the maxDownloadSize
	 */
	public int getMaxDownloadSize() {
		return maxDownloadSize;
	}

	/**
	 * @param maxDownloadSize the maxDownloadSize to set
	 */
//	@XmlElement (name = "maxDownloadSize")
	public void setMaxDownloadSize(int maxDownloadSize) {
		this.maxDownloadSize = maxDownloadSize;
	}

	/**
	 * @return the socketTimeout
	 */
	public int getSocketTimeout() {
		return socketTimeout;
	}

	/**
	 * @param socketTimeout the socketTimeout to set
	 */
//	@XmlElement (name = "socketTimeout")
	public void setSocketTimeout(int socketTimeout) {
		this.socketTimeout = socketTimeout;
	}

	/**
	 * @return the proxyHost
	 */
	public String getProxyHost() {
		return proxyHost;
	}

	/**
	 * @param proxyHost the proxyHost to set
	 */
//	@XmlElement (name = "proxyHost")
	public void setProxyHost(String proxyHost) {
		this.proxyHost = proxyHost;
	}

	/**
	 * @return the proxyUsername
	 */
	public String getProxyUsername() {
		return proxyUsername;
	}

	/**
	 * @param proxyUsername the proxyUsername to set
	 */
	public void setProxyUsername(String proxyUsername) {
		this.proxyUsername = proxyUsername;
	}

	/**
	 * @return the proxyPassword
	 */
	public String getProxyPassword() {
		return proxyPassword;
	}

	/**
	 * @param proxyPassword the proxyPassword to set
	 */
	public void setProxyPassword(String proxyPassword) {
		this.proxyPassword = proxyPassword;
	}

	/**
	 * @return the proxyPort
	 */
	public int getProxyPort() {
		return proxyPort;
	}

	/**
	 * @param proxyPort the proxyPort to set
	 */
	public void setProxyPort(int proxyPort) {
		this.proxyPort = proxyPort;
	}

	/**
	 * @return the userAgentString
	 */
	public String getUserAgentString() {
		return userAgentString;
	}

	/**
	 * @param userAgentString the userAgentString to set
	 */
	public void setUserAgentString(String userAgentString) {
		this.userAgentString = userAgentString;
	}

	/**
	 * @return the maxConnectionsPerHost
	 */
	public int getMaxConnectionsPerHost() {
		return maxConnectionsPerHost;
	}

	/**
	 * @param maxConnectionsPerHost the maxConnectionsPerHost to set
	 */
	public void setMaxConnectionsPerHost(int maxConnectionsPerHost) {
		this.maxConnectionsPerHost = maxConnectionsPerHost;
	}

	/**
	 * @return the maxTotalConnections
	 */
	public int getMaxTotalConnections() {
		return maxTotalConnections;
	}

	/**
	 * @param maxTotalConnections the maxTotalConnections to set
	 */
	public void setMaxTotalConnections(int maxTotalConnections) {
		this.maxTotalConnections = maxTotalConnections;
	}

	/**
	 * @return the concurrentThread
	 */
	public int getConcurrentThread() {
		return concurrentThread;
	}

	/**
	 * @param concurrentThread the concurrentThread to set
	 */
	public void setConcurrentThread(int concurrentThread) {
		this.concurrentThread = concurrentThread;
	}

	/**
	 * @return the crawlersDomain
	 */
	public List<String> getCrawlersDomain() {
		return crawlersDomain;
	}

	/**
	 * @param crawlersDomain the crawlersDomain to set
	 */
	public void setCrawlersDomain(List<String> crawlersDomain) {
		this.crawlersDomain = crawlersDomain;
	}

	/**
	 * @return the domainSeeders
	 */
	public List<String> getDomainSeeders() {
		return domainSeeders;
	}

	/**
	 * @param domainSeeders the domainSeeders to set
	 */
	public void setDomainSeeders(List<String> domainSeeders) {
		this.domainSeeders = domainSeeders;
	}	
}
