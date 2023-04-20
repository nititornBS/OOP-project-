import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;

public class registerPage extends JFrame implements ActionListener {
    private JPanel bigPanel;
    private JLabel title;
    private JPanel titlePanel;
    
    private JLabel name;
    private JTextField namebox;
    private JPanel mtLPanel;
    private JPanel mtRPanel;

    private JLabel memberTitle;
    private JPanel memberJPanel;

    private JPanel tempmember;

    private JPanel buttonmemberPanel;
    private JButton noMember;
    private JButton t1Button;
    private JButton t2Button;
    private JButton t3Button;
    
    private JPanel iDPanel;
    private JLabel ID;
    private TextField iDField;
    private JPanel test;
    private JButton nextPagebutton;
    private int t = 0;
    public static customer o ;

    
    
    public registerPage() {
        super("Register page");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(400, 300);
        title = new JLabel("Star-Duck Coffee");
        title.setFont(new Font("Serif", Font.ITALIC, 36));
        title.setForeground(Color.BLUE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setLayout(new BoxLayout(title, BoxLayout.X_AXIS));
        titlePanel = new JPanel();
        titlePanel.add(title);


        bigPanel = new JPanel();
        bigPanel.setLayout(new GridLayout(3, 1));
        bigPanel.add(titlePanel);

        mtLPanel = new JPanel();
        mtRPanel = new JPanel();

        name = new JLabel("Name");
        name.setHorizontalAlignment(JLabel.CENTER);
        namebox = new JTextField(20);
        namebox.setPreferredSize(new Dimension(250, 40));

        JPanel namePanel = new JPanel();

        namePanel.add(name);
        namePanel.add(namebox);

        bigPanel.add(namePanel);

        memberTitle = new JLabel("Are you a member ??");
        memberJPanel = new JPanel();
        memberJPanel.setLayout(new GridLayout(2, 1));
        memberJPanel.setLayout(new BoxLayout(memberJPanel, BoxLayout.Y_AXIS));
        tempmember = new JPanel();

        tempmember.add(memberTitle);
        memberJPanel.add(tempmember);

        buttonmemberPanel = new JPanel();

        noMember = new JButton("NO");
        noMember.addActionListener(this);
        t1Button = new JButton("I");
        t1Button.addActionListener(this);
        t2Button = new JButton("II");
        t2Button.addActionListener(this);
        t3Button = new JButton("III");
        t3Button.addActionListener(this);

        buttonmemberPanel.add(noMember);
        buttonmemberPanel.add(t1Button);
        buttonmemberPanel.add(t2Button);
        buttonmemberPanel.add(t3Button);

        memberJPanel.add(buttonmemberPanel);

        bigPanel.add(memberJPanel);

        iDPanel = new JPanel();
        iDPanel.setBackground(Color.red);

        ID = new JLabel("ID : ");
        iDField = new TextField();
        iDField.setPreferredSize(new Dimension(100, 20));

        test = new JPanel();
        test.setLayout(new GridLayout(2, 1));

        nextPagebutton = new JButton("Next Page");
        nextPagebutton.addActionListener(this);

        iDPanel.add(ID);
        iDPanel.add(iDField);

        test.add(iDPanel);
        test.add(nextPagebutton);

        bigPanel.add(test);



        getContentPane().add(titlePanel, BorderLayout.NORTH);
        getContentPane().add(bigPanel, BorderLayout.CENTER);
        getContentPane().add(mtRPanel, BorderLayout.EAST);
        getContentPane().add(mtLPanel, BorderLayout.WEST);

        setVisible(true);

    }

    public static void main(String[] args) {
       
        new registerPage();
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == noMember) {
            iDField.setText("------");
            t=0;
       }

       if (e.getSource() == t1Button) {
        t = 1;
        iDField.setText("");
       }
       else if (e.getSource() == t2Button) {
        t = 2;
        iDField.setText("");

       }
       else if (e.getSource() == t3Button) {
        t = 3;
        iDField.setText("");

       }

       if (e.getSource() == nextPagebutton) {
        try {
        if (namebox.getText().length()!=0) {
            if (iDField.getText().length()==6) {
                customer s = new customer(namebox.getText(), createOrderID (),iDField.getText() ,t );
        homePage.memberList.add(s);

        try {
            FileWriter writer = new FileWriter("filename.txt");
            for ( customer item : homePage.memberList) {
               writer.write("order iD" + item.orderID +"  Name :"+item.name +"  type :" + item.memberType +" Member ID : " + item.memberID + "\n");
            }
            writer.close();
         } catch (IOException p) {
            p.printStackTrace();
        
         }
            o=s;
            }else {
                throw  new InputMismatchException("ID member have to be 6 digit ");
            }
                new orderPage();
                dispose();
            JOptionPane.showMessageDialog(this, "Add name successfully.");
        }
    else{
        throw  new InputMismatchException("You have to  put the name");
    }
} 
        catch (InputMismatchException ex) {
            String message = "Wrong input. Please check data type. \nError: " + ex;
            JOptionPane.showMessageDialog(this, message );
        
        
        } catch (Exception ex) {
             JOptionPane.showMessageDialog(this, "Some error occurred. Please contact the admin.\n" + ex );
        }
        
       }


    }

    public int createOrderID (){
        int id=0;
        for (customer cus : homePage.memberList) {
            id++;
            
           
        }
        return id+1;
        
    }
    public int createOrde (){
        int id=0;
        for (customer cus : homePage.memberList) {
            id++;
            

           
        }
        return id+1;
        
    }

   


 


}
