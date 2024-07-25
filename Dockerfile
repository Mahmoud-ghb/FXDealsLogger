# Use OpenJDK image to run the application
FROM openjdk:22-jdk-slim as build


WORKDIR /FXDealsLogger

COPY /target/*.jar ./java.jar

EXPOSE 8080

CMD ["java", "-jar", "java.jar"]
#
# # Expose port 8080
# EXPOSE 8080
#
# # The application's jar file
# ARG JAR_FILE=target/FXDealsLogger-0.0.1-SNAPSHOT.jar FXDealsLogger.jar
#
# # Add the application's jar to the container
# COPY ${JAR_FILE} FXDealsLogger.jar
#
# # Run the jar file
# ENTRYPOINT ["java", "-jar", "/FXDealsLogger.jar"]

# Set working directory
# WORKDIR /app
#
# # Copy pom.xml and download dependencies
# COPY pom.xml .
# RUN mvn dependency:go-offline -B
#
# # Copy source code and package the application
# COPY src ./src
# RUN mvn clean package -DskipTests
#
# # Use OpenJDK image to run the application
# FROM openjdk:17
#
# # Set working directory
# WORKDIR /app
#
# # Copy the packaged application from the build stage
# COPY --from=build /app/target/*.jar app.jar
#
# # Run the application
# ENTRYPOINT ["java", "-jar", "app.jar"]
