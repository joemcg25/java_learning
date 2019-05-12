/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joe
 */
public class Blackjack {
    private PackOfCards cards;
    private final userInput dealer;
    private final RandomGen rndmLogic;
    private final boolean acesHigh;
    private final String[] usrCmds;
    private int usrScore;
    private int dlrScore;
    public Blackjack(boolean acesHigh){
      this.cards=new PackOfCards();
      this.dealer=new userInput();
      this.rndmLogic=new RandomGen();
      this.usrCmds=new String[]{"start","hit","stand","split","double","quit","reset"};
      this.usrScore=0;
      this.dlrScore=0;
      this.acesHigh=acesHigh;
      cards.shuffleDeck();
    }
    //"Jack","Queen","King","Ace"
    //This should be private and contained in a usrMove/dlrMove method
    public int scoreCard(String card){
        System.out.println("Cards Left = "+cards.cardsLeft().size());
        for(String i:cards.faceCrds()){
            if(card.contains(i)){
                return 10;
            }else{
                for(String j:cards.numCards()){
                    if(card.contains(j)){
                        return Integer.valueOf(j);
                    }
                }
            }
        }
        return 0;
    }
    public void makeMove(int noMoves,boolean isDealer){
        String[] res=cards.drawCard(noMoves);
        for(String i:res){
            int scre=scoreCard(i);
            trackScore(scre,isDealer);
            System.out.println("Card drawn was: "+i+", It's score is: "+scre);
            System.out.println("Current score is "+retScore(isDealer));
        }
    }
    public void reset(){
        System.out.println("Reseting game");
        cards.reset(true);
        usrScore=0;
        dlrScore=0;
    }
    public void trackScore(int score,boolean isDealer){
        if(isDealer){
            dlrScore=dlrScore+score;
        }else{
            usrScore=usrScore+score;
        }
    }    
    public int retScore(boolean isDealer){
        if(isDealer){
            return dlrScore;
        }else{
            return usrScore;
        }
    }    
    private void prntCmds(){
        System.out.println("The following user Commands are available");
        for(String i:usrCmds){
            System.out.println(i);
        }
    }
    public void startGame(){
        System.out.println("You are starting a game");
        prntCmds();
        while(true){
            String res=dealer.returnString("Please enter your command");
            if(res.equals("quit")){
                System.out.println("The game will now finish");
                break;
            }else if(res.equals("start")){
                reset();
                makeMove(2,false);
            }else if(res.equals("reset")){
                System.out.println("The game will now reset");
                reset();
            }else if(res.equals("hit")){
                System.out.println("You have selected hit on "+retScore(false));
                makeMove(1,false);
                System.out.println("Your score now is "+retScore(false));
                if(retScore(false)>21){
                    System.out.println("Bust!");
                    reset();
                }
            }else if(res.equals("stand")){
                System.out.println("You have selected to stand on "+retScore(false));
                makeMove(2,true);
                while(dlrLgc(retScore(true))){
                  makeMove(1,true);
                }
                System.out.println("Final Dealer score is "+retScore(true));
                if((retScore(true)>retScore(false))&&(retScore(true)<21)){
                    System.out.println("Dealer wins!!");
                    printScrs();
                }else if(retScore(true)==retScore(false)){
                    System.out.println("Tie game!!");
                    printScrs();                    
                }else {
                    System.out.println("You win!!");
                    printScrs();
                }
                reset();
            }else if(res.equals("split")){
                //add in split logic here
            }else if(res.equals("double")){
                //add in double logic here
            }else{
                System.out.println("Unknown Command: "+res);
                System.out.println("Known Commands are: ");
                prntCmds();
            }           
        }
    }
    public boolean dlrLgc(int crrScr){
        int rmToPlay=21-crrScr;
        if(rmToPlay<=1){
            return false;
        }
        int rndGen=rndmLogic.randomInt(109);
        System.out.println("rndVAr is:: " + rndGen);
        System.out.println("diff is: "+rmToPlay*10);
        if(rndGen>(rmToPlay*10)){
            return false;
        }else{
            return true;
        }
    }
    private void printScrs(){
        System.out.println("Dealer final score "+ retScore(true));
        System.out.println("Your final score "+ retScore(false));
    }
    //private 
    ///Option to have Ace be 11 or 1/11
    //Dealer interface - 

    
}
