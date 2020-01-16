package compiler_error;

import org.json.JSONObject;

import java.util.regex.Pattern;

public class Compiler_Error_Check {

    // Phân tích lỗi từ chuỗi thành JSON
    public JSONObject Jsonify(String input) {
        Pattern regex = Pattern.compile("\n", Pattern.MULTILINE);

        // Tạo phần tử JSON để lưu lỗi
        JSONObject json_err_msg = new JSONObject();
        String[] compile_error_arr = regex.split(input);

        // Duyệt chuỗi bằng mảng
        for (String line: compile_error_arr) {
            // Phân tích chuỗi vd: symbol: class Account
            if (line.matches("(.*)^(symbol):(.*)")) {
                json_err_msg.put("symbol", line.split("symbol:")[1].trim());
            }
            // Phân tích chuỗi vd: location: class MyTest
            else if (line.matches("(.*)^(location):(.*)")) {
                json_err_msg.put("className", line.split("location:")[1].split("class")[1].trim());
            }
            else if (line.contains(":")) {
                String[] line_array = line.split(":");

                // Phân tích chuỗi vd: MyTest.java:50: error: cannot find symbol
                for (String split_string: line_array) {
                    if (split_string.trim().matches("(.*)^[\\d]+$(.*)")) {
                        json_err_msg.put("line", split_string);
                    }
                    else if (split_string.trim().matches("(.*)^(\\w+)\\.(java)$(.*)")) {
                        json_err_msg.put("className", line_array[0].split(".java")[0].trim());
                    }
                    else if (split_string.trim().matches("(.*)^(error)$(.*)")) {
                        json_err_msg.put("message", line_array[line_array.length - 1].trim());
                    }
                }
            }
        }
        return json_err_msg;
    }
}
