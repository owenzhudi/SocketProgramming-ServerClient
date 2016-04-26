I use Java in homework 6 about network socket programming.
The program includes 2 files below:
- Server.java: Java code for server.
- Client.java: Java code for the client.

There are two ways to run the program: in command line and in Eclipse.
In command line:
- Open the terminal.
- Navigate into the directory of the Java file.
- Enter “javac Server.java” and “javac Client.java” to compile the Java files.
- Navigate to the parent directory, that is, /src, and enter “java homework6.Server 8800” to run the Server program. “8800” is the port number, you can change it to another one.
- Open a new window of the terminal, and navigate to the /src directory, then enter “java homework6.Client localhost 8800”. “localhost” is the host name, and “8800” is the port number. You can change it to another host name and port number.

In Eclipse:
To run Server.java:
- Open the files Server.java.
- Click the menu Run - Run Configurations.
- Click the tab Arguments, and type “8800” in the Program Arguments, where “8800” is the port number.
- Click Run.
To run Client.java:
- Open the file Client.java.
- Click the menu Run - Run Configurations.
- Click the tab Arguments, and type “localhost” and “8800”, where “localhost” is the host name, and “8800” is the port number.
- Click Run.

You can type the commands in the client program. The command and code are separated by a space.
Example commands:
GET hello.txt
BOUNCE hi
EXIT
EXIT 1