package webProject;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

@SuppressWarnings("serial")
public class QuizzServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    	
    	StringBuffer u = request.getRequestURL();
    	String hashtag = u.substring(u.lastIndexOf("/")+1);

        Twitter twitter = (Twitter)request.getSession().getAttribute("twitter");
		try {
	        Query query = new Query(hashtag);
	        QueryResult result = twitter.search(query);
	        List<Status> tweets = result.getTweets();
	        
	        String allTweets = null; 
	        for (Status status : tweets) {
	        	allTweets += status.getUser().getScreenName() + " " + status.getText() + "\n";
	        }
	        
	        response.setContentType("text/plain");
			response.getWriter().println("Tweet : #" + hashtag + "\n\n" + allTweets);
			
	    } catch (TwitterException e) {
	    	throw new ServletException(e);
	    }
    }
}
