一年一度的春招就要到来了，牛牛为了备战春招，在家刷了很多道题，所以牛牛非常喜欢AC这两个字母。他现在有一个只包含A和C的字符串，
你可以任意修改最多k个字符，让A变成C，或者C变成A。请问修改完之后，最长连续相同字符的长度是多少。
public class Solution {
    /**
     * 
     * @param k int整型 
     * @param s string字符串 
     * @return int整型
     */
    public int Solve (int k, String s) {
        // write code here
        int n=s.length();
        int[] A=new int[n+2];
        int a=1;
        A[0]=-1;
        int[] C=new int[n+2];
        C[0]=-1;
        int b=1;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='A') A[a++]=i;
            else C[b++]=i;
        }
        A[a++]=n;
        C[b++]=n;
        if(a<=k||b<=k) return n;
        
        int max=0;
        for(int left=1,right=k;right<a-1;left++,right++){
            max=Math.max(max,A[right+1]-A[left-1]-1);
        }
        
        for(int left=1,right=k;right<b-1;left++,right++){
            max=Math.max(max,C[right+1]-C[left-1]-1);
        }
        
        return max;
    }
}


public class Main{
    private static void back(int n,int m,int begin,List<Integer> list){
        if(m<0) return;
        if(m==0){
            for(int num:list){
                System.out.print(num+" ");
            }
            System.out.println();
            return;
        }
        if(begin==n+1) return;
        for(int i=begin;i<=n;i++){
            if(i>m) break;
            m-=i;
            list.add(i);
            back(n,m,i+1,list);
            m+=i;
            list.remove(list.size()-1);
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int m=sc.nextInt();
            back(n,m,1,new ArrayList<>());
        }
    }
}



public class Main{
    static int[] arr={2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,8,8,8,9,9,9,9};
    private static void transform(String[] str){
        List<String> list=new ArrayList<>();
        for(String s:str){
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<s.length();i++){
                char c=s.charAt(i);
                if(c>='0'&&c<='9'){
                    sb.append(c);
                }else if(c>='A'&&c<='Z'){
                    sb.append(arr[c-'A']);
                }
                if(sb.length()==3) sb.append("-");
            }
            list.add(new String(sb));
        }

        Collections.sort(list);
        String tmp="";
        for(String s:list){
            if(!tmp.equals(s))
                System.out.println(s);
            tmp=s;
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            String[] str=new String[n];
            for(int i=0;i<n-1;i++){
                str[i]=sc.next();
            }
            str[n-1]=sc.next();
            transform(str);
            System.out.println();
        }
    }
}