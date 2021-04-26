FROM openjdk11:latest
ADD target/accounting-0.0.1.jar /usr/share/accounting-0.0.1.jar
ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/accounting-0.0.1.jar"]