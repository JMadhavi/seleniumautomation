git clone https://github.com/JMadhavi/seleniumautomation
Enter your gmail user name and password values in userName, password test.properties file.(seleniumautomation->src->resources->test.properties)
To run test ./gradlew clean -Dbrowser=$browsertype -Durl=https://mail.google.com -Dprpfile=test.properties mats   
e.g. ./gradlew clean -Dbrowser=chrome -Durl=https://mail.google.com -Dprpfile=test.properties mats
Value for -Dbrowser can be chrome, firefox,safari,internetexplorer
