## 第3课 - 构建第一个服务

### 一、主要知识点
* REST/HAL 101
* Docker 101
* 构建第一个微服务
* 使用MongoDB存储数据
* 使用HAL-Browser浏览服务接口
* 构建Dockerfile 
* 使用Docker-compose运行服务



### 二、本地运行服务

* 1.安装MongoDB

```
//Mac中使用brew直接安装
brew install mongodb

//Windows请自行下载并安装
......
```


* 2.启动MongoDB

```
mongod --config /usr/local/etc/mongod.conf
```

* 3.加载测试数据

可以使用Mongo命令加载数据
	
	
```
mongoimport --db test --collection event --type json --file db-seed/events-with-id.json
```

或者执行如下脚本

```
./db-seed/seed_local.sh
```


* 4.启动应用

```
./gradlew bootRun
```

### 三、Docker中运行服务

```
./gradlew clean build
./docker-compose up --build
./db-seed/seed.sh
```

### 四、查看服务接口

* 使用[HAL](phlyrestfully.readthedocs.org/en/latest/halprimer.html)显示服务首页API

![HAL](/images/hal-index.png)


* 使用HAL可视化查看Events的列表信息

![HAL](/images/hal-results-list.png)

* 使用Curl发送请求，获取Events的列表信息

	```
	curl -H "Content-type: application/json" http://localhost:8080/events
	```
 
* 创建一个Event

```
START_AT=$(date +"%Y-%m-%d") && END_AT=$(date +"%Y-%m-%d") && curl -H "Content-type: application/json" -d "{\"name\": \"测试活动\", \"numberLimit\": 20, \"mainPhoto\": \"http://localhost/image/main_photo.png\", \"introduction\": \"活动介绍\", \"startAt\": \"$START_AT\", \"endAt\": \"$END_AT\"}" http://localhost:8080/events
```
* 获取Event详情

```
curl http://localhost:8080/events/57c811115d6fe2b86380d53b
```


* 更新一个Event

```
START_AT=$(date +"%Y-%m-%d") && END_AT=$(date +"%Y-%m-%d") && curl -H "Content-type: application/json" -X PUT -d "{\"name\": \"测试活动-updated\", \"numberLimit\": 20, \"mainPhoto\": \"http://localhost/image/main_photo.png\", \"introduction\": \"活动介绍\", \"startAt\": \"$START_AT\", \"endAt\": \"$END_AT\"}" http://localhost:8080/events/57c811115d6fe2b86380d53b
```


* 删除一个Event

```
curl -X DELETE http://localhost:8080/events/57c811115d6fe2b86380d53b
```