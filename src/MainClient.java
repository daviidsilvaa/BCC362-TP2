import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MainClient {
	public static void main(String[] args)
	throws UnknownHostException, IOException{
		// System.out.print("Insert your ID: ");
		// Scanner scanner = new Scanner(System.in);
		//
		// // Dispara o cliente
		// new Client(scanner.nextLine(),
		// 		InetAddress.getLocalHost().toString().substring(
		// 				InetAddress.getLocalHost().toString().indexOf("/") + 1), 12345).execute();

		String[] str = new String[3];

		System.out.print("Insert your ID: ");
		Scanner scanner = new Scanner(System.in);
		str[0] = scanner.nextLine();

		System.out.print("Insert your address: ");
		str[1] = scanner.nextLine();

		str[2] = InetAddress.getLocalHost().toString().substring(InetAddress.getLocalHost().toString().indexOf("/") + 1);	

		new Client(str[0], str[2], 12345, str[1]).execute();

		scanner.close();
	}
}
