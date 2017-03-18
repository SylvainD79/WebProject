var app = angular.module('quizApp', ['timer']);

var userName;
var listTweet;
var listHighScore;
  
app.controller('tweetController', ['$window','$scope',function($window,$scope) {
  
  userName = $window.userName;
  console.log("welcome ", userName);
  
  $window.getListTweet = function() {
	console.log("get list tweet");
	var rootApi = 'https://1-dot-whosaidthatontwitter.appspot.com/_ah/api';
	gapi.client.load('tweetentityendpoint', 'v1', function() {
	  console.log("tweet api loaded");
	  gapi.client.tweetentityendpoint.listTweetEntity().execute(function(resp) {
	    listTweet = resp.items || [];
	    console.log(resp);
	  });
	}, rootApi);
  }
  
  $window.getListHighScore = function() {
	  console.log("get list high score");
	  var rootApi = 'https://1-dot-whosaidthatontwitter.appspot.com/_ah/api';
      gapi.client.load('highscoreentityendpoint', 'v1', function() {
      	console.log("high score api loaded");
          gapi.client.highscoreentityendpoint.listHighScoreEntity().execute(function(resp) {
            listHighScore = resp.items || [];
            console.log(resp);
          });
      }, rootApi);
  }
  
}]);

app.factory('quizFactory', function() {
	return {
		getQuestion: function(questions, id) {
			if(id < questions.length) {
				console.log("question : ",questions[id]);
				return questions[id];
			} else {
				return false;
			}
		}
	};
});

app.directive('quiz', function(quizFactory) {
	return {
		restrict: 'AE',
		scope: {},
		templateUrl: 'quiz.html',
		link: function(scope, elem, attrs) {
			scope.startTimer = function () {
		        console.log("timer-start");
		        scope.$broadcast('timer-start');
		    };

		    scope.stopTimer = function () {
		        console.log("timer-stop");
		        scope.timer = scope.$broadcast('timer-stop');
		        
		        scope.time = {
		        	minutes : scope.timer.targetScope.$$childHead.minutes,
		        	seconds : scope.timer.targetScope.$$childHead.seconds
		        };
		        console.log("time : ",scope.time);
		    };
		      
			scope.choiceTopic = function (topic) { 
			    console.log("topic choice : ",topic);
			    scope.topic = topic;
			    scope.topicChoice = true;
			};
			
			scope.start = function() {
				console.log("start");
				scope.cpt = 0;
				scope.quizOver = false;
				scope.inProgress = true;
				quizInProgress = true;
				scope.generateQuiz();
				scope.countQuestions = scope.questions.filter(function(item) { 
                    return item.category == scope.topic;
                }).length;	
				console.log("questions available for this topic : ",scope.countQuestions);
				if (scope.countQuestions < 10) {
					scope.maxQuestions = scope.countQuestions;
				} else {
					scope.maxQuestions = 10;
				}
				console.log("maximum number of quiz questions : ",scope.maxQuestions);
				scope.getQuestion();
				scope.startTimer();
			};
 
			scope.reset = function() {
				console.log("reset");
				scope.topic = "";
				scope.topicChoice = false;
			  	scope.inProgress = false;
			  	scope.score = 0;
			}
			
			scope.generateQuiz = function() {
				console.log("generate quiz");
		        var length = listTweet.length;
		        scope.questions = [];
		        var question;
		        var names;
		        var pos;
		        for (var i=0;i<length;i++) {
		          names = [];
		          pos = Math.floor(Math.random() * 3);
		          for (var j=0;j<=3;j++) {
		            if (j==pos) {
		            	names.push(listTweet[i].name);
		            } else {
		            	var next = false;
		            	while (!next) {
		            		var name = listTweet[Math.floor(Math.random() * length)].name;
		            		if(names.indexOf(name) == -1) {
		            			names.push(name);
		            			next = true;
		            		}
		            	}
		            }
		          }
		          scope.question = {
		            category : listTweet[i].category,
		            question : listTweet[i].tweet,
		            options : names,
		            answer : pos
		          };
		          scope.questions.push(scope.question);
		        }
			}
 
			scope.getQuestion = function() { 
				console.log("get question");
				var id = Math.floor(Math.random() * scope.questions.length);
				var q = quizFactory.getQuestion(scope.questions, id);
				if(q) {
				  if (q.category == scope.topic) {
					  scope.category = q.category;
					  scope.question = q.question;
					  scope.options = q.options;
					  scope.answer = q.answer;
					  scope.answerMode = true;
					  scope.cpt++;
					  scope.questions.splice(id, 1);
				  } else {
					  console.log("The question don't apply to the topic choice (",scope.topic,")");
					  scope.nextQuestion();
				  }
				} else {
					scope.quizOver = true;
					scope.stopTimer();
				}
			};
 
			scope.checkAnswer = function(ans) {
				console.log("check answer");
				console.log("answer choice : ",ans);
				console.log("answer true : ",scope.options[scope.answer]);
 
				scope.ans = ans;
				if(ans == scope.options[scope.answer]) {
					scope.score++;
					scope.correctAns = true;
				} else {
					scope.correctAns = false;
				}
 
				console.log("score : ",scope.score);
				scope.answerMode = false;
			};
 
			scope.nextQuestion = function() {
				console.log("next question");
				if (scope.cpt < scope.maxQuestions) {
				  scope.getQuestion();
				} else {
				  scope.quizOver = true;
				  scope.stopTimer();
				  scope.id = userName + "-" + scope.topic;
				  var rootApi = 'https://1-dot-whosaidthatontwitter.appspot.com/_ah/api';
		          gapi.client.load('highscoreentityendpoint', 'v1', function() {
		        	console.log("insert or update high score");
				    gapi.client.highscoreentityendpoint.manageHighScoreEntity({id:scope.id, name:userName, score:scope.score, minutes:scope.time.minutes, seconds:scope.time.seconds, topic:scope.topic}).execute(function() {
				      console.log("finish");
				    });
		          }, rootApi);
				}
			}
			
			scope.quizIsFinish = function() {
				var rootApi = 'https://1-dot-whosaidthatontwitter.appspot.com/_ah/api';
		        gapi.client.load('highscoreentityendpoint', 'v1', function() {
		        	console.log("get high score");
		            gapi.client.highscoreentityendpoint.listHighScoreEntity().execute(function(resp) {
		              listHighScore = resp.items || [];
	                  console.log(resp);
		            });
		        }, rootApi);
		        scope.reset();
			}
 
			scope.reset();
		}
	}
});

app.directive('highscore', function() {
	return {
		restrict: 'AE',
		scope: {},
		templateUrl: 'highscore.html',
		link: function(scope, elem, attrs) {
			scope.reset = function() {
				console.log("reset");
				scope.topic = "";
				scope.topicChoice = false;
			  	scope.score = 0;
			}
			
			scope.choiceTopic = function (topic) { 
			    console.log("topic choice : ",topic);
			    scope.topic = topic;
			    scope.topicChoice = true;
			    scope.generateHighScore(topic);
			};
			
			scope.generateHighScore = function(topic) {
				console.log("generate high score");
		        scope.highscores = [];
		        var m;
		        var s;
		        for (var i=0;i<listHighScore.length;i++) {
		        	if (listHighScore[i].topic == topic) {
		   		        if (listHighScore[i].minutes < 10) {
		        			m = "0" + listHighScore[i].minutes;
		        		} else {
		        			m = listHighScore[i].minutes;
		        		}
		        		if (listHighScore[i].seconds < 10) {
		        			s = "0" + listHighScore[i].seconds;
		        		} else {
		        			s = listHighScore[i].seconds;
		        		}
		        		scope.highscore = {
		        				name : listHighScore[i].name,
		    		            score : listHighScore[i].score,
		    		            min : listHighScore[i].minutes,
		    		            sec : listHighScore[i].seconds,
		    		            time : m + ":" + s
		        		};
		        		scope.highscores.push(scope.highscore);
		        	} 
		        }
			}
			
			scope.reset();
		}
	}
});