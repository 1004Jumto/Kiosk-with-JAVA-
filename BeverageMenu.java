package Kiosk;

import java.awt.*;
// import java.util.*;
import javax.swing.*;
import java.awt.event.*;
// import Kiosk.Menu.*;

public class BeverageMenu extends SuperPanel implements MouseListener {
    
    String[] BeverageNames = {"BubbleLatte", "Chocolate", "CreamLatte", "GoldKiwi", "Strawberry", "GreenTea", "ToffeeLatte"};
    JLabel[] BeverageLabels = new JLabel[7];
    JLabel[] BeverageImageLabels = new JLabel[7];
    JLabel[] BeverageMenu = new JLabel[7];
    Integer[] price = {5900, 4900, 4900, 5300, 5300, 4900, 4900};

    ImageIcon bubblelatte;
    ImageIcon chocolate;
    ImageIcon creamlatte;
    ImageIcon goldkiwi;
    ImageIcon strawberry;
    ImageIcon greentea;
    ImageIcon toffeelatte;

    MenuBottomPanel m_bottom;
       
    public BeverageMenu(MenuBottomPanel bottom){
        setSize(500,530);
        setLayout(null);
    
        m_bottom = bottom;

        bubblelatte = resizeImage("C://과제//2학년//HW_Java//src//Kiosk//Images//Beverage//bubbleblacklatte.png", bubblelatte, 140, 150);
        chocolate = resizeImage("C://과제//2학년//HW_Java//src//Kiosk//Images//Beverage//chocolate.png",chocolate, 140,150);
        creamlatte = resizeImage("C://과제//2학년//HW_Java//src//Kiosk//Images//Beverage//creamlatte.png", creamlatte, 140,150);
        goldkiwi = resizeImage("C://과제//2학년//HW_Java//src//Kiosk//Images//Beverage//goldkiwijuice.png",goldkiwi, 140,150);
        strawberry = resizeImage("Kiosk//Images//Beverage//strawberryjuice.png",strawberry, 140,150);
        greentea = resizeImage("C://과제//2학년//HW_Java//src//Kiosk//Images//Beverage//greentealatte.png", greentea, 140,150);
        toffeelatte = resizeImage("C://과제//2학년//HW_Java//src//Kiosk//Images//Beverage//toffelatte.png", toffeelatte, 140,150);
    
        BeverageImageLabels[0] = new JLabel(bubblelatte);
        BeverageImageLabels[1] = new JLabel(chocolate);
        BeverageImageLabels[2] = new JLabel(creamlatte);
        BeverageImageLabels[3] = new JLabel(goldkiwi);
        BeverageImageLabels[4] = new JLabel(strawberry);
        BeverageImageLabels[5] = new JLabel(greentea);
        BeverageImageLabels[6] = new JLabel(toffeelatte);
    
        for(int i=0; i<7; i++){
            BeverageMenu[i] = new JLabel();
            BeverageMenu[i].setPreferredSize(new Dimension(150,170));
            
            BeverageLabels[i] = new JLabel(BeverageNames[i], SwingConstants.CENTER);
            BeverageLabels[i].setBounds(0,150,140,20);
            BeverageLabels[i].setFont(MenuNameFont);
    
            BeverageImageLabels[i].setBounds(0, 0, 140, 150);

            BeverageMenu[i].add(BeverageImageLabels[i]);
            BeverageMenu[i].add(BeverageLabels[i]);
            BeverageMenu[i].addMouseListener(this);

            orderMap.put(BeverageNames[i], price[i]);
        }
    
        for(int i=0; i<3; i++){
            BeverageMenu[i].setBounds(25+i*150, 12, 150, 170);
            add(BeverageMenu[i]);
        }
        for(int i=3; i<6; i++){
            BeverageMenu[i].setBounds(25+(i-3)*150, 180, 150, 170);
            add(BeverageMenu[i]);
        }
        for(int i=6; i<7; i++){
            BeverageMenu[i].setBounds(25+(i-6)*150, 355, 150, 170);
            add(BeverageMenu[i]);
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

