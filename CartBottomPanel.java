package Kiosk;

import java.awt.*;
import javax.swing.*;
// import java.awt.event.*;

public class CartBottomPanel extends SuperPanel{
      
    JButton Back, Next;
    JLabel Total;

    public CartBottomPanel(){
        setSize(600,240);
        setLayout(null);

        Total = new JLabel("Total:                       " + TOTAL +" won");
        Total.setFont(new Font("Arial", Font.BOLD, 35));
        Total.setBounds(50,0,600,100);

        Next = new JButton("Next");
        Back = new JButton("Back");

        //폰트 설정
        Next.setFont(super.btnfont);
        Back.setFont(super.btnfont);

        //위치 및 크기 설정
        Back.setBounds(115, 135, 180, 90);
        Next.setBounds(305, 135, 180,90);

        Next.setBackground(new Color(98,158,236));
       
        add(Total);
        add(Next);
        add(Back);
    }   
    
}
