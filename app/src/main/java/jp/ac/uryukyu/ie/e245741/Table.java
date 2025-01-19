package jp.ac.uryukyu.ie.e245741;
import java.util.*;

public class Table {
    Map<String, List<Card>> table;
    //コンストラクタ
    public Table() {
        this.table = new HashMap<>(); // table を初期化
    }

    
    //カードを場の状況に加えるためのメソッド
    
    public void placeCard(String suit, int number) {
        // スートに対応するカードリストを取得、なければ新しいリストを作成
        List<Card> cards = table.get(suit);
        if (cards == null) {
            cards = new ArrayList<>();
            table.put(suit, cards); // 初めてのスートの場合、table に登録
        }

        // カードの重複をチェック
        Card newCard = new Card(suit, number);
        //if (cards.contains(newCard)) {      //カードを配るシステム上重複することがないと思うので一旦この部分は省略
            //System.out.println("Card already placed: " + suit + " " + number);
        //} else {
            cards.add(newCard); // 新しいカードを追加
            cards.sort(Comparator.comparingInt(Card::getNumber)); // 数字順にソート
        
    }

    //tableのゲッター
    public Map<String, List<Card>> getTable() {
        return table; // 現在の場のカード状態を返す
    }

    //特定スートのカードを返すメソッド
    public List<Card> getCardsBySuit(String suit) {
        return table.getOrDefault(suit, new ArrayList<>()); // スートのカードリストを返す
    }
    
}
