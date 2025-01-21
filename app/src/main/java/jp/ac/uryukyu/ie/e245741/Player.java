package jp.ac.uryukyu.ie.e245741;
import java.util.ArrayList;
import java.util.List;

/**
 * プレイヤーの情報を保持したり、プレイヤーの手札から出せるカードを判断したり、場に出すためのクラス
 */
public class Player {
    private String name;
    private List<Card> hand;

    /**
     * コンストラクタ。名前を代入して、ArrayListを準備する。
     * @param name　プレイヤーの名前
     */
    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
    }

    /**
     * カードを手札に加えるためのメソッド。
     * @param cards　手札に加えたいカード
     */
    public void receiveCards(List<Card> cards) {
        hand.addAll(cards);
    }
    
    /**
     * handのゲッター
     * @return hand
     */
    public List<Card> getHand() {
        return hand;
    }
    
    /**
     * nameのゲッター
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 手札が空かどうかを判定する
     * @return true：手札が空のとき
     *         false：手札が空でないとき
     */
    public boolean hasNoCards() {
        return hand.isEmpty();
    }
    
    /**
     * 場に出てるカードとプレイヤーの手札を比べて、場に出せる手札を返す。
     * @param table　テーブルに出ているカードの情報
     * @return　placeableCards　場に出せるカードのリスト
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
     * プレイヤーの手札を見やすい書式で返す
     */
    @Override
    public String toString() {
        return name + "'s hand: " + hand;
    }

    /**
     * 場にカードを出すためのメソッド。
     * 引数として受け取ったカードをプレイヤーが持っていれば、手札から削除し、Tableに追加する。
     * @param suit　カードのスート
     * @param number　カードの番号
     * @param table　　テーブルの情報
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
