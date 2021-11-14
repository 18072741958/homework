create schema demo_ds_0;
create schema demo_ds_1;



CREATE TABLE IF NOT EXISTS t_order (order_id BIGINT NOT NULL AUTO_INCREMENT, user_id INT NOT NULL, status VARCHAR(50), PRIMARY KEY (order_id));

insert into t_order (order_id,user_id,status) values (0,1,'OK'),(1,1,'FAIl'),(2,1,'FAIl'),(3,1,'FAIl'),(4,1,'FAIl'),(5,1,'FAIl'),(6,1,'FAIl'),(7,1,'FAIl'),(8,1,'FAIl'),(9,1,'FAIl'),(10,1,'FAIl'),(11,1,'FAIl'),(12,1,'FAIl'),(13,1,'FAIl'),(14,1,'FAIl'),(15,1,'FAIl');
insert into t_order (order_id,user_id,status) values (0,2,'OK'),(1,2,'OK'),(2,2,'OK'),(3,2,'OK'),(4,2,'OK'),(5,2,'OK'),(6,2,'OK'),(7,2,'OK'),(8,2,'OK'),(9,2,'OK'),(10,2,'OK'),(11,2,'OK'),(12,2,'OK'),(13,2,'OK'),(14,2,'OK'),(15,2,'OK');



