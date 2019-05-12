
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
public class RandomGen {
    private final Random random;
    public RandomGen(){
        this.random= new Random();
    }
    public int randomInt(){
        return random.nextInt(1000);
    }
    public int randomInt(int upBnd){
        return random.nextInt(upBnd);
    }
    
    public double randomDouble(){
        return random.nextDouble();
    }
}
