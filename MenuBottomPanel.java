package Kiosk;

import javax.swing.*;
import java.awt.*;
// import java.awt.event.*;
import javax.swing.table.*;

public class MenuBottomPanel extends SuperPanel{

    JLabel bottomLabel;
    JButton AC, Pay;
    
    JLabel head1, head2;
    JScrollPane scroll;

    JTable orderTable;
    DefaultTableModel model;
    String header[] = {"Menu", "Price"};

    public MenuBottomPanel(){
        setSize(600,170);
        setLayout(null);
        setBackground(Color.LIGHT_GRAY);

        ///////////////TABLE///////////////        
        head1 = new JLabel("Menu", SwingConstants.CENTER);
        head2 = new JLabel("Price", SwingConstants.CENTER);

        model = new DefaultTableModel(header,0);
        orderTable = new JTable(model);

        scroll = new JScrollPane(orderTable);   
        scroll.setBounds(0, 0, 350, 170);
        
        //////////////BUTTON////////////////
        AC = new JButton("All Cancel");
        AC.setFont(super.btnfont);
        AC.setBounds(350,100,150,70);
        
        bottomLabel = new JLabel("Total: ");
        bottomLabel.setBounds(350,0,150,100);
        bottomLabel.setFont(new Font("Arial", Font.BOLD, 20));
        bottomLabel.setForeground(Color.RED);

        Pay = new JButton("Pay");
        Pay.setFont(btnfont);
        Pay.setBounds(500,0,100,170);
        
        add(scroll);
        add(AC);
        add(bottomLabel);
        add(Pay);

    }

    public void getData(String name, Integer price){
    
        String data[] = {name, String.valueOf(price)};
        model.addRow(data);
        orderTable.updateUI();

        //주문된 데이터 저장 -> 나중에 영수증 출력시 사용
        String[] str = {name, String.valueOf(price)};
        ORDERED.add(str);

        //총 가격 계산하기
        TOTAL += price;
        bottomLabel.setText("Total : " + String.valueOf(TOTAL));
    }
}
