FROM oraclelinux:8.8

RUN dnf -y install wget && \
    dnf -y install unzip && \
    cd /tmp && \
    wget https://oca.opensource.oracle.com/gds/GRAALVM_EE_JAVA17_22_3_2/graalvm-ee-java17-linux-amd64-22.3.2.tar.gz && \
    tar -xzf graalvm-ee-java17-linux-amd64-22.3.2.tar.gz && \
    mv graalvm-ee-java17-22.3.2/ /opt/graalvm-java17/

ENV JAVA_HOME=/opt/graalvm-java17
ENV PATH="${PATH}:${JAVA_HOME}/bin"

RUN mkdir -p /tmp/ords && \
    cd /tmp/ords && \
    wget https://download.oracle.com/otn_software/java/ords/ords-23.1.3.137.1032.zip && \
    unzip ords-23.1.3.137.1032.zip && \
    rm -rf ords-23.1.3.137.1032.zip && \
    cd .. && \
    mv ords/ /opt/ords/

ENV PATH="${PATH}:/opt/ords/bin"

ARG ORACLE_ADMIN_USER_ARG
ARG ORACLE_SERVICE_ARG
ARG ORACLE_HOST_ARG
ARG ORACLE_PORT_ARG
ARG ORDS_USER_ARG
ARG ORDS_PWD_ARG
ARG ORACLE_PWD_ARG
ARG ORDS_HTTPS_PORT_ARG
ARG ORDS_HTTP_PORT_ARG
ARG ORDS_CERT_ARG
ARG ORDS_CERT_KEY_ARG
ARG ORDS_HOME_ARG
ARG ORDS_CONFIG_ARG

ENV ORACLE_ADMIN_USER=$ORACLE_ADMIN_USER_ARG
ENV ORACLE_SERVICE=$ORACLE_SERVICE_ARG
ENV ORACLE_HOST=$ORACLE_HOST_ARG
ENV ORACLE_PORT=$ORACLE_PORT_ARG
ENV ORDS_USER=$ORDS_USER_ARG
ENV ORDS_PWD=$ORDS_PWD_ARG
ENV ORACLE_PWD=$ORACLE_PWD_ARG
ENV ORDS_HTTPS_PORT=$ORDS_HTTPS_PORT_ARG
ENV ORDS_HTTP_PORT=$ORDS_HTTP_PORT_ARG
ENV ORDS_CERT=$ORDS_CERT_ARG
ENV ORDS_CERT_KEY=$ORDS_CERT_KEY_ARG
ENV ORDS_HOME=$ORDS_HOME_ARG
ENV ORDS_CONFIG=$ORDS_CONFIG_ARG

WORKDIR $ORDS_CONFIG_ARG
ENV RUN_FILE="newrunOrds.sh"
COPY $RUN_FILE $ORDS_HOME/

RUN chmod ug+x $ORDS_HOME/*.sh

EXPOSE 27017

CMD $ORDS_HOME/$RUN_FILE
