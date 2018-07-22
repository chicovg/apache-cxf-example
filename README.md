# apache-cxf-example
A simple WSDL-first Apache CXF example

## How to

### build it
```
maven clean package
```

### Run the server
```
mvn exec:java -Pserver
```

### Run the client (in a separate terminal)
```
mvn exec:java -Pclient
```

This example was heavily influenced by the examples posted [here](https://github.com/apache/cxf/tree/master/distribution/src/main/release/samples).
