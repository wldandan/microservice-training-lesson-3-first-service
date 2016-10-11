##Run the applicaiton locally

* Install MongoDB

```
brew install mongodb
```


* Start MongoDB

```
mongod --config /usr/local/etc/mongod.conf
mongoimport --db test --collection event --type json --file db-seed/events-with-id.json
```

* Start application

```
./gradlew bootRun
```

##Run the applicaiton in docker

```
./gradlew clean build
./docker-compose up --build
./db-seed/seed.sh
```

## Manage event
 
### Create one event

```
START_AT=$(date +"%Y-%m-%d") && END_AT=$(date +"%Y-%m-%d") && curl -H "Content-type: application/json" -d "{\"name\": \"测试活动\", \"numberLimit\": 20, \"mainPhoto\": \"http://localhost/image/main_photo.png\", \"introduction\": \"活动介绍\", \"startAt\": \"$START_AT\", \"endAt\": \"$END_AT\"}" http://localhost:8080/events
```

### Update one event

```
START_AT=$(date +"%Y-%m-%d") && END_AT=$(date +"%Y-%m-%d") && curl -H "Content-type: application/json" -d "{\"name\": \"测试活动-updated\", \"numberLimit\": 20, \"mainPhoto\": \"http://localhost/image/main_photo.png\", \"introduction\": \"活动介绍\", \"startAt\": \"$START_AT\", \"endAt\": \"$END_AT\"}" http://localhost:8080/events/{id}
```
