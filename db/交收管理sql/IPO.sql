/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     2015/12/14 14:10:31                          */
/*==============================================================*/


drop table IPO_DELIVERYORDER cascade constraints;

drop table IPO_DELIVERY_COST cascade constraints;

drop table IPO_EXPRESS cascade constraints;

drop table IPO_PICKUP cascade constraints;

drop table IPO_SPECIAL_POUNDAGE cascade constraints;

/*==============================================================*/
/* Table: IPO_DELIVERYORDER                                     */
/*==============================================================*/
create table IPO_DELIVERYORDER 
(
   DELIVERYORDER_ID     NUMBER(12)           not null,
   COMMODITY_ID         VARCHAR2(32)         not null,
   COMMODITY_NAME       VARCHAR2(32),
   DEALER_ID            VARCHAR2(50)         not null,
   DEALER_NAME          VARCHAR2(32),
   WAREHOUSE_ID         VARCHAR2(32)         not null,
   WAREHOUSE_NAME       VARCHAR2(32),
   DELIVERY_QUATITY     NUMBER(12)           not null,
   DELIVERY_COUNTS      NUMBER(12),
   DELIVERY_METHOD      VARCHAR2(32)         not null,
   METHOD_ID            NUMBER(12)           not null,
   UNIT                 VARCHAR2(32),
   DELIVERY_DATE        DATE                 not null,
   APPLY_DATE           DATE                 not null,
   APPROVAL_STATUS      NUMBER(8)            not null,
   APPROVERS            VARCHAR2(32),
   APPROVE_DATE         DATE,
   CANCELER             VARCHAR2(32),
   CANCEL_DATE          DATE,
   POSITION             NUMBER(12),
   REMARKS              VARCHAR2(200),
   constraint PK_IPO_DELIVERYORDER primary key (DELIVERYORDER_ID)
);

/*==============================================================*/
/* Table: IPO_DELIVERY_COST                                     */
/*==============================================================*/
create table IPO_DELIVERY_COST 
(
   DELIVERY_ID          NUMBER(12)           not null,
   DELIVERY_METHOD      VARCHAR2(32),
   APPLY_DATE           DATE,
   INSURANCE            NUMBER(12,2),
   TRUSTEE_FEE          NUMBER(12,2),
   WAREHOUSING_FEE      NUMBER(12,2),
   DELIVERY_FEE         NUMBER(12,2),
   constraint PK_IPO_DELIVERY_COST primary key (DELIVERY_ID)
);

/*==============================================================*/
/* Table: IPO_EXPRESS                                           */
/*==============================================================*/
create table IPO_EXPRESS 
(
   EXPRESS_ID           NUMBER(12)           not null,
   ADDRESS              VARCHAR2(200),
   COST                 NUMBER(32,2),
   EXPRESS_DATE         DATE,
   RECEIVER             VARCHAR2(32),
   TEL                  VARCHAR2(32),
   constraint PK_IPO_EXPRESS primary key (EXPRESS_ID)
);

/*==============================================================*/
/* Table: IPO_PICKUP                                            */
/*==============================================================*/
create table IPO_PICKUP 
(
   PICKUP_ID            NUMBER(12)           not null,
   PICKUP_PASSWORD      VARCHAR2(50),
   IDCARD_NUM           VARCHAR2(50),
   constraint PK_IPO_PICKUP primary key (PICKUP_ID)
);

/*==============================================================*/
/* Table: IPO_SPECIAL_POUNDAGE                                  */
/*==============================================================*/
create table IPO_SPECIAL_POUNDAGE 
(
   POUNDAGE_ID          NUMBER(12)           not null,
   DEALER_ID            VARCHAR2(50)         not null,
   COMMODITY_ID         VARCHAR2(32)         not null,
   POUNDAGE_ALGR        NUMBER(8),
   MODIFY_DATE          DATE,
   REGISTER_RATIO       NUMBER(12,2),
   CANCEL_RATIO         NUMBER(12,2),
   SAIL_RATIO           NUMBER(12,2),
   constraint PK_IPO_SPECIAL_POUNDAGE primary key (POUNDAGE_ID)
);

