import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class MainClient implements Runnable{
	public void run(){
		String[] str = new String[3];
		Scanner scanner = new Scanner(System.in);

		// numero da porta do server
		System.out.println("Insert server port to connect client: ");
		str[0] = scanner.nextLine();

		// recebe o IP local
		str[1] = new LocalIP().get();

		// recebe o IP do server
		System.out.println("Insert server address: ");
		str[2] = scanner.nextLine();

		// inicializa o Cliente
		new Client(str[1], Integer.parseInt(str[0]), str[2]).execute();

		scanner.close();
	}
}
