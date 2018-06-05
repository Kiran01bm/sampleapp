#/bin/bash

# Feed Connection String and Other config via Env variables

# Build/Compile
javac -d /usr/src/apps/dataseeder/classes /usr/src/apps/dataseeder/src/SampleDataSeeder.java

# Run/Execute
java -Djava.net.preferIPv4Stack=true -cp /usr/src/apps/dataseeder/lib/mysql-connector-java-8.0.11/mysql-connector-java-8.0.11.jar:/usr/src/apps/dataseeder/classes SampleDataSeeder
