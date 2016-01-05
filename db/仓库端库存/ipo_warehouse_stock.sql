/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     2016/1/5 15:38:06                            */
/*==============================================================*/


DROP TABLE IPO_WAREHOUSE_STOCK CASCADE CONSTRAINTS;

/*==============================================================*/
/* Table: IPO_WAREHOUSE_STOCK */
/*==============================================================*/
CREATE TABLE IPO_WAREHOUSE_STOCK 
(
   STOCKID              VARCHAR2(32)         NOT NULL,
   COMMODITYID          VARCHAR2(32),
   STORAGENUM           NUMBER(12),
   FORZENNUM            NUMBER(12),
   AVAILABLENUM         NUMBER(12),
   OUTBOUNDNUM          NUMBER(12),
   WAREHOUSEID          NUMBER(10),
   CONSTRAINT PK_IPO_WAREHOUSE_STOCK PRIMARY KEY (STOCKID)
);
-- Add comments to the columns 
comment on column IPO_WAREHOUSE_STOCK.STORAGENUM
  is '入库数量';
comment on column IPO_WAREHOUSE_STOCK.FORZENNUM
  is '冻结数量';
comment on column IPO_WAREHOUSE_STOCK.AVAILABLENUM
  is '有效数量';
comment on column IPO_WAREHOUSE_STOCK.OUTBOUNDNUM
  is '出库数量';

-- Create sequence 
create sequence SEQ_IPO_WAREHOUSE_STOCK
minvalue 1
maxvalue 9999999999999999999999999999
start with 41
increment by 1
cache 20;
