import java.io.*;
import java.net.*;
import java.util.*;

public class udpclient
{
	public static void main(String args[]) throws IOException
	{
		File f=new File("udpout.txt");
		BufferedReader br=new BufferedReader(new FileReader(f));
		DatagramSocket ds = new DatagramSocket();
		InetAddress ip = InetAddress.getLocalHost();
		byte buf[] = null;
		while (true)
		{
			String inp = br.readLine();
			buf = inp.getBytes();
			DatagramPacket DpSend =new DatagramPacket(buf, buf.length, ip, 8000);
			ds.send(DpSend);
			if (inp.equals("exit")){
				System.out.println("File Sent..! Exiting!");
				break;
			}
		}
	}
}
