package jp.ac.uryukyu.ie.e245741;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> hand;

    //コンストラクタ
    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
    }
    //カードを受け取る
    public void receiveCards(List<Card> cards) {
        hand.addAll(cards);
    }
    //handのゲッター
    public List<Card> getHand() {
        return hand;
    }
    //nameのゲッター
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + "'s hand: " + hand;
    }
    
    /**
     * 場に出てるカードとプレイヤーの手札を比べて、場に出せる手札を返す。
     * @param table
     * @return　List<Card> placeableCards
     */
    public List<Card> canPlay(Table table) {
        List<Card> placeableCards = new ArrayList<>();
    
        // 場に出ている全てのカードを取得
        for (String suit : table.getTable().keySet()) {
            List<Card> tableCards = table.getCardsBySuit(suit);
    
            for (Card tableCard : tableCards) {
                for (Card handCard : hand) {
                    // 場のカードと手札のカードを比較
                    if (handCard.getSuit().equals(tableCard.getSuit()) && 
                       (handCard.getNumber() == tableCard.getNumber() - 1 || 
                        handCard.getNumber() == tableCard.getNumber() + 1)) {
                        // 条件に合うカードを追加
                        if (!placeableCards.contains(handCard)) { // 重複を防ぐ
                            placeableCards.add(handCard);
                        }
                    }
                }
            }
        }
    
        return placeableCards;
    }

    /**
     * 場にカードを出すためのメソッド。
     * 引数として受け取ったカードをプレイヤーが持っていれば、手札から削除し、Tableに追加する。
     * @param suit
     * @param number
     * @param table
     */
    public void playCard(String suit, int number, Table table) {
        // プレイヤーの手札から引数のカードを探す
        Card cardToPlay = null;
        for (Card card : hand) {
            if (card.getSuit().equals(suit) && card.getNumber() == number) {
                cardToPlay = card;
                break;
            }
        }
    
        if (cardToPlay != null) {
            // 手札から削除
            hand.remove(cardToPlay);
    
            // Table にカードを置く
            table.placeCard(suit, number);
    
            System.out.println(name + " は " + cardToPlay + "を出しました");
        } else {
            System.out.println(name + " は該当するカードを持っていません： " + suit + " " + number);
        }
    }
    
    
}
