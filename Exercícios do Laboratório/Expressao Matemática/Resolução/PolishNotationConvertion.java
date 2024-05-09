import java.util.ArrayList;
import java.util.List;

public class PolishNotationConvertion {

    private Value[] valueArray;

    private Stack<Value> waitingStack;

    private String[] output;
    private int outputPostionArray;


    public String mathExpressionConversion(String array){

        this.waitingStack = new Stack<>();


        this.outputPostionArray = 0;

        creatingValueArray(array);
        
        for(Value value: valueArray){

            if (value.getPriority() == -1) {
                
                priorityMinusOne(value);
            
            }else if(value.getPriority() == 4 ){

                priorityFour();

            }else if(value.getPriority() == 1){

                priorityOne(value);

            }else if(waitingStack.empty() || value.getPriority() > waitingStack.peek().getPriority() ){

                highterPriority(value);

            }else if(value.getPriority() <= waitingStack.peek().getPriority() ){

                lowerPriority(value);

            }

        }


        finishCleaningWaitingStack();

        String result = refiningOutputArrayToString();
        
        return result;

    }





    public void priorityMinusOne(Value value){

        output[outputPostionArray] = value.getData();
        outputPostionArray++;

    }

    public void priorityFour(){


        while(waitingStack.peek().getPriority() != 1){

            output[outputPostionArray] = waitingStack.pop().getData();
            outputPostionArray++;

        }

        waitingStack.pop();

    }

    public void priorityOne(Value value){

        waitingStack.push(value);

    }

    public void highterPriority(Value value){

        waitingStack.push(value);

    }

    public void lowerPriority(Value value){

        Value unstackedValue = waitingStack.pop();
        output[outputPostionArray] = unstackedValue.getData();
        waitingStack.push(value);
        outputPostionArray++;

    }

    public void creatingValueArray(String string){

        String correctedString = correctingString(string);
        String[] stringDevided = correctedString.split(" ");

        List<Value> valueList = new ArrayList<>();
        this.output = new String[stringDevided.length];
        
        for(String item: stringDevided){

            Value value = new Value(item);
            valueList.add(value);
        }

        valueArray = valueList.toArray(new Value[valueList.size()]);

    }


    public void finishCleaningWaitingStack(){
        while(!waitingStack.empty()){
            String unstackedValue = waitingStack.pop().getData();
            output[outputPostionArray] = unstackedValue;
            outputPostionArray++;
        }
    }


    public String refiningOutputArrayToString(){
        String result = "";

        for(String character : output){

            if( character != null){

                result += character + " ";

            }else
                break;

        }
        
        return result;

    }




    public static String correctingString(String data){
        StringBuilder result = new StringBuilder();
        boolean dentroDoParenteses = false;

        for (char c : data.toCharArray()) {
            if (c == '(') {
                dentroDoParenteses = true;
            } else if (c == ')') {
                dentroDoParenteses = false;
            }

            if (c == '(' ) {
                result.append(c).append(" ");
                
            } else if(c == ')') {
                result.append(" ").append(c);
            } else
            {
                result.append(c);
            }
        }

         return result.toString();
    }


}
