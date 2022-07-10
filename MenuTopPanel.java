package Kiosk;

// import java.io.*;
// import java.util.*; 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuTopPanel extends SuperPanel implements MouseListener{
   
   ImageIcon homeicon;

   public MenuTopPanel(){

   setSize(600, 70);
   setBackground(new Color(54,123,212));
   
   addMouseListener(this);
   }

     @Override
     protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        homeicon = resizeImage("C://과제//2학년//HW_Java//src//Kiosk//Images//homeicon.png", homeicon, 50, 50);                                                                                                                                    
        Image img = homeicon.getImage();
        g.drawImage(img, 30, 10, this);

        Font font = new Font("맑은 고딕", Font.BOLD, 25);
        g.setFont(font);
        g.setColor(Color.BLACK);
        g.drawString("처음으로", 90, 47);

     }

   @Override
   public void mouseClicked(MouseEvent e) {
      
      int x = e.getX();
      int y = e.getY();
   
      if(30 <= x && x <=180 && 10 <= y && y <= 50){
         int result = JOptionPane.showConfirmDialog(this, "정말 처음으로 돌아가시겠습니까?", "Reset All", JOptionPane.OK_CANCEL_OPTION);
         
         if(result == 0){
            HomePanel home = new HomePanel();
            Container parent = this.getParent();
            // parent.invalidate();
            parent.removeAll();
            parent.add(home);
            parent.revalidate();

         }
      }
   }

   @Override
   public void mousePressed(MouseEvent e) {}

   @Override
   public void mouseReleased(MouseEvent e) {}

   @Override
   public void mouseEntered(MouseEvent e) {}

   @Override
   public void mouseExited(MouseEvent e) {}
}
