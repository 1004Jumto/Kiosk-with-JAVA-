package Kiosk;

import java.awt.*;
// import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class DessertMenu extends SuperPanel implements MouseListener {
    
    String[] DessertNames = {"ChocoMuffin", "CheeseMuffin", "Tiramisu", "CreamCheese", "Waffle", "Macaron"};
    JLabel[] DessertLabels = new JLabel[6];
    JLabel[] DessertImageLabels = new JLabel[6];
    JLabel[] DessertMenu = new JLabel[6];

    Integer[] price = {3800, 3800, 6300, 5300, 2800, 2800};
    
    ImageIcon chocomuffin;
    ImageIcon cheesemuffin;
    ImageIcon tiramisu;
    ImageIcon creamcheese;
    ImageIcon waffle;
    ImageIcon macaron;

    MenuBottomPanel m_bottom;

    public DessertMenu(MenuBottomPanel bottom){
        setSize(500,530);
        setLayout(null);
    
        m_bottom = bottom;

        chocomuffin = resizeImage("C://과제//2학년//HW_Java//src//Kiosk//Images//Dessert//chocochipmuffin.png", chocomuffin, 140, 150);
        cheesemuffin = resizeImage("C://과제//2학년//HW_Java//src//Kiosk//Images//Dessert//creamcheesemuffin.png",cheesemuffin, 140,150);
        tiramisu = resizeImage("C://과제//2학년//HW_Java//src//Kiosk//Images//Dessert//chocotiramisu.png", tiramisu, 140,150);
        creamcheese = resizeImage("C://과제//2학년//HW_Java//src//Kiosk//Images//Dessert//doublecheesecake.png",creamcheese, 140,150);
        waffle = resizeImage("C://과제//2학년//HW_Java//src//Kiosk//Images//Dessert//plainwaffle.png",waffle, 140,150);
        macaron = resizeImage("C://과제//2학년//HW_Java//src//Kiosk//Images//Dessert//vanillamacaron.png", macaron, 140,150);

        DessertImageLabels[0] = new JLabel(chocomuffin);
        DessertImageLabels[1] = new JLabel(cheesemuffin);
        DessertImageLabels[2] = new JLabel(tiramisu);
        DessertImageLabels[3] = new JLabel(creamcheese);
        DessertImageLabels[4] = new JLabel(waffle);
        DessertImageLabels[5] = new JLabel(macaron);
    
        for(int i=0; i<6; i++){
            DessertMenu[i] = new JLabel();
            DessertMenu[i].setPreferredSize(new Dimension(150,170));
            
            DessertLabels[i] = new JLabel(DessertNames[i], SwingConstants.CENTER);
            DessertLabels[i].setBounds(0,150,140,20);
            DessertLabels[i].setFont(MenuNameFont);

            DessertImageLabels[i].setBounds(0, 0, 140, 150);
    
            DessertMenu[i].add(DessertImageLabels[i]);
            DessertMenu[i].add(DessertLabels[i]);
            DessertMenu[i].addMouseListener(this);;
    
            orderMap.put(DessertNames[i], price[i]);
        }
    
        for(int i=0; i<3; i++){
            DessertMenu[i].setBounds(25+i*150, 12, 150, 170);
            add(DessertMenu[i]);
        }
        for(int i=3; i<6; i++){
            DessertMenu[i].setBounds(25+(i-3)*150, 180, 150, 170);
            add(DessertMenu[i]);
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
