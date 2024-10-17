package SecondMenu;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BottomSecondMenu extends JPanel {
    JButton aboutsUs;
    JButton close;





    BottomSecondMenu(){
        super();
        addObjects();
    }
     private void addObjects() {
         this.setBackground(new Color(0,0,0,0));

         BoxLayout boxLayout=new BoxLayout(this , BoxLayout.X_AXIS);
         this.setLayout(boxLayout);
         this.setBorder(new EmptyBorder(new Insets(20,100,20,100)));
         aboutsUs=new JButton("تغییر اطلاعات");
         close=new JButton("تغییر پسورد");
        Font font=new Font("علی", 8 ,20);
        close.setPreferredSize(new Dimension(200,50));
        close.setFont(font);
        this.add(close);
        this.add(Box.createGlue());
        aboutsUs.setPreferredSize(new Dimension(200,50));
        aboutsUs.setFont(font);
        this.add(aboutsUs);

       // this.add(Box.createGlue());


    }


}
