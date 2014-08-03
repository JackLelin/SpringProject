package test;


import java.awt.*;
    import java.awt.event.*;

    public class savet extends Frame 
    {
        /**
         *
         */
        private static final long serialVersionUID = 1L;
        Button clientBtn, serverBtn;
        TextArea ta;
        TextField tfaddress, tfport, tftype;
        int port;
        Client client;
        ss server;
        boolean iamserver;
        static savet frm;

        public savet() {
            clientBtn = new Button("�ͻ���");
            serverBtn = new Button("������");
            ta = new TextArea("", 10, 50, TextArea.SCROLLBARS_BOTH);
            tfaddress = new TextField("192.168.1.104", 20);
            tfport = new TextField("2000");
            tftype = new TextField(50);

            tftype.addKeyListener(new TFListener());
            ta.setEditable(false);

            setLayout(new FlowLayout());
            add(tfaddress);
            add(tfport);
            add(clientBtn);
            add(serverBtn);
            add(ta);
            add(tftype);
            setSize(400, 300);
            setTitle("�ҵ�������");
            this.setVisible(true);

            clientBtn.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {

                    port = Integer.parseInt(tfport.getText());

                    client = new Client(tfaddress.getText(), port, frm);

                    client.start();

                    tfaddress.setEnabled(false);
                    tfport.setEnabled(false);
                    serverBtn.setEnabled(false);
                    clientBtn.setEnabled(false);
                }
            });

            serverBtn.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) 
                {

                    port = Integer.parseInt(tfport.getText());

                    server = new ss(port, frm);

                    server.start();

                    iamserver = true;
                    tfaddress.setText("��Ϊ������");

                    tfaddress.setEnabled(false);
                    tfport.setEnabled(false);
                    serverBtn.setEnabled(false);
                    clientBtn.setEnabled(false);
                }
            });

            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });

        }

        public static void main(String args[]) {
            frm = new savet();
        }

        private class TFListener implements KeyListener 
        {
            public void keyPressed(KeyEvent e) 
            {

                if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                    ta.append(">" + tftype.getText() + "\n");

                    if (iamserver)
                        server.dataout(tftype.getText());
                    else
                        client.dataout(tftype.getText());

                    tftype.setText("");
                }
            }

            public void keyTyped(KeyEvent e) 
            {
            }

            public void keyReleased(KeyEvent e) 
            {
            }
        }
    }
   


