package jp.ac.uryukyu.ie.e245741;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;

class DeckTest {
    @Test
    void testInitialize() {
        Deck deck = new Deck();
        assertEquals(52, deck.getCards().size());
    }

    @Test
    void testShuffle() {
        Deck deck = new Deck();
        List<Card> beforeShuffle = new ArrayList<>(deck.getCards());
        deck.shuffle();
        assertNotEquals(beforeShuffle, deck.getCards());
    }
}