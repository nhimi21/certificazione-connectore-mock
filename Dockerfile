# Use an official Amazon Corretto image as the base image
FROM amazoncorretto:11

# Set the working directory inside the container
WORKDIR /app

# Copy the application JAR file into the container
# Replace 'target/*.jar' and this get the actual name of JAR file
COPY target/*.jar app.jar

# Expose the port the app runs on
# Replace '8080' with your application's port if different
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
