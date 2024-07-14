# Preview kafka queue
docker exec broker /opt/kafka/bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic "urls.forbidden" --property print.key=true --from-beginning

# Connect to database
docker exec -it cass1 bash -c "cqlsh -u cassandra -p cassandra"

# Preview cassandra database
SELECT * FROM spring_cassandra.url
