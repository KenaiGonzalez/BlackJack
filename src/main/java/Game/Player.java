package Game;

public class Player implements Participant{
    private final Card[] hand;
    private final String name;
    public Player(Card[] hand,String name) {
        this.hand = hand;
        this.name = name;
    }
    
    @Override
    public Card[] getHand(){
        return hand;
    }

    public String getName() {
        return name;
    }
    
    
}
