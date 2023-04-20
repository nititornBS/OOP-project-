
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;

public class orderPage extends JFrame implements ActionListener  {
    private JPanel bigpanel;
    private JLabel title;
    private JPanel titlePanel;
    private JPanel nameMemberPanel;
    private JLabel name;
    private JLabel member;
    private JTextArea showname;
    private JTextArea showmember;
  
    private JPanel besstsell;
    private JPanel bestJPanel;
    private JLabel bestJLabel;  
    private JPanel TopTable;


    private JPanel menuJPanel;
    private JLabel menutop;
    private JPanel cupPanel;
    private JLabel cuptop;
    private JPanel sizepanel;
    private JLabel sizetop;
    private JPanel pricepPanel;
    private JLabel price;


    private JPanel menu1JPanel;
    private JPanel menu2JPanel;
    private JPanel menu3JPanel;
    
    private JLabel menu1;
    private JTextField menu1Field;
    private JTextField size1TextField;
    private JLabel priceMe1;
    private JLabel menu2;
    private JTextField menu2Field;
    private JTextField size2TextField;
    private JLabel priceMe2;
    private JLabel menu3;
    private JTextField menu3Field;
    private JTextField size3TextField;
    private JLabel priceMe3;
    private JLabel menu4;
    private JTextField menu4Field;
    private JTextField size4TextField;
    private JLabel priceMe4;
    private JLabel menu5;
    private JTextField menu5Field;
    private JTextField size5TextField;
    private JLabel priceMe5;
    private JLabel menu6;
    private JTextField menu6Field;
    private JTextField size6TextField;
    private JLabel priceMe6;


    private JPanel nextPage;
    private JButton nextButton;
    static customer h = new customer("", 0, "null", 0);
        





    public orderPage(){
        super("Order page");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
        setSize(400,700);

        bigpanel = new JPanel();
        bigpanel.setBackground(Color.darkGray);
        bigpanel.setLayout(new GridLayout(7,1));
        h = registerPage.o;
       
        title = new JLabel("ORDER");
        title.setFont(new Font("Serif", Font.ITALIC, 36));
        title.setForeground(Color.BLUE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setLayout(new BoxLayout (title,BoxLayout.X_AXIS));
        titlePanel = new JPanel();
        titlePanel.add(title);

        nameMemberPanel = new JPanel();
        // nameMemberPanel.setBackground(Color.);
        name = new JLabel("Name");
        member = new JLabel("Member");
        showname = new JTextArea(1,10);
        showname.setText(h.name);
        showmember = new JTextArea(1,10);
        showmember.setText(String.format("%d",h.memberType));
        nameMemberPanel.setBorder(BorderFactory.createEmptyBorder(0, 0,0,0));
        nameMemberPanel.add(name);
        nameMemberPanel.add(showname);
        nameMemberPanel.add(member);
        nameMemberPanel.add(showmember);

        besstsell = new JPanel();
        besstsell.setLayout(new GridLayout(2,1));
        bestJPanel = new JPanel();

        bestJLabel= new JLabel("Best Selling");
        bestJPanel.setBackground(Color.LIGHT_GRAY);
        bestJPanel.add(bestJLabel);

        TopTable = new JPanel();
        TopTable.setLayout(new GridLayout(1,4));
        menutop = new JLabel("Menu");
        cuptop = new JLabel("quantity");
        sizetop = new JLabel("size(s,m,l)");
        price = new JLabel("Price(Bath)");


        menuJPanel= new JPanel();
        menuJPanel.add(menutop);
        TopTable.add(menuJPanel);

        pricepPanel = new JPanel();
        pricepPanel.add(price);
        TopTable.add(pricepPanel);

        cupPanel = new JPanel();
        cupPanel.add(cuptop);
        TopTable.add(cupPanel);

        sizepanel = new JPanel();
        sizepanel.add(sizetop);
        TopTable.add(sizepanel);

        besstsell.add(bestJPanel);
        besstsell.add(TopTable);

        menu1JPanel = new JPanel();
        menu1JPanel.setBackground(Color.LIGHT_GRAY);
        menu1JPanel.setLayout(new GridLayout(2,4));

        menu2JPanel = new JPanel();
        menu2JPanel.setBackground(Color.LIGHT_GRAY);
        menu2JPanel.setLayout(new GridLayout(2,4));

        menu3JPanel = new JPanel();
        menu3JPanel.setBackground(Color.LIGHT_GRAY);
        menu3JPanel.setLayout(new GridLayout(2,4));


        menu1 = new JLabel("Thai Iced Tea");
        menu1Field = new JTextField(10);
        size1TextField = new JTextField();
        priceMe1 = new JLabel("30");
        
        JPanel temPanel1 = new JPanel();
        temPanel1.add(priceMe1);

        menu2 = new JLabel("Espresso");
        menu2Field = new JTextField(10);
        size2TextField = new JTextField();
        priceMe2 = new JLabel("70");
        JPanel temPanel2 = new JPanel();
        temPanel2.add(priceMe2);

        menu3 = new JLabel("Green Tea Latte");
        menu3Field = new JTextField(10);
        size3TextField = new JTextField();
        priceMe3 = new JLabel("80");
        JPanel temPanel3 = new JPanel();
        temPanel3.add(priceMe3);

        menu4 = new JLabel("Mango Smoothie");
        menu4Field = new JTextField(10);
        size4TextField = new JTextField();
        priceMe4 = new JLabel("60");
        JPanel temPanel4 = new JPanel();
        temPanel4.add(priceMe4);

        menu5 = new JLabel("Iced Cappuccino");
        menu5Field = new JTextField(10);
        size5TextField = new JTextField();
        priceMe5 = new JLabel("70");
        JPanel temPanel5 = new JPanel();
        temPanel5.add(priceMe5);

        menu6= new JLabel("Matcha Latte");
        menu6Field = new JTextField(10);
        size6TextField = new JTextField();
        priceMe6 = new JLabel("65");
        JPanel temPanel6 = new JPanel();
        temPanel6.add(priceMe6);

        menu1JPanel.add(menu1);
        menu1JPanel.add(temPanel1);
        menu1JPanel.add(menu1Field);
        menu1JPanel.add(size1TextField);
        menu1JPanel.add(menu2);
        menu1JPanel.add(temPanel2);
        menu1JPanel.add(menu2Field);
        menu1JPanel.add(size2TextField);
        
        
        menu2JPanel.add(menu3);
        menu2JPanel.add(temPanel3);
        menu2JPanel.add(menu3Field);
        menu2JPanel.add(size3TextField);
        menu2JPanel.add(menu4);
        menu2JPanel.add(temPanel4);
        menu2JPanel.add(menu4Field);
        menu2JPanel.add(size4TextField);
        
        menu3JPanel.add(menu5);
        menu3JPanel.add(temPanel5);
        menu3JPanel.add(menu5Field);
        menu3JPanel.add(size5TextField);
        menu3JPanel.add(menu6);
        menu3JPanel.add(temPanel6);
        menu3JPanel.add(menu6Field);
        menu3JPanel.add(size6TextField);

        nextPage = new JPanel();
        nextButton = new JButton("NEXT PAGE");
        nextButton.addActionListener(this);
        nextPage.add(nextButton);   
        
        bigpanel.add(nameMemberPanel);
        bigpanel.add(besstsell);
        bigpanel.add(menu1JPanel);
        bigpanel.add(menu2JPanel);
        bigpanel.add(menu3JPanel);
        bigpanel.add(nextPage);
        
        getContentPane().add(bigpanel, BorderLayout.CENTER);
        getContentPane().add(titlePanel, BorderLayout.NORTH);

        setVisible(true);

    }
    public static void main(String[] args) {
        new orderPage();


        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("filename.bin",true))) {
            out.writeObject(homePage.orderlist);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==nextButton) {
            if(menu1Field.getText().length() > 0){
                menuclass temp = getSomething(1);
                homePage.orderlist.add(new order(h.orderID, temp.type,1, size1TextField.getText(), temp.price,Integer.parseInt(menu1Field.getText())));
                
            }
            if(menu2Field.getText().length() > 0){
                menuclass temp = getSomething(2);
                homePage.orderlist.add(new order(h.orderID, temp.type,2, size2TextField.getText(), temp.price,Integer.parseInt(menu2Field.getText())));
                
            }
            if(menu3Field.getText().length() > 0){
                menuclass temp = getSomething(3);
                homePage.orderlist.add(new order(h.orderID, temp.type,3, size3TextField.getText(), temp.price,Integer.parseInt(menu3Field.getText())));
                
            }
            if(menu4Field.getText().length() > 0){
                menuclass temp = getSomething(4);
                homePage.orderlist.add(new order(h.orderID, temp.type,4, size4TextField.getText(), temp.price,Integer.parseInt(menu4Field.getText())));
                
            }
            if(menu5Field.getText().length() > 0){
                menuclass temp = getSomething(5);
                homePage.orderlist.add(new order(h.orderID, temp.type,5, size5TextField.getText(), temp.price,Integer.parseInt(menu5Field.getText())));
                
            }
            if(menu6Field.getText().length() > 0){
                menuclass temp = getSomething(6);
                homePage.orderlist.add(new order(h.orderID, temp.type,6, size6TextField.getText(), temp.price,Integer.parseInt(menu6Field.getText())));
                
            }
            
            new receipt();
            dispose();
        }
    }

    public menuclass getSomething(int i){
        for (menuclass menuclass : homePage.menuList) {

            if (menuclass.Nomenu == i) {
                return menuclass;
            }
        }
        return null;
       
    }
   


}

