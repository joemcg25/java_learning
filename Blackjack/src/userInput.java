
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joe
 */
public class userInput {
    private final Scanner reader;
    
    public userInput(){
        this.reader=new Scanner(System.in);
    }
    
    public String returnString(String inpt){
        System.out.println(inpt);
        String res=reader.nextLine();
        return res;
    }
    public int returnInt(String inpt){
        System.out.println(inpt);
        int res=Integer.parseInt(reader.nextLine());
        return res;
    }
    
}
