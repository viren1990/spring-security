# spring-security-demo

### Make sure test data is set as below;

#### mysql> use springsecurity;
#### mysql> select * from user;
###### +----+----------------+----------+----------+-----------+
###### | id | active         | name     | password | role      |
###### +----+----------------+----------+----------+-----------+
###### |  1 | 0x01           | testuser | pass     | ROLE_USER |
###### +----+----------------+----------+----------+-----------+
###### 1 row in set (0.00 sec)

### active column is of tinyint(1) type and it's value above is true/1.
