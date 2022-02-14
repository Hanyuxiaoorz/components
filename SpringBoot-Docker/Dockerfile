FROM adoptopenjdk/openjdk11
RUN  mkdir /app
WORKDIR /app
COPY ./target/SpringBoot-Docker-1.0.0.jar /app
ENV TZ="Asia/Shanghai"
ENV JAVA_OPS="-Xmx512M"
EXPOSE 8080
CMD java ${JAVA_OPS} -jar SpringBoot-Docker-1.0.0.jar