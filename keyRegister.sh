keytool -import -noprompt -trustcacerts -alias oracleords-service.oracle23c.svc.cluster.local -storepass changeit -keypass changeit -file $KEY_FILE_PATH -keystore /usr/local/openjdk-11/lib/security/cacerts
java -jar /opt/api/student-api.jar
