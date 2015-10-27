/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     2015/10/26 17:38:43                          */
/*==============================================================*/


alter table IPO_DISTRIBUTION
   drop constraint FK_IPO_DIST_REFERENCE_IPO_ORDE;

drop table IPO_DISTRIBUTION cascade constraints;

drop table IPO_LISTOFGOODS cascade constraints;

drop table IPO_ORDER cascade constraints;

/*==============================================================*/
/* Table: IPO_DISTRIBUTION                                      */
/*==============================================================*/
create table IPO_DISTRIBUTION 
(
   "id"                 INT                  not null,
   "orderid"            INT                  not null,
   "start_number"       NUMBER               not null,
   "distribution_quantity" INT                  not null,
   "distribution_number" VARCHAR(64)          not null,
   "distribution_time"  DATE                 not null,
   "number"             VARCHAR(128),
   constraint PK_IPO_DISTRIBUTION primary key ("id")
);

comment on table IPO_DISTRIBUTION is
'��ţ���ǩ���';

/*==============================================================*/
/* Table: IPO_LISTOFGOODS                                       */
/*==============================================================*/
create table IPO_LISTOFGOODS 
(
   "id"                 INT                  not null,
   "commodityid"        INT                  not null,
   "state"              INT                  not null,
   "sale_time"          DATE                 not null,
   constraint PK_IPO_LISTOFGOODS primary key ("id")
);

comment on table IPO_LISTOFGOODS is
'��Ʒ�б�';

comment on column IPO_LISTOFGOODS."state" is
'0���ɷ���
1����Ʒ��ȫ����';

/*==============================================================*/
/* Table: IPO_ORDER                                             */
/*==============================================================*/
create table IPO_ORDER 
(
   "orderid"            INT                  not null,
   "userid"             INT                  not null,
   "username"           VARCHAR(12)          not null,
   "commodityid"        INT                  not null,
   "commodityname"      VARCHAR(12)          not null,
   "count"              NUMBER               not null,
   "date"               DATE                 not null,
   "moneyisfrozen"      NUMBER               not null,
   constraint PK_IPO_ORDER primary key ("orderid")
);

comment on table IPO_ORDER is
'�ͻ����깺����Ʒ��ѯ��';

alter table IPO_DISTRIBUTION
   add constraint FK_IPO_DIST_REFERENCE_IPO_ORDE foreign key ("orderid")
      references IPO_ORDER ("orderid");

