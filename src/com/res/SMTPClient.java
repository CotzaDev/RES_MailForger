package com.res;

import java.io.*;
import java.net.Socket;
import java.util.logging.Logger;

/**
 * Class who manage the interaction between the server and the client
 */
public class SMTPClient {

    private static final Logger LOG = Logger.getLogger(SMTPClient.class.getName());
    private Socket ClientSocket;

    /**
     * Try to connect to the smtp server & say HELO
     *
     * @param adrServer
     * @param portServer
     * @param relayer
     */
    public SMTPClient(String adrServer, int portServer, String relayer) {

        try {
            ClientSocket = new Socket(adrServer, portServer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(ClientSocket.getInputStream(), "UTF-8"));
            PrintWriter os = new PrintWriter(new OutputStreamWriter(ClientSocket.getOutputStream(), "UTF-8"));
            String buffer = new String();

            buffer = is.readLine();
            String b = buffer;

            if (Integer.parseInt(b.substring(0, 3)) != 220) {
                throw new IOException("Server off");
            } else {
                LOG.info("server on");
            }


            os.print("HELO " + relayer + "\r\n");
            os.flush();

            buffer = is.readLine();
            b = buffer;

            if (Integer.parseInt(b.substring(0, 3)) != 250) {
                throw new IOException("Server refused connection");
            } else {
                LOG.info("server accepted connection");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Send the mail content to the server
     *
     * @param m mail you want to send
     */
    public void sendMail(Mail m) {
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(ClientSocket.getInputStream(), "UTF-8"));
            String buffer = new String();

            String b = buffer;

            LOG.info("MAIL FROM:<" + m.getFrom() + ">");
            sendMessage("MAIL FROM:<" + m.getFrom() + ">");
            buffer = is.readLine();
            LOG.info(buffer);


            for (String to : m.getTo()) {
                LOG.info("RCPT TO:<" + to + ">");
                sendMessage("RCPT TO:<" + to + ">");
                buffer = is.readLine();
                LOG.info(buffer);
            }

            LOG.info("DATA");
            sendMessage("DATA");
            buffer = is.readLine();
            LOG.info(buffer);

            sendMessage(m.getHeader());
            sendMessage(m.getMsg());
            sendMessage(".");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Send some text to the server
     *
     * @param msg
     * @throws IOException
     */
    private void sendMessage(String msg) throws IOException {

        PrintWriter os = new PrintWriter(new OutputStreamWriter(ClientSocket.getOutputStream(), "UTF-8"));
        os.print(msg + "\r\n");
        os.flush();
    }
}
