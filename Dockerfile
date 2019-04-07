FROM java:8

WORKDIR /app

COPY target/student-*.jar api-student.jar

COPY target/student-*.jar api-student.jar

EXPOSE 9090

CMD ["java", "-jar", "api-student.jar"]
