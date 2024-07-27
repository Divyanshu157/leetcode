class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int[][] dist = new int[26][26];

        for(int i=0;i<26;i++){
            for(int j=0;j<26;j++){
                if(i==j){
                    dist[i][j]=0;
                }else
                {
                    dist[i][j] = Integer.MAX_VALUE;

                }
            }
        }

        for(int i=0;i<changed.length;i++){
            int u = original[i]-'a';
            int v =changed[i]-'a';
            int wt = cost[i];
            dist[u][v] = Math.min(dist[u][v], wt);

        }

        for(int k=0;k<26;k++){
            for(int i=0;i<26;i++){
                for(int j=0;j<26;j++){

                   if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        }


        for(int i=0;i<26;i++){
            for(int j=0;j<26;j++){
                System.out.print(dist[i][j]+"    ");
            }
            System.out.println();
        }

        long totalCost = 0;
        for (int i = 0; i < source.length(); i++) {
            char u = source.charAt(i);
            char v = target.charAt(i);
            int costToConvert = dist[u - 'a'][v - 'a'];

            if (costToConvert == Integer.MAX_VALUE) {
                return -1;  // Conversion is impossible
            }

            totalCost += costToConvert;
        }

        return totalCost;
        

    }

    }

