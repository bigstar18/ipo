/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     2015/10/31 20:43:48                          */
/*==============================================================*/


drop table IPO_COMMODITY cascade constraints;

drop table IPO_DISTRIBUTION cascade constraints;

drop table IPO_NUMBEROFRECORDS cascade constraints;

drop table IPO_ORDER cascade constraints;

/*==============================================================*/
/* Table: IPO_COMMODITY                                         */
/*==============================================================*/
create table IPO_COMMODITY 
(
   ID                   VARCHAR(32)          not null,
   COMMODITYID          VARCHAR(32)          not null,
   COMMODITYNAME        VARCHAR(32)          not null,
   PRICE                NUMBER(11,3)         not null,
   UNITS                NUMBER               not null,
   COUNTS               NUMBER               not null,
   STARTTIME            DATE                 not null,
   ENDTIME              DATE                 not null,
   constraint PK_IPO_COMMODITY primary key (ID)
);

comment on table IPO_COMMODITY is
'商品列表';

comment on column IPO_COMMODITY.COMMODITYID is
'商品编号';

comment on column IPO_COMMODITY.COMMODITYNAME is
'商品名称';

comment on column IPO_COMMODITY.PRICE is
'发售价';

comment on column IPO_COMMODITY.UNITS is
'发售单位';

comment on column IPO_COMMODITY.COUNTS is
'发售数量';

comment on column IPO_COMMODITY.STARTTIME is
'起始时间';

comment on column IPO_COMMODITY.ENDTIME is
'结束时间';

/*==============================================================*/
/* Table: IPO_DISTRIBUTION                                      */
/*==============================================================*/
create table IPO_DISTRIBUTION 
(
   ID                   VARCHAR(32)          not null,
   USERID               VARCHAR(32)          not null,
   COMMODITYNAME        VARCHAR(12)          not null,
   STARTNUMBER          NUMBER               not null,
   PCOUNTS              INT                  not null,
   PTIME                TIMESTAMP            not null,
   ZCOUNTS              NUMBER,
   NUMBERS              BLOB,
   constraint PK_IPO_DISTRIBUTION primary key (ID)
);

comment on table IPO_DISTRIBUTION is
'配号，中签结果';

comment on column IPO_DISTRIBUTION.USERID is
'客户编号';

comment on column IPO_DISTRIBUTION.COMMODITYNAME is
'商品名称';

comment on column IPO_DISTRIBUTION.STARTNUMBER is
'起始配号';

comment on column IPO_DISTRIBUTION.PCOUNTS is
'配号数量';

comment on column IPO_DISTRIBUTION.PTIME is
'配号时间';

comment on column IPO_DISTRIBUTION.ZCOUNTS is
'中签数量';

comment on column IPO_DISTRIBUTION.NUMBERS is
'中签号码';

/*==============================================================*/
/* Table: IPO_NUMBEROFRECORDS                                   */
/*==============================================================*/
create table IPO_NUMBEROFRECORDS 
(
   ID                   VARCHAR(32)          not null,
   COMMODITYID          VARCHAR(32),
   COUNTS               NUMBER,
   NOWTIME              TIMESTAMP            
);

comment on column IPO_NUMBEROFRECORDS.COMMODITYID is
'商品编号';

comment on column IPO_NUMBEROFRECORDS.COUNTS is
'已配个数';

comment on column IPO_NUMBEROFRECORDS.NOWTIME is
'时间';

/*==============================================================*/
/* Table: IPO_ORDER                                             */
/*==============================================================*/
create table IPO_ORDER 
(
   ORDERID              VARCHAR(32)          not null,
   USERID               VARCHAR(32)          not null,
   USERNAME             VARCHAR(12),
   COMMODITYID          VARCHAR(12)          not null,
   COMMODITYNAME        VARCHAR(12)          not null,
   COUNTS               NUMBER               not null,
   CREATETIME           TIMESTAMP            not null,
   FROZENFUNDS          NUMBER(15,2)         not null,
   constraint PK_IPO_ORDER primary key (ORDERID)
);

comment on table IPO_ORDER is
'订单表';

comment on column IPO_ORDER.USERID is
'客户编号';

comment on column IPO_ORDER.USERNAME is
'客户姓名';

comment on column IPO_ORDER.COMMODITYID is
'商品编号';

comment on column IPO_ORDER.COMMODITYNAME is
'商品名称';

comment on column IPO_ORDER.COUNTS is
'客户申购数';

comment on column IPO_ORDER.CREATETIME is
'申购时间';

comment on column IPO_ORDER.FROZENFUNDS is
'资金冻结';

