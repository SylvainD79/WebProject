package webProject;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType=IdentityType.APPLICATION)
public class TweetEntity {
	@Persistent
	String name;
	
	@PrimaryKey
	@Persistent
	String Tweet;
	
	@Persistent
	String category;
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public TweetEntity(String n, String t) {
		this.name = n;
		this.Tweet = t;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTweet() {
		return Tweet;
	}
	
	public void setTweet(String tweet) {
		Tweet = tweet;
	}
}


