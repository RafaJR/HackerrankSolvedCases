package hackerrank.cases.comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Checker implements Comparator<Player>{

    @Override
    public int compare(Player o1, Player o2) {
	return o1.score > o2.score ? -1 :
	    o1.score == o2.score ? o1.name.compareTo(o2.name)
	    : 1;
    }
    
}

class Player{
    String name;
    int score;
    
    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();
        
        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}

//b 3
//a 1
//bb 3
//b 8
//bba 0
//bb 2
//bca 6
//ccc 4
//b 3
//ab 8
//bb 3
//bb 7
//ccb 8
//bbb 2
//aab 8
//b 6
//ab 8
//cb 9
//cbb 8
//ba 9