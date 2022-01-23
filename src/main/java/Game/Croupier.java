package Game;

public class Croupier implements Participant{
    private Card[] hand;
    

    public Croupier(Card[] hand) {
        this.hand = hand;
    }
    
    @Override
    public Card[] getHand() {
        return hand;
    }

    private void addCard(Card card){
        Card[] newHand = new Card[hand.length + 1];
        System.arraycopy(hand, 0, newHand, 0, hand.length);
        newHand[newHand.length-1] = card;
        hand = newHand;
    }
    
    public void completeCroupierHand(Card[] deck){
        int i = 0;
        
        while(BlackJack.getSum(this.getHand()) < 17 && i < deck.length){
            this.addCard(deck[i]);
            i++;
        }
    }
}
