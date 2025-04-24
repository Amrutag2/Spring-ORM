# 🌿 Spring ORM with JDBC & Hibernate Integration

This project demonstrates how to integrate **Spring ORM** with **Hibernate** and **MySQL** using **XML-based configuration**. It covers a full ORM workflow including data source setup, session factory creation, entity management, and transaction handling through Spring Framework.

---

## 🔍 Overview: Spring ORM Integration Flow

Spring ORM (Object Relational Mapping) bridges your Java application and the database using Hibernate. It provides a cleaner abstraction for managing persistent data, transactions, and database interaction.

This project demonstrates:

- Connecting to a MySQL database
- Managing Hibernate sessions
- Performing CRUD operations on the `Student` entity
- Handling transaction management declaratively

---

## 🧱 Spring Configuration Breakdown

### 🛢️ 1. `DriverManagerDataSource` - JDBC Configuration

```xml
<bean class="org.springframework.jdbc.datasource.DriverManagerDataSource" name="ds">
    <property name="driverClassName" value="com.mysql.cj.jdbc.Driver"/>
    <property name="url" value="jdbc:mysql://localhost:3306/springjdbc?useSSL=false&amp;allowPublicKeyRetrieval=true"/>
    <property name="username" value="root"/>
    <property name="password" value="Amu@0204"/>
</bean>
Purpose:
Provides JDBC connectivity. This bean connects to MySQL and is later injected into the Hibernate SessionFactory.

🏭 2. LocalSessionFactoryBean - Hibernate SessionFactory Configuration
xml
Copy
Edit
<bean class="org.springframework.orm.hibernate5.LocalSessionFactoryBean" name="localSessionFactory">
    <property name="dataSource" ref="ds"/>
    <property name="hibernateProperties">
        <props>
            <prop key="hibernate.dialect">org.hibernate.dialect.MySQLDialect</prop>
            <prop key="hibernate.show_sql">true</prop>
            <prop key="hibernate.hbm2ddl.auto">update</prop>
        </props>
    </property>
    <property name="annotatedClasses">
        <list>
            <value>com.spring.orm.entities.Student</value>
        </list>
    </property>
</bean>
Purpose:
Creates the SessionFactory which Hibernate uses to perform all database operations such as CRUD, queries, and transactions.

🧰 3. HibernateTemplate - Simplifies Hibernate Operations
xml
Copy
Edit
<bean class="org.springframework.orm.hibernate5.HibernateTemplate" name="hibernateTemplate">
    <property name="sessionFactory" ref="localSessionFactory"/>
</bean>
Purpose:
A helper class that reduces boilerplate code for common Hibernate tasks. Offers easy-to-use methods like save(), update(), delete(), etc.

🧑‍🎓 4. StudentDao - DAO Layer for Entity Logic
xml
Copy
Edit
<bean class="com.spring.orm.dao.StudentDao" name="studentDao">
    <property name="hibernateTemplate" ref="hibernateTemplate"/>
</bean>
Purpose:
Custom DAO class for the Student entity that interacts with the database using the HibernateTemplate. It contains logic for methods like addStudent(), getStudent(), getAllStudents(), etc.

🔁 5. HibernateTransactionManager & @Transactional - Transaction Handling
xml
Copy
Edit
<bean class="org.springframework.orm.hibernate5.HibernateTransactionManager" name="transactionManager">
    <property name="sessionFactory" ref="localSessionFactory"/>
</bean>

<tx:annotation-driven/>
Purpose:
HibernateTransactionManager manages the transactions and works behind the scenes to ensure atomicity.
<tx:annotation-driven/> enables annotation-based transaction management using @Transactional.

🔗 How It All Connects
DriverManagerDataSource provides JDBC connectivity to MySQL.

LocalSessionFactoryBean uses it to configure Hibernate.

HibernateTemplate uses the session factory for simplified CRUD operations.

StudentDao interacts with HibernateTemplate for entity persistence.

HibernateTransactionManager and @Transactional manage transaction boundaries automatically.

📦 Technologies Used
Java 21

Spring Framework

Hibernate 5

MySQL

Maven

Eclipse IDE

