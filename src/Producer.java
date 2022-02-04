import java.util.ArrayList;

public class Producer extends User {
	private ArrayList<Product> productList;
	private ArrayList<String> productTypeList=new ArrayList<String>();


	public Producer(int userID, String userName, String password, String displayedName, String userType) {
		super(userID, userName, password, displayedName, userType);
		productList=new ArrayList<Product>();
	}
	
	public Producer(String userName, String password, String displayedName, String userType) {
		super(numberOfUsers, userName, password, displayedName, userType);
		productList=new ArrayList<Product>();

	
	}
	
	public void addProduct(Product p) {
		productList.add(p);
		if (!productTypeList.contains(p.getProductType())) {
			productTypeList.add(p.getProductType());
		}
		
		
		
	}
	public ArrayList<String> getProductTypeList(){
		return productTypeList;
		
		
	}

	public ArrayList<Product> getProduct(String type){
		ArrayList<Product> product=new ArrayList<Product>();
		for (Product p:productList ) {
			if(p.getProductType().equals(type)) {
				product.add(p);
				
			}
		}
		return product;
	}
	
	public void addComplaint(Complaint complaint) {
		complaintList.add(complaint);
		complaint.setProducerName(displayedName);
		for (Product p: productList) {
			if (complaint.getProductID()==p.getProductID()) {
				complaint.setProduct(p.getProductName());
			}
		}
		
	}
	
	public void printComplaint() {
		for (int i = 0; i < complaintList.size(); i++) {
			if (!complaintList.get(i).getStatus().equals("delete")) {
			System.out.println(i+"- " + complaintList.get(i).getComplaintID()+" "+complaintList.get(i).getCustomerName()+" "+complaintList.get(i).getProduct()+" "+complaintList.get(i).getComplaintTitle()+" "+complaintList.get(i).getStatus());
		}}
	}
	
}
