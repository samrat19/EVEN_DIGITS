package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {


        File file = new File("Output.txt");

        int test_case ;

        //file input proccess
        
        int[] datalist = readFile();

        // file output process

        try{

            PrintWriter output = new PrintWriter(file);

            //main execution

            test_case = datalist[0];

            for (int i = 1 ; i<=test_case ; i++) {

                System.out.println(""+final_result(datalist[i]));

                output.println("case #"+i+":  "+ final_result(datalist[i]));
            }

            output.close();

        }catch (FileNotFoundException e) {System.out.println("File not found");}
    }

    private static int[] readFile() throws FileNotFoundException {


        File file1 = new File("D:\\Java\\EvenDigits\\Input.txt.txt");

        Scanner sc = new Scanner(file1);

        int ctr = 0 ;
        while(sc.hasNext()){

            ctr++;
            sc.nextInt();
        }

        int[] testcase = new int[ctr];

        Scanner scanner1 = new Scanner(file1);

        for ( int i =0 ; i<testcase.length ; i++){
            testcase[i] = scanner1.nextInt();
        }

        return testcase;
    }

    private static int final_result(int number){

        int plus = number;
        int minus = number;
        int num1 = number;

        int check ;
        int check1 ;

        // for plus

        while(true){

            check = work_done(number);
            if(check > 0 ){
                number = number + 1;
            }else{
                break;
            }
        }

        int do_plus = number - plus;

        // for minus

        while(true){

            check1 = work_done(num1);

            if(check1 > 0){
                num1 = num1 - 1;
            }else{
                break;
            }
        }

        int do_minus = minus - num1;

        if(do_plus > do_minus){
            return do_minus;
        }else{
            return do_plus;
        }
    }

    private static int check(int x) {

        if (x%2 == 0){ return 0; }else{ return 1; }
    }

    private static int work_done(int number){

        int c ;
        int a =0 ;

        while(number > 0) {

            int x = number % 10;
            c = check(x);
            a = a + c;
            number = number / 10;
        }

        return a;
    }
}
