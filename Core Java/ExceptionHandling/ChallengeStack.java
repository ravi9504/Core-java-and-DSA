package ExceptionHandling;

class StackOverflow extends Exception{
    public String toString(){
        return "Stack is full";
    }
}
class StackUnderFlow extends Exception{
    public String toString(){
        return "Stack is empty";
    }
}

class Stack{
    private int size;
    private int top=-1;
    private int s[];

    public Stack(int sz){
        size=sz;
        s=new int[sz];
    }
    public void push(int x) throws Exception{
        if(top==size-1){
            throw new StackOverflow();
        }
        top++;
        s[top]=x;
    }
    public int pop() throws Exception{
        int x=-1;
        if(top==-1){
            throw new StackUnderFlow();
        }
        x=s[top];
        top--;
        return x;
    }
}

public class ChallengeStack {
    public static void main(String[] args) throws Exception{
        Stack st= new Stack(5);
        try {
            st.push(4);
            st.push(4);
            st.push(4);
            st.push(4);
            st.push(4);
        } catch (StackOverflow sta) {
            System.out.println(sta);
        }
    }
}
