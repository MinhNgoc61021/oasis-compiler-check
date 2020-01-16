package string_process;

import java.util.regex.Pattern;

public class String_Process {
    private String[] error;

    public String[] toErrorArray(String compiler_error) {
        Pattern regex = Pattern.compile("(?<=(.))\\n(.+\\.java)", Pattern.MULTILINE);
        error = regex.split(compiler_error);
        return error;
    }
}
