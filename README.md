1) git clone https://github.com/JMadhavi/seleniumautomation
2) Enter your gmail user name and password values in test.properties file.(seleniumautomation->src->resources->test.properties).Test assumes that 2 factor verification is not set for user.Test logs in gmail using username, password provided.Asserts that user is looged in and then logs out.
3) To run test ./gradlew clean -Dbrowser=$browsertype -Durl=https://mail.google.com -Dprpfile=test.properties mats   
  e.g. ./gradlew clean -Dbrowser=chrome -Durl=https://mail.google.com -Dprpfile=test.properties mats
  Value for -Dbrowser can be chrome, firefox,safari,internetexplorer.
