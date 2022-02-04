import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileIO {
	private ArrayList<User> userList;
	private ArrayList<Product> productList;
	private ArrayList<Complaint> complaintList;
	
	public FileIO() {
		userList = new ArrayList<User>();
		productList = new ArrayList<Product>();
		complaintList = new ArrayList<Complaint>();
	}



	
	
	public ArrayList<User> getUserList() {
		return userList;
	}





	public ArrayList<Product> getProductList() {
		return productList;
	}





	public ArrayList<Complaint> getComplaintList() {
		return complaintList;
	}





	public void readFile(String fileName) throws Exception {
		String line;
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
			while ((line=bufferedReader.readLine()) != null) {
				String[] data=line.toString().replaceAll("\\uFEFF", "").split(",");
				switch(fileName) {
				case"User.csv":addUser(data);break;
				case"Product.csv":addProduct(data);break;
				case"Complaint.csv":addComplaint(data);break;
				default:throw new Exception("an error occurred");
				
				}
				
				
				
				}

				}
					
				 }

	public void addUser(String[] data) throws Exception {
		switch(data[4]) {
		case "Customer":{
			userList.add(new Customer(Integer.parseInt(data[0]),data[1],data[2],data[3],data[4]));
			break;
		}
		case "Producer":{
			userList.add(new Producer(Integer.parseInt(data[0]),data[1],data[2],data[3],data[4]));
			break;
		}
		case "Admin":{

			userList.add(new Admin(Integer.parseInt(data[0]),data[1],data[2],data[3],data[4]));
			break;
		}
		default:{
			throw new Exception("an error occurred");
			
		}}
		
	}
	
	public void addProduct(String[] data) {
		productList.add(new Product(Integer.parseInt(data[0]),Integer.parseInt(data[1]),data[2],data[3]));
	}
	
	public void addComplaint(String[] data) {
		complaintList.add(new Complaint(Integer.parseInt(data[0]),Integer.parseInt(data[1]),Integer.parseInt(data[2]),Integer.parseInt(data[3]),data[4],data[5],data[6]));
		
	}
	
	public void addLine(String fileName,String addLine) throws FileNotFoundException, IOException {
		String line,lines="";
		
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
			while ((line=bufferedReader.readLine()) != null) {
				lines=lines+line+"\n";
			}
			try(BufferedWriter br = new BufferedWriter(new FileWriter(fileName))){
				br.write(lines+addLine);
				    
				} 
		
	}
		
		
	}
	
	public void changeLine(String fileName,String oldLine,String newLine) throws FileNotFoundException, IOException {
		String line,lines="";
		
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
			while ((line=bufferedReader.readLine()) != null) {
				lines=lines+line+"\n";
			}
			lines=lines.replaceAll(oldLine, newLine);
			try(BufferedWriter br = new BufferedWriter(new FileWriter(fileName))){
				br.write(lines);
				    
				} 
		
	}
		
	}
}
	

	
	
	

