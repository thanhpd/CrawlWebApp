package models;

import java.util.ArrayList;
import java.util.List;

public class Crawler {
	private int maxPagesToFetch;
	private int delay;
	private int concurrentThreads;
	private int maxDepth;
	private int maxTimeoutConnection;
	private int maxTimeoutSocket;
	private boolean isIncludeBinary;
	private String individualFolder;
	private List<String> crawlersDomain = new ArrayList<String>();
	private List<String> domainSeeders = new ArrayList<String>();
	
	public void setMaxPagesToFetch(int input) {
		this.maxPagesToFetch = input;
	}
	public int getMaxPagesToFetch() {
		return this.maxPagesToFetch;
	}
	public void setDelay(int input) {
		this.delay = input;
	}
	public int getDelay() {
		return this.delay;
	}
	public void setConcurrentThreads(int input) {
		this.concurrentThreads = input;
	}
	public int getConcurrentThreads() {
		return this.concurrentThreads;
	}
	public void setMaxDepth(int input) {
		this.maxDepth = input;
	}
	public int getMaxDepth() {
		return this.maxDepth;
	}
	public void setMaxTimeoutConnection(int input) {
		this.maxTimeoutConnection = input;
	}
	public int getMaxTimeoutConnection() {
		return this.maxTimeoutConnection;
	}
	public void setMaxTimeoutSocket(int input) {
		this.maxTimeoutSocket = input;
	}
	public int getMaxTimeoutSocket() {
		return this.maxTimeoutSocket;
	}
	public void setIncludeBinary(boolean input) {
		this.isIncludeBinary = input;
	}
	public boolean isIncludeBinary() {
		return this.isIncludeBinary;
	}
	public void setIndividualFolder(String input) {
		this.individualFolder = input;
	}
	public String getIndividualFolder() {
		return this.individualFolder;
	}
	public void setCrawlersDomain(List<String> crawlersDomain) {
		this.crawlersDomain = crawlersDomain;
	}
	public List<String> getCrawlersDomain() {
		return this.crawlersDomain;
	}
	public void setDomainSeeders(List<String> domainSeeders) {
		this.domainSeeders = domainSeeders;
	}
	public List<String> getDomainSeeders() {
		return this.domainSeeders;
	}
}
