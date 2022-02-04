import java.util.ArrayList;

public class Admin extends User {
	

	public Admin(int userID, String userName, String password, String displayedName, String userType) {
		super(userID, userName, password, displayedName, userType);
	}

	public void addComplaint(ArrayList<Complaint> complaintList) {
		for (Complaint c:complaintList) {
			addComplaint(c);
		}
		
	}
	
	public void printComplaint() {
		for (int i = 0; i < complaintList.size(); i++) {
			System.out.println(i+"- " + complaintList.get(i).getComplaintID()+" "+complaintList.get(i).getCustomerName()+" "+complaintList.get(i).getProducerName()+" "+complaintList.get(i).getProduct()+" "+complaintList.get(i).getComplaintTitle()+" "+complaintList.get(i).getStatus());
		}
	}


	
	
	

}
