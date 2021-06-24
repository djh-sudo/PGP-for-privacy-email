import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.Checkbox;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.security.KeyPair;
import java.security.PublicKey;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.DebugGraphics;
import javax.swing.JTable;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.TableModel;



public class Client {

	private JFrame frame;
	private JPanel panel;
	private JPanel userLoginPanel;
	private ClientPanel clientPanel;
	private JPasswordField passwordField;
	private JTextField textField;
	private JButton exit;
	private JButton recv;
	private JButton sent;
	private JButton write;
	private JButton update;
	private JButton add;
	private JButton logout;
	private JPanel eventPanel;
	private JLabel Name;
	private JPanel Register;
	private JLabel title_1;
	private JLabel mailIdRegister;
	private JLabel passwordRegister;
	private JPasswordField passwordField_1;
	private JTextField textField_1;
	private JPasswordField passwordField_2;
	private JButton btnRegister;
	private boolean userNameIsOK = false;
	private boolean pswIsOK = false;
	private boolean pswComfirmIsOK = false;
	private JButton Return;
	private JLabel infomation;
	private JLabel lblNewLabel;
	private JTextArea textArea;
	private JLabel lblNewLabel_2;
	private JTextArea textArea_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JButton btnNewButton;
	private JTextArea textArea_2;
	private JTextField textField_2;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextField textField_3;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JPanel defaultPanel;
	private JTextField textField_4;
	private JTextField textField_5;
	private JComboBox comboBox;
	private volatile boolean isRemember;
	private JCheckBox chckbxNewCheckBox;
	private JList userlist;
	private JLabel lblNewLabel_10;
	private JTextField textField_6;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_14;
	private volatile int countSend = 0;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;
	private JButton btnNewButton_7;
	private JLabel lblNewLabel_15;
	private JLabel lblNewLabel_16;
	private JLabel lblNewLabel_17;
	private JLabel lblNewLabel_18;
	private JLabel lblNewLabel_19;
	private DefaultTableModel model;
	private DefaultTableModel model1;
	private JTable table;
	private JButton btnNewButton_8;
	private JPanel showPanel;
	private JTextField textField_7;
	private int index;
	private int indexRecv;
	private JLabel lblNewLabel_21;
	private JLabel lblNewLabel_21_1;
	private JLabel lblNewLabel_21_2;
	private JTextArea textArea_4;
	private JLabel lblNewLabel_22;
	private JTable table_1;
	private JLabel lblNewLabel_23;
	private JLabel lblNewLabel_10_1;
	private JTextArea textArea_3;
	private JTextArea textArea_6;
	private JPanel showPanel_1;
	private JScrollPane jsp4_1;
	private JLabel lblNewLabel_24;
	private JLabel lblNewLabel_25;
	private JLabel lblNewLabel_20_4;
	private JLabel lblNewLabel_21_3;
	private JLabel lblNewLabel_20_5;
	private JLabel lblNewLabel_21_4;
	private JTextField textField_8;
	private JLabel lblNewLabel_20_6;
	private JButton btnNewButton_11;
	private JButton btnNewButton_9_4;
	private JButton btnNewButton_9_5;
	private JButton btnNewButton_9_6;
	private JLabel lblNewLabel_26;
	private JTextField textField_9;
	private JLabel lblNewLabel_20_7;
	private JButton btnNewButton_12;
	private JLabel lblNewLabel_27;
	private JLabel lblNewLabel_28;
	private JLabel lblNewLabel_29;
	private JLabel lblNewLabel_30;
	private JLabel lblNewLabel_31;
	private JLabel lblNewLabel_32;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client window = new Client();
					window.frame.setVisible(true);
					window.frame.setTitle("Open-PGP-@copyright by DJH 2021");
					//					long time = System.currentTimeMillis();
					//					Date date = new Date(time);
					//					System.out.println(date);;
					//					PGPRSA rsa = new PGPRSA();
					//					String message =  MD.MD5("1231111111111111111111111111111111111111111");
					//					rsa.generateKeyPair();
					//					byte[] sig =  rsa.RSASign(message, rsa.getPrivateKey());
					//					System.out.println("sig:" + sig);
					//					boolean ver = rsa.vertify(message, sig, rsa.getPublicKey());
					//					System.out.println("ver:" + ver);
					//					System.out.println("原始数据" + message);
					//					byte[] enc =  rsa.Encrypt(message.getBytes(), rsa.getPublicKey());
					//					System.out.println("加密:" + enc);
					//
					//					byte[] res = rsa.Decrypt(enc, rsa.getPrivateKey()); 
					//					System.out.println("解密" + new String(res));

					//					rsa.SaveToPEM("PublicKey.pem");
					//					PGPIDEA idea = new PGPIDEA();
					//					idea.generateKey();
					//					byte[] data = (message+"你").getBytes();
					//					byte[] encString = idea.Encrypt(data, idea.getKey());
					//					System.out.println("idea加密:" + encString);
					//					byte[] dataString = idea.Decrypt(encString, idea.getKey());
					//					System.out.println("IDEA解密" + new String(dataString));
					//					System.out.println(idea.getKey().getEncoded());
					//
					//					byte[] zdata = zip.gZip(BASE64.decoder.decode(sig));
					//					System.out.println(BASE64.encoder.encodeToString(zdata));
					//					byte[] rawData = zip.unZip(zdata);
					//					System.out.println(BASE64.encoder.encodeToString(rawData));


				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Client() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		userNameIsOK = false;
		pswIsOK = false;
		pswComfirmIsOK = false;
		isRemember = false;
		index = -1;
		indexRecv = -1;
		CardLayout cl = new CardLayout(0, 0);
		CardLayout cl1 = new CardLayout(0, 0);
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Client.class.getResource("/source/emal.png")));
		frame.setBounds(100, 100, 1141, 655);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		panel = new JPanel();
		panel.setBounds(10, 10, 1107, 598);
		frame.getContentPane().add(panel);
		panel.setLayout(cl);

		userLoginPanel = new JPanel();
		userLoginPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.requestFocus();
			}
		});
		userLoginPanel.setName("userLoginPanel");
		panel.add(userLoginPanel, "userLoginPanel");
		userLoginPanel.setLayout(null);

		clientPanel = new ClientPanel();
		clientPanel.setName("clientPanel");
		panel.add(clientPanel, "clientPanel");
		clientPanel.setLayout(null);

		recv = new JButton("\u6536\u4FE1\u7BB1");
		recv.setIcon(new ImageIcon(Client.class.getResource("/source/go.png")));
		recv.addMouseListener(new MouseAdapter() {
			@Override
			/* click the recv btn */
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_23.setText("刷新中，请稍后...");
				lblNewLabel_29.setText(null);
				model1.setRowCount(0);
				new Thread() {
					public void run() {
						boolean haveNet = clientPanel.setSocket(9999, "127.0.0.1");
						if(haveNet) {
							boolean flag =  clientPanel.Request();
							if(flag == true) {
								lblNewLabel_23.setText("收到新的邮件!");
							}
							else {
								lblNewLabel_23.setText("刷新成功!");
							}
							clientPanel.dropSocket();
						}else {
							lblNewLabel_23.setText("无网络");
						}
						for(int i=0;i<clientPanel.getUser().getRecvMail().size();i++) {
							String time = clientPanel.getUser().getRecvMail().elementAt(i).getDate().toString();
							String MD = clientPanel.getUser().getRecvMail().elementAt(i).getemailDigest();
							String mailSend = clientPanel.getUser().getRecvMail().elementAt(i).getMailSend();
							model1.addRow(new Object[] {new Boolean(false),time,mailSend,MD});
						}
					};
				}.start();
				cl1.show(eventPanel, "recvPanel");
			}
		});
		recv.setActionCommand("");
		recv.setBounds(10, 75, 128, 43);
		recv.setName("recv");
		clientPanel.add(recv);

		sent = new JButton("\u5DF2\u53D1\u9001");
		sent.setIcon(new ImageIcon(Client.class.getResource("/source/sentout.png")));
		sent.addMouseListener(new MouseAdapter() {
			@Override
			/* have sent */
			public void mouseClicked(MouseEvent e) {
				model.setRowCount(0);
				lblNewLabel_28.setText(null);
				new Thread(){
					public void run() {
						for(int i = 0;i<clientPanel.getUser().getSendMail().size();i++) {
							String time = clientPanel.getUser().getSendMail().elementAt(i).getDate().toString();
							String mailRecv = clientPanel.getUser().getSendMail().elementAt(i).getMailRecv();
							String MD = clientPanel.getUser().getSendMail().elementAt(i).getemailDigest();
							model.addRow(new Object[0]);
							model.setValueAt(false, i, 0);
							model.setValueAt(time, i, 1);
							model.setValueAt(mailRecv, i, 2);
							model.setValueAt(MD, i, 3);
						}
					};
				}.start();
				cl1.show(eventPanel, "sentPanel");
			}
		});
		sent.setBounds(10, 154, 128, 43);
		sent.setName("sent");
		clientPanel.add(sent);

		write = new JButton("\u5199\u4FE1");
		write.setIcon(new ImageIcon(Client.class.getResource("/source/writeMail.png")));

		write.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/* show the write panel */
				lblNewLabel_10.setText(null);
				textArea_3.setText(null);
				textField_4.setText(null);
				textField_5.setText(null);
				comboBox.removeAllItems();
				for(Friend it:clientPanel.getUser().getFriend()) {
					comboBox.addItem(it.getUserMail());
				}

				textField_4.setText(null);
				cl1.show(eventPanel, "writePanel");
			}
		});
		write.setBounds(10, 232, 128, 43);
		write.setName("write");
		clientPanel.add(write);

		update = new JButton("\u66F4\u65B0\u5BC6\u94A5");
		update.setIcon(new ImageIcon(Client.class.getResource("/source/update.png")));
		update.addMouseListener(new MouseAdapter() {
			@Override
			/* update the KeyPair */
			public void mouseClicked(MouseEvent e) {
				String publicKeyMosulus = clientPanel.getPublicKeyModulus();
				String publicKeyExponent = clientPanel.getPublicKeyExponent();
				textArea.setText(publicKeyMosulus);
				textArea_1.setText(publicKeyExponent);
				btnNewButton.setEnabled(true);
				cl1.show(eventPanel, "updatePanel");
			}
		});
		update.setBounds(10, 311, 128, 43);
		update.setName("update");
		clientPanel.add(update);

		add = new JButton("\u7528\u6237\u516C\u94A5");
		add.setIcon(new ImageIcon(Client.class.getResource("/source/userIcon.png")));
		add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textArea_2.setText(null);
				textField_3.setText(null);
				textField_2.setText(null);
				DefaultListModel dlmIns = new DefaultListModel();
				for(Friend it:clientPanel.getUser().getFriend()) {
					dlmIns.addElement(it.getUserMail());
				}
				userlist.setModel(dlmIns);
				cl1.show(eventPanel, "addPanel");
			}
		});
		add.setBounds(10, 385, 128, 43);
		add.setName("add");
		clientPanel.add(add);

		logout = new JButton("\u9000\u51FA");
		logout.setIcon(new ImageIcon(Client.class.getResource("/source/exitIcon.png")));
		logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				passwordField.setText("");
				passwordField.setBorder(null);
				textField.setText("");
				infomation.setText("");
				chckbxNewCheckBox.setSelected(false);
				userNameIsOK = false;
				pswIsOK = false;
				pswComfirmIsOK = false;
				isRemember = false;
				cl.show(panel, "userLoginPanel");
			}
		});
		logout.setBounds(10, 524, 128, 43);
		logout.setName("logout");
		clientPanel.add(logout);

		eventPanel = new JPanel();
		eventPanel.setBounds(172, 10, 925, 578);
		clientPanel.add(eventPanel);
		eventPanel.setLayout(cl1);

		showPanel_1 = new JPanel();
		showPanel_1.setLayout(null);
		eventPanel.add(showPanel_1, "showPanel_1");

		textArea_6 = new JTextArea();
		textArea_6.setEditable(false);
		textArea_6.setFont(new Font("宋体", Font.BOLD, 18));
		textArea_6.setBounds(10, 208, 905, 370);

		jsp4_1 = new JScrollPane(textArea_6);
		jsp4_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp4_1.setBounds(10, 208, 905, 370);
		showPanel_1.add(jsp4_1);

		lblNewLabel_24 = new JLabel("\u65F6\u95F4\u6233");
		lblNewLabel_24.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_24.setBounds(16, 70, 73, 25);
		showPanel_1.add(lblNewLabel_24);

		lblNewLabel_25 = new JLabel("");
		lblNewLabel_25.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_25.setBounds(99, 70, 267, 22);
		showPanel_1.add(lblNewLabel_25);

		lblNewLabel_20_4 = new JLabel("\u53D1\u4EF6\u4EBA:");
		lblNewLabel_20_4.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_20_4.setBounds(376, 70, 81, 25);
		showPanel_1.add(lblNewLabel_20_4);

		lblNewLabel_21_3 = new JLabel("");
		lblNewLabel_21_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_21_3.setBounds(452, 70, 175, 22);
		showPanel_1.add(lblNewLabel_21_3);

		lblNewLabel_20_5 = new JLabel("\u6536\u4EF6\u4EBA:");
		lblNewLabel_20_5.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_20_5.setBounds(637, 70, 81, 25);
		showPanel_1.add(lblNewLabel_20_5);

		lblNewLabel_21_4 = new JLabel("");
		lblNewLabel_21_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_21_4.setBounds(715, 70, 160, 22);
		showPanel_1.add(lblNewLabel_21_4);

		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setFont(new Font("宋体", Font.BOLD, 17));
		textField_8.setColumns(10);
		textField_8.setBounds(147, 122, 740, 31);
		showPanel_1.add(textField_8);

		lblNewLabel_20_6 = new JLabel("\u90AE\u4EF6\u6458\u8981");
		lblNewLabel_20_6.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_20_6.setBounds(27, 125, 91, 25);
		showPanel_1.add(lblNewLabel_20_6);

		btnNewButton_11 = new JButton("\u8FD4\u56DE");
		btnNewButton_11.addMouseListener(new MouseAdapter() {
			@Override
			/* return */
			public void mouseClicked(MouseEvent e) {

				cl1.show(eventPanel, "recvPanel");
			}
		});
		btnNewButton_11.setFont(new Font("宋体", Font.BOLD, 18));
		btnNewButton_11.setBounds(10, 10, 97, 39);
		showPanel_1.add(btnNewButton_11);

		btnNewButton_9_4 = new JButton("\u4E0A\u4E00\u5C01");
		btnNewButton_9_4.addMouseListener(new MouseAdapter() {
			@Override
			/* last */
			public void mouseClicked(MouseEvent e) {
				if(indexRecv>0) {
					indexRecv--;
					lblNewLabel_26.setText(null);
					String time = clientPanel.getUser().getRecvMail().elementAt(indexRecv).getDate().toString();
					String send = clientPanel.getUser().getRecvMail().elementAt(indexRecv).getMailSend();
					String recv = clientPanel.getUserName();
					String content = clientPanel.getUser().getRecvMail().elementAt(indexRecv).getContent();
					String digest = clientPanel.getUser().getRecvMail().elementAt(indexRecv).getemailDigest();
					String sig = BASE64.encoder.encodeToString(clientPanel.getUser().getRecvMail().elementAt(indexRecv).getSignature());
					boolean ver = clientPanel.getUser().getRecvMail().elementAt(indexRecv).getVertify();
					lblNewLabel_25.setText(time);
					lblNewLabel_21_3.setText(send);
					lblNewLabel_21_4.setText(recv);
					textField_8.setText(digest);
					textArea_6.setText(content);
					textField_9.setText(sig);
					if(ver == true) {
						lblNewLabel_27.setText("签名验证成功!");
					}else {
						lblNewLabel_27.setText("签名验证失败");
					}
				}else {
					lblNewLabel_26.setText("已经是第一封邮件");
				}
			}
		});
		btnNewButton_9_4.setFont(new Font("宋体", Font.BOLD, 18));
		btnNewButton_9_4.setBounds(147, 10, 97, 39);
		showPanel_1.add(btnNewButton_9_4);

		btnNewButton_9_5 = new JButton("\u4E0B\u4E00\u5C01");
		btnNewButton_9_5.addMouseListener(new MouseAdapter() {
			@Override
			/* next */
			public void mouseClicked(MouseEvent e) {
				int rawCount = model1.getRowCount();
				if(indexRecv<rawCount-1) {
					indexRecv++;
					lblNewLabel_26.setText(null);
					String time = clientPanel.getUser().getRecvMail().elementAt(indexRecv).getDate().toString();
					String send = clientPanel.getUser().getRecvMail().elementAt(indexRecv).getMailSend();
					String recv = clientPanel.getUserName();
					String content = clientPanel.getUser().getRecvMail().elementAt(indexRecv).getContent();
					String digest = clientPanel.getUser().getRecvMail().elementAt(indexRecv).getemailDigest();
					String sig = BASE64.encoder.encodeToString(clientPanel.getUser().getRecvMail().elementAt(indexRecv).getSignature());
					boolean ver = clientPanel.getUser().getRecvMail().elementAt(indexRecv).getVertify();
					lblNewLabel_25.setText(time);
					lblNewLabel_21_3.setText(send);
					lblNewLabel_21_4.setText(recv);
					textField_8.setText(digest);
					textArea_6.setText(content);
					textField_9.setText(sig);
					if(ver == true) {
						lblNewLabel_27.setText("签名验证成功!");
					}else {
						lblNewLabel_27.setText("签名验证失败");
					}
				}else {
					lblNewLabel_26.setText("已经是最后一封封邮件");
				}
			}
		});
		btnNewButton_9_5.setFont(new Font("宋体", Font.BOLD, 18));
		btnNewButton_9_5.setBounds(288, 10, 97, 39);
		showPanel_1.add(btnNewButton_9_5);

		btnNewButton_9_6 = new JButton("\u5220\u9664");
		btnNewButton_9_6.addMouseListener(new MouseAdapter() {
			@Override
			/* delete */
			public void mouseClicked(MouseEvent e) {
				boolean flag = clientPanel.getUser().deleteRecvMail(indexRecv);
				if(flag == true) {
					model1.removeRow(indexRecv);
					clientPanel.updateUserInfo();
					lblNewLabel_26.setText("此邮件删除成功!");
				}else {
					JOptionPane.showMessageDialog(null,"删除失败!","delete infomation",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnNewButton_9_6.setFont(new Font("宋体", Font.BOLD, 18));
		btnNewButton_9_6.setBounds(419, 10, 97, 39);
		showPanel_1.add(btnNewButton_9_6);

		lblNewLabel_26 = new JLabel("");
		lblNewLabel_26.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_26.setBounds(526, 10, 349, 39);
		showPanel_1.add(lblNewLabel_26);

		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setFont(new Font("宋体", Font.BOLD, 17));
		textField_9.setColumns(10);
		textField_9.setBounds(147, 163, 377, 31);
		showPanel_1.add(textField_9);

		lblNewLabel_20_7 = new JLabel("\u6D88\u606F\u7B7E\u540D");
		lblNewLabel_20_7.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_20_7.setBounds(27, 166, 91, 25);
		showPanel_1.add(lblNewLabel_20_7);

		btnNewButton_12 = new JButton("\u9A8C\u8BC1\u7B7E\u540D");
		btnNewButton_12.addMouseListener(new MouseAdapter() {
			@Override
			/* vertify the signature */
			public void mouseClicked(MouseEvent e) {
				String userMail = lblNewLabel_21_3.getText();
				PublicKey key =  clientPanel.getUser().getFriendKey(userMail);
				String message = textField_8.getText() + textArea_6.getText();
				String data = MD.MD5(message);
				String rawSig = textField_9.getText();
				byte[] sig = BASE64.decoder.decode(rawSig);
				if(key!=null) {
					boolean res = clientPanel.getRSA().vertify(data, sig, key);
					clientPanel.getUser().getRecvMail().elementAt(indexRecv).setVertify(res);
					clientPanel.updateUserInfo();
					if(res == true) {
						lblNewLabel_27.setText("签名验证成功!");
					}else {
						lblNewLabel_27.setText("签名验证失败!");
					}
				}else {
					lblNewLabel_27.setText("用户公钥还未被导入!");
				}
			}
		});
		btnNewButton_12.setFont(new Font("宋体", Font.BOLD, 18));
		btnNewButton_12.setBounds(540, 163, 120, 35);
		showPanel_1.add(btnNewButton_12);

		lblNewLabel_27 = new JLabel("");
		lblNewLabel_27.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_27.setBounds(670, 163, 217, 31);
		showPanel_1.add(lblNewLabel_27);

		JPanel recvPanel = new JPanel();
		eventPanel.add(recvPanel, "recvPanel");
		recvPanel.setLayout(null);

		model1 = new DefaultTableModel() {
			public Class<?>getColumnClass(int column){
				switch (column) {
				case 0:
					return Boolean.class;
				default:
					return String.class;
				}
			}
		};
		table_1 = new JTable(model1);
		model1.addColumn("选中");
		model1.addColumn("时间");
		model1.addColumn("发件人");
		model1.addColumn("摘要");
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			/* recv mail */
			public void mouseClicked(MouseEvent e) {
				indexRecv = table_1.getSelectedRow();
				int col = table_1.getSelectedColumn();
				if(indexRecv !=-1 && col != 0) {
					String time = clientPanel.getUser().getRecvMail().elementAt(indexRecv).getDate().toString();
					String send = clientPanel.getUser().getRecvMail().elementAt(indexRecv).getMailSend();
					String recv = clientPanel.getUserName();
					String content = clientPanel.getUser().getRecvMail().elementAt(indexRecv).getContent();
					String digest = clientPanel.getUser().getRecvMail().elementAt(indexRecv).getemailDigest();
					String sig = BASE64.encoder.encodeToString(clientPanel.getUser().getRecvMail().elementAt(indexRecv).getSignature());
					boolean ver = clientPanel.getUser().getRecvMail().elementAt(indexRecv).getVertify();
					lblNewLabel_25.setText(time);
					lblNewLabel_21_3.setText(send);
					lblNewLabel_21_4.setText(recv);
					textField_8.setText(digest);
					textArea_6.setText(content);
					textField_9.setText(sig);
					if(ver == true) {
						lblNewLabel_27.setText("签名验证成功!");
					}else {
						lblNewLabel_27.setText("签名验证失败");
					}
					cl1.show(eventPanel, "showPanel_1");
				}
			}
		});
		table_1.setBounds(10, 43, 886, 0);

		table_1.getColumnModel().getColumn(0).setPreferredWidth(50);
		table_1.getColumnModel().getColumn(0).setMaxWidth(50);
		table_1.getColumnModel().getColumn(0).setMinWidth(50);

		table_1.getColumnModel().getColumn(1).setPreferredWidth(300);
		table_1.getColumnModel().getColumn(1).setMaxWidth(300);
		table_1.getColumnModel().getColumn(1).setMinWidth(300);

		DefaultTableCellRenderer renderer1 = new DefaultTableCellRenderer();
		renderer1.setHorizontalAlignment(SwingConstants.CENTER);
		table_1.getColumn("时间").setCellRenderer(renderer1);
		table_1.getColumn("发件人").setCellRenderer(renderer1);
		table_1.getColumn("摘要").setCellRenderer(renderer1);
		table_1.setRowHeight(40);
		table_1.setFont(new Font("宋体",Font.BOLD,17));

		JScrollPane scrollPane_1 = new JScrollPane(table_1);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(10, 43, 905, 525);
		recvPanel.add(scrollPane_1);

		table_1.setRowHeight(40);
		table_1.setFont(new Font("宋体", Font.BOLD, 17));

		lblNewLabel_23 = new JLabel("");
		lblNewLabel_23.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_23.setBounds(593, 0, 322, 33);
		recvPanel.add(lblNewLabel_23);

		JButton btnNewButton_10 = new JButton("\u5220\u9664\u9009\u4E2D");
		btnNewButton_10.addMouseListener(new MouseAdapter() {
			@Override
			/* multi-delete recv mail */
			public void mouseClicked(MouseEvent e) {
				new Thread(){
					public void run() {
						lblNewLabel_29.setText(null);
						Vector<Integer>selected = new Vector<Integer>();
						for(int i=0;i<table_1.getRowCount();i++) {
							Boolean check = Boolean.valueOf(table_1.getValueAt(i, 0).toString());
							if(check) {
								selected.add(i);
							}
						}
						int count = 0;
						for(int i=selected.size()-1;i>=0;i--) {
							boolean index = clientPanel.getUser().deleteRecvMail(i);
							if(index == true) {
								model1.removeRow(selected.elementAt(i));
								count++;
								lblNewLabel_29.setText("已成功删除" + count + "邮件!");
							}
						}
						clientPanel.updateUserInfo();
						selected = null;
					};
				}.start();
			}
		});
		btnNewButton_10.setBounds(10, 0, 97, 33);
		recvPanel.add(btnNewButton_10);

		lblNewLabel_29 = new JLabel("");
		lblNewLabel_29.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_29.setBounds(117, 0, 384, 33);
		recvPanel.add(lblNewLabel_29);

		defaultPanel = new JPanel();
		defaultPanel.setDebugGraphicsOptions(DebugGraphics.BUFFERED_OPTION);
		eventPanel.add(defaultPanel, "defaultPanel");
		defaultPanel.setLayout(null);

		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			/* write */
			public void mouseClicked(MouseEvent e) {
				comboBox.removeAllItems();
				for(Friend it:clientPanel.getUser().getFriend()) {
					comboBox.addItem(it.getUserMail());
				}

				textField_4.setText(null);
				cl1.show(eventPanel, "writePanel");
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(Client.class.getResource("/source/envelope.png")));
		btnNewButton_3.setOpaque(false);
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setBounds(253, 99, 64, 64);
		defaultPanel.add(btnNewButton_3);

		btnNewButton_4 = new JButton("");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			/* update the key */
			public void mouseClicked(MouseEvent e) {
				String publicKeyMosulus = clientPanel.getPublicKeyModulus();
				String publicKeyExponent = clientPanel.getPublicKeyExponent();
				textArea.setText(publicKeyMosulus);
				textArea_1.setText(publicKeyExponent);
				btnNewButton.setEnabled(true);
				cl1.show(eventPanel, "updatePanel");
			}
		});
		btnNewButton_4.setIcon(new ImageIcon(Client.class.getResource("/source/key.png")));
		btnNewButton_4.setOpaque(false);
		btnNewButton_4.setBorderPainted(false);
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.setBounds(381, 99, 64, 64);
		defaultPanel.add(btnNewButton_4);

		btnNewButton_5 = new JButton("");
		btnNewButton_5.setIcon(new ImageIcon(Client.class.getResource("/source/recv.png")));
		btnNewButton_5.setOpaque(false);
		btnNewButton_5.setBorderPainted(false);
		btnNewButton_5.setBackground(Color.WHITE);
		btnNewButton_5.setBounds(127, 99, 64, 64);
		defaultPanel.add(btnNewButton_5);

		btnNewButton_6 = new JButton("");
		btnNewButton_6.addMouseListener(new MouseAdapter() {
			@Override
			/* userlist */
			public void mouseClicked(MouseEvent e) {
				textArea_2.setText(null);
				textField_3.setText(null);
				DefaultListModel dlmIns = new DefaultListModel();
				for(Friend it:clientPanel.getUser().getFriend()) {
					dlmIns.addElement(it.getUserMail());
				}
				userlist.setModel(dlmIns);
				cl1.show(eventPanel, "addPanel");
			}
		});
		btnNewButton_6.setIcon(new ImageIcon(Client.class.getResource("/source/userInfo.png")));
		btnNewButton_6.setOpaque(false);
		btnNewButton_6.setBorderPainted(false);
		btnNewButton_6.setBackground(Color.WHITE);
		btnNewButton_6.setBounds(511, 99, 64, 64);
		defaultPanel.add(btnNewButton_6);

		btnNewButton_7 = new JButton("");
		btnNewButton_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				passwordField.setText("");
				passwordField.setBorder(null);
				textField.setText("");
				infomation.setText("");
				chckbxNewCheckBox.setSelected(false);
				userNameIsOK = false;
				pswIsOK = false;
				pswComfirmIsOK = false;
				isRemember = false;
				cl.show(panel, "userLoginPanel");
			}
		});
		btnNewButton_7.setIcon(new ImageIcon(Client.class.getResource("/source/exit.png")));
		btnNewButton_7.setOpaque(false);
		btnNewButton_7.setBorderPainted(false);
		btnNewButton_7.setBackground(Color.WHITE);
		btnNewButton_7.setBounds(633, 99, 64, 64);
		defaultPanel.add(btnNewButton_7);

		lblNewLabel_15 = new JLabel("\u6536\u4FE1");
		lblNewLabel_15.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_15.setBounds(137, 160, 47, 35);
		defaultPanel.add(lblNewLabel_15);

		lblNewLabel_16 = new JLabel("\u5199\u4FE1");
		lblNewLabel_16.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_16.setBounds(263, 160, 47, 35);
		defaultPanel.add(lblNewLabel_16);

		lblNewLabel_17 = new JLabel("\u66F4\u65B0\u5BC6\u94A5");
		lblNewLabel_17.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_17.setBounds(381, 160, 94, 35);
		defaultPanel.add(lblNewLabel_17);

		lblNewLabel_18 = new JLabel("\u7528\u6237\u5217\u8868");
		lblNewLabel_18.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_18.setBounds(501, 160, 94, 35);
		defaultPanel.add(lblNewLabel_18);

		lblNewLabel_19 = new JLabel("\u9000\u51FA\u767B\u5F55");
		lblNewLabel_19.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_19.setBounds(633, 160, 94, 35);
		defaultPanel.add(lblNewLabel_19);

		JPanel sentPanel = new JPanel();
		eventPanel.add(sentPanel, "sentPanel");
		sentPanel.setLayout(null);

		model = new DefaultTableModel() {
			public Class<?>getColumnClass(int column){
				switch(column) {	
				case 0:
					return Boolean.class;
				default:
					return String.class;
				}
			}
		};

		table = new JTable(model);
		model.addColumn("选中");
		model.addColumn("时间");
		model.addColumn("收件人");
		model.addColumn("摘要");
		table.addMouseListener(new MouseAdapter() {
			@Override
			/* click the table */
			public void mouseClicked(MouseEvent e) {
				index = table.getSelectedRow();
				int col = table.getSelectedColumn();
				if(col != 0) {
					String time = clientPanel.getUser().getSendMail().elementAt(index).getDate().toString();
					String recv = clientPanel.getUser().getSendMail().elementAt(index).getMailRecv();
					String send = clientPanel.getUserName();
					String content = clientPanel.getUser().getSendMail().elementAt(index).getContent();
					String digest = clientPanel.getUser().getSendMail().elementAt(index).getemailDigest();
					lblNewLabel_21.setText(time);
					lblNewLabel_21_1.setText(send);
					lblNewLabel_21_2.setText(recv);
					textField_7.setText(digest);
					textArea_4.setText(content);
					cl1.show(eventPanel, "showPanel");
				}
			}
		});
		table.setBounds(10, 10, 905, 558);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(0).setMaxWidth(50);
		table.getColumnModel().getColumn(0).setMinWidth(50);

		table.getColumnModel().getColumn(1).setPreferredWidth(300);
		table.getColumnModel().getColumn(1).setMaxWidth(300);
		table.getColumnModel().getColumn(1).setMinWidth(300);
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumn("时间").setCellRenderer(renderer);
		table.getColumn("收件人").setCellRenderer(renderer);
		table.getColumn("摘要").setCellRenderer(renderer);
		table.setRowHeight(40);
		table.setFont(new Font("宋体", Font.BOLD, 17));

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 43, 905, 525);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sentPanel.add(scrollPane);

		btnNewButton_8 = new JButton("\u5220\u9664\u9009\u4E2D");
		btnNewButton_8.addMouseListener(new MouseAdapter() {
			@Override
			/* multi-delete */
			public void mouseClicked(MouseEvent e) {
				new Thread(){
					public void run() {
						lblNewLabel_28.setText(null);
						table.clearSelection();
						Vector<Integer>selected = new Vector<Integer>();
						for(int i=0;i<table.getRowCount();i++) {
							Boolean check = Boolean.valueOf(table.getValueAt(i, 0).toString());
							if(check) {
								selected.add(i);
							}
						}
						int count = 0;
						for(int i = selected.size()-1;i >= 0;i--) {
							boolean index = clientPanel.getUser().deleteSendMail(i);
							if(index == true) {
								model.removeRow(selected.elementAt(i));
								count++;
								lblNewLabel_28.setText("已成功删除" + count + "封邮件!");
							}
						}
						clientPanel.updateUserInfo();
					};
				}.start();
			}
		});
		btnNewButton_8.setBounds(10, 0, 97, 33);
		sentPanel.add(btnNewButton_8);

		lblNewLabel_28 = new JLabel("");
		lblNewLabel_28.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_28.setBounds(117, 0, 416, 33);
		sentPanel.add(lblNewLabel_28);

		JPanel writePanel = new JPanel();
		writePanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.requestFocus();
			}
		});
		eventPanel.add(writePanel, "writePanel");
		writePanel.setLayout(null);

		JLabel Name_1 = new JLabel("\u6536\u4EF6\u4EBA");
		Name_1.setFont(new Font("宋体", Font.BOLD, 20));
		Name_1.setBounds(32, 55, 68, 33);
		writePanel.add(Name_1);

		textField_4 = new JTextField();
		textField_4.setFont(new Font("Times New Roman", Font.BOLD, 17));
		textField_4.setBounds(110, 51, 741, 33);
		writePanel.add(textField_4);
		textField_4.setColumns(10);

		JLabel Name_1_1 = new JLabel("\u6458\u8981");
		Name_1_1.setFont(new Font("宋体", Font.BOLD, 20));
		Name_1_1.setBounds(42, 100, 58, 33);
		writePanel.add(Name_1_1);

		textField_5 = new JTextField();
		textField_5.setFont(new Font("宋体", Font.BOLD, 15));
		textField_5.setColumns(10);
		textField_5.setBounds(110, 100, 741, 33);
		writePanel.add(textField_5);

		JLabel Name_1_1_1 = new JLabel("\u6B63\u6587");
		Name_1_1_1.setFont(new Font("宋体", Font.BOLD, 20));
		Name_1_1_1.setBounds(42, 141, 58, 33);
		writePanel.add(Name_1_1_1);

		textArea_3 = new JTextArea();
		textArea_3.setFont(new Font("Monospaced", Font.BOLD, 18));
		textArea_3.setBounds(10, 10, 873, 397);
		//		writePanel.add(textArea_3);

		JScrollPane jsp3 = new JScrollPane(textArea_3);
		jsp3.setBounds(42, 171, 873, 397);
		jsp3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		writePanel.add(jsp3);

		JButton register_1 = new JButton("\u53D1\u9001");
		register_1.addMouseListener(new MouseAdapter() {
			@Override
			/* sent out the email ... */
			public void mouseClicked(MouseEvent e) {
				String emailDiget = textField_5.getText();
				
				if(emailDiget.length()>50) {
					lblNewLabel_10.setText("邮件摘要过长!");
					textField_5.setBorder(new RoundBorder(Color.RED));
					return;
				}else{
					lblNewLabel_10.setText("");
					textField_5.setBorder(new RoundBorder(Color.GREEN));
				}
				String content = textArea_3.getText();
				if(content.length()>1024*1024*1024-50) {
					lblNewLabel_10.setText("邮件内容过长!");
					return;
				}else {
					lblNewLabel_10.setText(null);
				}
				/* handle the recvMail */
				String recvList = textField_4.getText();
				if(recvList.equals("")) {
					lblNewLabel_10.setText("接收人不可以为空!");
					return;
				}
				recvList.replace(" ", "");
				String[] list = recvList.split(";");
				countSend = 0;
				lblNewLabel_10_1.setText(null);
				lblNewLabel_10.setText("发送中...");
				for(int i = 0;i<list.length;i++) {
					int index = clientPanel.getUser().checkIsDuplicated(list[i]);
					if(index != -1) {	
						new Thread() {
							public void run() {
								byte[] res =  clientPanel.sentEmail(emailDiget,content,index).getBytes();
								clientPanel.setSocket(9999, "127.0.0.1");
								boolean sendIsOk = clientPanel.sendToServer(res);
								if(sendIsOk) {
									clientPanel.updateUserInfo();
									countSend++;
									lblNewLabel_10.setText("成功发送" + countSend + "邮件!");
								}else {
									System.out.println("error");
								}
								clientPanel.dropSocket();
							};
						}.start();
					}else {
						lblNewLabel_10_1.setText("存在发送失败的邮件,请检查您的邮箱地址");
						continue;
					}
				}
				//				new Thread(){
				//					public void run() {
				//						try {
				//							Thread.sleep(2000);
				//							textArea_3.setText(null);
				//							textField_5.setText(null);
				//							textField_4.setText(null);
				//							if(countSend == 0) {
				//								JOptionPane.showMessageDialog(null,"邮件发送失败，请检查网络!","update PublicKey infomation",JOptionPane.INFORMATION_MESSAGE);
				//							}
				//						} catch (InterruptedException e) {
				//							// TODO Auto-generated catch block
				//							e.printStackTrace();
				//						}
				//					};
				//				}.start();
			}
		});
		register_1.setFont(new Font("宋体", Font.BOLD, 15));
		register_1.setBounds(32, 0, 87, 34);
		writePanel.add(register_1);

		JButton register_1_1 = new JButton("\u8FD4\u56DE\u9996\u9875");
		register_1_1.addMouseListener(new MouseAdapter() {
			@Override
			/* return to the default page */
			public void mouseClicked(MouseEvent e) {
				cl1.show(eventPanel, "defaultPanel");
			}
		});
		register_1_1.setFont(new Font("宋体", Font.BOLD, 15));
		register_1_1.setBounds(141, 0, 103, 34);
		writePanel.add(register_1_1);

		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem() != null) {
					String content = textField_4.getText();
					if(!content.contains(comboBox.getSelectedItem().toString())) {
						textField_4.setText(textField_4.getText() + comboBox.getSelectedItem().toString() + ";");
						System.out.println(comboBox.getSelectedIndex());
					}
				}
			}
		});
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 17));
		comboBox.setBounds(694, 0, 221, 34);
		writePanel.add(comboBox);

		JLabel lblNewLabel_9 = new JLabel("\u9009\u62E9\u6536\u4EF6\u4EBA");
		lblNewLabel_9.setFont(new Font("宋体", Font.BOLD, 17));
		lblNewLabel_9.setBounds(601, 1, 103, 30);
		writePanel.add(lblNewLabel_9);

		lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_10.setBounds(257, 0, 334, 33);
		writePanel.add(lblNewLabel_10);

		lblNewLabel_10_1 = new JLabel("");
		lblNewLabel_10_1.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_10_1.setBounds(110, 141, 334, 30);
		writePanel.add(lblNewLabel_10_1);

		JPanel updatePanel = new JPanel();
		eventPanel.add(updatePanel, "updatePanel");
		updatePanel.setLayout(null);

		lblNewLabel = new JLabel("\u8BF7\u9009\u62E9\u5BC6\u94A5\u957F\u5EA6");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 18));
		lblNewLabel.setBounds(43, 22, 173, 30);
		updatePanel.add(lblNewLabel);

		JRadioButton jb1_1 = new JRadioButton("2048 bit Key(recommend)");
		jb1_1.setSelected(true);
		jb1_1.setName("jb1");
		jb1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		jb1_1.setActionCommand("2048");
		jb1_1.setBounds(43, 71, 292, 36);
		updatePanel.add(jb1_1);

		JLabel note_1 = new JLabel("The recommended key length is 2048 bit");
		note_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		note_1.setBounds(53, 113, 411, 46);
		updatePanel.add(note_1);

		JRadioButton jb2_1 = new JRadioButton("1024 bit Key");
		jb2_1.setName("jb2");
		jb2_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		jb2_1.setActionCommand("1024");
		jb2_1.setBounds(43, 158, 157, 43);
		updatePanel.add(jb2_1);

		JRadioButton jb3_1 = new JRadioButton("4096 bit Key");
		jb3_1.setName("jb3");
		jb3_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		jb3_1.setActionCommand("4096");
		jb3_1.setBounds(43, 203, 157, 36);
		updatePanel.add(jb3_1);

		JRadioButton jb4_1 = new JRadioButton("512 bit Key (not recommend)");
		jb4_1.setName("jb4");
		jb4_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		jb4_1.setActionCommand("512");
		jb4_1.setBounds(43, 242, 309, 30);
		updatePanel.add(jb4_1);

		JLabel lblTheEncryptionIs_1 = new JLabel("Encryption is fast, but it is easier to crack");
		lblTheEncryptionIs_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTheEncryptionIs_1.setBounds(53, 279, 403, 51);
		updatePanel.add(lblTheEncryptionIs_1);

		ButtonGroup group1 = new ButtonGroup();
		group1.add(jb1_1);
		group1.add(jb2_1);
		group1.add(jb3_1);
		group1.add(jb4_1);

		btnNewButton = new JButton("\u66F4\u65B0\u5BC6\u94A5");
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 20));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			/* update the key */
			public void mouseClicked(MouseEvent e) {
				String KeyLength = group1.getSelection().getActionCommand();
				String userName = clientPanel.getUserName();
				int keyLength = Integer.parseInt(KeyLength);
				clientPanel.setKeyLength(keyLength);
				clientPanel.updateKeyPair();
				clientPanel.updateUserInfo();
				JOptionPane.showMessageDialog(null,"密钥更新成功!","outPublicKey infomation",JOptionPane.INFORMATION_MESSAGE);
				btnNewButton.setEnabled(false);
			}
		});
		btnNewButton.setActionCommand("confirm");
		btnNewButton.setBounds(348, 476, 266, 51);
		updatePanel.add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("\u539F\u59CB\u5BC6\u94A5\u4FE1\u606F");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 18));
		lblNewLabel_1.setBounds(477, 22, 157, 24);
		updatePanel.add(lblNewLabel_1);

		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);	
		textArea.setBounds(491, 74, 394, 127);


		JPanel addPanel = new JPanel();
		addPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.requestFocus();
			}
		});
		eventPanel.add(addPanel, "addPanel");
		addPanel.setLayout(null);

		textArea_2 = new JTextArea();
		textArea_2.setEditable(false);
		textArea_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textArea_2.setBounds(44, 88, 830, 226);
		textArea_2.setLineWrap(true);
		textArea_2.setWrapStyleWord(true);	

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.BOLD, 17));
		textField_2.setBounds(130, 43, 384, 35);

		addPanel.add(textField_2);
		textField_2.setColumns(10);

		btnNewButton_1 = new JButton("\u9009\u62E9\u6587\u4EF6");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			/* choose the file */
			public void mouseClicked(MouseEvent e) {
				JFileChooser fcDlg = new JFileChooser();
				fcDlg.setDialogTitle("请选择待导入的公钥文件...");
				fcDlg.setCurrentDirectory(FileSystemView.getFileSystemView().getHomeDirectory());
				int returnVal = fcDlg.showOpenDialog(null);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					String filepath = fcDlg.getSelectedFile().getPath();
					textField_2.setText(filepath);
					String content = clientPanel.getPublicKeyFile(filepath);
					if(content.equals("")) {
						lblNewLabel_8.setText("文件过大,公钥解析失败!");
					}else {
						lblNewLabel_8.setText("");
						textArea_2.setText(content);
					}
				}

			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 19));
		btnNewButton_1.setBounds(536, 43, 116, 35);
		addPanel.add(btnNewButton_1);

		lblNewLabel_5 = new JLabel("\u6587\u4EF6\u8DEF\u5F84");
		lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_5.setBounds(10, 45, 110, 29);
		addPanel.add(lblNewLabel_5);

		JScrollPane jsp = new JScrollPane(textArea);
		jsp.setBounds(491, 74, 394, 127);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		updatePanel.add(jsp);

		JScrollPane jsp1 = new JScrollPane(textArea_2);
		jsp1.setBounds(10, 94, 642, 274);
		jsp1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		addPanel.add(jsp1);

		lblNewLabel_6 = new JLabel("\u90AE\u7BB1\u5730\u5740");
		lblNewLabel_6.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_6.setBounds(50, 404, 88, 29);
		addPanel.add(lblNewLabel_6);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField_3.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				/* check the email is right */

				String check = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
				String userName = textField_3.getText();
				Pattern regex = Pattern.compile(check);
				Matcher macher = regex.matcher(userName);
				boolean flag = macher.matches();
				if(flag == false) {
					userNameIsOK = false;
					textField_3.setBorder(new RoundBorder(Color.RED));
				}else {
					userNameIsOK = true;
					textField_3.setBorder(new RoundBorder(Color.GREEN));
				}
			}
		});
		textField_3.setColumns(10);
		textField_3.setBounds(148, 402, 384, 35);
		addPanel.add(textField_3);

		btnNewButton_2 = new JButton("\u5BFC\u5165\u7528\u6237");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			/* add user */
			public void mouseClicked(MouseEvent e) {
				if(userNameIsOK) {
					Friend friend = new Friend();
					int index = clientPanel.getUser().checkIsDuplicated(textField_3.getText());
					if(index == -1) {
						String filepath = textField_2.getText();
						String content = clientPanel.getPublicKeyFile(filepath);
						textArea_2.setText(content);
						boolean flag = friend.checkRSA(content);
						if(flag == true) {
							lblNewLabel_8.setText("");
							friend.setFriendMail(textField_3.getText());
							clientPanel.getUser().addFriend(friend);
							clientPanel.updateUserInfo();
							JOptionPane.showMessageDialog(null,"用户导入成功!","inPublicKey infomation",JOptionPane.INFORMATION_MESSAGE);
						}else {
							lblNewLabel_8.setText("公钥格式检查失败!");
						}
					}else {
						// update the public key
						boolean flag = friend.checkRSA(textArea_2.getText());
						if(flag == true) {
							clientPanel.getUser().getFriend().elementAt(index).checkRSA(textArea_2.getText());
							JOptionPane.showMessageDialog(null,"用户公钥更新成功!","update PublicKey infomation",JOptionPane.INFORMATION_MESSAGE);
							friend = null;
						}else {
							JOptionPane.showMessageDialog(null,"用户公钥更新失败!","update PublicKey infomation",JOptionPane.INFORMATION_MESSAGE);
							lblNewLabel_8.setText("公钥格式检查失败!");
							friend = null;
						}
					}
				}
			}

		});
		btnNewButton_2.setFont(new Font("宋体", Font.BOLD, 19));
		btnNewButton_2.setBounds(633, 500, 116, 35);
		addPanel.add(btnNewButton_2);

		lblNewLabel_7 = new JLabel("\u7528\u6237\u5217\u8868");
		lblNewLabel_7.setFont(new Font("宋体", Font.BOLD, 18));
		lblNewLabel_7.setBounds(763, 44, 99, 35);
		addPanel.add(lblNewLabel_7);

		lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setFont(new Font("宋体", Font.BOLD, 18));
		lblNewLabel_8.setBounds(54, 520, 504, 35);
		addPanel.add(lblNewLabel_8);

		userlist = new JList();
		userlist.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int index = userlist.getSelectedIndex();
				if(index != -1) {
					String content = clientPanel.getUser().getFriend().elementAt(index).getPublicKey().toString();
					String name = (String) userlist.getSelectedValue();
					textArea_2.setText(content);
					textField_3.setText(name);
				}
			}
		});
		userlist.setFont(new Font("Times New Roman", Font.BOLD, 20));
		userlist.setBounds(727, 88, 188, 385);

		JScrollPane jsp2 = new JScrollPane(userlist);
		jsp2.setBounds(697, 88, 218, 385);
		jsp2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		addPanel.add(jsp2);

		JButton btnNewButton_2_1 = new JButton("\u5220\u9664\u7528\u6237");
		btnNewButton_2_1.addMouseListener(new MouseAdapter() {
			@Override
			/* delete the selected user */
			public void mouseClicked(MouseEvent e) {
				String selectedUser = userlist.getSelectedValue().toString();
				int index = clientPanel.getUser().checkIsDuplicated(selectedUser);
				if(index != -1) {
					boolean flag =  clientPanel.getUser().deleteFriend(index);
					if(flag == true) {
						clientPanel.updateUserInfo();
						userlist.remove(index);
						JOptionPane.showMessageDialog(null,"用户公钥删除成功!","delPublicKey infomation",JOptionPane.INFORMATION_MESSAGE);
					}else {
						lblNewLabel_8.setText("用户删除失败!");
						JOptionPane.showMessageDialog(null,"用户公钥删除失败!","delPublicKey infomation",JOptionPane.INFORMATION_MESSAGE);
					}
				}else {
					
				}
			}
		});
		btnNewButton_2_1.setFont(new Font("宋体", Font.BOLD, 19));
		btnNewButton_2_1.setBounds(786, 500, 116, 35);
		addPanel.add(btnNewButton_2_1);

		lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setIcon(new ImageIcon(Client.class.getResource("/source/warning.png")));
		lblNewLabel_13.setBounds(60, 445, 64, 51);
		addPanel.add(lblNewLabel_13);

		lblNewLabel_14 = new JLabel("\u540C\u6837\u7528\u6237\u518D\u6B21\u5BFC\u5165\u516C\u94A5\u89C6\u4E3A\u66F4\u65B0\uFF01");
		lblNewLabel_14.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_14.setBounds(144, 459, 386, 36);
		addPanel.add(lblNewLabel_14);

		lblNewLabel_2 = new JLabel("modulus");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(487, 49, 99, 24);
		updatePanel.add(lblNewLabel_2);

		textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setFocusTraversalKeysEnabled(false);
		textArea_1.setWrapStyleWord(true);
		textArea_1.setLineWrap(true);
		textArea_1.setBounds(491, 247, 394, 30);
		updatePanel.add(textArea_1);


		lblNewLabel_3 = new JLabel("exponent");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3.setBounds(491, 216, 95, 24);
		updatePanel.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("\u539F\u59CB\u5BC6\u94A5\u5C06\u4F1A\u88AB\u9500\u6BC1\uFF0C\u8BF7\u8C28\u614E\u64CD\u4F5C\uFF01");
		lblNewLabel_4.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_4.setBounds(127, 354, 386, 36);
		updatePanel.add(lblNewLabel_4);

		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon(Client.class.getResource("/source/warning.png")));
		lblNewLabel_12.setBounds(43, 340, 64, 51);
		updatePanel.add(lblNewLabel_12);

		showPanel = new JPanel();
		eventPanel.add(showPanel, "showPanel");
		showPanel.setLayout(null);

		textArea_4 = new JTextArea();
		textArea_4.setEditable(false);
		textArea_4.setFont(new Font("宋体", Font.BOLD, 18));
		textArea_4.setBounds(10, 169, 905, 409);
		//		showPanel.add(textArea_4);

		JScrollPane jsp4 = new JScrollPane(textArea_4);
		jsp4.setBounds(10, 169, 905, 409);
		jsp4.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		showPanel.add(jsp4);

		JLabel lblNewLabel_20 = new JLabel("\u65F6\u95F4\u6233");
		lblNewLabel_20.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_20.setBounds(16, 70, 73, 25);
		showPanel.add(lblNewLabel_20);

		lblNewLabel_21 = new JLabel("");
		lblNewLabel_21.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_21.setBounds(99, 70, 267, 22);
		showPanel.add(lblNewLabel_21);

		JLabel lblNewLabel_20_1 = new JLabel("\u53D1\u4EF6\u4EBA:");
		lblNewLabel_20_1.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_20_1.setBounds(376, 70, 81, 25);
		showPanel.add(lblNewLabel_20_1);

		lblNewLabel_21_1 = new JLabel("");
		lblNewLabel_21_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_21_1.setBounds(452, 70, 175, 22);
		showPanel.add(lblNewLabel_21_1);

		JLabel lblNewLabel_20_2 = new JLabel("\u6536\u4EF6\u4EBA:");
		lblNewLabel_20_2.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_20_2.setBounds(637, 70, 81, 25);
		showPanel.add(lblNewLabel_20_2);

		lblNewLabel_21_2 = new JLabel("");
		lblNewLabel_21_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_21_2.setBounds(715, 70, 160, 22);
		showPanel.add(lblNewLabel_21_2);

		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setFont(new Font("宋体", Font.BOLD, 17));
		textField_7.setBounds(147, 122, 740, 31);
		showPanel.add(textField_7);
		textField_7.setColumns(10);

		JLabel lblNewLabel_20_3 = new JLabel("\u90AE\u4EF6\u6458\u8981");
		lblNewLabel_20_3.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_20_3.setBounds(27, 125, 91, 25);
		showPanel.add(lblNewLabel_20_3);

		JButton btnNewButton_9 = new JButton("\u8FD4\u56DE");
		btnNewButton_9.addMouseListener(new MouseAdapter() {
			@Override
			/* return */
			public void mouseClicked(MouseEvent e) {
				cl1.show(eventPanel, "sentPanel");
			}
		});
		btnNewButton_9.setFont(new Font("宋体", Font.BOLD, 18));
		btnNewButton_9.setBounds(10, 10, 97, 39);
		showPanel.add(btnNewButton_9);

		JButton btnNewButton_9_1 = new JButton("\u4E0A\u4E00\u5C01");
		btnNewButton_9_1.addMouseListener(new MouseAdapter() {
			@Override
			/* last */
			public void mouseClicked(MouseEvent e) {
				if(index>0) {
					index--;
					lblNewLabel_22.setText(null);
					String time = clientPanel.getUser().getSendMail().elementAt(index).getDate().toString();
					String recv = clientPanel.getUser().getSendMail().elementAt(index).getMailRecv();
					String send = clientPanel.getUserName();
					String content = clientPanel.getUser().getSendMail().elementAt(index).getContent();
					String digest = clientPanel.getUser().getSendMail().elementAt(index).getemailDigest();
					lblNewLabel_21.setText(time);
					lblNewLabel_21_1.setText(send);
					lblNewLabel_21_2.setText(recv);
					textField_7.setText(digest);
					textArea_4.setText(content);
				}else {
					lblNewLabel_22.setText("已经是第一封了!");
				}
			}
		});
		btnNewButton_9_1.setFont(new Font("宋体", Font.BOLD, 18));
		btnNewButton_9_1.setBounds(147, 10, 97, 39);
		showPanel.add(btnNewButton_9_1);

		JButton btnNewButton_9_2 = new JButton("\u4E0B\u4E00\u5C01");
		btnNewButton_9_2.addMouseListener(new MouseAdapter() {
			@Override
			/* next */
			public void mouseClicked(MouseEvent e) {
				if(index<model.getRowCount()-1) {
					index++;
					lblNewLabel_22.setText(null);
					String time = clientPanel.getUser().getSendMail().elementAt(index).getDate().toString();
					String recv = clientPanel.getUser().getSendMail().elementAt(index).getMailRecv();
					String send = clientPanel.getUserName();
					String content = clientPanel.getUser().getSendMail().elementAt(index).getContent();
					String digest = clientPanel.getUser().getSendMail().elementAt(index).getemailDigest();
					lblNewLabel_21.setText(time);
					lblNewLabel_21_1.setText(send);
					lblNewLabel_21_2.setText(recv);
					textField_7.setText(digest);
					textArea_4.setText(content);
				}else {
					lblNewLabel_22.setText("已经是最后一封了!");
				}
			}
		});
		btnNewButton_9_2.setFont(new Font("宋体", Font.BOLD, 18));
		btnNewButton_9_2.setBounds(288, 10, 97, 39);
		showPanel.add(btnNewButton_9_2);

		JButton btnNewButton_9_3 = new JButton("\u5220\u9664");
		btnNewButton_9_3.addMouseListener(new MouseAdapter() {
			@Override
			/* delete */
			public void mouseClicked(MouseEvent e) {
				boolean flag =  clientPanel.getUser().deleteSendMail(index);
				if(flag == true) {
					model.removeRow(index);
					clientPanel.updateUserInfo();
					lblNewLabel_22.setText("此邮件删除成功!");
				}else {
					JOptionPane.showMessageDialog(null,"删除失败!","delete infomation",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnNewButton_9_3.setFont(new Font("宋体", Font.BOLD, 18));
		btnNewButton_9_3.setBounds(419, 10, 97, 39);
		showPanel.add(btnNewButton_9_3);

		lblNewLabel_22 = new JLabel("");
		lblNewLabel_22.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_22.setBounds(526, 10, 349, 39);
		showPanel.add(lblNewLabel_22);

		Name = new JLabel("");
		Name.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Name.setBounds(0, 35, 181, 33);
		clientPanel.add(Name);
		JButton output = new JButton("\u5BFC\u51FA\u516C\u94A5");
		output.setIcon(new ImageIcon(Client.class.getResource("/source/publicKey.png")));
		output.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/* output the publicKey to the Desktop */
				FileSystemView view = FileSystemView.getFileSystemView();
				String path = view.getHomeDirectory().toString();
				clientPanel.outputPublicKey(path);
				JOptionPane.showMessageDialog(null,"导出成功!公钥已导出至桌面!","outPublicKey infomation",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		output.setName("output");
		output.setBounds(10, 455, 128, 43);
		clientPanel.add(output);

		JButton btnNewButton_13 = new JButton("");
		btnNewButton_13.addMouseListener(new MouseAdapter() {
			@Override
			/* return the default panel */
			public void mouseClicked(MouseEvent e) {
				cl1.show(eventPanel, "defaultPanel");
			}
		});
		btnNewButton_13.setIcon(new ImageIcon(Client.class.getResource("/source/index.png")));
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_13.setForeground(Color.WHITE);
		btnNewButton_13.setBackground(Color.WHITE);
		btnNewButton_13.setBorder(null);
		btnNewButton_13.setOpaque(false);
		btnNewButton_13.setFocusable(false);
		btnNewButton_13.setBounds(10, 2, 32, 32);
		clientPanel.add(btnNewButton_13);


		JLabel title = new JLabel("\u6B22\u8FCE\u4F7F\u7528PGP\u5B89\u5168\u7535\u5B50\u90AE\u4EF6\u7CFB\u7EDF");
		title.setFont(new Font("宋体", Font.BOLD, 54));
		title.setBounds(135, 61, 791, 94);
		title.setName("title");
		userLoginPanel.add(title);

		JLabel mailId = new JLabel("\u7528\u6237\u540D");
		mailId.setFont(new Font("宋体", Font.BOLD, 20));
		mailId.setBounds(341, 235, 70, 40);
		userLoginPanel.add(mailId);

		JLabel password = new JLabel("\u5BC6\u7801");
		password.setFont(new Font("宋体", Font.BOLD, 20));
		password.setBounds(349, 333, 58, 24);
		userLoginPanel.add(password);

		passwordField = new JPasswordField();
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			/* input the password*/
			public void focusGained(FocusEvent e) {
				new Thread() {
					public void run() {
						String userMail = textField.getText();
						File file = new File(MD.MD5(userMail));
						if(file.checkExist(MD.MD5(userMail)) == true) {
							User user = new User();
							user = file.readObj();
							if(user.getRemember() == true) {
								passwordField.setText("************");
								isRemember = true;
								chckbxNewCheckBox.setSelected(true);
								user = null;
							}else {
								user = null;
								isRemember = false;
							}
						}else {
							return;
						}
					};
				}.start();

			}
		});
		passwordField.setFont(new Font("宋体", Font.BOLD, 25));
		passwordField.setBounds(456, 321, 270, 46);
		userLoginPanel.add(passwordField);

		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.BOLD, 25));
		textField.setBounds(456, 232, 270, 46);
		userLoginPanel.add(textField);
		textField.setColumns(10);
		textField.setMargin(new Insets(0,2,0,0));
		JButton submit = new JButton("\u767B   \u5F55");
		submit.setFont(new Font("宋体", Font.BOLD, 23));
		submit.addMouseListener(new MouseAdapter() {
			@Override
			/* user login*/
			public void mouseClicked(MouseEvent e) {
				if(isRemember) {
					File filetemp = new File(MD.MD5(textField.getText()));
					User usertemp = new User();
					usertemp = filetemp.readObj();
					clientPanel.setRSAKey(usertemp.getKey());
					clientPanel.setUser(usertemp);
					Name.setText(usertemp.getName());
					clientPanel.getUser().setRemember(chckbxNewCheckBox.isSelected());
					clientPanel.updateUserInfo();
					cl.show(panel, "clientPanel");
					new Thread(){
						public void run() {
							cl1.show(eventPanel, "defaultPanel");
						};
					}.start();
				}
				String mailId = textField.getText();
				String passord = new String(passwordField.getPassword());
				if(mailId.isEmpty()) {
					// mailId is empty
					infomation.setText("邮箱名不可以为空!");
					return;
				}
				if(passord.isEmpty()) {
					// password is empty
					infomation.setText("密码不可以为空");
					passwordField.setBorder(new RoundBorder(Color.RED));
					return;
				}

				passord = MD.MD5(passord);

				/* validation the information of users */
				String fileName = MD.MD5(mailId);
				File file = new File(fileName);
				if(file.checkExist(fileName)){
					User user = new User();
					user = file.readObj();
					if(user.getName().equals(mailId) && user.getPassword().equals(passord)) {
						clientPanel.setRSAKey(user.getKey());
						clientPanel.setUser(user);
						clientPanel.getUser().setRemember(chckbxNewCheckBox.isSelected());
						Name.setText(mailId);
						clientPanel.updateUserInfo();
						passwordField.setText("");
						cl.show(panel, "clientPanel");
					}else {
						infomation.setText("密码错误!");
						passwordField.setText("");
						passwordField.setBorder(new RoundBorder(Color.RED));
					}	
				}else {
					infomation.setText("用户不存在,请检查账号");
				}
			}
		});
		submit.setBounds(623, 459, 250, 53);
		userLoginPanel.add(submit);

		exit = new JButton("\u9000   \u51FA");
		exit.addMouseListener(new MouseAdapter() {
			/* exit from the PGP system*/
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					clientPanel.getSocket().close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.exit(0);
			}
		});
		exit.setFont(new Font("宋体", Font.BOLD, 23));
		exit.setBounds(196, 459, 250, 53);
		userLoginPanel.add(exit);

		JButton register = new JButton("\u6CE8\u518C");
		register.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cl.show(panel, "Register");
				Register.requestFocus();
			}
		});
		register.setFont(new Font("宋体", Font.BOLD, 15));
		register.setBounds(403, 391, 87, 34);
		userLoginPanel.add(register);

		infomation = new JLabel("");
		infomation.setFont(new Font("宋体", Font.BOLD, 19));
		infomation.setBounds(665, 335, 208, 32);
		userLoginPanel.add(infomation);

		chckbxNewCheckBox = new JCheckBox("\u8BB0\u4F4F\u5BC6\u7801");
		chckbxNewCheckBox.setFont(new Font("宋体", Font.BOLD, 18));
		chckbxNewCheckBox.setBounds(558, 393, 123, 28);
		userLoginPanel.add(chckbxNewCheckBox);

		textField_6 = new JTextField();
		textField_6.setText("127.0.0.1");
		textField_6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField_6.addFocusListener(new FocusAdapter() {
			@Override
			/* check the ip addr is valid */
			public void focusLost(FocusEvent e) {
				String ip = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}"; 
				String inputIp = textField_6.getText();
				Pattern pattern = Pattern.compile(ip);
				Matcher matcher = pattern.matcher(inputIp);
				boolean flag = matcher.matches();
				if(flag == true) {
					textField_6.setBorder(new RoundBorder(Color.GREEN));
				}else {
					textField_6.setBorder(new RoundBorder(Color.RED));
				}

			}
		});
		textField_6.setBounds(951, 10, 123, 32);
		userLoginPanel.add(textField_6);
		textField_6.setColumns(10);

		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon(Client.class.getResource("/source/user.png")));
		lblNewLabel_11.setBounds(414, 240, 32, 32);
		userLoginPanel.add(lblNewLabel_11);

		JLabel lblNewLabel_11_1 = new JLabel("");
		lblNewLabel_11_1.setIcon(new ImageIcon(Client.class.getResource("/source/lock.png")));
		lblNewLabel_11_1.setBounds(414, 329, 32, 32);
		userLoginPanel.add(lblNewLabel_11_1);

		lblNewLabel_30 = new JLabel("");
		lblNewLabel_30.setIcon(new ImageIcon(Client.class.getResource("/source/P.png")));
		lblNewLabel_30.setBounds(10, 0, 64, 64);
		userLoginPanel.add(lblNewLabel_30);

		lblNewLabel_31 = new JLabel("");
		lblNewLabel_31.setIcon(new ImageIcon(Client.class.getResource("/source/g.png")));
		lblNewLabel_31.setBounds(108, 0, 64, 64);
		userLoginPanel.add(lblNewLabel_31);

		lblNewLabel_32 = new JLabel("");
		lblNewLabel_32.setIcon(new ImageIcon(Client.class.getResource("/source/P.png")));
		lblNewLabel_32.setBounds(203, 0, 64, 64);
		userLoginPanel.add(lblNewLabel_32);
		Register = new JPanel();
		Register.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.requestFocus();
			}
		});
		panel.add(Register, "Register");
		Register.setLayout(null);

		title_1 = new JLabel("\u6B22\u8FCE\u4F7F\u7528PGP\u5B89\u5168\u7535\u5B50\u90AE\u4EF6\u7CFB\u7EDF");
		title_1.setBounds(135, 61, 791, 94);
		title_1.setName("title");
		title_1.setFont(new Font("宋体", Font.BOLD, 54));
		Register.add(title_1);

		mailIdRegister = new JLabel("\u90AE\u7BB1\u5730\u5740");
		mailIdRegister.setBounds(95, 207, 101, 40);
		mailIdRegister.setFont(new Font("宋体", Font.BOLD, 20));
		Register.add(mailIdRegister);

		passwordRegister = new JLabel("\u5BC6\u7801");
		passwordRegister.setBounds(118, 308, 58, 24);
		passwordRegister.setFont(new Font("宋体", Font.BOLD, 20));
		Register.add(passwordRegister);

		passwordField_1 = new JPasswordField();
		passwordField_1.setMargin(new Insets(4,4,0,0));
		passwordField_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String password = new String(passwordField_1.getPassword());
				if(password.length()>8) {
					passwordField_1.setBorder(new RoundBorder(Color.GREEN));
					pswIsOK = true;
				}else {
					passwordField_1.setBorder(new RoundBorder(Color.RED));
					pswIsOK = false;
				}
			}
		});
		passwordField_1.setEchoChar('*');
		passwordField_1.setBounds(223, 296, 270, 46);
		passwordField_1.setFont(new Font("宋体", Font.BOLD, 25));
		passwordField_1.setBorder(new RoundBorder());
		Register.add(passwordField_1);

		textField_1 = new JTextField();
		textField_1.setBackground(Color.WHITE);
		textField_1.setToolTipText("");
		textField_1.setBorder(new RoundBorder());
		textField_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String check = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
				String userName = textField_1.getText();
				Pattern regex = Pattern.compile(check);
				Matcher macher = regex.matcher(userName);
				boolean flag = macher.matches();
				if(flag == false) {
					textField_1.setBorder(new RoundBorder(Color.RED));
					userNameIsOK = false;
				}else {
					textField_1.setBorder(new RoundBorder(Color.GREEN));
					userNameIsOK = true;
				}
			}
		});
		textField_1.setBounds(223, 203, 270, 46);	
		textField_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		textField_1.setColumns(10);

		Register.add(textField_1);

		JLabel passwordComfim = new JLabel("\u786E\u8BA4\u5BC6\u7801");
		passwordComfim.setBounds(118, 410, 95, 24);
		passwordComfim.setFont(new Font("宋体", Font.BOLD, 20));
		Register.add(passwordComfim);

		passwordField_2 = new JPasswordField();
		passwordField_2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String passwordComfirm = new String(passwordField_2.getPassword());
				String password = new String(passwordField_1.getPassword());
				if(passwordComfirm.equals(password)) {
					passwordField_2.setBorder(new RoundBorder(Color.GREEN));
					if(pswIsOK == false) {
						pswComfirmIsOK = false;
					}else {
						pswComfirmIsOK = true;
					}
				}else {
					passwordField_2.setBorder(new RoundBorder(Color.RED));
					pswComfirmIsOK = false;
				}
			}
		});
		passwordField_2.setEchoChar('*');
		passwordField_2.setBounds(223, 398, 270, 46);
		passwordField_2.setFont(new Font("宋体", Font.BOLD, 25));
		passwordField_2.setBorder(new RoundBorder());
		Register.add(passwordField_2);

		JRadioButton jb1 = new JRadioButton("2048 bit Key(recommend)");
		jb1.setSelected(true);
		jb1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		jb1.setBounds(584, 189, 292, 36);
		jb1.setName("jb1");
		jb1.setActionCommand("2048");
		Register.add(jb1);

		JRadioButton jb2 = new JRadioButton("1024 bit Key");
		jb2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		jb2.setBounds(584, 276, 157, 43);
		jb2.setName("jb2");
		jb2.setActionCommand("1024");
		Register.add(jb2);

		JRadioButton jb3 = new JRadioButton("4096 bit Key");
		jb3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		jb3.setBounds(584, 321, 157, 36);
		jb3.setName("jb3");
		jb3.setActionCommand("4096");
		Register.add(jb3);

		JRadioButton jb4 = new JRadioButton("512 bit Key (not recommend)");
		jb4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		jb4.setBounds(584, 360, 309, 30);
		jb4.setName("jb4");
		jb4.setActionCommand("512");
		Register.add(jb4);

		ButtonGroup group = new ButtonGroup();
		group.add(jb1);
		group.add(jb2);
		group.add(jb3);
		group.add(jb4);

		JLabel note = new JLabel("The recommended key length is 2048 bit");
		note.setFont(new Font("Times New Roman", Font.BOLD, 20));
		note.setBounds(594, 231, 411, 46);
		Register.add(note);

		JLabel lblTheEncryptionIs = new JLabel("Encryption is fast, but it is easier to crack");
		lblTheEncryptionIs.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTheEncryptionIs.setBounds(594, 397, 482, 51);
		Register.add(lblTheEncryptionIs);

		btnRegister = new JButton("\u6CE8  \u518C");
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/* register */
				if(userNameIsOK && pswIsOK && pswComfirmIsOK) {
					String KeyLength = group.getSelection().getActionCommand();
					String userName = textField_1.getText();
					if(zip.checkExist(MD.MD5(userName))) {
						JOptionPane.showMessageDialog(null,"用户注册失败!请更换用户名!","Register failed!",JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					String password = new String(passwordField_1.getPassword());
					password = MD.MD5(password);
					int keyLength = Integer.parseInt(KeyLength);
					PGPRSA rsa = new PGPRSA();
					rsa.setKeyLength(keyLength);
					rsa.generateKeyPair();
					KeyPair key = rsa.getKey();
					User user = new User(userName,password,keyLength,key);
					File file = new File(MD.MD5(userName));
					/* save the user obj */
					file.writeObj(user);
					textField.setText(userName);
					JOptionPane.showMessageDialog(null,"用户注册成功!","Register successfully!",JOptionPane.INFORMATION_MESSAGE);
				}else {

					return;
				}
			}
		});
		btnRegister.setFont(new Font("宋体", Font.BOLD, 15));
		btnRegister.setBounds(272, 489, 215, 40);
		Register.add(btnRegister);

		Return = new JButton("\u8FD4\u56DE\u767B\u5F55");
		Return.addMouseListener(new MouseAdapter() {
			@Override
			/* return to login in */
			public void mouseClicked(MouseEvent e) {
				userNameIsOK = false;
				pswIsOK = false;
				pswComfirmIsOK = false;
				textField_1.setText(null);
				passwordField_1.setText(null);
				passwordField_2.setText(null);
				cl.show(panel, "userLoginPanel");
			}
		});
		Return.setFont(new Font("宋体", Font.BOLD, 15));
		Return.setBounds(662, 489, 215, 40);
		Register.add(Return);
		cl1.show(eventPanel, "defaultPanel");
	}
}
