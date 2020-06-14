

import java.util.Scanner;

/**
 * Created by Piyush Priyadarshi.
 * User: @Piyush
 * Date: 17-04-2020
 * Time: 09:29
 */
public class AplusB {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String[] arr=str.split(" ");

        System.out.println(Integer.parseInt(arr[0])+Integer.parseInt(arr[1]));
    }
}
