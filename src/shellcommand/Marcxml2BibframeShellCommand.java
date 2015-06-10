package shellcommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Marcxml2BibframeShellCommand {
      
    // TODO Pass in more parameters rather than hard-coding the values. If we're
    // not keeping the file but returning the output as a string, that would 
    // work, since we don't care about the directory structure.
    public static String execute(String marcxmluri) {

        String output = new String();
        
        try {       
            
            ProcessBuilder pb = new ProcessBuilder("/usr/bin/java",
                    "-cp",
                    "/Users/rjy7/Workspace/bib2bibframe-java/lib/saxon951/saxon9he.jar",
                    "net.sf.saxon.Query",
                    "/Users/rjy7/Workspace/bib2bibframe-java/lib/marc2bibframe/xbin/saxon.xqy",
                    "marcxmluri=" + marcxmluri,
                    "baseuri=http://ld4l.library.cornell.edu/individual/",
                    "serialization=rdfxml"       
                    );

            
            // Working directory; default is the current working directory of 
            // the current process.
            pb.directory();
            
            // Required even though we're just using the default environment
            // (copy of the environment in the current process).
            // Assign to a variable if we want to set values.
            // Map<String, String> env = pb.environment();
            pb.environment();
            
            // Send output to a file instead of building a string
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
