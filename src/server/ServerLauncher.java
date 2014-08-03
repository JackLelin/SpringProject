package server;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.SQLException;

public class ServerLauncher {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					ServerLauncher window = new ServerLauncher();
					window.frame.setVisible(true);
					
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws UnknownHostException 
	 */
	public ServerLauncher() throws UnknownHostException 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws UnknownHostException 
	 */
	private void initialize() throws UnknownHostException {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(159, 134, 134, 28);
		panel.add(textField);
		textField.setColumns(10);
		
		final JButton btnNewButton = new JButton("Start");
		
		btnNewButton.setBounds(327, 135, 117, 29);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Set ServerPort");
		lblNewLabel.setBounds(41, 140, 106, 16);
		panel.add(lblNewLabel);
		
		JLabel lblServerip = new JLabel("Server IP");
		lblServerip.setBounds(41, 79, 106, 16);
		panel.add(lblServerip);
		
		JLabel label = new JLabel("127.0.0.1");
		InetAddress addr = InetAddress.getLocalHost();
		String ip=addr.getHostAddress().toString();//获得本机IP
		label.setText(ip);
		label.setBounds(159, 79, 134, 16);
		panel.add(label);
		
		JLabel lblServerStatus = new JLabel("Server Status");
		lblServerStatus.setBounds(41, 197, 106, 16);
		panel.add(lblServerStatus);
		
		final JLabel lblOff = new JLabel("Off");
		lblOff.setBounds(159, 197, 61, 16);
		panel.add(lblOff);
		
		textField.setText("11235");
		
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent ae) 
			{
				
				String p = textField.getText();
				
				if(p.length()==5)
				{
					try
					{
						int port = Integer.valueOf(p);
						new ServerMain(port);
						btnNewButton.setEnabled(false);
						lblOff.setText("On");
					}
					catch(RuntimeException er)
					{
						er.printStackTrace();
					}	
					catch (ClassNotFoundException e) 
					{
						e.printStackTrace();
					} 
					catch (SQLException e) 
					{			
						JOptionPane.showMessageDialog( frame, (Object)"SQL数据库未打开");
						e.printStackTrace();
					} 
					catch (IOException e) 
					{
						JOptionPane.showMessageDialog(null,"服务器未能正常开启");
						e.printStackTrace();
					}
				}
			}
		});
	}
}
