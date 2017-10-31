package os;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;
 
/**
 * �ͻ���
 */
public class SocketServer extends Socket{
     
    private static final String SERVER_IP ="127.0.0.1";
    private static final int SERVER_PORT =2013;
     
    private Socket client;
    private FileInputStream fis;
    private DataOutputStream dos;
     
    public SocketServer(){
        try {
            try {
                client =new Socket(SERVER_IP, SERVER_PORT);
                //�����˴����ļ�
                File file =new File("e:/in/taday.txt");
                fis =new FileInputStream(file);
                dos =new DataOutputStream(client.getOutputStream());
                 
                //�ļ����ͳ���
                dos.writeUTF(file.getName());
                dos.flush();
                dos.writeLong(file.length());
                dos.flush();
                 
                //�����ļ�
                byte[] sendBytes =new byte[1024];
                int length =0;
                while((length = fis.read(sendBytes,0, sendBytes.length)) >0){
                    dos.write(sendBytes,0, length);
                    dos.flush();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }finally{
                if(fis !=null)
                    fis.close();
                if(dos !=null)
                    dos.close();
                client.close();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
     
    public static void main(String[] args)throws Exception {
        new SocketServer();
    }
}