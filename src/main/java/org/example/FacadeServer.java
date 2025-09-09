package org.example;
import java.net.*;
import java.io.*;
import java.util.*;


public class FacadeServer {
        public static void main(String[] args) throws IOException {
            ServerSocket serverSocket = null;
            try {
                serverSocket = new ServerSocket(36000);
            } catch (IOException e) {
                System.err.println("Could not listen on port: 35000.");
                System.exit(1);
            }

            Socket clientSocket = null;

            boolean running = true;
            while (running){
                try {
                    System.out.println("Listo para recibir ...");
                    clientSocket = serverSocket.accept();
                } catch (IOException e) {
                    System.err.println("Accept failed.");
                    System.exit(1);
                }
                PrintWriter out = new PrintWriter(
                        clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
                String inputLine, outputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Recibí: " + inputLine);
                    if (!in.ready()) {break; }
                }



                outputLine = "HTTP/1.1 200 OK\r\n"
                        + "Content-Type: text/html\r\n"
                        + "\r\n"
                        + "<!DOCTYPE html>\n"
                        + "<html>\n"
                        + "<head>\n"
                        + "<meta charset=\"UTF-8\">\n"
                        + "<title>Title of the document</title>\n"
                        + "</head>\n"
                        + "<body>\n"
                        + "<h1>Mi propio mensaje</h1>\n"
                        + "</body>\n"
                        + "</html>\n";
                out.println(outputLine);
                out.close();
                in.close();
                clientSocket.close();
                serverSocket.close();
            }
        }

        public static void class handleClient(){
            String client = "<!DOCTYPE html>"
                            +"<html>"

                            +"<head>"
                            +"<title>Form Example</title>"
                            +"<meta charset="UTF-8">"
                            +"<meta name="35000" content="width=device-width, initial-scale=1.0">"
                            +"</head>"

                            +"<body>"
                            +"<h1>Form with GET</h1>"
                            +"<form action="/hello">"
                            +"<label for="name">Name:</label><br>"
                            +"<input type="text" id="name" name="name" value="John"><br><br>"
                            +"<input type="button" value="Submit" onclick="loadGetMsg()">"
                            +"</form>"
                            +"<div id="getrespmsg"></div>"

                            +"<script>"
                            +"function loadGetMsg() {"
                            +"let nameVar = document.getElementById("name").value;"
                            +"const xhttp = new XMLHttpRequest();"
                            +"xhttp.onload = function () {"
                            +"document.getElementById("getrespmsg").innerHTML =
                            +"this.responseText;"
                            +}
                            +"xhttp.open("GET", "/hello?name=" + nameVar);"
                            +"xhttp.send();"
                            +"}"
                            +"</script>"
                            +"</body>"
                            +"</html>"

        }

        public static void service(){


            String outputLine = "HTTP/1.1 200 OK\r\n"
            + "Content-Type: text/html\r\n"
                    + "\r\n"
                    + "<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "<head>\n"
                    + "<meta charset=\"UTF-8\">\n"
                    + "<title>Title of the document</title>\n"
                    + "</head>\n"
                    + "<body>\n"
                    + "<h1>Mi propio mensaje</h1>\n"
                    + "</body>\n"
        }
    }

