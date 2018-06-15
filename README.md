# Marama Editor

## Development

This project is based on Scala and sbt. To start developing you can import the project by opening the build.sbt file inside the project root with an IDE like IntelliJ or Eclipse.

## Documentation

It is recommended before you start development to read the technical design document that is provided in the source. 
  
## Building a .jar

To build the project into a jar artifact the following command needs to be executed in the project root.
```bash
> sbt assembly
```
This will build `MaramaEditor.jar` in the `target/scala-2.12/` directory.
