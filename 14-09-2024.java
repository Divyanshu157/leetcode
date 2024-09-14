class Solution {
    public int longestSubarray(int[] nums) {

        // ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        // int n =nums.length;
        // for(int i=0;i<n;i++){
        //     for(int j=i;j<n;j++){
        //         ArrayList<Integer> l = new ArrayList<>();

        //         for(int k=i;k<=j;k++){
        //             l.add(nums[k]);
        //         }
        //         list.add(l);
        //     }
        // }
        // System.out.println(list);
        // int size=0;
        // int max = Integer.MIN_VALUE;
        // for(ArrayList<Integer> li:list){
        //     int val = Integer.MAX_VALUE;;
        //     for(Integer i:li){
        //         val = val & i;     
        //     }
        //     if(max<val){
        //         max=val;
        //         size=li.size();
        //     }
        // }

        

        // return size;

        int maxlength=0;
        int currlength=0;
        int max=0;
        int n =nums.length;
        for(int i=0;i<n;i++){
            max = Math.max(max,nums[i]);
        }

        for(int i=0;i<n;i++){
            if(max==nums[i]){
                currlength++;
                maxlength=Math.max(currlength,maxlength);
            }else{
                currlength=0;
            }
        }

        return maxlength;

    }
}
