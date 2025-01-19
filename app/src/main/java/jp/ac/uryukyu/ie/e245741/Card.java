package jp.ac.uryukyu.ie.e245741;

class Card implements Comparable<Card> {
    private String suit; // スート（スペード、ダイヤ、ハート、クローバー）
    private int number;  // 数字

    //コンストラクタ
    public Card(String suit, int number) {
        this.suit = suit;
        this.number = number;
    }
    //suitのゲッター
    public String getSuit() {
        return suit;
    }
    //numberのゲッター
    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return suit + " " + number;
    }

    //数字を比べる
    @Override
    public int compareTo(Card other) {
        // 数字の昇順で比較
        return Integer.compare(this.number, other.number);
    }
}