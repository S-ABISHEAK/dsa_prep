import java.util.ArrayList;
import java.util.List;

public class CombinationLock {
    // public List<List<Integer>> combinations(int n , int k){
    //     List<List<Integer>> ans = new ArrayList<>();
    //     for(int i = 1 ; i <= n ; i++){
    //         for(int j = i + 1 ; j <= n ; j++){        
    //             ans.add(new ArrayList<>(Arrays.asList(i,j)));
    //         }
    //     }
    //     return ans;

        public void combinations(int start , int n , int k , List<Integer> list){
            
            if(list.size() == k){
                System.out.println(list);
                return;
            }

            for(int i = start ; i <= n ; i++){

                list.add(i);  // Initially FIRST number , then the 2nd number added
                combinations(i + 1 , n , k , list);
                list.remove(list.size() - 1); // first remove the 2nd number and then later through baacktracking remove the 1ts number for changing
            }
        }
        public static void main(String[] args) {
        int n = 4 , k = 2;
        List<Integer> ans = new ArrayList<>();
        CombinationLock obj = new CombinationLock();
        // System.out.println(obj.combinations(n , k));
        obj.combinations(1 , n , k , ans);
    }
}
    

