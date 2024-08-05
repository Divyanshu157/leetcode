class Solution {
    public String kthDistinct(String[] arr, int k) {

        LinkedHashMap<String,Integer> map = new LinkedHashMap<>();

        // LinkedHashMap<String ,Integer> map = new LinkedHashMap<>();

        for(String s:arr){
            map.put(s , map.getOrDefault(s,0)+1);

        }

        System.out.println(map);

        int temp=0;
        System.out.println();

        for(String str: map.keySet()){
            if(map.get(str)==1){
                temp++;
            }
            if(temp==k){
                return str;

            }

        }
        
        




        return "";


    }
}
