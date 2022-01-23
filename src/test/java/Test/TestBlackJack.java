package Test;

import Game.BlackJack;
import Game.Card;
import Game.Cards;
import Game.Croupier;
import Game.Player;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestBlackJack {
    Card[] hand1 = {Cards.J,Cards.A};// BlackJack
    Card[] hand2 = {Cards.card10,Cards.card5,Cards.card6};// 21
    Card[] hand3 = {Cards.card3,Cards.card6,Cards.A,Cards.card3,Cards.A,Cards.K};// 24
    Card[] hand4 = {Cards.card10,Cards.K};// 20
    Card[] hand5 = {Cards.card10,Cards.card2,Cards.card6};// 18
    Card[] hand6 = {Cards.card10,Cards.card6,Cards.card4};// 26
    
    Card[] deck1 = {Cards.card5,Cards.card4,Cards.K,Cards.card2};
    Card[] deck2 = {Cards.A,Cards.card3,Cards.K,Cards.card2};
    Card[] deck3 = {Cards.card10,Cards.card3,Cards.K,Cards.card2};
    
    Card[] croupierHand1 = {Cards.card9,Cards.card7};// 16
    Card[] croupierHand2 = {Cards.card5,Cards.card10};// 15
    Card[] croupierHand3 = {Cards.A,Cards.card10}; // BlackJack
    
    @Test
    public void check_that_the_hand_does_not_exceed_21(){
        assertTrue(BlackJack.getSum(hand1)<=21);
        assertTrue(BlackJack.getSum(hand2)<=21);
        assertFalse(BlackJack.getSum(hand3)<=21);
    }
    
    @Test
    public void check_that_the_hand_sum_is_21(){
        assertTrue(BlackJack.getSum(hand1)==21);
        assertTrue(BlackJack.getSum(hand2)==21);
        assertFalse(BlackJack.getSum(hand3)==21);
    }
    
    @Test
    public void check_have_BlackJack(){
        assertTrue(BlackJack.hasBlackJack(hand1));
        assertFalse(BlackJack.hasBlackJack(hand2));
        assertFalse(BlackJack.hasBlackJack(hand3));
    }
    
    @Test
    public void check_the_final_croupier_hand(){
        Croupier aux = new Croupier(croupierHand1);
        aux.completeCroupierHand(deck1);
        assertTrue(BlackJack.getSum(aux.getHand()) == 21);
        
        aux = new Croupier(croupierHand1);
        aux.completeCroupierHand(deck2);
        assertTrue(BlackJack.getSum(aux.getHand()) == 17);
        
        aux = new Croupier(croupierHand2);
        aux.completeCroupierHand(deck1);
        assertTrue(BlackJack.getSum(aux.getHand()) == 20);
        
        aux = new Croupier(croupierHand2);
        aux.completeCroupierHand(deck2);
        assertTrue(BlackJack.getSum(aux.getHand()) == 19);
    }
    
    @Test
    public void check_winner_seleccion_all_players_win(){
        Player player1 = new Player(hand1,"");
        Player player2 = new Player(hand1,"");
        Player player3 = new Player(hand1,"");
        Object[] result = {player1,player2,player3};
        assertArrayEquals(result ,BlackJack.getWinners(player1,player2 ,
                player3, new Croupier(croupierHand2), deck1));
    }
    
    @Test
    public void check_winner_seleccion_all_players_lose_for_overdo(){
        Player player1 = new Player(hand3,"");
        Player player2 = new Player(hand3,"");
        Player player3 = new Player(hand3,"");
        Object[] result = {};
        assertArrayEquals(result ,BlackJack.getWinners(player1,player2 ,
                player3, new Croupier(croupierHand2), deck1));
    }
    
    @Test
    public void check_winner_seleccion_all_have_BlackJack(){
        Player player1 = new Player(hand1,"");
        Player player2 = new Player(hand1,"");
        Player player3 = new Player(hand1,"");
        Object[] result = {};
        assertArrayEquals(result ,BlackJack.getWinners(player1,player2 ,
                player3, new Croupier(croupierHand3), deck1));
    }
    
    
}
   
    