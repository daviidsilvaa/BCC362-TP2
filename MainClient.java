import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class MainClient {
	public static void main(String[] args)
	throws UnknownHostException, IOException{
		// System.out.print("Insert your ID: ");
		// Scanner scanner = new Scanner(System.in);
		//
		// // Dispara o cliente
		// new Client(scanner.nextLine(),
		// 		InetAddress.getLocalHost().toString().substring(
		// 				InetAddress.getLocalHost().toString().indexOf("/") + 1), 12345).execute();

		String[] str = new String[3];

		System.out.print("Insert your ID: ");
		Scanner scanner = new Scanner(System.in);
		str[0] = scanner.nextLine();

		System.out.print("Insert your address: ");
		str[1] = scanner.nextLine();

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

		new Client(str[0], str[2], 12345, str[1]).execute();

		scanner.close();
	}
}

