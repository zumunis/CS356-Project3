package miniTwitterUpdate;



import java.util.ArrayList;

public abstract class Tweeter {
	
	private int id;
	private String name;
	ArrayList<Integer> followers;
	ArrayList<String> tweets;
	ArrayList<Integer> mygroups;
	ArrayList<String> newsfeed;
	private String time;
	
	public Tweeter(int id, String name, String time2)
	{
		this.id = id;
		this.name = name;
		this.time= time2;
	}


}

