import java.io.InputStream;
import java.util.Scanner;

public class ServerComm implements Runnable{
	private InputStream client;
	private Server server;

	public ServerComm(InputStream client, Server server) {
		this.client = client;
		this.server = server;
	}

	public void run() {
		// Quando chega uma mensagem, distribui para todos
		Scanner scanner = new Scanner(this.client);
		
		while (scanner.hasNextLine()) {
			server.sendMessage(scanner.nextLine());	// Server envia mensagem para Clientes
		}
		scanner.close();
	}
}