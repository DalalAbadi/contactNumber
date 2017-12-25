package javaapplication51;
import java.util.*;

import java.util.HashMap;

public class ContactNumber {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
      
        
        Trie trie = new Trie();
     trie.add("Yala");
        trie.add("Sara");
        trie.add("SSara");
        trie.add("SSara");
        trie.add("Sama");
        trie.add("Saama");
        trie.add("Lara");
        trie.add("Hala");
        trie.add("Dama");
        trie.add("HHala");
        trie.add("HHHHala");
        trie.add("Safa");
        trie.add("Lama");
        trie.add("Aama");
        trie.printAll(trie.root);
        trie.sort();
        
        
      
}
}

class TrieNode {
   HashMap<Character, TrieNode> children = new HashMap<>();
    public int size = 0; // this was the main trick to decrease runtime to pass tests.
    public char ch ;
    public String sr ;
    public boolean isWord ;

    public void putChildIfAbsent(char ch,boolean isWord , String str) {
        TrieNode nn = new TrieNode();
        nn.isWord = isWord ;
        nn.sr = str ;
        children.putIfAbsent(ch, nn);
        
    }

    public TrieNode getChild(char ch) {
        return children.get(ch);
    }
}

class Trie {
    TrieNode root = new TrieNode();
    ArrayList al = new ArrayList();
    
   

    Trie(){} 
    
    Trie(String[] words) {
        for (String word : words) {
            add(word);
        }
    }
    
    public void add(String str) {
         
        TrieNode curr = root;
        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            if ( i == (str.length() - 1 ) ){
            curr.putChildIfAbsent(ch,true ,str);
            }
            else {
                    curr.putChildIfAbsent(ch,false ,str);
                    }
            curr.ch = ch; 
            curr = curr.getChild(ch);
            curr.size++;
        }
    }
    
    public int find(String prefix) {
        TrieNode curr = root;
        
        /* Traverse down tree to end of our prefix */
        for (int i = 0; i < prefix.length(); i++) {
            Character ch = prefix.charAt(i);
            curr = curr.getChild(ch);
            if (curr == null) {
                return 0;
            }
        }
        return curr.size;
    }
    
     public void printAll(TrieNode root) {
        TrieNode curr = root;
        
        /* Traverse down tree to end of our prefix */
        
            Character ch = root.ch;
            curr = curr.getChild(ch);
            
            if (curr == null) {
                return ;
            }
            TrieNode prev =null;
            
            
            
            
            for (Map.Entry<Character, TrieNode> entry : root.children.entrySet()) {
     
                      
                        if ((entry.getValue().children.isEmpty()) ||  entry.getValue().isWord){
                          this.al.add(entry.getValue().sr);
                           
                     
                           
                             
                        }
                         printAll(entry.getValue());
                        
                       
                
                
            }
            
           
        }
     
     
     void sort(){
          Collections.sort(al);
            System.out.print(al.size());
           System.out.print(Arrays.toString(al.toArray()));
         
     }
       
    
}