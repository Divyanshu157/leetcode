class Solution {
    public int minimumPushes(String word) {

        // return word.length(); //  169 testcases pass out of 877

int n =word.length();
        int arr[] = new int[26];
        for(int i=0;i<n;i++){
            arr[word.charAt(i)-'a']++;
        
        }

        Arrays.sort(arr);


        int count=1;
        int min=0;

        int round=0;

        for(int j=arr.length-1;j>=0;j--){

         
            min+=count*arr[j];
            round+=1;
            if(round==8){
                round=0;
                count+=1;
            }
        
            System.out.println(min +"="+arr[j]+"*"+count);
         

        }

        return min;





        
    }
}
