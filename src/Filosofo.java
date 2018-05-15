import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Filosofo {
	public static void main(String[] args)
	throws UnknownHostException, IOException{
		Scanner scanner = new Scanner(System.in);
		try{
        	System.out.println("Insert server port: ");
			String port = scanner.nextLine();
			new Thread(new MainServer(Integer.parseInt(port))).start();
		} catch(Exception e){
			System.out.println(e.toString());
		}

		try{
			new Thread(new MainClient()).start();
		} catch(Exception e){
			System.out.println(e.toString());
		}
	}
}
