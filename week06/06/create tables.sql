create table if not exists t_user
(
  id int(10) not null auto_increment comment 'id',
  name varchar(10) not null comment '姓名',
  gender tinyint not null comment '性别',
  address varchar(20) comment '地址',
  contact varchar(20) comment '联系方式',
  create_time datetime default null comment '创建时间',
  update_time datetime default null comment '更新时间',
  primary key (id)
)ENGINE=InnoDB, DEFAULT CHARSET=utf8mb4;

create table if not exists t_product
(
 id int(10) not null auto_increment comment 'id',
 name varchar(10) not null comment '姓名',
 type int(4) not null comment '产品类别',
 price float not null comment '单价' ,
 create_time datetime default null comment '创建时间',
 update_time datetime default null comment '更新时间',
 primary key (id)
)ENGINE=InnoDB, DEFAULT CHARSET=utf8mb4;

create table if not exists t_order
(
id bigint not null auto_increment comment 'id',
user_id int(10) not null comment '用户id',
product_id int(10) not null comment '商品id',
quantity int(10) not null comment '商品数量',
create_time datetime default null comment '创建时间',
update_time datetime default null comment '更新时间',
primary key (id)
)ENGINE=InnoDB, DEFAULT CHARSET=utf8mb4;