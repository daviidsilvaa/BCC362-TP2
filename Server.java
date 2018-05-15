import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
	private int port;
	private List<PrintStream> clients;
	private List<String> clients_address;
	private ServerSocket servidor;

	public Server(int port) {
		this.port = port;
		this.clients = new ArrayList<PrintStream>();
		this.clients_address = new ArrayList<String>();
	}

	public void execute (){
		try{
			servidor = new ServerSocket(this.port);
		} catch(Exception e){
			System.out.println(e.toString());
		}
		//System.out.println("Porta " + this.port + " aberta!");

		while(true){
			// Aceita um cliente
			Socket client = new Socket();
			try{
			client = servidor.accept();
			} catch(Exception e){
				System.out.println(e.toString());
			}
			//new Thread(new ServerWorker(client)).start();
			System.out.println("Cliente " + client.getInetAddress().getHostAddress() + " online");
			clients_address.add(client.getInetAddress().getHostAddress());

			// Adiciona saida do cliente a lista
			PrintStream p = null;
			try{
				p = new PrintStream(client.getOutputStream());
				this.clients.add(p);
			} catch(Exception e){
				System.out.println(e.toString());
			}
			// Cria comunicador de cliente numa nova thread
			try{
				new Thread(new ServerComm(client.getInputStream(), this)).start();
			} catch(Exception e){
				System.out.println(e.toString());
			}
		}
	}

	public void sendMessage(String str) {
		String[] str_split = new String[2];
		str_split = str.split(":");

		System.out.println(str);

		// Envia mensagem para todo mundo
		for (PrintStream client : this.clients) {
			client.println(str_split[1]);
		}

		// for (PrintStream client : this.clients) {
		// 	for (String s : this.clients_address) {
		// 		client.println(s);
		// 	}
		// }

		// for(int i = 0; i < this.clients_address.size(); i++) {
		// 	if(this.clients_address.get(i).equals(str_split[0])) {
		// 		System.out.println(i);
		// 		if(i == 0) {
		// 			clients.get(i+1).println(str_split[0] + ":" + str_split[1]);
		// 			clients.get(this.clients_address.size() - 1).println(str_split[0] + ":" + str_split[1]);
		// 		} else if(i == (this.clients_address.size() - 1)) {
		// 			clients.get(i-1).println(str_split[0] + ":" + str_split[1]);
		// 			clients.get(0).println(str_split[0] + ":" + str_split[1]);
		// 		} else {
		// 			clients.get(i+1).println(str_split[0] + ":" + str_split[1]);
		// 			clients.get(i-1).println(str_split[0] + ":" + str_split[1]);
		// 		}
		// 	}
		// }
	}
}
