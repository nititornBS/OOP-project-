import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.*;


public class list extends JFrame implements ActionListener {
    private JPanel bigPanel;
    private JLabel title;
    private JPanel titlePanel;
    private JPanel listJPanel;
    private JLabel listJLabel;
    private Button showdetaiil;
    private Panel showpPanel;
    JList<String> list;
    public static int index=-1;
    int thing=-1;
    private JPanel backJPanel;
    private JButton back;
    

    public list(){
        super("List of order");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(375, 700);
        bigPanel = new JPanel();
        bigPanel.setBackground(Color.GRAY);
        title = new JLabel("Star-Duck Coffee");
        title.setFont(new Font("Serif", Font.ITALIC, 36));
        title.setForeground(Color.BLUE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setLayout(new BoxLayout(title, BoxLayout.X_AXIS));
        titlePanel = new JPanel();
        titlePanel.add(title);

        listJPanel= new JPanel();
        listJLabel = new JLabel("List of order");
        listJPanel.add(listJLabel);

        showdetaiil = new Button("show");
        showdetaiil.addActionListener(this);
        showpPanel = new Panel();
        showpPanel.add(showdetaiil);

        DefaultListModel<String> model = new DefaultListModel<>();
        for (customer cus : homePage.memberList) {
        model.addElement(cus.toString());
        }
        list = new JList<>(model);
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setPreferredSize(new Dimension(300, 475));

      bigPanel.add(listJPanel);
      bigPanel.add(scrollPane);
      bigPanel.add(showpPanel);
      backJPanel = new JPanel();
      back = new JButton("Back to main page");
      back.addActionListener(this);
      backJPanel.add(back);

        getContentPane().add(titlePanel, BorderLayout.NORTH);
        getContentPane().add(bigPanel, BorderLayout.CENTER);
        getContentPane().add(backJPanel, BorderLayout.SOUTH);
        setVisible(true);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
         thing = list.getSelectedIndex();
        if (e.getSource() == showdetaiil) {
            index = thing;
            list.clearSelection();
            new receiptshow();
            dispose();
        }
        if (e.getSource() == back) {
            dispose();
        }

    }
    public static void main(String[] args) {
        new list();
    }
    
    public String getname(int menu){
        for (customer cus: homePage.memberList) {
            if (cus.orderID == menu) {
                   return cus.name;
            }
        }
        return "null";
    }

    public void close() {
        WindowEvent windowclosingegen = new WindowEvent(this,WindowEvent.WINDOW_CLOSING ); 
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(windowclosingegen);
    }
}
