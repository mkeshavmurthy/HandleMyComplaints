# Test Automation

This repository contains Test automation for the Two Hoots. It uses Selenium, via a local Chrome Driver or 
a Remote Driver that connects to a Selenium Grid.

## Running using docker

In a terminal window, run the following to start a local Selenium Grid.

```shell script
docker-compose up -d
```

Next, execute the test from the project root using:

```shell script
docker run -it --rm  \
  -v "$(pwd)":/test-automation \
  -v ~/.m2/repository:/root/.m2/repository \
  -w /test-automation maven:3.6.3-jdk-11 \
  mvn test -DhubUrl=http://172.17.0.1:4444 \
    -DbrowserName=chrome \
    -DconfigPath=./env/stagging.properties
```
   
Note: Maven needs to download the internet so this will take some time on first run. The command will populate
your local Maven cache to speed things up on subsequent runs. 

## Running Java and Maven on host

To run the test on host you'll need to install Java (11+) and Maven. For this reason it's not recommended
unless you know what you're doing. Once you've installed Java, Maven and possibly the Chrome Driver, run test as above.

## Running using your host Chrome installation

To run tests against your host Chrome Browser you'll need to download the latest 
[Chrome Driver](https://chromedriver.chromium.org/downloads) for your platform. If you're running on Linux or 
Mac, ensure the Driver is executable.  

Specify the Chrome Driver when running the test.

```shell script
mvn test -DconfigPath=./env/stagging.properties -Dwebdriver.chrome.driver=/path/to/chromedriver
```

## CI using GitHubAction

To check on every push and Pull Request. Set-up the GitHubAction.yml
```shell script
name: Docker Compose Actions Workflow
on:
  push:
    branches: [ main ]
  pull_request:
    branches: [ main ]
jobs:
  build:
    runs-on: ubuntu-latest

    steps:
    - uses: actions/checkout@v2 # Checkout the code
    - name: Install Google Chrome # Using shell script to install Google Chrome
      run: |
       chmod +x ./InstallChrome.sh
        ./InstallChrome.sh
    - name: Install Docker # Using shell script to install Google Chrome
      run: |
       chmod +x ./installDocker.sh
        ./installDocker.sh
    - name: Run All Test in Docker # Using shell script to install Google Chrome
      run: |
       chmod +x ./RunDocker.sh
        ./RunDocker.sh
```