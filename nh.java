import java.io.*;
import java.net.*;

public class nh{



    public static void main(String args[]){

    try{

      Process p =Runtime.getRuntime().exec("tracert www.google.com");
      BufferedReader in=new BufferedReader(new InputStreamReader(p.getInputStream()));
      System.out.println(in.readLine());

     // System.out.println(in.readLine());
      String[] arr=in.readLine().split("\\s+");
      int n=arr[3].length();
      System.out.println(arr[3].substring(1,n-1));
      //System.out.println("Ip: " + GetNetworkAddress.GetAddress("ip"));
      //System.out.println("Mac: " + GetNetworkAddress.GetAddress("mac"));
       // InetAddress ipAddress = InetAddress.getByName("www.google.com");
        InetAddress ipAddress = InetAddress.getByName(arr[3].substring(1,n-1));
        NetworkInterface networkInterface = NetworkInterface
                .getByInetAddress(ipAddress);
        byte[] macAddressBytes = networkInterface.getHardwareAddress();
        StringBuilder macAddressBuilder = new StringBuilder();

        for (int macAddressByteIndex = 0; macAddressByteIndex < macAddressBytes.length; macAddressByteIndex++)
        {
            String macAddressHexByte = String.format("%02X",
                    macAddressBytes[macAddressByteIndex]);
            macAddressBuilder.append(macAddressHexByte);

            if (macAddressByteIndex != macAddressBytes.length - 1)
            {
                macAddressBuilder.append(":");
            }
        }

        System.out.println( macAddressBuilder.toString());
}catch(Exception e){
   System.out.println("ERROR");

}
}
}
