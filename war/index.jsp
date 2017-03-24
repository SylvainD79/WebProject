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
	    <link href="vendor/csshake/csshake.min.css" rel="stylesheet">
	
	    <!-- Custom Fonts -->
	    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
	    <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
	
	    <!-- Plugin CSS -->
	    <link href="vendor/magnific-popup/magnific-popup.css" rel="stylesheet">
	
	    <!-- Theme CSS -->
	    <link href="css/creative.min.css" rel="stylesheet">
	    <link href="css/social-buttons.css" rel="stylesheet"/>
	    <link href="css/style.css" rel="stylesheet"/>
	    
	    <!-- JavaScript -->
	    <script src="https://code.jquery.com/jquery-2.0.3.min.js"></script>
        <script data-require="angular.js@1.5.x" src="https://code.angularjs.org/1.5.8/angular.min.js" data-semver="1.5.8"></script>
        <script src="js/angular-google-gapi-1.0.1/dist/angular-google-gapi.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="js/app.js"></script>

	</head>

	<body id="page-top" ng-controller="tweetController">

		<nav id="mainNav" class="navbar navbar-default navbar-fixed-top">
	        <div class="container-fluid">
	            <!-- Brand and toggle get grouped for better mobile display -->
	            <div class="navbar-header">
	                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
	                    <span class="sr-only">Toggle navigation</span>Menu<i class="fa fa-bars"></i>
	                </button>
	                <a class="navbar-brand page-scroll" href="#page-top">Who said that on Twitter ?</a>
	            </div>
	
	            <!-- Collect the nav links, forms, and other content for toggling -->
	            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	                <ul class="nav navbar-nav navbar-right">
	                    <li>
	                        <a class="page-scroll" href="#topic"><i class="fa fa-2x fa-th-large"></i>&nbsp;All Quiz Topic</a>
	                    </li>
                    	<li ng-show="currentUser">
	                        <a id="allquiz1" class="page-scroll" href="#quiz"><i class="fa fa-2x fa-list"></i>&nbsp;Quiz</a>
	                    </li>
                    	<li ng-show="currentUser">
	                        <a id="highscore1" class="page-scroll" href="#highscore"><i class="fa fa-2x fa-bar-chart"></i>&nbsp;High Score</a>
	                    </li>
	                    <li ng-show="currentUser">
                       		<a class="page-scroll" href="#tweet"><i class="fa fa-2x fa-twitter"></i>&nbsp;What's Happening ?</a>
                    	</li> 
                    	<tag:loggedin>
                    		<li ng-show="currentUser">
                       			<a href="https://twitter.com/" target="_blank" class="page-scroll"><i class="fa fa-2x fa-twitter"></i>&nbsp;${twitter.screenName}</a>
                    		</li> 
                    	</tag:loggedin>
	                    <li>
	                        <a class="page-scroll" href="#github"><i class="fa fa-2x fa-download"></i>&nbsp;Download</a>
	                    </li> 
	                    <li>
	                        <a class="page-scroll" href="#contact"><i class="fa fa-2x fa-group"></i>&nbsp;Contact</a>
	                    </li> 
                    	<li ng-show="!currentUser">
                        	<a class="page-scroll" ng-click="signIn()"><i class="fa fa-2x fa-sign-in"></i>&nbsp;Sign in</a>
                    	</li> 
                    	<li ng-show="currentUser">
                        	<a id="logout" class="page-scroll" ng-click="logout()"><i class="fa fa-2x fa-power-off"></i>&nbsp;Logout</a>
                    	</li> 
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
	                <div ng-show="!currentUser">
	                	<div class="shake-slow shake-constant shake-constant--hover">
	                		<a class="btn btn-primary btn-xl page-scroll" ng-click="signIn()">
			                	<i class="fa fa-google"></i>&nbsp;Sign in with Google
							</a>
						</div>
					</div>
					<div ng-show="currentUser">
						<div class="shake-slow shake-constant shake-constant--hover">
							<a href="#start" class="btn btn-primary btn-xl page-scroll">
			                	<i class="fa fa-chevron-down"></i>&nbsp;Get Started
							</a>
						</div>
					</div>
	            </div>
	        </div>
	    </header>
	    
	    <section class="bg-primary" id="start" ng-show="currentUser">
	        <div class="container">
	            <div class="row">
	                <div class="col-lg-8 col-lg-offset-2 text-center">
	               		<h2>Welcome {{currentUser.name}}</h2>
	               		<hr class="light">
	               		<p class="text-faded">
	               		In order to be able to evaluate your level of knowledge you must choose a quiz in the topics proposed. 
	               		The quiz are random and with time. You can also view the high score.</p>
	               		<a href="#topic" class="page-scroll btn btn-default btn-xl sr-button">
		                	<i class="fa fa-chevron-down"></i>&nbsp;All quiz topic
						</a>
						&nbsp;
						<a id="highscore2" href="#highscore" class="page-scroll btn btn-default btn-xl sr-button">
		                	<i class="fa fa-chevron-down"></i>&nbsp;High Score
						</a>
			    	</div>
	            </div>
	        </div>
	    </section>
	
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
	                    </div>
	                </div>
	                <div class="col-lg-3 col-md-6 text-center">
	                    <div class="service-box">
	                        <i class="fa fa-4x fa-tv text-primary sr-icons"></i>
	                        <h3>Television</h3>
	                        <p class="text-muted">
	                        Know all about the television ? 
	                        This quiz will evaluate your knowledge about the television's celebrities.</p>
	                    </div>
	                </div>
	                <div class="col-lg-3 col-md-6 text-center">
	                    <div class="service-box">
	                        <i class="fa fa-4x fa-balance-scale text-primary sr-icons"></i>
	                        <h3>Policy</h3>
	                        <p class="text-muted">
	                        Interest in the policy ?
	                        This quiz will evaluate your knowledge about the political topic.</p>
	                    </div>
	                </div>
	                <div class="col-lg-3 col-md-6 text-center">
	                    <div class="service-box">
	                        <i class="fa fa-4x fa-gamepad text-primary sr-icons"></i>
	                        <h3>Game</h3>
	                        <p class="text-muted">
	                        You are player ?
	                        This quiz will evaluate your knowledge about the game topic.</p>
	                    </div>
	                </div>
	            </div>
	        </div>
	        <div class="container">
	            <div class="row">
	                <div class="col-lg-8 col-lg-offset-2 text-center">
	                	<div ng-show="currentUser">
		                	<br>
							<a id="allquiz2" href="#quiz" class="btn btn-primary btn-xl page-scroll">
			                	<i class="fa fa-chevron-down"></i>&nbsp;Choose Quiz
							</a>
						</div>
			    	</div>
	            </div>
	        </div>
	    </section>
	    
	    <section id="quiz" class="bg-dark" style="display: none">  
	    	<quiz><div class="container text-center"><h2>Quiz is loading ...</h2></div></quiz>
	    </section> 
	    <script>
	        $( "#allquiz1,#allquiz2" ).click(function() {
	        	if($("#highscore").is(":visible")) {
	        		$( "#highscore" ).toggle("slow");
	        	}
	          	$( "#quiz" ).toggle("slow");
	        });
	        $( "#logout" ).click(function() {
	        	if($("#quiz").is(":visible")) {
	        		$( "#quiz" ).toggle("slow");
	        	}
	        });
      	</script>
      	
      	<section id="highscore" class="bg-info" style="display: none">
	        <highscore><div class="container text-center"><h2>High Score is loading ...</h2></div></highscore>
	    </section> 
	    <script>
	        $( "#highscore1,#highscore2" ).click(function() {
	        	if($("#quiz").is(":visible")) {
	        		$( "#quiz" ).toggle("slow");
	        	}
	          	$( "#highscore" ).toggle("slow");
	        });
	        $( "#logout" ).click(function() {
	        	if($("#highscore").is(":visible")) {
	        		$( "#highscore" ).toggle("slow");
	        	}
	        });
      	</script>
	    
	    <div ng-show="currentUser">
		    <section id="tweet" class="bg-primary">
		        <div class="container text-center">
		            <div class="call-to-action">
		                <h2>What's happening ?</h2>
		                <hr class="light">
		                <tag:notloggedin>
			                <p class="text-faded">
		               		If you want to send tweet or share your quiz score you must first authorize our application to join your twitter account.</p>
							<a href="/signin" class="page-scroll btn btn-default btn-xl sr-button">
			                	<i class="fa fa-twitter"></i>&nbsp;Twitter authorization
							</a>
		                </tag:notloggedin>
		                <tag:loggedin>
		               		<p class="text-faded">
		               		You can post what you want on twitter thanks to the box below. 
		               		By applying the hashtag <b>#WhoSaidThatOnTwitter</b> we can see your tweets more easily. 
		               		In the future we can create a quiz with your tweet containing this hashtag.(140 characters max)</p>
			                <form action="./post" method="post">
				    			<div class="form-group">
									<textarea class="form-control" rows="3" name="text" maxlength="140">#WhoSaidThatOnTwitter</textarea>
								</div>
				    			<button type="submit" class="page-scroll btn btn-default btn-xl sr-button">
				    				<i class="fa fa-paper-plane"></i>&nbsp;Tweet
				    			</button>
							</form>
						</tag:loggedin>
		            </div>
		        </div>
		    </section>
	    </div>
	    
		<section id="github" class="bg-dark">
	        <div class="container text-center">
	            <div class="call-to-action">
	                <h2>Free Download at GitHub</h2>
	                <hr class="light">
	                <p class="text-faded">It is possible if you wish to recover the sources on the GitHub platform.</p>
	                <a href="https://github.com/SylvainD79/WebProject">
		                <i class="fa fa-github fa-3x sr-contact"></i>&nbsp;MIAGE Master Project
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
	    
	    <!-- 
	    <section id="topic" class="bg-dark">
	    	<div class="container">
	            <div class="row">
	                <div class="col-lg-12 text-center">
	                    <h2 class="section-heading">Test</h2>
	                    <hr class="light">
	                </div>
	            </div>
	        </div>
	        <div class="container">
	            <div class="row">
	                <div class="col-lg-3 col-md-6 text-center">
	                    <div class="service-box">
	                        <a href="/quiz/sport" class="btn btn-primary btn-xl page-scroll">
			                	<i class="fa fa-futbol-o"></i>&nbsp;Sport
							</a>
	                    </div>
	                </div>
	                <div class="col-lg-3 col-md-6 text-center">
	                    <div class="service-box">
                        	<a href="/quiz/television" class="btn btn-primary btn-xl page-scroll">
		                		<i class="fa fa-tv"></i>&nbsp;Television
							</a>
	                    </div>
	                </div>
	                <div class="col-lg-3 col-md-6 text-center">
	                    <div class="service-box">
                        	<a href="/quiz/policy" class="btn btn-primary btn-xl page-scroll">
		                		<i class="fa fa-balance-scale"></i>&nbsp;Policy
							</a>
	                    </div>
	                </div>
	                <div class="col-lg-3 col-md-6 text-center">
	                    <div class="service-box">
                        	<a href="/quiz/gaming" class="btn btn-primary btn-xl page-scroll">
		                		<i class="fa fa-gamepad"></i>&nbsp;Game
							</a>
	                    </div>
	                </div> 
	            </div>
	        </div>
	    </section>
	    -->
	       
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
