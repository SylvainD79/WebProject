package webProject;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

@SuppressWarnings("serial")
public class CleanDatastoreServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    	
    	DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

    	Query mydeleteq = new Query("TweetEntity");
    	PreparedQuery pq = datastore.prepare(mydeleteq);
    	for (Entity result : pq.asIterable()) {
    		datastore.delete(result.getKey());      
    	}   
    }
}