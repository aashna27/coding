//Qs https://leetcode.com/problems/string-to-integer-atoi


class Solution {
    public static void main(String[] args) {
        String str = " -213445";
        String  s1 = " +98";// output = 98
        String s2 = "-"; // output = 0
        String s3 = "-2147483647";// output = -2147483647 its less than Integer.MIN_VALUE= -2147483648
        String s4 = "2147483647"; // output = 2147483647= INteger.MAX_VALUE
        String s5 = "1111122223334";
        System.out.println(myAtoi(str));
    }
    public static int myAtoi(String str) {
         boolean negetive = false; // to see if input is negetive
        String noInput="";
        
        for(int i=0;i<str.length();i++){
             // skip all spaces in starting

            if(str.charAt(i)!=' ')
            {
                if(str.charAt(i)=='-'){ // see if no is negetive eg "   -9829"
                    negetive = true;
                    i++;
                }
                else if(str.charAt(i)=='+'){ // see if positive eg "+98"
                    i++;
                }
                
                while(i<str.length()){
                    char ch = str.charAt(i);

                    if(ch<'0'||ch>'9') // if a non-digit char is found then break
                    {
                        break;
                    }
                    else noInput+=str.charAt(i); // else keep appending
                    i++;
                }
                
                 break; // no need to parse rest of string, we only need first number 
                
            }
        }
        
        
        if(noInput=="") // if no number found first
            return 0;
        else {
            int no = 0;
            for(int i=0;i<noInput.length();i++)
            {
                char ch=noInput.charAt(i);

                if(!negetive){
                    if ( no > Integer.MAX_VALUE / 10 || 
                         (no == Integer.MAX_VALUE / 10 && (ch-'0') > Integer.MAX_VALUE % 10)) // condition to check for overflow
                            return Integer.MAX_VALUE;
                    else
                         no = no*10 + (ch-'0');
                     }
                else { 
                    // check for negetive overflow, notice the *-1
                    if(no*-1<Integer.MIN_VALUE /10 || 
                        (no*-1==Integer.MIN_VALUE / 10 && (ch-'0')> (Integer.MIN_VALUE%10)*-1 ))
                       {
                           return Integer.MIN_VALUE;
                       }
                    else
                       no = no*10 + (ch-'0');
                }
            }
                
            
            if(negetive){

                return no*-1;
            }
                
           return no;
        }
    }
}