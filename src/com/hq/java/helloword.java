package com.hq.java;
/*


 */


import java.math.BigInteger;
import java.util.Scanner;

public class helloword {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BigInteger answer= new BigInteger("1");
        for (int i=1;i<1000;i++){
            BigInteger current= BigInteger.valueOf(i);
            answer=answer.multiply(current);
        }
        System.out.println(answer);
    }
}
