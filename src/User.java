import java.util.ArrayList;

public abstract class User {
	
	protected static int numberOfUsers;
	
	private int userID;
	private String userName;
	private String password;
	protected String displayedName;
	private String userType;
	protected ArrayList<Complaint> complaintList;
	
	public User(int userID, String userName, String password, String displayedName, String userType) {
		this.userID = userID;
		this.userName = userName;
		this.password = password;
		this.displayedName = displayedName;
		this.userType = userType;
		complaintList=new ArrayList<Complaint>();
		numberOfUsers++;
	}

	public int getUserID() {
		return userID;
	}


	public String getUserName() {
		return userName;
	}


	public String getPassword() {
		return password;
	}


	public String getDisplayedName() {
		return displayedName;
	}


	public String getUserType() {
		return userType;
	}
	
	public void printComplaint() {
		for (int i = 0; i < complaintList.size(); i++) {
			if (!complaintList.get(i).getStatus().equals("delete")) {
			System.out.println(i+"- " + complaintList.get(i).getComplaintID()+" "+complaintList.get(i).getProducerName()+" "+complaintList.get(i).getProduct()+" "+complaintList.get(i).getComplaintTitle()+" "+complaintList.get(i).getStatus());
		}}
	}
	
	public void addComplaint(Complaint complaint) {
		complaintList.add(complaint);
		
	}
	
	public Complaint getComplaint(int index) {
		return complaintList.get(index);
	}
	
	public boolean login(String password) {
		return this.password.equals(password);
		
	}
	
	public void changeComplaint(String s,int i ) {
		switch(s) {
		
		case "delete":
			complaintList.get(i).setStatus("delete");
			break;
		case "working":
			complaintList.get(i).setStatus("working");
			break;
		case "fixed":
			complaintList.get(i).setStatus("fixed");
			break;
		case "seen":
			if (complaintList.get(i).getStatus().equals("new")){
			complaintList.get(i).setStatus("seen");}
			break;
		case "new":
			complaintList.get(i).setStatus("new");
			break;
		}
		
		
	}

	public String newLine() {
		return (userID+","+userName+","+password+","+displayedName+","+userType);
	}
	
	public void printComplaintDetails(int index) {
		System.out.println(complaintList.get(index).getComplaint());
		
	}

}
