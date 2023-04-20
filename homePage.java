/**
 * homePage
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
public class homePage extends JFrame implements ActionListener {
    private JPanel paneltitle;
    private JPanel panelbotton;
    private JPanel bigPanel;
    public static ArrayList<customer> memberList = new ArrayList<>();
    public static ArrayList<order> orderlist = new ArrayList<>();
    public static ArrayList<menuclass> menuList = new ArrayList<>();
    
    public JMenuBar menuBar;
    public JMenu mainPage;
    private JMenuItem exit;
    private JMenuItem order;
    private JMenuItem listoforder;

    
    private JLabel title;
    private JButton orderButton;
    private JButton showorder;
    private JButton exiButton;



    public homePage() {
        setTitle("wellcome to coffee ");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
        setSize(300,300);
        menuBar = new JMenuBar();
        mainPage = new JMenu("main Page");
        exit = new JMenuItem("Exit");
        exit.addActionListener(this);
        order = new JMenuItem("Order");
        order.addActionListener(this);
        listoforder = new JMenuItem("List of order");
        listoforder.addActionListener(this);
        mainPage.add(order);
        mainPage.add(listoforder);
        mainPage.add(exit);
        menuBar.add(mainPage);
        setJMenuBar(menuBar);
        title = new JLabel("Star-Duck Coffee");
        title.setFont(new Font("Serif", Font.ITALIC, 36));
        title.setForeground(Color.BLUE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setLayout(new BoxLayout (title,BoxLayout.X_AXIS));
   
        paneltitle = new JPanel();
        paneltitle.setLayout(new BoxLayout (paneltitle,BoxLayout.Y_AXIS));
        panelbotton = new JPanel();
        panelbotton.setLayout(new BoxLayout(panelbotton,BoxLayout.Y_AXIS));
        

        showorder = new JButton("show the order");
        showorder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new list();
            }
        });
        
        
        exiButton = new JButton("exit");
        exiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        
        
        bigPanel = new JPanel();
        bigPanel.setLayout(new GridLayout(4,1));
        
        orderButton = new JButton("Order the coffee");
        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new registerPage();
            }
        });
        
        paneltitle.add(title);
        
        
        
        bigPanel.add(paneltitle);
        bigPanel.add(orderButton);
        bigPanel.add(showorder);
        bigPanel.add(exiButton);
        
        
        add(bigPanel);
        setVisible(true);   
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
      if (e.getSource()==order) {
        new list();
      }else if (e.getSource()==listoforder){
        new registerPage();
      }
      else if(e.getSource()==exit){
        System.exit(0);      }
    }
    public static void main(String[] args) throws IOException {
        memberList.add(new customer("Thana", 1, "111526",1));
        memberList.add(new customer("Somchai", 2, "526480",2));
        memberList.add(new customer("Supansa", 3, "696359",3));
        addINfile();
        menuList.add(new menuclass(1, "Thai Iced Tea", 30));
        menuList.add(new menuclass(2, "Espresso", 70));
        menuList.add(new menuclass(3, "Green Tea Latte", 80));
        menuList.add(new menuclass(4, "Mango Smoothie", 60));
        menuList.add(new menuclass(5, "Iced Cappuccino", 75));
        menuList.add(new menuclass(6, "Matcha Latte", 65));
        
        
        
        orderlist.add(new order(1, "Thai Iced Tea",1,"s", 30,2));
        orderlist.add(new order(2, "Espresso",2,"s", 70,1));
        orderlist.add(new order(2, "Green Tea Latte",3,"s", 80,3));
        orderlist.add(new order(1, "Mango Smoothie",4,"s", 60,4));
        orderlist.add(new order(3, "Iced Cappuccino",5,"s", 75,5));
        orderlist.add(new order(3, "Matcha Latte",6,"s", 65,6));
        addtobinary();
       new homePage();
    }
  
    public static void addINfile() throws IOException {
        FileWriter writer = new FileWriter("filename.txt");
         for (customer item : memberList) {
            writer.write("order iD" + item.orderID +"  Name :"+item.name +"  type :" + item.memberType +" Member ID : " + item.memberID + "\n");
         }
         writer.close();
    }
    

    public static void addtobinary() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("filename.bin"))) {
            out.writeObject(orderlist);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}


