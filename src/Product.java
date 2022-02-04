import java.util.ArrayList;

public class Product {
	private static ArrayList<String> productTypeList=new ArrayList<String>();
	public static int numberOfProduct;
	private int productID,producerID;
	private String productName,productType;
	
	public Product(int productID, int producerID, String productName, String productType) {
		this.productID = productID;
		this.producerID = producerID;
		this.productName = productName;
		this.productType = productType;
		numberOfProduct++;
		if (!productTypeList.contains(productType)) {
			productTypeList.add(productType);
		}
		
		
		
	}
	
	public Product(int producerID, String productName, String productType) {
		this(numberOfProduct,producerID,productName,productType);
	}
	
	public int getProductID() {
		return productID;
	}
	public int getProducerID() {
		return producerID;
	}
	public String getProductName() {
		return productName;
	}
	public String getProductType() {
		return productType;
	}
	
	public static void printProductTypeList() {
		for (int i = 0; i < productTypeList.size(); i++) {
			System.out.println(i+"-"+productTypeList.get(i));
		}
		
	}
	
	public static String getProductType(int i) {
		return productTypeList.get(i);
		
	}
	
	public String getLine() {
		return productID+","+producerID+","+productName+","+productType;
	}
	
	
	

}
