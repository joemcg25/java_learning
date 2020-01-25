
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joe
 */
public class BlackJackView implements Runnable {
    private JFrame obj;
    private Blackjack bljack;

    @Override
    public void run() {
        obj = new JFrame("Black Jack View");
        obj.setPreferredSize(new Dimension(750, 250));
        obj.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(obj.getContentPane());

        obj.pack();
        obj.setVisible(true);
    }
    
    private JPanel createPanelObj(int x,int y){
        JPanel panel = new JPanel(new GridLayout(x, y));
        return panel;        
    }
    
    private void createComponents(Container container) {
        GridLayout layout=new GridLayout(3, 3);
        Blackjack log=new Blackjack(true);
        JTextField display=new JTextField("Dealer Score");
        JTextField display1=new JTextField("0");
        display.setEnabled(false);
        JPanel panel=createPanelObj(1,2);
        panel.add(display);
        panel.add(display1);
        JTextField txtFld=new JTextField("User Score");
        JTextField txtFld1=new JTextField("0");
        JPanel panel1=createPanelObj(1,2);
        panel1.add(txtFld);
        panel1.add(txtFld1);
        JPanel panelBut=createPanelObj(1,6);
        actionClass gameCls=new actionClass(log,this.obj,panelBut);
        JButton but0=new JButton("Start");
        JButton but1=new JButton("Hit");
        JButton but2=new JButton("Stand");
        JButton but3=new JButton("Split");
        JButton but4=new JButton("Double");
        JButton but5=new JButton("Quit");
        JButton but6=new JButton("Reset");
        but0.addActionListener(gameCls);
        but1.addActionListener(gameCls);
        but2.addActionListener(gameCls);
        but3.addActionListener(gameCls);
        but4.addActionListener(gameCls);
        but5.addActionListener(gameCls);
        but6.addActionListener(gameCls);
        gameCls.retPanel().add(but0);
        gameCls.retPanel().add(but1);
        gameCls.retPanel().add(but2);
        gameCls.retPanel().add(but3);
        gameCls.retPanel().add(but4);
        gameCls.retPanel().add(but5);
        gameCls.retPanel().add(but6);
        //actCls.setButValue(panel, 2, false);
        container.setLayout(layout);
        container.add(panel,BorderLayout.NORTH);
        container.add(panel1,BorderLayout.CENTER);
        container.add(panelBut, BorderLayout.SOUTH);
    }
}
