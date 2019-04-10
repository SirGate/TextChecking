package TextCheck;

import java.util.HashMap;

public class CheckOut {


 public static int calculate(String str1,String str2){

        int count=0;
        int count1=0;
        HashMap<String,Integer> words = new HashMap<>();

    if((str1.length()==0)|(str2.length()==0)){return 0;}

        str1=str1.trim().replaceAll("[^a-zA-Zа-яА-Я]"," ").toLowerCase();
        str2=str2.trim().replaceAll("[^a-zA-Zа-яА-Я]"," ").toLowerCase();

        String [] text1 = str1.split(" ");

for(String str:text1){
   if((words.get(str)!=null)&(str.length()>2)){
        words.put(str,words.get(str)+1);
        count++;
         } else if((words.get(str)==null)&(str.length()>2)){
       words.put(str,1);
       count++;
   }
}
 String [] text2 = str2.split(" ");

  for(String str:text2){
            if(words.get(str)!=null){
                count1++;
                int k=words.get(str)-1;
                if(k>0){
                    words.put(str,k);
                }
                else if(k==0){words.remove(str);}
            }
        }
int res=(int)(((double) count1/count)*100);
return res;}
}
