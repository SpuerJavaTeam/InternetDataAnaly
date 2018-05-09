# InternetDataAnaly

## 要求

字段：<br>
姓名[可随机]、学号[可随机]、上网时间[可指定区间随机]、网站[可随机]、性别[可随机]

模块：<br>
网站前台：设置产生数据规则、展示页面<br>
单元测试模块：编写测试case验证数据分析正确性<br>
网站后台：根据前台数据规则产生数据<br>
HADOOP服务端：分析数据并将结果上传<br>
后台脚本：完成数据接收、上传HDFS等<br>
数据库段：配置各个节点IP等配置信息、各个随机区间内容。

展示要求：<br>
1、访问最多的网站     N<br>
2、男生访问最多的网站. N<br>
3、女生访问最多的网站 N<br>
4、指定时间区间内上网次数最多的学生姓名 2 <br>
5、指定时间区间内上网次数最多的男生学生姓名 2<br>
6、指定时间区间内上网次数最多的女生学生姓名2<br>
7、以10分钟为区间，上网次数最多的时间区间 N<br>
8、指定时间段，查看上网次数最多的学生学号 2<br>
9、同时[5s以内]同时上同一个网站的男生列表 1<br>
10、同时[5s以内]同时上同一个网站的女生列表 1

(top10或可以翻页查看全部或饼状图,指定时间直接系统设置[支持设置3个时间段])

## 后端数据库设计

    +----------------------------------------------------------------+
    |                            user                                |
    +----------+-------------+------+-----+---------+----------------+
    | Field    | Type        | Null | Key | Default | Extra          |
    +----------+-------------+------+-----+---------+----------------+
    | uid      | int         | NO   | PRI |         | auto_increment |
    | sno      | varchar(20) | NO   |     | NULL    |                |    
    | name     | varchar(50) | NO   |     | NULL    |                |
    | age      | varchar(5)  | NO   |     | NULL    |                |
    | gender   | varchar(5)  | No   |     | NULL    |                |
    |created_at| timestamp   | No   |     | NULL    |                |
    +----------+-------------+------+-----+---------+----------------+
    
    create table javabean.user(
        uid int auto_increment,
        sno varchar(20) not null,
        name varchar(20) not null,
        age varchar(5) not null,
        gender varchar(5) default null,
        created_at timestamp,
        primary key(uid)
    )
    
    +----------------------------------------------------------------+
    |                        internetdata                            |
    +----------+-------------+------+-----+---------+----------------+
    | Field    | Type        | Null | Key | Default | Extra          |
    +----------+-------------+------+-----+---------+----------------+
    | id       |int          | NO   | PRI |         | auto_increment |
    | uid      |int          | NO   |     |         |                |
    | url      |varchar(1000)| NO   |     | NULL    |                |    
    | date     |date         | NO   |     | NULL    |                | -- yyyy-mm-dd HH:mm:ss
    |created_at|timestamp    | No   |     | NULL    |                |
    +----------+-------------+------+-----+---------+----------------+
    
    create table internetdata(
        id int AUTO_INCREMENT,
        uid int not null,
        url varchar(1000) not null,
        date date not null,
        created_at timestamp not null,
        primary key(id)
    );
    alter table javbeaninternetdata add constraint fk_001 foreign key(uid) references javabean.user(uid);
    

## 前端设计

1. 随机数据产生页面
    1. 随机数据产生配置文件
    2. 随机数据产生的结果（以配置文件的方式呈现）
2. 数据浏览页面
    1. 浏览产生的随机数据
    2. 根据用户自定义字段浏览
3. 计算结果并展示
    1. 数据汇总
    2. 根据用户要求进行计算
