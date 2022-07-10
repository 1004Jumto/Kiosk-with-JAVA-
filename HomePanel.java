package Kiosk;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/*
- 위 : 카드 전용 안내 문구 + 이미지
- 중간 : 홍보용 사진들 
- 아래 : 매장/포장 선택 버튼
*/

public class HomePanel extends SuperPanel implements ActionListener{
    ImageIcon adIcon, cardIcon;         //가운데 들어갈 광고 사진, 위에 들어갈 카드 아이콘
    JPanel north, south;                //맨 위, 맨 아래에 부착될 패널
    JLabel center;                      //가운데 부착될 라벨
    JButton here, to_go;

    public HomePanel(){
        setLayout(new BorderLayout());
        
        ////////////////////////////////// NORTH /////////////////////////////
        north = new JPanel(null);
        north.setPreferredSize(new Dimension(600,130));
        north.setBackground(new Color(162, 207,233));

        //라벨 생성
        cardIcon = resizeImage("C://과제//2학년//HW_Java//src//Kiosk//Images//card.png", cardIcon, 130, 130);   
        JLabel imgLabel = new JLabel(cardIcon);
        JLabel label1 = new JLabel("카드 결제 전용");
        JLabel label2 = new JLabel("<html>현금/쿠폰 결제는 카운터를 이용해주세요. <br>멤버스 적립 가능 합니다. </html>");
        
        //폰트 생성
        Font font1 = new Font("맑은 고딕", Font.BOLD, 25);
        Font font2 = new Font("맑은 고딕", Font.PLAIN, 20);       
        
        //폰트 설정
        label1.setFont(font1);
        label1.setForeground(new Color(54,123,212));
        label2.setFont(font2);                                                
        label2.setForeground(new Color(54,123,212));                                  //글씨 색 설정
        
        //위치 설정
        imgLabel.setBounds(20, 5, 130, 130);
        label1.setBounds(170, 5, 500, 60);
        label2.setBounds(170, 50, 500, 60);

        //부착
        north.add(imgLabel);
        north.add(label1);
        north.add(label2);

        add(north, BorderLayout.NORTH);

        //////////////////////////// CENTER ///////////////////////////////////
        adIcon = resizeImage("C://과제//2학년//HW_Java//src//Kiosk//Images//start.jpg", adIcon, 600, 600);
        
        //패널 생성 및 부착
        center = new JLabel(adIcon);
        center.setPreferredSize(new Dimension(600,600));

        add(center, BorderLayout.CENTER);

        ///////////////////////////// SOUTH ///////////////////////////////////
        south = new JPanel(null);
        south.setPreferredSize(new Dimension(600,170));
        south.setBackground(new Color(54,123,212));

        //버튼 생성
        here = new JButton("매장");
        to_go = new JButton("포장");
        
        JLabel label3 = new JLabel("<html><center>맛있는 음료와 베이커리<br>정성껏 준비해드리겠습니다.</center></html>", SwingConstants.CENTER);
        
        //폰트 생성
        Font font3 = new Font("맑은 고딕", Font.ITALIC, 25);
        Font bFont = new Font("맑은 고딕", Font.PLAIN, 20);

        //폰트 설정
        label3.setFont(font3);
        label3.setForeground(Color.WHITE);
        here.setFont(bFont);
        to_go.setFont(bFont);

        //위치 설정
        here.setBounds(100, 110, 180, 40);
        to_go.setBounds(310, 110, 180, 40);
        label3.setBounds(0,5,600,70);
        
        //부착
        south.add(here);
        south.add(to_go);
        south.add(label3);

        add(south, BorderLayout.SOUTH);

        //버튼에 이벤트 등록
        here.addActionListener(this);
        to_go.addActionListener(this);

    }
        ///////////////이벤트 처리////////////
        /*
          버튼 누르면 그에 맞는 다이얼로그 상자 띄우고, 데이터(포장/매장) 저장
          그 다음화면인 Menu 화면으로 넘어가기
         */

        @Override
        public void actionPerformed(ActionEvent e) {
            String str = e.getActionCommand();
            
            if(str.equals("매장")){
                int result = JOptionPane.showConfirmDialog(this, "매장에서 드시고 가시겠습니까?", "For here", JOptionPane.OK_CANCEL_OPTION); 
                
                if(result == 0){        //예 -> 매장 식사
                    //다음 화면
                    Menu menu = new Menu();
                    this.setVisible(false);
                    this.getParent().add(menu);

                    SELECT = "매장";
                }   
            }

            if(str.equals("포장")){
                int result = JOptionPane.showConfirmDialog(this, "포장해 가시겠습니까?", "To go", JOptionPane.OK_CANCEL_OPTION); 
                
                if(result == 0){        //예 -> 포장
                    //다음 화면
                    Menu menu = new Menu();
                    this.setVisible(false);
                    this.getParent().add(menu);   
                    
                    SELECT = "포장";
                }
              
            
            }
            
        } 

}
