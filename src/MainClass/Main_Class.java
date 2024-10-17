package MainClass;

import Frame.First_Menu;
import Frame.Main_Frame;
import Frame.User;

import javax.jws.soap.SOAPBinding;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class Main_Class {

    public static Main_Frame jframe;
    public static void main(String[] args) throws IOException {
        jframe=new Main_Frame();
        First_Menu jpanel=new First_Menu(jframe,1);
        jframe.add(jpanel);
        jframe.setVisible(true);
//        byte[] bytes="hi2".getBytes();
//        byte[] bytes1=null;
//        try {
//            bytes= User.getSalt();
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//        System.out.println(new String(bytes));
//        String b= new String(bytes,"UTF-8");
//        byte[]b2=b.getBytes();
//        System.out.println(b2.length);
//        System.out.println(bytes.length);
//        byte[]b3=new byte[bytes.length];
//        for (int i = 0; i < bytes.length; i++) {
//            b3[i]=bytes[i];
//        }
//        System.out.println(b2.length);
//        System.out.println(bytes.length);
//        System.out.println(new String(b2));
//        System.out.println(new String(b3));
//        System.out.println(Arrays.equals(b3,bytes));
//        try {
//            byte[] a=getSalt();
//            String b=getSecurePassword("Parham",a);
//            System.out.println(b);
//            String c=getSecurePassword("Parham",a);
//            if(b.equals(c)){
//                System.out.println("hoora");
//            }
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }

    }


}
