package os;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
 

public class Server extends ServerSocket{
 
    private static final int PORT = 3990;
    private ServerSocket server;
    private Socket client;
    private DataInputStream dis;
    private DataOutputStream dos;
    private FileOutputStream fos;
    private FileInputStream fis;
    private BufferedReader in;
    private String method="";
    private String local_filename;
    private String remote_filename;
    private String[] command;
    public Server()throws Exception{
    	/**
    	 * 服务器运行原理大致与client端相同*/
        try {
            try {
                server = new ServerSocket(PORT);
                 
                while(true)
                {
                	//接受客户端连接
                	client = server.accept();   
                    dis = new DataInputStream(client.getInputStream());
                    dos = new DataOutputStream(client.getOutputStream());
                    
                    int len = dis.readInt();
                    method = "";
                    //获得发来的命令
                    for (int i = 0; i < len;i++) 
                    {
                    	method = method + dis.readChar();                   
                    }                    
                    command = method.split(" ");
                    method = command[0];
                    local_filename = command[5];//local为客户端
                    remote_filename = command[6];//remote为本机
                    
                    //执行put文件操作
	                 if("put".equals(method))
	                 { 
	                	
	                	String fileName = dis.readUTF();
	                    long fileLength = dis.readLong();
	                    //本地接受目录
	                    fos =new FileOutputStream(new File("e:/out/" + remote_filename));
	                     
	                    byte[] sendBytes = new byte[1024];
	                    int transLen =0;
	                    System.out.println("----开始接收文件<" + fileName +">,文件大小为<" + fileLength +"Byte>----");
	                    while(true)
	                    {
	                        int read = 0;
	                        read = dis.read(sendBytes);
	                        if(read == -1)
	                            break;
	                        transLen += read;
	                        System.out.println("接收文件进度" +100 * transLen/fileLength +"%...");
	                        fos.write(sendBytes,0, read);
	                        fos.flush();
	                        if(1==(transLen/fileLength))
	                        	break;
	                    }
	                    System.out.println("----接收文件<" + fileName +">成功-------");
	                    //发送结束反馈
	                    dos.writeUTF("文件传输成功");
	                    client.close();
	                 }
	                 //执行Get操作
	                 if("get".equals(method))
	                 {         	
	                	 //向客户端传送文件
			                File file = new File("e:/out/"+local_filename);
			                fis = new FileInputStream(file);
			                dos = new DataOutputStream(client.getOutputStream());
			                //文件名、长度指令
			                dos.writeUTF(file.getName());
			                dos.flush();
			                dos.writeLong(file.length());
			                dos.flush();
			                byte[] sendBytes = new byte[1024];
			                int length = 0;
			                while((length = fis.read(sendBytes,0, sendBytes.length)) >0)
			                {
			                    dos.write(sendBytes,0, length);
			                    dos.flush();
			                }
			                //执行完成反馈
			           System.out.println(dis.readUTF());
	                }
                 }
            }catch (Exception e) {
                e.printStackTrace();
            }finally {
                if(dis !=null)
                    dis.close();
                if(fos !=null)
                    fos.close();
                server.close();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
     
    public static void main(String[] args)throws Exception {
        new Server();
    }
}