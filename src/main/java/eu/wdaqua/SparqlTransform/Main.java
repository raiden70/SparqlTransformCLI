package eu.wdaqua.SparqlTransform;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        QueryTransformer queryTransformer=new QueryTransformer();
        FileIO fileIO=new FileIO();
        SparqlCli cli=new SparqlCli(args);
        queryTransformer.setDataSet(cli.getDataset());
        if(cli.getQueryFile()!=null)
        {
                String query = fileIO.readFile(cli.getQueryFile());
                queryTransformer.setQuery(query);
        }
        else
            queryTransformer.setQuery(cli.getQuery());
        String meta="";
        if(cli.getMetaFile()!=null)
            meta = fileIO.readFile(cli.getMetaFile());
        else
            meta=cli.getMeta();
        String results=queryTransformer.conversion(cli.getType(),meta);
        if(cli.getQueryOut()!=null)
        fileIO.writeFile(cli.getQueryOut(),results);
        queryTransformer.execQuery(results);
    }
}
