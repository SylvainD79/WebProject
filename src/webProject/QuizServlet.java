package webProject;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

@SuppressWarnings("serial")
public class QuizServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    	
    	StringBuffer u = request.getRequestURL();
    	String hashtag = u.substring(u.lastIndexOf("/")+1);
    	
    	//Invoke the datastore services to put tweets in the datastore
    	DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

        Twitter twitter = (Twitter)request.getSession().getAttribute("twitter");
		try {
	        Query query = new Query(hashtag + "+exclude:retweets");
	        query.setLang("en");
	        query.setCount(100);
	        
	        String tweetWithoutHashtagAndUrl;
	        QueryResult result = twitter.search(query);
	        List<Status> tweets = result.getTweets();
	        
	        Pattern urlPattern = Pattern.compile("(http|ftp|https)://([\\w_-]+(?:(?:\\.[\\w_-]+)+))([\\w.,@?^=%&:/~+#-]*[\\w@?^=%&/~+#-])?");
	        
	        //Put the tweet resulting from the query into the datastore
	        for (Status status : tweets ) {
	        	Entity e = new Entity("TweetEntity");
	        	if(status.getUser().getFollowersCount() > 5000) {
		        	e.setProperty("name", status.getUser().getName());
		        	
		        	Matcher matcher = urlPattern.matcher(status.getText());
		        	
		        	if(matcher.find()) {
		        	    //Matcher found urls
		        	    //Removing them now..
		        	    tweetWithoutHashtagAndUrl = matcher.replaceAll("");   
		        	} else {
		        	    //Matcher did not find any urls, which means the 'tweetWithoutHashtag' already is ready for further usage
		        	    tweetWithoutHashtagAndUrl = status.getText();
		        	}
		        	
		        	e.setProperty("Tweet", tweetWithoutHashtagAndUrl);
		        	e.setProperty("category", hashtag);
		        	datastore.put(e);
	        	}
	        }
	        
	        Filter filter = new FilterPredicate("category", FilterOperator.EQUAL, hashtag);
	        com.google.appengine.api.datastore.Query q = new com.google.appengine.api.datastore.Query("TweetEntity").setFilter(filter);

	        PreparedQuery pq = datastore.prepare(q);
	        
	        Iterator<Entity> tweetIterator = pq.asIterator(FetchOptions.Builder.withLimit(10));
	        
	        String allTweets = null;
	        while(tweetIterator.hasNext()) {
	        	Entity e = tweetIterator.next();
	        	allTweets += "Name : " + e.getProperty("name").toString() + "\nTexte : " + e.getProperty("Tweet").toString() + "\n\n";
	        }
	        
	        
	        /*for (Status status : tweets) {
	        	allTweets += "Name : " + status.getUser().getScreenName() + "\nTexte : " + status.getText() + "\n\n";
	        }*/
	        
	        response.setContentType("text/plain");
	        response.getWriter().println(query.toString());
			response.getWriter().println("Tweet : #" + hashtag + "\n\n" + allTweets);
	        
	        //request.getRequestDispatcher("/quiz.jsp").forward(request, response);
			
	    } catch (TwitterException e) {
	    	throw new ServletException(e);
	    }
    }
}