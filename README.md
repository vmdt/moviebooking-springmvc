# moviebooking-springmvc
Movie Booking Website using Spring Framework, MVC, Restful API

## Environment Variables

To run this project, you will need to add final static variables in SystemContant Java Class

`DRIVER_DB`

`URL_DB`

`USERNAME_DB`

`PASSWORD_DB`

## Config JPA 

If you want to create or drop tables in database

```java
  properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
```

After create tables, set update during project running

```java
  properties.setProperty("hibernate.hbm2ddl.auto", "update");
```

![image](https://github.com/vmdt/moviebooking-springmvc/assets/122994022/034a932a-6db7-411a-b395-8c251082a360)

