## Compile and start up app containers
```bash
docker-compose up --build -d
```
## Shut down containers
```bash
docker-compose down
```
## Preview kafka queue
```bash
docker exec broker /opt/kafka/bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic "urls.forbidden" --property print.key=true --from-beginning
```
## Connect to database
```bash
docker exec -it cass1 bash -c "cqlsh -u cassandra -p cassandra";
```
## Preview cassandra database
```bash
SELECT * FROM spring_cassandra.url
```
## Create cassandra keyspace
```bash
CREATE KEYSPACE spring_cassandra WITH REPLICATION = {'class' : 'SimpleStrategy', 'replication_factor' : 1};
```
