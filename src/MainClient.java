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

<<<<<<< HEAD
		// recebe o IP do server
		System.out.print("Insert server address: ");
		str[2] = scanner.nextLine();
=======
		String command = null;
           
 		if(System.getProperty("os.name").equals("Linux"))
                	command = "ifconfig";
            	else
                	command = "ipconfig";
            Runtime r = Runtime.getRuntime();
            Process p = r.exec(command);
            Scanner s = new Scanner(p.getInputStream());
 
            StringBuilder sb = new StringBuilder("");
            while(s.hasNext())
                sb.append(s.next());
            String ipconfig = sb.toString();
            Pattern pt = Pattern.compile("192\\.168\\.[0-9]{1,3}\\.[0-9]{1,3}");
            Matcher mt = pt.matcher(ipconfig);
            mt.find();
            str[2] = mt.group();

		System.out.println(str[2]);	
>>>>>>> 7aa7a229385842129782f10d230a8f54eac8a201

		// inicializa o Cliente
		new Client(str[0], str[1], 12345, str[2]).execute();

		scanner.close();
	}
}

