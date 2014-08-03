package test;

 import java.awt.*;
import java.net.*;
import java.io.*;

    public class ss extends Thread {
        ServerSocket skt;

        Socket Client[]=new Socket[10];;
        Socket Client1=null;

        int i = 0;

        TextArea in;

        int port,k=0,l=0;

        //BufferedReader theInputStream;

        PrintStream theOutputStream;

        //String readin;

        savet chat;

        public ss(int port, savet chat) {
            try {
                this.port = port;
                skt = new ServerSocket(port);
                this.chat = chat;
            } catch (IOException e) {
                chat.ta.append(e.toString());
            }
        }

        public void run() {

            chat.ta.append("�ȴ�����......");

            while (true) {
                //System.out.print(""+i+"\n");
                try {


                Client[k] = skt.accept(); /* ���տͻ����� */

                //���пͻ�������ʱ���½�һ�����߳�


                if (i < 2) {
                    ServerThread server[] = new ServerThread[10];
                     server[k]= new ServerThread(Client[k], this.chat, i);
                     l=server.length;
                     server[k].start();
                    chat.ta.append("�ͻ���" + Client[k].getInetAddress() + "������\n");
                    //for(int j=0;j<server.length;j++)
                    theOutputStream = new PrintStream(server[k].getClient().getOutputStream());
                    i = server[k].getI();
                    k++;
                } else {
                    //theOutputStream = new PrintStream(null);
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

        }

        public void dataout(String data) {
            for(int j=0;j<l;j++)
            theOutputStream.println(data);
        }
    }

    class ServerThread extends Thread {
        ServerSocket skt;

        Socket Client;

        TextArea in;

        int port;

        int i;

        BufferedReader theInputStream;

        PrintStream theOutputStream;

        String readin;

        savet chat;

    public ServerThread(Socket s, savet chat, int i) {
        this.i = ++i;
        Client = s;
        this.port = port;
        try {
			skt = new ServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        this.chat = chat;

    }

    public int getI() {
        return this.i;
    }
    public Socket getClient() {
        return this.Client;
    }
    public void run() {

        chat.ta.append("�ȴ�����......");

        try {
            Client = skt.accept(); /* ���տͻ����� */

            chat.ta.append("�ͻ���" + Client.getInetAddress() + "������\n");
            theInputStream = new BufferedReader(new InputStreamReader(Client
                    .getInputStream()));
            theOutputStream = new PrintStream(Client.getOutputStream());

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
                i--;
                skt.close();
                Client.close();
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
