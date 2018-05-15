import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class LocalIP{
    public LocalIP(){ }

    // retorna o IP local da maquina
    public String get(){
        String command = null;

        if(System.getProperty("os.name").equals("Linux")){
            command = "ifconfig";
        }else{
            command = "ipconfig";
        }

        Runtime r = Runtime.getRuntime();
	    Process p;
	    try{
            p = r.exec(command);
	    }catch(Exception e){
		  return e.toString();
	    }
        Scanner s = new Scanner(p.getInputStream());

        StringBuilder sb = new StringBuilder("");
        while(s.hasNext()){
            sb.append(s.next());
        }

        String ipconfig = sb.toString();
        Pattern pt = Pattern.compile("192\\.168\\.[0-9]{1,3}\\.[0-9]{1,3}");
        Matcher mt = pt.matcher(ipconfig);
        mt.find();

        return mt.group();
    }
}
