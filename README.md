# SPARQL dataset transformer:
This code will transform SPARQL queries based on different aproaches like(RDF reification, N-ary relations, Singleton property, Ndfluents) to Named Graphs.
#### Example:
This SPARQL query is based one RDF reification:
```
PREFIX rdf:  <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
SELECT * WHERE{
    ?st rdf:type rdf:statement.
    ?st rdf:subject ?s.
    ?st rdf:predicate ?p.
    ?st rdf:object ?o.
}
```
That SPARQL query will be transformed to a new query based on Named graph approach :
```
SELECT * WHERE{GRAPH ?st {?s ?p ?o .}}
```


#### Requirements:
1. JDK 1.8
2. Maven

First run this command on the project path to build the jar file:
```
$ mvn clean package
````

To execute the generated jar file:
```
$ java -jar target\SparqlTransform-1.0-SNAPSHOT-jar-with-dependencies.jar -t "query_type" -d "dataset_path" -q "SPARQL_query" -m "query_mapping" 
```
- **-q** : will take SPARQL query as an argument.
- **-t** : will take the SPARQL query type(reification,singleton,ndfluents,nary).
- **-d** : will take the path of the dataset that we want to use.
- **-m** : will take the metadata of the query we use it in ndfluents and n-ary relations.
- **-qf** : will take the path of a SPARQL query file.
- **-o** : will take a path to an output file to write the new query.
- **-mf** : will take the path of a metadata file.

You can check the web version [here](http://wdaqua-dataset-transformation.univ-st-etienne.fr/).
