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

	public Client(String host, int port, String server) {
		this.host = host;
		this.port = port;
		this.server = server;
	}

	public void execute(){
		Socket client = new Socket();
		try{
		client = new Socket(this.server, this.port);
		} catch(Exception e){
			System.out.println(e.toString());
		}

		// Thread para enviar mensagens do servidor
		try{
		new Thread(new ClientComm(client.getInputStream())).start();
		} catch(Exception e){
			System.out.println(e.toString());
		}

		// Recebe frame do teclado e envia para o servidor
		Scanner keyboard = new Scanner(System.in);

		PrintStream frame = null;
		try{
			frame = new PrintStream(client.getOutputStream());
		} catch(Exception e){
			System.out.println(e.toString());
		}

		while (keyboard.hasNextLine()) {
			frame.print(this.host + ":");
			frame.println(keyboard.nextLine());
		}

		frame.close();
		keyboard.close();

		try{
			client.close();
		} catch(Exception e){
			System.out.println(e.toString());
		}
	}
}
