package jp.ac.uryukyu.ie.e245741;

import java.util.List;

public class GameMaster {
    //以下はプレイヤーにカードを配る処理ができてるかを確認するためのコード
    /*public static void main(String[] args) {
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
    } */

    //以下はcanPlay()を試すためのコード
    /*public static void main(String[] args) {
    Deck deck = new Deck();
    deck.shuffle();

    // 場の準備
    Table table = new Table();
    table.placeCard("Spades", 7);
    table.placeCard("Hearts", 5);

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
    // プレイヤーが出せるカードを確認
    List<Card> placeableCards = player1.canPlay(table);

    // 出せるカードを表示
    System.out.println("Placeable cards: " + placeableCards);
}*/

/*以下はplayCardを試すためのコード
public static void main(String[] args) {
    Deck deck = new Deck();
        deck.shuffle();
        Table table = new Table();

        // プレイヤーを作成し、カードを配る
        Player player = new Player("Alice");
        player.receiveCards(deck.dealCards(52));

        // 現在の手札を表示
        //System.out.println(player);

        // カードを場に出す
        player.playCard("Spades", 7, table);

        // 現在の場の状態と手札を表示
        System.out.println("Table: " + table.getCardsBySuit("Spades"));
        //System.out.println(player);
}
}*/
}

