package jp.ac.uryukyu.ie.e245741;

class Card {
    private String suit; // スート（スペード、ダイヤ、ハート、クローバー）
    private int number;  // 数字

    public Card(String suit, int number) {
        this.suit = suit;
        this.number = number;
    }

    public String getSuit() {
        return suit;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return suit + " " + number;
    }
}