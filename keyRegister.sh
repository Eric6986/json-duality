keytool -import -noprompt -trustcacerts -alias $ORDS_DNS -storepass changeit -keypass changeit -file $ORDS_KEY_FILE_PATH -keystore /usr/local/openjdk-11/lib/security/cacerts
keytool -import -noprompt -trustcacerts -alias $MONGODB_DNS -storepass changeit -keypass changeit -file $MONGODB_KEY_FILE_PATH -keystore /usr/local/openjdk-11/lib/security/cacerts
java -jar /opt/api/student-api.jar
