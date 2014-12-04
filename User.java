package miniTwitterUpdate;



import java.util.ArrayList;

public class User extends Tweeter {

	public User(int id, String name, String time) {
		super(id, name, time);
		// TODO Auto-generated constructor stub
	}



	private int id;
	private String name;
	ArrayList<Integer> followers;
	ArrayList<Integer> ifollow;
	ArrayList<String> tweets;
	ArrayList<Integer> mygroups;
	ArrayList<String> newsfeed;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void addfollower(int a)
	{
		followers.add(a);
	}
	
	public void follow(int a)
	{
		ifollow.add(a);
	}
	
	public void addtweet(String a)
	{
		tweets.add(a);
	}
	
	public void addgroup(int a)
	{
		mygroups.add(a);
	}
	
	public void update(String a)
	{
		newsfeed.add(a);
	}
	

}

