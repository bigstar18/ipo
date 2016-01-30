 
/*==============================================================*/
/* Table: BILLOFLADING       ��Ʒ�����                         */
/*==============================================================*/
 
-- Create table
create table IPO_BILLOFLADING
(
  id               NUMBER(32) not null,
  firmid           VARCHAR2(64),
  commodityid      VARCHAR2(64),
  commodityname    VARCHAR2(64),
  quantity         NUMBER(32),
  counts           NUMBER(32),
  deliverytype     VARCHAR2(64),
  billofladingfee  NUMBER(15,2),
  warehousingfee   NUMBER(15,2),
  insurance        NUMBER(15,2),
  trusteefee       NUMBER(15,2),
  registrationdate DATE,
  createtime       DATE
)
tablespace YRDXH
  pctfree 10
  initrans 1
  maxtrans 255;
-- Add comments to the columns 
comment on column IPO_BILLOFLADING.id
  is '���';
comment on column IPO_BILLOFLADING.firmid
  is '������id';
comment on column IPO_BILLOFLADING.commodityid
  is '��Ʒ����';
comment on column IPO_BILLOFLADING.commodityname
  is '��Ʒ����';
comment on column IPO_BILLOFLADING.quantity
  is '����';
comment on column IPO_BILLOFLADING.counts
  is '����';
comment on column IPO_BILLOFLADING.deliverytype
  is '����';
comment on column IPO_BILLOFLADING.billofladingfee
  is '�����������';
comment on column IPO_BILLOFLADING.warehousingfee
  is '�ִ���';
comment on column IPO_BILLOFLADING.insurance
  is '���շ�';
comment on column IPO_BILLOFLADING.trusteefee
  is '�йܷ�';
comment on column IPO_BILLOFLADING.registrationdate
  is 'ע������';
comment on column IPO_BILLOFLADING.createtime
  is '����ʱ��';
-- Create/Recreate primary, unique and foreign key constraints 
alter table IPO_BILLOFLADING
  add constraint PK_IPO_BILLOFLADING primary key (ID)
  using index 
  tablespace YRDXH
  pctfree 10
  initrans 2
  maxtrans 255;
  
-- Create sequence 
create sequence SEQ_IPO_BILLOFLADING
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;


/*==============================================================*/
/* Table: DELIVERY            ��Ʒ�����                        */
/*==============================================================*/

-- Create table
create table IPO_DELIVERY
(
  id            NUMBER(32) not null,
  firmid        VARCHAR2(64) not null,
  commodityid   VARCHAR2(64) not null,
  commodityname VARCHAR2(64) not null,
  quantity      NUMBER(32) not null,
  counts        NUMBER(32) not null,
  deliverytype  VARCHAR2(64) not null,
  transferfee   NUMBER(15,2),
  postage       NUMBER(15,2),
  transferdate  DATE,
  createtime    DATE not null
)
tablespace YRDXH
  pctfree 10
  initrans 1
  maxtrans 255;
-- Add comments to the columns 
comment on column IPO_DELIVERY.id
  is '���';
comment on column IPO_DELIVERY.firmid
  is '������id';
comment on column IPO_DELIVERY.commodityid
  is '��Ʒ����';
comment on column IPO_DELIVERY.commodityname
  is '��Ʒ����';
comment on column IPO_DELIVERY.quantity
  is '����';
comment on column IPO_DELIVERY.counts
  is '����';
comment on column IPO_DELIVERY.deliverytype
  is '����';
comment on column IPO_DELIVERY.transferfee
  is '������';
comment on column IPO_DELIVERY.postage
  is '�˷�';
comment on column IPO_DELIVERY.transferdate
  is '����ʱ��';
comment on column IPO_DELIVERY.createtime
  is '����ʱ��';
-- Create/Recreate primary, unique and foreign key constraints 
alter table IPO_DELIVERY
  add constraint PK_IPO_DELIVERY primary key (ID)
  using index 
  tablespace YRDXH
  pctfree 10
  initrans 2
  maxtrans 255;

 -- Create sequence 
create sequence SEQ_IPO_DELIVERY
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

/*==============================================================*/
/* Table: HOLDCOMMODITY            ��Ʒ���б�                   */
/*==============================================================*/
-- Create table
create table IPO_HOLDCOMMODITY
(
  id                    NUMBER(32) not null,
  firmid                VARCHAR2(64) not null,
  commodityid           VARCHAR2(64) not null,
  commodityname         VARCHAR2(64) not null,
  bs_flag               NUMBER(1) not null,
  holdqty               NUMBER(32) not null,
  frozenqty             NUMBER(32) not null,
  quantityavailable     NUMBER(32) not null,
  evenprice             NUMBER(15,2) not null,
  price                 NUMBER(15,2) not null,
  holdinggainsandlosses NUMBER(15,2) not null,
  marketvalue           NUMBER(15,2) not null,
  createtime            DATE not null
)
tablespace YRDXH
  pctfree 10
  initrans 1
  maxtrans 255;
-- Add comments to the columns 
comment on column IPO_HOLDCOMMODITY.id
  is '���';
comment on column IPO_HOLDCOMMODITY.firmid
  is '������id';
comment on column IPO_HOLDCOMMODITY.commodityid
  is '��Ʒ����';
comment on column IPO_HOLDCOMMODITY.commodityname
  is '��Ʒ����';
comment on column IPO_HOLDCOMMODITY.bs_flag
  is '������־';
comment on column IPO_HOLDCOMMODITY.holdqty
  is '��������';
comment on column IPO_HOLDCOMMODITY.frozenqty
  is '��������';
comment on column IPO_HOLDCOMMODITY.quantityavailable
  is '��������';
comment on column IPO_HOLDCOMMODITY.evenprice
  is '���о���';
comment on column IPO_HOLDCOMMODITY.price
  is '�ּ�';
comment on column IPO_HOLDCOMMODITY.holdinggainsandlosses
  is '����ӯ��';
comment on column IPO_HOLDCOMMODITY.marketvalue
  is '������ֵ';
comment on column IPO_HOLDCOMMODITY.createtime
  is '����ʱ��';
-- Create/Recreate primary, unique and foreign key constraints 
alter table IPO_HOLDCOMMODITY
  add constraint PK_IPO_HOLDCOMMODITY primary key (ID)
  using index 
  tablespace YRDXH
  pctfree 10
  initrans 2
  maxtrans 255;
-- Create sequence 
create sequence SEQ_IPO_HOLDCOMMODITY
minvalue 1
maxvalue 9999999999999999999999999999
start with 21
increment by 1
cache 20;
 

/*==============================================================*/
/* Table: RELEASESUBSCRIPTION        �����깺��ϸ��             */
/*==============================================================*/

-- Create table
create table IPO_RELEASESUBSCRIPTION
(
  id                       NUMBER(32) not null,
  firmid                   VARCHAR2(64) not null,
  commodityid              VARCHAR2(64) not null,
  commodityname            VARCHAR2(64) not null,
  issueprice               NUMBER(15,2) not null,
  purchasetime             DATE not null,
  purchasequantity         NUMBER(32) not null,
  purchaseamount           NUMBER(15,2) not null,
  issuancefee              NUMBER(15,2) not null,
  refundablepurchaseamount NUMBER(15,2),
  refundableservicefee     NUMBER(15,2),
  createtime               DATE not null
)
tablespace YRDXH
  pctfree 10
  initrans 1
  maxtrans 255;
-- Add comments to the columns 
comment on column IPO_RELEASESUBSCRIPTION.id
  is '���';
comment on column IPO_RELEASESUBSCRIPTION.firmid
  is '������ID';
comment on column IPO_RELEASESUBSCRIPTION.commodityid
  is '��Ʒ����';
comment on column IPO_RELEASESUBSCRIPTION.commodityname
  is '��Ʒ����';
comment on column IPO_RELEASESUBSCRIPTION.issueprice
  is '���ж���';
comment on column IPO_RELEASESUBSCRIPTION.purchasetime
  is '�깺ʱ��';
comment on column IPO_RELEASESUBSCRIPTION.purchasequantity
  is '�깺����';
comment on column IPO_RELEASESUBSCRIPTION.purchaseamount
  is '�깺���';
comment on column IPO_RELEASESUBSCRIPTION.issuancefee
  is '���з����';
comment on column IPO_RELEASESUBSCRIPTION.refundablepurchaseamount
  is '�˻��깺���';
comment on column IPO_RELEASESUBSCRIPTION.refundableservicefee
  is '�˻����з����';
comment on column IPO_RELEASESUBSCRIPTION.createtime
  is '����ʱ��';
-- Create/Recreate primary, unique and foreign key constraints 
alter table IPO_RELEASESUBSCRIPTION
  add constraint PK_IPO_RELEASESUBSCRIPTION primary key (ID)
  using index 
  tablespace YRDXH 
  pctfree 10
  initrans 2
  maxtrans 255;

-- Create sequence 
create sequence SEQ_IPO_RELEASESUBSCRIPTION
minvalue 1
maxvalue 9999999999999999999999999999
start with 21
increment by 1
cache 20;

/*==============================================================*/
/* Table: TRANSACTIONDETAILS            ������ϸ��              */
/*==============================================================*/
CREATE TABLE IPO_TRANSACTIONDETAILS 
(
   ID                   NUMBER(32)                    NOT NULL,
   FIRMID               VARCHAR(64)                    NULL,
   ORDERID              VARCHAR(64)                    NULL,
   TRANSACTIONTIME      DATE                           NULL,
   COMMODITYID          VARCHAR(64)                    NULL,
   COMMODITYNAME        VARCHAR(64)                    NULL,
   TRANSACTIONPRICE     NUMBER(15,2)                  NULL,
   TRANSACTIONNUMBER    NUMBER                        NULL,
   BS_FLAG              NUMBER(2)                     NULL,
   B_MONEY              NUMBER(15,2)                  NULL,
   S_MONEY              NUMBER(15,2)                  NULL,
   FLOATINGLOSS         NUMBER(15,2)                  NULL,
   TRANSACTIONFEES      NUMBER(15,2)                  NULL,
   INSURANCE            NUMBER(15,2)                  NULL,
   WAREHOUSINGFEE       NUMBER(15,2)                  NULL,
   TRUSTEEFEE           NUMBER(15,2)                  NULL,
   CREATETIME           DATE                           NULL,
   CONSTRAINT PK_IPO_TRANSACTIONDETAILS PRIMARY KEY CLUSTERED (ID)
);

