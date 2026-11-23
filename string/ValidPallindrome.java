public class ValidPallindrome {
    public boolean validcheck(String s){
        int left = 0;
        int right = s.length() - 1;

        while(left < right){
            if(left < right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            if(left < right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            if(!(Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right)))){
                return false;
            }
            left++;
            right--;

        }
        return true;
    }
    public static void main(String[]args){
        String s = "A man, a plan, a canal: Panama";
        ValidPallindrome obj = new ValidPallindrome();
        System.out.println(obj.validcheck(s));
    }
}
