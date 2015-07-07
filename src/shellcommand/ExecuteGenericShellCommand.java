package shellcommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class ExecuteGenericShellCommand {


    public static void main(String[] args) {
        
        // String marcxmluri = args[0];

        // Could extend this framework to execute other commands by passing in
        // the classname. Use interface or abstract class ShellCommand on 
        // which others are based. Or more simply: pass in the entire command
        // and split it on whitespace.
        // String output = Marcxml2BibframeShellCommand.execute(marcxmluri);
        
        String output = execute(args[0]);
        System.out.println(output);
        
    }
    
    public static String execute(String command) {
        
        String output = new String();
        List<String> args = Arrays.asList(command.split(" "));

        try { 
            
            ProcessBuilder pb = new ProcessBuilder(args);
            
            // Working directory; default is the current working directory of 
            // the current process.
            pb.directory();
            
            // Required even though we're just using the default environment
            // (copy of the environment in the current process).
            // Assign to a variable if we want to set values.
            // Map<String, String> env = pb.environment();
            pb.environment();
            
            // Send output to a file instead of building a string.
            // outputFile = new File(...);
            //pb.redirectOutput(Redirect.appendTo(outputFile));
            
            Process p = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    p.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String line = null;
            String lineSeparator = System.getProperty("line.separator");
            while ( ( line = reader.readLine()) != null) {
                builder.append(line + lineSeparator);
            }
            output = builder.toString();
        
    
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
      
        
        return output;
    }
    
}
