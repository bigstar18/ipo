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
  is '���ⵥId';
comment on column IPO_OUTBOUND.DELIVERYORDERID
  is '�������';
comment on column IPO_OUTBOUND.OUTBOUNDSTATE
  is '����״̬(1������ 2�����ͨ�� 3����˲���)';
comment on column IPO_OUTBOUND.OUTBOUNDDATE
  is '����ʱ��';
comment on column IPO_OUTBOUND.OPERATORID
  is '¼��Ա';
comment on column IPO_OUTBOUND.AUDITORID
  is '���Ա';
comment on column IPO_OUTBOUND.WAREHOUSEID
  is '�ֿ����';
comment on column IPO_OUTBOUND.DELIVERYPERSON
  is '�����';
comment on column IPO_OUTBOUND.SEX
  is '�Ա�';
comment on column IPO_OUTBOUND.IDTYPE
  is '֤������';
comment on column IPO_OUTBOUND.IDNUM
  is '֤������';
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
