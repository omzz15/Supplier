# Java Supplier
The name is a little misleading, this is actually more about functions (called modifiers) that allow you to modify data in a variety of ways. These modifiers can be linked together and then turned into a supplier by supplying a base supplier. This allows for complex modification and monitoring of data streams.

## What does it do?
- Provide basic interfaces for creating custom modifiers
- provide basic utilities to help modify data streams (ex: number-converting methods)
- Allow for a variety of monitoring (ex: logging or edge detection) and modification (ex: conditional modification) functions with pre-build modifiers

## Future Additions
- More examples
- Community Requests(your input is always important)

# How To Install
There are multiple ways to use this library, but it was primarily made for Maven/Gradle so that will be the most up to date. There will also be releases on GitHub, but I would recommend using Maven.

## To Install with Maven:
1. In your project, make sure you can get libraries from Maven Central(This should be automatically available in maven projects)
2. Add the library to the project(by default it should be in the dependencies section of pom.xml)
   ```
   <dependency>
      <groupId>io.github.omzz15</groupId>
      <artifactId>supplier</artifactId>
      <version>2.0.0-RELEASE</version>
   </dependency>
   ```
3. Enjoy :)

## To Install with Gradle
1. Add the mavenCentral() repository to the repositories section(it should be in build.gradle by default)
2. Add the library to the gradle using:
    ```
    implementation 'io.github.omzz15:supplier:2.0.0-RELEASE'
    ```
3. Enjoy :)

# How To Use
Check examples [here](./src/test/java/examples)
