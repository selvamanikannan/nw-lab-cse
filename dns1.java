import java.net.*;
import java.io.*;
import java.util.*;
public class dns1
{
  public static void main(String args[])throws IOException
  {
   Process process = Runtime.getRuntime().exec("nslookup www.yahoo.com");
   BufferedReader output = new BufferedReader(new InputStreamReader(process.getInputStream()));
   String s=output.readLine();
     System.out.println(s);
   s=output.readLine();
     System.out.println(s);
     s=output.readLine();
       System.out.println(s);
}
}
