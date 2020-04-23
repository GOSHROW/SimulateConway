import java.awt.*;  
import java.awt.event.*;  
import java.util.*;


class GUI extends WindowAdapter{  

    Frame f;
    int[][] twodArray;
    int r, c, t;

    GUI() {  
        f = new Frame();  
        f.addWindowListener(this);  
        f.setSize(400,250);  
        f.setLayout(null);  
        f.setTitle("GOSHROW's Conway's Game of Life");
        f.setLocationRelativeTo(null);
        f.setVisible(true);  
    }                                    

    public void getParams() {                             
        TextField row = new TextField ("50");
        TextField col = new TextField ("50");  
        TextField tm = new TextField ("1");    
        Label rowL = new Label ("Enter no. of rows");
        Label colL = new Label ("Enter no. of columns");
        Label tmL = new Label ("Enter time-gap in milli-seconds");                                                                                                            
        row.setEditable(true);
        col.setEditable(true);
        tm.setEditable(true);
        row.setBounds(250, 50, 100, 30);  
        col.setBounds(250, 100, 100, 30); 
        tm.setBounds(250, 150, 100, 30);
        rowL.setBounds(50, 50, 135, 30);
        colL.setBounds(50, 100, 135, 30);
        tmL.setBounds(50, 150, 135, 30); 
        f.add(row); 
        f.add(col);
        f.add(tm);
        f.add(rowL);
        f.add(colL);
        f.add(tmL);
        Button submit = new Button("Start Sim");
        submit.setBounds(150, 210, 100, 30);
        submit.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                    r = Integer.parseInt(row.getText());
                    c = Integer.parseInt(col.getText());
                    t = Integer.parseInt(tm.getText());
                    logic();
                }  
            }
        );
        f.add(submit);
    }

    public void windowClosing(WindowEvent e) {  
        f.dispose();  
    }  

    public void logic() {

    }
}

public class Main {
    public static void main(String[] args) {  
        GUI ob = new GUI();  
        // while (True) {
        ob.getParams();
    }  

}  