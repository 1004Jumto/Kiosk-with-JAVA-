package Kiosk;

// import java.io.*;
// import java.util.*; 
// import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Pay extends SuperPanel implements ActionListener{

    public Pay(){

        //"처음으로"가 있는 맨 위 패널
        MenuTopPanel top = new MenuTopPanel();
        top.setBounds(0,0,600,70);
        add(top);

        //로고 패널
        LogoPanel logo = new LogoPanel("Payment");
        logo.setBounds(0,70,600,90);
        add(logo);

        //카드/쿠폰 버튼이 있는 패널
        PayCenterPanel centerPanel = new PayCenterPanel();
        centerPanel.setBounds(0, 160, 600,500);
        add(centerPanel);

        //총 가격, 뒤로가기, 넘어가기 버튼 있는 맨 아래 패널
        CartBottomPanel bottomPanel = new CartBottomPanel();
        bottomPanel.setBounds(0,640,600,240);
        add(bottomPanel);

        centerPanel.card.addActionListener(this);
        centerPanel.coupon.addActionListener(this);

        bottomPanel.Next.addActionListener(this);
        bottomPanel.Back.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        AfterPayment aftPAY = new AfterPayment();
        BeforeBackHome waitingAgain;

        if(str.equals("CARD")){
            int result = JOptionPane.showConfirmDialog(this, "결제하시겠습니까?", "Reset All", JOptionPane.OK_CANCEL_OPTION);
            
            if(result == 0){    //예 -> 결제 완료 -> 영수증 출력
                JOptionPane.showMessageDialog(null, "...잠시 기다려주세요...", "처리중", JOptionPane.INFORMATION_MESSAGE);
                aftPAY.start();
                JOptionPane.showMessageDialog(null, "계산이 완료되었습니다!", "Complete!", JOptionPane.CLOSED_OPTION);

                PAYMENT = "CARD :: 일시불";

                //영수증 출력
                Receipt receipt = new Receipt(TOTAL, SELECT, PhoneNUMBER, PAYMENT, ORDERED);
                receipt.setVisible(true);

                JOptionPane.showMessageDialog(null, "초기화면으로 돌아갑니다..", "Go Home", JOptionPane.INFORMATION_MESSAGE);

                /*스레드로 잠시 기다림 */
                waitingAgain = new BeforeBackHome(receipt);
                waitingAgain.start();

                //정보 모두 삭제
                ORDERED.clear();
                SELECT = "";
                PhoneNUMBER = "";
                TOTAL = 0;
                PAYMENT = "";
                couponNUMBER = "";
                
                this.setVisible(false);
                this.getParent().add(new HomePanel());
            }
            else{       //에러
                JOptionPane.showMessageDialog(this, "결제를 진행해주세요!","!Payment ERROR", JOptionPane.ERROR_MESSAGE);
            }
            
        }

        else if(str.equals("COUPON")){
            couponNUMBER = JOptionPane.showInputDialog(this, "쿠폰번호를 입력하세요!", "Coupon", JOptionPane.CLOSED_OPTION);
            
            if(couponNUMBER != null && couponNUMBER.matches("^[0-9a-zA-Z]*$")){
                JOptionPane.showMessageDialog(null, "...잠시 기다려주세요...", "처리중", JOptionPane.INFORMATION_MESSAGE);
               
                /*스레드로 잠시 기다림*/
                aftPAY.start();

                JOptionPane.showMessageDialog(this, "계산이 완료되었습니다!", "Complete!", JOptionPane.CLOSED_OPTION);
                PAYMENT = "COUPON :: " + couponNUMBER;

                //영수증 출력
                Receipt receipt = new Receipt(TOTAL, SELECT, PhoneNUMBER, PAYMENT, ORDERED);
                receipt.setVisible(true);
                
                JOptionPane.showMessageDialog(null, "초기화면으로 돌아갑니다..", "Go Home", JOptionPane.INFORMATION_MESSAGE);

                waitingAgain = new BeforeBackHome(receipt);
                waitingAgain.start();
                
                //정보 모두 삭제
                ORDERED.clear();
                SELECT = "";
                PhoneNUMBER = "";
                TOTAL = 0;
                PAYMENT = "";
                couponNUMBER = "";

                this.setVisible(false);
                this.getParent().add(new HomePanel());

            }
            else{       //에러
                JOptionPane.showMessageDialog(this, "! 유효하지 않은 쿠폰입니다","!Payment ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }

        else if(str.equals("Back")){
                Membership membership = new Membership();
                this.setVisible(false);
                this.getParent().add(membership);
            
            
        }
        else if(str.equals("Next"))
            JOptionPane.showMessageDialog(this, "결제를 진행해주세요!","!Payment ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
    }  
        

    

