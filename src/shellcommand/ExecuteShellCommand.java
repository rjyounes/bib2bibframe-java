package shellcommand;

public class ExecuteShellCommand {

    public static void main (String[] args) {
        
        String marcxmluri = args[0];

        // Could extend this framework to execute other commands by passing in
        // the classname. Use interface or abstract class ShellCommand on 
        // which others are based.
        String output = Marcxml2BibframeShellCommand.execute(marcxmluri);
        System.out.println(output);
        
    }
}
