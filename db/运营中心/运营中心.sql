/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     2016-04-16 14:16:25                          */
/*==============================================================*/


drop table OO_CENTER_BROKER_ORM cascade constraints;

drop table OO_CENTER_COMMODITY_ORM cascade constraints;

drop table OO_CENTERDIVIDE cascade constraints;

/*==============================================================*/
/* Table: OO_CENTER_BROKER_ORM */
/*==============================================================*/
create table OO_CENTER_BROKER_ORM 
(
   ID                   NUMBER               not null,
   CENTERID             VARCHAR(32),
   BROKERID             VARCHAR(32),
   constraint PK_OO_CENTER_BROKER_ORM  primary key (ID)
);

/*==============================================================*/
/* Table: OO_CENTER_COMMODITY_ORM */
/*==============================================================*/
create table OO_CENTER_COMMODITY_ORM 
(
   ID                   NUMBER               not null,
   CENTERID             VARCHAR(32),
   COMMODITYID          VARCHAR(32),
   constraint PK_OO_CENTER_COMMODITY_ORM  primary key (ID)
);

/*==============================================================*/
/* Table: OO_CENTERDIVIDE */
/*==============================================================*/
create table OO_CENTERDIVIDE 
(
   ID                   NUMBER               not null,
   CENTERID             VARCHAR(32),
   MODELID              VARCHAR(32),
   DIVIDEMONEY          NUMBER,
   PAYMENTDATE          DATE,
   ISPAYMENT            NUMBER,
   CREATEDATE           DATE,
   AUTOMATICPAYMENT     NUMBER,
   constraint PK_OO_CENTERDIVIDE  primary key (ID)
);

