import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client{
	private String host;
	private String server;
	private int port;
	private String id;

	public Client(String id, String host, int port, String server) {
		this.id = id;
		this.host = host;
		this.port = port;
		this.server = server;
	}

	public void execute() throws UnknownHostException, IOException {
		Socket client = new Socket(this.server, this.port);

		// Thread para enviar mensagens do servidor
		new Thread(new ClientComm(client.getInputStream())).start();

		// Recebe frame do teclado e envia para o servidor
		Scanner keyboard = new Scanner(System.in);
		PrintStream frame = new PrintStream(client.getOutputStream());

		while (keyboard.hasNextLine()) {
			frame.print(this.host + ": ");
			frame.println(keyboard.nextLine());
		}

		frame.close();
		keyboard.close();
		client.close();
	}
}
