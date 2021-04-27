FROM openjdk:11
ADD target/accounting-0.0.1.jar /usr/share/accounting-0.0.1.jar
ENTRYPOINT ["java", "-jar", "/usr/share/accounting-0.0.1.jar"]