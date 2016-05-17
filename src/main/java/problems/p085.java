package problems;

import main.Problem;
import main.annotations.Solved;

@Solved
public class p085 extends Problem {

    public static void main(String[] args) {
        Problem p = new p085();
        p.run();
        System.out.println(p.answer());
    }

    public void run() {
        int area = 0;
        int closedTo2Million = Integer.MAX_VALUE;
        for(int w = 1; w < 100; w++) {
            for(int h = 1; h < 100; h++) {
                int count = countRectangles(w, h);
                int delta = Math.abs(count - 2000000);
                if(delta < closedTo2Million) {
                    closedTo2Million = delta;
                    area = w * h;
                    // System.out.println("d = " + delta + ", c = " + count + ", a = " + area);
                }
            }
        }
        this.answer = area;
    }

    private int countRectangles(int w, int h) {
        int count = 0;
        for(int w2 = 1; w2 <= w; w2++) {
            for(int h2 = 1; h2 <= h; h2++) {
                //int microCount = 0;
                for(int x = 0; x <= w - w2; x++) {
                    for(int y = 0; y <= h - h2; y++) {
                        count++;
                        //microCount++;
                    }
                }
                //System.out.println(w2 + " " + h2 + " : " + microCount);
            }
        }
        return count;

    }


}
