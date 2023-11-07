import java.util.*;
class Solution {
    public static class Tree{
        char c;
        boolean isAble = true;
        Map<Character,Tree> children = new HashMap<>();
        
        public Tree(){
            
        }
        public Tree(char c){
            this.c = c;
        }
        
        public void add(String word){
            char firstChar = word.charAt(0);
            if(children.containsKey(firstChar)){
                children.get(firstChar).isAble = false;
            }else{
                children.put(firstChar,new Tree(firstChar));
            }
            if(word.length() != 1) children.get(firstChar).add(word.substring(1));
        }
        
        public int getResult(String word){
            char firstChar = word.charAt(0);
            Tree target = children.get(firstChar);
            if(target.isAble){
                return 1;
            }else{
                if(word.length() == 1){
                   return 1; 
                }
                return 1 + target.getResult(word.substring(1));
            }
        }
        
        
        
    }
    public int solution(String[] words) {
        int answer = 0;
        Tree root = new Tree();
        
        
        for(String word : words){
            root.add(word);
        }
        
        for(String word : words){
            answer += root.getResult(word);
        }
        
        return answer;
    }
}