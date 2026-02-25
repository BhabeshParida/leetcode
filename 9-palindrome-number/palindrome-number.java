import java.util.Scanner;
class Solution {
    public static boolean isPalindrome(int x) { //856
     if (x < 0) return false;
        int temp=x,sum=0;
        while(x!=0)
        {
            int last=x%10;
            sum=sum*10+last;// 658
            x/=10;
        }
        return sum==temp;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num=sc.nextInt();
        System.out.println(isPalindrome(num)?"true":"false");
        sc.close();
    }
}