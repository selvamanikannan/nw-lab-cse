import java.io.*;
import java.net.*;

public class udpserver
{
	public static void main(String[] args) throws IOException
	{
		DatagramSocket ds = new DatagramSocket(8000);
		byte[] receive = new byte[99999];
		FileWriter fw=new FileWriter("udpin.txt");
		while (true)
		{
			DatagramPacket DpReceive = new DatagramPacket(receive, receive.length);
			ds.receive(DpReceive);
			System.out.println("Client:-" + data(receive));
			if (data(receive).toString().equals("exit"))
			{
				System.out.println("Client sent bye.....EXITING");
				break;
			}
			receive = new byte[99999];
		}
	}
	public static StringBuilder data(byte[] a)
	{
		if (a == null)
			return null;
		StringBuilder ret = new StringBuilder();
		int i = 0;
		while (a[i] != 0)
		{
			ret.append((char) a[i]);
			i++;
		}
		return ret;
	}
}
