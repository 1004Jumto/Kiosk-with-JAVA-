package Kiosk;

import java.awt.*;
// import javax.swing.*;
// import java.awt.event.*;

public class LogoPanel extends SuperPanel {
    String m_title;

    public LogoPanel(String title){
        setSize(600,90);
        setBackground(new Color(98,158,236));
        m_title = title;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Font font = new Font("맑은고딕", Font.BOLD, 35);
        g.setColor(Color.WHITE);
        g.setFont(font);
        g.drawString("EDIYA COFFEE", 30, 60);

        g.setFont(CartHeadFont);
        g.drawString(m_title, 300,60);

    }
}
