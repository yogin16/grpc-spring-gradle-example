FROM java:8
RUN mkdir -p /grpc-hello
COPY ./ /grpc-hello
WORKDIR /grpc-hello
RUN apt-get -y update && \
    apt-get install -y --no-install-recommends wget unzip
RUN wget https://services.gradle.org/distributions/gradle-3.4.1-bin.zip
RUN mkdir /opt/gradle
RUN unzip -d /opt/gradle gradle-3.4.1-bin.zip
ENV PATH="/opt/gradle/gradle-3.4.1/bin:${PATH}"
RUN gradle build
CMD ["gradle", "execute"]