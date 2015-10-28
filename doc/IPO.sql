/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     2015/10/28 10:59:44                          */
/*==============================================================*/


drop table IPO_COMMODITY cascade constraints;

drop table IPO_DISTRIBUTION cascade constraints;

drop table IPO_ORDER cascade constraints;

/*==============================================================*/
/* Table: IPO_COMMODITY                                         */
/*==============================================================*/
create table IPO_COMMODITY 
(
   "id"                 VARCHAR(32)          not null,
   "commodityid"        VARCHAR(32)          not null,
   "commodityname"      VARCHAR(32)          not null,
   "price"              NUMBER(5,5)          not null,
   "unit"               NUMBER               not null,
   "count"              NUMBER               not null,
   "start_time"         DATE                 not null,
   "end_time"           DATE                 not null,
   constraint PK_IPO_COMMODITY primary key ("id")
);

comment on table IPO_COMMODITY is
'��Ʒ�б�';

comment on column IPO_COMMODITY."commodityid" is
'��Ʒ���';

comment on column IPO_COMMODITY."commodityname" is
'��Ʒ����';

comment on column IPO_COMMODITY."price" is
'���ۼ�';

comment on column IPO_COMMODITY."unit" is
'���۵�λ';

comment on column IPO_COMMODITY."count" is
'��������';

comment on column IPO_COMMODITY."start_time" is
'��ʼʱ��';

comment on column IPO_COMMODITY."end_time" is
'����ʱ��';

/*==============================================================*/
/* Table: IPO_DISTRIBUTION                                      */
/*==============================================================*/
create table IPO_DISTRIBUTION 
(
   "id"                 VARCHAR(32)          not null,
   "userid"             VARCHAR(32)          not null,
   "commodityname"      VARCHAR(12)          not null,
   "start_number"       NUMBER               not null,
   "distribution_quantity" INT                  not null,
   "distribution_time"  DATE                 not null,
   "count"              NUMBER               not null,
   "number"             BLOB                 not null,
   constraint PK_IPO_DISTRIBUTION primary key ("id")
);

comment on table IPO_DISTRIBUTION is
'��ţ���ǩ���';

comment on column IPO_DISTRIBUTION."userid" is
'�ͻ����';

comment on column IPO_DISTRIBUTION."commodityname" is
'��Ʒ����';

comment on column IPO_DISTRIBUTION."start_number" is
'��ʼ���';

comment on column IPO_DISTRIBUTION."distribution_quantity" is
'�������';

comment on column IPO_DISTRIBUTION."distribution_time" is
'���ʱ��';

comment on column IPO_DISTRIBUTION."count" is
'��ǩ����';

comment on column IPO_DISTRIBUTION."number" is
'��ǩ����';

/*==============================================================*/
/* Table: IPO_ORDER                                             */
/*==============================================================*/
create table IPO_ORDER 
(
   "orderid"            VARCHAR(32)          not null,
   "userid"             VARCHAR(32)          not null,
   "username"           VARCHAR(12)          not null,
   "commodityid"        VARCHAR(12)          not null,
   "commodityname"      VARCHAR(12)          not null,
   "count"              NUMBER               not null,
   "date"               TIMESTAMP            not null,
   "frozenfunds"        NUMBER(15,2)         not null,
   constraint PK_IPO_ORDER primary key ("orderid")
);

comment on table IPO_ORDER is
'������';

comment on column IPO_ORDER."userid" is
'�ͻ����';

comment on column IPO_ORDER."username" is
'�ͻ�����';

comment on column IPO_ORDER."commodityid" is
'��Ʒ���';

comment on column IPO_ORDER."commodityname" is
'��Ʒ����';

comment on column IPO_ORDER."count" is
'�ͻ��깺��';

comment on column IPO_ORDER."date" is
'�깺ʱ��';

comment on column IPO_ORDER."frozenfunds" is
'�ʽ𶳽�';

