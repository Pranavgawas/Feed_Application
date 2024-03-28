# java application
FROM openjdk:17-alpine
WORKDIR /urs/src/myapp
COPY . /urs/src/myapp/
CMD [ "java","-jar", "./Feed-0.0.1-SNAPSHOT.jar" ]