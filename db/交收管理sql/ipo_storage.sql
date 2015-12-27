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
  is '��ⵥ��';
comment on column IPO_STORAGE.COMMODITYID
  is '��Ʒ����';
comment on column IPO_STORAGE.STORAGENUM
  is '������';
comment on column IPO_STORAGE.STARTNUM
  is '��ʼ����';
comment on column IPO_STORAGE.ENDNUM
  is '��������';
comment on column IPO_STORAGE.OPERATORID
  is '¼��Ա';
comment on column IPO_STORAGE.WAREHOUSEAUDITORID
  is '�ֿ����Ա';
comment on column IPO_STORAGE.MARKETAUDITORID
  is '�г����Ա';
comment on column IPO_STORAGE.STORAGESTATE
  is '���״̬(1������ 2���ֿ�ͨ�� 3���ֿⲵ�� 4���г�ͨ�� 5���г�����)';
comment on column IPO_STORAGE.STORAGEDATE
  is '���ʱ��';
comment on column IPO_STORAGE.WAREHOUSEID
  is '�ֿ����';
comment on column IPO_STORAGE.MAPPERBILLID
  is '�����ֵ�ID';
comment on column IPO_STORAGE.STORAGECOUNTS
  is '�������';
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
