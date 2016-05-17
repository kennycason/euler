package problems;

import lib.FileReader;
import main.Problem;
import main.annotations.Solved;

@Solved
public class p059 extends Problem {

    public static void main(String[] args) {
        Problem p = new p059();
        p.run();
        System.out.println(p.answer());
    }

    /**
     * brute force
     */
    public void run() {
        int[] codes = readCode();
        int[] decrypted;
        for(int k1 = 'a'; k1 <= 'z'; k1++) {
            for(int k2 = 'a'; k2 <= 'z'; k2++) {
                for(int k3 = 'a'; k3 <= 'z'; k3++) {

                    int[] key = new int[] {k1, k2, k3};
                    decrypted = encrypt(codes, key);
                    double ratio = isEnglishRatio(decrypted);
                    /* ideally match 100%, but to offset random characters
                     * that are valid, but not accounted for
                     */
                    if(ratio > 0.98) {
                        // System.out.print("KEY: " + (char)key[0] + (char)key[1] + (char)key[2] + ": (" + ratio + ")");
                        // print(decrypted);
                        this.answer = sum(decrypted);
                        return;
                    }
                }
            }
        }
    }

    private int sum(int[] codes) {
        int sum = 0;
        for(int i = 0; i < codes.length; i++) {
            sum += codes[i];
        }
        return sum;
    }

    /**
     * analyze the text, farily straight forward,
     * could always do frequency analysis, test for common letters/words/etc
     * but this problem is pretty simple so no need
     */
    private double isEnglishRatio(int[] codes) {
        int letters = 0;
        for(int i = 0; i < codes.length; i++) {
            if((codes[i] >= 'a' && codes[i] <= 'z')
                    || (codes[i] >= 'A' && codes[i] <= 'Z')
                    || (codes[i] >= '0' && codes[i] <= '9')
                    || codes[i] == ' ' || codes[i] == ',' || codes[i] == '.'
                    ) {
                letters++;
            } else if(codes[i] > 128) { // penalize characters way out of normal ascii range
                letters -= 25;
            }
        }
        return (double) letters / codes.length;
    }

    public void print(int[] codes) {
        for(int i = 0; i < codes.length; i++) {
            System.out.print((char)codes[i]);
        }
        System.out.println();
        for(int i = 0; i < codes.length; i++) {
            System.out.print(codes[i] + " ");
        }
        System.out.println();
    }

    private int[] readCode() {
        FileReader reader = new FileReader("problems/_059/cipher1.txt");
        String data = reader.getContent();
        String[] arr = data.replace("\n", "").split(",");
        int[] codes = new int[arr.length];
        for(int i = 0; i < codes.length; i++) {
            codes[i] = Integer.parseInt(arr[i]);
        }
        return codes;
    }

    /**
     * works both ways
     * 65 XOR 42 = 107, then 107 XOR 42 = 65.
     */
    private int[] encrypt(int[] message, int[] key) {
        int[] encrypted = new int[message.length];

        for (int i = 0; i < message.length; i++) {
            encrypted[i] = message[i] ^ key[i % key.length];
        }
        return encrypted;
    }


}
