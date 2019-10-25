FROM tomcat:9.0.27-jdk11-corretto
LABEL maintainer="alexander.nikiforovk@gmail.com"

CMD ["catalina.sh", "run"]

ARG HELLO_AZURE_VERION
COPY build/artifacts/hello-azure-${HELLO_AZURE_VERION}.war /usr/local/tomcat/webapps/hello-azure.war

