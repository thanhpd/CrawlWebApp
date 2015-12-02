package helper;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import models.CrawlerConfig;


public class Util {
	public static String[] splitString(String input) {
		String[] parts = input.split("|");
		return parts;
	}
	
	public static ArrayList<Integer> getIntegerArray(List<String> stringArray) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(String stringValue : stringArray) {
            try {
                //Convert String to Integer, and store it into integer array list.
                result.add(Integer.parseInt(stringValue));
            } catch(NumberFormatException nfe) {
               //System.out.println("Could not parse " + nfe);
//                Log.w("NumberFormat", "Parsing failed! " + stringValue + " can not be an integer");
            } 
        }       
        return result;
    }
	
	public static String[] getUrlIgnoreList() {
		List<String> tmp = new ArrayList<String>();
		try {
			File file = new File("urlignore.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;			
			while ((line = bufferedReader.readLine()) != null) {				
				tmp.add(line);
			}			
			fileReader.close();
			
			System.out.println("Contents of file:");
			System.out.println(stringBuffer.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return (String[])tmp.toArray();
	}
	
	public static CrawlConfig getConfig(CrawlerConfig c, String storageFolder) {
		CrawlConfig config = new CrawlConfig();
		
		config.setConnectionTimeout(c.getConnectionTimeout());
		config.setCrawlStorageFolder(storageFolder + "/" + c.getIndividualStorageFolder());
		config.setFollowRedirects(c.isFollowRedirect());
		config.setIncludeBinaryContentInCrawling(c.isIncludeBinaryContent());
		config.setIncludeHttpsPages(c.isIncludeHttpsPages());
		config.setMaxConnectionsPerHost(c.getMaxConnectionsPerHost());
		config.setMaxDepthOfCrawling(c.getMaxDepth());
		config.setMaxDownloadSize(c.getMaxDownloadSize());
		config.setMaxOutgoingLinksToFollow(c.getMaxOutgoingPagesToFollow());
		config.setMaxPagesToFetch(c.getMaxPagesToFetch());
		config.setMaxTotalConnections(c.getMaxTotalConnections());
		config.setPolitenessDelay(c.getPolitenessDelay());
		config.setResumableCrawling(c.isResumableCrawling());
		config.setSocketTimeout(c.getSocketTimeout());
		config.setUserAgentString(c.getUserAgentString());
		
		if(c.getProxyHost()!=null && c.getProxyPassword()!=null && c.getProxyUsername()!=null) {
			config.setProxyHost(c.getProxyHost());
			config.setProxyPassword(c.getProxyPassword());
			config.setProxyUsername(c.getProxyUsername());
			config.setProxyPort(c.getProxyPort());
		}
		
		return config;
	}
}
