FROM java:8
COPY maven /
EXPOSE 8080
ENTRYPOINT exec java $JAVA_OPTS -jar /falcon-backup-restore.jar