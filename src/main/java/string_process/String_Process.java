package string_process;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Pattern;

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
            if (line.contains("expected:")) {
                expected_count++;
                if (expected_count == 1) {
                    each_error_queue.add(line);
                }
                else {
                    StringBuffer error_string = new StringBuffer();
                    for (Object error_each_line: each_error_queue) {
                        error_string.append(error_each_line.toString()).append(newLine);
                    }
                    each_error_queue.clear();
                    each_error_queue.add(line);
                    false_test_list.add(error_string.toString());
                }
            }
            else {
                each_error_queue.add(line);
            }

        }
        return false_test_list;
    }
}
