package Kiosk;

import java.awt.*;
// import java.awt.event.*;
import javax.swing.*;

public class MembershipCenterPanel extends SuperPanel{
    JButton PhoneNum;

    public MembershipCenterPanel(){
        setSize(600, 500);
        setLayout(null);
        
        PhoneNum = new JButton("Phone");
        PhoneNum.setFont(super.btnfont);
        PhoneNum.setBounds(50, 100, 100, 100);

        add(PhoneNum);        
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Font font = new Font("Arial", Font.BOLD, 25);

        g.setFont(font);
        g.setColor(super.color);
        g.drawString("Step1.", 50, 50);

        font = new Font("Arial", Font.PLAIN, 20);

        g.setFont(font);
        g.setColor(Color.BLACK);
        g.drawString("Please choose the way to save Membership Point", 50, 80);
    }
}
