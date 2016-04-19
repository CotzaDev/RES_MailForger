package com.res;

import java.io.*;
import java.net.Socket;
import java.util.logging.Logger;

public class SMTPClient {

    private static final Logger LOG = Logger.getLogger(SMTPClient.class.getName());
    private Socket ClientSocket;

    public SMTPClient(String adrServer, int portServer,String relayer) {

        try {
            ClientSocket = new Socket(adrServer, portServer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(ClientSocket.getInputStream(), "UTF-8"));
            PrintWriter os = new PrintWriter(new OutputStreamWriter(ClientSocket.getOutputStream(), "UTF-8"));
            String buffer = new String();

            os.println("HELO "+relayer);
            os.flush();

            buffer = is.readLine();
            int b = Integer.valueOf(buffer);

            if (b != 250) {
                throw new IOException("Server refused connection");
            } else {
                LOG.info("server accepted connection");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMail(Mail m){
        try {
            sendMessage("MAIL FROM:<" + m.getFrom() + ">");

            for(String to : m.getTo()){
                sendMessage("RCPT TO:<"+to+">");
            }

            sendMessage("DATA");
            sendMessage(m.getHeader());
            sendMessage(m.getMsgContent());
            sendMessage(".");
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private void sendMessage(String msg) throws IOException {

        PrintWriter os = new PrintWriter(new OutputStreamWriter(ClientSocket.getOutputStream(), "UTF-8"));
        os.println(msg);
        os.flush();
    }

}
