public class Customer extends User{

	public Customer(int userID, String userName, String password, String displayedName, String userType) {
		super(userID, userName, password, displayedName, userType);
		// TODO Auto-generated constructor stub
	}
	
	public Customer(String userName, String password, String displayedName, String userType) {
		super(numberOfUsers, userName, password, displayedName, userType);
		
		
	}
	
	public void printComplaint() {
		for (int i = 0; i < complaintList.size(); i++) {
			if (!complaintList.get(i).getStatus().equals("delete")) {
			System.out.println(i+"- " + complaintList.get(i).getComplaintID()+" "+complaintList.get(i).getProducerName()+" "+complaintList.get(i).getProduct()+" "+complaintList.get(i).getComplaintTitle()+" "+complaintList.get(i).getStatus());
		}}
	}
	

	
	
	

}
