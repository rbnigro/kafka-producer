# kafka-producer
Kafka Producer

## Subir Serviços

### Iniciar Zookeeper
cd\kafka\bin\windows
zookeeper-server-start.bat C:\kafka\config\zookeeper.properties

### Iniciar Kafka
cd\kafka\bin\windows
kafka-server-start.bat C:\kafka\config\server.properties

### Apagar tópicos
cd\kafka\bin\windows
kafka-topics.bat --bootstrap-server localhost:9092 --delete --topic ecommerce.compras

### Verificações
cd\kafka\bin\windows
kafka-topics.bat --bootstrap-server localhost:9092 --describe
ou 
cd\kafka\bin\windows
kafka-topics.bat --bootstrap-server localhost:9092 --list

### Versão
cd\kafka\bin\windows
kafka-topics.bat --version

### Criar Eventos
cd\kafka\bin\windows<br>
kafka-console-producer.bat --topic --broker-list  pagamento.request.topic.v1 --bootstrap-server localhost:9092

### Ler Eventos
cd\kafka_2.13-3.6.1\bin\windows
kafka-console-consumer.bat --topic pagamento.request.topic.v1 --from-beginning --bootstrap-server localhost:9092
> > > > Para pegar as mensagens desde o início. As que estão armazenadas no disco (--from-beginning)