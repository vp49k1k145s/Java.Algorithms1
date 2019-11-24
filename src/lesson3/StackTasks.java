package lesson3;

public class StackTasks {

    public static void main(String[] args) {
        System.out.println(new StackTasks()
                .trueBracketSequences("())((()())())"));
//        CrockeryStack stack = new CrockeryStack(3);
//        for (int i = 0; i < 7; i++) {
//            stack.push("crockery " + (i + 1));
//        }
//        stack.show();
//        for (int i = 0; i < 7; i++) {
//            System.out.print(stack.pop() + " ");
//        }

    }

    public boolean trueBracketSequences(String sequence) {
        Stack<Character> stack = new Stack<Character>();
        char[] c = sequence.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '(') stack.push('(');
            else {
                if (stack.size() == 0) return false;
                stack.pop();
            }
        }
        return stack.size() == 0;
    }

    static class CrockeryStack {
        int limit, counter, size;
        Stack<Stack<String>> stacks;


        public CrockeryStack(int limit) {
            this.limit = limit;
            counter = 0;
            size = 0;
            stacks = new Stack<Stack<String>>();
        }

        public String pop() {
            String item = null;
            if (stacks.size() == 0) return null;
            if (stacks.top().size() == 0) {
                stacks.pop();
                if (stacks.size() == 0) return null;
                item = stacks.top().top();
                stacks.top().pop();
            } else {
                item = stacks.top().top();
                stacks.top().pop();
            }
            return item;
        }

        public void push(String item) {
            if (stacks.size() == 0) {
                stacks.push(new Stack<String>());
                size++;
            }
            if (stacks.top().size() < limit) {
                stacks.top().push(item);
            } else {
                stacks.push(new Stack<String>());
                size++;
                stacks.top().push(item);
            }
        }

        public void show() {
            for (Stack<String> s : stacks) {
                s.show();
                s.top();
            }
        }
    }
}