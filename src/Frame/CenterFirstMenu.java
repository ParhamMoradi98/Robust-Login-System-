package Frame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CenterFirstMenu extends JPanel {
    JComboBox list_Players;
    File users_file;
    PrintWriter pw;
    BufferedImage bufferedImage;

    public CenterFirstMenu() {
        super();
        //   BoxLayout boxLayout=new BoxLayout(this , BoxLayout.X_AXIS);
        //   this.setLayout(boxLayout);
        this.setBackground(new Color(0, 0, 0, 0));
        // this.add(Box.createGlue());
        //  this.add(Box.createRigidArea(new Dimension(325,300)));
        this.users_file = new File("Game.data");
        Scanner scanner = null;
        try {
            scanner = new Scanner(users_file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int i = 0;
        String lastID = scanner.nextLine();
        System.out.println(lastID);
        if (lastID.equals("-1")) {
            list_Players = new JComboBox();
            this.add(list_Players);
            list_Players.setBounds(100, 100, 100, 50);
            Font font = new Font("علي", 8, 30);
            list_Players.setFont(font);
            //    this.add(Box.createGl
        } else {
//            if (User.users.size() == 0){
                String encryptedID = scanner.nextLine();
            String encryptedData = scanner.nextLine();
            String salt = scanner.nextLine();
            User user = new User(lastID);
            User.users.add(user);
            User.hashMap.put(lastID, user);
            user.encryptedData = encryptedData;
            byte[] sa = salt.getBytes();

            user.salt = sa;
            user.encryptedID = encryptedID;
            String[] IDs = new String[100];
            while (!lastID.equals("-1")) {
                IDs[i] = lastID;
                lastID = scanner.nextLine();
                if (lastID.equals("-1")) {
                    break;
                }
                encryptedID = scanner.nextLine();
                encryptedData = scanner.nextLine();
                salt = scanner.nextLine();
                user = new User(lastID);
                user.encryptedID = encryptedID;
                user.encryptedData = encryptedData;
                user.salt = salt.getBytes();
                User.users.add(user);
                User.hashMap.put(lastID, user);
                i = i + 1;
            }
            String[] players_copy = new String[i + 1];
            for (int j = 0; j < i + 1; j++) {
                players_copy[j] = IDs[j];
            }

            list_Players = new JComboBox(players_copy);
            this.add(list_Players);
            list_Players.setBounds(100, 100, 100, 50);
            Font font = new Font("علي", 8, 30);
            list_Players.setFont(font);



        }

    }
}
