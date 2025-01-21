import java.util.Arrays;
import java.util.List;

import jp.ac.uryukyu.ie.e245741.*;
/**
 * ゲームを始めるためのクラス
 */
public class Main {
    /**
     * コンストラクタ。実装する中身はないがjavadocの生成でエラーとなるので記述した
     */
    public Main(){

    }
    /**
     * javadocの生成でエラーとなるのでドキュメントを記述している
     * @param args　引数
     */
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
        int firstPlayerIndex = players.indexOf(gameMaster.getFirstPlayer());

        gameMaster.placeAllSevens(players, table);

        int currentPlayerIndex = firstPlayerIndex;  // 最初のプレイヤーのインデックスを取得する
        while (true) {
            Player currentPlayer = players.get(currentPlayerIndex);
            System.out.println(currentPlayer.getName() + " のターンです");

            // プレイヤーのターンを実行
            table.displayTable();
            gameMaster.playTurn(currentPlayer, table);
            

            // ゲーム終了チェック
            gameMaster.isGameOver(currentPlayer);

            // 次のプレイヤーに切り替え
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();  // プレイヤーを交代

            System.out.println(System.lineSeparator());
        }
    }
}

    

