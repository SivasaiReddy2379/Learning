FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app
COPY . .

RUN javac PalindromeExample.java

CMD ["java", "PalindromeExample"]
