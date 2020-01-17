package string_process;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Pattern;

// xử lý chuỗi nhập vào thành mảng/danh sách
public class String_Process {
    private String[] compiler_error_array;
    private List<String> false_test_list;

    public String[] toCompilerErrorArray(String compiler_error) {
        Pattern regex = Pattern.compile("(?<=(.))\\n(.+\\.java)", Pattern.MULTILINE);
        compiler_error_array = regex.split(compiler_error);
        return compiler_error_array;
    }
    public List<String> toFalseTestArray(String false_text) {
        false_test_list = new ArrayList<>();
        Pattern regex = Pattern.compile("\n", Pattern.MULTILINE);
        String newLine = System.getProperty("line.separator");
        String[] false_test_array = regex.split(false_text);
        Queue<String> each_error_queue = new LinkedList<>();
        int expected_count = 0;

        for (String line: false_test_array) {
            // khi gặp expected
            if (line.contains("expected:")) {
                expected_count++;
                // nếu expected gặp lần đầu thì tăng lên, khi đó lưu vào queue
                if (expected_count == 1) {
                    each_error_queue.add(line);
                }
                // nếu gặp trên 1 lần, tức là khi gặp lỗi mới thi đẩy hết chuỗi chứa trong queue vào error_string
                // sau khi duyệt hết queue thì đẩy error_string vào false_test_list
                else {
                    //
                    StringBuffer error_string = new StringBuffer();
                    for (Object error_each_line: each_error_queue) {
                        error_string.append(error_each_line.toString()).append(newLine);
                    }
                    each_error_queue.clear();
                    each_error_queue.add(line);
                    false_test_list.add(error_string.toString());
                }
            }
            // nếu ko có cứ đẩy vào queue
            else {
                each_error_queue.add(line);
            }

        }
        return false_test_list;
    }
}
