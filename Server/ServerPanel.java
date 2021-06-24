import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JPanel;

import com.sun.xml.internal.ws.policy.spi.PolicyAssertionValidator.Fitness;

public class ServerPanel extends JPanel{
	private ServerSocket serverSocket;
	private int port;
	public ServerPanel(){
		this.port = 9999;
		try {
			this.serverSocket = new ServerSocket(port);
			new Thread() {
				public void run() {
					startServer();
				};
			}.start();

//			new Thread(){
//				@Override
//				public void run() {
//					// TODO Auto-generated method stub
//					super.run();
//					for(int i=0;i<Server.contentStore.size();i++) {
//						String name = Server.contentStore.elementAt(i);
//						String fileName = MD.MD5(name);
//						String time = new Date(System.currentTimeMillis()).toString();
//						long size = zip.getFileSize(fileName);
//						String size_ = Long.toString(size) + "KB";
//						Server.model.addRow(new Object[] {fileName,time,"-","-",size_});
//					}
//				}
//			}.start();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void startServer() {
		ExecutorService exec = Executors.newCachedThreadPool();
		try {
			while(true) {
				Socket socket = serverSocket.accept();
				exec.execute(new SingleServer(socket));
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			try {
				serverSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
