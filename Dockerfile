FROM azul/zulu-openjdk-alpine:11

# Copy jar file into the image.
COPY target/movie-0.0.1-SNAPSHOT.jar movie-0.0.1-SNAPSHOT.jar

#  Executable to start during container booting.
ENTRYPOINT ["java","-jar","/movie-0.0.1-SNAPSHOT.jar"]
