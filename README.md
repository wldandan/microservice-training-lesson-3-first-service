### 本地环境中运行

* 安装MongoDB(Mac中可以使用brew)

```
brew install mongodb
```


* 启动MongoDB

```
mongod --config /usr/local/etc/mongod.conf
```

* 加载测试数据

```
mongoimport --db test --collection event --type json --file db-seed/events-with-id.json
```
或者执行

```
./db-seed/seed_local.sh
```


* 启动应用

```
./gradlew bootRun
```

### Docker环境中运行

```
./gradlew clean build
./docker-compose up --build
./db-seed/seed.sh
```

### Event管理

* 获取Event列表

```
curl -H "Content-type: application/json" http://localhost:8080/events
```
 
* 创建一个Event

```
START_AT=$(date +"%Y-%m-%d") && END_AT=$(date +"%Y-%m-%d") && curl -H "Content-type: application/json" -d "{\"name\": \"测试活动\", \"numberLimit\": 20, \"mainPhoto\": \"http://localhost/image/main_photo.png\", \"introduction\": \"活动介绍\", \"startAt\": \"$START_AT\", \"endAt\": \"$END_AT\"}" http://localhost:8080/events
```
* 获取Event详情

```
curl http://localhost:8080/events/{ID}
```




* 更新一个Event

```
START_AT=$(date +"%Y-%m-%d") && END_AT=$(date +"%Y-%m-%d") && curl -H "Content-type: application/json" -X PUT -d "{\"name\": \"测试活动-updated\", \"numberLimit\": 20, \"mainPhoto\": \"http://localhost/image/main_photo.png\", \"introduction\": \"活动介绍\", \"startAt\": \"$START_AT\", \"endAt\": \"$END_AT\"}" http://localhost:8080/events/{ID}
```


* 删除一个Event

```
curl -X DELETE http://localhost:8080/events/{ID}
```
