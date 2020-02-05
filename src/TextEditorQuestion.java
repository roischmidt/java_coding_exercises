import java.util.Stack;


/**
 * [Google] Design Text Editor (Doubly Linked List)
 * Build a text editor class with the following functions,
 *
 * moveCursorLeft(),
 *
 * moveCursorRight(),
 *
 * insertCharacter(char) //insert the char right before cursor
 *
 * backspace() //delete the char right before cursor
 *
 * Follow-up
 * Implement undo() //undo the last edit. Can be called multiple times until all edits are cancelled.
 *
 * All functions above should take O(1) time.
 *
 * Example
 *
 * ( '|' denotes where the cursor locates. 'text' shows what's been written to the text editor. )
 *
 * Start with empty text
 * text = "|"
 *
 * insertCharacter('a')
 * text = "a|"
 *
 * insertCharacter('b')
 * text = "ab|"
 *
 * insertCharacter('c')
 * text = "abc|"
 *
 * moveCursorLeft()
 * text = "ab|c"
 *
 * moveCursorLeft()
 * text = "a|bc"
 *
 * backspace()
 * text = "|bc"
 *
 * moveCursorLeft()
 * text = "|bc" (nothing happens since cursor was on the leftmost position)
 *
 * undo()
 * text = "a|bc"
 *
 * undo()
 * text = "ab|c"
 *
 * undo()
 * text = "abc|"
 *
 * undo()
 * text = "ab|"
 *
 * undo()
 * text = "a|"
 */
public class TextEditorQuestion {

    enum TextEditEnum{
        MOVE_CUR_LEFT,MOVE_CUR_RIGHT,INSERT_CHAR,BACKSPACE
    }

    class EditOperation {
        TextEditNode textEditNode;
        TextEditEnum textEditEnum;

        public EditOperation(TextEditEnum textEditEnum,TextEditNode textEditNode) {
            this.textEditEnum = textEditEnum;
            this.textEditNode = textEditNode;
        }

        public TextEditNode getTextEditNode(){return textEditNode;}
        public TextEditEnum getTextEditEnum(){return textEditEnum;}
    }

    class TextEditNode {

        char ch;

        public TextEditNode(char ch){
            this.ch = ch;
        }
        public char getCh(){return ch;}

        public TextEditNode right;
        public TextEditNode left;
    }

    Stack<EditOperation> editStack = new Stack<>();
    TextEditNode cur = new TextEditNode('|');
    TextEditNode head = cur;


    public void moveCursorLeft() {
        if(cur.left == null) {
            head = cur;
            return;
        }
        editStack.push(new EditOperation(TextEditEnum.MOVE_CUR_LEFT,null));
        TextEditNode cl = cur.left;
        TextEditNode cr = cur.right;

        cur.left = cl.left;
        cur.right = cl;

        cl.left.right = cur;
        cl.right = cr;

        if(cr != null)
            cr.left = cl;

    }

    public void moveCursorRight(){
        if(cur.right == null)
            return;
        editStack.push(new EditOperation(TextEditEnum.MOVE_CUR_RIGHT,null));
        TextEditNode cl = cur.left;
        TextEditNode cr = cur.right;

        cur.left = cr;
        cur.right = cr.right;

        if(cl != null)
            cl.right = cr;
        else
            head = cr;
        cr.left = cl;

        cr.right = cur;
    }

    public void insertCharacter(char ch){
        TextEditNode newNode = new TextEditNode(ch);
        TextEditNode l = cur.left;
        if(l != null)
            l.right = newNode;
        else
            head = newNode;
        newNode.left = l;
        newNode.right = cur;
        cur.left = newNode;
        editStack.push(new EditOperation(TextEditEnum.INSERT_CHAR,newNode));


    }

    public void backspace(){
        TextEditNode nodeToDelete = cur.left;
        cur.left = nodeToDelete.left;
        nodeToDelete.left = null;
        nodeToDelete.right = null;
        if(cur.left != null)
            cur.left.right = cur;
        else
            head = cur;
        editStack.push(new EditOperation(TextEditEnum.BACKSPACE,nodeToDelete));
    }

    public void undo(){
        EditOperation editOperation = editStack.empty() ? null : editStack.pop();
        if(editOperation == null)
            return;
        switch (editOperation.textEditEnum) {
            case MOVE_CUR_LEFT:
                moveCursorRight();
                break;
            case MOVE_CUR_RIGHT:
                moveCursorLeft();
                break;
            case INSERT_CHAR:
                backspace();
                break;
            case BACKSPACE:
                insertCharacter(editOperation.getTextEditNode().ch);
                break;
        }
        editStack.pop(); // remove last save because it was triggered from undo
    }

    public void print() {
        TextEditNode node = head;
        while(node != null) {
            System.out.print(node.ch);
            node = node.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TextEditorQuestion t = new TextEditorQuestion();
        t.insertCharacter('a');
        t.print();//text = "a|"

        t.insertCharacter('b');
        t.print();//text = "ab|"

        t.insertCharacter('c');
        t.print();//text = "abc|"

        t.moveCursorLeft();
        t.print();//text = "ab|c"

        t.moveCursorLeft();
        t.print();//text = "a|bc"

        t.backspace();
        t.print();//text = "|bc"

        t.moveCursorLeft();
        t.print();//text = "|bc" (nothing happens since cursor was on the leftmost position)

        t.undo();
        t.print();//text = "a|bc"

        t.undo();
        t.print();//text = "ab|c"

        t.undo();
        t.print();//text = "abv|"

        t.undo();
        t.print();//text = "ab|"

        t.undo();
        t.print();//text = "a|"
    }
}
