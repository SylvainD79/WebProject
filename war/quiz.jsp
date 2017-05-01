<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<div class="container text-center">
	<div class="call-to-action">
		<h2 id="title" ng-show="!inProgress">Quiz {{quizName}}</h2>
		<div ng-show="inProgress">
			<h1 ng-show="!quizOver">
				<timer autostart="false" interval="1000">{{timer}}</timer>
			</h1>
			<h2 ng-show="quizOver">Quiz is over</h2>
		</div>
		<hr class="light">
	</div>
</div>

<div class="container text-center" ng-show="!topicChoice">	
	<p class="text-faded">Please select a quiz from the list of candidates to evaluate your knowledge.</p>
	<div class="container">
		<div class="row">
	    	<div class="col-lg-3 col-md-6 text-center">
	        	<div class="service-box">
					<a id="Sport" class="btn btn-primary btn-xl page-scroll" ng-click="choiceTopic('sport')">
				    	<i class="fa fa-futbol-o"></i>&nbsp;Sport Quiz
					</a>
				</div>
			</div>
	    	<div class="col-lg-3 col-md-6 text-center">
	        	<div class="service-box">
					<a id="Television" class="btn btn-primary btn-xl page-scroll" ng-click="choiceTopic('television')">
						<i class="fa fa-tv"></i>&nbsp;Television Quiz
					</a>
				</div>
			</div>
			<div class="col-lg-3 col-md-6 text-center">
	        	<div class="service-box">
					<a id="Policy" class="btn btn-primary btn-xl page-scroll" ng-click="choiceTopic('politique')">
				    	<i class="fa fa-balance-scale"></i>&nbsp;Policy Quiz
					</a>
				</div>
			</div>
			<div class="col-lg-3 col-md-6 text-center">
	        	<div class="service-box">
					<a id="Game" class="btn btn-primary btn-xl page-scroll" ng-click="choiceTopic('gaming')">
						<i class="fa fa-gamepad"></i>&nbsp;Game Quiz
					</a>
				</div>
			</div>
		</div>
	</div>
</div>
	  
<div ng-show="topicChoice">              
	<div ng-show="inProgress">
		<div ng-show="!quizOver">
			<div class="container text-center text-primary">
		  		<h3>Quiz {{quizName}} - Question {{cpt}} of {{maxQuestions}} - Score {{score}}</h3>
		  	</div>
		  	<br>
		  	<div class="container text-center">
				<p id="question" class="text-faded">Who said : "{{question}}" ?</p>
				<br>
				<div ng-repeat="option in options" style="display:inline-block;" ng-show="answerMode">
					<a id="validate" class="page-scroll btn btn-default btn-xl sr-button" ng-click="checkAnswer(option)">
						{{option}}
					</a>
					&nbsp;
				</div>
			</div>
		
		   	<div class="container text-center" ng-show="!answerMode">
		   		<div ng-show="correctAns">
					<p class="text-success">
					<i class="fa fa-smile-o"></i> 
					{{ans}} is correct!</p>
					<a id="next" class="btn btn-primary btn-xl page-scroll" ng-click="nextQuestion()">
						Next&nbsp;<i class="fa fa-chevron-right"></i>
					</a>
				</div>
				<div id="incorrectAns" ng-show="!correctAns">
					<p class="text-danger">
					<i class="fa fa-frown-o"></i> 
					Sorry, {{ans}} is incorrect! The true answer is {{ansTrue}}.</p>
					<a id="next" class="btn btn-primary btn-xl page-scroll" ng-click="nextQuestion()">
						Next&nbsp;<i class="fa fa-chevron-right"></i>
					</a>
				</div>
			</div> 
		</div>
		
		<script>
		$( document ).click(function() {
		  $( "#incorrectAns" ).effect( "shake" );
		});
		</script>
  		<script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	 
		<div class="container text-center" ng-show="quizOver">
			<p class="text-faded">You have completed the {{topic}} quiz in {{time}} with {{score}} good answers.</p>
			<div>
				<a id="playAgain" class="btn btn-primary btn-xl page-scroll" ng-click="quizIsFinish()">
					<i class="fa fa-reply"></i>&nbsp;Done
				</a>
				<tag:loggedin>
					<form action="./post" method="post">
						<div class="form-group">
							<textarea class="form-control" rows="3" name="text" ng-show="textarea-share-hidden">That's good! {{score}}/10 in {{time.minutes}}:{{time.seconds}} minutes. You can test too on -> http://1-dot-whosaidthatontwitter.appspot.com #{{topic}} #WhoSaidThatOnTwitter</textarea>
						</div>
						<button type="submit" id="share" class="btn btn-primary btn-xl page-scroll">
				    		<i class="fa fa-share-square-o"></i>&nbsp;Share
				    	</button>
					</form>
				</tag:loggedin>
			</div>
		</div>
	</div>
	
	<div class="container text-center" ng-show="!inProgress">
		<p class="text-faded">You are about to start a quiz. Are you ready ?</p>
		<a id="back" class="btn btn-primary btn-xl page-scroll" ng-click="reset()">
			<i class="fa fa-chevron-left"></i>&nbsp;Go Back
		</a>
		&nbsp;
		<a id="startQuiz" class="btn btn-primary btn-xl page-scroll" ng-click="start()">
			Let's go&nbsp;<i class="fa fa-chevron-right"></i>
		</a>
	</div>
</div>
