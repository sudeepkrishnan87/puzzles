package com.mytechexp.modulararithmetics;

/*
* Given two integers A and B, find the greatest possible positive M, such that A % M = B % M
*A = 1
B = 2
* A%1==B%1==0 but A%m==B%m==k where it can be a floating pont value but equal here eucliden GCD wotn work
*
* Its not mandatory to be A%m and B%m ==0
*
*  if a%m =b%m
* B=A-(A-B)%m
*
*     a-b=m
*
*if(A>B)
* B= A-(A-B)
* take %(A-B) both sides
* B%(A-B)=(A-(A-B))%(A-B)
* B%(A-B)=(A%(A-B)-(A-B)%A-B))
*
* B%(A-B)=A%(A-B)// A-B as %m
* A-B=m
*
* 5,9  abs(5-9)=4
* 5%4=1 9%4=1
*
*
* */
public class FindInverseMod {

    public int solve(int A, int B) {
       int result=Math.abs(A-B);
        return result;
    }

    public static void main(String args[]) {
        FindInverseMod mod = new FindInverseMod();
        System.out.println(mod.solve(6816621, 8157697));
    }

}
