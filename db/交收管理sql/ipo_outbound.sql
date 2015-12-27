-- Create table
create table IPO_OUTBOUND
(
  OUTBOUNDORDERID VARCHAR2(32) not null,
  DELIVERYORDERID VARCHAR2(32) not null,
  OUTBOUNDSTATE   NUMBER(8) not null,
  OUTBOUNDDATE    DATE not null,
  OPERATORID      VARCHAR2(32) not null,
  AUDITORID       VARCHAR2(32) not null,
  WAREHOUSEID     VARCHAR2(32),
  DELIVERYPERSON  VARCHAR2(32),
  SEX             VARCHAR2(32),
  IDTYPE          VARCHAR2(32),
  IDNUM           VARCHAR2(32)
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
comment on column IPO_OUTBOUND.OUTBOUNDORDERID
  is '出库单Id';
comment on column IPO_OUTBOUND.DELIVERYORDERID
  is '提货单号';
comment on column IPO_OUTBOUND.OUTBOUNDSTATE
  is '出库状态(1、申请 2、审核通过 3、审核驳回)';
comment on column IPO_OUTBOUND.OUTBOUNDDATE
  is '出库时间';
comment on column IPO_OUTBOUND.OPERATORID
  is '录入员';
comment on column IPO_OUTBOUND.AUDITORID
  is '审核员';
comment on column IPO_OUTBOUND.WAREHOUSEID
  is '仓库代码';
comment on column IPO_OUTBOUND.DELIVERYPERSON
  is '提货人';
comment on column IPO_OUTBOUND.SEX
  is '性别';
comment on column IPO_OUTBOUND.IDTYPE
  is '证件类型';
comment on column IPO_OUTBOUND.IDNUM
  is '证件号码';
-- Create/Recreate primary, unique and foreign key constraints 
alter table IPO_OUTBOUND
  add constraint PK_IPO_OUTBOUND primary key (OUTBOUNDORDERID)
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
