import java.io.IOException;
import java.util.Scanner;

public class MainServer implements Runnable {
	public void run(){
		Scanner scanner = new Scanner(System.in);
		String port = scanner.nextLine();

		// Inicializa o servidor
		new Server(Integer.parseInt(port)).execute();
	}
}
