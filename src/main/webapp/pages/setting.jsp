<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Crawler Configuration</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="config" scope="session" value="${crawlerSetting.configs}"/>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.7.7/css/bootstrap-select.min.css" />

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">ICrawler</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Configuration <span
						class="sr-only">(current)</span></a></li>
				<li><a href="#">Link</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	</nav>

	<div class="container">
		<div class="row">
			<form action="CrawlerConfig" method="POST">
				<div class="col-md-4">
					<h3>Solr Configuration</h3>
					<div class="input-group">
						<strong>Server Host</strong> <br /> <input type="text"
							class="form-control" placeholder="Server Host"
							aria-describedby="server-host"
							value="${crawlerSetting.serverHost}"> <br /> <strong>Port</strong>
						<br /> <input type="text" class="form-control" placeholder="Port"
							aria-describedby="port" value="${crawlerSetting.port}">
						<br /> <strong>Solr Path</strong> <br /> <input type="text"
							class="form-control" placeholder="Solr Path"
							aria-describedby="solr-path" value="${crawlerSetting.solrPath}">
						<br /> <strong>Core Name</strong> <br /> <input type="text"
							class="form-control" placeholder="Core Name"
							aria-describedby="core-name" value="${crawlerSetting.core}">
					</div>
				</div>
				<div class="col-md-8">
					<h3>Crawlers' Setting</h3>
					<div class="input-group">
						<strong>Crawl Storage Folder</strong> <br /> <input type="text"
							class="form-control" placeholder="Crawl Storage Folder"
							aria-describedby="storage-folder"
							value="${crawlerSetting.crawlStorageFolder}">
					</div>
					<div>
						<strong>Number of crawlers</strong> <br /> 
						<select	class="crawler-number" title="${crawlerSetting.numberOfCrawlers}">
							<c:forEach begin="1" end="5" varStatus="loop">
								<option> ${ loop.index }</option>						    
							</c:forEach>
						</select>
						<c:forEach begin="1" end="${crawlerSetting.numberOfCrawlers}" varStatus="loop">
							<c:set var="tmp" scope="session" value="${config[loop.index - 1]}"/>
							<div class="panel panel-primary">
								<div class="panel-heading">Crawler ${ loop.index }</div>
							  	<div class="panel-body">
							    	<div class="col-md-6">
							    		<strong>Connection Timeout</strong> <br />
							    		<input type="text" class="form-control" placeholder="Connection Timeout" aria-describedby="connection-timeout" value="${tmp.connectionTimeout}"> <br />
							    		<strong>socketTimeout</strong> <br />
							    		<input type="text" class="form-control" placeholder="socketTimeout" aria-describedby="socketTimeout" value="${tmp.socketTimeout}"> <br />
							    		<strong>isFollowRedirect</strong>
							    		<c:choose>
							    			<c:when test="${tmp.isFollowRedirect() }">
							    				<input type="checkbox" id="isFollowRedirect" checked /> 
								    		</c:when>
								    		<c:otherwise>
								    			<input type="checkbox" id="isFollowRedirect" />
								    		</c:otherwise>
							    		</c:choose>
							    		<br />
							    		<strong>isIncludeBinaryContent</strong>
							    		<c:choose>
							    			<c:when test="${tmp.isIncludeBinaryContent() }">
							    				<input type="checkbox" id="isIncludeBinaryContent" checked /> 
								    		</c:when>
								    		<c:otherwise>
								    			<input type="checkbox" id="isIncludeBinaryContent" />
								    		</c:otherwise>
							    		</c:choose>
							    		<br />
							    		<strong>isIncludeHttpsPages</strong>
							    		<c:choose>
							    			<c:when test="${tmp.isIncludeHttpsPages() }">
							    				<input type="checkbox" id="isIncludeHttpsPages" checked /> 
								    		</c:when>
								    		<c:otherwise>
								    			<input type="checkbox" id="isIncludeHttpsPages" />
								    		</c:otherwise>
							    		</c:choose>
							    		<br />
							    		<strong>isResumableCrawling</strong>
							    		<c:choose>
							    			<c:when test="${tmp.isResumableCrawling() }">
							    				<input type="checkbox" id="isResumableCrawling" checked /> 
								    		</c:when>
								    		<c:otherwise>
								    			<input type="checkbox" id="isResumableCrawling" />
								    		</c:otherwise>
							    		</c:choose>
							    		<br />
							    		<strong>individualStorageFolder</strong> <br />
							    		<input type="text" class="form-control" placeholder="individualStorageFolder" aria-describedby="individual-storage-folder" value="${tmp.individualStorageFolder}"> <br />
							    		<strong>politenessDelay</strong> <br />
							    		<input type="text" class="form-control" placeholder="politenessDelay" aria-describedby="politeness-delay" value="${tmp.politenessDelay}"> <br />
							    		<strong>maxPagesToFetch</strong> <br />
							    		<input type="text" class="form-control" placeholder="maxPagesToFetch" aria-describedby="maxPagesToFetch" value="${tmp.maxPagesToFetch}"> <br />
							    		<strong>maxDepth</strong> <br />
							    		<input type="text" class="form-control" placeholder="maxDepth" aria-describedby="maxDepth" value="${tmp.maxDepth}"> <br />
							    		<strong>maxOutgoingPagesToFollow</strong> <br />
							    		<input type="text" class="form-control" placeholder="maxOutgoingPagesToFollow" aria-describedby="maxOutgoingPagesToFollow" value="${tmp.maxOutgoingPagesToFollow}"> <br />
							    		<strong>maxDownloadSize</strong> <br />
							    		<input type="text" class="form-control" placeholder="maxDownloadSize" aria-describedby="maxDownloadSize" value="${tmp.maxDownloadSize}"> <br />
							    		<strong>maxConnectionsPerHost</strong> <br />
							    		<input type="text" class="form-control" placeholder="maxConnectionsPerHost" aria-describedby="maxConnectionsPerHost" value="${tmp.maxConnectionsPerHost}"> <br />
							    		<strong>maxTotalConnections</strong> <br />
							    		<input type="text" class="form-control" placeholder="maxTotalConnections" aria-describedby="maxTotalConnections" value="${tmp.maxTotalConnections}"> <br />							    									    		   	
							    	</div>
							    	<div class="col-md-6">
							    		<strong>proxyHost</strong> <br />
							    		<input type="text" class="form-control" placeholder="proxyHost" aria-describedby="proxyHost" value="${tmp.proxyHost}"> <br />
							    		<strong>proxyUsername</strong> <br />
							    		<input type="text" class="form-control" placeholder="proxyUsername" aria-describedby="proxyUsername" value="${tmp.proxyUsername}"> <br />
							    		<strong>proxyPassword</strong> <br />
							    		<input type="text" class="form-control" placeholder="proxyPassword" aria-describedby="proxyPassword" value="${tmp.proxyPassword}"> <br />
							    		<strong>proxyPort</strong> <br />
							    		<input type="text" class="form-control" placeholder="proxyPort" aria-describedby="proxyPort" value="${tmp.proxyPort}"> <br />
							    		<strong>userAgentString</strong> <br />
							    		<input type="text" class="form-control" placeholder="userAgentString" aria-describedby="userAgentString" value="${tmp.userAgentString}"> <br />
							    		<strong>concurrentThread</strong> <br />
							    		<input type="text" class="form-control" placeholder="concurrentThread" aria-describedby="concurrentThread" value="${tmp.concurrentThread}"> <br />
							    	</div>
							  	</div>
							</div>
						</c:forEach>						
					</div>
				</div>
			</form>
		</div>
	</div>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
		integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.7.7/js/bootstrap-select.min.js"></script>
	<script>
    	$('.crawler-number').selectpicker();
    </script>
</body>
</html>