package jp.ac.uryukyu.ie.e245741;
import java.util.ArrayList;
import java.util.List;

class Player {
    private String name;
    private List<Card> hand;

    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
    }

    public void receiveCards(List<Card> cards) {
        hand.addAll(cards);
    }

    public List<Card> getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + "'s hand: " + hand;
    }
}
