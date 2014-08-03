/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clientGui;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.ListCellRenderer;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import client.ClientMain;
import univers.ClientSetUpPack;
import univers.HomeworkPack;
import univers.OrderPack;
import univers.Question;
import univers.QuestionMapPack;
import univers.TalkPack;
import univers.User;


/**
 *
 * @author jackle
 */
public class StudentFrame extends javax.swing.JFrame implements ClientFrame
{

    /**
     * Creates new form MainJFrame
     */
    public StudentFrame(ClientMain _cm,User _user) 
    {
    	cm = _cm;
    	user = _user;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem3 = new javax.swing.JCheckBoxMenuItem();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        onlineUserList = new javax.swing.JList();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
//        jTree2 = new javax.swing.JTree();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jButton6 = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("jCheckBoxMenuItem2");

        jCheckBoxMenuItem3.setSelected(true);
        jCheckBoxMenuItem3.setText("jCheckBoxMenuItem3");

//TODO jTree2
    	top = new DefaultMutableTreeNode(new String("Questions"));
    	jTree2 = new JTree(top);
//    	jTree2.setRootVisible(false);
    	jTree2.addMouseListener(new MouseListener()
    	{

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					treeEventProcess(e);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
    	});
    	jTree2.addTreeSelectionListener(new TreeSelectionListener() {
    		 
            @Override
            public void valueChanged(TreeSelectionEvent e) 
            {
            	QuestionSelected();
            }
        });
    	
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(200, 200, 800, 600));
        setLocation(new java.awt.Point(200, 150));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(788, 588));

        jPanel4.setMaximumSize(new java.awt.Dimension(161, 421));
        jPanel4.setMinimumSize(new java.awt.Dimension(161, 421));

        jScrollPane3.setMaximumSize(new java.awt.Dimension(160, 411));
        jScrollPane3.setMinimumSize(new java.awt.Dimension(160, 411));
        jScrollPane3.setPreferredSize(new java.awt.Dimension(160, 411));
        jScrollPane3.setSize(new java.awt.Dimension(163, 411));
                
        
        // TODO OnLineList    
        onlineUserList.setCellRenderer(new MyCellRenderer());  
        onlineUserList.addMouseListener(new MouseListener() 
        {
			@Override
			public void mouseClicked(MouseEvent evt)  
			{ 
//				try {
					onlineUserSelect(evt);
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
			}
			@Override
			public void mousePressed(MouseEvent e) { }
			@Override
			public void mouseReleased(MouseEvent e) { }
			@Override
			public void mouseEntered(MouseEvent e) { }
			@Override
			public void mouseExited(MouseEvent e) {	}
        });
        
        jScrollPane3.setViewportView(onlineUserList);
  
 
        
        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setFont(new java.awt.Font("Arial Hebrew", 1, 14));
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jButton2.setText("Send");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                try {
					jButton2ActionPerformed(evt);
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					jButton1ActionPerformed(evt);
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(user.getUserIcon())); // NOI18N
        jLabel1.setText(user.getUserName());
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addGap(16, 16, 16))
        );
//TODO Question Edidt 
        jTabbedPane1.addTab("    Talk    ", jPanel1);

        jComboBox1.setEnabled(false);
        
        jButton4.setText("     ＋     ");
        jButton4.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                jButton4ActionPerformed(evt);
            }
        });

        jTextField1.setText("");
        jTextField1.setEditable(false);

        jLabel2.setText("Title");

        jLabel3.setText("Field");
    
        jLabel4.setText("Content");

        jScrollPane6.setViewportView(jEditorPane1);
        
        jEditorPane1.setEditable(false);

        jButton5.setText("Comfirm");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					jButton5ActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        jButton5.setEnabled(false);

        jButton3.setText("Edit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(60, 60, 60)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel4))
                                .addGap(0, 422, Short.MAX_VALUE))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        jScrollPane10.setViewportView(jTree2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                    .addComponent(jScrollPane10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)))
                .addGap(17, 17, 17))
        );

        jTabbedPane1.addTab("Questions", jPanel2);

        jScrollPane4.setHorizontalScrollBar(null);
        jScrollPane4.setPreferredSize(new java.awt.Dimension(170, 375));

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("选择课程"));
        jPanel7.setPreferredSize(new java.awt.Dimension(150, 370));

        jTree1.setRootVisible(false);
        jScrollPane7.setViewportView(jTree1);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
        );

        jScrollPane4.setViewportView(jPanel7);

        jButton6.setText("Submit");

        jScrollPane9.setViewportView(jPanel6);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton6))
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("    Class   ", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        
        
        
        pack();
    }
    
    private void onlineUserSelect(MouseEvent me)
    {
    	// TODO onlineUserSelect
    	System.out.println(onlineUserList.getSelectedValue());
    	int to = (Integer)onlineUserList.getSelectedValue();
    	if(talkLog.get(to)!=null)
    	{
    		String c = talkLog.get(to).toString();
        	jTextArea1.setText(c);
    	}
    	else
    	{
    		talkLog.put(to, new StringBuffer());
    	}
    	jTextArea1.repaint();
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) throws IOException
    {
        // TODO 刷新按钮的事件处理
    	onlineUserList.repaint();
    	cm.sendOutPack(new OrderPack(OrderPack.GETSETUPINFO,user.getUserNumber(),null));
    }
    
    
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) throws IOException 
    {
        // TODO 发送按钮的处理
    	int to = (Integer)onlineUserList.getSelectedValue();
    	TalkPack tp = new TalkPack(user.getUserNumber() ,to ,jTextArea2.getText());
        cm.sendOutPack(tp);
    	talkLog.get(to).append("你 ：\n"+jTextArea2.getText()+"\n");
    	String c = talkLog.get(to).toString();
    	jTextArea1.setText(c);
    	jTextArea2.setText("");
        
    }

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) 
    {
        // TODO add your handling code here:
        System.out.println("点击了头像");
        IconSelectFrame isf = new IconSelectFrame(this);
        isf.setLocationRelativeTo(null);
        isf.setVisible(true);
        
    }
    
    
    private long timeInterval = new Date().getTime()-30000;
    private void treeEventProcess(MouseEvent me) throws IOException
    {
    	timeInterval = new Date().getTime()-timeInterval;
    	if(timeInterval>30000)
    	{
    		System.out.println("发出的包中信息为"+user.getUserNumber());
    		cm.sendOutPack(new OrderPack(OrderPack.GETQUESTION,user.getUserNumber(),"byauthor"));
    	}
    	timeInterval = new Date().getTime();
    }
    
		
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) 
    {
        // TODO 添加问题
    	jTree2.setEnabled(false);
    	jTextField1.setEditable(true);
    	jTextField1.setText("添加标题");
    	jButton3.setEnabled(false);
    	jButton5.setText("Add Question");
    	jComboBox1.setEnabled(true);
    	jEditorPane1.setText("");
    	jEditorPane1.setEditable(true);
    	jButton5.setEnabled(true);
    	for(String o : fields)
    	{
    		System.out.println(o);
    		jComboBox1.addItem(o);
    	}
    	editQuestion = false;
    	
    }
    
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) throws IOException 
    {
    	//TODO 发送已经编辑好的question
    	int SendComfirm;
    	SendComfirm = JOptionPane.showConfirmDialog(null, "确认上传问题？", "提示",JOptionPane.YES_NO_CANCEL_OPTION);
    	if(SendComfirm==0)
    	{
    		if(editQuestion)
    		{
    			cm.sendOutPack(new OrderPack(OrderPack.DELETQUESTION,user.getUserNumber(),""+selectQuestionId));
    			DefaultMutableTreeNode node = (DefaultMutableTreeNode)jTree2.getLastSelectedPathComponent();
    			String title = (String)node.getUserObject();
                System.out.println("你选择了：" + title.toString());
                Long num = questionList.get(title);
                selectQuestionId = num;
                Question q = questionMap.get(num);
    			Question questionToSend = new Question(jTextField1.getText(),q.getField(),new StringBuffer(jEditorPane1.getText()),user.getUserNumber());
    			cm.sendOutPack(questionToSend);
    			questionList.remove(questionToSend.getTitle());
    			addedQuestion.remove(questionToSend);
    			questionMap.remove(questionToSend.getQuestionId());
    			jTree2.removeAll();
    			cm.sendOutPack(new OrderPack(0,user.getUserNumber(),"byauthor"));
    			jTree2.repaint();
    		}
    		else
    		{
                Question questionToSend = new Question(jTextField1.getText(),jComboBox1.getSelectedItem().toString(),new StringBuffer(jEditorPane1.getText()),user.getUserNumber());
    			cm.sendOutPack(questionToSend);  			
    		}
    		
    	}
    	jTree2.setEnabled(true);
    	jButton5.setText("Comfirm");
		jButton3.setEnabled(true);
		jButton5.setEnabled(false);
    }	

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) 
    {
    	jTree2.setEnabled(false);
    	jTextField1.setEditable(true);
    	jButton3.setEnabled(false);
    	jEditorPane1.setEditable(true);
    	jButton5.setEnabled(true);
    	jButton3.setEnabled(false);
    	editQuestion = true;
    }

    

    public void SetUpClientUI(ClientSetUpPack csup)
    {
    	
    	cm.IconMap = csup.getIconMap();
    	cm.NameMap = csup.getNameMap();
    	Vector<Integer> listData = new Vector<Integer>(cm.IconMap.keySet());
    	onlineUserList.setListData(listData); 
    	
    }
    
    public void newMessage(TalkPack tp)
    {
    	String from = cm.NameMap.get(tp.getFrom());
    	String content = tp.getContent();
    	if(talkLog.get(tp.getFrom())!=null)
    	{
    		talkLog.get(tp.getFrom()).append(from+"：\n"+content+"\n");
        	jTextArea1.setText(talkLog.get(tp.getFrom()).toString());
    	}
    	else
    	{
    		talkLog.put(tp.getFrom(), new StringBuffer());
    		talkLog.get(tp.getFrom()).append(from+"：\n"+content+"\n");
        	jTextArea1.setText(talkLog.get(tp.getFrom()).toString());
    	}
    	jTextArea1.repaint();
    }
    
    @Override
    public void setUpQuestion(QuestionMapPack qmp)
    {
    	//TODO    	
    	questionMap = qmp.getQmp();
    	System.out.println("收到的questionPack的大小为"+questionMap.size());
    	ArrayList<Long> queId = new ArrayList<Long>(questionMap.keySet());//all question's id
     	for(long l : queId)
    	{
    		Question temQ = questionMap.get(l);
    		String field = temQ.getField();
    		if(!fields.contains(field))
    		{
    			fields.add(field);
    		}
    		questionList.put(temQ.getTitle(), temQ.getQuestionId());
    	}
    	for(String s : fields)
    	{
    		DefaultMutableTreeNode dmtn = new DefaultMutableTreeNode(s);
    		if(!tree.containsKey(s))
    		{
    			tree.put(s, dmtn);
            	top.add(dmtn);	
    		}	
    	}
    	for(long l : queId)
    	{
    		Question tempQuestion = questionMap.get(l);
    		String field = tempQuestion.getField();
    		DefaultMutableTreeNode dmtn = tree.get(field);
    		if(!addedQuestion.contains(tempQuestion))
    		{
    			System.out.println("添加了一次");
    			dmtn.add(new DefaultMutableTreeNode(tempQuestion.getTitle()));
    			addedQuestion.add(tempQuestion);
    		}  		
    	}
    	repaint();
    }
    
    public void QuestionSelected()
    {
    	//TODO questionSelected
    	 DefaultMutableTreeNode node = (DefaultMutableTreeNode)jTree2.getLastSelectedPathComponent();
         if (node == null)
         {
        	 return;
         } 
         if (node.isLeaf()) 
         {
        	 String title = (String)node.getUserObject();
             System.out.println("你选择了：" + title.toString());
             Long num = questionList.get(title);
             selectQuestionId = num;
             Question q = questionMap.get(num);
             jTextField1.setText(q.getTitle());
             jEditorPane1.setText(q.getContent().toString());
         }
    }
    
    public void setIcon(String icon)
    {
    	
    	try {
    		jLabel1.setIcon(new ImageIcon(icon));
        	jLabel1.repaint();
			cm.sendOutPack(new OrderPack(OrderPack.CHANGEICON,user.getUserNumber(),icon));
		} 
    	catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    
    @Override
	public void setHomework(HomeworkPack hp) 
    {
		// TODO Auto-generated method stub
		
	}
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList onlineUserList;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTree jTree1;
    private javax.swing.JTree jTree2; 

	public ClientMain cm;
	public HashMap<Integer,StringBuffer> talkLog = new HashMap<Integer,StringBuffer>();
	private ArrayList<String> fields = new ArrayList<String>();//all question's fields
	private HashMap<String,Long> questionList = new HashMap<String,Long>();//questionTitle to questionId
	private HashMap<String,DefaultMutableTreeNode> tree = new HashMap<String,DefaultMutableTreeNode>();//field to defaultMutableTreeNode first stage
	private ArrayList<Question> addedQuestion = new ArrayList<Question>();//已经添加过的Question
	private HashMap<Long,Question> questionMap;
	private DefaultMutableTreeNode top;
	private User user;
	
	private boolean editQuestion = false;
	private long selectQuestionId;
	 	
    // End of variables declaration//GEN-END:variables
	class MyCellRenderer extends JLabel implements ListCellRenderer<Object> 
	{
	    public MyCellRenderer() 
	    {
	        setOpaque(true);
	        setFont(new java.awt.Font("Arial Hebrew", 1, 20));        
	    }

	    public Component getListCellRendererComponent(  JList<?> list,
									                    Object value,
									                    int index,
									                    boolean isSelected,
									                    boolean cellHasFocus) 
	    {
	    	if (value != null)   
			{   
	    		Integer num = (Integer)value;
				setText(cm.NameMap.get(num));   
				setIcon(new ImageIcon(cm.IconMap.get(num)));
	  
			}           
			if (isSelected)   
			{   
				setBackground(list.getSelectionBackground());   
				setForeground(list.getSelectionForeground());   
			}   
		  	else
			{                
				//设置选取与取消选取的前景与背景颜色.   
				setBackground(list.getBackground());   
				setForeground(list.getForeground());   
			}   
			return   this;  

	    }
	}

	
}
