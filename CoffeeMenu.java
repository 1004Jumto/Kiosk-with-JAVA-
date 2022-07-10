package Kiosk;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CoffeeMenu extends SuperPanel implements MouseListener{
   
    String[] CoffeeNames = {"Americano", "CafeLatte", "DalgonaMix", "DecafColdBrew", "Espresso", "MocaMix", "ViennaCoffee"};
    JLabel[] CoffeeNameLabels = new JLabel[7];
    JLabel[] CoffeeImageLabels = new JLabel[7];
    JLabel[] CoffeeMenu = new JLabel[7];

    Integer[] price = {3800, 4100, 5900, 4300, 3500, 5900, 4900};

    ImageIcon americano;
    ImageIcon cafelatte;
    ImageIcon dalgonamix;
    ImageIcon decafcoldbrew;
    ImageIcon espresso;
    ImageIcon mocamix;
    ImageIcon viennacoffee;
       
    MenuBottomPanel m_bottom;

    public CoffeeMenu(MenuBottomPanel bottom){
        setSize(500,530);
        setLayout(null);

        m_bottom = bottom;

        americano = resizeImage("C://과제//2학년//HW_Java//src//Kiosk//Images//Coffee//americano.png", americano, 140, 150);
        cafelatte = resizeImage("C://과제//2학년//HW_Java//src//Kiosk//Images//Coffee//cafelatte.png", cafelatte, 140,150);
        dalgonamix = resizeImage("C://과제//2학년//HW_Java//src//Kiosk//Images//Coffee//dalgonamix.png", dalgonamix, 140,150);
        decafcoldbrew = resizeImage("C://과제//2학년//HW_Java//src//Kiosk//Images//Coffee//decafcoldbrew.png", decafcoldbrew,140,150);
        espresso = resizeImage("C://과제//2학년//HW_Java//src//Kiosk//Images//Coffee//espresso.png",espresso, 140,150);
        mocamix = resizeImage("C://과제//2학년//HW_Java//src//Kiosk//Images//Coffee//mocamix.png", mocamix, 140,150);
        viennacoffee = resizeImage("C://과제//2학년//HW_Java//src//Kiosk//Images//Coffee//viennacoffee.png", viennacoffee, 140,150);

        CoffeeImageLabels[0] = new JLabel(americano);
        CoffeeImageLabels[1] = new JLabel(cafelatte);
        CoffeeImageLabels[2] = new JLabel(dalgonamix);
        CoffeeImageLabels[3] = new JLabel(decafcoldbrew);
        CoffeeImageLabels[4] = new JLabel(espresso);
        CoffeeImageLabels[5] = new JLabel(mocamix);
        CoffeeImageLabels[6] = new JLabel(viennacoffee);

        for(int i=0; i<7; i++){
            CoffeeMenu[i] = new JLabel();
            CoffeeMenu[i].setPreferredSize(new Dimension(150,170));
            
            CoffeeNameLabels[i] = new JLabel(CoffeeNames[i], SwingConstants.CENTER);
            CoffeeNameLabels[i].setBounds(0,150,140,20);
            CoffeeNameLabels[i].setFont(MenuNameFont);
            
            CoffeeImageLabels[i].setBounds(0, 0, 140, 150);

            CoffeeMenu[i].add(CoffeeImageLabels[i]);
            CoffeeMenu[i].add(CoffeeNameLabels[i]);
            CoffeeMenu[i].addMouseListener(this);

            orderMap.put(CoffeeNames[i], price[i]);

        }

        for(int i=0; i<3; i++){
            CoffeeMenu[i].setBounds(25+i*150, 12, 150, 170);
            add(CoffeeMenu[i]);
        }
        for(int i=3; i<6; i++){
            CoffeeMenu[i].setBounds(25+(i-3)*150, 180, 150, 170);
            add(CoffeeMenu[i]);
        }
        for(int i=6; i<7; i++){
            CoffeeMenu[i].setBounds(25+(i-6)*150, 355, 150, 170);
            add(CoffeeMenu[i]);
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
