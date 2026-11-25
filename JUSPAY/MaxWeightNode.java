public class MaxWeightNode {
    public int maxweight(int edge[]){
        int n = edge.length;
        int weights[] = new int[n];   // stores the sum of value nodes connected to each value giving us the answer
        
        for(int i = 0 ; i < n ; i++){
            if(edge[i] >= 0 && edge[i] < n){
                weights[edge[i]] += i;
            }
        }
        
        // now need to find the max node with the highest sum...
        
        int ans = -1 , maxVal = -1;
        
        for(int i = 0 ; i < n ; i++){
            if(weights[i] >= maxVal){
                maxVal = weights[i];
                ans = i;
            }
        }
        return ans;
    }
    public static void main(String[]args){
        int[] edge = {2, 0, -1, 2, 6};
        MaxWeightNode obj = new MaxWeightNode();
        System.out.println(obj.maxweight(edge));
    }
}
