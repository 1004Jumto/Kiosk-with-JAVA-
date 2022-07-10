package Kiosk;

import java.awt.*;
import javax.swing.*;
import java.util.*; 

class SuperPanel extends JPanel{
    Color color = new Color(54,123,212);

    Font btnfont = new Font("Arial", Font.PLAIN, 20); 
    Font CartHeadFont = new Font("Edwardian Script ITC", Font.PLAIN, 35);
    Font CartDataFont = new Font("맑은 고딕", Font.PLAIN, 30);
    Font MenuNameFont = new Font("Berlin Sans FB", Font.PLAIN, 20);

    //키오스크 데이터 집합
    public static HashMap<String, Integer> orderMap = new HashMap<>();
    public static ArrayList<String[]> ORDERED = new ArrayList<String[]>();

    public static Integer TOTAL = 0;
    public static String SELECT = "";
    public static String PhoneNUMBER = "";
    public static String PAYMENT = "";
    public static String couponNUMBER;


    public SuperPanel(){
        
        setSize(600,900);
        setLayout(null);
        setVisible(true);
        
    }

    // 이미지 크기 조정 함수
    public ImageIcon resizeImage (String filename, ImageIcon icon, int width, int height){
        icon = new ImageIcon(filename);
        Image img = icon.getImage();
        Image updateImage = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon updateIcon = new ImageIcon(updateImage);

        return updateIcon;
    }

   
}