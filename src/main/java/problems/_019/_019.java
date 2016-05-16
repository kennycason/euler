package problems._019;

import main.Problem;
import main.annotations.Solved;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Solved
public class _019 extends Problem {

    public static void main(String[] args) {
        Problem p = new _019();
        p.run();
        System.out.println(p.answer());
    }

    @SuppressWarnings("deprecation")
    public void run() {
         GregorianCalendar startDate = new GregorianCalendar(1901, 1 - 1, 1);
         GregorianCalendar endDate = new GregorianCalendar(2000, 12 - 1, 1);

        Calendar start = Calendar.getInstance();
        start.setTime(startDate.getTime());
        Calendar end = Calendar.getInstance();
        end.setTime(endDate.getTime());

        int num = 0;
        for (Date date = start.getTime(); !start.after(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
            if(date.getDate() == 1 && date.getDay() == 0) {
                num++;
            }
        }
        this.answer = num;
    }

}
