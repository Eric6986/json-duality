# json-duality
json-duality


docker build --platform linux/amd64 --build-arg ORACLE_ADMIN_USER_ARG="SYS" --build-arg ORACLE_SERVICE_ARG="freepdb1" --build-arg ORACLE_HOST_ARG="oracledb" --build-arg ORACLE_PORT_ARG="1521" --build-arg ORDS_USER_ARG="ORDS_PUBLIC_USER" --build-arg ORDS_PWD_ARG="abc123" --build-arg ORACLE_PWD_ARG="abc123" --build-arg ORDS_HTTPS_PORT_ARG="8443" --build-arg ORDS_HTTP_PORT_ARG="8080" --build-arg ORDS_CERT_ARG="/etc/ords/keystore/testing.mongodb.der" --build-arg ORDS_CERT_KEY_ARG="/etc/ords/keystore/testing.mongodb-key.der" --build-arg ORDS_HOME_ARG="/opt/ords" --build-arg ORDS_CONFIG_ARG="/etc/ords/config" -t oracleords:latest -f Dockerfile .