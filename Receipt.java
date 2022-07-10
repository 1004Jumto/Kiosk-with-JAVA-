package Kiosk;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;
import java.time.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Receipt extends JDialog implements ActionListener {
   
    JTextArea tx;
    String str;
    JButton ok;
    JScrollPane txScroll;

    public Receipt(Integer Tot, String Sel, String Phn, String Pay, ArrayList<String[]> arr){
        //시간
        //매장 이름
        //포장/매장
        //주문 내역
        //총 결제액
        //지불 방법(카드/쿠폰)
        //적립 번호

        super();
        setTitle("Receipt");
        setLayout(null);
        setSize(400, 600);

        // 현재 날짜와 시간 구하기
        LocalDate date = LocalDate.now();       
        DateTimeFormatter dformatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");         // 포맷 적용        String formatedNow = now.format(formatter);
        String FormattedDate = date.format(dformatter);

        LocalTime time = LocalTime.now();        
        DateTimeFormatter tFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");         // 포맷 적용하기        
        String FormattedTime = time.format(tFormatter);

        //주문 내역 스트링에 저장하기
        tx = new JTextArea("<Ordered>\n");
        for(int i=0; i<arr.size(); i++){
            tx.append(arr.get(i)[0] + "      " + arr.get(i)[1] + "\n");
        }

        tx.setFont(new Font("Bodoni MT", Font.PLAIN, 20));

        txScroll = new JScrollPane(tx);
    

        //정보 라벨에 붙여주기
        JLabel[] info = new JLabel[7];

        info[0] = new JLabel(FormattedDate + FormattedTime, SwingConstants.CENTER);            //날짜 시간
        info[0].setFont(new Font("Arial", Font.PLAIN, 20));

        info[1] = new JLabel("EDIYA Coffee LYJ Cafe", SwingConstants.CENTER);            //매장이름
        info[1].setFont(new Font("Arial", Font.PLAIN, 20));

        info[2] = new JLabel("포장/매장 : " + Sel, SwingConstants.CENTER);                     //포장여부 
        info[2].setFont(new Font("맑은 고딕", Font.PLAIN, 20));

        info[3] = new JLabel("총 결제액 : " + String.valueOf(Tot), SwingConstants.CENTER);                   
        info[3].setFont(new Font("맑은 고딕", Font.PLAIN, 20));                     //총 결제액

        info[4] = new JLabel(Pay, SwingConstants.CENTER);                      //지불방법
        info[4].setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        
        info[5] = new JLabel("적립 번호 : " + Phn, SwingConstants.CENTER);                     //적립번호
        info[5].setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        
        //ok버튼
        ok = new JButton("OK");
        ok.setFont(new Font("Arial", Font.PLAIN, 25));
        ok.addActionListener(this);

        //다이얼로그에 붙여주기
        info[0].setBounds(0, 0, 400, 30); add(info[0]);
        info[1].setBounds(0, 30, 400, 30); add(info[1]);
        info[2].setBounds(0, 60, 400, 30); add(info[2]);
        txScroll.setBounds(0,90,400,300); add(txScroll);
        info[3].setBounds(0, 390, 400, 40); add(info[3]);
        info[4].setBounds(0, 430, 400, 40); add(info[4]);
        info[5].setBounds(0, 470, 400, 40); add(info[5]);
        ok.setBounds(150,520,100,20); add(ok);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        
    }
}
