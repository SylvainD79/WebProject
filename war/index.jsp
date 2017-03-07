<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html lang="en" ng-app="quizApp">

	<head>

	    <title>Who said that on Twitter ?</title>
	
		<meta content="text/html; charset=utf-8" http-equiv="Content-Type"/>
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <meta name="description" content="">
	    <meta name="author" content="">
	
	    <!-- Bootstrap Core CSS -->
	    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	
	    <!-- Custom Fonts -->
	    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
	    <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
	
	    <!-- Plugin CSS -->
	    <link href="vendor/magnific-popup/magnific-popup.css" rel="stylesheet">
	
	    <!-- Theme CSS -->
	    <link href="css/creative.min.css" rel="stylesheet">
	    <link href="css/social-buttons.css" rel="stylesheet"/>
	    
	    <!-- JavaScript -->
        <script src="https://code.jquery.com/jquery-2.0.3.min.js"></script>
        <script data-require="angular.js@1.3.x" src="https://code.angularjs.org/1.3.14/angular.js" data-semver="1.3.14"></script>
        <script src="app.js"></script>

	</head>
	
	<script>
		var init = function() {
	    	var rootApi = 'http://1-dot-projectwebtwitter.appspot.com/_ah/api';
	        gapi.client.load('tweetentityendpoint', 'v1', function() {
	            console.log("todos api loaded");
	        }, rootApi);
	        
	        gapi.client.tweetentityendpoint.listTweetEntity().execute(function(resp) {
	            console.log(resp);
	        });
	    }
     </script>

	<body id="page-top">

		<nav id="mainNav" class="navbar navbar-default navbar-fixed-top">
	        <div class="container-fluid">
	            <!-- Brand and toggle get grouped for better mobile display -->
	            <div class="navbar-header">
	                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
	                    <span class="sr-only">Toggle navigation</span> Menu <i class="fa fa-bars"></i>
	                </button>
	                <a class="navbar-brand page-scroll" href="#page-top">Who said that on Twitter ?</a>
	            </div>
	
	            <!-- Collect the nav links, forms, and other content for toggling -->
	            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	                <ul class="nav navbar-nav navbar-right">
	                    <li>
	                        <a class="page-scroll" href="#topic"><i class="fa fa-2x fa-list"></i>&nbsp;All Quiz Topic</a>
	                    </li>
	                    <tag:loggedin>
	                    	<li>
		                        <a id="highscore1" class="page-scroll" href="#highscore"><i class="fa fa-2x fa-bar-chart"></i>&nbsp;High Score</a>
		                    </li>
		                    <li>
	                       		<a class="page-scroll" href="#tweet"><i class="fa fa-2x fa-twitter"></i>&nbsp;What's Happening ?</a>
	                    	</li> 
	                    </tag:loggedin>
	                    <li>
	                        <a class="page-scroll" href="#github"><i class="fa fa-2x fa-download"></i>&nbsp;Download</a>
	                    </li> 
	                    <li>
	                        <a class="page-scroll" href="#contact"><i class="fa fa-2x fa-group"></i>&nbsp;Contact</a>
	                    </li> 
	                    <tag:notloggedin>
	                    	<li>
	                    		<a href="signin"><i class="fa fa-2x fa-sign-in"></i>&nbsp;Sign In</a>
	                    	</li>
                    	</tag:notloggedin> 
	                    <tag:loggedin>
	                    	<li>
	                    		<a href="./logout"><i class="fa fa-2x fa-power-off"></i>&nbsp;Logout</a>
	                    	</li>
                    	</tag:loggedin> 
	                </ul>
	            </div>
	            <!-- /.navbar-collapse -->
	        </div>
	        <!-- /.container-fluid -->
	    </nav>
    
	    <header>
	        <div class="header-content">
	            <div class="header-content-inner">
	                <h1 id="homeHeading">Do you know all about the current events ?</h1>
	                <hr class="primary">
	                <p>Follower of Twitter ? 
	                Fan of the current events ? 
	                You want to know your level of knowledge ? 
	                This application is made for you ! 
	                Test your knowledge level on the current events of the whole world. 
	                This test proceeds by quiz with different topic.</p>
	                <tag:notloggedin>
		                <a href="signin" class="btn btn-primary btn-xl page-scroll">
		                	<i class="fa fa-twitter"></i>&nbsp;Sign in with Twitter
						</a>
					</tag:notloggedin>
					<tag:loggedin>
						<a href="#start" class="btn btn-primary btn-xl page-scroll">
		                	<i class="fa fa-chevron-down"></i>&nbsp;Get Started
						</a>
					</tag:loggedin>
	            </div>
	        </div>
	    </header>
	    
	    <tag:loggedin>
		    <section class="bg-primary" id="start">
		        <div class="container">
		            <div class="row">
		                <div class="col-lg-8 col-lg-offset-2 text-center">
		               		<h2>Welcome ${twitter.screenName}</h2>
		               		<hr class="light">
		               		<p class="text-faded">
		               		In order to be able to evaluate your level of knowledge you must choose a quiz in the topics proposed. 
		               		The quiz are random and without time. You can also view the high score.</p>
		               		<a href="#topic" class="page-scroll btn btn-default btn-xl sr-button">
			                	<i class="fa fa-chevron-down"></i>&nbsp;All quiz topic
							</a>
							<a id="highscore2" href="#highscore" class="page-scroll btn btn-default btn-xl sr-button">
			                	<i class="fa fa-chevron-down"></i>&nbsp;High Score
							</a>
				    	</div>
		            </div>
		        </div>
		    </section>
	    </tag:loggedin>
	
	    <section id="topic">
	        <div class="container">
	            <div class="row">
	                <div class="col-lg-12 text-center">
	                    <h2 class="section-heading">All Quiz Topic</h2>
	                    <hr class="primary">
	                </div>
	            </div>
	        </div>
	        <div class="container">
	            <div class="row">
	                <div class="col-lg-3 col-md-6 text-center">
	                    <div class="service-box">
	                        <i class="fa fa-4x fa-futbol-o text-primary sr-icons"></i>
	                        <h3>Sport</h3>
	                        <p class="text-muted">
	                        Follower of the sport ?
	                        This quiz will evaluate your knowledge about the sport topic.</p>
	                        <tag:loggedin>
	                        	<br>
		                        <a id="Sport" href="#quiz" class="btn btn-primary btn-xl page-scroll">
				                	<i class="fa fa-chevron-down"></i>&nbsp;Get Started
								</a>
							</tag:loggedin>
	                    </div>
	                </div>
	                <div class="col-lg-3 col-md-6 text-center">
	                    <div class="service-box">
	                        <i class="fa fa-4x fa-tv text-primary sr-icons"></i>
	                        <h3>Television</h3>
	                        <p class="text-muted">
	                        Know all about the television ? 
	                        This quiz will evaluate your knowledge about the television's celebrities.</p>
	                        <tag:loggedin>
	                        	<br>
	                        	<a id="Television" href="#quiz" class="btn btn-primary btn-xl page-scroll">
			                		<i class="fa fa-chevron-down"></i>&nbsp;Get Started
								</a>
							</tag:loggedin>
	                    </div>
	                </div>
	                <div class="col-lg-3 col-md-6 text-center">
	                    <div class="service-box">
	                        <i class="fa fa-4x fa-balance-scale text-primary sr-icons"></i>
	                        <h3>Policy</h3>
	                        <p class="text-muted">
	                        Interest in the policy ?
	                        This quiz will evaluate your knowledge about the political topic.</p>
	                        <tag:loggedin>
	                        	<br>
	                        	<a id="Policy" href="#quiz" class="btn btn-primary btn-xl page-scroll">
			                		<i class="fa fa-chevron-down"></i>&nbsp;Get Started
								</a>
							</tag:loggedin>
	                    </div>
	                </div>
	                <div class="col-lg-3 col-md-6 text-center">
	                    <div class="service-box">
	                        <i class="fa fa-4x fa-gamepad text-primary sr-icons"></i>
	                        <h3>Game</h3>
	                        <p class="text-muted">
	                        You are player ?
	                        This quiz will evaluate your knowledge about the game topic.</p>
	                        <tag:loggedin>
	                        	<br>
	                        	<a id="Game" href="#quiz" class="btn btn-primary btn-xl page-scroll">
			                		<i class="fa fa-chevron-down"></i>&nbsp;Get Started
								</a>
							</tag:loggedin>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </section>
	    
	    <section id="quiz" class="bg-dark" style="display: none">
	        <div class="container text-center">
	            <div class="call-to-action">
	                <h2 id="title">Quiz</h2>
	                <hr class="light">
	                <quiz/>
	            </div>
	        </div>
	    </section> 
	    <script>
	        var title = $("#title").text();
	        $( "#Sport,#Television,#Policy,#Game" ).click(function() {
	        	var t1 = title + " " + $(this).attr("id");
	          	var t2 = $("#title").text();
	          	if ((t1 != t2) && (t2 != title)) {
	          		if ($('#quiz').is(':visible')) {
	            		$( "#quiz" ).toggle();
	          		}
	          	}
	          	$( "#quiz" ).toggle("slow");
	          	var x = $(this).attr("id");
	          	document.getElementById('title').innerHTML = title + " " + x;
	        });
      	</script>
      	
      	<section id="highscore" class="bg-info" style="display: none">
	        <div class="container text-center">
	            <div class="call-to-action">
	                <h2 id="title">High Score</h2>
	                <hr class="light">
	                <p class="text-faded">Here you can view the high score.</p>
	            </div>
	        </div>
	    </section> 
	    <script>
	        $( "#highscore1,#highscore2" ).click(function() {
	          	$( "#highscore" ).toggle("slow");
	        });
      	</script>
	    
	    <tag:loggedin>
		    <section id="tweet" class="bg-primary">
		        <div class="container text-center">
		            <div class="call-to-action">
		                <h2>What's happening ?</h2>
		                <form action="./post" method="post">
			    			<div class="form-group">
								<textarea class="form-control" rows="3" name="text">#WhoSaidThatOnTwitter</textarea>
							</div>
			    			<button type="submit" class="page-scroll btn btn-default btn-xl sr-button">
			    				<i class="fa fa-paper-plane"></i>&nbsp;Tweet
			    			</button>
						</form>
		            </div>
		        </div>
		    </section>
	    </tag:loggedin>
	    
		<section id="github" class="bg-dark">
	        <div class="container text-center">
	            <div class="call-to-action">
	                <h2>Free Download at GitHub</h2>
	                <hr class="light">
	                <p class="text-faded">It is possible if you wish to recover the sources on the GitHub platform.</p>
	                <a href="https://github.com/SylvainD79/WebProject">
		                <i class="fa fa-github fa-3x sr-contact"></i>MIAGE Master Project
	                </a>
	            </div>
	        </div>
	    </section>
	
	    <section id="contact">
	        <div class="container">
	            <div class="row">
	                <div class="col-lg-8 col-lg-offset-2 text-center">
	                    <h2 class="section-heading">Thank you !</h2>
	                    <hr class="primary">
	                    <p class="text-muted">Thank you for your participation ! 
	                    We would like to have your opinion ! 
	                    You can contact us ! Do not hesitate to share the link or the hashtag <b>#WhoSaidThatOnTwitter</b>.
	                    </p>
                    </div>
                    <br>
	                <div class="col-lg-4 col-md-6 text-center">
	                    <i class="fa fa-user fa-4x sr-contact"></i>
	                    <p class="text-muted">Axel BOUTET</p>
	                    <p><a href="https://twitter.com/axelnantes?lang=fr"><i class="fa fa-twitter-square fa-2x sr-contact"></i>&nbsp;@axelnantes</a></p>
                    	<p><a href="mailto:axel.boutet@etu.univ-nantes.fr"><i class="fa fa-envelope-o fa-2x sr-contact"></i>&nbsp;Send Mail</a></p>
                    </div>
					<div class="col-lg-4 col-md-6 text-center">
	                    <i class="fa fa-user fa-4x sr-contact"></i>
	                    <p class="text-muted">Sylvain DAVID</p>
	                    <p><a href="https://twitter.com/SylvainD79?lang=fr"><i class="fa fa-twitter-square fa-2x sr-contact"></i>&nbsp;@SylvainD79</a></p>
                    	<p><a href="mailto:sylvain.david@etu.univ-nantes.fr"><i class="fa fa-envelope-o fa-2x sr-contact"></i>&nbsp;Send Mail</a></p>
                    </div>
					<div class="col-lg-4 col-md-6 text-center">
	                    <i class="fa fa-user fa-4x sr-contact"></i>
	                    <p class="text-muted">Laure DUCHEMIN</p>
	                    <p><a href="https://twitter.com/ducheminlaure?lang=fr"><i class="fa fa-twitter-square fa-2x sr-contact"></i>&nbsp;@DucheminLaure</a></p>
                    	<p><a href="mailto:laure.duchemin@etu.univ-nantes.fr"><i class="fa fa-envelope-o fa-2x sr-contact"></i>&nbsp;Send Mail</a></p>
                    </div>
	            </div>
	        </div>
	    </section>
	       
	    <!-- jQuery -->
	    <script src="vendor/jquery/jquery.min.js"></script>
	
	    <!-- Bootstrap Core JavaScript -->
	    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
	
	    <!-- Plugin JavaScript -->
	    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
	    <script src="vendor/scrollreveal/scrollreveal.min.js"></script>
	    <script src="vendor/magnific-popup/jquery.magnific-popup.min.js"></script>
	
	    <!-- Theme JavaScript -->
	    <script src="js/creative.min.js"></script>
        
	</body>

</html>