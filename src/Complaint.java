
public class Complaint {
	private static int  numberOfComplaint;
	private int complaintID;
	private int customerID;
	private int producerID;
	private int productID;
	private String complaintTitle;
	private String complaint;
	private String status;
	private String product;
	private String producerName;
	private String CustomerName;

	
	
	public Complaint(int complaintID, int customerID, int producerID, int productID, String complaintTitle,
			String complaint, String status) {
		this.complaintID = complaintID;
		this.customerID = customerID;
		this.producerID = producerID;
		this.productID = productID;
		this.complaintTitle = complaintTitle;
		this.complaint = complaint;
		this.status = status;
		numberOfComplaint++;
	}
	public Complaint(int customerID, int producerID, int productID, String complaintTitle, String complaint) {
		this(numberOfComplaint,customerID,producerID,productID,complaintTitle,complaint,"new");
		
	}


	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getComplaintID() {
		return complaintID;
	}
	public int getCustomerID() {
		return customerID;
	}
	public int getProducerID() {
		return producerID;
	}
	public int getProductID() {
		return productID;
	}
	public String getComplaintTitle() {
		return complaintTitle;
	}
	public String getComplaint() {
		return complaint;
	}
	public String newLine() {
		return complaintID+","+customerID+","+producerID+","+productID+","+complaintTitle+","+complaint+","+status;
				
	}
	public String getProducerName() {
		return producerName;
	}
	public void setProducerName(String producerName) {
		this.producerName = producerName;
	}
	
	public String getProduct() {
		return product;
		
	}
	
	public String getLine() {
		return complaintID+","+customerID+","+producerID+","+productID+","+complaintTitle+","+complaint+","+status;
				
	}
	
	
	public void setProduct(String product) {
		this.product=product;
		
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	
	
	

	


	
	
	

}
