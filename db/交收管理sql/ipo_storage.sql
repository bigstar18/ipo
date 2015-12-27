-- Create table
create table IPO_STORAGE
(
  STORAGEID          VARCHAR2(32) not null,
  COMMODITYID        VARCHAR2(32) not null,
  STORAGENUM         NUMBER(12) not null,
  STARTNUM           VARCHAR2(32),
  ENDNUM             VARCHAR2(32),
  OPERATORID         VARCHAR2(32),
  WAREHOUSEAUDITORID VARCHAR2(32),
  MARKETAUDITORID    VARCHAR2(32),
  STORAGESTATE       NUMBER(8) not null,
  STORAGEDATE        DATE not null,
  WAREHOUSEID        VARCHAR2(32),
  MAPPERBILLID       VARCHAR2(32),
  STORAGECOUNTS      NUMBER(12)
)
tablespace YRDXH
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64
    next 8
    minextents 1
    maxextents unlimited
  );
-- Add comments to the columns 
comment on column IPO_STORAGE.STORAGEID
  is '入库单号';
comment on column IPO_STORAGE.COMMODITYID
  is '商品代码';
comment on column IPO_STORAGE.STORAGENUM
  is '入库件数';
comment on column IPO_STORAGE.STARTNUM
  is '起始编码';
comment on column IPO_STORAGE.ENDNUM
  is '结束编码';
comment on column IPO_STORAGE.OPERATORID
  is '录入员';
comment on column IPO_STORAGE.WAREHOUSEAUDITORID
  is '仓库审核员';
comment on column IPO_STORAGE.MARKETAUDITORID
  is '市场审核员';
comment on column IPO_STORAGE.STORAGESTATE
  is '入库状态(1、申请 2、仓库通过 3、仓库驳回 4、市场通过 5、市场驳回)';
comment on column IPO_STORAGE.STORAGEDATE
  is '入库时间';
comment on column IPO_STORAGE.WAREHOUSEID
  is '仓库代码';
comment on column IPO_STORAGE.MAPPERBILLID
  is '关联仓单ID';
comment on column IPO_STORAGE.STORAGECOUNTS
  is '入库数量';
-- Create/Recreate primary, unique and foreign key constraints 
alter table IPO_STORAGE
  add constraint PK_IPO_STORAGE primary key (STORAGEID)
  using index 
  tablespace YRDXH
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
