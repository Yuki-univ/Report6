package jp.ac.uryukyu.ie.e245741;
import java.util.ArrayList;
import java.util.List;

class Player {
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
    //場に出せる手札を返す
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
                        if (!placeableCards.contains(handCard)) { // 重複防止
                            placeableCards.add(handCard);
                        }
                    }
                }
            }
        }
    
        return placeableCards;
    }
    
}
