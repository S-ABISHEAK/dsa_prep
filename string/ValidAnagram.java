public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length()){
            return false;
        }
        
        int n = s.length();

        int calc[] = new int[26];

        for(int i = 0 ; i < n ; i++){
            calc[s.charAt(i) - 'a']++;
            calc[t.charAt(i) - 'a']--;
        }

        for(int x : calc){
            if(x != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[]args){  // this should be always the same and should not change the return type as the created function...

        String s = "anagram";
        String t = "nagaram";

        ValidAnagram obj = new ValidAnagram();

        System.out.println(obj.isAnagram(s, t));
    }
}