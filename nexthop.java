import java.io.*;
import java.net.*;
import java.lang.*;

class nexthop
{
    public static void main(String args[])throws Exception{

    BufferedReader in;
    String line;
        try{
            Runtime r   =   Runtime.getRuntime();
            //get next hop ip
            System.out.println("Next Hop: www.tce.edu");
            Process p   =   r.exec("tracert -h 1 www.tce.edu");
            in  =   new BufferedReader(new InputStreamReader(p.getInputStream()));
            in.readLine();
            in.readLine();
            in.readLine();
            in.readLine();
            line=in.readLine();
            String[] arrOfStr = line.split("\\s+");
            System.out.println(arrOfStr[8]);
        }
        catch(IOException e){
        	System.out.println(e.toString());
        }

        InetAddress address = InetAddress.getLocalHost();
        NetworkInterface ni = NetworkInterface.getByInetAddress(address);
        byte[] mac = ni.getHardwareAddress();
        for (int i = 0; i < mac.length; i++) {
          System.out.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : "");}

    }
}
