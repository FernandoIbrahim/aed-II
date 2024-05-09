class Value {

    private String data;
    private int priority;

    public Value(String data){
        
        this.data = data;

        this.priority = switch(this.data.toLowerCase()) {
            case "(" -> 1;
            case ")" -> 4;
            case "+", "-" -> 2;
            case "*", "/" -> 3;
            default -> -1;
        };

    }

    public int getPriority() {
        return priority;
    }

    public String getData() {
        return this.data;
    }


}
