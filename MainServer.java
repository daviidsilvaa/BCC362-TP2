import java.io.IOException;
import java.util.Scanner;

public class MainServer implements Runnable {
    private int port;
    public MainServer(int port){
        this.port = port;
    }
	public void run(){
		// Inicializa o servidor
		new Server(this.port).execute();
	}
}
