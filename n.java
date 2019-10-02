import java.io.*;
import java.net.*;
import java.lang.*;

class n
{
 public static void main(String args[])throws Exception{
 BufferedReader in;
String line;
try{
Runtime r=Runtime.getRuntime();
System.out.println("Next Hop:");
Process p = r.exec("tracert -h 1 www.tce.edu");
in = new BufferedReader(new InputStreamReader(p.getInputStream()));
in.readLine();
in.readLine();
in.readLine();
in.readLine();
line = in.readLine();
String[] arr=line.split("\\s+");
System.out.println(arr[8]);
}
catch(IOException e){
System.out.println(e.toString());
}
}
}


