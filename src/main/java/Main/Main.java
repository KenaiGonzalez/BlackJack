package Main;

import Game.BlackJack;
import Game.Cards;
import Game.Croupier;
import Game.Player;

public class Main {
    
    public static void main(String[] args){
        Main.caso1();
        Main.caso2();
        
    }
    
    private static void caso1(){
        Cards[] hand = {Cards.J,Cards.A};
        Player player1 = new Player(hand,"player1");
        Cards[] hand1 = {Cards.card10,Cards.card5,Cards.card6};
        Player player2 = new Player(hand1,"player2");
        Cards[] hand2 = {Cards.card3,Cards.card6,
            Cards.A,Cards.card3,Cards.A,Cards.K};
        Player player3 = new Player(hand2,"player3");
        Cards[] croupierHand = {Cards.card9,Cards.card7};
        Croupier croupier = new Croupier(croupierHand);
        Cards[] deck = {Cards.card5,Cards.card4,Cards.K,Cards.card2};
        Main.printResult(BlackJack.getWinners(player1, player2, player3, croupier, deck),1);
    }
    
    private static void caso2(){
        Cards[] hand = {Cards.card10,Cards.K};
        Player player1 = new Player(hand,"player1");
        Cards[] hand1 = {Cards.card10,Cards.card2,Cards.card6};
        Player player2 = new Player(hand1,"player2");
        Cards[] hand2 = {Cards.card8,Cards.card8,Cards.card5};
        Player player3 = new Player(hand2,"player3");
        Cards[] croupierHand = {Cards.card5,Cards.card10};
        Croupier croupier = new Croupier(croupierHand);
        Cards[] deck = {Cards.A,Cards.card3,Cards.K,Cards.card2};
        Main.printResult(BlackJack.getWinners(player1, player2, player3, croupier, deck),2);
    }
    
    private static void printResult(Object[] result, int caso){
        System.out.print("El resultado del caso " + caso + " es [ ");
        String out = "";
        for (Object player : result){
            out= out +(((Player)player).getName()+ ", ");
        }
        out=out.substring(0, out.length()-2) + " ]";
        System.out.println(out);
    }
    
}
