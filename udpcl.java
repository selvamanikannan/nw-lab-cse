import java.io.*;
import java.net.*;
import java.util.*;

public class udpcl
{
	public static void main(String args[]) throws IOException
	{

		File f=new File("tcpout.txt");
		BufferedReader br=new BufferedReader(new FileReader(f));
		DatagramSocket ds = new DatagramSocket();
		InetAddress ip = InetAddress.getLocalHost();
		byte buf[] = null;
		//String inp;
			while (true)
		{
			String inp = br.readLine();

			buf = inp.getBytes();
			DatagramPacket DpSend =new DatagramPacket(buf, buf.length, ip, 8000);
			ds.send(DpSend);
			if (inp.equals("exit"))
				break;
		}

	}
}
