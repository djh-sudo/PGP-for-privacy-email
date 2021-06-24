import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Hashtable;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Server {

	private JFrame frame;
	private ServerPanel panel;
	public static Hashtable<String, Vector<byte[]>>hash;
	public static Vector<String>contentStore;
	private JTable table;
	private JScrollPane jsp;
	public static DefaultTableModel model;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Server window = new Server();
//					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Server() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1219, 576);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new ServerPanel();
		panel.setBounds(10, 10, 1185, 519);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
//		frame.addWindowListener(new WindowListener() {
//
//			@Override
//			public void windowOpened(WindowEvent e) {
//				// TODO Auto-generated method stub
//				contentStore = (Vector<String>) zip.readObj("hash");
//			}
//
//			@Override
//			public void windowClosing(WindowEvent e) {
//				// TODO Auto-generated method stub
//				zip.writeObj(contentStore, "hash");	
//			}
//
//			@Override
//			public void windowClosed(WindowEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void windowIconified(WindowEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void windowDeiconified(WindowEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void windowActivated(WindowEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void windowDeactivated(WindowEvent e) {
//				// TODO Auto-generated method stub
//				
//			}});
		Object[][] tableData = {};
		Object[] columnTitle = {"文件","时间" , "收件人" , "发件人","大小"};
		model = new DefaultTableModel(tableData,columnTitle);
		
		table = new JTable(model);
		table.setRowHeight(40);
		table.getColumnModel().getColumn(0).setPreferredWidth(300);
		table.getColumnModel().getColumn(0).setMaxWidth(300);
		table.getColumnModel().getColumn(0).setMinWidth(300);
		
		table.getColumnModel().getColumn(1).setPreferredWidth(300);
		table.getColumnModel().getColumn(1).setMaxWidth(300);
		table.getColumnModel().getColumn(1).setMinWidth(300);
		table.setFont(new Font("宋体", Font.BOLD, 17));

		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumn("文件").setCellRenderer(renderer);
		table.getColumn("时间").setCellRenderer(renderer);
		table.getColumn("收件人").setCellRenderer(renderer);
		table.getColumn("发件人").setCellRenderer(renderer);
		table.getColumn("大小").setCellRenderer(renderer);

		jsp = new JScrollPane(table);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(10, 10, 1165, 499);

		table.setBounds(10, 10, 1165, 499);
		panel.add(jsp);
		hash = new Hashtable<String, Vector<byte[]>>();
	}
}
