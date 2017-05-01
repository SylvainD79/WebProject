# Who Said That On Twitter ?
Web Project of Master MIAGE at the University of Nantes

Link of the Application : http://1-dot-whosaidthatontwitter.appspot.com/

## Presentation
You're a lover of Twitter and you want to test your knowledge about the most popular tweet ? Our Quizzes are made for you ! We propose 4 differents topic; Sport, Television, Policy and Game.

Our Website is composed with only one page where you can navigate with the top menu or just slide down the page for discover all the functionality.

## Register
- With Twitter : you can post tweet with our hastag and your score at the quizz
- With Google : you have to sign in with your Google Account for access to the functionality of the website

## Tweet recovery
In order to update regularly our base of tweets, we use an twitter admin account with which we programed a cron service who clean the base everyday at 00:00 AM and insert the new popular tweets at 00:05.

## Datastore
In our Datastore, we save 4 differents informations :
- List of tweets : it list all the recent tweet used for the quizz
- High scores : it list all the score made by the user
- Session
- Admin Acount twitter : it stock the access information for connect to the Twitter admin Acount

## Quiz creation
We recover all the tweet on the Datastore and we made a list of 10 questions for the quiz with a random function and we draw lots of 3 falses responses to complete the 4 choices of responses. We also put a timer that will start at the begining of the quiz.

## Security
All the functionality of the website are accessible by sign in with Google Account, the same for update the datastore.
