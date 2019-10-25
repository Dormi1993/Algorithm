package com.fcj.DynamicProgramming.POJ;

import java.util.Scanner;

/**
 * Created by dormi on 2017/9/3.
 */
//public class Main {
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[][] dp = new int[n+1][n+1];
//        int[][] maxDP = new int[n+1][n+1];
//
//        for (int i = 1; i <= n; i++){
//            for (int j = 1; j <= i; j++){
//                dp[i][j] = sc.nextInt();
//                maxDP[i][j] = -1;
//            }
//        }
//
//        System.out.println(backMax(1, 1, n, dp, maxDP));
//
//    }
//
//    public static int backMax(int p, int q, int n, int[][] dp, int[][] maxDP){
//        if (maxDP[p][q] != -1){
//            return maxDP[p][q];
//        }
//
//        if (p == n){
//            return dp[p][q];
//        } else {
//            return Math.max(backMax(p+1, q, n, dp, maxDP),
//                    backMax(p+1, q+1, n, dp, maxDP)) + dp[p][q];
//        }
//    }
//}


//public class Main {
//
//    static int max = 101;
//    static int[][] dp = new int[max][max];
//    static int[][] maxDP = new int[max][max];
//
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//
//
//        for (int i = 1; i <= n; i++){
//            for (int j = 1; j <= i; j++){
//                dp[i][j] = sc.nextInt();
//                maxDP[i][j] = -1;
//            }
//        }
//
//        System.out.println(backMax(1, 1, n));
//
//    }
//
//    public static int backMax(int p, int q, int n){
//        if (maxDP[p][q] != -1){
//            return maxDP[p][q];
//        }
//
//        if (p == n){
//            return dp[p][q];
//        } else {
//            return Math.max(backMax(p+1, q, n),
//                    backMax(p+1, q+1, n)) + dp[p][q];
//        }
//    }
//}

public class Main {

    //带备忘录的递归
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[][] dp = new int[n+1][n+1];
//        int[][] maxDP = new int[n+1][n+1];
//
//        for (int i = 1; i <= n; i++){
//            for (int j = 1; j <= i; j++){
//                dp[i][j] = sc.nextInt();
//                maxDP[i][j] = -1;
//            }
//        }
//
//        System.out.println(backMax(1, 1, n, dp, maxDP));
//
//    }
//
//    public static int backMax(int p, int q, int n, int[][] dp, int[][] maxDP){
//        if (maxDP[p][q] != -1){
//            return maxDP[p][q];
//        }
//
//        if (p == n){
//            return dp[p][q];
//        } else {
//            return Math.max(backMax(p+1, q, n, dp, maxDP),
//                    backMax(p+1, q+1, n, dp, maxDP)) + dp[p][q];
//        }
//    }

    //自底向上的递归
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[n+1][n+1];
        int[][] maxDP = new int[n+1][n+1];

        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= i; j++){
                dp[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i <= n; i++){
            maxDP[n][i] = dp[n][i];
        }

        for (int i = n - 1; i > 0; i--){
            for (int j = 1; j <= i; j++){
                maxDP[i][j] = Math.max(maxDP[i + 1][j], maxDP[i + 1][j + 1]) + dp[i][j];
            }
        }

        System.out.println(maxDP[1][1]);


    }
}