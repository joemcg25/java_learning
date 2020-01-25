/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joe
 */
public class Main {
    public static void main(String[] args){
        System.out.println("Blackjack game ");
        Blackjack blackjack=new Blackjack(true);
        blackjack.startGame(true);
        //BlackJackView item=new BlackJackView();
        //item.run();
    }
}
