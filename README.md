# webapp-plus-plus

webapp-plus-plus 是一个基于spring boot的快速开发框架，提供了一些常用的功能，如：统一异常处理、统一返回结果、统一日志处理、统一参数校验、统一权限校验、统一分页处理、统一缓存处理、统一消息队列处理、统一定时任务处理等。


项目结构:
1. webapp-plus-api - 提供对外dubbo接口
2. webapp-plus-service - 提供对外dubbo接口实现 [校验层]
3. webapp-plus-biz - 业务层实现
4. webapp-plus-rpc - rpc层
5. ~~webapp-plus-config - 配置层~~
6. webapp-plus-start - 启动层 
7. webapp-plus-common - 工具层
8. 8webapp-plus-task - 定时任务层
9. webapp-plus-core - 事务层

## 项目启动 
1. 启动webapp-plus-start模块下的WebappPlusStartApplication.java
2. 访问 http://localhost:8080/swagger-ui.html
3. 输入用户名：admin 密码：123456 登录
4. 查看接口文档
5. 项目启动成功


## 定时任务
https://shardingsphere.apache.org/elasticjob/current/cn/overview/

