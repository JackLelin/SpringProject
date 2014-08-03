package test;

import java.net.*;
import java.io.*;
import javax.swing.Timer;
class Client extends Thread {
    Socket skt;
    InetAddress host;
    int port;

    BufferedReader theInputStream;
    PrintStream theOutputStream;
    String readin;

    savet chat;

    public Client(String ip, int p, savet chat) {
        try {
            host = InetAddress.getByName(ip);
            port = p;
            this.chat = chat;
        } catch (IOException e) {
            chat.ta.append(e.toString());
        }
    }

    public void run() {
        try {
            chat.ta.append("��������...");

            skt = new Socket(host, port);
            chat.ta.append("���߳ɹ�\n");

            theInputStream = new BufferedReader(new InputStreamReader(skt
                    .getInputStream()));

            theOutputStream = new PrintStream(skt.getOutputStream());
            //Timer myTimer = new Timer();
            while (true) {
                readin = theInputStream.readLine();
                chat.ta.append(readin + "\n");
            }
        } catch (SocketException e) {
            chat.ta.append("�����жϣ�\n");
            chat.clientBtn.setEnabled(true);
            chat.serverBtn.setEnabled(true);
            chat.tfaddress.setEnabled(true);
            chat.tfport.setEnabled(true);
            try {
                skt.close();
            } catch (IOException err) {
                chat.ta.append(err.toString());
            }
        } catch (IOException e) {
            chat.ta.append(e.toString());
        }
    }

    public void dataout(String data) {
        theOutputStream.println(data);
    }
}

