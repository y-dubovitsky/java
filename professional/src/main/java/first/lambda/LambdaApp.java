package first.lambda;

public class LambdaApp {

    public static void main(String[] args) {

        // lambda-expression
        Operationable operation;
        operation = (x,y) -> x + y;

        int result = operation.calculation(2,2);
        System.out.println("lambda-expression " + result);

        // anonymous class
        Operationable op = new Operationable() {
            @Override
            public int calculation(int x, int y) {
                return x + y;
            }
        };
        System.out.println("anonymous class " + op.calculation(2,2));
    }

}

interface Operationable {
    int calculation(int x, int y);
}
