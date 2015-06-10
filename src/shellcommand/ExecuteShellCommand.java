package shellcommand;

import java.io.File;

import org.apache.commons.lang3.StringUtils;

public class ExecuteShellCommand {

    public static void main(String[] args) {
        
        String marcxmluri = args[0];

        // Could extend this framework to execute other commands by passing in
        // the classname. Use interface or abstract class ShellCommand on 
        // which others are based. Or more simply: pass in the entire command
        // and split it on whitespace.
        String output = Marcxml2BibframeShellCommand.execute(marcxmluri);
        System.out.println(output);
        
    }
    
}
