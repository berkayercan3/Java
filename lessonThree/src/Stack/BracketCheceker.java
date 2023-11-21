package Stack;

public class BracketCheceker {
    private String input;

    public BracketCheceker(String in) {input=in;}

    public void check(){
        int stackSize = input.length();
        StackX theStack = new StackX(stackSize);

        for (int i = 0; i <input.length() ; i++) {
            char ch = input.charAt(i);
            switch (ch){
                case '{':
                case '[':
                case'(':
                    theStack.push(ch);
                    break;
                case '}':
                case']':
                case ')':
                    if(!theStack.isEmpty()) {
                        char  popped = theStack.pop();
                        if((ch == '}' && popped != '{') || (ch==']' &&  popped !='[') || (ch == ')' && popped !='(') )
                        System.out.println("Hata yanlış parantez: " + ch + "İndis:" + i);
                    }
                    else
                        System.out.println("hata fazla parantez kapatılmış: " + ch + "İndis: " + i);
                    break;
            }
        }
        if (!theStack.isEmpty())
            System.out.println("Hata: Sağ parantez eksik");
    }


}
