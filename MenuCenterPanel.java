package Kiosk;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuCenterPanel extends SuperPanel implements ActionListener {
    JPanel CategoryPanel;
    JPanel MenuPanel;

    JButton CoffeeButton, BeverageButton, FlatccinoButton, BreadButton, DessertButton;
   
    CardLayoutMenu menus;
    MenuBottomPanel m_bottom;

    public MenuCenterPanel(MenuBottomPanel bottom){
        setSize(600, 660);
        setLayout(new BorderLayout());

        m_bottom = bottom;

        CategoryPanel = new JPanel(null);
        CategoryPanel.setPreferredSize(new Dimension(600,100));


        //카테고리 버튼 생성 및 위치 설정
        CoffeeButton = new JButton("Coffee");
        CoffeeButton.setBounds(50, 20, 90, 60);
        CoffeeButton.addActionListener(this);

        BeverageButton = new JButton("Beverage");
        BeverageButton.setBounds(150, 20, 90,60);
        BeverageButton.addActionListener(this);

        FlatccinoButton = new JButton("Flatccino");
        FlatccinoButton.setBounds(250, 20, 90, 60);
        FlatccinoButton.addActionListener(this);

        BreadButton = new JButton("Bread");
        BreadButton.setBounds(350, 20, 90, 60);
        BreadButton.addActionListener(this);

        DessertButton = new JButton("Dessert");
        DessertButton.setBounds(450, 20, 90, 60);
        DessertButton.addActionListener(this);

        //카테고리 버튼 부착
        CategoryPanel.add(CoffeeButton);
        CategoryPanel.add(BeverageButton);
        CategoryPanel.add(FlatccinoButton);
        CategoryPanel.add(BreadButton);
        CategoryPanel.add(DessertButton);

        //메뉴 패널
        MenuPanel = new JPanel(null);
        MenuPanel.setPreferredSize(new Dimension(600, 560));
        
        //메뉴 패널들 생성 및 붙이기
        menus = new CardLayoutMenu(m_bottom);
        menus.setBounds(40, 10, 500, 530);

        MenuPanel.add(menus);

        add(CategoryPanel, BorderLayout.NORTH);
        add(MenuPanel, BorderLayout.CENTER);
        

    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        if(str.equals("Coffee")){
            menus.card.show(menus, "coffee");
        }
        else if(str.equals("Beverage")){
            menus.card.show(menus, "beverage");
        }
        else if(str.equals("Flatccino")){
            menus.card.show(menus, "flatccino");
        }
        else if(str.equals("Bread")){
            menus.card.show(menus, "bread");
        }
        else if(str.equals("Dessert")){
            menus.card.show(menus, "dessert");
        }
    }

}
