package jp.ac.uryukyu.ie.e245741;

/**
 * １枚のカードを管理するためのクラス。
 */

public class Card implements Comparable<Card> {
    private String suit; // スート（スペード、ダイヤ、ハート、クローバー）
    private int number;  // 数字

    /**
     * コンストラクタ。カードのスートと番号を受け取ってフィールドに保存する。
     * 
     * @param suit　カードの種類
     * @param number　カードの番号
     */
    public Card(String suit, int number) {
        this.suit = suit;
        this.number = number;
    }

    /**
     * suitのゲッター
     * @return suit
     */
    public String getSuit() {
        return suit;
    }
    
    /**
     * numberのゲッター
     * @return number
     */
    public int getNumber() {
        return number;
    }
    /**
     * カードのスートと番号をまとめて返す
     */
    @Override
    public String toString() {
        return suit + " " + number;
    }

    /**
     * カードの番号と引数として受け取ったカードの番号を比べる。
     * @param other　比べたいカード
     * @return -1:this.number が other.number より小さい場合。
     *          0:this.number と other.number が等しい場合。
     *          1:this.number が other.number より大きい場合。         
     */
    @Override
    public int compareTo(Card other) {
        // 数字の昇順で比較
        return Integer.compare(this.number, other.number);
    }
}