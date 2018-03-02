package com.example.feni.share;

/**
 * Created by Feni on 02-03-2018.
 */
//import java.awt.Rectangle;
//import java.awt.Robot;
//import java.awt.image.BufferedImage;
import android.graphics.Bitmap;
import android.net.wifi.p2p.WifiP2pManager;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.io.File;


//import javax.imageio.ImageIO;
import java.io.File;

import java.io.IOException;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.Rectangle;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.Test;

public class SendScreen extends Thread {

    Socket socket=null;
   // Robot robot=null;
    Rectangle rectangle=null;
    boolean continueLoop=true;
    OutputStream oos=null;
    public SendScreen(Socket socket,Robot robot,Rectangle rect) {
        this.socket=socket;
        this.robot=robot;
        rectangle=rect;
        start();
    }
    public void run() {
        try {
            oos = socket.getOutputStream();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        while (continueLoop) {
           // BufferedImage image = robot.createScreenCapture(rectangle);

           Bitmap image1= TakesScreenshot.getScreenshotAs(rectangle);
            try {
               // Object image;
               ImageIO.write(image1, "jpeg", oos);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
