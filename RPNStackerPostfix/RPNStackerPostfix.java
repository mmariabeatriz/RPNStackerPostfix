import java.util.Scanner;
import java.io.File;
import java.util.Stack;

public class RPNStackerPostfix{
     public static boolean isInt(String input) {
        if (input == null) return false;

        try {
            Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            return false;
        }

        return true;
    }

    public static int calculate(int left, int right, String operation) {
        if (operation.equals("+")) {
            return left + right;
        }else if (operation.equals("-")) {
            return left - right;
        }else if (operation.equals("*")) {
            return left * right;
        }else if (operation.equals("/")) {
            return left / right;
        }else {
            return left;
        }
    }

    public static void main(String[] args){
        Stack<Integer> stack = new Stack<Integer>();  
        Scanner input = new Scanner(file);
        File file = new File("./input.stk");
        while (input.hasNextLine()) {
            String data = input.nextLine();
            if(isInt(data) && stack.size() < 2) {
                stack.push(Integer.parseInt(data));
            }else if(isInt(data) && stack.size() >= 2) {
                throw new Exception("Invalid data.");
            }else {
                int left = stack.pop();
                int right = stack.pop();
                String operation = data;
                int operationResult = calculate(left, right, operation);
                stack.push(operationResult);
            }
            input.close();
            System.out.println(stack.pop());
        }
    }
}
