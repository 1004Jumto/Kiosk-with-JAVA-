package Kiosk;

// import java.io.*;
// import java.util.*; 
// import java.awt.event.*;
import java.awt.*;
// import javax.swing.*;

public class CardLayoutMenu extends SuperPanel {
    CardLayout card;

    MenuBottomPanel m_bottom;

    BeverageMenu beverageMenu;
    CoffeeMenu coffeeMenu;
    FlatccinoMenu flatccinoMenu;
    DessertMenu dessertMenu;
    BreadMenu breadMenu;

    public CardLayoutMenu(MenuBottomPanel bottom){
        card = new CardLayout();
        m_bottom = bottom;

        setSize(500,530);
        setLayout(card);
        

        coffeeMenu = new CoffeeMenu(m_bottom);
        coffeeMenu.setBounds(0, 0, 500, 530);
        add("coffee",coffeeMenu);

        beverageMenu = new BeverageMenu(m_bottom);
        beverageMenu.setBounds(0, 0, 500, 530);
        add("beverage",beverageMenu);

        flatccinoMenu = new FlatccinoMenu(m_bottom);
        flatccinoMenu.setBounds(0, 0, 500, 530);
        add("flatccino",flatccinoMenu);
        
        dessertMenu = new DessertMenu(m_bottom);
        dessertMenu.setBounds(0, 0, 500, 530);
        add("dessert",dessertMenu);

        breadMenu = new BreadMenu(m_bottom);
        breadMenu.setBounds(0, 0, 500, 530);
        add("bread",breadMenu);

    }
}
