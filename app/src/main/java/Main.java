import java.util.Arrays;
import java.util.List;

import jp.ac.uryukyu.ie.e245741.*;

public class Main {

    public static void main(String[] args) {
        // デッキを作成してシャッフル
        Deck deck = new Deck();
        deck.shuffle();

        // プレイヤーを作成
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        List<Player> players = Arrays.asList(player1, player2);

        // カードを配布
        while (deck.getCards().size() > 0) {
            player1.receiveCards(deck.dealCards(1));
            if (deck.getCards().size() > 0) {
                player2.receiveCards(deck.dealCards(1));
            }
        }

        // テーブルを初期化
        Table table = new Table();

        // 最初のプレイヤーを決定してゲーム開始
        GameMaster gameMaster = new GameMaster();
        gameMaster.decideFirstPlayer(player1,"Spades", 7 );
        gameMaster.decideFirstPlayer(player2,"Spades", 7);

        gameMaster.placeAllSevens(players, table);
        
        gameMaster.playTurn(player2, table);
        table.displayTable();
        

    }
}

    

