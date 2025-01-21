package jp.ac.uryukyu.ie.e245741;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 7並べ実装において、カードを準備して２人のプレイヤーに配る役割のクラス。
 * トランプを準備して、シャッフルし、プレイヤーに配る。
 */

public class Deck {
    private List<Card> cards;

    /**
     * コンストラクタ。カードを準備する（初期化）。
     */
    public Deck() {
        cards = new ArrayList<>();
        initialize(); 
    }

    /**
     * カードの初期化用メソッド。
     * ４種のスートについてそれぞれ１３枚のカードを用意する。
     */
    public void initialize() {
        String[] suits = {"Spades", "Diamonds", "Hearts", "Clubs"};
        for (String suit : suits) {
            for (int i = 1; i <= 13; i++) {
                cards.add(new Card(suit, i));
            }
        }
    }

    /**
     * カードの順番をシャッフルする。
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }
    /**
     * カード束の1番上から引数の枚数分のカードをListに保存して返す。
     * プレイヤーはこのメソッドから手札に加えるカードの情報を受け取って、Player.javaにあるrecieveCards()により手札に加える。
     * 
     * @param numberOfCards　配りたいカードの枚数
     * @return hand カードのリスト
     */
    
    public List<Card> dealCards(int numberOfCards) {
        List<Card> hand = new ArrayList<>(cards.subList(0, numberOfCards));
        cards.subList(0, numberOfCards).clear();
        return hand;
    }
    
    /**
     * cardsのゲッター。
     * @return　cards
     */

    public List<Card> getCards() {
        return cards;
    }
}
