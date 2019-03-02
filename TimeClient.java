// Tejas Desai
// #700669284

import java.io.*;
import java.util.*;
import java.net.*;

public class TimeClient{
	public static void main(String[] args) throws Exception{
		try{
			String ip = "localhost";
			int port = 7777;
			Socket sc = new Socket(ip, port);
			OutputStreamWriter ow = new OutputStreamWriter(sc.getOutputStream());

			PrintWriter pw = new PrintWriter(ow);
			pw.println();
			pw.flush();

			BufferedReader br = new BufferedReader(new InputStreamReader(sc.getInputStream()));
			String data = br.readLine();
			System.out.println("Your request has been processed at "+data+"...");
			sc.close();
		} catch(Exception e){
			System.out.println(e);
		}
	}
}