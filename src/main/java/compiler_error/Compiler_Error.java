package compiler_error;

import org.json.JSONObject;

import java.util.Stack;
import java.util.regex.Pattern;

public class Compiler_Error {
    private JSONObject json_err_msg;
    private Stack<String> error_stack;

    // Chuyển array dòng lỗi thành stack
    public Stack<String> toStack(String input) {
        Pattern regex = Pattern.compile("\n", Pattern.MULTILINE);
        String[] compile_error_arr = regex.split(input);
        for (String line: compile_error_arr) {
            error_stack.push(line);
        }
        return error_stack;
    }

    public JSONObject Jsonify(String input) {
        Pattern regex = Pattern.compile("\n", Pattern.MULTILINE);

        String[] compile_error_arr = regex.split(input);

        for (String line: compile_error_arr) {
            System.out.print(line + ", ");
            if (line.matches("(.*)^(symbol):(.*)")) {
                String[] symbol = line.split("symbol:");
                json_err_msg.put("symbol", symbol[0]);
            }
            else if ()
            if (line.contains(":")) {
                String[] line_array = line.split(":");
                for (String split_string: line_array) {
                    // Truy vấn để kiểm tra
                    if (split_string.matches("(.*)^[\\d]+$(.*)")) {
                        json_err_msg.put("line", Integer.getInteger(split_string));
                    }
                    else if (split_string.matches("(.*)^(\\w+)\\.(java)$(.*)")) {
                        json_err_msg.put("className", split_string.split(".java")[0]);
                    }
//                    else if (split_string.matches("^\\<[\\w \\W ]*\\> but was$")) {
//
//                    }
                }
            }
        }
        return json_err_msg;
    }
}
