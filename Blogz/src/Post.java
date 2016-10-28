import java.util.ArrayList;
import java.util.Date;

public class Post {
	private String body;
	private String title;
	private String author;
	private Date created;
	private ArrayList <Date> dt_mod = new ArrayList<Date>();
	
	public Post (String body, String title, String author, Date dt) {
		this.setBody(body);
		this.setTitle(title);
		this.setAuthor(author);
		final Date created = dt;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public ArrayList <Date> getDt_mod() {
		return dt_mod;
	}

	public void setDt_mod(Date dt) {
		dt_mod.add(dt);
	}

	
}
