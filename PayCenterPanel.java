package Kiosk;

// import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class PayCenterPanel extends SuperPanel{

    JButton card, coupon;

    public PayCenterPanel(){
        
        setSize(600, 500);
        setLayout(null);
    
        card = new JButton("CARD");
        card.setFont(super.btnfont);
        card.setBounds(50, 100, 150, 100);
        
        coupon = new JButton("COUPON");
        coupon.setFont(super.btnfont);
        coupon.setBounds(220, 100, 150, 100);
    
        add(card);        
        add(coupon);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Font font = new Font("Arial", Font.BOLD, 25);

        g.setFont(font);
        g.setColor(super.color);
        g.drawString("Step2.", 50, 50);
        
        font = new Font("Arial", Font.PLAIN, 20);

        g.setFont(font);
        g.setColor(Color.BLACK);
        g.drawString("Please select a payment method!", 50, 80);
    
    }

}