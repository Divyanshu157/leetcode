class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int [][] dist = new int[n][n];
        
        // Initialize distance matrix
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (i == j) {
                    dist[i][j] = 0;  // Distance to itself is zero
                } else {
                    dist[i][j] = Integer.MAX_VALUE;  // Infinite distance initially
                }
            }
        }

        // Set the distance for each edge
        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            dist[u][v] = wt;
            dist[v][u] = wt;
        }

        // Floyd-Warshall algorithm to find shortest paths
        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        int cntcity = n;
        int cityNo = -1;

        // Find the city with the smallest number of reachable cities within the distance threshold
        for(int city = 0; city < n; city++) {
            int cnt = 0;
            for(int adjCity = 0; adjCity < n; adjCity++) {
                if(dist[city][adjCity] <= distanceThreshold) {
                    cnt++;
                }
            }
            if(cnt <= cntcity) {
                cntcity = cnt;
                cityNo = city;   
            }
        }
        return cityNo;
    }
}
