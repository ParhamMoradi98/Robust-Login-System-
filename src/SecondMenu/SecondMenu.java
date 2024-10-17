package SecondMenu;


import javax.imageio.ImageIO;
import javax.jws.soap.SOAPBinding;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import Menu.GeneralMenu;
import Frame.First_Menu;

import Frame.User;
import Frame.AES;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class SecondMenu extends JPanel {
    public static boolean plane=false;
    BufferedImage bufferedImage;
    BottomSecondMenu bottomSecondMenu;
    TopSecondMenu topSecondMenu;
    CenterSecondMenu centerSecondMenu;
    public static String user;
    String password;


   public SecondMenu (String User,String password){
       super();
       this.user=User;
       this.password=password;
       this.setBackground(new Color(0,0,0,0));
       generate();

   }

   private void generate(){

    background();
    this.setLayout(new BorderLayout());
    otherLayouts();
    buttonListener();


   }

private void otherLayouts(){
    bottomSecondMenu=new BottomSecondMenu();
    centerSecondMenu=new CenterSecondMenu(this.user,this);
    topSecondMenu=new TopSecondMenu();
    this.add(bottomSecondMenu,BorderLayout.SOUTH);
    this.add(centerSecondMenu,BorderLayout.CENTER);
    this.add(topSecondMenu,BorderLayout.NORTH);


}
    private void buttonListener(){

        bottomSecondMenu.aboutsUs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String data= JOptionPane.showInputDialog("Please type your data");
                User.hashMap.get(user).changeData(password,data);

            }
        });

        bottomSecondMenu.close.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                String data= JOptionPane.showInputDialog("Please type your data");
                String pass= JOptionPane.showInputDialog("Please type your new Password");
                User.hashMap.get(user).changeData(pass,data);
                User u=User.hashMap.get(user);
                String key=u.getSecurePassword(password,u.salt);
                u.encryptedID= AES.encrypt(u.id,key);
                u.encryptedData= AES.encrypt(data,key);
            }
//                First_Menu first_menu= null;
//                try {
//                    first_menu = new First_Menu(First_Menu.jFrame,2);
//                } catch (IOException e1) {
//                    e1.printStackTrace();
//                }
//                SecondMenu.this.removeAll();
//                SecondMenu.this.add(first_menu);
//                SecondMenu.this.revalidate();
//                SecondMenu.this.repaint();
//            }

        });


    }
    private void background(){
     try {
         bufferedImage=ImageIO.read(new File("pngs/background.png"));
     } catch (IOException e) {
         e.printStackTrace();
     }
 }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bufferedImage, 0, 0, null);
    }

}
