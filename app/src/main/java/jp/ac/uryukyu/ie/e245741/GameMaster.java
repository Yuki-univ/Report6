package jp.ac.uryukyu.ie.e245741;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameMaster {
    private String firstPlayer;
    private Scanner scanner = new Scanner(System.in);

    public void decideFirstPlayer(Player player, String suit, int number){
        for (Card card : player.getHand()) {
            if (card.getSuit().equals(suit) && card.getNumber() == number) {
                this.firstPlayer = player.getName();
                System.out.println("先手は" + player.getName() + "です");
                break;
            }
            
        }

    }

    // プレイヤーが持っている全ての7を場に出させる
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
     * プレイヤーに場に出せるカードを選んでもらい、出すためのメソッド
     * プレイヤーの出せるカードを出力して、プレイヤーの出したいカードの入力を受け取り場に出す
     * 
     * @param player
     * @param table
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
                System.out.println("無効です。もう一で選んでください");
            }
        }

        // 選択されたカードを場に出し、手札から削除
        player.playCard(selectedCard.getSuit(), selectedCard.getNumber(),table);
      
    }
}

