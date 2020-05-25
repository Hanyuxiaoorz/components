FROM adoptopenjdk/openjdk11:latest
RUN  mkdir /app
WORKDIR /app
COPY ./JAVA_JAR /app
EXPOSE 8080
CMD ["java", "-jar", "JAVA_JAR"]