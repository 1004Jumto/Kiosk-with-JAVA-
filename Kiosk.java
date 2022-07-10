package Kiosk;

import javax.swing.*;

public class Kiosk{

    public static void main(String[] args) {
        
        JFrame f = new JFrame();
        f.setSize(600,950);
    
        HomePanel homePanel = new HomePanel();
    
        f.add(homePanel);
        f.setResizable(false);
        f.setVisible(true);
        
    }
}
