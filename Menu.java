package Kiosk;

// import java.io.*;
// import java.util.*; 
import java.awt.event.*;
// import java.awt.*;
// import javax.swing.*;

public class Menu extends SuperPanel implements ActionListener{
    public static MenuTopPanel top;
    public static MenuCenterPanel center;
    public static MenuBottomPanel bottom;

    public Menu(){
    
        top = new MenuTopPanel();
        top.setBounds(0,0, 600, 70);

        bottom = new MenuBottomPanel();
        bottom.setBounds(0,730,600,170);
       
        center = new MenuCenterPanel(bottom);
        center.setBounds(0,70,600,660);

        add(top);
        add(center);
        add(bottom);

        bottom.Pay.addActionListener(this);
        bottom.AC.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();

        if(str.equals("Pay")){
            Membership Membership = new Membership();
            this.setVisible(false);
            this.getParent().add(Membership);
        }

        else if(str.equals("All Cancel")){
            //표 데이터 지우기
            bottom.model.setNumRows(0); 

            //총 가격도 리셋
            TOTAL = 0;
            bottom.bottomLabel.setText("Total : ");

            //주문 내역도 리셋
            ORDERED.clear();

        }        
    }
}



