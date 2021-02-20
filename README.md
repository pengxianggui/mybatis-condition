# Mybatis-Condition
基于Mybatis-Plus做的一个方便查询筛选的工具。

## 用法
有一个t_user表，对应entity实体类User：
```java
public class User {
    private String id;
    private String username;
    private Integer age;
    private LocalDate birthday;
    // getter/setter
}
```
演示如何方便的构建查询:
1. 首先创建一个查询条件类，叫做UserCondition，或者UserRequest都无所谓。
```java
public class UserCondition extends DefaultCondition<User> {
    @Condition(Conditions.Like) // 通过注解定义查询逻辑
    private String username;
    @Condition(Conditions.Eq)
    private Integer age;

    @Condition(value = Conditions.Between, field = "birthday", rangeType = RangeType.START)
    private LocalDate birthdayStart;

    @Condition(value = Conditions.Between, field = "birthday", rangeType = RangeType.END)
    private LocalDate birthdayEnd;
    // getter/setter
}
```
2. 使用。
```java
public class UserController {
    public List<User> userList(UserCondition condition) {
        return baseMapper.selectList(condition.toWrapper());
    }
    
    public IPage<User> userPage(UserCondition condition) {
        return baseMapper.selectPage(condition.toPage(), condition.toWrapper);
    }
}
```

