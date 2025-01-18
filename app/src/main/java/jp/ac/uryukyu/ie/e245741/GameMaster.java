package jp.ac.uryukyu.ie.e245741;

public class GameMaster {
    public static void main(String[] args) {
        // デッキを作成してシャッフル
        Deck deck = new Deck();
        deck.shuffle();

        // プレイヤーを作成
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        // 各プレイヤーにカードを交互に配る
        while (deck.getCards().size() > 0) {
            player1.receiveCards(deck.dealCards(1));
            if (deck.getCards().size() > 0) {
                player2.receiveCards(deck.dealCards(1));
            }
        }

        // 各プレイヤーの手札を表示
        System.out.println(player1.getHand());
        System.out.println(player2.getHand());
    }
}
