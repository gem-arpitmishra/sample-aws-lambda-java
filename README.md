## Introduction

A simple java MAVEN based project to demonstrate how Java functions can be created and deployed in AWS Lambda

## Requirements
Maven Shade plugin is used for building the lambda function.

## Instructions
create deployment file by running `mvn clean package shade:shade` and the jar file will be created under the target folder.

1. Go to AWS Lambda and create a new function
2. choose "Author from scratch" option
3. Give a Function name and Runtime choose Java 8
4. Create Function
5. Edit Runtime Settings and give handler `com.aws.lambda.LambdaMethodHandler::handleRequest`
6. Function code section -> Action -> Upload your jar file
7. Deployed

## Testing
1. Click on your lambda function from lists and then click on “Test” button
2. A popup window will appear which contains dummy value for sending data. Override the data with "Aurobinda"
3. Click on “Save” button
4. Now click on "Test" button you'll be able to see the response 
```"Hello World - Aurobinda"```

