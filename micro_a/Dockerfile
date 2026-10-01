FROM eclipse-temurin:22-jdk AS buildstage

RUN apt-get update && \
    apt-get install -y maven

WORKDIR /app

COPY pom.xml .
COPY src /app/src
COPY Wallet_F35QHF3FOZC81P00 /app/wallet

ENV TNS_ADMIN=/app/wallet

RUN mvn clean package -DskipTests


FROM eclipse-temurin:22-jdk

COPY --from=buildstage /app/target/micro_a-0.0.1-SNAPSHOT.jar /app/micro_a.jar

COPY Wallet_F35QHF3FOZC81P00 /app/wallet

ENV TNS_ADMIN=/app/wallet
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/micro_a.jar"]