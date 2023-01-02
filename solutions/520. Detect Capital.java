class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.length() < 2) return true;
        return solver(word);
    }
    private boolean solver(String word){
        if(Character.isUpperCase(word.charAt(0))){
            if(Character.isUpperCase(word.charAt(1))){
                for(int i=2; i<word.length(); i++){
                    if(!Character.isUpperCase(word.charAt(i))){
                        return false;
                    }
                }
            }else{
                for(int i=2; i<word.length(); i++){
                    if(Character.isUpperCase(word.charAt(i))){
                        return false;
                    }
                }
            }
        }else{
            for(int i=1; i<word.length(); i++){
                if(Character.isUpperCase(word.charAt(i))){
                        return false;
                }
            }
        }
        return true;
    }
}
