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
'商品列表';

comment on column IPO_COMMODITY."commodityid" is
'商品编号';

comment on column IPO_COMMODITY."commodityname" is
'商品名称';

comment on column IPO_COMMODITY."price" is
'发售价';

comment on column IPO_COMMODITY."unit" is
'发售单位';

comment on column IPO_COMMODITY."count" is
'发售数量';

comment on column IPO_COMMODITY."start_time" is
'起始时间';

comment on column IPO_COMMODITY."end_time" is
'结束时间';

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
'配号，中签结果';

comment on column IPO_DISTRIBUTION."userid" is
'客户编号';

comment on column IPO_DISTRIBUTION."commodityname" is
'商品名称';

comment on column IPO_DISTRIBUTION."start_number" is
'起始配号';

comment on column IPO_DISTRIBUTION."distribution_quantity" is
'配号数量';

comment on column IPO_DISTRIBUTION."distribution_time" is
'配号时间';

comment on column IPO_DISTRIBUTION."count" is
'中签数量';

comment on column IPO_DISTRIBUTION."number" is
'中签号码';

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
'订单表';

comment on column IPO_ORDER."userid" is
'客户编号';

comment on column IPO_ORDER."username" is
'客户姓名';

comment on column IPO_ORDER."commodityid" is
'商品编号';

comment on column IPO_ORDER."commodityname" is
'商品名称';

comment on column IPO_ORDER."count" is
'客户申购数';

comment on column IPO_ORDER."date" is
'申购时间';

comment on column IPO_ORDER."frozenfunds" is
'资金冻结';

