# Using delvelin plugin in Spring projects

## Setup
```groovy
plugins {
    id 'org.springframework.boot' version '3.0.6'
    id 'io.spring.dependency-management' version '1.1.0'
    id 'java'
    id 'io.github.hangga.delvelin' version '0.0.18-beta1'
}
```
## Configuration
```groovy
delvelin {
    outputFileFormat = 'HTML' // Options: LOG, JSON, HTML
    showDate = true
    showSaveDialog = false
}
```
## Running the Analysis
Open terminal and run the delvelinScan task to analyze our project:
```shell
./gradlew delvelinScan
```
If we are using Intellij IDEA, we can also use the gradle menu in the sidebar:

<img width="350" src="https://github.com/hangga/delvelin/blob/main/delvelin-scan-gradle-menu.png?raw=true" alt="sidebar"/>
