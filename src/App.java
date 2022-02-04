import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class App {
	private ArrayList<User> userList;
	private ArrayList<Product> productList ;
	private ArrayList<Complaint> complaintList;
	private ArrayList<Producer> producerList;

	private FileIO fileIO;
	private Scanner sc;
	private User user;
	private Customer customer;
	private Producer producer;
	private Admin admin;
	private boolean isLogin;
	
	public App() throws Exception {
		fileIO=new FileIO();
		fileIO.readFile("User.csv");
		fileIO.readFile("Product.csv");
		fileIO.readFile("Complaint.csv");
		producerList=new ArrayList<Producer>();
		userList=fileIO.getUserList();
		productList=fileIO.getProductList();
		complaintList=fileIO.getComplaintList();
		user = null;
		isLogin=false;
		initialize();
		
		}
	public void run() throws FileNotFoundException, IOException {
		if (user.getUserType().equals("Customer")){
			showCustomerMenu();
			}
		else if (user.getUserType().equals("Producer")){
			showProducerMenu();
			}
		else if (user.getUserType().equals("Admin")){
			showAdminMenu();
			}
	}
	
	public boolean login() {
		System.out.print("Username: ");
		String username=sc.nextLine();
		System.out.print("Password: ");
		String password=sc.nextLine();
		

		for (int i=0; i<userList.size(); i++) {
			if(userList.get(i).getUserName().equals(username)) {
				if(isLogin=userList.get(i).login(password)) {
					user=userList.get(i);
					System.out.println("Login successful");
					return true;}
				else {
					System.out.println("invalid password please try again");
					login();}
				
			}
			
				
				
			
		}
		if (!isLogin) {
		System.out.println("user not found Please register");
		}
		return isLogin;

		
		
		
		
	}
	
	public void register() throws Exception {
		System.out.print("Username: ");
		String username=sc.nextLine();
		System.out.print("Password: ");
		String password=sc.nextLine();
		System.out.print("Displayed Name: ");
		String displayedName=sc.nextLine();
		
		System.out.println("user type \n1-Customer \n2-Producer");
		String choose=sc.nextLine();
		if (choose.equals("1")) {
			User newUser=new Customer(username,password,displayedName,"Customer");
			fileIO.addLine("User.csv",newUser.newLine());
			userList.add(newUser);
		}
		else if (choose.equals("2")) {
			User newUser=new Producer(username,password,displayedName,"Producer");

			userList.add(newUser);
			producerList.add((Producer) newUser);
			fileIO.addLine("User.csv",newUser.newLine());

			
		}
		else {
			System.out.println("invalid input please try again");
			register();
		}
		
		
	}

	public void showCustomerMenu() throws FileNotFoundException, IOException {
		customer=(Customer) user;
		System.out.println("1-add a complaint \n2-show previous complaints");
		String choose=sc.nextLine();
		if (choose.equals("1")) {
			System.out.println("Choose a producer");
			
			for(int i=0; i<producerList.size();i++) {
				System.out.println(i+"- Producer Name: "+producerList.get(i).getDisplayedName()+" | id: "+producerList.get(i).getUserID());
				
			}
			int chooseID=sc.nextInt();
			sc.nextLine();
			int id=producerList.get(chooseID).getUserID();
			
			System.out.println("Choose a product Type");
			for(int i=0; i<producerList.get(chooseID).getProductTypeList().size();i++) {
				System.out.println(i+"-"+producerList.get(chooseID).getProductTypeList().get(i));
				}
			int chooseProductType=sc.nextInt();
			sc.nextLine();
			String productType=producerList.get(chooseID).getProductTypeList().get(chooseProductType);
			System.out.println("Choose a product");
			for(int i=0; i<producerList.get(chooseID).getProduct(productType).size();i++) {
				System.out.println(i+"-"+producerList.get(chooseID).getProduct(productType).get(i).getProductName());
				}
			int chooseProductChoose=sc.nextInt();
			sc.nextLine();
			int chooseProductID=producerList.get(chooseID).getProduct(productType).get(chooseProductChoose).getProductID();
			System.out.print("complaint Title:");
			String complaintTitle=sc.nextLine();
			System.out.print("Complaint:");
			String complaint=sc.nextLine();
			Complaint newComplaint=new Complaint(user.getUserID(),id,chooseProductID,complaintTitle,complaint);
			user.addComplaint(newComplaint);
			producerList.get(chooseID).addComplaint(newComplaint);
			fileIO.addLine("Complaint.csv",newComplaint.newLine());


			
			
		}
		else if (choose.equals("2")) {
			while (true) {
				
				System.out.println("Select a complaint to view details");
				user.printComplaint();
				int details=sc.nextInt();
				sc.nextLine();
				user.printComplaintDetails(details);
				System.out.println("1-delete complaint\n2-back to complaint list \n 3-exit" + 
					"");
				int input=sc.nextInt();
				sc.hasNextLine();
				if (input==1) {
					String oldLine=user.getComplaint(details).getLine();
					user.changeComplaint("deleted",details);
					String newLine=user.getComplaint(details).getLine();
					fileIO.changeLine("Complaint.csv", oldLine, newLine);
				}
				else if (input==2) {
					continue;
				}
				else if (input==3) {
					break;
				}
				
			}
			
			}
			
			
			
			
			
		
		else {
			System.out.println("invalid input please try again");
			showCustomerMenu();
			
		}
	}

	public void showProducerMenu() throws FileNotFoundException, IOException {
		producer=(Producer)user;
		System.out.println("1-add a Product \n2-shows complaints");
		String choose=sc.nextLine();
		if (choose.equals("1")) {
			String productType,productName=null;
			System.out.println("Choose a product type");
			Product.printProductTypeList();
			System.out.println("a- add a new one");
			String s=sc.nextLine();
			if (s.equals("a")) {
				System.out.println("product type:");
				productType=sc.nextLine();
			}
			else {
				productType=Product.getProductType(Integer.parseInt(s));
				
			}
			System.out.println("product name:");
			productName=sc.nextLine();
			Product newProduct=new Product(producer.getUserID(),productName,productType);
			producer.addProduct(newProduct);
			fileIO.addLine("Product.csv", newProduct.getLine());
			
	}
		else if (choose.equals("2")) {
			while (true) {
				
				System.out.println("Select a complaint to view details");
				producer.printComplaint();
				int details=sc.nextInt();
				sc.nextLine();
				user.printComplaintDetails(details);
				user.changeComplaint("seen", details);
				System.out.println("1-change status to fixed \n2-chance to status working \n 3-exit" + 
					"");
				int input=sc.nextInt();
				sc.nextLine();
				if (input==1) {
					String oldLine=producer.getComplaint(details).getLine();
					producer.changeComplaint("fixed",details);
					String newLine=producer.getComplaint(details).getLine();
					fileIO.changeLine("Complaint.csv", oldLine, newLine);
				}
				else if (input==2) {
					String oldLine=producer.getComplaint(details).getLine();
					producer.changeComplaint("working",details);
					String newLine=producer.getComplaint(details).getLine();
					fileIO.changeLine("Complaint.csv", oldLine, newLine);
				}
				else if (input==3) {
					break;
				}
				
			}
		}
}

	public void showAdminMenu() throws FileNotFoundException, IOException {
		admin=(Admin)user;
		adminInitialize();
		admin.printComplaint();
		System.out.print("\"Select a complaint to view details \n details=");
		int details=sc.nextInt();
		sc.nextLine();
		admin.printComplaintDetails(details);
		System.out.println("1-change status to fixed \n2-chance to status working \n3-chance to status seen \n4-chance to status new \n5-chance to status delete" + 
				"");
			int input=sc.nextInt();
			sc.nextLine();
			if (input==1) {
				String oldLine=admin.getComplaint(details).getLine();
				admin.changeComplaint("fixed",details);
				String newLine=admin.getComplaint(details).getLine();
				fileIO.changeLine("Complaint.csv", oldLine, newLine);
			}
			else if (input==2) {
				String oldLine=admin.getComplaint(details).getLine();
				admin.changeComplaint("working",details);
				String newLine=admin.getComplaint(details).getLine();
				fileIO.changeLine("Complaint.csv", oldLine, newLine);
			}
			else if (input==3) {
				String oldLine=admin.getComplaint(details).getLine();
				admin.changeComplaint("seen",details);
				String newLine=admin.getComplaint(details).getLine();
				fileIO.changeLine("Complaint.csv", oldLine, newLine);
			}
			else if (input==4) {
				String oldLine=admin.getComplaint(details).getLine();
				admin.changeComplaint("new",details);
				String newLine=admin.getComplaint(details).getLine();
				fileIO.changeLine("Complaint.csv", oldLine, newLine);
			}
			else if (input==5) {
				String oldLine=admin.getComplaint(details).getLine();
				admin.changeComplaint("delete",details);
				String newLine=admin.getComplaint(details).getLine();
				fileIO.changeLine("Complaint.csv", oldLine, newLine);
			}
		
		
	}
	
	private void initialize() {
		sc=new Scanner(System.in);
		for (int i=0; i<userList.size(); i++) {
			if (userList.get(i) instanceof  Producer) {
				producerList.add((Producer) userList.get(i));
				
			}
		
		}
		for (Product product: productList) {
			for (Producer producer:producerList ) {
				if (product.getProducerID()==producer.getUserID()) {
					producer.addProduct(product);
				}
			}
		}
		for (Complaint c: complaintList) {
			for (User user:userList ) {
				if (c.getCustomerID()==user.getUserID()) {
					user.addComplaint(c);
					c.setCustomerName(user.getDisplayedName());
					
				}
			}
		}
		for (Complaint c: complaintList) {
			for (User user:userList ) {
				if (c.getProducerID()==user.getUserID()) {
					user.addComplaint(c);
					c.setProducerName(user.getDisplayedName());
					
				}
			}
		}
		
	
		
		
	}
	

	private void adminInitialize() {
		admin.addComplaint(complaintList);
	}
}
