package com.mytechexp.eratosthenis;
/*
* Given an integer A, find the sum of divisors of A! modulo
*
* Example Input 1:
    A = 2
Example Output 1:
    3
Explanation 1:
    2! = 2, divisors = 1, 2

Example Input 2:
    A = 3
Example Output 2:
    12
    *
    *
    *3!=1*2*3=6
    * 6  1+2+3+6=12
    *
    *
    * 2^2 * 3^1=12
    * equation 2^2+1-1/2-1=2^3-1/1=8-1/1=7
    * 3^1+1-1/3-1=9-1/2=4
 * */


import java.util.ArrayList;
import java.util.List;

/*
* solution fine the prime factors and the exponent
*
* (factor^exp+1)-1/factor-1 + (factor^exp+1)-1/factor-1
*
* ex: (2^3+1)-1/2-1+(3^2+1)-1/3-1  etc
 *
* */
public class  SumOfDivisors {
    int modulo=1000*1000*1000+7;

    ArrayList<Long>primes=new ArrayList<>();

    public int solve(int A) {

      long factorial=fact(A);

      long sum=1l;
      findSieve(factorial);
      int[] count =new int[primes.size()];

      int index=0;
      while(factorial>1)
      {
           if(primes.size()==index)
               break;
          if(factorial%primes.get(index)==0) {
              factorial /= primes.get(index);
              count[index] = ++count[index];
          }
          else
              index++;

      }
for(int i=0;i<primes.size();i++)
{
    if(count[i]>0)
    {
        sum*=(power(primes.get(i),count[i]+1)-1)/(primes.get(i)-1);
    }
}

     return (int)sum;
    }
   private long power(long a,int b)
   {
       long result=1;
       a=a%modulo;
       while(b!=0)
       {
           if(b%2==1)
               result=(a*result)%modulo;

               b/=2;
               a=(a*a)%modulo;
           }


       return result;
   }
    private void findSieve(long factorial) {
        int[] sieve=new int[400000+1];

        for(int i=2;i<=400000;i++)
        {
           if(sieve[i]==0) {
               sieve[i] = i;
               primes.add(i*1l);
           }
           //System.out.println(i);//46341
           if((i*1l*i)>400000)
               continue;
           for(int j=(int)(i*i*1l)%modulo;j<=400000;j+=i)
           {
               //System.out.println(325611);

               if(sieve[j]==0)
                 sieve[j]=i;
           }
        }

    }

    private long fact(int A)
    {
        if(A==1)
            return 1;
        return fact(A-1)*A%modulo;
    }
  public static void main(String[] arg)
  {
      SumOfDivisors sd=new SumOfDivisors();
      System.out.println(sd.solve(13));
  }
}
