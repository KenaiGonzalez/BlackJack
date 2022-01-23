package Game;

import java.util.ArrayList;
import java.util.List;

public class BlackJack {
    
    public static Object[] getWinners(Player player1,Player player2,Player player3,Croupier croupier,Card[] deck){
        croupier.completeCroupierHand(deck);
        if(hasBlackJack(croupier.getHand())) return new Player[0];
        List<Player> winners = new ArrayList<>();
        int sumCroupier = getSum(croupier.getHand());
        if(playerWin(player1.getHand(),sumCroupier))winners.add(player1);
        if(playerWin(player2.getHand(),sumCroupier))winners.add(player2);
        if(playerWin(player3.getHand(),sumCroupier))winners.add(player3);
        return winners.toArray();
        
    }
    private static boolean playerWin(Card[] player, int croupier){
        if(hasBlackJack(player))return true;
        if(getSum(player) > 21) return false;
        return croupier < getSum(player);
    }
    public static int getSum(Card[] hand){
        int sum = 0;
        int numAces = 0;
        for (Card card : hand) {
            if(card.equals(Cards.A)){
                numAces++;
                continue;
            }
            sum=sum+card.getValue();
        }
        
        while(numAces != 0){
            if(sum<11){
                sum=sum+Cards.A.getSecondValue();
            }else sum=sum+Cards.A.getValue();
            numAces--;
        }
        return sum;
    }
    
    public static boolean hasBlackJack(Card[] hand){
        return getSum(hand) == 21 && hand.length == 2;
    }
    
   
}
