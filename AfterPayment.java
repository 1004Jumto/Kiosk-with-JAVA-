package Kiosk;

import javax.swing.*;

public class AfterPayment extends Thread {
    public void run(){
        try{
            
            sleep(5000);

            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

    }
    
}
