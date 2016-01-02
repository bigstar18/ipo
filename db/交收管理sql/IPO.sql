/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     2016/1/2 20:57:51                            */
/*==============================================================*/


DROP TABLE IPO_DELIVERYORDER CASCADE CONSTRAINTS;

DROP TABLE IPO_DELIVERY_COST CASCADE CONSTRAINTS;

DROP TABLE IPO_EXPRESS CASCADE CONSTRAINTS;

DROP TABLE IPO_OUTBOUND CASCADE CONSTRAINTS;

DROP TABLE IPO_PICKUP CASCADE CONSTRAINTS;

DROP TABLE IPO_SPECIAL_POUNDAGE CASCADE CONSTRAINTS;

DROP TABLE IPO_STORAGE CASCADE CONSTRAINTS;

/*==============================================================*/
/* Table: IPO_DELIVERYORDER                                     */
/*==============================================================*/
CREATE TABLE IPO_DELIVERYORDER 
(
   DELIVERYORDER_ID     NUMBER(12)           NOT NULL,
   COMMODITY_ID         VARCHAR2(32)         NOT NULL,
   COMMODITY_NAME       VARCHAR2(32),
   DEALER_ID            VARCHAR2(50)         NOT NULL,
   DEALER_NAME          VARCHAR2(32),
   WAREHOUSE_ID         VARCHAR2(32)         NOT NULL,
   WAREHOUSE_NAME       VARCHAR2(32),
   DELIVERY_QUATITY     NUMBER(12)           NOT NULL,
   DELIVERY_COUNTS      NUMBER(12),
   DELIVERY_METHOD      VARCHAR2(32)         NOT NULL,
   METHOD_ID            NUMBER(12)           NOT NULL,
   UNIT                 VARCHAR2(32),
   DELIVERY_DATE        DATE                 NOT NULL,
   APPLY_DATE           DATE                 NOT NULL,
   APPROVAL_STATUS      NUMBER(8)            NOT NULL,
   APPROVERS            VARCHAR2(32),
   APPROVE_DATE         DATE,
   CANCELER             VARCHAR2(32),
   CANCEL_DATE          DATE,
   REMARKS              VARCHAR2(200),
   CONSTRAINT PK_IPO_DELIVERYORDER PRIMARY KEY (DELIVERYORDER_ID)
);

/*==============================================================*/
/* Table: IPO_DELIVERY_COST                                     */
/*==============================================================*/
CREATE TABLE IPO_DELIVERY_COST 
(
   DELIVERY_ID          NUMBER(12)           NOT NULL,
   DELIVERY_METHOD      VARCHAR2(32),
   APPLY_DATE           DATE,
   INSURANCE            NUMBER(12,2),
   TRUSTEE_FEE          NUMBER(12,2),
   WAREHOUSING_FEE      NUMBER(12,2),
   DELIVERY_FEE         NUMBER(12,2),
   CONSTRAINT PK_IPO_DELIVERY_COST PRIMARY KEY (DELIVERY_ID)
);

/*==============================================================*/
/* Table: IPO_EXPRESS                                           */
/*==============================================================*/
CREATE TABLE IPO_EXPRESS 
(
   EXPRESS_ID           NUMBER(12)           NOT NULL,
   ADDRESS              VARCHAR2(200),
   COST                 NUMBER(32,2),
   EXPRESS_DATE         DATE,
   RECEIVER             VARCHAR2(32),
   TEL                  VARCHAR2(32),
   CONSTRAINT PK_IPO_EXPRESS PRIMARY KEY (EXPRESS_ID)
);

/*==============================================================*/
/* Table: IPO_OUTBOUND                                          */
/*==============================================================*/
CREATE TABLE IPO_OUTBOUND 
(
   OUTBOUNDORDERID      VARCHAR2(32)         NOT NULL,
   DELIVERYORDERID      VARCHAR2(32)         NOT NULL,
   OUTBOUNDSTATE        NUMBER(8)            NOT NULL,
   OUTBOUNDDATE         DATE                 NOT NULL,
   OPERATORID           VARCHAR2(32)         NOT NULL,
   AUDITORID            VARCHAR2(32)         NOT NULL,
   WAREHOUSEID          VARCHAR2(32),
   DELIVERYPERSON       VARCHAR2(32),
   SEX                  VARCHAR2(32),
   IDTYPE               VARCHAR2(32),
   IDNUM                VARCHAR2(32),
   CONSTRAINT PK_IPO_OUTBOUND PRIMARY KEY (OUTBOUNDORDERID)
);

/*==============================================================*/
/* Table: IPO_PICKUP                                            */
/*==============================================================*/
CREATE TABLE IPO_PICKUP 
(
   PICKUP_ID            NUMBER(12)           NOT NULL,
   PICKUP_PASSWORD      VARCHAR2(50),
   IDCARD_NUM           VARCHAR2(50),
   CONSTRAINT PK_IPO_PICKUP PRIMARY KEY (PICKUP_ID)
);

/*==============================================================*/
/* Table: IPO_SPECIAL_POUNDAGE                                  */
/*==============================================================*/
CREATE TABLE IPO_SPECIAL_POUNDAGE 
(
   POUNDAGE_ID          NUMBER(12)           NOT NULL,
   DEALER_ID            VARCHAR2(50)         NOT NULL,
   COMMODITY_ID         VARCHAR2(32)         NOT NULL,
   POUNDAGE_ALGR        NUMBER(8),
   MODIFY_DATE          DATE,
   REGISTER_RATIO       NUMBER(12,2),
   CANCEL_RATIO         NUMBER(12,2),
   SAIL_RATIO           NUMBER(12,2),
   CONSTRAINT PK_IPO_SPECIAL_POUNDAGE PRIMARY KEY (POUNDAGE_ID)
);

/*==============================================================*/
/* Table: IPO_STORAGE                                           */
/*==============================================================*/
CREATE TABLE IPO_STORAGE 
(
   STORAGEID            VARCHAR2(32)         NOT NULL,
   COMMODITYID          VARCHAR2(32)         NOT NULL,
   STORAGENUM           NUMBER(16)           NOT NULL,
   STARTNUM             VARCHAR2(32),
   ENDNUM               VARCHAR2(32),
   OPERATORID           VARCHAR2(32),
   WAREHOUSEAUDITORID   VARCHAR2(32),
   MARKETAUDITORID      VARCHAR2(32),
   STORAGESTATE         NUMBER(8)            NOT NULL,
   STORAGEDATE          DATE                 NOT NULL,
   WAREHOUSEID          VARCHAR2(32),
   MAPPERBILLID         VARCHAR2(32),
   STORAGECOUNTS        NUMBER(16),
   CONSTRAINT PK_IPO_STORAGE PRIMARY KEY (STORAGEID)
);

