import java.util.*;

/**
 * Write an autocomplete class that returns all dictionary words with a given
 * prefix.
 *
 * eg.
 * dict: {"abc", "acd", "bcd", "def", "a", "aba"}
 * prefix: "a" -> "abc", "acd", "a", "aba"
 * prefix: "b" -> "bcd"
 */
public class Autocomplete {

    static Map<Integer,String> dictionary = new HashMap<>();
    static Node root = new Node(null);

    public static class Node {
        public Character ch;
        public List<Integer> words; //index of words in main words map
        public Map<Character,Node> childChars;

        public Node(Character ch) {
            this.ch = ch;
            words = new ArrayList<>();
            childChars = new HashMap<>();
        }
    }

    public static void addWord(String word) {
        dictionary.put(word.hashCode(),word);
        addWord(root,word,0);
    }

    private static void addWord(Node root,String word, int idx) {
        if(idx == word.length())
            return;
        char c = word.charAt(idx);
        Node n = root.childChars.get(c);
        if(n == null) {
            n = new Node(c);
        }
        n.words.add(word.hashCode());
        root.childChars.put(c,n);
        addWord(n,word,idx+1);
    }

    public static void onInput(String prefix) {
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        int idx = 0;
        while(!nodes.isEmpty()) {
            Node n = nodes.poll();
            if(idx == prefix.length()){
                printWords(n.words);
                return;
            }
            char ch = prefix.charAt(idx);
            Node childNode = n.childChars.get(ch);
            if(childNode != null)
                nodes.add(childNode);
            else{
                printWords(n.words);
                return;
            }
            idx++;
        }
    }

    public static void printWords(List<Integer> words) {
        for(Integer i : words) {
            String word = dictionary.get(i);
            if(word == null)
                word = "";
	else
            word = word + ",";
            System.out.print(word);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        addWord("abc");
        addWord("acd");
        addWord("bcd");
        addWord("def");
        addWord("a");
        addWord("aba");

        onInput("a"); //"abc", "acd", "a", "aba"
        onInput("b"); //"bcd"
        onInput("ab"); //abc,aba
        onInput("aba"); //aba
    }

}
