import java.io.InputStream;
import java.util.Scanner;


public class ClientComm implements Runnable{
	private InputStream server;
	private String ip;

	public ClientComm(InputStream server, String ip) {
		this.server = server;
		this.ip = ip;
	}

	public void run() {
		Scanner scanner = new Scanner(this.server);

		while (scanner.hasNextLine()) {
			// envia frame de bytes para o Server
			System.out.println(new String(this.ip + ":" + scanner.nextLine()));
		}
		scanner.close();
	}
}
