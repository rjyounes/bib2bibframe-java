package shellcommand;

import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.commons.io.FileUtils;

public class ExecuteShellCommand1 {
    
    public static void main (String[] args) {
        String marcxmluri = args[0];

        String output = execute(marcxmluri);
        System.out.println(output);
        
    }

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
 
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd-HHmmss");
            File outputFile = new File(format.format(new Date())); 
            pb.directory(new File("/Users/rjy7/Workspace/bib2bibframe-java"));
            Map<String, String> env = pb.environment();
            // TODO Redirect to input stream instead (Process.getInputStream();
            pb.redirectOutput(Redirect.appendTo(outputFile));
            Process p = pb.start();
            // TODO Read in output file contents as String and return
            // If we don't want the file, r Process.getInputStream()
            // This should read the contents of outputFile into a String, but
            // it doesn't.
            output = FileUtils.readFileToString(outputFile);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        
        return output;


    }
    


}
