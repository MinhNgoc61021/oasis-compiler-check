import compiler_error.Compiler_Error;
import org.json.JSONObject;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Compiler_Error error = new Compiler_Error();
        String compiler_error_msg = "symbol: class Account\n" +
                "location: class MyTest\n" +
                "MyTest.java:25: error: cannot find symbol\n" +
                "withdrawMethod = JavaReflection.getMethod(Account.class, withdraw, void.class, , ,";
        JSONObject json_error = error.Jsonify(compiler_error_msg);
        System.out.println(json_error.toString());

    }
}
