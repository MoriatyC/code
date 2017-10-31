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
    	 * ����������ԭ�������client����ͬ*/
        try {
            try {
                server = new ServerSocket(PORT);
                 
                while(true)
                {
                	//���ܿͻ�������
                	client = server.accept();   
                    dis = new DataInputStream(client.getInputStream());
                    dos = new DataOutputStream(client.getOutputStream());
                    
                    int len = dis.readInt();
                    method = "";
                    //��÷���������
                    for (int i = 0; i < len;i++) 
                    {
                    	method = method + dis.readChar();                   
                    }                    
                    command = method.split(" ");
                    method = command[0];
                    local_filename = command[5];//localΪ�ͻ���
                    remote_filename = command[6];//remoteΪ����
                    
                    //ִ��put�ļ�����
	                 if("put".equals(method))
	                 { 
	                	
	                	String fileName = dis.readUTF();
	                    long fileLength = dis.readLong();
	                    //���ؽ���Ŀ¼
	                    fos =new FileOutputStream(new File("e:/out/" + remote_filename));
	                     
	                    byte[] sendBytes = new byte[1024];
	                    int transLen =0;
	                    System.out.println("----��ʼ�����ļ�<" + fileName +">,�ļ���СΪ<" + fileLength +"Byte>----");
	                    while(true)
	                    {
	                        int read = 0;
	                        read = dis.read(sendBytes);
	                        if(read == -1)
	                            break;
	                        transLen += read;
	                        System.out.println("�����ļ�����" +100 * transLen/fileLength +"%...");
	                        fos.write(sendBytes,0, read);
	                        fos.flush();
	                        if(1==(transLen/fileLength))
	                        	break;
	                    }
	                    System.out.println("----�����ļ�<" + fileName +">�ɹ�-------");
	                    //���ͽ�������
	                    dos.writeUTF("�ļ�����ɹ�");
	                    client.close();
	                 }
	                 //ִ��Get����
	                 if("get".equals(method))
	                 {         	
	                	 //��ͻ��˴����ļ�
			                File file = new File("e:/out/"+local_filename);
			                fis = new FileInputStream(file);
			                dos = new DataOutputStream(client.getOutputStream());
			                //�ļ���������ָ��
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
			                //ִ����ɷ���
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