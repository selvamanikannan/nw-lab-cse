import java.rmi.*;
import java.io.*;
import java.net.*;
import java.util.*;
public class client
{
 public static void main(String a[]) throws Exception
 {
   InetAddress ip=InetAddress.getLocalHost();

   rev_in obj =(rev_in) Naming.lookup("rmi://localhost:1900/"+ip.getHostName());
   Scanner input = new Scanner(System.in);
   System.out.println("Enter a Number:");
   int in = Integer.parseInt(input.nextLine());
   int n= obj.reverse(in);
   System.out.println("Reversed Number:"+n);
}
}
