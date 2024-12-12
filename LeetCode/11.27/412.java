// 给你一个整数 n ，找出从 1 到 n 各个整数的 Fizz Buzz 表示，并用字符串数组 answer（下标从 1 开始）返回结果，其中：


// answer[i] == "FizzBuzz" 如果 i 同时是 3 和 5 的倍数。
// answer[i] == "Fizz" 如果 i 是 3 的倍数。
// answer[i] == "Buzz" 如果 i 是 5 的倍数。
// answer[i] == i （以字符串形式）如果上述条件全不满足。


import java.util.List;
import java.util.ArrayList;
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ans=new ArrayList();
        for(int i=1;i<=n;i++){
            if(i%15==0){
                ans.add("FizzBuzz");
            }else if(i%3==0){
                ans.add("Fizz");
            }else if(i%5==0){
                ans.add("Buzz");
            }
            else{
                String temp=i+"";
                ans.add(temp);
            }
        }
        return ans;
    }
}


//C语言不好做