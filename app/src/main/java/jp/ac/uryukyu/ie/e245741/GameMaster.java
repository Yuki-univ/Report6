package jp.ac.uryukyu.ie.e245741;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ゲームの流れを管理するためのクラス。ゲームが動くためのロジックも担っている。
 */

public class GameMaster {
    private Player firstPlayer;
    private Scanner scanner = new Scanner(System.in);

    /**
     * コンストラクタ。特に実装することはないがjavadocの生成でエラーとなるので記述した
     */
    public GameMaster(){

    }

    /**
     * 先手を決める
     * @param player　プレイヤー
     * @param suit　先手を決めるためのカードのスート
     * @param number　先手を決めるためのカードの番号
     */
    public void decideFirstPlayer(Player player, String suit, int number){
        for (Card card : player.getHand()) {
            if (card.getSuit().equals(suit) && card.getNumber() == number) {
                this.firstPlayer = player;
                System.out.println("先手は" + player.getName() + "です");
                break;
            }
        }
    }

    /**
     * firstPlayerのゲッター
     * @return firstPlayer
     */
    public Player getFirstPlayer(){
        return firstPlayer;
    }

    /**
     * プレイヤーが持っている番号7のカードを全て場に出させる
     * @param players　ゲームのプレイヤー
     * @param table　テーブルの情報
     */
    public void placeAllSevens(List<Player> players, Table table){
        for (Player player : players) {
            
            List<Card> cards_ = new ArrayList<>(player.getHand()); 
            for (Card card : cards_) {
                if (card.getNumber() == 7) { // 数字が7のカードをチェック
                    player.playCard(card.getSuit(), card.getNumber(), table);         
                }
            }
        }
    }

    /**
     * ゲームの勝者を判定する
     * @param player　プレイヤー
     */
    public void isGameOver(Player player){
        boolean x = player.hasNoCards();
        if(x == true){
            System.out.println("勝者は"+ player.getName() + "です。");
            System.exit(0);
        }else{}
    }
     
    /**
     * プレイヤーに場に出せるカードを選んでもらい、出すためのメソッド
     * プレイヤーの出せるカードを出力して、プレイヤーの出したいカードの入力を受け取り場に出す
     * 
     * @param player　プレイヤー
     * @param table　テーブルの情報
     */
    public void playTurn(Player player, Table table) {
        // 出せるカードを取得
        List<Card> playableCards = player.canPlay(table);

        if (playableCards.isEmpty()) {
            System.out.println(player.getName() + " は出せるカードがありません");
            return;
        }

        // 出せるカードを表示
        System.out.println(player.getName() + "は以下のカードを出せます:");
        for (int i = 0; i < playableCards.size(); i++) {
            System.out.println((i + 1) + ": " + playableCards.get(i));
        }

        // ユーザーが選択するまで繰り返す
        Card selectedCard = null;
        while (selectedCard == null) {
            System.out.print("出すカードを選んでください (1-" + playableCards.size() + "): ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= playableCards.size()) {
                    selectedCard = playableCards.get(choice - 1);
                } else {
                    System.out.println("無効な番号です。有効なものを選んでください");
                }
            } catch (NumberFormatException e) {
                System.out.println("無効です。もう１度選んでください");
            }
        }

        // 選択されたカードを場に出し、手札から削除
        player.playCard(selectedCard.getSuit(), selectedCard.getNumber(),table);
      
    }
}

