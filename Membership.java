package Kiosk;

// import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/* 멤버쉽 적립 패널 */
public class Membership extends SuperPanel implements ActionListener{

    public Membership(){

        //"처음으로"가 있는 맨 위 패널
        MenuTopPanel topPanel = new MenuTopPanel();
        topPanel.setBounds(0,0, 600, 70);
        add(topPanel);

        //멤버쉽 알려주는 로고 패널
        LogoPanel logoPanel = new LogoPanel("Membership");
        logoPanel.setBounds(0, 70, 600, 90);
        add(logoPanel);
        
        //멤버쉽 적립 할 수 있는 폰 버튼이 있는 패널
        MembershipCenterPanel centerPanel = new MembershipCenterPanel();
        centerPanel.setBounds(0,160,600,500);
        add(centerPanel);

        //맨 아래 패널
        //총 가격과 뒤로가기, 넘어가기 버튼이 있음
        CartBottomPanel bottomPanel = new CartBottomPanel();
        bottomPanel.setBounds(0, 660, 600, 240);
        add(bottomPanel);

        centerPanel.PhoneNum.addActionListener(this);      //폰 번호로 멤버쉽 적립 됨
        bottomPanel.Next.addActionListener(this);       //누르면 다음 화면으로 넘어가야함
        bottomPanel.Back.addActionListener(this);       //누르면 그 전 화면으로 돌아가야함 -> 돌아가면 리셋됨


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();

        if(str.equals("Phone")){
            PhoneNUMBER = JOptionPane.showInputDialog(this, "전화번호를 입력해주세요", "Members : PhoneNum", JOptionPane.PLAIN_MESSAGE);
            
            //전화번호 제대로 입력한 경우
            if(PhoneNUMBER != null && PhoneNUMBER.matches("^01(?:0|1|[6-9])(?:\\d{3}|\\d{4})\\d{4}$")){
                Pay payPanel = new Pay();
                this.setVisible(false);
                this.getParent().add(payPanel);
            }

            //아닌 경우
            else{
                JOptionPane.showMessageDialog(this, "! 유효하지 않은 번호입니다.");
            }
        }

        
        else if(str.equals("Back")){
            int result = JOptionPane.showConfirmDialog(this, "장바구니가 모두 초기화 됩니다. 그래도 돌아가시겠습니까?", "Back", JOptionPane.OK_CANCEL_OPTION);
           
            if(result == 0){    //예 -> 뒤로 돌아감
                Menu menu = new Menu();
                this.setVisible(false);
                this.getParent().add(menu);
            }

            //총 금액 리셋
            TOTAL = 0;

            //주문 내역 리셋
            ORDERED.clear();

            
        }
        else if(str.equals("Next")){
            Pay payPanel = new Pay();
            this.setVisible(false);
            this.getParent().add(payPanel);
        }
        
    }  
}
