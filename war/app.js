var app = angular.module('quizApp', ['timer']);

var listTweet;
var userName;
  
app.controller('tweetController', ['$window','$scope',function($window,$scope) {
  
  var errorQuizInProgress = "Please finish the quizz in progress before to choice a new quiz topic."
  userName = $window.userName;
  console.log("user name ", userName);
  
  $window.init = function() {
    console.log("window init called");
    var rootApi = 'https://1-dot-whosaidthatontwitter.appspot.com/_ah/api';
    gapi.client.load('tweetentityendpoint', 'v1', function() {
      console.log("tweet api loaded");
      gapi.client.tweetentityendpoint.listTweetEntity().execute(function(resp) {
        listTweet = resp.items || [];
        console.log(resp);
      });
    }, rootApi);
  }
  
}]);

app.factory('quizFactory', function() {
	return {
		getQuestion: function(questions) {
		  var id = Math.floor(Math.random() * questions.length)
		  console.log("question : ",questions[id]);
			if(id < questions.length) {
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
		templateUrl: 'template.html',
		link: function(scope, elem, attrs) {
			scope.startTimer = function () {
		        console.log("timer-start");
		        scope.$broadcast('timer-start');
		      };

		      scope.stopTimer = function () {
		        console.log("timer-stop");
		        scope.$broadcast('timer-stop');
		      };
		      
			scope.choiceTopic = function (topic) { 
			    console.log("topic choice : ",topic);
			    scope.topic = topic;
			    scope.topicChoice = true;
			};
			
			scope.getUserName = function(name) {
				console.log("user name : ",name);
				scope.userName = name;
			}
			
			scope.start = function() {
				console.log("start");
				scope.cpt = 0;
				scope.quizOver = false;
				scope.inProgress = true;
				quizInProgress = true;
				scope.generateQuiz();
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
		        for (var i=0;i<=length-1;i++) {
		          names = [];
		          pos = Math.floor(Math.random() * 3);
		          for (var j=0;j<=3;j++) {
		            if (j==pos) {
		              names.push(listTweet[i].name);
		            } else {
		              names.push(listTweet[Math.floor(Math.random() * length)].name);
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
				var q = quizFactory.getQuestion(scope.questions);
				if(q) {
				  if (q.category == scope.topic) {
					  scope.category = q.category;
					  scope.question = q.question;
					  scope.options = q.options;
					  scope.answer = q.answer;
					  scope.answerMode = true;
					  scope.cpt++;
				  } else {
					  console.log("The question don't apply to the topic choice (",scope.topic,")");
					  scope.nextQuestion();
				  }
				} else {
					scope.quizOver = true;
					scope.stopTimer();
				}
			};
 
			scope.checkAnswer = function() {
				console.log("check answer");
				if(!$('input[name=answer]:checked').length) return;
 
				var ans = $('input[name=answer]:checked').val();
				console.log("answer choice : ",ans);
				console.log("answer true : ",scope.options[scope.answer]);
 
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
				// on limite le nombre de questions par quizz à 10
				if (scope.cpt < 10) {
				  scope.getQuestion();
				} else {
				  scope.quizOver = true;
				  scope.stopTimer();
				  var rootApi = 'https://1-dot-whosaidthatontwitter.appspot.com/_ah/api';
		          gapi.client.load('highscoreentityendpoint', 'v1', function() {
		            console.log("user name", scope.userName);
		            gapi.client.highscoreentityendpoint.insertHighScoreEntity({id:1, name: userName, score:scope.score, time:0, topic:scope.topic}).execute(function(resp) {
		              console.log(resp);
		            });
		          }, rootApi);
				}
			}
 
			scope.reset();
		}
	}
});