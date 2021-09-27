##repo
    - repository name: project
    - https://github.com/ophingo/project.git
    
MYSQL Database Details
 ==============================
    - Server: localhost
    - Port 3308
    - Database name: gerry_test_db
    - Username: username
    - Password: password
    
##ports
- service discovery : 8761
- user microservice : 9095
- application application.gateway : 9999

 Deployment Commands
===========================
- scp -rv coding-assignment-app/users-microservice/target/users-service-1.0-SNAPSHOT.jar developer@server.ip:/data/apps/services/users-service-1.0-SNAPSHOT.jar
- scp -rv coding-assignment-infrastructure/application-application.gateway/target/application-application.gateway-1.0-SNAPSHOT.jar developer@server.ip:/data/apps/services/application-application.gateway-1.0-SNAPSHOT.jar
- scp -rv coding-assignment-infrastructure/discovery-server/target/discovery-server-1.0-SNAPSHOT.jar developer@server.ip:/data/apps/services/discovery-server-1.0-SNAPSHOT.jar


Launch Services |
================
1. ./data/apps/services/discovery-server-1.0-SNAPSHOT.jar &
2. ./data/apps/services/application-application.gateway-1.0-SNAPSHOT.jar &
3. ./data/apps/services/users-service-1.0-SNAPSHOT.jar &


   
