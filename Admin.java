package miniTwitterUpdate;

/**
 * Zaki Munis
 * Project 2
 * CS 356
 * 
 * I only implemented Singleton Pattern and Composite Pattern, 
 * I got stuck at interacting the JTree and Jpanel
 */


import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

public class Admin extends JPanel implements ActionListener {
	static ArrayList<User> users;
	ArrayList<Group> groups;
	ArrayList<Integer> ids;
	private static final Admin instance = new Admin();
	
	
	
	private JTree tree;
	

    private static boolean playWithLineStyle = false;
    private static String lineStyle = "Horizontal";
    private static boolean useSystemLookAndFeel = false;
    private static String view = "Open User View";
    private static String REMOVE_COMMAND = "remove";
    private static String CLEAR_COMMAND = "clear";
	

	
	private Admin(){
		
		 super(new GridLayout(1,0));
		 DefaultMutableTreeNode top = new DefaultMutableTreeNode("Root");
		        createNodes(top);
		 
		        //Create a tree that allows one selection at a time.
		        tree = new JTree(top);
		        tree.getSelectionModel().setSelectionMode
		                (TreeSelectionModel.SINGLE_TREE_SELECTION);
		 
		        //Listen for when the selection changes.
		        //tree.addTreeSelectionListener(this);
		        tree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
		            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
		                jTree1ValueChanged(evt);
		            }
		        });
		 
		        if (playWithLineStyle) {
		            System.out.println("line style = " + lineStyle);
		            tree.putClientProperty("JTree.lineStyle", lineStyle);
		        }
		 
		        //Create the scroll pane and add the tree to it. 
		        JScrollPane treeView = new JScrollPane(tree);
		 
		   
		 
		        //Add the scroll panes to a split pane.
		        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		        splitPane.setTopComponent(treeView);
		 
		        Dimension minimumSize = new Dimension(10, 5);
		        treeView.setMinimumSize(minimumSize);
		        splitPane.setDividerLocation(100); 
		        splitPane.setPreferredSize(new Dimension(300, 200));
		      
		        //Add the split pane to this panel.
		        add(splitPane);
		        
		        JButton addButton = new JButton("Add");
		        addButton.setActionCommand(view);
		        addButton.addActionListener(this);
		        
		        JButton removeButton = new JButton("Remove");
		        removeButton.setActionCommand(REMOVE_COMMAND);
		        removeButton.addActionListener(this);
		        
		        JButton clearButton = new JButton("Clear");
		        clearButton.setActionCommand(CLEAR_COMMAND);
		        clearButton.addActionListener(this);
		        
		        JButton Total = new JButton("Total");
		        Total.setActionCommand(CLEAR_COMMAND);
		        Total.addActionListener(this);
		        
		        JButton IDVButton = new JButton("User/GroupID-Verfication");
		        IDVButton.setActionCommand(view);
		        IDVButton.addActionListener(this);
		        
		        JButton Ctime = new JButton("CreationTime");
		        Ctime.setActionCommand(REMOVE_COMMAND);
		        Ctime.addActionListener(this);
		        
		        JButton LUtime = new JButton("lastupdate-time");
		        LUtime.setActionCommand(CLEAR_COMMAND);
		        LUtime.addActionListener(this);
		        
		        JButton LUuser = new JButton("lastupdated-user");
		        LUuser.setActionCommand(CLEAR_COMMAND);
		        LUuser.addActionListener(this);
		        
		        
		        JPanel panel = new JPanel(new GridLayout(0,2));
		        panel.add(addButton);
		        panel.add(removeButton);
		        panel.add(clearButton);
		        panel.add(Total);
		        panel.add(IDVButton);
		        panel.add(Ctime);
		        panel.add(LUtime);
		        panel.add(LUuser);
		        add(panel, BorderLayout.LINE_END);
		        
		
	}
	
	public static Admin getinstance()
	{
		return Admin.instance;
	}
	public void createUser(String name, String time)
	{
		int id = uniqueID();
		
		User temp = new User(id, name, time);
		users.add(temp);
		
	}

	public void createGroup(String name, String time)
	{
		int id = uniqueID();
		
		Group temp = new Group(id, name, time);
		groups.add(temp);
	}
	public static int uniqueID() {
	    Random rand = new Random();
	    boolean unique = false;
	    int id;
	    do
	    {
	    id = rand.nextInt((1000000 - 10000) + 1) + 10000;
	    unique = uniquecheck(id);
	    }while(!unique);

	    return id;
	}

	private static boolean uniquecheck(int id) {
		
		for(int i=0; i<users.size(); i++)
		{
			if(users.get(i).getId()== id)
				return false;
		}
		return true;
	}
	 private void createNodes(DefaultMutableTreeNode top) {
	        DefaultMutableTreeNode groups = null;
	        DefaultMutableTreeNode users = null;
	 
	        groups = new DefaultMutableTreeNode("CS356");
	        top.add(groups);
	 
	 
	       
	        users = new DefaultMutableTreeNode("Edward JOnes");
	        groups.add(users);
	 
	       
	        users = new DefaultMutableTreeNode(
	            ("Zack Munis"));
	        groups.add(users);
	 
	      
	        users = new DefaultMutableTreeNode(
	            ("Mary"));
	        groups.add(users);
	 
	        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	        Date date = new Date();
	        System.out.println(dateFormat.format(date));
	        
	        String time = (dateFormat.format(date));
	        
	        users = new DefaultMutableTreeNode(new User
	            (1, "arnold.html", time));
	        groups.add(users);
	        
	        time = (dateFormat.format(date));
	
	        users = new DefaultMutableTreeNode(new User
	            (3, "John", time));
	        groups.add(users);
	 
	        groups = new DefaultMutableTreeNode("CS331");
	        top.add(groups);
	 
	        time = (dateFormat.format(date));
	        users = new DefaultMutableTreeNode(new User
	            (11,"Group", time));
	        groups.add(users);
	 
	        time = (dateFormat.format(date));
	        users = new DefaultMutableTreeNode(new User
	            (13, "Carol", time));
	        groups.add(users);
	    }
	         
	    /**
	     * Create the GUI and show it.  For thread safety,
	     * this method should be invoked from the
	     * event dispatch thread.
	     */
	    static void createAndShowGUI() {
	        if (useSystemLookAndFeel) {
	            try {
	                UIManager.setLookAndFeel(
	                    UIManager.getSystemLookAndFeelClassName());
	            } catch (Exception e) {
	                System.err.println("Couldn't use system look and feel.");
	            }
	        }
	 
	        //Create and set up the window.
	        JFrame frame = new JFrame("miniTwitter");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       
	        //Add content to the window.
	        frame.add(new Admin());
	 
	        //Display the window.
	        frame.pack();
	        frame.setVisible(true);
	    }
	 
	    private static String labelPrefix = "total button clicks: ";
		private int clicks =0;
		final JLabel label = new JLabel(labelPrefix + "0  ");
		
		final static String look = null;

	    public Component createComponents() {
			
			JButton button = new JButton("Im a swing button!");
			button.setMnemonic('i');
			button.addActionListener((ActionListener) this);
			label.setLabelFor(button);
			
			
			JPanel pane = new JPanel(new GridLayout(0,1));
			pane.setBorder(BorderFactory.createEmptyBorder(90,30,10,30));
			pane.add(button);
			pane.add(label);
			
			return pane;
		}
	
	
	public void jTree1ValueChanged( TreeSelectionEvent tse ) {
	     String node = tse.getNewLeadSelectionPath().getLastPathComponent().toString();
	    if( node.equals("CS356") ) {
	       //
	    } else if( node.equals("video") ) {
	       // play video
	    }
	    else if(node.equals("Edward JOnes") )
	    {
	    	
	    }
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

}

