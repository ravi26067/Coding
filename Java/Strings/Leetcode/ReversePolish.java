class Solution {
    
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack();
        int tmp = 0;
        if(tokens.length == 1)
        {
            return Integer.parseInt(tokens[0]);
        }
        
        for(int i=0;i<tokens.length;i++){
            String c = tokens[i];
            if(c.length()==1 && (c.equals("+") || c.equals("-") || c.equals("/")||c.equals("*"))){
                Integer op2 = st.pop();
                Integer op1 = st.pop();
                switch (c){
                    case "+":
                        tmp = op1 + op2;
                        break;
                    case "-":
                        tmp = op1 - op2;
                        break;
                    case "/":
                        tmp = op1 / op2;
                        break;
                    case "*":
                        tmp = op1 * op2;
                        break;
                }
                //if(!st.isEmpty())
                    st.push(tmp);
            }else{
                Integer value = Integer.parseInt(c);
                st.push(value);
            }
        }
        return tmp;
    }
}
