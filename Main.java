import java.awt.*;  
import java.awt.event.*;  
import java.util.*;
import javax.swing.*;
import java.util.Timer;

class GUI extends WindowAdapter{  

    Frame f;
    boolean[][] twodArray;
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
        JSpinner row = new JSpinner (new SpinnerNumberModel(60, 2, 200, 1));
        JSpinner col = new JSpinner (new SpinnerNumberModel(50, 2, 160, 1));  
        JSpinner tm = new JSpinner (new SpinnerNumberModel(50, 50, 10000, 50));    
        Label rowL = new Label ("Enter no. of rows");
        Label colL = new Label ("Enter no. of columns");
        Label tmL = new Label ("Enter time-gap in milli-seconds");                                                                                                            
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
                    r = Integer.parseInt(row.getValue().toString().trim());
                    c = Integer.parseInt(col.getValue().toString().trim());
                    t = Integer.parseInt(tm.getValue().toString().trim());
                    
                    GUISetup();
                }  
            }
        );
        f.add(submit);
        f.validate();
    }

    public void windowClosing(WindowEvent e) {  
        f.dispose();  
        System.exit(0);
    }  

    public void GUISetup() {
        twodArray = new boolean[r][c];
        for (int i = 0, len = twodArray.length; i < len; i++) {
            Arrays.fill(twodArray[i], false);
        }
        
        Button [][]btns = new Button[r][c];
        f.removeAll();
        f.validate();
        f.setSize (900,750);
        f.setLocationRelativeTo (null);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                f.dispose();
            }
        });
        int btnDim = 15;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j< c; j++) {
                btns[i][j] = new Button (" ");
                btns[i][j].setBounds(0 + i * btnDim, 0 + j * btnDim, btnDim, btnDim);
                f.add(btns[i][j]);
                btns[i][j].addActionListener (new ActionListener () {  
                    public void actionPerformed (ActionEvent e) { 
                        String []indices = e.getSource().toString().split(",");
                        int idx = (Integer.parseInt(indices[1]) / 15);
                        int jdx = (Integer.parseInt(indices[2]) / 15);
                        if (twodArray[idx][jdx]) {
                            btns[idx][jdx].setBackground(new Color(0, 255, 0));
                        } else {
                            btns[idx][jdx].setBackground(new Color(0, 0, 255));
                        }
                        twodArray[idx][jdx] = !twodArray[idx][jdx];
                        System.out.println("Toggled " + idx + " " + jdx + " " + twodArray[idx][jdx]);
                    }
                });
            }
        }
        f.validate();

        Timer timer = new Timer();
        Logic logic = new Logic();
        TimerTask myTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Status " + twodArray[0][2]);
                twodArray = logic.getNextGen(twodArray);
            }
        };

        timer.schedule(myTask, t, t);
    }
}

class Logic {

    Logic() {

    }

    public boolean[][] getNextGen(boolean prev[][]) {
        return prev;
    }
}


public class Main {
    public static void main(String[] args) {  
        GUI ob = new GUI();  
        // while (True) {
        ob.getParams();
    }  

}  