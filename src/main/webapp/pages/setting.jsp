<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  <title>Crawler Configuration</title>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
  <!-- Bootstrap -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

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
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand" href="#">ICrawler</a>
	    </div>
	
	    <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	        <li class="active"><a href="#">Configuration <span class="sr-only">(current)</span></a></li>
	        <li><a href="#">Link</a></li>	        
	      </ul>	      	      
	    </div><!-- /.navbar-collapse -->
	  </div>
	</nav>     
	
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<h3>Solr Config</h3>							
				<div class="input-group">
				  <strong>Server Host</strong>
				  <br />				  
				  <input type="text" class="form-control" placeholder="Server Host" aria-describedby="server-host" value="${crawlerSetting.serverHost}" >
				  <br />
				  <strong>Port</strong>
				  <br />				  
				  <input type="text" class="form-control" placeholder="Port" aria-describedby="port" value="${crawlerSetting.port}" >
				  <br />
				  <strong>Solr Path</strong>
				  <br />				  
				  <input type="text" class="form-control" placeholder="Solr Path" aria-describedby="solr-path" value="${crawlerSetting.solrPath}">
				  <br />
				  <strong>Core Name</strong>
				  <br />				  
				  <input type="text" class="form-control" placeholder="Core Name" aria-describedby="core-name" value="${crawlerSetting.core}">
				</div>
			</div>
			<div class="col-md-8">
			
			</div>
		</div>
	</div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
  </body>
</html>