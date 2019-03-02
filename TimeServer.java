// Tejas Desai
// #700669284

import java.io.*;
import java.util.*;
import java.net.*;
import java.text.*;

class TimeHandler extends Thread{
	private BufferedReader br;
	private Socket s;
	
	public TimeHandler(Socket s){
		this.s = s;
	}
	public void run(){
		try {
			Date currentDate = new Date();
			SimpleDateFormat timeformat = new SimpleDateFormat();
			timeformat = new SimpleDateFormat("HH:mm:ss z");
			String DateToStr = timeformat.format(currentDate);

			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String data = br.readLine();

			OutputStreamWriter ow = new OutputStreamWriter(s.getOutputStream());
			PrintWriter pw = new PrintWriter(ow);
			pw.println(DateToStr);
			pw.flush();
			
		} catch(Exception e){
			System.out.println(e);
		}
	}
}

public class TimeServer{
	public static void main(String[] args) throws Exception{
		int port = 7777;
		ServerSocket ss = new ServerSocket(port);
		Socket s = null;
		try{
			while(true){
				s = ss.accept();
				Thread t = new TimeHandler(s);
				t.start();
			}
		} catch(Exception e){
			s.close();
			System.out.println(e);
		}
	}
}