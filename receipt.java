import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.swing.*;
public class receipt extends JFrame implements ActionListener {
    private JPanel bigPanel;
    private JLabel title;
    private JPanel titlePanel;
    private JPanel nameMemberPanel;
    private JLabel name;
    private JLabel member;
    private JTextArea showname;
    private JTextArea showmember;
    private JPanel line2;
    private JLabel yourOrder;
    discout dis = new discout();

    private JPanel line3;
    
    private JLabel menuJLabel;
    private JLabel price;
    private JLabel quantity;
    private JLabel priceAll;


    //menu1
    private JPanel line4;
    private JLabel menu1Name;
    private JLabel menu1price;
    private JLabel menu1quantity;
    private JLabel menu1AllPrice;

//menu2
    private JPanel line5;
    private JLabel menu2Name;
    private JLabel menu2price;
    private JLabel menu2quantity;
    private JLabel menu2AllPrice;

    private JPanel line6;
    private JLabel menu3Name;
    private JLabel menu3price;
    private JLabel menu3quantity;
    private JLabel menu3AllPrice;
    
    private JPanel line7;
    private JLabel menu4Name;
    private JLabel menu4price;
    private JLabel menu4quantity;
    private JLabel menu4AllPrice;

    private JPanel line8;
    private JLabel menu5Name;
    private JLabel menu5price;
    private JLabel menu5quantity;
    private JLabel menu5AllPrice;
    private JPanel line9;
    private JLabel menu6Name;
    private JLabel menu6price;
    private JLabel menu6quantity;
    private JLabel menu6AllPrice;

    private JPanel line10;
    private JPanel sumJPanel;
    private JLabel sum;
    private JLabel sumField;

    private JPanel line11;
    private JLabel discout;
    private JPanel discoutJPanel;
    private JLabel discouTextField;


    private JPanel line12;
    private JLabel totle;
    private JPanel totleJPanel;
    private JLabel totleextField;

    private JPanel line13;

    private Button next;
    static customer C = new customer(null, ALLBITS, null, ABORT) ;
   

    

    public receipt(){
        super("Receipt");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(500, 700);
        C = orderPage.h;
        order temp1 =    getordername(C.orderID, 1);
        order temp2 =  getordername(C.orderID, 2);
        order temp3 =  getordername(C.orderID, 3);
        order temp4 =  getordername(C.orderID, 4);
        order temp5 =  getordername(C.orderID, 5);
        order temp6 =  getordername(C.orderID, 6);
        double sunofprice = sumprice(C.orderID);
        double discoutcal= dis.calculatedicout(C.memberType,sunofprice ) ;


        bigPanel = new JPanel();
        bigPanel.setLayout(new GridLayout(14,1));
        title = new JLabel("Star-Duck Coffee");
        title.setFont(new Font("Serif", Font.ITALIC, 36));
        title.setForeground(Color.BLUE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setLayout(new BoxLayout(title, BoxLayout.X_AXIS));
        titlePanel = new JPanel();
        titlePanel.add(title);

        nameMemberPanel = new JPanel();
        name = new JLabel("Name");

        member = new JLabel("Member");
        showname = new JTextArea(1,10);
        showname.setText(C.name);
        showmember = new JTextArea(1,10);
        showmember.setText(String.format("%d",C.memberType));
        nameMemberPanel.setBorder(BorderFactory.createEmptyBorder(10, 0,0,0));
        nameMemberPanel.add(name);
        nameMemberPanel.add(showname);
        nameMemberPanel.add(member);
        nameMemberPanel.add(showmember);

        line2 = new JPanel();
        line2.setBackground(Color.red);
        yourOrder = new JLabel("Your Order"); 
        line2.add(yourOrder);
        
        line3 = new JPanel();
        line3.setLayout(new GridLayout(1, 4));

        menuJLabel = new JLabel("Menu");
        JPanel nemuJPanel = new JPanel();
        nemuJPanel.setBackground(Color.lightGray);
        nemuJPanel.add(menuJLabel);

        price = new JLabel("price/each");
        JPanel pricepPanel = new JPanel();
        pricepPanel.setBackground(Color.lightGray);
        pricepPanel.add(price);

        quantity = new JLabel("Quantity");
        JPanel qJPanel = new JPanel();
        qJPanel.setBackground(Color.lightGray);
        qJPanel.add(quantity);

        priceAll = new JLabel("price");
        JPanel priceallJPanel = new JPanel();
        priceallJPanel.setBackground(Color.lightGray);
        priceallJPanel.add(priceAll);
        
        line3.add(nemuJPanel);
        line3.add(pricepPanel);
        line3.add(qJPanel);
        line3.add(priceallJPanel);

        line4 =  new JPanel();
        line4.setLayout(new GridLayout(1, 4));
        menu1Name = new JLabel(getname(1));
        JPanel menu1namePanel = new JPanel();
        menu1namePanel.setBackground(Color.lightGray);
        menu1namePanel.add(menu1Name);
        line4.add(menu1namePanel);
        
        JPanel panelmenu1 = new JPanel();
        menu1price = new JLabel();
        panelmenu1.add(menu1price);
        menu1price.setText(String.format("%.2f",temp1.price));
        line4.add(panelmenu1);
        menu1quantity = new JLabel();
        JPanel panelquan1 = new JPanel();
        menu1quantity.setText(String.format("%d",temp1.num));
        panelquan1.add(menu1quantity);
        line4.add(panelquan1);
        menu1AllPrice = new JLabel();
        JPanel panelallprice1 = new JPanel();
        panelallprice1.add(menu1AllPrice);
        menu1AllPrice.setText(String.format("%.2f",(temp1.num*temp1.price)));
        line4.add(panelallprice1);

        line5 =  new JPanel();
        line5.setLayout(new GridLayout(1, 4));
        menu2Name = new JLabel();
        menu2Name.setText(getname(2));
        JPanel menu2namePanel = new JPanel();
        menu2namePanel.setBackground(Color.lightGray);
        menu2namePanel.add(menu2Name);
        line5.add(menu2namePanel);
        JPanel panelmenu2 = new JPanel();
        menu2price = new JLabel();
        panelmenu2.add(menu2price);
        menu2price.setText(String.format("%.2f",temp2.price));
        line5.add(panelmenu2);
        menu2quantity = new JLabel();
        JPanel panelquan2 = new JPanel();
        menu2quantity.setText(String.format("%d",temp2.num));
        panelquan2.add(menu2quantity);
        line5.add(panelquan2);
        menu2AllPrice = new JLabel();
        JPanel panelallprice2 = new JPanel();
        panelallprice2.add(menu2AllPrice);
        menu2AllPrice.setText(String.format("%.2f",(temp2.num*temp2.price)));
        line5.add(panelallprice2);

        line6 =  new JPanel();
        line6.setLayout(new GridLayout(1, 4));
        menu3Name = new JLabel();
        menu3Name.setText(getname(3));
        JPanel menu3namePanel = new JPanel();
        menu3namePanel.setBackground(Color.lightGray);
        menu3namePanel.add(menu3Name);
        line6.add(menu3namePanel);
        JPanel panelmenu3 = new JPanel();
        menu3price = new JLabel();
        panelmenu3.add(menu3price);
        menu3price.setText(String.format("%.2f",temp3.price));
        line6.add(panelmenu3);
        menu3quantity = new JLabel();
        JPanel panelquan3 = new JPanel();
        menu3quantity.setText(String.format("%d",temp3.num));
        panelquan3.add(menu3quantity);
        line6.add(panelquan3);
        menu3AllPrice = new JLabel();
        JPanel panelallprice3 = new JPanel();
        panelallprice3.add(menu3AllPrice);
        menu3AllPrice.setText(String.format("%.2f",(temp3.num*temp3.price)));
        line6.add(panelallprice3);
        

        line7 =  new JPanel();
        line7.setLayout(new GridLayout(1, 4));
        menu4Name = new JLabel();
        menu4Name.setText(getname(4));
        JPanel menu4namePanel = new JPanel();
        menu4namePanel.setBackground(Color.lightGray);
        menu4namePanel.add(menu4Name);
        line7.add(menu4namePanel);
        JPanel panelmenu4 = new JPanel();
        menu4price = new JLabel();
        panelmenu4.add(menu4price);
        menu4price.setText(String.format("%.2f",temp4.price));
        line7.add(panelmenu4);
        menu4quantity = new JLabel();
        JPanel panelquan4 = new JPanel();
        menu4quantity.setText(String.format("%d",temp4.num));
        panelquan4.add(menu4quantity);
        line7.add(panelquan4);
        menu4AllPrice = new JLabel();
        JPanel panelallprice4 = new JPanel();
        panelallprice4.add(menu4AllPrice);
        menu4AllPrice.setText(String.format("%.2f",(temp4.num*temp4.price)));
        line7.add(panelallprice4);

        line8 =  new JPanel();
        line8.setLayout(new GridLayout(1, 4));
        menu5Name = new JLabel();
        menu5Name.setText(getname(5));
        JPanel menu5namePanel = new JPanel();
        menu5namePanel.setBackground(Color.lightGray);
        menu5namePanel.add(menu5Name);
        line8.add(menu5namePanel);
        JPanel panelmenu5 = new JPanel();
        menu5price = new JLabel();
        panelmenu5.add(menu5price);
        menu5price.setText(String.format("%.2f",temp5.price));
        line8.add(panelmenu5);
        menu5quantity = new JLabel();
        JPanel panelquan5 = new JPanel();
        menu5quantity.setText(String.format("%d",temp5.num));
        panelquan5.add(menu5quantity);
        line8.add(panelquan5);
        menu5AllPrice = new JLabel();
        JPanel panelallprice5 = new JPanel();
        panelallprice5.add(menu5AllPrice);
        menu5AllPrice.setText(String.format("%.2f",(temp5.num*temp5.price)));
        line8.add(panelallprice5);

        line9 =  new JPanel();
        line9.setLayout(new GridLayout(1, 4));
        menu6Name = new JLabel();
    
        menu6Name.setText(getname(6));
        JPanel menu6namePanel = new JPanel();
        menu6namePanel.setBackground(Color.lightGray);
        menu6namePanel.add(menu6Name);
        line9.add(menu6namePanel);
        JPanel panelmenu6 = new JPanel();
        menu6price = new JLabel();
        panelmenu6.add(menu6price);
        menu6price.setText(String.format("%.2f",temp6.price));
        line9.add(panelmenu6);
        menu6quantity = new JLabel();
        JPanel panelquan6 = new JPanel();
        menu6quantity.setText(String.format("%d",temp6.num));
        panelquan6.add(menu6quantity);
        line9.add(panelquan6);
        menu6AllPrice = new JLabel();
        JPanel panelallprice6 = new JPanel();
        panelallprice6.add(menu6AllPrice);
        menu6AllPrice.setText(String.format("%.2f",(temp6.num*temp6.price)));
        line9.add(panelallprice6);
        
        line10 = new JPanel();
        line10.setLayout(new GridLayout(1, 2));
        sum = new JLabel("Sum");
        sumJPanel = new JPanel();
        sumJPanel.add(sum);
        sumField = new JLabel();
        JPanel sumtemp = new JPanel();
        sumtemp.add(sumField);
        sumField.setText(String.format("%.2f",sunofprice));
        line10.add(sumJPanel);
        line10.add(sumtemp);

        line11 = new JPanel();
        line11.setLayout(new GridLayout(1, 2));
        discout= new JLabel("discout");
        discoutJPanel = new JPanel();
        discoutJPanel.add(discout);
        discouTextField = new JLabel();
        discouTextField.setText(String.format("%.2f",discoutcal));
        JPanel paneldis= new JPanel();
        paneldis.add(discouTextField);
        line11.add(discoutJPanel);
        line11.add(paneldis); 

        line12 = new JPanel();
        line12.setLayout(new GridLayout(1, 2));
        totle= new JLabel("totle");
        totleJPanel = new JPanel();
        totleJPanel.add(totle);
        totleextField = new JLabel();
        totleextField.setText(String.format("%.2f", sunofprice-discoutcal));
        JPanel paneltotle = new JPanel();
        paneltotle.add(totleextField);
        line12.add(totleJPanel);
        line12.add(paneltotle); 

        line13 = new JPanel();
        next = new Button("next");
        next.addActionListener(this);
        line13.add(next);
        



        bigPanel.add(nameMemberPanel);
        bigPanel.add(line2);
        bigPanel.add(line3);
        bigPanel.add(line4);
        bigPanel.add(line5);
        bigPanel.add(line6);
        bigPanel.add(line7);
        bigPanel.add(line8);
        bigPanel.add(line9);
        bigPanel.add(line10);
        bigPanel.add(line11);
        bigPanel.add(line12);
        bigPanel.add(line13);

        getContentPane().add(titlePanel, BorderLayout.NORTH);
        getContentPane().add(bigPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        new receipt();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource() == next) {
        dispose();
       }
    }
    public order getordername(int orderID,int menu){
        for (order menuclass : homePage.orderlist) {
            if (menuclass.orderID == orderID) {
                if (menuclass.Nomenu== menu) {
                   return menuclass;
                }
            }
        }
        return new order(0, "", 0, "", 0, 0);
    }

    public String getname(int menu){
        for (menuclass menunode: homePage.menuList) {
            if (menunode.Nomenu == menu) {
                
                   return menunode.type;
            }
        }
        return null;
    }

    public double sumprice(int orderID){
        Double sum =  (double) 0 ;
        for (order menuclass : homePage.orderlist) {
            if (menuclass.orderID == orderID) {
               sum = sum+ (menuclass.price*menuclass.num);
            }
        }
        return sum;
    }

    public int findtire(int iDorder) {
        for (customer cus: homePage.memberList) {
            if (iDorder == cus.orderID ) {
                return cus.memberType;
            }
        }
        return 0;
    }
 

}


