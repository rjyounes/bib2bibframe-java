package shellcommand;

import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;

public class ExecuteShellCommand {
    
    public static void main (String[] args) {
        String marcxmluri = args[0];

        String output = execute(marcxmluri);
        System.out.println(output);
        
    }
    
    public static String execute(String marcxmluri) {

        String output = new String();
        System.out.println(marcxmluri);
        
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
            String outputDirName = format.format(new Date());
            // If supporting multiple RDF formats, "rdfxml" will vary depending
            // on format.
            // String parentName = System.getProperty("user.dir") + "/out/" + outputDirName + "/bibframe/rdfxml";
            String parentName = System.getProperty("user.dir") + "/out/"; // for debugging
            File parent = new File(parentName);
            parent.mkdirs();
            
            String basename = FilenameUtils.getBaseName(marcxmluri);
            File outputFile = new File(parent, basename + ".rdf");   
            
            // Working directory; default is the current working directory of 
            // the current process.
            pb.directory();
            //pb.directory(new File("/Users/rjy7/Workspace/bib2bibframe-java/"));
            
            // Required even though we're just using the default environment
            // (copy of the environment in the current process).
            // Assign to a variable if we want to set values.
            Map<String, String> env = pb.environment();
            //pb.environment();
            
            pb.redirectOutput(Redirect.appendTo(outputFile));
            //pb.redirectOutput(Process.getInputStream());
            
            // Process p = pb.start();
            pb.start();
            
            // TODO Read in output file contents as String and return
            // If we don't want the file, r Process.getInputStream()
            // This should read the contents of outputFile into a String, but
            // it doesn't.
            //output = FileUtils.readFileToString(outputFile);
            //outputFile.delete();
            

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        
        return output;


    }
    


}
