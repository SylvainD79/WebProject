var app = angular.module('quizApp', ['angular-google-gapi']);

var userName;
var listTweet;
var listHighScore;

app.run(['GAuth', 'GApi', 'GData', '$rootScope', function(GAuth, GApi, GData, $rootScope) {
		
	var CLIENT = '1015135576790-lhkk91hkepjpa0fp09lh4to4p24slnbo.apps.googleusercontent.com';
	var BASE = 'https://1-dot-whosaidthatontwitter.appspot.com/_ah/api';
	var SCOPE = 'https://www.googleapis.com/auth/userinfo.email';
		
	GApi.load('tweetentityendpoint','v1',BASE).then(function(resp) {
		console.log('api : ' + resp.api + ', version : ' + resp.version + ' loaded');
	}, function(resp) {
		console.log('an error occured during loading api : ' + resp.api + ', resp.version : ' + version);
	});
		
	GApi.load('highscoreentityendpoint','v1',BASE).then(function(resp) {
		console.log('api : ' + resp.api + ', version : ' + resp.version + ' loaded');
	}, function(resp) { 
		console.log('an error occured during loading api : ' + resp.api + ', resp.version : ' + version);
	});
		
	GAuth.setClient(CLIENT)
	GAuth.setScope(SCOPE);
	GAuth.load();
		
	GAuth.checkAuth().then(function (user) {
		$rootScope.currentUser = user;
		console.log(user.name + ' is already logged in');
		userName = user.name;
	}, function() {
		console.log('checkAuth() : Erreur de connexion !');
	})

	$rootScope.signIn = function() {
		GAuth.login().then(function(user) {
			console.log(user.name + ' is logged in');
			userName = user.name;
			$rootScope.currentUser = user;					
		}, function() {
			console.log('signIn() : Erreur de connexion !');
		});
	};
			
	$rootScope.logout = function() {
		GAuth.logout();
		console.log('Déconnexion...');
		$rootScope.currentUser = null;
	};
}]);

app.controller('tweetController', ['$scope', 'GApi' ,function tweetController($scope, GApi) {

	  GApi.executeAuth('tweetentityendpoint', 'listTweetEntity').then(function(resp) {
		  listTweet = resp.items || [];
		  console.log(resp);
      }, function() {
          console.log('error : listTweet');
      });
	  
	  GApi.executeAuth('highscoreentityendpoint', 'listHighScoreEntity').then(function(resp) {
		  listHighScore = resp.items || [];
          console.log(resp);
      }, function() {
          console.log('error : listHighScore');
      });
	  
}]);

app.directive('quiz', ['GApi', '$timeout', function(GApi, $timeout) {
	return {
		restrict: 'AE',
		scope: {},
		templateUrl: 'quiz.jsp',
		link: function(scope, elem, attrs) {
			//timer callback
			var timer = function() {
				scope.timer = "";
				if (scope.seconds == 59) {
					scope.minutes += 1;
					scope.seconds = 0;
				} else {
					scope.seconds += 1;
				}
				if (scope.minutes < 10) {
					if (scope.seconds < 10) {
						scope.timer = "0" + scope.minutes + ":0" + scope.seconds; 
					} else {
						scope.timer = "0" + scope.minutes + ":" + scope.seconds; 
					}
				} else {
					if (scope.seconds < 10) {
						scope.timer = scope.minutes + ":0" + scope.seconds; 
					} else {
						scope.timer = scope.minutes + ":" + scope.seconds; 
					}
				}
				if (!scope.quizOver) {
					$timeout(timer, 1000);
				}
			}
		      
			scope.choiceTopic = function (topic) { 
			    console.log("topic choice : ",topic);
			    scope.topic = topic;
			    scope.topicChoice = true;
			};
			
			scope.start = function() {
				console.log("start : ",userName);
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
				$timeout(timer, 1000);
			};
 
			scope.reset = function() {
				console.log("reset");
				scope.topic = "";
				scope.topicChoice = false;
			  	scope.inProgress = false;
			  	scope.score = 0;
			  	scope.minutes = 0;
				scope.seconds = 0;
				scope.time = "";
				scope.timer = "00:00";
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
				if(id < scope.questions.length) {
					console.log("question : ",scope.questions[id]);
					var q = scope.questions[id];
				} else {
					var q = false;
				}
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
				}
			};
 
			scope.checkAnswer = function(ans) {
				console.log("check answer");
				console.log("answer choice : ",ans);
				console.log("answer true : ",scope.options[scope.answer]);
				scope.ans = ans;
				scope.ansTrue = scope.options[scope.answer];
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
				  scope.id = userName + "-" + scope.topic;
				  scope.time = scope.timer;
		          GApi.executeAuth('highscoreentityendpoint', 'manageHighScoreEntity', {id:scope.id, name:userName, score:scope.score, minutes:scope.minutes, seconds:scope.seconds, topic:scope.topic}).then(function(resp) {
		        	  console.log("finish");
		          }, function() {
		              console.log('error : ( hs');
		          });
				}
			}
			
			scope.quizIsFinish = function() {        
		        GApi.executeAuth('highscoreentityendpoint', 'listHighScoreEntity').then(function(resp) {
		  		  listHighScore = resp.items || [];
		  		  console.log(resp);
		        }, function() {
		        	console.log('error : ( hs');
		        });
		        scope.reset();
			}
 
			scope.reset();
		}
	}
}]);

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


