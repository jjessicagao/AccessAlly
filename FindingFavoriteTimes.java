// favourite times - 12:34, 1:11, 1:23, 1:35, 1:47, 1:59, 2:10, 2:22, 2:34, 2:46, 2:58, 3:21, 3:33, 3:45, 3:57, 4:20, 4:32, 4:44, 4:56, 
// 5:31, 5:43, 5:55, 6:30, 6:42, 6:54, 7:41, 7:53, 8:40, 8:52, 9:51, 11:11
// total - 31

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
public class FindingFavoriteTimes {
    public static void main(String[] args)
        throws IOException
    {
        int[] favHours = {0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 8, 8, 9, 11};
        int[] favMins = {34, 11, 23, 35, 47, 59, 10, 22, 34, 46, 58, 21, 33, 45, 57, 20, 32, 44, 56, 31, 43, 55, 30, 42,
                54, 41, 53, 40, 52, 51, 11};
        int[] favTimes = new int[31];
        for (int i = 0 ; i < 31 ; i++) {
            favTimes[i] = favHours[i]*60 + favMins[i];
        }

        InputStream in;
        if (args.length == 1) {
            in = new FileInputStream(args[0]);
        } else {
            in = System.in;
        }
        Scanner s = new Scanner(in);
        int d = s.nextInt();
        if (args.length == 1) {
            in.close();
        }

        int halfDays = d / (60 * 12);
        int total = 31 * halfDays;
        int remainingTime = d % (60 * 12);
        
        for (int time : favTimes) {
            if (remainingTime >= time) {
                total++;
            } else {
                break;
            }
        }
        System.out.println(total);
        return;
    }
}

