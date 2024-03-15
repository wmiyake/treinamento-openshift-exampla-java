# Use a imagem base do OpenJDK 17 no Red Hat Universal Base Image (UBI)
FROM registry.access.redhat.com/ubi8/openjdk-17

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia o arquivo JAR do diretório target do seu projeto para o diretório de trabalho do contêiner
COPY target/app-intsolutionss-java-example-0.0.1-SNAPSHOT.jar .

# Comando padrão para executar o aplicativo quando o contêiner for iniciado
CMD ["java", "-jar", "app-intsolutionss-java-example-0.0.1-SNAPSHOT.jar"]
