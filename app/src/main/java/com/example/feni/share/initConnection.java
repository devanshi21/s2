package com.example.feni.share;

/**
 * Created by Feni on 02-03-2018.
 */

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GraphicsDevice;
import java.awt.Robot;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.lang.String;
import org.openqa.selenium.Rectangle;

public class InitConnection extends Activity {

    ServerSocket socket = null;
    DataInputStream password = null;
    DataOutputStream verify = null;
    String width="";
    String height="";

    InitConnection(int port,String value1){
        Robot robot = null;
        Rectangle rectangle = null;
        try{
            System.out.println("Awaiting Connection from Client");
            socket=new ServerSocket(port);

            GraphicsEnvironment gEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice gDev = gEnv.getDefaultScreenDevice();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowmanager = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
            windowmanager.getDefaultDisplay().getMetrics(displayMetrics);
            int deviceWidth = displayMetrics.widthPixels;
            int deviceHeight = displayMetrics.heightPixels;
            rectangle=new Rectangle(dim);
            robot=new Robot(gDev);

            drawGUI();

            while(true){
                Socket sc=socket.accept();
                password=new DataInputStream(sc.getInputStream());
                verify=new DataOutputStream(sc.getOutputStream());
                //String username=password.readUTF();
                String pssword=password.readUTF();
                if(pssword.equals(value1)){
                    verify.writeUTF("valid");
                    verify.writeUTF(width);
                    verify.writeUTF(height);
                    new SendScreen(sc,robot,rectangle);
                    new ReceiveEvents(sc,robot);}
                else{
                    verify.writeUTF("Invalid");
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    private void drawGUI(){
    }
}
