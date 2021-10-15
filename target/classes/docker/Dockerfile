FROM openjdk:11

# Default to UTF-8 file.encoding
ENV LANG C.UTF-8

RUN mkdir -p /opt
ADD maven/opt/YokudlelaMenu.jar /opt/YokudlelaMenu.jar


EXPOSE 8080

ENTRYPOINT java -jar /opt/YokudlelaMenu.jar -Djava.net.preferIPv4Stack=true
