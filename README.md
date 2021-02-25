# Opera Application
1. [About Application](#about-application)
2. [Application Structure](#application-structure)
3. [Technologies Used](#technologies-used)
4. [Running the Application](#running-the-application)
5. [Author's contacts](#authors-contacts)
---
# About Application
This application is a prototype of an online store, where users can buy tickets to the performances.
***
# Application Structure
Application is based on the N-tier architecture. Application has been developed according to SOLID principles.
If you look at the project, you will find there:
- DAO layers;
- Service layers;
- Controllers layers;
- Models;
- Mappers to work with the JSON format;
- Configurations to the Spring Security, MVC, etc.

Also, this project contains 2 roles for users. The first role is User. User can:
- Register on the Application;
- Log in to the Application;
- Add tickets for Performance to a shopping cart;
- Complete his order;
- View the history of his order;

The second role is Administrator. He can:
- All actions of the usual user;
- Add new stages;
- Add new Performance sessions;
- Add new Performances;
- Update information about Performance sessions;
- Delete information about Performance sessions;

Near you can see, a UML diagram of the project:
![package_model](https://github.com/NikolayFatkullin/pictures/blob/master/Package%20model.png)

***
# Technologies Used
- Spring MVC;
- Spring Security;
- Hibernate;
- MySql;
- Java Core;
- Jackson;
- Apache Tomcat;
- Apache Maven;
***
# Running the Application
1. Download and Install [JDK](https://www.oracle.com/java/technologies/javase-downloads.html) (If you don't do it yet);
2. Download and Install servlet container([Tomcat](https://tomcat.apache.org/download-80.cgi), [Jetty](https://www.eclipse.org/jetty/download.php), etc.);
3. Download and Install [MySql Server](https://dev.mysql.com/downloads/workbench/);
4. Create a schema in the MySql Server with a name: "opera";
5. Also, you need to change the root name and password in the file
   db.properties to yours;
6. Run application;
7. To make tests more comfortable, you can download a [Postman application](https://www.postman.com/downloads/);
***
# Author's contacts
[e-mail](http://fatkullinmykola@gmail.com) - fatkullinmykola@gmail.com

[LinkedIn](https://www.linkedin.com/in/mykola-fatkullin-b56350206/) - Fatkullin Mykola;

[Skype](https://join.skype.com/invite/bpH8IGxUune1) - Fatkullin Mykola;

