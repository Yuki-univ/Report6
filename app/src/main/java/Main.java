import jp.ac.uryukyu.ie.e245741.*;

public class Main {

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
}

    

