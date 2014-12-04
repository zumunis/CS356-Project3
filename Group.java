package miniTwitterUpdate;



import java.util.ArrayList;

public class Group extends Tweeter {

	private int id;
	private String name;
	ArrayList<User> members;
	ArrayList<Group> subgroups;
	
	public Group(int id, String name, String time)
	{
		super(id, name, time);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public void addmember(User a)
	{
		members.add(a);
	}
	
	public void addsubgroups(Group a)
	{
		subgroups.add(a);
	}
}

