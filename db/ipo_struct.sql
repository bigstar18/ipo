--------------------------------------------------
-- Export file for user TRADE_GNNT@SPOT.DEV.183 --
-- Created by hxx on 2016/2/25, 21:25:03 ---------
--------------------------------------------------

set define off
spool ipo_struct.log

prompt
prompt Creating table IPO_BALLOTNO_INFO
prompt ================================
prompt
create table IPO_BALLOTNO_INFO
(
  id               NUMBER not null,
  commodityid      VARCHAR2(32) not null,
  ballotnostartlen NUMBER not null,
  ballotnoendlen   NUMBER not null,
  ballotno         VARCHAR2(32),
  createtime       DATE not null
)
;
comment on table IPO_BALLOTNO_INFO
  is 'ҡ����Ϣ';
comment on column IPO_BALLOTNO_INFO.commodityid
  is '��Ʒ���';
comment on column IPO_BALLOTNO_INFO.ballotnostartlen
  is 'β����ʼλ';
comment on column IPO_BALLOTNO_INFO.ballotnoendlen
  is 'β�Ž���λ';
comment on column IPO_BALLOTNO_INFO.ballotno
  is 'β��';
comment on column IPO_BALLOTNO_INFO.createtime
  is 'β�Ŵ���ʱ��';
alter table IPO_BALLOTNO_INFO
  add primary key (ID);

prompt
prompt Creating table IPO_BILLOFLADING
prompt ===============================
prompt
create table IPO_BILLOFLADING
(
  id               NUMBER(32) not null,
  brokerid         VARCHAR2(64) not null,
  brokername       VARCHAR2(64) not null,
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
;
comment on table IPO_BILLOFLADING
  is '���ͻ�Ա�����';
comment on column IPO_BILLOFLADING.id
  is 'ID';
comment on column IPO_BILLOFLADING.brokerid
  is '��ԱID';
comment on column IPO_BILLOFLADING.brokername
  is '��Ա����';
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
alter table IPO_BILLOFLADING
  add constraint PK_IPO_BILLOFLADING primary key (ID);

prompt
prompt Creating table IPO_BREED
prompt ========================
prompt
create table IPO_BREED
(
  breedid            NUMBER(10) not null,
  breedname          VARCHAR2(50) not null,
  sortid             NUMBER(10) not null,
  contractfactor     NUMBER(12,2),
  minpricemove       NUMBER(10,2),
  spreadalgr         NUMBER(1),
  spreaduplmt        NUMBER(10,2),
  spreaddownlmt      NUMBER(10,2),
  minquantitymove    NUMBER(8),
  contractfactorname VARCHAR2(10) not null,
  minapplynum        NUMBER(10) not null,
  maxapplynum        NUMBER(32) not null,
  minapplyquamove    NUMBER(8) not null,
  publishalgr        NUMBER(1) not null,
  dealerpubcharatio  NUMBER(10,2) not null,
  mktdeapubcharatio  NUMBER(10,2) not null,
  publishercharatio  NUMBER(10,2) not null,
  mktpubcharatio     NUMBER(10,2) not null,
  contractcurrency   VARCHAR2(32) not null,
  tradedays          NUMBER(8) not null,
  tradealgr          NUMBER(1),
  buy                NUMBER(10,2),
  sell               NUMBER(10,2),
  mktbuyfeeradio     NUMBER(10,2),
  mktsellfeeradio    NUMBER(10,2),
  warehousedailyrent NUMBER(10,2),
  trusteedailyrent   NUMBER(10,2),
  insurancedailyrent NUMBER(10,2),
  freetrusteedays    NUMBER(8),
  deliveryunit       VARCHAR2(32),
  deliunittocontract NUMBER(10,2),
  registfeeradio     NUMBER(10,2),
  mktregistfeeradio  NUMBER(10,2),
  cancelfeeradio     NUMBER(10,2),
  mktcancelfeeradio  NUMBER(10,2),
  deliverycostbefore NUMBER(8),
  transferfeeradio   NUMBER(10,2)
)
;
comment on column IPO_BREED.breedid
  is 'Ʒ��ID';
comment on column IPO_BREED.breedname
  is 'Ʒ������';
comment on column IPO_BREED.sortid
  is '����ID(��Ӧmbreed���categoryid)';
comment on column IPO_BREED.contractfactor
  is '���׵�λ';
comment on column IPO_BREED.minpricemove
  is '��С�䶯�۸�';
comment on column IPO_BREED.spreadalgr
  is '�ǵ�ͣ���㷨';
comment on column IPO_BREED.spreaduplmt
  is '�Ƿ�����';
comment on column IPO_BREED.spreaddownlmt
  is '��������';
comment on column IPO_BREED.minquantitymove
  is '��С�䶯����';
comment on column IPO_BREED.contractfactorname
  is '���۵�λ(��Ӧmbreed���unit)';
comment on column IPO_BREED.minapplynum
  is '��С�깺����';
comment on column IPO_BREED.maxapplynum
  is '����깺����';
comment on column IPO_BREED.minapplyquamove
  is '��С�깺�䶯��';
comment on column IPO_BREED.publishalgr
  is '�����������㷨(1�����ٷֱ�  2��������ֵ)';
comment on column IPO_BREED.dealerpubcharatio
  is '�����̷��������ѱ���';
comment on column IPO_BREED.mktdeapubcharatio
  is '�����̷����������г��������';
comment on column IPO_BREED.publishercharatio
  is '�����̷��������ѱ���';
comment on column IPO_BREED.mktpubcharatio
  is '�����̷����������г��������';
comment on column IPO_BREED.contractcurrency
  is '���ۻ���(1��Ԫ 2����Ԫ)';
comment on column IPO_BREED.tradedays
  is 'T+N��������';
comment on column IPO_BREED.tradealgr
  is '�����������㷨';
comment on column IPO_BREED.buy
  is '����';
comment on column IPO_BREED.sell
  is '����';
comment on column IPO_BREED.mktbuyfeeradio
  is '���������г��������';
comment on column IPO_BREED.mktsellfeeradio
  is '�����������г��������';
comment on column IPO_BREED.warehousedailyrent
  is '�ִ�������׼';
comment on column IPO_BREED.trusteedailyrent
  is '���йܷѱ�׼';
comment on column IPO_BREED.insurancedailyrent
  is '�ձ��շѱ�׼';
comment on column IPO_BREED.freetrusteedays
  is '���й�����';
comment on column IPO_BREED.deliveryunit
  is '���λ';
comment on column IPO_BREED.deliunittocontract
  is '�����뽻�׵�λ����';
comment on column IPO_BREED.registfeeradio
  is 'ע����ñ���';
comment on column IPO_BREED.mktregistfeeradio
  is 'ע����г��������';
comment on column IPO_BREED.cancelfeeradio
  is 'ע�����ñ���';
comment on column IPO_BREED.mktcancelfeeradio
  is 'ע�����г��������';
comment on column IPO_BREED.deliverycostbefore
  is '��������ü۸���ǰ����';
comment on column IPO_BREED.transferfeeradio
  is '�������ñ���';
alter table IPO_BREED
  add constraint PK_IPO_BREED primary key (BREEDID);

prompt
prompt Creating table IPO_CHARGE_ITEM
prompt ==============================
prompt
create table IPO_CHARGE_ITEM
(
  id          VARCHAR2(100) not null,
  name        VARCHAR2(100) default '',
  type        NUMBER(1),
  parent_id   VARCHAR2(100) default 0,
  sort_id     NUMBER(5),
  remark      VARCHAR2(200),
  delete_flag NUMBER(1) default 0,
  leaf        CHAR(1),
  create_user VARCHAR2(32),
  create_date DATE,
  update_user VARCHAR2(32),
  update_date DATE
)
;
comment on table IPO_CHARGE_ITEM
  is '��������';
comment on column IPO_CHARGE_ITEM.id
  is '���ñ���';
comment on column IPO_CHARGE_ITEM.name
  is '��������';
comment on column IPO_CHARGE_ITEM.type
  is '��������,1:һ���Է���,2:�����Է���';
comment on column IPO_CHARGE_ITEM.parent_id
  is '�ϼ����ñ���';
comment on column IPO_CHARGE_ITEM.sort_id
  is '����';
comment on column IPO_CHARGE_ITEM.remark
  is '��ע';
comment on column IPO_CHARGE_ITEM.delete_flag
  is 'ɾ����� 0:��Ч 1:��Ч';
comment on column IPO_CHARGE_ITEM.leaf
  is '�Ƿ�Ҷ�ӽڵ�';
comment on column IPO_CHARGE_ITEM.create_user
  is '������';
comment on column IPO_CHARGE_ITEM.create_date
  is '����ʱ��';
comment on column IPO_CHARGE_ITEM.update_user
  is '�޸���';
comment on column IPO_CHARGE_ITEM.update_date
  is '�޸�ʱ��';
create index IND_IPO_CHARGE_DELETE_FLAG on IPO_CHARGE_ITEM (DELETE_FLAG);
create index IND_IPO_CHARGE_PARENT_ID on IPO_CHARGE_ITEM (PARENT_ID);
create index IND_IPO_CHARGE_SORT_ID on IPO_CHARGE_ITEM (SORT_ID);
create index IND_IPO_CHARGE_TYPE on IPO_CHARGE_ITEM (TYPE);
alter table IPO_CHARGE_ITEM
  add primary key (ID);

prompt
prompt Creating table IPO_CHARGE_ROLE
prompt ==============================
prompt
create table IPO_CHARGE_ROLE
(
  id             NUMBER not null,
  business_code  VARCHAR2(50),
  role_code      VARCHAR2(50),
  charge_id      VARCHAR2(100),
  charge_pattern NUMBER(1),
  amount         NUMBER(15,3),
  delete_flag    NUMBER(1) default 0,
  create_user    VARCHAR2(32),
  create_date    DATE,
  update_user    VARCHAR2(32),
  update_date    DATE
)
;
comment on table IPO_CHARGE_ROLE
  is 'ͨ�÷������ñ�';
comment on column IPO_CHARGE_ROLE.id
  is '���� SEQ_IPO_CHARGE_ROLE';
comment on column IPO_CHARGE_ROLE.business_code
  is 'ҵ�����';
comment on column IPO_CHARGE_ROLE.role_code
  is '��ɫ����';
comment on column IPO_CHARGE_ROLE.charge_id
  is '������';
comment on column IPO_CHARGE_ROLE.charge_pattern
  is '�շ�ģʽ ,1:�ٷֱ� 2:�̶�ֵ';
comment on column IPO_CHARGE_ROLE.amount
  is '���';
comment on column IPO_CHARGE_ROLE.delete_flag
  is 'ɾ����� ,0:δɾ����1:��ɾ��';
comment on column IPO_CHARGE_ROLE.create_user
  is '������';
comment on column IPO_CHARGE_ROLE.create_date
  is '����ʱ��';
comment on column IPO_CHARGE_ROLE.update_user
  is '�޸���';
comment on column IPO_CHARGE_ROLE.update_date
  is '�޸�ʱ��';
create index IND_IPO_CHARGE_ROLE_DELETEFLAG on IPO_CHARGE_ROLE (DELETE_FLAG);
alter table IPO_CHARGE_ROLE
  add primary key (ID);

prompt
prompt Creating table IPO_CHARGE_USER
prompt ==============================
prompt
create table IPO_CHARGE_USER
(
  id             NUMBER not null,
  business_code  VARCHAR2(50),
  role_code      VARCHAR2(50),
  user_id        VARCHAR2(32),
  charge_id      VARCHAR2(100),
  charge_pattern NUMBER(1),
  amount         NUMBER(15,3),
  delete_flag    NUMBER(1) default 0,
  create_user    VARCHAR2(32),
  create_date    DATE,
  update_user    VARCHAR2(32),
  update_date    DATE
)
;
comment on table IPO_CHARGE_USER
  is '����������ñ�';
comment on column IPO_CHARGE_USER.id
  is '���� SEQ_IPO_CHARGE_USER';
comment on column IPO_CHARGE_USER.business_code
  is 'ҵ�����';
comment on column IPO_CHARGE_USER.role_code
  is '��ɫ����';
comment on column IPO_CHARGE_USER.user_id
  is '�û�ID';
comment on column IPO_CHARGE_USER.charge_id
  is '������';
comment on column IPO_CHARGE_USER.charge_pattern
  is '�շ�ģʽ ,1:�ٷֱ� 2:�̶�ֵ';
comment on column IPO_CHARGE_USER.amount
  is '���';
comment on column IPO_CHARGE_USER.delete_flag
  is 'ɾ����� ,0:δɾ����1:��ɾ��';
comment on column IPO_CHARGE_USER.create_user
  is '������';
comment on column IPO_CHARGE_USER.create_date
  is '����ʱ��';
comment on column IPO_CHARGE_USER.update_user
  is '�޸���';
comment on column IPO_CHARGE_USER.update_date
  is '�޸�ʱ��';
create index IND_IPO_CHARGE_USER_DELETEFLAG on IPO_CHARGE_USER (DELETE_FLAG);
alter table IPO_CHARGE_USER
  add primary key (ID);

prompt
prompt Creating table IPO_CLEARSTATUS
prompt ==============================
prompt
create table IPO_CLEARSTATUS
(
  actionid   NUMBER(3) not null,
  actionnote VARCHAR2(32) not null,
  status     CHAR(1) not null,
  finishtime DATE
)
;
alter table IPO_CLEARSTATUS
  add primary key (ACTIONID);

prompt
prompt Creating table IPO_COMMODITY_CONF
prompt =================================
prompt
create table IPO_COMMODITY_CONF
(
  commodityid        VARCHAR2(32) not null,
  commodityname      VARCHAR2(32) not null,
  price              NUMBER(10,2) not null,
  units              NUMBER not null,
  counts             NUMBER not null,
  starttime          DATE not null,
  endtime            DATE not null,
  maxapplynum        NUMBER(32) not null,
  status             NUMBER,
  breedid            NUMBER(10) not null,
  tradedays          NUMBER(8) not null,
  codedelivery       NUMBER not null,
  nonissuereg        NUMBER not null,
  pubmemberid        VARCHAR2(32) not null,
  minapplynum        NUMBER(10) not null,
  minapplyquamove    NUMBER(8) not null,
  publishalgr        NUMBER(1) not null,
  dealerpubcharatio  NUMBER(10,2) not null,
  mktdeapubcharatio  NUMBER(10,2) not null,
  publishercharatio  NUMBER(10,2) not null,
  mktpubcharatio     NUMBER(10,2) not null,
  currstatus         NUMBER(1) not null,
  supervisedprice    NUMBER(10,2),
  listingdate        DATE not null,
  lasttradate        DATE not null,
  contractfactor     NUMBER(12,2) not null,
  contractfactorname VARCHAR2(32) not null,
  mapperid           VARCHAR2(32),
  minpricemove       NUMBER(10,2),
  spreadalgr         NUMBER(1),
  spreaduplmt        NUMBER(10,2),
  spreaddownlmt      NUMBER(10,2),
  minquantitymove    NUMBER(8),
  tradealgr          NUMBER(1),
  buy                NUMBER(10,2),
  sell               NUMBER(10,2),
  mktbuyfeeradio     NUMBER(10,2),
  mktsellfeeradio    NUMBER(10,2),
  warehousedailyrent NUMBER(10,2),
  warehousestartday  DATE,
  trusteedailyrent   NUMBER(10,2),
  insurancedailyrent NUMBER(10,2),
  insurancestartday  DATE,
  freetrusteedays    NUMBER(8),
  deliveryunit       VARCHAR2(32),
  deliunittocontract NUMBER(10,2),
  deliverystartday   DATE,
  registfeeradio     NUMBER(10,2),
  mktregistfeeradio  NUMBER(10,2),
  cancelfeeradio     NUMBER(10,2),
  mktcancelfeeradio  NUMBER(10,2),
  deliverycostbefore NUMBER(8),
  commdetails        VARCHAR2(200),
  transferfeeradio   NUMBER(10,2),
  deliveryprop       NUMBER(1)
)
;
comment on column IPO_COMMODITY_CONF.commodityid
  is '��Ʒ���';
comment on column IPO_COMMODITY_CONF.commodityname
  is '��Ʒ����';
comment on column IPO_COMMODITY_CONF.price
  is '���м�';
comment on column IPO_COMMODITY_CONF.units
  is '���۵�λ';
comment on column IPO_COMMODITY_CONF.counts
  is '��������';
comment on column IPO_COMMODITY_CONF.starttime
  is '��ʼʱ��';
comment on column IPO_COMMODITY_CONF.endtime
  is '����ʱ��';
comment on column IPO_COMMODITY_CONF.maxapplynum
  is '�깺��ȣ�����깺������';
comment on column IPO_COMMODITY_CONF.status
  is '1��δ���
2�������
3����ҡ��
4���ѽ���';
comment on column IPO_COMMODITY_CONF.breedid
  is 'Ʒ�ֱ��';
comment on column IPO_COMMODITY_CONF.tradedays
  is 'T+N��������';
comment on column IPO_COMMODITY_CONF.codedelivery
  is '�Ƿ����������(0������  1���ر�)';
comment on column IPO_COMMODITY_CONF.nonissuereg
  is '�Ƿ���ע��(0����  1����)';
comment on column IPO_COMMODITY_CONF.pubmemberid
  is '���л�Ա���';
comment on column IPO_COMMODITY_CONF.minapplynum
  is '��С�깺����';
comment on column IPO_COMMODITY_CONF.minapplyquamove
  is '��С�깺�䶯��';
comment on column IPO_COMMODITY_CONF.publishalgr
  is '�����������㷨(1�����ٷֱ�  2��������ֵ)';
comment on column IPO_COMMODITY_CONF.dealerpubcharatio
  is '�����̷��������ѱ���';
comment on column IPO_COMMODITY_CONF.mktdeapubcharatio
  is '�����̷����������г��������';
comment on column IPO_COMMODITY_CONF.publishercharatio
  is '�����̷��������ѱ���';
comment on column IPO_COMMODITY_CONF.mktpubcharatio
  is '�����̷����������г��������';
comment on column IPO_COMMODITY_CONF.currstatus
  is '��ǰ״̬ 0����Ч 2����ͣ����';
comment on column IPO_COMMODITY_CONF.supervisedprice
  is '����ָ����';
comment on column IPO_COMMODITY_CONF.listingdate
  is '��������';
comment on column IPO_COMMODITY_CONF.lasttradate
  is '�������';
comment on column IPO_COMMODITY_CONF.contractfactor
  is '���׵�λ';
comment on column IPO_COMMODITY_CONF.contractfactorname
  is '���׵�λ�����ʣ�';
comment on column IPO_COMMODITY_CONF.mapperid
  is '��Ӧ�ֻ���ƷID';
comment on column IPO_COMMODITY_CONF.minpricemove
  is '��С�䶯�۸�';
comment on column IPO_COMMODITY_CONF.spreadalgr
  is '�ǵ�ͣ���㷨';
comment on column IPO_COMMODITY_CONF.spreaduplmt
  is '�Ƿ�����';
comment on column IPO_COMMODITY_CONF.spreaddownlmt
  is '��������';
comment on column IPO_COMMODITY_CONF.minquantitymove
  is '��С�䶯��';
comment on column IPO_COMMODITY_CONF.tradealgr
  is '�깺�������㷨';
comment on column IPO_COMMODITY_CONF.buy
  is '����';
comment on column IPO_COMMODITY_CONF.sell
  is '����';
comment on column IPO_COMMODITY_CONF.mktbuyfeeradio
  is '���������г��������';
comment on column IPO_COMMODITY_CONF.mktsellfeeradio
  is '�����������г��������';
comment on column IPO_COMMODITY_CONF.warehousedailyrent
  is '�ִ�������׼';
comment on column IPO_COMMODITY_CONF.warehousestartday
  is '�ִ��������ȡ��ʼ����';
comment on column IPO_COMMODITY_CONF.trusteedailyrent
  is '���йܷѱ�׼';
comment on column IPO_COMMODITY_CONF.insurancedailyrent
  is '�ձ��շѱ�׼';
comment on column IPO_COMMODITY_CONF.insurancestartday
  is '�ձ��շ���ȡ��ʼ����';
comment on column IPO_COMMODITY_CONF.freetrusteedays
  is '���й�����';
comment on column IPO_COMMODITY_CONF.deliveryunit
  is '���λ';
comment on column IPO_COMMODITY_CONF.deliunittocontract
  is '�����뽻�׵�λ����';
comment on column IPO_COMMODITY_CONF.deliverystartday
  is '������ʼ����';
comment on column IPO_COMMODITY_CONF.registfeeradio
  is 'ע����ñ���';
comment on column IPO_COMMODITY_CONF.mktregistfeeradio
  is 'ע����г��������';
comment on column IPO_COMMODITY_CONF.cancelfeeradio
  is 'ע�����ñ���';
comment on column IPO_COMMODITY_CONF.mktcancelfeeradio
  is 'ע�����г��������';
comment on column IPO_COMMODITY_CONF.deliverycostbefore
  is '��������ü۸���ǰ����';
comment on column IPO_COMMODITY_CONF.commdetails
  is '��Ʒ��ϸ����';
comment on column IPO_COMMODITY_CONF.transferfeeradio
  is '�������ñ���';
comment on column IPO_COMMODITY_CONF.deliveryprop
  is '�Ƿ����ý������� ��1 �� 2 ��';
alter table IPO_COMMODITY_CONF
  add constraint PK_IPO_COMMODITY_CONF primary key (COMMODITYID);

prompt
prompt Creating table IPO_COMMODITY_SALE
prompt =================================
prompt
create table IPO_COMMODITY_SALE
(
  commodityid   VARCHAR2(32) not null,
  commodityname VARCHAR2(32) not null,
  price         NUMBER(10,2) not null,
  units         NUMBER not null,
  counts        NUMBER not null,
  starttime     DATE not null,
  endtime       DATE not null,
  maxapplynum   NUMBER,
  status        NUMBER,
  id            NUMBER not null
)
;
comment on table IPO_COMMODITY_SALE
  is '��Ʒ�б�';
comment on column IPO_COMMODITY_SALE.commodityid
  is '��Ʒ���';
comment on column IPO_COMMODITY_SALE.commodityname
  is '��Ʒ����';
comment on column IPO_COMMODITY_SALE.price
  is '���ۼ�';
comment on column IPO_COMMODITY_SALE.units
  is '���۵�λ';
comment on column IPO_COMMODITY_SALE.counts
  is '��������';
comment on column IPO_COMMODITY_SALE.starttime
  is '��ʼʱ��';
comment on column IPO_COMMODITY_SALE.endtime
  is '����ʱ��';
comment on column IPO_COMMODITY_SALE.maxapplynum
  is '�깺���';
comment on column IPO_COMMODITY_SALE.status
  is '"1";// δ��� "2";// ������ 3// ��ǩ��� 31";// ��ǩ�� 32";// ���ü������ "4";// ������� "41";// ������';
comment on column IPO_COMMODITY_SALE.id
  is '����';
alter table IPO_COMMODITY_SALE
  add constraint PK_IPO_COMMODITY_SALE primary key (ID);

prompt
prompt Creating table IPO_DATA_ITEM
prompt ============================
prompt
create table IPO_DATA_ITEM
(
  code        VARCHAR2(50) not null,
  value       VARCHAR2(200),
  type        VARCHAR2(100) not null,
  remark      VARCHAR2(200),
  delete_flag NUMBER(1) default 0
)
;
comment on table IPO_DATA_ITEM
  is '���������ñ�';
comment on column IPO_DATA_ITEM.code
  is '����';
comment on column IPO_DATA_ITEM.value
  is 'ֵ';
comment on column IPO_DATA_ITEM.type
  is '���';
comment on column IPO_DATA_ITEM.remark
  is '��ע';
comment on column IPO_DATA_ITEM.delete_flag
  is 'ɾ����� 0:��Ч , 1:��Ч';
create index IND_IPO_DATA_ITEM_DELETE_FLAG on IPO_DATA_ITEM (DELETE_FLAG);
alter table IPO_DATA_ITEM
  add constraint IPO_DATA_ITEM_PK primary key (CODE, TYPE);

prompt
prompt Creating table IPO_DEBITFLOW
prompt ============================
prompt
create table IPO_DEBITFLOW
(
  id            NUMBER not null,
  business_type VARCHAR2(50),
  charge_type   VARCHAR2(50),
  commodity_id  VARCHAR2(32),
  order_id      VARCHAR2(32),
  debit_state   NUMBER(2),
  payer         VARCHAR2(40),
  amount        NUMBER(15,2),
  debit_mode    NUMBER(2),
  debit_channel NUMBER(2),
  debit_date    DATE,
  remark        VARCHAR2(500),
  buy_back_flag NUMBER(1) default 0,
  create_user   VARCHAR2(32),
  create_date   DATE,
  update_user   VARCHAR2(32),
  update_date   DATE
)
;
comment on table IPO_DEBITFLOW
  is '�ۿ���ˮ��¼';
comment on column IPO_DEBITFLOW.id
  is '��ˮ�� : SEQ_IPO_DEBITFLOW';
comment on column IPO_DEBITFLOW.business_type
  is 'ҵ������';
comment on column IPO_DEBITFLOW.charge_type
  is '��������';
comment on column IPO_DEBITFLOW.commodity_id
  is '��Ʒ���';
comment on column IPO_DEBITFLOW.order_id
  is '����';
comment on column IPO_DEBITFLOW.debit_state
  is '�ۿ�״̬ :1����ɹ� 2 �ۿ�ɹ�';
comment on column IPO_DEBITFLOW.payer
  is '������';
comment on column IPO_DEBITFLOW.amount
  is '�ۿ���';
comment on column IPO_DEBITFLOW.debit_mode
  is '�ۿʽ:1 ���Ͽۿ� 2 ���¿ۿ�';
comment on column IPO_DEBITFLOW.debit_channel
  is '�ۿ�����:1 ��֤��ۿ� 2 :�ֽ� 3:ˢ�� 4:֧���� 5:΢��';
comment on column IPO_DEBITFLOW.debit_date
  is '�ۿ�ʱ��';
comment on column IPO_DEBITFLOW.remark
  is '��ע';
comment on column IPO_DEBITFLOW.buy_back_flag
  is '������� 0:δ���� 1 :�ѷ���';
comment on column IPO_DEBITFLOW.create_user
  is '������';
comment on column IPO_DEBITFLOW.create_date
  is '����ʱ��';
comment on column IPO_DEBITFLOW.update_user
  is '�޸���';
comment on column IPO_DEBITFLOW.update_date
  is '�޸�ʱ��';
create index IND_IPO_DEBITFLOW_BACK_FLAG on IPO_DEBITFLOW (BUY_BACK_FLAG);
create index IND_IPO_DEBITFLOW_BUS_TYPE on IPO_DEBITFLOW (BUSINESS_TYPE);
create index IND_IPO_DEBITFLOW_CHARGE_TYPE on IPO_DEBITFLOW (CHARGE_TYPE);
create index IND_IPO_DEBITFLOW_COMMODITY_ID on IPO_DEBITFLOW (COMMODITY_ID);
create index IND_IPO_DEBITFLOW_DEBIT_MODE on IPO_DEBITFLOW (DEBIT_MODE);
create index IND_IPO_DEBITFLOW_STATE on IPO_DEBITFLOW (DEBIT_STATE);
alter table IPO_DEBITFLOW
  add primary key (ID);

prompt
prompt Creating table IPO_DELIVERY
prompt ===========================
prompt
create table IPO_DELIVERY
(
  id            NUMBER(32) not null,
  brokerid      VARCHAR2(64) not null,
  brokername    VARCHAR2(64) not null,
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
;
comment on table IPO_DELIVERY
  is '���ͻ�Ա��Ʒ���';
comment on column IPO_DELIVERY.id
  is '���';
comment on column IPO_DELIVERY.brokerid
  is '��ԱID';
comment on column IPO_DELIVERY.brokername
  is '��Ա����';
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
alter table IPO_DELIVERY
  add constraint PK_IPO_DELIVERY primary key (ID);

prompt
prompt Creating table IPO_DELIVERYORDER
prompt ================================
prompt
create table IPO_DELIVERYORDER
(
  deliveryorder_id VARCHAR2(32) not null,
  commodity_id     VARCHAR2(32) not null,
  commodity_name   VARCHAR2(32),
  dealer_id        VARCHAR2(50) not null,
  dealer_name      VARCHAR2(32),
  warehouse_id     VARCHAR2(32) not null,
  warehouse_name   VARCHAR2(32),
  delivery_quatity NUMBER(12) not null,
  delivery_counts  NUMBER(12),
  delivery_method  VARCHAR2(32) not null,
  method_id        VARCHAR2(32),
  unit             VARCHAR2(32),
  delivery_date    DATE not null,
  apply_date       DATE not null,
  approval_status  VARCHAR2(32),
  approvers        VARCHAR2(32),
  approve_date     DATE,
  canceler         VARCHAR2(32),
  cancel_date      DATE,
  position         NUMBER(12),
  remarks          VARCHAR2(200)
)
;
comment on column IPO_DELIVERYORDER.deliveryorder_id
  is '�������';
comment on column IPO_DELIVERYORDER.commodity_id
  is '��Ʒ����';
comment on column IPO_DELIVERYORDER.commodity_name
  is '��Ʒ����';
comment on column IPO_DELIVERYORDER.dealer_id
  is '�����̴���';
comment on column IPO_DELIVERYORDER.dealer_name
  is '����������';
comment on column IPO_DELIVERYORDER.warehouse_id
  is '�ֿ����';
comment on column IPO_DELIVERYORDER.warehouse_name
  is '�ֿ�����';
comment on column IPO_DELIVERYORDER.delivery_quatity
  is '��������';
comment on column IPO_DELIVERYORDER.delivery_counts
  is '�������';
comment on column IPO_DELIVERYORDER.delivery_method
  is '�����ʽ';
comment on column IPO_DELIVERYORDER.method_id
  is '���������ʽID';
comment on column IPO_DELIVERYORDER.unit
  is '��λ';
comment on column IPO_DELIVERYORDER.delivery_date
  is '�������';
comment on column IPO_DELIVERYORDER.apply_date
  is '��������';
comment on column IPO_DELIVERYORDER.approval_status
  is 'REGISTER("001", "ע��"), MARKETPASS("002001", "�г�ͨ��"), MARKETNOPASS(
				"002002", "�г�����"), PRINTED("003001", "�������ӡ"), TRANSFERRED(
				"003002", "�ѻ�Ȩ����"), EXPRESSCOSTSET("003003", "���������ͷ���"), CONFIRM(
				"003003001", "��ȷ��"), WAREHOUSEPASS("004001", "�ֿ�ͨ��"), WAREHOUSENOPASS(
				"004002", "�ֿⲵ��"), WAREHOUSEOUT("005", "�ѳ���"), CANCEL("006",
				"�ѷϳ�");
';
comment on column IPO_DELIVERYORDER.approvers
  is '������';
comment on column IPO_DELIVERYORDER.approve_date
  is '��������';
comment on column IPO_DELIVERYORDER.canceler
  is '������';
comment on column IPO_DELIVERYORDER.cancel_date
  is '��������';
comment on column IPO_DELIVERYORDER.position
  is '�ֲ���';
comment on column IPO_DELIVERYORDER.remarks
  is '��ע';
alter table IPO_DELIVERYORDER
  add constraint PK_IPO_DELIVERYORDER primary key (DELIVERYORDER_ID);

prompt
prompt Creating table IPO_DELIVERY_COST
prompt ================================
prompt
create table IPO_DELIVERY_COST
(
  delivery_id     VARCHAR2(32) not null,
  delivery_method VARCHAR2(32),
  apply_date      DATE,
  insurance       NUMBER(12,2),
  trustee_fee     NUMBER(12,2),
  warehousing_fee NUMBER(12,2),
  delivery_fee    NUMBER(12,2)
)
;
comment on column IPO_DELIVERY_COST.delivery_id
  is '�������';
comment on column IPO_DELIVERY_COST.delivery_method
  is '�����ʽ';
comment on column IPO_DELIVERY_COST.apply_date
  is '��������';
comment on column IPO_DELIVERY_COST.insurance
  is '���շ�';
comment on column IPO_DELIVERY_COST.trustee_fee
  is '�йܷ�';
comment on column IPO_DELIVERY_COST.warehousing_fee
  is '�ִ���';
comment on column IPO_DELIVERY_COST.delivery_fee
  is '���������';
alter table IPO_DELIVERY_COST
  add constraint PK_IPO_DELIVERY_COST primary key (DELIVERY_ID);

prompt
prompt Creating table IPO_DELIVERY_PROP
prompt ================================
prompt
create table IPO_DELIVERY_PROP
(
  deliverypropid NUMBER(10) not null,
  commodityid    VARCHAR2(32),
  propertyid     NUMBER(10),
  sortno         NUMBER(10)
)
;
comment on column IPO_DELIVERY_PROP.deliverypropid
  is '����';
comment on column IPO_DELIVERY_PROP.commodityid
  is '��ƷID';
comment on column IPO_DELIVERY_PROP.propertyid
  is '����ID';
comment on column IPO_DELIVERY_PROP.sortno
  is '����ֵ��Ӧ��key';

prompt
prompt Creating table IPO_DISTRIBUTION
prompt ===============================
prompt
create table IPO_DISTRIBUTION
(
  id            NUMBER(8) not null,
  userid        VARCHAR2(32) not null,
  commodityname VARCHAR2(32) not null,
  startnumber   NUMBER not null,
  pcounts       NUMBER(8) not null,
  ptime         TIMESTAMP(6) not null,
  zcounts       NUMBER(8),
  numbers       BLOB,
  commodityid   VARCHAR2(32),
  frozen        NUMBER default 1 not null,
  tradingamount NUMBER(15,2),
  counterfee    NUMBER(15,2),
  frozendate    DATE
)
;
comment on table IPO_DISTRIBUTION
  is '��ţ���ǩ���';
comment on column IPO_DISTRIBUTION.userid
  is '�ͻ����';
comment on column IPO_DISTRIBUTION.commodityname
  is '��Ʒ����';
comment on column IPO_DISTRIBUTION.startnumber
  is '��ʼ���';
comment on column IPO_DISTRIBUTION.pcounts
  is '�������';
comment on column IPO_DISTRIBUTION.ptime
  is '���ʱ��';
comment on column IPO_DISTRIBUTION.zcounts
  is '��ǩ����';
comment on column IPO_DISTRIBUTION.numbers
  is '��ǩ����';
comment on column IPO_DISTRIBUTION.commodityid
  is '��Ʒ���';
comment on column IPO_DISTRIBUTION.frozen
  is '�Ƿ񶳽�(1��ʾδ����2��ʾ�Ѷ���)��3��ʾ�����';
comment on column IPO_DISTRIBUTION.tradingamount
  is '�ɽ����';
comment on column IPO_DISTRIBUTION.counterfee
  is '������';
comment on column IPO_DISTRIBUTION.frozendate
  is '��������';
alter table IPO_DISTRIBUTION
  add primary key (ID);

prompt
prompt Creating table IPO_DISTRIBUTION_RULE
prompt ====================================
prompt
create table IPO_DISTRIBUTION_RULE
(
  id              NUMBER,
  commodityid     VARCHAR2(32),
  hold_ratio      NUMBER,
  purchase_ratio  NUMBER,
  maxqty          NUMBER,
  create_user     VARCHAR2(32),
  create_date     DATE,
  update_user     VARCHAR2(32),
  update_date     DATE,
  delete_flag     NUMBER(1) default 0,
  hold_unit_value NUMBER
)
;
comment on table IPO_DISTRIBUTION_RULE
  is '��ǩ����';
comment on column IPO_DISTRIBUTION_RULE.id
  is '����';
comment on column IPO_DISTRIBUTION_RULE.commodityid
  is '��Ʒ���';
comment on column IPO_DISTRIBUTION_RULE.hold_ratio
  is '�ֲ�������ǩ����';
comment on column IPO_DISTRIBUTION_RULE.purchase_ratio
  is '�깺��������ǩ����';
comment on column IPO_DISTRIBUTION_RULE.maxqty
  is '���˻������ǩ��';
comment on column IPO_DISTRIBUTION_RULE.create_user
  is '������';
comment on column IPO_DISTRIBUTION_RULE.create_date
  is '����ʱ��';
comment on column IPO_DISTRIBUTION_RULE.update_user
  is '�޸���';
comment on column IPO_DISTRIBUTION_RULE.update_date
  is '�޸�ʱ��';
comment on column IPO_DISTRIBUTION_RULE.delete_flag
  is 'ɾ����� 0:��Ч 1:��Ч';
comment on column IPO_DISTRIBUTION_RULE.hold_unit_value
  is '�ֲֵ�λ��ֵ';

prompt
prompt Creating table IPO_EXPRESS
prompt ==========================
prompt
create table IPO_EXPRESS
(
  express_id VARCHAR2(32) not null,
  address    VARCHAR2(200),
  cost       NUMBER(32,2),
  receiver   VARCHAR2(32),
  tel        VARCHAR2(32)
)
;
alter table IPO_EXPRESS
  add constraint PK_IPO_EXPRESS primary key (EXPRESS_ID);

prompt
prompt Creating table IPO_FIRMREWARDDEAIL
prompt ==================================
prompt
create table IPO_FIRMREWARDDEAIL
(
  firmid           VARCHAR2(32) not null,
  commodityid      VARCHAR2(16) not null,
  cleardate        DATE not null,
  brokerid         VARCHAR2(16) not null,
  brokername       VARCHAR2(128),
  firstpay         NUMBER(15,2) not null,
  secondpay        NUMBER(15,2) not null,
  reward           NUMBER(15,2) not null,
  marketreward     NUMBER(15,2) not null,
  brokereachdivide NUMBER(15,2) not null,
  commodityname    VARCHAR2(32),
  breedid          NUMBER(10),
  breedname        VARCHAR2(50),
  business_type    VARCHAR2(50),
  charge_type      VARCHAR2(50),
  id               NUMBER not null,
  trademoney       NUMBER(15,2)
)
;
comment on table IPO_FIRMREWARDDEAIL
  is '������Ӷ����ϸ��';
comment on column IPO_FIRMREWARDDEAIL.firmid
  is '������id';
comment on column IPO_FIRMREWARDDEAIL.commodityid
  is '��Ʒ����';
comment on column IPO_FIRMREWARDDEAIL.cleardate
  is '��������';
comment on column IPO_FIRMREWARDDEAIL.brokerid
  is '������id';
comment on column IPO_FIRMREWARDDEAIL.brokername
  is '����������';
comment on column IPO_FIRMREWARDDEAIL.firstpay
  is '�׿�';
comment on column IPO_FIRMREWARDDEAIL.secondpay
  is 'β��';
comment on column IPO_FIRMREWARDDEAIL.reward
  is '������ʵ��������';
comment on column IPO_FIRMREWARDDEAIL.marketreward
  is '������ʵ��������';
comment on column IPO_FIRMREWARDDEAIL.brokereachdivide
  is '�����������м����������ѷֳ�';
comment on column IPO_FIRMREWARDDEAIL.commodityname
  is '��Ʒ����';
comment on column IPO_FIRMREWARDDEAIL.breedid
  is 'Ʒ�ֱ���';
comment on column IPO_FIRMREWARDDEAIL.breedname
  is 'Ʒ������';
comment on column IPO_FIRMREWARDDEAIL.business_type
  is 'ҵ������';
comment on column IPO_FIRMREWARDDEAIL.charge_type
  is '��������';
comment on column IPO_FIRMREWARDDEAIL.id
  is '����';
comment on column IPO_FIRMREWARDDEAIL.trademoney
  is '���׶�';
alter table IPO_FIRMREWARDDEAIL
  add constraint PK_IPO_FIRMREWARDDEAIL primary key (ID);

prompt
prompt Creating table IPO_HOLDCOMMODITY
prompt ================================
prompt
create table IPO_HOLDCOMMODITY
(
  id                    NUMBER(32) not null,
  brokerid              VARCHAR2(64) not null,
  brokername            VARCHAR2(64) not null,
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
;
comment on table IPO_HOLDCOMMODITY
  is '���ͻ�Ա��Ʒ����';
comment on column IPO_HOLDCOMMODITY.id
  is '���';
comment on column IPO_HOLDCOMMODITY.brokerid
  is '��ԱID';
comment on column IPO_HOLDCOMMODITY.brokername
  is '��Ա����';
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
alter table IPO_HOLDCOMMODITY
  add constraint PK_IPO_HOLDCOMMODITY primary key (ID);

prompt
prompt Creating table IPO_NOTTRADEDAY
prompt ==============================
prompt
create table IPO_NOTTRADEDAY
(
  id         NUMBER(10) not null,
  week       VARCHAR2(30),
  day        VARCHAR2(1024),
  modifytime DATE not null
)
;
comment on column IPO_NOTTRADEDAY.week
  is '���ڼ�';
comment on column IPO_NOTTRADEDAY.day
  is '����';
comment on column IPO_NOTTRADEDAY.modifytime
  is '�޸�ʱ��';
alter table IPO_NOTTRADEDAY
  add constraint PK_IPO_NOTTRADEDAY primary key (ID);

prompt
prompt Creating table IPO_NUMBEROFRECORDS
prompt ==================================
prompt
create table IPO_NUMBEROFRECORDS
(
  id          NUMBER(8) not null,
  commodityid VARCHAR2(32),
  counts      NUMBER,
  nowtime     TIMESTAMP(6)
)
;
comment on column IPO_NUMBEROFRECORDS.commodityid
  is '��Ʒ���';
comment on column IPO_NUMBEROFRECORDS.counts
  is '�������';
comment on column IPO_NUMBEROFRECORDS.nowtime
  is 'ʱ��';
alter table IPO_NUMBEROFRECORDS
  add primary key (ID);

prompt
prompt Creating table IPO_NUMBEROFRECORDS_H
prompt ====================================
prompt
create table IPO_NUMBEROFRECORDS_H
(
  id          NUMBER(8) not null,
  commodityid VARCHAR2(32),
  counts      NUMBER,
  nowtime     TIMESTAMP(6)
)
;
comment on column IPO_NUMBEROFRECORDS_H.id
  is 'ID';
comment on column IPO_NUMBEROFRECORDS_H.commodityid
  is '��Ʒ����';
comment on column IPO_NUMBEROFRECORDS_H.nowtime
  is 'ʱ��';
alter table IPO_NUMBEROFRECORDS_H
  add primary key (ID);

prompt
prompt Creating table IPO_ORDER
prompt ========================
prompt
create table IPO_ORDER
(
  orderid          NUMBER not null,
  userid           VARCHAR2(32) not null,
  username         VARCHAR2(32),
  commodityid      VARCHAR2(32) not null,
  commodityname    VARCHAR2(32) not null,
  counts           NUMBER not null,
  createtime       TIMESTAMP(6) not null,
  frozenfunds      NUMBER(15,2) not null,
  frozenst         NUMBER default 0,
  commodity_id     NUMBER,
  tradealgr        NUMBER(1),
  buy              NUMBER(10,2),
  frozencounterfee NUMBER(15,2),
  unfreezefunds    NUMBER(15,2),
  unfreezefees     NUMBER(15,2)
)
;
comment on table IPO_ORDER
  is '������';
comment on column IPO_ORDER.userid
  is '�ͻ����';
comment on column IPO_ORDER.username
  is '�ͻ�����';
comment on column IPO_ORDER.commodityid
  is '��Ʒ���';
comment on column IPO_ORDER.commodityname
  is '��Ʒ����';
comment on column IPO_ORDER.counts
  is '�ͻ��깺��';
comment on column IPO_ORDER.createtime
  is '�깺ʱ��';
comment on column IPO_ORDER.frozenfunds
  is '�ʽ𶳽�';
comment on column IPO_ORDER.frozenst
  is '����״̬ 0 ���Ѷ��� 1 �ѽⶳ';
comment on column IPO_ORDER.commodity_id
  is '��Ʒ���۱�(ipo_commodity_sale) ��id��';
comment on column IPO_ORDER.tradealgr
  is '�������㷨��1Ϊ����2Ϊ����ֵ��';
comment on column IPO_ORDER.buy
  is '�����ѱ���';
comment on column IPO_ORDER.frozencounterfee
  is '����������';
comment on column IPO_ORDER.unfreezefunds
  is '�ⶳ�깺���';
comment on column IPO_ORDER.unfreezefees
  is '�ⶳ������';
alter table IPO_ORDER
  add primary key (ORDERID);

prompt
prompt Creating table IPO_ORDER_H
prompt ==========================
prompt
create table IPO_ORDER_H
(
  orderid       NUMBER not null,
  userid        VARCHAR2(32) not null,
  username      VARCHAR2(12),
  commodityid   VARCHAR2(12) not null,
  commodityname VARCHAR2(12) not null,
  counts        NUMBER not null,
  createtime    TIMESTAMP(6) not null,
  frozenfunds   NUMBER(15,2) not null,
  frozenst      NUMBER,
  commodity_id  NUMBER not null
)
;
comment on column IPO_ORDER_H.userid
  is '�ͻ����';
comment on column IPO_ORDER_H.username
  is '�ͻ�����';
comment on column IPO_ORDER_H.commodityid
  is '��Ʒ���';
comment on column IPO_ORDER_H.commodityname
  is '��Ʒ����';
comment on column IPO_ORDER_H.counts
  is '�ͻ��깺��';
comment on column IPO_ORDER_H.createtime
  is '�깺ʱ��';
comment on column IPO_ORDER_H.frozenfunds
  is '�ʽ𶳽�';
comment on column IPO_ORDER_H.commodity_id
  is '����id';
alter table IPO_ORDER_H
  add primary key (ORDERID);

prompt
prompt Creating table IPO_OUTBOUND
prompt ===========================
prompt
create table IPO_OUTBOUND
(
  outboundorderid VARCHAR2(32) not null,
  deliveryorderid VARCHAR2(32) not null,
  outboundstate   NUMBER(8) not null,
  outbounddate    DATE not null,
  operatorid      VARCHAR2(32),
  auditorid       VARCHAR2(32),
  warehouseid     VARCHAR2(32),
  deliveryperson  VARCHAR2(32),
  sex             VARCHAR2(32),
  idtype          VARCHAR2(32),
  idnum           VARCHAR2(32)
)
;
comment on column IPO_OUTBOUND.outboundorderid
  is '���ⵥId';
comment on column IPO_OUTBOUND.deliveryorderid
  is '�������';
comment on column IPO_OUTBOUND.outboundstate
  is '����״̬(1������ 2�����ͨ�� 3����˲���)';
comment on column IPO_OUTBOUND.outbounddate
  is '����ʱ��';
comment on column IPO_OUTBOUND.operatorid
  is '¼��Ա';
comment on column IPO_OUTBOUND.auditorid
  is '���Ա';
comment on column IPO_OUTBOUND.warehouseid
  is '�ֿ����';
comment on column IPO_OUTBOUND.deliveryperson
  is '�����';
comment on column IPO_OUTBOUND.sex
  is '�Ա�';
comment on column IPO_OUTBOUND.idtype
  is '֤������';
comment on column IPO_OUTBOUND.idnum
  is '֤������';
alter table IPO_OUTBOUND
  add constraint PK_IPO_OUTBOUND primary key (OUTBOUNDORDERID);

prompt
prompt Creating table IPO_PAYFLOW
prompt ==========================
prompt
create table IPO_PAYFLOW
(
  id            NUMBER not null,
  business_type VARCHAR2(50),
  charge_type   VARCHAR2(50),
  commodity_id  VARCHAR2(32),
  order_id      VARCHAR2(32),
  pay_state     NUMBER(2),
  payee         VARCHAR2(40),
  amount        NUMBER(15,2),
  pay_mode      NUMBER(2),
  pay_channel   NUMBER(2),
  pay_date      DATE,
  remark        VARCHAR2(500),
  buy_back_flag NUMBER(1) default 0,
  create_user   VARCHAR2(32),
  create_date   DATE,
  update_user   VARCHAR2(32),
  update_date   DATE
)
;
comment on table IPO_PAYFLOW
  is '������ˮ��';
comment on column IPO_PAYFLOW.id
  is '��ˮ�� SEQ_IPO_PAYFLOW';
comment on column IPO_PAYFLOW.business_type
  is 'ҵ������';
comment on column IPO_PAYFLOW.charge_type
  is '��������';
comment on column IPO_PAYFLOW.commodity_id
  is '��Ʒ���';
comment on column IPO_PAYFLOW.order_id
  is '����';
comment on column IPO_PAYFLOW.pay_state
  is '����״̬ :1δ���� 2 �Ѹ���';
comment on column IPO_PAYFLOW.payee
  is '�տ���';
comment on column IPO_PAYFLOW.amount
  is '������';
comment on column IPO_PAYFLOW.pay_mode
  is '���ʽ:1 ���ϸ��� 2 ���¸���';
comment on column IPO_PAYFLOW.pay_channel
  is '��������:1 ��֤�𸶿� 2 :�ֽ� 3:ˢ�� 4:֧���� 5:΢��';
comment on column IPO_PAYFLOW.pay_date
  is '����ʱ��';
comment on column IPO_PAYFLOW.remark
  is '��ע';
comment on column IPO_PAYFLOW.buy_back_flag
  is '������� 0:δ���� 1 :�ѷ���';
comment on column IPO_PAYFLOW.create_user
  is '������';
comment on column IPO_PAYFLOW.create_date
  is '����ʱ��';
comment on column IPO_PAYFLOW.update_user
  is '�޸���';
comment on column IPO_PAYFLOW.update_date
  is '�޸�ʱ��';
create index IND_IPO_PAYFLOW_BACK_FLAG on IPO_PAYFLOW (BUY_BACK_FLAG);
create index IND_IPO_PAYFLOW_BUS_TYPE on IPO_PAYFLOW (BUSINESS_TYPE);
create index IND_IPO_PAYFLOW_CHARGE_TYPE on IPO_PAYFLOW (CHARGE_TYPE);
create index IND_IPO_PAYFLOW_COMMODITY_ID on IPO_PAYFLOW (COMMODITY_ID);
create index IND_IPO_PAYFLOW_PAY_MODE on IPO_PAYFLOW (PAY_MODE);
create index IND_IPO_PAYFLOW_STATE on IPO_PAYFLOW (PAY_STATE);
alter table IPO_PAYFLOW
  add primary key (ID);

prompt
prompt Creating table IPO_PICKUP
prompt =========================
prompt
create table IPO_PICKUP
(
  pickup_id       VARCHAR2(32) not null,
  pickup_password VARCHAR2(50),
  idcard_num      VARCHAR2(50)
)
;
alter table IPO_PICKUP
  add constraint PK_IPO_PICKUP primary key (PICKUP_ID);

prompt
prompt Creating table IPO_POSITION
prompt ===========================
prompt
create table IPO_POSITION
(
  positionid     NUMBER not null,
  firmid         VARCHAR2(64),
  position       NUMBER(12),
  commodityid    VARCHAR2(64),
  position_price NUMBER(12,2),
  position_unit  VARCHAR2(12),
  operation_time DATE,
  commodityname  VARCHAR2(64),
  reduction_num  NUMBER,
  reduction_date DATE
)
;
comment on table IPO_POSITION
  is '�ֲ���ˮ��';
comment on column IPO_POSITION.positionid
  is '�ֲֵ���';
comment on column IPO_POSITION.firmid
  is '������id';
comment on column IPO_POSITION.position
  is '�ֲ���';
comment on column IPO_POSITION.commodityid
  is '��Ʒid';
comment on column IPO_POSITION.position_price
  is '�ֲּ�';
comment on column IPO_POSITION.position_unit
  is '�ֲֵ�λ';
comment on column IPO_POSITION.operation_time
  is '��������';
comment on column IPO_POSITION.commodityname
  is '��Ʒ����';
comment on column IPO_POSITION.reduction_num
  is 'Ԥ��������';
comment on column IPO_POSITION.reduction_date
  is 'Ԥ��������';
alter table IPO_POSITION
  add constraint PK_IPO_POSITION primary key (POSITIONID);

prompt
prompt Creating table IPO_POSITIONFLOW
prompt ===============================
prompt
create table IPO_POSITIONFLOW
(
  id            NUMBER not null,
  firmid        VARCHAR2(32),
  holdqty       NUMBER(12),
  business_code VARCHAR2(50),
  role_code     VARCHAR2(50),
  commodityid   VARCHAR2(32),
  price         NUMBER(12,2),
  create_user   VARCHAR2(32),
  create_date   DATE,
  update_user   VARCHAR2(32),
  update_date   DATE,
  state         NUMBER(1) default 1,
  frozenqty     NUMBER(12) default 0,
  remark        VARCHAR2(250),
  freeqty       NUMBER(12) default 0
)
;
comment on table IPO_POSITIONFLOW
  is 'ipo�ֲ���ˮ��';
comment on column IPO_POSITIONFLOW.id
  is 'ipo�ֲֵ���';
comment on column IPO_POSITIONFLOW.firmid
  is '������id';
comment on column IPO_POSITIONFLOW.holdqty
  is '�ֲ���';
comment on column IPO_POSITIONFLOW.business_code
  is 'ҵ������';
comment on column IPO_POSITIONFLOW.role_code
  is '��ɫ����';
comment on column IPO_POSITIONFLOW.commodityid
  is '��Ʒ����';
comment on column IPO_POSITIONFLOW.price
  is '�ֲּ�';
comment on column IPO_POSITIONFLOW.create_user
  is '������';
comment on column IPO_POSITIONFLOW.create_date
  is '��������';
comment on column IPO_POSITIONFLOW.update_user
  is '������';
comment on column IPO_POSITIONFLOW.update_date
  is '��������';
comment on column IPO_POSITIONFLOW.state
  is '״̬ 1:��ת�ֻ� 2:��ת�ֻ�';
comment on column IPO_POSITIONFLOW.frozenqty
  is '��������';
comment on column IPO_POSITIONFLOW.remark
  is '��ע';
comment on column IPO_POSITIONFLOW.freeqty
  is '�ͷ�����';
create index IND_IPO_PF_BUSINESS_CODE on IPO_POSITIONFLOW (BUSINESS_CODE);
create index IND_IPO_PF_CREATE_DATE on IPO_POSITIONFLOW (CREATE_DATE);
create index IND_IPO_PF_ROLE_CODE on IPO_POSITIONFLOW (ROLE_CODE);
create index IND_IPO_PF_STATE on IPO_POSITIONFLOW (STATE);
alter table IPO_POSITIONFLOW
  add primary key (ID);

prompt
prompt Creating table IPO_POSITIONFLOW_HIS
prompt ===================================
prompt
create table IPO_POSITIONFLOW_HIS
(
  id            NUMBER,
  firmid        VARCHAR2(32),
  holdqty       NUMBER(12),
  business_code VARCHAR2(50),
  role_code     VARCHAR2(50),
  commodityid   VARCHAR2(32),
  price         NUMBER(12,2),
  create_user   VARCHAR2(32),
  create_date   DATE,
  update_user   VARCHAR2(32),
  update_date   DATE,
  state         NUMBER(1) default 1,
  frozenqty     NUMBER(12) default 0,
  remark        VARCHAR2(250),
  freeqty       NUMBER(12) default 0,
  oper_user     VARCHAR2(32),
  oper_date     DATE not null
)
;
comment on table IPO_POSITIONFLOW_HIS
  is 'ipo�ֲ���ˮ��ʷ��';
comment on column IPO_POSITIONFLOW_HIS.id
  is 'ipo�ֲֵ���';
comment on column IPO_POSITIONFLOW_HIS.firmid
  is '������id';
comment on column IPO_POSITIONFLOW_HIS.holdqty
  is '�ֲ���';
comment on column IPO_POSITIONFLOW_HIS.business_code
  is 'ҵ������';
comment on column IPO_POSITIONFLOW_HIS.role_code
  is '��ɫ����';
comment on column IPO_POSITIONFLOW_HIS.commodityid
  is '��Ʒ����';
comment on column IPO_POSITIONFLOW_HIS.price
  is '�ֲּ�';
comment on column IPO_POSITIONFLOW_HIS.create_user
  is '������';
comment on column IPO_POSITIONFLOW_HIS.create_date
  is '��������';
comment on column IPO_POSITIONFLOW_HIS.update_user
  is '������';
comment on column IPO_POSITIONFLOW_HIS.update_date
  is '��������';
comment on column IPO_POSITIONFLOW_HIS.state
  is '״̬ 1:��ת�ֻ� 2:��ת�ֻ�';
comment on column IPO_POSITIONFLOW_HIS.frozenqty
  is '��������';
comment on column IPO_POSITIONFLOW_HIS.remark
  is '��ע';
comment on column IPO_POSITIONFLOW_HIS.freeqty
  is '�ͷ�����';
comment on column IPO_POSITIONFLOW_HIS.oper_user
  is '������';
comment on column IPO_POSITIONFLOW_HIS.oper_date
  is '��������';

prompt
prompt Creating table IPO_POSITIONREDUCE
prompt =================================
prompt
create table IPO_POSITIONREDUCE
(
  id              NUMBER,
  positionflow_id NUMBER,
  ratio           NUMBER(10,2),
  reduceqty       NUMBER(12),
  create_user     VARCHAR2(32),
  create_date     DATE,
  update_user     VARCHAR2(32),
  update_date     DATE,
  state           NUMBER(1),
  delete_flag     NUMBER(1) default 0,
  reduce_date     DATE
)
;
comment on table IPO_POSITIONREDUCE
  is '�ֲּ��ּ�¼';
comment on column IPO_POSITIONREDUCE.id
  is '����';
comment on column IPO_POSITIONREDUCE.positionflow_id
  is 'ipo�ֲֵ���';
comment on column IPO_POSITIONREDUCE.ratio
  is '���ֱ���';
comment on column IPO_POSITIONREDUCE.reduceqty
  is '��������';
comment on column IPO_POSITIONREDUCE.create_user
  is '������';
comment on column IPO_POSITIONREDUCE.create_date
  is '��������';
comment on column IPO_POSITIONREDUCE.update_user
  is '�޸���';
comment on column IPO_POSITIONREDUCE.update_date
  is '�޸�����';
comment on column IPO_POSITIONREDUCE.state
  is '״̬ 1:δ���� 2:�Ѽ���';
comment on column IPO_POSITIONREDUCE.delete_flag
  is 'ɾ����� 0:��Ч 1:��Ч';
comment on column IPO_POSITIONREDUCE.reduce_date
  is '��������';
create index IND_IPO_PR_CREATE_DATE on IPO_POSITIONREDUCE (CREATE_DATE);
create index IND_IPO_PR_DELETE_FLAG on IPO_POSITIONREDUCE (DELETE_FLAG);
create index IND_IPO_PR_POSITIONFLOW_ID on IPO_POSITIONREDUCE (POSITIONFLOW_ID);
create index IND_IPO_PR_STATE on IPO_POSITIONREDUCE (STATE);

prompt
prompt Creating table IPO_POSITION_HIS
prompt ===============================
prompt
create table IPO_POSITION_HIS
(
  positionid     NUMBER not null,
  firmid         VARCHAR2(64) not null,
  position       NUMBER(12) not null,
  commodityid    VARCHAR2(64) not null,
  commodityname  VARCHAR2(64),
  position_price NUMBER(12) not null,
  position_unit  VARCHAR2(12),
  reduction_num  NUMBER,
  reduction_date DATE,
  create_user    VARCHAR2(32),
  create_date    DATE
)
;
comment on column IPO_POSITION_HIS.positionid
  is '�ֲֵ���';
comment on column IPO_POSITION_HIS.firmid
  is '������id';
comment on column IPO_POSITION_HIS.position
  is '�ֲ���';
comment on column IPO_POSITION_HIS.commodityid
  is '��Ʒid';
comment on column IPO_POSITION_HIS.commodityname
  is '��Ʒ����';
comment on column IPO_POSITION_HIS.position_price
  is '�ֲּ�';
comment on column IPO_POSITION_HIS.position_unit
  is '�ֲֵ�λ';
comment on column IPO_POSITION_HIS.reduction_num
  is 'Ԥ��������';
comment on column IPO_POSITION_HIS.reduction_date
  is 'Ԥ��������';
comment on column IPO_POSITION_HIS.create_user
  is '������';
comment on column IPO_POSITION_HIS.create_date
  is '����ʱ��';

prompt
prompt Creating table IPO_PUBLISHER_POSITION
prompt =====================================
prompt
create table IPO_PUBLISHER_POSITION
(
  positionid    NUMBER not null,
  publisherid   VARCHAR2(32),
  commodityid   VARCHAR2(32),
  totalvalue    NUMBER(32,2),
  pubposition   NUMBER(16),
  salecounts    NUMBER(16),
  totalcounts   NUMBER(16),
  status        NUMBER(1),
  creater       VARCHAR2(32),
  createdate    DATE,
  updater       VARCHAR2(32),
  updatedate    DATE,
  storageid     VARCHAR2(32),
  subscricounts NUMBER(16)
)
;
comment on column IPO_PUBLISHER_POSITION.positionid
  is '���� SEQ_IPO_PUBLISHER_POSITION';
comment on column IPO_PUBLISHER_POSITION.publisherid
  is '���л�Ա����';
comment on column IPO_PUBLISHER_POSITION.commodityid
  is '��Ʒ����';
comment on column IPO_PUBLISHER_POSITION.totalvalue
  is '����ֵ';
comment on column IPO_PUBLISHER_POSITION.pubposition
  is 'ת�ֲ���';
comment on column IPO_PUBLISHER_POSITION.salecounts
  is 'ת������';
comment on column IPO_PUBLISHER_POSITION.totalcounts
  is '����';
comment on column IPO_PUBLISHER_POSITION.status
  is '״̬(1������ 2���Ѷ��� 3���ѿۿ� 4����ת�ֲ�)';
comment on column IPO_PUBLISHER_POSITION.creater
  is '������';
comment on column IPO_PUBLISHER_POSITION.createdate
  is '��������';
comment on column IPO_PUBLISHER_POSITION.updater
  is '������';
comment on column IPO_PUBLISHER_POSITION.updatedate
  is '��������';
comment on column IPO_PUBLISHER_POSITION.storageid
  is '������ⵥ������';
comment on column IPO_PUBLISHER_POSITION.subscricounts
  is '�������Ϲ���';
alter table IPO_PUBLISHER_POSITION
  add constraint PK_IPO_PUBLISHER_POSITION primary key (POSITIONID);

prompt
prompt Creating table IPO_PUBPAYMENT_TRACK
prompt ===================================
prompt
create table IPO_PUBPAYMENT_TRACK
(
  trackid      NUMBER(10) not null,
  commodityid  VARCHAR2(32),
  payables     NUMBER(16,2),
  status       NUMBER(1),
  createperson VARCHAR2(32),
  createdate   DATE,
  updateperson VARCHAR2(32),
  updatedate   DATE,
  deleteflag   NUMBER(1) default 0
)
;
comment on column IPO_PUBPAYMENT_TRACK.trackid
  is '���� SEQ_IPO_PUBPAYMENT_TRACK ��������';
comment on column IPO_PUBPAYMENT_TRACK.commodityid
  is '��Ʒ����';
comment on column IPO_PUBPAYMENT_TRACK.payables
  is 'Ӧ������';
comment on column IPO_PUBPAYMENT_TRACK.status
  is '״̬  1 δ���� 2 �Ѹ���';
comment on column IPO_PUBPAYMENT_TRACK.createperson
  is '������';
comment on column IPO_PUBPAYMENT_TRACK.createdate
  is '��������';
comment on column IPO_PUBPAYMENT_TRACK.updateperson
  is '������';
comment on column IPO_PUBPAYMENT_TRACK.updatedate
  is '��������';
comment on column IPO_PUBPAYMENT_TRACK.deleteflag
  is 'ɾ����� 0 ��Ч 1 ɾ��';
alter table IPO_PUBPAYMENT_TRACK
  add constraint PK_IPO_PUBPAYMENT_TRACK primary key (TRACKID);

prompt
prompt Creating table IPO_RELEASESUBSCRIPTION
prompt ======================================
prompt
create table IPO_RELEASESUBSCRIPTION
(
  id                       NUMBER(32) not null,
  brokerid                 VARCHAR2(64) not null,
  brokername               VARCHAR2(64) not null,
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
;
comment on table IPO_RELEASESUBSCRIPTION
  is '���ͻ�Ա�깺��ϸ';
comment on column IPO_RELEASESUBSCRIPTION.id
  is '���';
comment on column IPO_RELEASESUBSCRIPTION.brokerid
  is '��ԱID';
comment on column IPO_RELEASESUBSCRIPTION.brokername
  is '��Ա����';
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
alter table IPO_RELEASESUBSCRIPTION
  add constraint PK_IPO_RELEASESUBSCRIPTION primary key (ID);

prompt
prompt Creating table IPO_SALES
prompt ========================
prompt
create table IPO_SALES
(
  id                    NUMBER not null,
  salesid               VARCHAR2(128),
  commodityid           VARCHAR2(128),
  subscriptionnum       NUMBER,
  proportion            NUMBER(8,2),
  payment               NUMBER,
  subscriptioncommodity VARCHAR2(128)
)
;
alter table IPO_SALES
  add constraint PK_IPO_SALES primary key (ID);

prompt
prompt Creating table IPO_SPECIALCOUNTERFEE
prompt ====================================
prompt
create table IPO_SPECIALCOUNTERFEE
(
  id             VARCHAR2(32) not null,
  firmid         VARCHAR2(32),
  commodityid    VARCHAR2(32),
  tradealgr      NUMBER(1),
  counterfee     NUMBER(10,2),
  sell           NUMBER(10,2),
  updatedate     DATE,
  userid         VARCHAR2(32),
  counterfeetype NUMBER(1)
)
;
comment on column IPO_SPECIALCOUNTERFEE.id
  is '����';
comment on column IPO_SPECIALCOUNTERFEE.firmid
  is '�����̴���';
comment on column IPO_SPECIALCOUNTERFEE.commodityid
  is '��Ʒ����';
comment on column IPO_SPECIALCOUNTERFEE.tradealgr
  is '�����������㷨   1:���� 2������ֵ';
comment on column IPO_SPECIALCOUNTERFEE.counterfee
  is '������';
comment on column IPO_SPECIALCOUNTERFEE.sell
  is '���ݲ��ã�';
comment on column IPO_SPECIALCOUNTERFEE.updatedate
  is '�޸�ʱ��';
comment on column IPO_SPECIALCOUNTERFEE.userid
  is '�޸��˴���';
comment on column IPO_SPECIALCOUNTERFEE.counterfeetype
  is '���������ࣨ�ݶ���1.������2.������3.����';
alter table IPO_SPECIALCOUNTERFEE
  add constraint PK_IPO_SPECIALCOUNTERFEE primary key (ID);

prompt
prompt Creating table IPO_SPECIAL_POUNDAGE
prompt ===================================
prompt
create table IPO_SPECIAL_POUNDAGE
(
  poundage_id    VARCHAR2(32) not null,
  dealer_id      VARCHAR2(50) not null,
  commodity_id   VARCHAR2(32) not null,
  poundage_algr  NUMBER(8),
  modify_date    DATE,
  poundage_ratio NUMBER(12,2),
  poundage_type  VARCHAR2(32)
)
;
alter table IPO_SPECIAL_POUNDAGE
  add constraint PK_IPO_SPECIAL_POUNDAGE primary key (POUNDAGE_ID);

prompt
prompt Creating table IPO_SPO_COMMODITYMANMAAGEMENT
prompt ============================================
prompt
create table IPO_SPO_COMMODITYMANMAAGEMENT
(
  spo_id                VARCHAR2(32) not null,
  commodity_id          VARCHAR2(32) not null,
  spo_counts            NUMBER(12) not null,
  spo_price             NUMBER(12,2) not null,
  register_date         DATE not null,
  spo_date              DATE,
  ipo_date              DATE not null,
  spo_sate              NUMBER(8) default 4,
  ration_type           VARCHAR2(32) not null,
  not_ration_counts     NUMBER(12),
  success_ration_counts NUMBER(12) default 0,
  min_ration_counts     NUMBER(12),
  min_ration_proportion NUMBER(12),
  rebate                NUMBER(8) default 2,
  be_listed             NUMBER(8) default 2,
  pre_placement         NUMBER(12),
  positions_price       NUMBER(12,2)
)
;
comment on column IPO_SPO_COMMODITYMANMAAGEMENT.spo_id
  is '����id';
comment on column IPO_SPO_COMMODITYMANMAAGEMENT.commodity_id
  is '��Ʒ����';
comment on column IPO_SPO_COMMODITYMANMAAGEMENT.spo_counts
  is '��������';
comment on column IPO_SPO_COMMODITYMANMAAGEMENT.spo_price
  is '�����۸�';
comment on column IPO_SPO_COMMODITYMANMAAGEMENT.register_date
  is '�Ǽ�����';
comment on column IPO_SPO_COMMODITYMANMAAGEMENT.spo_date
  is '��������';
comment on column IPO_SPO_COMMODITYMANMAAGEMENT.ipo_date
  is '��������';
comment on column IPO_SPO_COMMODITYMANMAAGEMENT.spo_sate
  is '1:δ����
2:�����ɹ�3.����ʧ��4��δ������δ���������ڣ� 5��������';
comment on column IPO_SPO_COMMODITYMANMAAGEMENT.ration_type
  is '1:�������� 2:��������';
comment on column IPO_SPO_COMMODITYMANMAAGEMENT.not_ration_counts
  is 'δ��������';
comment on column IPO_SPO_COMMODITYMANMAAGEMENT.success_ration_counts
  is '����������';
comment on column IPO_SPO_COMMODITYMANMAAGEMENT.min_ration_counts
  is '��С��������';
comment on column IPO_SPO_COMMODITYMANMAAGEMENT.min_ration_proportion
  is '��С���۱���';
comment on column IPO_SPO_COMMODITYMANMAAGEMENT.rebate
  is '1:�ѷ�Ӷ
2:δ��Ӷ';
comment on column IPO_SPO_COMMODITYMANMAAGEMENT.be_listed
  is '1:������
2:δ����';
comment on column IPO_SPO_COMMODITYMANMAAGEMENT.pre_placement
  is 'Ԥ����';
comment on column IPO_SPO_COMMODITYMANMAAGEMENT.positions_price
  is '�ֲּ۸�';

prompt
prompt Creating table IPO_SPO_RATION
prompt =============================
prompt
create table IPO_SPO_RATION
(
  rationid              NUMBER(12) not null,
  spoid                 NUMBER(12) not null,
  rationcounts          NUMBER(12) not null,
  firmid                VARCHAR2(32) not null,
  operationdate         DATE,
  rationloan            NUMBER(12,2),
  servicefee            NUMBER(12,2),
  sales_allocationratio NUMBER(12),
  sales_rebateratio     NUMBER(12),
  firmname              VARCHAR2(32),
  salesid               VARCHAR2(32),
  ration_sate           NUMBER(8)
)
;
comment on column IPO_SPO_RATION.rationid
  is '����ID';
comment on column IPO_SPO_RATION.spoid
  is '����ID';
comment on column IPO_SPO_RATION.rationcounts
  is '��������';
comment on column IPO_SPO_RATION.firmid
  is '������ID';
comment on column IPO_SPO_RATION.operationdate
  is '��������';
comment on column IPO_SPO_RATION.rationloan
  is '���ۻ���';
comment on column IPO_SPO_RATION.servicefee
  is '�����';
comment on column IPO_SPO_RATION.sales_allocationratio
  is '�����̷������';
comment on column IPO_SPO_RATION.sales_rebateratio
  is '�����̷�Ӷ����';
comment on column IPO_SPO_RATION.firmname
  is '����������';
comment on column IPO_SPO_RATION.salesid
  is '�����̴���';
comment on column IPO_SPO_RATION.ration_sate
  is '����״̬(1:δȷ������ 2����ȷ������)';
alter table IPO_SPO_RATION
  add constraint PK_IPO_SPO_RATION primary key (RATIONID);

prompt
prompt Creating table IPO_STORAGE
prompt ==========================
prompt
create table IPO_STORAGE
(
  storageid          VARCHAR2(32) not null,
  commodityid        VARCHAR2(32) not null,
  storagenum         NUMBER(12) not null,
  startnum           VARCHAR2(32),
  endnum             VARCHAR2(32),
  operatorid         VARCHAR2(32),
  warehouseauditorid VARCHAR2(32),
  marketauditorid    VARCHAR2(32),
  storagestate       NUMBER(8) not null,
  storagedate        DATE not null,
  warehouseid        NUMBER(10),
  mapperbillid       VARCHAR2(32),
  storagecounts      NUMBER(12),
  transferstatus     NUMBER(8)
)
;
comment on column IPO_STORAGE.storageid
  is '��ⵥ��';
comment on column IPO_STORAGE.commodityid
  is '��Ʒ����';
comment on column IPO_STORAGE.storagenum
  is '������';
comment on column IPO_STORAGE.startnum
  is '��ʼ����';
comment on column IPO_STORAGE.endnum
  is '��������';
comment on column IPO_STORAGE.operatorid
  is '¼��Ա';
comment on column IPO_STORAGE.warehouseauditorid
  is '�ֿ����Ա';
comment on column IPO_STORAGE.marketauditorid
  is '�г����Ա';
comment on column IPO_STORAGE.storagestate
  is '���״̬(1������ 2���ֿ�ͨ�� 3���ֿⲵ�� 4���г�ͨ�� 5���г�����)';
comment on column IPO_STORAGE.storagedate
  is '���ʱ��';
comment on column IPO_STORAGE.warehouseid
  is '�ֿ����';
comment on column IPO_STORAGE.mapperbillid
  is '�����ֵ�ID';
comment on column IPO_STORAGE.storagecounts
  is '�������';
comment on column IPO_STORAGE.transferstatus
  is 'ת�ֲ�״̬��1������ 2���Ѷ��� 3���ѿۿ� 4����ת�ֲ֣�';
alter table IPO_STORAGE
  add constraint PK_IPO_STORAGE primary key (STORAGEID);

prompt
prompt Creating table IPO_SYSSTATUS
prompt ============================
prompt
create table IPO_SYSSTATUS
(
  tradedate   DATE not null,
  status      NUMBER(2) default 3 not null,
  sectionid   NUMBER(4),
  note        VARCHAR2(256),
  recovertime VARCHAR2(10)
)
;
alter table IPO_SYSSTATUS
  add constraint PK_IPO_SYSSTATUS primary key (TRADEDATE);

prompt
prompt Creating table IPO_TEST
prompt =======================
prompt
create table IPO_TEST
(
  id                 NUMBER,
  tradealgr          NUMBER(1),
  buy                NUMBER(10,2),
  sell               NUMBER(10,2),
  mktbuyfeeradio     NUMBER(10,2),
  mktsellfeeradio    NUMBER(10,2),
  warehousedailyrent NUMBER(10,2),
  trusteedailyrent   NUMBER(10,2),
  insurancedailyrent NUMBER(10,2),
  freetrusteedays    NUMBER(8),
  deliveryunit       VARCHAR2(32),
  deliunittocontract NUMBER(10,2),
  registfeeradio     NUMBER(10,2),
  mktregistfeeradio  NUMBER(10,2),
  cancelfeeradio     NUMBER(10,2),
  mktcancelfeeradio  NUMBER(10,2),
  deliverycostbefore NUMBER(8),
  transferfeeradio   NUMBER(10,2)
)
;

prompt
prompt Creating table IPO_TRADETIME
prompt ============================
prompt
create table IPO_TRADETIME
(
  sectionid  NUMBER(4) not null,
  name       VARCHAR2(20),
  starttime  VARCHAR2(10) not null,
  endtime    VARCHAR2(10) not null,
  status     NUMBER(2) not null,
  modifytime DATE not null
)
;
comment on column IPO_TRADETIME.sectionid
  is 'ID';
comment on column IPO_TRADETIME.name
  is '���׽�����';
comment on column IPO_TRADETIME.starttime
  is '��ʼʱ��';
comment on column IPO_TRADETIME.endtime
  is '����ʱ��';
comment on column IPO_TRADETIME.status
  is '״̬
0:��Ч
1:��Ч';
alter table IPO_TRADETIME
  add primary key (SECTIONID);

prompt
prompt Creating table IPO_TRADETIME_COMM
prompt =================================
prompt
create table IPO_TRADETIME_COMM
(
  id          NUMBER not null,
  tradetimeid NUMBER(4),
  commodityid VARCHAR2(32)
)
;
comment on column IPO_TRADETIME_COMM.id
  is '����';
comment on column IPO_TRADETIME_COMM.tradetimeid
  is '���׽�ID';
comment on column IPO_TRADETIME_COMM.commodityid
  is '��ƷID';
alter table IPO_TRADETIME_COMM
  add constraint PK_TRADETIME_COMM_ID primary key (ID);

prompt
prompt Creating table IPO_TRUSTEESHIP
prompt ==============================
prompt
create table IPO_TRUSTEESHIP
(
  id                       NUMBER not null,
  apply_amount             NUMBER default 0,
  instorage_amount         NUMBER default 0,
  effective_amount         NUMBER default 0,
  position_amount          NUMBER default 0,
  trusteeship_commodity_id NUMBER,
  state                    NUMBER(2),
  price                    NUMBER,
  publish_charge           NUMBER default 0,
  delay_charge             NUMBER default 0,
  listing_charge           NUMBER default 0,
  auditing_date            DATE,
  create_user              VARCHAR2(32),
  create_date              DATE,
  update_user              VARCHAR2(32),
  update_date              DATE,
  delete_flag              NUMBER(1) default 0,
  commodity_id             VARCHAR2(32),
  warehouse_id             NUMBER,
  reduce_date              DATE,
  reduce_ratio             NUMBER(10,2)
)
;
comment on table IPO_TRUSTEESHIP
  is '�йܼ�¼ ';
comment on column IPO_TRUSTEESHIP.id
  is '���� ,SEQ_ipo_trusteeship';
comment on column IPO_TRUSTEESHIP.apply_amount
  is '��������';
comment on column IPO_TRUSTEESHIP.instorage_amount
  is '�������';
comment on column IPO_TRUSTEESHIP.effective_amount
  is '���깺����';
comment on column IPO_TRUSTEESHIP.position_amount
  is '�ֲ�����';
comment on column IPO_TRUSTEESHIP.trusteeship_commodity_id
  is '�й���Ʒ,��� IPO_Trusteeship_commodity.id';
comment on column IPO_TRUSTEESHIP.state
  is ' 1:����,2:����,3:�ֿ����ͨ��,4:�ֿ���󲵻�,5:�ֿ�����ͨ��,6:�ֿ����󲵻�, 7:�г����ͨ��,8:�г���˲���,9:�����ּӲ�,10:������Ԥ����';
comment on column IPO_TRUSTEESHIP.price
  is '���м�';
comment on column IPO_TRUSTEESHIP.publish_charge
  is '����������';
comment on column IPO_TRUSTEESHIP.delay_charge
  is '���ɽ�';
comment on column IPO_TRUSTEESHIP.listing_charge
  is '���Ʒ�';
comment on column IPO_TRUSTEESHIP.auditing_date
  is '���ʱ��';
comment on column IPO_TRUSTEESHIP.create_user
  is '������';
comment on column IPO_TRUSTEESHIP.create_date
  is '����ʱ��';
comment on column IPO_TRUSTEESHIP.update_user
  is '�޸���';
comment on column IPO_TRUSTEESHIP.update_date
  is '�޸�ʱ��';
comment on column IPO_TRUSTEESHIP.delete_flag
  is 'ɾ����� 0:��Ч 1:��Ч';
comment on column IPO_TRUSTEESHIP.commodity_id
  is '��Ʒ���';
comment on column IPO_TRUSTEESHIP.warehouse_id
  is '�ֿ�id';
comment on column IPO_TRUSTEESHIP.reduce_date
  is '��������';
comment on column IPO_TRUSTEESHIP.reduce_ratio
  is '���ְٷֱ�';
alter table IPO_TRUSTEESHIP
  add primary key (ID);

prompt
prompt Creating table IPO_TRUSTEESHIP_COMMODITY
prompt ========================================
prompt
create table IPO_TRUSTEESHIP_COMMODITY
(
  id                  NUMBER not null,
  commodity_id        VARCHAR2(32),
  plan                VARCHAR2(50),
  purchase_rate       NUMBER(10),
  remark              VARCHAR2(200),
  delete_flag         NUMBER(1) default 0,
  create_user         VARCHAR2(32),
  create_date         DATE,
  update_user         VARCHAR2(32),
  update_date         DATE,
  listing_charge_rate NUMBER(10)
)
;
comment on table IPO_TRUSTEESHIP_COMMODITY
  is '�й���Ʒ';
comment on column IPO_TRUSTEESHIP_COMMODITY.id
  is '���� SEQ_IPO_Trusteeship_commodity';
comment on column IPO_TRUSTEESHIP_COMMODITY.commodity_id
  is '��Ʒ���';
comment on column IPO_TRUSTEESHIP_COMMODITY.plan
  is '�йܼƻ�';
comment on column IPO_TRUSTEESHIP_COMMODITY.purchase_rate
  is '�깺���б���';
comment on column IPO_TRUSTEESHIP_COMMODITY.remark
  is '��ע';
comment on column IPO_TRUSTEESHIP_COMMODITY.delete_flag
  is 'ɾ����� 0:��Ч 1:��Ч';
comment on column IPO_TRUSTEESHIP_COMMODITY.create_user
  is '������';
comment on column IPO_TRUSTEESHIP_COMMODITY.create_date
  is '����ʱ��';
comment on column IPO_TRUSTEESHIP_COMMODITY.update_user
  is '�޸���';
comment on column IPO_TRUSTEESHIP_COMMODITY.update_date
  is '�޸�ʱ��';
comment on column IPO_TRUSTEESHIP_COMMODITY.listing_charge_rate
  is '���Ʒѱ���';
alter table IPO_TRUSTEESHIP_COMMODITY
  add primary key (ID);

prompt
prompt Creating table IPO_TRUSTEESHIP_HIS
prompt ==================================
prompt
create table IPO_TRUSTEESHIP_HIS
(
  id             NUMBER not null,
  trusteeship_id NUMBER,
  state          NUMBER(2),
  content        VARCHAR2(1500),
  create_user    VARCHAR2(32),
  create_date    DATE,
  remark         VARCHAR2(50)
)
;
comment on table IPO_TRUSTEESHIP_HIS
  is '�йܼ�¼��ʷ�� ';
comment on column IPO_TRUSTEESHIP_HIS.id
  is '���� ,SEQ_ipo_trusteeship_his';
comment on column IPO_TRUSTEESHIP_HIS.trusteeship_id
  is '�йܼ�¼id';
comment on column IPO_TRUSTEESHIP_HIS.state
  is '1:����,2:����,3:�ֿ����ͨ��,4:�ֿ���󲵻�,5:�ֿ�����ͨ��,6:�ֿ����󲵻�, 7:�г����ͨ��,8:�г���˲���,9:�����ּӲ�,10:������Ԥ����';
comment on column IPO_TRUSTEESHIP_HIS.content
  is 'json��ʽ��¼�ϴβ�������Ϣ';
comment on column IPO_TRUSTEESHIP_HIS.create_user
  is '������';
comment on column IPO_TRUSTEESHIP_HIS.create_date
  is '����ʱ��';
comment on column IPO_TRUSTEESHIP_HIS.remark
  is '��ע';
alter table IPO_TRUSTEESHIP_HIS
  add primary key (ID);

prompt
prompt Creating table IPO_TRUSTEESHIP_WAREHOUSE
prompt ========================================
prompt
create table IPO_TRUSTEESHIP_WAREHOUSE
(
  id           NUMBER not null,
  commodity_id VARCHAR2(32),
  warehouse_id NUMBER
)
;
comment on table IPO_TRUSTEESHIP_WAREHOUSE
  is '�йֿܲ�';
comment on column IPO_TRUSTEESHIP_WAREHOUSE.id
  is '���� SEQ_IPO_Trusteeship_warehouse';
comment on column IPO_TRUSTEESHIP_WAREHOUSE.commodity_id
  is '��Ʒ���';
comment on column IPO_TRUSTEESHIP_WAREHOUSE.warehouse_id
  is '�ֿ�id';
alter table IPO_TRUSTEESHIP_WAREHOUSE
  add primary key (ID);

prompt
prompt Creating table IPO_UNDERWRITER_DEPOSIT
prompt ======================================
prompt
create table IPO_UNDERWRITER_DEPOSIT
(
  id          NUMBER not null,
  amount      NUMBER,
  remark      VARCHAR2(200),
  delete_flag NUMBER(1) default 0,
  create_user VARCHAR2(32),
  create_date DATE,
  update_user VARCHAR2(32),
  update_date DATE,
  state       NUMBER(2),
  subscribeid NUMBER
)
;
comment on table IPO_UNDERWRITER_DEPOSIT
  is '������Ѻ��';
comment on column IPO_UNDERWRITER_DEPOSIT.id
  is '����,SEQ_ipo_underwriter_deposit';
comment on column IPO_UNDERWRITER_DEPOSIT.amount
  is 'Ԥ������';
comment on column IPO_UNDERWRITER_DEPOSIT.remark
  is '��ע';
comment on column IPO_UNDERWRITER_DEPOSIT.delete_flag
  is 'ɾ����� 0:��Ч 1:��Ч';
comment on column IPO_UNDERWRITER_DEPOSIT.create_user
  is '������';
comment on column IPO_UNDERWRITER_DEPOSIT.create_date
  is '����ʱ��';
comment on column IPO_UNDERWRITER_DEPOSIT.update_user
  is '�޸���';
comment on column IPO_UNDERWRITER_DEPOSIT.update_date
  is '�޸�ʱ��';
comment on column IPO_UNDERWRITER_DEPOSIT.state
  is '1: δ���᣻2���Ѷ��᣻3���ѿۿ�s';
comment on column IPO_UNDERWRITER_DEPOSIT.subscribeid
  is '������������';
alter table IPO_UNDERWRITER_DEPOSIT
  add constraint PK_IPO_UNDERWRITER_DEPOSIT primary key (ID);

prompt
prompt Creating table IPO_UNDERWRITER_SUBSCRIBE
prompt ========================================
prompt
create table IPO_UNDERWRITER_SUBSCRIBE
(
  subscribeid     NUMBER not null,
  underwriterid   VARCHAR2(32),
  commodityid     VARCHAR2(32),
  subscribecounts NUMBER(12),
  proportion      NUMBER(8,2),
  delete_flag     NUMBER(1) default 0 not null,
  create_user     VARCHAR2(32),
  create_date     DATE,
  update_user     VARCHAR2(32),
  update_date     DATE,
  subscribeprice  NUMBER(15,2)
)
;
comment on column IPO_UNDERWRITER_SUBSCRIBE.subscribeid
  is '����,seq_ipo_underwriter_sub';
comment on column IPO_UNDERWRITER_SUBSCRIBE.underwriterid
  is '������ID';
comment on column IPO_UNDERWRITER_SUBSCRIBE.commodityid
  is '��ƷID';
comment on column IPO_UNDERWRITER_SUBSCRIBE.subscribecounts
  is '�Ϲ�����';
comment on column IPO_UNDERWRITER_SUBSCRIBE.proportion
  is 'ռ�������������ܺ͵ı���';
comment on column IPO_UNDERWRITER_SUBSCRIBE.delete_flag
  is 'ɾ����� 0:��Ч 1:��Ч';
comment on column IPO_UNDERWRITER_SUBSCRIBE.create_user
  is '������';
comment on column IPO_UNDERWRITER_SUBSCRIBE.create_date
  is '����ʱ��';
comment on column IPO_UNDERWRITER_SUBSCRIBE.update_user
  is '�޸���';
comment on column IPO_UNDERWRITER_SUBSCRIBE.update_date
  is '�޸�ʱ��';
comment on column IPO_UNDERWRITER_SUBSCRIBE.subscribeprice
  is '�Ϲ��۸�';
alter table IPO_UNDERWRITER_SUBSCRIBE
  add constraint PK_IPO_UNDERWRITER_SUBSCRIBE primary key (SUBSCRIBEID);

prompt
prompt Creating table IPO_WAREHOUSE_STOCK
prompt ==================================
prompt
create table IPO_WAREHOUSE_STOCK
(
  stockid      VARCHAR2(32) not null,
  commodityid  VARCHAR2(32),
  storagenum   NUMBER(12),
  forzennum    NUMBER(12),
  availablenum NUMBER(12),
  outboundnum  NUMBER(12),
  warehouseid  NUMBER(10)
)
;
comment on column IPO_WAREHOUSE_STOCK.storagenum
  is '�������';
comment on column IPO_WAREHOUSE_STOCK.forzennum
  is '��������';
comment on column IPO_WAREHOUSE_STOCK.availablenum
  is '��Ч����';
comment on column IPO_WAREHOUSE_STOCK.outboundnum
  is '��������';
comment on column IPO_WAREHOUSE_STOCK.warehouseid
  is '�ֿ�ID(��bi_warehouse��ID��������)';
alter table IPO_WAREHOUSE_STOCK
  add constraint PK_IPO_WAREHOUSE_STOCK primary key (STOCKID);


spool off
