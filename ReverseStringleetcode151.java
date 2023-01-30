import java.util.*;
public class ReverseString {
    
    public static void ReverseString(String a){
        int i =a.length()-1;
        StringBuilder sb=new StringBuilder(""); 
        while(i>=0){
            while(i>=0 && a.charAt(i)==' ')i--;
             int j=i;

             while(i>=0 && a.charAt(i)!=' ')i--;
            
             sb.append(a.substring(i+1, j+1));
             sb.append(" ");
        }

        System.out.println(sb);
    }
public static void main(String args[]){
 String a="This is the great book.";
 ReverseString(a);
}
}
