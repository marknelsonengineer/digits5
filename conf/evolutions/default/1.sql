# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table contact (
  id                        bigint not null,
  first_name                varchar(255),
  last_name                 varchar(255),
  phone                     varchar(255),
  phone_type_id             bigint,
  constraint pk_contact primary key (id))
;

create table diet_type (
  id                        bigint not null,
  diet_type                 varchar(255),
  constraint pk_diet_type primary key (id))
;

create table phone_type (
  id                        bigint not null,
  phone_type                varchar(255),
  constraint pk_phone_type primary key (id))
;


create table contact_diet_type (
  contact_id                     bigint not null,
  diet_type_id                   bigint not null,
  constraint pk_contact_diet_type primary key (contact_id, diet_type_id))
;
create sequence contact_seq;

create sequence diet_type_seq;

create sequence phone_type_seq;

alter table contact add constraint fk_contact_phoneType_1 foreign key (phone_type_id) references phone_type (id);
create index ix_contact_phoneType_1 on contact (phone_type_id);



alter table contact_diet_type add constraint fk_contact_diet_type_contact_01 foreign key (contact_id) references contact (id);

alter table contact_diet_type add constraint fk_contact_diet_type_diet_typ_02 foreign key (diet_type_id) references diet_type (id);

# --- !Downs

drop table if exists contact cascade;

drop table if exists contact_diet_type cascade;

drop table if exists diet_type cascade;

drop table if exists phone_type cascade;

drop sequence if exists contact_seq;

drop sequence if exists diet_type_seq;

drop sequence if exists phone_type_seq;

