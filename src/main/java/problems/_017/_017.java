package problems._017;

import main.Problem;
import main.annotations.Solved;

@Solved
public class _017 extends Problem {

    private String[] num1_20 = {
            "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
            "eighteen", "nineteen"
    };

    public static void main(String[] args) {
        Problem p = new _017();
        p.run();
        System.out.println(p.answer());
    }

    // could do pattern analysis, but i'm going to write a generic number writer
    public void run() {
        int length = 0;
        for(int i = 1; i <= 1000; i++) {
            StringBuffer sb = new StringBuffer();
            build(i, sb);
            String num = sb.toString().replace(" ", "").trim();
            length += num.length();
        }
        this.answer = length;
    }


    private void build(int num, StringBuffer sb) {
        if(num > 999) {
            // assume no larger than 1000s
            sb.append("one thousand");
            if(num % 1000 != 0) {
                sb.append("and");
                build(num % 1000, sb);
            }
        } else if(num > 99) {
            if(num >= 100 && num < 200) {
                sb.append("one hundred");
            } else if(num >= 200 && num < 300) {
                sb.append("two hundred");
            } else if(num >= 300 && num < 400) {
                sb.append("three hundred");
            } else if(num >= 400 && num < 500) {
                sb.append("four hundred");
            } else if(num >= 500 && num < 600) {
                sb.append("five hundred");
            } else if(num >= 600 && num < 700) {
                sb.append("six hundred ");
            } else if(num >= 700 && num < 800) {
                sb.append("seven hundred");
            } else if(num >= 800 && num < 900) {
                sb.append("eight hundred");
            } else if(num >= 900 && num < 1000) {
                sb.append("nine hundred");
            }
            if(num % 100 != 0) {
                sb.append(" and ");
                build(num % 100, sb);
            }
        } else if(num >= 20 && num <= 99) {
            if(num >= 20 && num < 30) {
                sb.append("twenty ");
            } else if(num >= 30 && num < 40) {
                sb.append("thirty ");
            } else if(num >= 40 && num < 50) {
                sb.append("forty ");
            } else if(num >= 50 && num < 60) {
                sb.append("fifty ");
            } else if(num >= 60 && num < 70) {
                sb.append("sixty ");
            } else if(num >= 70 && num < 80) {
                sb.append("seventy ");
            } else if(num >= 80 && num < 90) {
                sb.append("eighty ");
            } else if(num >= 90 && num < 100) {
                sb.append("ninety ");
            }
            build(num % 10, sb);
        } else if(num < 20) {
            if(num > 0) {
                sb.append(num1_20[num - 1]);
            }
        }
    }

}
