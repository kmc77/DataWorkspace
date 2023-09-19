FROM openjdk:17-ea-11-jdk-slim
COPY ./target/myhome4-0.0.1-SNAPSHOT.war /security.war
copy ./icecream.png  /usr/src/icecream.png 
ENTRYPOINT ["java", "-jar", "security.war"]