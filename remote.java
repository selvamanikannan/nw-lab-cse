import java.rmi.*;
import java.net.*;
import java.io.*;
import java.rmi.registry.*;
public class remote
{
public static void main(String a[]) throws Exception
{
InetAddress ip=InetAddress.getLocalHost();
  rev_in obj =new rev_im();
 LocateRegistry.createRegistry(1900);
  Naming.rebind("rmi://localhost:1900/"+ip.getHostName(),obj);
  System.out.println("Server started...");

}}
