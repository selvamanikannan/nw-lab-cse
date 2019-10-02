import java.io.*;
import java.net.*;
public class tcpserver{

public static void main(String args[]) throws Exception{
   ServerSocket sock=new ServerSocket(5000);
   Socket socket=sock.accept();
   InetAddress ia=InetAddress.getByName("LocalHost");
  //File file =new File("/home/cse5lab/17c091/Desktop/hello.txt");
  File file =new File("tcpout.txt");
//  FileOutputStream fos=new FileOutputStream("C:/Users/arun/Documents/nwlab/tcpout.txt");
  FileInputStream fis=new FileInputStream(file);
  BufferedInputStream bis=new BufferedInputStream(fis);
  OutputStream os=socket.getOutputStream();
  byte[] contents;
  long filelength=file.length();
  long current=0;
  long start=System.nanoTime();
  while(current!=filelength){

  int size=10000;
  if(filelength-current>=size)
       current+=size;
  else{
    size=(int)(filelength-current);
    current=filelength;
    }
   contents=new byte[size];
   bis.read(contents,0,size);
   os.write(contents);
   System.out.println("sending file..."+(current+100)/filelength+"% complete");
}
  os.flush();
  socket.close();
  sock.close();
  System.out.println("file sent successfully");


}

}
