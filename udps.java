import java.io.*;
import java.net.*;

public class udps
{
	public static void main(String[] args) throws IOException
	{
		DatagramSocket ds = new DatagramSocket(8000);
		byte[] receive = new byte[99999];
		FileWriter fw=new FileWriter("tcpin.txt");
		while (true)
		{
			DatagramPacket DpReceive = new DatagramPacket(receive, receive.length);
			ds.receive(DpReceive);
			System.out.println("Client:-" + data(receive));
      fw.write(data(receive).toString());
			if (data(receive).toString().equals(exit))
			{
				System.out.println("EXITING");
				break;
			}
			receive = new byte[99999];
		}
		//System.out.println("EXITING");

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
