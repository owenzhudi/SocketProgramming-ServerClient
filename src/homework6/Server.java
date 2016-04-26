package homework6;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket; 

public class Server {
	
	private static void readFile(String fileName, PrintWriter out) {
		File file = new File(fileName);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			while(line != null) {
				out.println(line);
				line = reader.readLine();
			}
			reader.close();
		} catch(IOException ex) {
			out.println("ERROR: no such file");
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		if (args.length != 1) { // Test for correct num. of arguments
			 System.err.println( "ERROR server port number not given");
			 System.exit(1);
		}
		int port_num = Integer.parseInt(args[0]);
		ServerSocket rv_sock = null;
		try {
			rv_sock = new ServerSocket(port_num);
		} catch (IOException ex) { 
			ex.printStackTrace(); 
		}
		while (true) { // run forever, waiting for clients to connect
			System.out.println("\nWaiting for client to connect...");
			try {
				Socket s_sock = rv_sock.accept();
				BufferedReader in = new BufferedReader(new InputStreamReader(s_sock.getInputStream()));
				PrintWriter out = new PrintWriter(
						new OutputStreamWriter(s_sock.getOutputStream()),true);
				String command = in.readLine();
				String[] cmds = command.split(" ");
				System.out.println("Client's message: " + command); 
				
				// process client's command
				if(cmds[0].equals("GET")) {
					if(cmds.length >= 2) {
						String fileName = cmds[1];
						readFile(fileName, out);
					}
				} else if(cmds[0].equals("BOUNCE")) {
					if(cmds.length >= 2) {
						for(int i = 1; i < cmds.length; i++) {
							out.print(cmds[i] + " ");
						}
						out.println();
					}
				} else if(cmds[0].equals("EXIT")) {
					
				} else {
					out.println("ERROR: no such command");
				}
				//out.println("I got your message");
				s_sock.close();
				//rv_sock.close();
			} catch (IOException ex) { 
				ex.printStackTrace(); 
			} 
		}
	}
}
