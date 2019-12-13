# maven-helloworld-mybatis
  [toc]

简单的maven工程样例：集成日常开发基础依赖包和打包配置，可用作新的maven项目开发。

## 基础依赖包
  * 日志
  * 单元测试
  * spring
  * mybatis + sqlite

## 打包
  * 可启动JAR包
  * TAR压缩包

## sqlite相关
从sqlite[官网](https://sqlite.org/download.html)下载数据库管理程序，执行以下命令进入sqlite命令行模式：

```bash
sqlite3 data/sqlite.db
```

其中**sqlite.db**为刚刚创建的空文件。

在sqlite命令行模式下，可以执行SQL创建表单：

```sql
create table demo(id int primary key not null, comment text);
```

执行下列命令展示帮助选项：

```sql
.help
```

执行下列命令展示表内容：

```sql
.header on
.mode column
select * from demo;
```

执行下列命令退出sqlite命令行模式：

```sql
.exit
```

