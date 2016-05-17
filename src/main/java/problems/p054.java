package problems;

import lib.FileReader;
import main.Problem;
import main.annotations.Solved;

import java.util.Arrays;

@Solved
public class p054 extends Problem {

    Hand[] p1;

    Hand[] p2;

    public static void main(String[] args) {
        Problem p = new p054();
        p.run();
        System.out.println(p.answer());
    }

    public void run() {
        read();
        int p1Wins = 0;
        for(int i = 0; i < p1.length; i++) {
            int score = p1[i].compareTo(p2[i]);
            if(score == 1) {
                // System.out.println(p1[i] + " > " + p2[i]);
                p1Wins++;
            }
        }
        this.answer = p1Wins;
    }

    /**
     * 1 High Card:
     * 2 One Pair:
     * 3 Two Pairs:
     * 4 Three of a Kind:
     * 5 Straight:
     * 6 Flush:
     * 7 Full House:
     * 8 Four of a Kind:
     * 9 Straight Flush:
     * 10 Royal Flush:
     */
    private int score(Hand h) {
        if(isRoyalFlush(h)) {
            return 10;
        }
        if(isStraightFlush(h)) {
            return 9;
        }
        if(is4ofaKind(h)) {
            return 8;
        }
        if(isFullHouse(h)) {
            return 7;
        }
        if(isFlush(h)) {
            return 6;
        }
        if(isStraight(h)) {
            return 5;
        }
        if(is3ofaKind(h)) {
            return 4;
        }
        if(is2Pair(h)) {
            return 3;
        }
        if(is2ofaKind(h)) {
            return 2;
        }
        setHighCard(h);
        return 1;
    }


    private void setHighCard(Hand h) {
        for(Card c : h.cards) {
            if(c.face > h.highCard) {
                h.highCard = c.face;
            }
        }
    }

    private boolean isRoyalFlush(Hand h) {
        return isFlush(h) && (h.cards[0].face == 10
                && h.cards[1].face == 11
                && h.cards[2].face == 12
                && h.cards[3].face == 13
                && h.cards[4].face == 14);
    }

    private boolean isFullHouse(Hand h) {
        int[][] faceNumbers = new int[15][1];
        for(Card c : h.cards) {
            faceNumbers[c.face][0]++;
        }
        boolean three = false;
        boolean pair = false;
        for(int i = 0; i < 15; i++) {
            if(faceNumbers[i][0] == 3) {
                three = true;
                h.highCard = i;
            } else if(faceNumbers[i][0] == 2) {
                pair = true;
            }
        }
        return pair & three;
    }

    private boolean isStraightFlush(Hand h) {
        return isStraight(h) && isFlush(h);
    }

    private boolean isFlush(Hand h) {
        Character suit = null;
        for(Card c : h.cards) {
            if(suit == null) {
                suit = c.suit;
            } else {
                if(suit != c.suit) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean is2ofaKind(Hand h) {
        return isNofaKind(h, 2);
    }

    private boolean is3ofaKind(Hand h) {
        return isNofaKind(h, 3);
    }

    private boolean is4ofaKind(Hand h) {
        return isNofaKind(h, 4);
    }

    private boolean isNofaKind(Hand h, int n) {
        int[][] faceNumbers = new int[15][1];
        for(Card c : h.cards) {
            faceNumbers[c.face][0]++;
        }
        for(int i = 0; i < 15; i++) {
            if(faceNumbers[i][0] == n) {
                h.highCard = i;
                return true;
            }
        }
        return false;
    }

    private boolean is2Pair(Hand h) {
        int[][] faceNumbers = new int[15][1];
        for(Card c : h.cards) {
            faceNumbers[c.face][0]++;
        }
        int numPairs = 0;
        for(int i = 0; i < 15; i++) {
            if(faceNumbers[i][0] == 2) {
                numPairs++;
                if(i > h.highCard) {
                    h.highCard = i;
                }
            }
        }
        return numPairs == 2;
    }

    private boolean isStraight(Hand h) {
        boolean isStraight = (h.cards[0].face == h.cards[1].face - 1
                && h.cards[1].face == h.cards[2].face - 1
                && h.cards[2].face == h.cards[3].face - 1
                && h.cards[3].face == h.cards[4].face - 1);
        if(isStraight) {
            h.highCard = h.cards[4].face;
        }
        return isStraight;
    }

    private void read() {
        FileReader reader = new FileReader("problems/_054/poker.txt");
        String contents = reader.getContent();
        String[] hands = contents.split("\n");
        p1 = new Hand[hands.length];
        p2 = new Hand[hands.length];
        for(int i = 0; i < hands.length; i++) {
            String[] cards = hands[i].split(" ");

            p1[i] = new Hand();
            p2[i] = new Hand();

            for(int j = 0; j < 5; j++) {
                p1[i].cards[j] = new Card(cards[j]);
            }
            for(int j = 5; j < 10; j++) {
                p2[i].cards[j - 5] = new Card(cards[j]);
            }
            Arrays.sort(p1[i].cards);
            Arrays.sort(p2[i].cards);
        }
    }

    private class Hand implements Comparable<Hand> {

        Card[] cards = new Card[5];

        int highCard = 0;

        public String toString() {
            StringBuffer sb = new StringBuffer();
            for(Card card : cards) {
                sb.append(card + " ");
            }
            if(highCard > 0) {
                sb.append("(" + highCard + " high)");
            }
            return sb.toString();
        }

        @Override
        public int compareTo(Hand h) {
            int score1 = score(this);
            int score2 = score(h);
            if(score1 == score2) {
                if(highCard < h.highCard) {
                    return -1;
                } else if(highCard > h.highCard) {
                    return 1;
                } else {
                    return 0;
                }
            }
            if(score1 < score2) {
                return -1;
            }
            return 1;
        }

    }

    private class Card implements Comparable<Card> {

        public Card(String value) {
            switch(value.charAt(0)) {
                case 'T':
                    face = 10;
                    break;
                case 'J':
                    face = 11;
                    break;
                case 'Q':
                    face = 12;
                    break;
                case 'K':
                    face = 13;
                    break;
                case 'A':
                    face = 14;
                    break;
                default:
                    face = Integer.parseInt(String.valueOf(value.charAt(0)));
                    break;
            }
            suit = value.charAt(1);
            this.value = value;
        }

        String value;

        int face;

        char suit;

        public String toString() {
            return value;
        }

        @Override
        public int compareTo(Card c) {
            if(face == c.face) {
                return 0;
            }
            if(face < c.face) {
                return -1;
            }
            return 1;
        }

    }

}
