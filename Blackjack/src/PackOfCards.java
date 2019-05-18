
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joe
 */
public class PackOfCards {
    private ArrayList<String> drawnCards;
    //private HashMap<String,ArrayList<String>> cards;
    private final ArrayList<String> cards;
    private ArrayList<String> cardsLeft;
    private final String[] crdTypes;
    private final String[] faceCrds;
    private final String[] numCrds;
    public PackOfCards(){
        //System.out.println("Called");
        this.crdTypes=new String[]{"hrts","clbs","spds","dmds"};
        this.faceCrds=new String[]{"Jack","Queen","King","Ace"};
        this.numCrds=new String[]{"2","3","4","5","6","7","8","9","10"};
        this.cards=this.genCards();
        this.cardsLeft=this.genCards();
        //System.out.println("Size of deck is: "+cards.size());
        this.drawnCards=new ArrayList<>();
    }
    private ArrayList<String> genCards(){
        ArrayList<String> res=new ArrayList<>();
        
        
        for(String i:crdTypes){
            for(int j=2;j<11;j++){
                String num=String.valueOf(j);
                res.add(join(num,i,"_"));
            }
            for(String x:faceCrds){
                res.add(join(x,i,"_"));
            }
        }
        //Best to store as a dict(HASH MAP)
        return res;
    }
    public ArrayList<String> cards(){
        return cards;
    }
    public ArrayList<String> drawnCards(){
        return drawnCards;
    }
    public ArrayList<String> cardsLeft(){
        return cardsLeft;
    }
    public String[] faceCrds(){
        return faceCrds;
    }
    public String[] numCards(){
        return numCrds;
    }
    public void printCards(ArrayList<String> cards){
        String res="";
        for(String i:crdTypes){
            System.out.println(i);
            for(String j:cards){
                if(j.contains(i)){
                    res=join(res,j,", ");
                }
            }
            System.out.println(res);
            res="";
        }
    }
    public String drawCard(){
        Random random=new Random();
        int indx=random.nextInt(cardsLeft.size());
        String res=cardsLeft.get(indx);
        cardsLeft.remove(res);
        drawnCards.add(res);
        return res;
    }
    public String[] drawCard(int numCrds){
        String[] list=new String[numCrds];
        for(int i=0;i<numCrds;i++){
            String res=drawCard();
            list[i]=res;
        }
        return list;
    }
    public void replaceCards(){
        
    }
    public void reset(boolean withShuffle){
        cardsLeft=this.genCards();
        drawnCards=new ArrayList<>();
        if(withShuffle){
            shuffleDeck();
        }
    }
    public void shuffleDeck(){
        Random random=new Random();
        ArrayList<Integer> rndmNums=rndmList(cardsLeft().size());
        ArrayList<String> newDeck=new ArrayList<>();
        int j=0;
        for(int i:rndmNums){
            newDeck.add(j, cardsLeft.get(i));
            j++;
        }
        cardsLeft=newDeck;
    }
    public ArrayList<Integer> rndmList(int numItms){
        ArrayList<Integer> list=new ArrayList<>();
        Random random=new Random();
            int res;
            while(list.size()<numItms){
                res=random.nextInt(numItms);
                if(!list.contains(res)){
                    list.add(res);
                }
            }
        return list;
    }
    private String join(String item1,String item2,String sep){
        return item1+sep+item2;
    }
}
