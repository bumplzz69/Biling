# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table biling (
  id                        bigint not null,
  date                      timestamp,
  validate                  integer,
  reference                 varchar(255),
  isencao_iva               integer,
  description               varchar(255),
  retention                 double,
  currency                  integer,
  client_id                 bigint,
  constraint pk_biling primary key (id))
;

create table client (
  id                        bigint not null,
  name                      varchar(255),
  nif                       bigint,
  email                     varchar(255),
  address                   varchar(255),
  cep                       varchar(255),
  country                   integer,
  constraint pk_client primary key (id))
;

create table item (
  id                        bigint not null,
  reference                 varchar(255),
  description               varchar(255),
  price                     double,
  quantity                  integer,
  unit                      integer,
  iva                       float,
  descount                  float,
  constraint pk_item primary key (id))
;


create table item_biling (
  item_id                        bigint not null,
  biling_id                      bigint not null,
  constraint pk_item_biling primary key (item_id, biling_id))
;
create sequence biling_seq;

create sequence client_seq;

create sequence item_seq;

alter table biling add constraint fk_biling_client_1 foreign key (client_id) references client (id) on delete restrict on update restrict;
create index ix_biling_client_1 on biling (client_id);



alter table item_biling add constraint fk_item_biling_item_01 foreign key (item_id) references item (id) on delete restrict on update restrict;

alter table item_biling add constraint fk_item_biling_biling_02 foreign key (biling_id) references biling (id) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists biling;

drop table if exists item_biling;

drop table if exists client;

drop table if exists item;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists biling_seq;

drop sequence if exists client_seq;

drop sequence if exists item_seq;

