FROM openjdk:11-jre-slim
ENV RUN_FILE="keyRegister.sh"
USER root
COPY $RUN_FILE /opt/api/
RUN addgroup --system spring && adduser --system spring -ingroup spring
RUN chmod ug+x /opt/api/*.sh && chown spring:spring /opt/api/*.sh && chown spring:spring /usr/local/openjdk-11/lib/security/cacerts && chmod 644 /usr/local/openjdk-11/lib/security/cacerts
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /opt/api/student-api.jar
ENV PORT 8080
EXPOSE 8080
CMD /opt/api/$RUN_FILE
