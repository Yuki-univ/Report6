package jp.ac.uryukyu.ie.e245741;
import java.util.*;

/**
 * プレイヤーがカードを出す場を管理するためのクラス
 */

public class Table {
    Map<String, List<Card>> table;
    
    /**
     * コンストラクタ。
     * 場の状態を保存するためのフィールドであるtableを初期化する
     */
    public Table() {
        this.table = new HashMap<>(); 
    }
    
    /**
     * カードを場に加えるためのメソッド。
     * 引数で受け取ったカードをtableフィールドに追加し、数字順にソートする。
     * @param suit　カードのスート
     * @param number　カードの番号
     */
    public void placeCard(String suit, int number) {
        // スートに対応するカードリストを取得、なければ新しいリストを作成
        List<Card> cards = table.get(suit);
        if (cards == null) {
            cards = new ArrayList<>();
            table.put(suit, cards); // 初めてのスートの場合、table に登録
        }

        Card newCard = new Card(suit, number);
        cards.add(newCard); // 新しいカードを追加
        cards.sort(Comparator.comparingInt(Card::getNumber)); // 数字順にソート
    }

    /**
     * tableのゲッター
     * @return table
     */
    public Map<String, List<Card>> getTable() {
        return table; // 現在の場のカード状態を返す
    }

    /**
     * 引数として受け取ったスートの、カード一覧（List）を返すメソッド
     * @param suit　カードのスート
     * @return　カードのリスト
     */
    public List<Card> getCardsBySuit(String suit) {
        return table.getOrDefault(suit, new ArrayList<>()); 
    }

    /**
     * テーブルに出されているカードをスートごとに並べて表示する
     */
    public void displayTable() {
        System.out.println("-----------------------------");
        System.out.println("テーブルに出されているカード:");
        for (String suit : table.keySet()) {
            System.out.print(suit + ": ");
            List<Card> cards = table.get(suit);
            for (Card card : cards) {
                System.out.print(card.getNumber() + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------------------");
    }
    
}
