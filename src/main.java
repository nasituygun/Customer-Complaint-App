import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class main {
	
	

	public static void main(String[] args) throws Exception {
		Scanner scanner=new Scanner(System.in);
		App app=new App();
		while (true) {
			System.out.println("1-login \n2-register");
			String s=scanner.nextLine();
			if (s.equals("1")) {
				if(app.login()) {
					app.run();
					break;
				}
			}
			else if (s.equals("2")) {
				app.register();
			}
		}
		
	
	}

		
	}


