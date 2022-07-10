package Kiosk;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
// import java.util.*;

public class BreadMenu extends SuperPanel implements MouseListener {
   
    String[] BreadNames = {"BeefBurrito", "Sandwich", "HawaianPizza", "Pizza", "ChickenBurrito", "RedbeanSand"};
    JLabel[] BreadLabels = new JLabel[6];
    JLabel[] BreadImageLabels = new JLabel[6];
    JLabel[] BreadMenu = new JLabel[6];
    
    Integer[] price = {5900, 3800, 4900, 5300, 5900, 4300};

    ImageIcon beefburrito;
    ImageIcon sandwich;
    ImageIcon hawaian;
    ImageIcon sweetpizza;
    ImageIcon hotchickenburrito;
    ImageIcon redbeansandwich;

    MenuBottomPanel m_bottom;

    public BreadMenu(MenuBottomPanel bottom){
        setSize(500,530);
        setLayout(null);
    
        m_bottom = bottom;

        beefburrito = resizeImage("C://과제//2학년//HW_Java//src//Kiosk//Images//Bread//beefburrito.png", beefburrito, 140, 150);
        sandwich = resizeImage("C://과제//2학년//HW_Java//src//Kiosk//Images//Bread//hamandcheesesandwich.png",sandwich, 140,150);
        hawaian = resizeImage("C://과제//2학년//HW_Java//src//Kiosk//Images//Bread//hawaianpizza.png", hawaian, 140,150);
        sweetpizza = resizeImage("C://과제//2학년//HW_Java//src//Kiosk//Images//Bread//sweetpotatopizza.png",sweetpizza, 140,150);
        hotchickenburrito = resizeImage("C://과제//2학년//HW_Java//src//Kiosk//Images//Bread//hotchickenburrito.png",hotchickenburrito, 140,150);
        redbeansandwich = resizeImage("C://과제//2학년//HW_Java//src//Kiosk//Images//Bread//redbeansandwich.png", redbeansandwich, 140,150);

        BreadImageLabels[0] = new JLabel(beefburrito);
        BreadImageLabels[1] = new JLabel(sandwich);
        BreadImageLabels[2] = new JLabel(hawaian);
        BreadImageLabels[3] = new JLabel(sweetpizza);
        BreadImageLabels[4] = new JLabel(hotchickenburrito);
        BreadImageLabels[5] = new JLabel(redbeansandwich);
    
        for(int i=0; i<6; i++){
            BreadMenu[i] = new JLabel();
            BreadMenu[i].setPreferredSize(new Dimension(150,170));
            
            BreadLabels[i] = new JLabel(BreadNames[i], SwingConstants.CENTER);
            BreadLabels[i].setBounds(0,150,140,20);
            BreadLabels[i].setFont(MenuNameFont);
            
            BreadImageLabels[i].setBounds(0, 0, 140, 150);
    
            BreadMenu[i].add(BreadImageLabels[i]);
            BreadMenu[i].add(BreadLabels[i]);
            BreadMenu[i].addMouseListener(this);;
    
            orderMap.put(BreadNames[i], price[i]);
        }
    
        for(int i=0; i<3; i++){
            BreadMenu[i].setBounds(25+i*150, 12, 150, 170);
            add(BreadMenu[i]);
        }
        for(int i=3; i<6; i++){
            BreadMenu[i].setBounds(25+(i-3)*150, 180, 150, 170);
            add(BreadMenu[i]);
        }

    }
 
    @Override
    public void mouseClicked(MouseEvent e) {
        JLabel label = (JLabel) e.getSource();
        JLabel la = (JLabel) label.getComponent(1);
    
        String name = la.getText();
        Integer cost = orderMap.get(name);
               
        m_bottom.getData(name, cost);

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
