**This is the FTC version of the library meaning this uses java 8 and has instructions for installing this to an FTC project. For the normal version go [here](https://github.com/omzz15/Supplier)**

# Java Supplier
The name is a little misleading, this is actually more about functions (called modifiers) that allow you to modify data in a variety of ways. These modifiers can be linked together and then turned into a supplier by supplying a base supplier. This allows for complex modification and monitoring of data streams. In FTC, this is especially useful for modifying sensor data, and allowing for the flexible use of controller inputs (ex: easily switch between a latched button and regular button). 

## What does it do?
- Provide basic interfaces for creating custom modifiers
- provide basic utilities to help modify data streams (ex: number-converting methods)
- Allow for a variety of monitoring (ex: logging or edge detection) and modification (ex: conditional modification) functions with pre-build modifiers
- Allow for easy chaining of modifiers
- Modification of sensor data and controller inputs

## Future Additions
- More examples
- Community Requests(your input is always important)

# How To Install
There are multiple ways to use this library, but it was primarily made for Maven/Gradle so that will be the most up to date. There will also be releases on GitHub, but I would recommend using Maven or gradle as FTC projects already use them meaning you only need to add a few lines.

## To Install with Gradle
1. Go to the TeamCode folder in your project and open build.gradle 
2. Add maven central to the repositories section (it should be in there by default)
    ```
    repositories {
        mavenCentral()
    }
    ```
3. Add the library to the dependencies section:
    ```
    dependencies {
        implementation 'io.github.omzz15:supplier:2.0.0-FTCRELEASE'
    }
    ```
4. Enjoy :)

## To Install with Maven:
**FTC does not use maven, so follow the installation with gradle instructions if you are using FTC**
1. In your project, make sure you can get libraries from Maven Central(This should be automatically available in maven projects)
2. Add the library to the project(by default, it should be in the dependencies section of pom.xml)
   ```
   <dependency>
      <groupId>io.github.omzz15</groupId>
      <artifactId>supplier</artifactId>
      <version>2.0.0-FTCRELEASE</version>
   </dependency>
   ```
3. Enjoy :)

# How To Use
Check examples [here](./src/test/java/examples)
