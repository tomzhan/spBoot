##  springBoot多模块开发 ##
----
现在只是搭建了整体框架，还有很多工作没做，比如shiro的整合、权限设计，后台管理的展示模板

### 　项目技术
> 数据库：mysql         

> 依赖管理：maven

> 后端技术: spring boot + logback +  beetl页面模板 +  mybatis(通用mapper、分页插件) + redis + swagger2文档接口 + velocity一键生成代码

> 前端: bootstrap3 + datatable表格展示 + layer弹出框 + Validform表单验证

----

###　模块说明 ###
　

项目分成了５个模块
> common——通用的工具、属性、插件（redis、swagger2配置）　

> bean——实体、VO

> businiss——service、dao（集成通用mapper、mybatis分页插件）

> admin——后台管理 (logback、beetl)

> code——代码生成。独立运行，依赖common模块的swagger2配置，可单独拿出到其他项目使用

----

###　配置运行 ###
 
 

 1. 项目的配置都在 **application-dev.yml** 文件，都有注释说明
 2. 日志配置文件需要**更改**目录文件的生成地址和项目名称
在**logback-springboot.xml**文件
```
     <!--定义日志文件的存储地址(绝对路径) -->
     <property name="log_home" value="F:/data/LOG/oa/admin" />
     <!--生成日志的名称-->
     <property name="project_name" value="spBoot_admin" />
```

 3. redis和mysql的配置需要自己重新配置（不配置redis也可以跑起项目）
 4. 数据库演示的sql
 
```
  DROP TABLE IF EXISTS `demo_user`; CREATE TABLE `demo_user` (   `id`
 varchar(36) NOT NULL,   `name` varchar(64) DEFAULT NULL,   `age`
 int(4) DEFAULT NULL,   `userName` varchar(64) DEFAULT NULL COMMENT
 '用户名称',   `roleId` int(11) DEFAULT NULL COMMENT '用户角色',  
 `create_date` datetime DEFAULT NULL,   PRIMARY KEY (`id`) )
 ENGINE=InnoDB DEFAULT CHARSET=utf8;
 
 -- ----------------------------
 -- Records of demo_user
 -- ---------------------------- INSERT INTO `demo_user` VALUES ('004657554b74411e8e25de7ba352c55d', '很柒运！！！', null,
 '5bQ3kI8g~~~！@！！', null, '2017-04-18 18:00:58'); INSERT INTO
 `demo_user` VALUES ('01109eb0-7ee5-44eb-a681-855af5b800db', '仙前嚎',
 null, 'v6s6o020', null, '2017-04-12 11:22:41'); INSERT INTO
 `demo_user` VALUES ('031eeb76-55e2-4f2b-b4eb-b6e3be78bf46', '鳞铭乃',
 null, '8sn36RO6', null, '2017-04-12 11:22:41');
```

5.项目启动后，会在控制台打印访问的url，请根据此url在后面加上/demo，即可见到CRUD的demo演示

 
