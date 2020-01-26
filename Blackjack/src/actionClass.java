
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joe
 */
public class actionClass implements ActionListener{
    private Blackjack logic;
    private JFrame obj;
    private JPanel panelBut;
    public actionClass(Blackjack logic, JFrame obj,JPanel panelBut){
        this.logic=logic;
        this.obj=obj;
        this.panelBut=panelBut;
    }
    public JPanel retPanel(){
        return panelBut;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String userEntry=e.getActionCommand();
        System.out.println(userEntry);
        logic.game(userEntry);
        logic.retScore(false);
        logic.retScore(true);
        if(userEntry.toLowerCase().equals("quit")){
            obj.dispose();
        }
    }
}
