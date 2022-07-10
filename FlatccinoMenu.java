package Kiosk;

import java.awt.*;
// import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class FlatccinoMenu extends SuperPanel implements MouseListener {
    
    String[] FlatccinoNames = {"Blueberry", "Caramel", "Coffee", "Mango", "Peach", "Yogurt", "Strawberry"};
    JLabel[] FlatccinoLabels = new JLabel[7];
    JLabel[] FlatccinoImageLabels = new JLabel[7];
    JLabel[] FlatccinoMenu = new JLabel[7];
    Integer[] price = {5900, 5900, 4900, 5900, 5300, 5900, 4900};
    
    ImageIcon blueberry;
    ImageIcon caramel;
    ImageIcon coffee;
    ImageIcon mango;
    ImageIcon peach;
    ImageIcon yogurt;
    ImageIcon strawberry;
       
    MenuBottomPanel m_bottom;

    public FlatccinoMenu(MenuBottomPanel bottom){
        setSize(500,530);
        setLayout(null);
        
        m_bottom = bottom;
        
        blueberry = resizeImage("C://과제//2학년//HW_Java//src//Kiosk//Images//Flatccino//blueberry.png", blueberry, 140, 150);
        caramel = resizeImage("C://과제//2학년//HW_Java//src//Kiosk//Images//Flatccino//caramel.png",caramel, 140,150);
        coffee = resizeImage("C://과제//2학년//HW_Java//src//Kiosk//Images//Flatccino//coffee.png", coffee, 140,150);
        mango = resizeImage("C://과제//2학년//HW_Java//src//Kiosk//Images//Flatccino//mango.png",mango, 140,150);
        peach = resizeImage("Kiosk//Images//Flatccino//peach.png",peach, 140,150);
        yogurt = resizeImage("C://과제//2학년//HW_Java//src//Kiosk//Images//Flatccino//yogurt.png", yogurt, 140,150);
        strawberry = resizeImage("C://과제//2학년//HW_Java//src//Kiosk//Images//Flatccino//strawberry.png", strawberry, 140,150);
    
        FlatccinoImageLabels[0] = new JLabel(blueberry);
        FlatccinoImageLabels[1] = new JLabel(caramel);
        FlatccinoImageLabels[2] = new JLabel(coffee);
        FlatccinoImageLabels[3] = new JLabel(mango);
        FlatccinoImageLabels[4] = new JLabel(peach);
        FlatccinoImageLabels[5] = new JLabel(yogurt);
        FlatccinoImageLabels[6] = new JLabel(strawberry);
    
        for(int i=0; i<7; i++){
            FlatccinoMenu[i] = new JLabel();
            FlatccinoMenu[i].setPreferredSize(new Dimension(150,170));
            
            FlatccinoLabels[i] = new JLabel(FlatccinoNames[i], SwingConstants.CENTER);
            FlatccinoLabels[i].setBounds(0,150,140,20);
            FlatccinoLabels[i].setFont(MenuNameFont);

            FlatccinoImageLabels[i].setBounds(0, 0, 140, 150);
    
            FlatccinoMenu[i].add(FlatccinoImageLabels[i]);
            FlatccinoMenu[i].add(FlatccinoLabels[i]);
            FlatccinoMenu[i].addMouseListener(this);;
            
            orderMap.put(FlatccinoNames[i], price[i]);
        }
    
        for(int i=0; i<3; i++){
            FlatccinoMenu[i].setBounds(25+i*150, 12, 150, 170);
            add(FlatccinoMenu[i]);
        }
        for(int i=3; i<6; i++){
            FlatccinoMenu[i].setBounds(25+(i-3)*150, 180, 150, 170);
            add(FlatccinoMenu[i]);
        }
        for(int i=6; i<7; i++){
            FlatccinoMenu[i].setBounds(25+(i-6)*150, 355, 150, 170);
            add(FlatccinoMenu[i]);
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
