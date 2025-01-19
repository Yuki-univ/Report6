package jp.ac.uryukyu.ie.e245741;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Deck {
    private List<Card> cards;

    //コンストラクタ
    public Deck() {
        cards = new ArrayList<>();
        initialize(); // カードを初期化
    }

    //トランプを準備する
    public void initialize() {
        String[] suits = {"Spades", "Diamonds", "Hearts", "Clubs"};
        for (String suit : suits) {
            for (int i = 1; i <= 13; i++) {
                cards.add(new Card(suit, i));
            }
        }
    }
    //トランプをシャッフルする
    public void shuffle() {
        Collections.shuffle(cards);
    }
    //カードを配るロジックに必要
    public List<Card> dealCards(int numberOfCards) {
        List<Card> hand = new ArrayList<>(cards.subList(0, numberOfCards));
        cards.subList(0, numberOfCards).clear();
        return hand;
    }
    //cardsのゲッター
    public List<Card> getCards() {
        return cards;
    }
}
