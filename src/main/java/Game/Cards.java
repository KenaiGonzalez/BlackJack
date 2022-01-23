/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

/**
 *
 * @author kenai
 */
public enum Cards implements Card{
    card2(2),card3(3),card4(4),card5(5),card6(6),card7(7),card8(8),card9(9)
    ,card10(10),J(10),Q(10),K(10),A(1,11);
    
    private final int value;
    private int secondValue = 0;
    
    private Cards(int value){ this.value=value;}
    @Override
    public int getValue() {
        return value;
    }
    
    public int getSecondValue(){
        return secondValue;
    }
    
    private Cards(int value,int secondValue){
        this.value = value;
        this.secondValue = secondValue;
    }
    
}
