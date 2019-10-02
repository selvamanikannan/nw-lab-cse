import java.io.*;
import java.net.*;
public class tcpclient{
  public static void main(String args[]) throws Exception{
       Socket socket =new Socket(InetAddress.getByName("LocalHost"),5000);
       byte[] contents=new byte[10000];
       //FileOutputStream fos=new FileOutputStream("/home/cse5lab/17c091/Desktop/helloworld.txt");
       FileOutputStream fos=new FileOutputStream("tcpin.txt");
      // FileOutputStream fos=new FileOutputStream("C:\Users\arun\Documents\nwlab\tcpin.txt");
       BufferedOutputStream bos=new BufferedOutputStream(fos);
       InputStream is=socket.getInputStream();
       int bytesread=0;
       while((bytesread=is.read(contents))!=-1)
            bos.write(contents,0,bytesread);
       bos.flush();
       socket.close();
       System.out.println("File saved successfully");
}
}
