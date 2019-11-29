[](https://github.com/jkonarze/converterProperties/workflows/.github/workflows/ci.yml/badge.svg)

[![codecov](https://codecov.io/gh/jkonarze/converterProperties/branch/master/graph/badge.svg)](https://codecov.io/gh/jkonarze/converterProperties)

### converterProperties

This project goal is to create a program, which converts any given data input (currently *CSV*) and output property 
files (currently *java properties*). Furthermore, a user can escape special characters with a desire escape sequence 
(currently *HTML escape sequence* `1` or *original value* `0`).



## Motivation

Copying translations from an Excel spreadsheets, one by one, to a java properties file is a very time consuming and 
prone for a human error process. The main goal of this project is to reduce the amount of time spend on a manual process
 so developers have more time for the actual development. 



## How to use

You can run it through a command prompt by following instructions, run from your IDE or run it as a 
jar. To run from your command prompt, navigate to a directory where you saved the project. Then cd into 
_src->main->java_ and run `javac Main.java` after that run `java Main`.  Currently you can only upload the *CSV* file and 
decide if you want to keep the original values (`0`) or escape special character using the *HTML escape sequence* 
(`1`). Please, make sure your data file is saved with `.csv` extension. To run it as a *jar* make sure to build it 
correctly; `mvn clean install` will create a jar file in your target folder. Navigate in your command prompt to your 
target folder and simply run `java -jar <nameOfTheJar>`. For example, `java -jar converterJavaProperties-1.0-SNAPSHOT
.jar`, note that the version number might change. 


Enjoy :)



## Contributors 

Everyone is welcome to improve this simple project. Please, fork the repo and raise the PR to get your code approved 
