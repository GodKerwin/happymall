happymall
===========================
1.版本管理工具使用github
2.版本构建工具使用gradle，项目采用多模块架构
3.数据访问采用jpa+mybatis，使用jpa自动建表+简单数据访问，使用mybatis来进行复杂的连表查询及变更操作

###########环境依赖
jdk 1.8
mysql
groovy 2.4+
gradle

###########部署步骤
1. checkout代码至本地目录
2. 执行根目录sql文件夹下初始化SQL(或直接启动项目jpa自动建表)
3. java -cp 启动jar包

###########目录结构描述
├── doc                         // 文档
├── happymall-admin             // happymall后台管理
│   ├── dao                        // 数据访问层
│   ├── domain                     // 实体
│   ├── enums                      // 枚举
│   ├── repository                 // 仓库接口
│   ├── service                    // 服务层
│   ├── support                    // 支持服务
        ├── config                    // 配置类
        ├── dto                       // 数据传输对象
        └── utils                     // 工具类
│   ├── web                        // 接口层
│   └── HappymallAdminApplication  // happymall后台管理启动类
├── happymall-base              // happymall基础服务
│   ├── dao                        
│   ├── domain                     
│   ├── enums                      
│   ├── repository                 
│   ├── service                    
│   ├── support                    
        ├── aspect                 // aop接口日志打印
        ├── config
        ├── constant               // 常量类
        ├── dto                    
        ├── exception              // 异常类
        ├── handle                 // 异常拦截处理
        └── utils                     
│   ├── web                        
│   └── HappymallBaseApplication  // happymall基础服务启动类
├── happymall-portal            // happymall前端服务
│   ├── dao                        
│   ├── domain                     
│   ├── enums                      
│   ├── repository                 
│   ├── service                    
│   ├── support                    
        ├── config                    
        ├── dto                       
        └── utils                     
│   ├── web                        
│   └── HappymallPortalApplication  // happymall前端服务启动类
├── log                         // 日志
├── sql                         // 初始化SQL
├── .gitignore                  // git忽略文件
├── build.gradle                // gradle配置
├── gradle.properties           // gradle配置
└── README.md                   // 帮助


########### V1.0.0 版本内容更新
###########  date   2018-12-04

Implemented enhancements:
1.happymall项目v1.0.0初始发布

Fixed bugs:
none

Merged pull requests:
none