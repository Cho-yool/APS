import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        int num=scan.nextInt();

        String base=scan.next();

        int start_index=base.indexOf("*");



        String base_start=base.substring(0,start_index);
        String base_end=base.substring(start_index+1);

        int base_start_length=base_start.length();
        int base_end_length=base_end.length();

        //*을 뺀 string 길이.
        int base_length=base.length()-1;

        for(int i=0;i<num;i++){
            String temp=scan.next();

            int temp_length=temp.length();

            if(temp_length<base_length){
                System.out.println("NE");
            }else{
                String temp_start=temp.substring(0,base_start_length);
                String temp_end=temp.substring(temp_length-base_end_length);

                if(temp_start.equals(base_start)&&temp_end.equals(base_end))
                    System.out.println("DA");
                else
                    System.out.println("NE");
            }


        }

        scan.close();

        return;
    }



}