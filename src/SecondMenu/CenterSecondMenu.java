package SecondMenu;

import SecondMenu.CenterOfSecondMenu.BottomCenterSecondMenu;
import SecondMenu.CenterOfSecondMenu.CenterCenterSecondMenu;
import SecondMenu.CenterOfSecondMenu.TopCenterSecondMenu;
import Frame.User;
import Frame.AES;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CenterSecondMenu extends JPanel {
    CenterCenterSecondMenu centerCenterSecondMenu;
    TopCenterSecondMenu topCenterSecondMenu;
    SecondMenu secondMenu;
    JLabel hiUser;
    JPanel enterGame;
    CenterSecondMenu(String name,SecondMenu secondMenu){
        this.secondMenu=secondMenu;
        generate(name);



    }

    private void generate(String name) {
        this.setBackground(new Color(0,0,0,0));
        BoxLayout boxLayout=new BoxLayout(this , BoxLayout.Y_AXIS);
        this.setLayout(boxLayout);
        this.add(Box.createRigidArea(new Dimension(325,300)));
        addLable(name);
        addButtons();
    }

    private void addButtons() {
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.add(Box.createGlue());
        Font font=new Font("علي", 8 ,20);
        this.add(Box.createRigidArea(new Dimension(0,100)));

    }

    private void addLable(String name) {
        Font font=new Font("علي", Font.ITALIC ,30);
        User user=User.hashMap.get(name);
        String data=user.readData(secondMenu.password);
        name= "Hi  " +(String)name+   "!  your data is :  "+data;

        hiUser=new JLabel(name);
        hiUser.setForeground(Color.WHITE);
        hiUser.setFont(font);
        this.add(hiUser);
        //hiuser.setForeground(Color.YELLOW);
//        this.add(Box.createGlue());

    }


}
