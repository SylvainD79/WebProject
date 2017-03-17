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
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;

import twitter4j.Query;
import twitter4j.Query.ResultType;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@SuppressWarnings("serial")
public class QuizServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    	
    	StringBuffer u = request.getRequestURL();
    	String hashtag = u.substring(u.lastIndexOf("/")+1);
    	
    	//Invoke the datastore services to put tweets in the datastore
    	DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
    	
        //Twitter twitter = (Twitter)request.getSession().getAttribute("twitter");
    	
    	com.google.appengine.api.datastore.Key key = KeyFactory.createKey("AccountTwitterEntity", "admin");
    	try {
			Entity account = datastore.get(key);
		
	    	ConfigurationBuilder cb = new ConfigurationBuilder();
	        cb.setDebugEnabled(true)
	                .setOAuthConsumerKey((String) account.getProperty("ConsumerKey"))
	                .setOAuthConsumerSecret((String) account.getProperty("ConsumerSecret"))
	                .setOAuthAccessToken((String) account.getProperty("AccessToken"))
	                .setOAuthAccessTokenSecret((String) account.getProperty("AccessTokenSecret"));
	
	        TwitterFactory tf = new TwitterFactory(cb.build());
	        Twitter twitter = tf.getInstance();
 
	        Query query = new Query(hashtag + "+exclude:retweets");
	        query.setResultType(ResultType.popular);
	        query.setLang("en");
	        query.setCount(100);
	        
	        String tweetWithoutHashtagAndUrl;
	        QueryResult result = twitter.search(query);
	        List<Status> tweets = result.getTweets();
	        
	        Pattern urlPattern = Pattern.compile("(http|ftp|https)://([\\w_-]+(?:(?:\\.[\\w_-]+)+))([\\w.,@?^=%&:/~+#-]*[\\w@?^=%&/~+#-])?");
	        
	        //Put the tweet resulting from the query into the datastore
	        for (Status status : tweets ) {
	        	Matcher matcher = urlPattern.matcher(status.getText());
	        	
	        	if(matcher.find()) {
	        	    tweetWithoutHashtagAndUrl = matcher.replaceAll("");   
	        	} else {
	        	    tweetWithoutHashtagAndUrl = status.getText();
	        	}
	        	
	        	Entity e = new Entity("TweetEntity", tweetWithoutHashtagAndUrl);
	        	
	        	if(status.getUser().getFollowersCount() > 5000) {
	        		
		        	e.setProperty("name", status.getUser().getName());   	
		        	e.setProperty("Tweet", tweetWithoutHashtagAndUrl);
		        	e.setProperty("category", hashtag);
		        	
		        	datastore.put(e);
	        	}
	        }
	        
	        //Request from the datastore
	        Filter filter = new FilterPredicate("category", FilterOperator.EQUAL, hashtag);
	        com.google.appengine.api.datastore.Query q = new com.google.appengine.api.datastore.Query("TweetEntity").setFilter(filter);

	        PreparedQuery pq = datastore.prepare(q);
	        
	        Iterator<Entity> tweetIterator = pq.asIterator(FetchOptions.Builder.withLimit(10));
	        
	        String allTweets = null;
	        while(tweetIterator.hasNext()) {
	        	Entity e = tweetIterator.next();
	        	allTweets += "Name : " + e.getProperty("name").toString() + "\nTexte : " + e.getProperty("Tweet").toString() + "\n\n";
	        }
	        
	        response.setContentType("text/plain");
	        response.getWriter().println(query.toString());
			response.getWriter().println("Tweet : #" + hashtag + "\n\n" + allTweets);
			
    	} catch (EntityNotFoundException e) {
			e.printStackTrace();
		}  catch (TwitterException e) {
	    	throw new ServletException(e);
	    }
    }
}
