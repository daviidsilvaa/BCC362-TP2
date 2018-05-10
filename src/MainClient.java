import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class MainClient {
	public static void main(String[] args)
	throws UnknownHostException, IOException{
		String[] str = new String[3];

		// recebe o ID da maquina, ie, um apelido
		System.out.print("Insert your ID: ");
		Scanner scanner = new Scanner(System.in);
		str[0] = scanner.nextLine();

		// recebe o IP local
		str[1] = new LocalIP().get();

		// recebe o IP do server
		System.out.print("Insert server address: ");
		str[2] = scanner.nextLine();

		// inicializa o Cliente
		new Client(str[0], str[1], 12345, str[2]).execute();

		scanner.close();
	}
}
