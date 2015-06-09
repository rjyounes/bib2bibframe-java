package saxonquery;

import net.sf.saxon.Configuration;
import net.sf.saxon.query.StaticQueryContext;

/*
java -cp /Users/rjy7/Workspace/javatest/lib/saxon/951/saxon9he.jar net.sf.saxon.Query 
/Users/rjy7/Workspace/javatest/lib/marc2bibframe/xbin/saxon.xqy 
marcxmluri=/Users/rjy7/data/cul/bib/split/bib.001.1-20.xml baseuri=http://ld4l.library.cornell.edu/individual/
serialization=rdfxml usebnodes=false 
*/

public class SaxonQuery {

    public static void main(String[] args) {

        Configuration config = new Configuration();
//        StaticQueryContext staticContext = new StaticQueryContext();
//        QueryProcessor qp = new QueryProcessor(config, staticContext);
        

    }

}
