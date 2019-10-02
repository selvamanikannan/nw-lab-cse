import java.net.InetAddress;
import java.net.UnknownHostException;
 

public class ip {
 
    public static void main(String[] args) {
 
        InetAddress ip;
        String hostname;
        try {
            ip = InetAddress.getLocalHost();
            hostname = ip.getHostName();
            System.out.println("Your current IP address : " + ip);
            System.out.println("Your current Hostname : " + hostname);
            System.out.println(InetAddress.getByName("www.javacodegeeks.com"));
 
        } catch (UnknownHostException e) {
 
            e.printStackTrace();
        }
    }
}