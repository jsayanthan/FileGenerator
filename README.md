File Generator Application
=========================
Java program to accept a variable x. x can be any number from 1 to 230-1. Generate a file with x number of lines and each line consist of a string that is unique with 100 characters long

Technologies:
----

- Java 8
- Maven 3+ ( [Build tool - Reference](http://maven.apache.org))

Running the Application locally
-----------------
1. Open terminal
2. Navigate to project folder(Folder name :- FileGenerator)
3. Inside the project folder run the following  command 
```
mvn clean install
```
4.Run the application using following command
```
java -jar target/FileGenerator-1.0-SNAPSHOT.jar
```
5. To find the output file, please locate to the following directory - src/main/resources/output_file.txt

NOTE :- Test cases are included under the test folder. If you need to run the test cases execute the following command
        ```
        mvn test
        ```

Running the Application in Docker container 
-----------------
NOTE :- Docker should be installed in the environment.
1. To create the docker image, please follow the below instructions
- Open the terminal and navigate to project folder (Folder name :- FileGenerator)
- To build the image execute the following command 
```
 docker build -t filegenerator:v1.0 .
```
- To list the docker images execute  the following command 
```
 docker images
```
- Find the relevant image by tag(Ex :- filegenerator:v1.0) and copy the docker image id.

2. To run the Docker image, please execute the below command by replacing the image id
```
 docker run -it <image_id>
```
3. To find the output file, please follow the below steps 
- execute the following command to list the running container 
```
 docker ps
```
- Find the relevant container and execute the following command to enter into the Docker container 
```
 docker exec -it <container-name> sh
```
- To display the output data, please execute the below command 
```
 cat src/main/resources/output_file.txt
```