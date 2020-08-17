# Spring-Tutorial
This is tutorial for Spring Core, Spring boot, Spring Data, Spring Security and monitoring.
## 1. Spring Core Configuration
|List branches|
|-----------|
|[**🎉 No using spring context to configure beans**][1.1]|
|[**🎉 Using XML to configure beans**][1.2]|
|[**🎉 Spring bean life cycle**][1.3]|
|[**🎉 Using Annotation to configure beans**][1.4]|

[1.1]: https://github.com/eoet/Spring-Tutorial/tree/spring-boot/1.starter
[1.2]: https://github.com/eoet/Spring-Tutorial/tree/spring-boot/2.xml-configuration
[1.3]: https://github.com/eoet/Spring-Tutorial/tree/spring-boot/3.spring-bean-life-cycle
[1.4]: https://github.com/eoet/Spring-Tutorial/tree/spring-boot/4.annotations-configuration

# 2. Spring Data

StackEdit stores your files in your browser, which means all your files are automatically saved locally and are accessible **offline!**

## 2.1 JDBC

1. Branch spring-data/1.jdbc-mysql:
You can see in src/main/resouces/slide, there are 3 images to describe JDBC structure.
So, we have several Driver that wrap JDBC API and use it to call to Database. 
Read file ## **JDBCConnection.java** and you can see every related files.

2. Branch spring-data/2.jdbc-posgresql:
I use the same code in EmployeeRepository that is written for Mysql.
I just modify DB_URL, USER_NAME and PASSWORD to get Connection to Posgresql.
So, I can write once for Mysql and it's able to reuse in multiple Database. Cool!!!

## 2.2 Hibernate
### Branch spring-data/3.hibernate
Hibernate is a ORM Framework that let you interact to Database easily. You don't need to open/close connection, write SQL code, ... that are cons of JDBC.
See in src/main/resources/slide/orm and hibernate structure images, you can see in these images that Hibernate need JDBC to connect to DB.
Read file **[hibernate.cfg.xml]**, **[HibernateMain.java]** and run this file, you will know how it works.
I use Mysql in this example.

## 2.3 Spring Data

### Branch spring-data/4.spring-jpa
Read file **[application.properties]**, **[SpringDataApplication.java]** and run this file, see in Console.
I'd like you to discover every components I use in this example and you will under
