package Kiosk;

import javax.swing.*;

public class BeforeBackHome extends Thread{
    Receipt m_receipt;

    public BeforeBackHome(Receipt receipt){
        m_receipt = receipt;
    }
    public void run(){
        try{
           
            sleep(7000);

            m_receipt.setVisible(false);
            
            

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

    }
}
