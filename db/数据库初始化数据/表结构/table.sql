--------------------------------------------------
-- Export file for user TRADE_GNNT@SPOT.DEV.183 --
-- Created by Bob on 2016-04-08, 16:35:08 --------
--------------------------------------------------

set define off
spool table.log

prompt
prompt Creating table BI_BUSINESSRELATIONSHIP
prompt ======================================
prompt
create table BI_BUSINESSRELATIONSHIP
(
  stockid      VARCHAR2(16) not null,
  buyer        VARCHAR2(32) not null,
  seller       VARCHAR2(32) not null,
  received     CHAR(1),
  receiveddate DATE,
  selltime     DATE
)
;
comment on column BI_BUSINESSRELATIONSHIP.stockid
  is '�ֵ�id';
comment on column BI_BUSINESSRELATIONSHIP.buyer
  is '���';
comment on column BI_BUSINESSRELATIONSHIP.seller
  is '����';
comment on column BI_BUSINESSRELATIONSHIP.received
  is '�ջ�״̬0��1��';
comment on column BI_BUSINESSRELATIONSHIP.receiveddate
  is '�ջ�ʱ��';
comment on column BI_BUSINESSRELATIONSHIP.selltime
  is '����ʱ��';

prompt
prompt Creating table BI_DISMANTLE
prompt ===========================
prompt
create table BI_DISMANTLE
(
  dismantleid   NUMBER(16) not null,
  stockid       VARCHAR2(16) not null,
  newstockid    VARCHAR2(16),
  realstockcode VARCHAR2(30),
  amount        NUMBER(15,2) default 0 not null,
  applytime     DATE not null,
  processtime   DATE,
  status        CHAR(1)
)
;
comment on column BI_DISMANTLE.status
  is '0:������ 1���𵥳ɹ� 2����ʧ��';
alter table BI_DISMANTLE
  add constraint PK_BI_DISMANTLE primary key (DISMANTLEID);

prompt
prompt Creating table BI_FINANCINGSTOCK
prompt ================================
prompt
create table BI_FINANCINGSTOCK
(
  financingstockid NUMBER(10) not null,
  stockid          VARCHAR2(16),
  status           CHAR(1),
  createtime       DATE not null,
  releasetime      DATE
)
;
comment on column BI_FINANCINGSTOCK.status
  is '''Y'' ��Ч  ''N'' ��Ч';
alter table BI_FINANCINGSTOCK
  add constraint PK_BI_FINANNCINGSTOCK primary key (FINANCINGSTOCKID);

prompt
prompt Creating table BI_FIRM
prompt ======================
prompt
create table BI_FIRM
(
  firmid     VARCHAR2(32) not null,
  password   VARCHAR2(32) not null,
  createtime DATE
)
;
alter table BI_FIRM
  add constraint PK_BI_FIRM primary key (FIRMID);

prompt
prompt Creating table BI_FROZENSTOCK
prompt =============================
prompt
create table BI_FROZENSTOCK
(
  frozenstockid NUMBER(10) not null,
  stockid       VARCHAR2(16) not null,
  moduleid      NUMBER(2) not null,
  status        NUMBER(2) default 0 not null,
  createtime    DATE not null,
  releasetime   DATE
)
;
comment on column BI_FROZENSTOCK.moduleid
  is '10�ۺϹ���ƽ̨
11����ϵͳ
12��ֿܲ����ϵͳ
13�ֵ�����ϵͳ
14����ϵͳ
15��������
18Ͷ���������Ʒ����ϵͳ
19���˻�Ա����ϵͳ
20�����̽���ϵͳ
21����ϵͳ
22���н��뼰����ϵͳ
23E�ֻ�
24�����¼ϵͳ
25ʵʱ�������ϵͳ
26���׿ͻ���
98demoϵͳ
99����ϵͳ';
comment on column BI_FROZENSTOCK.status
  is '0:�ֵ�ʹ���� 1���ֵ��ͷ�״̬';
alter table BI_FROZENSTOCK
  add constraint PK_BI_FROZENSTOCK primary key (FROZENSTOCKID);

prompt
prompt Creating table BI_GOODSPROPERTY
prompt ===============================
prompt
create table BI_GOODSPROPERTY
(
  stockid        VARCHAR2(16) not null,
  propertyname   VARCHAR2(64) not null,
  propertyvalue  VARCHAR2(64),
  propertytypeid NUMBER(15) not null
)
;
alter table BI_GOODSPROPERTY
  add constraint PK_BI_GOODSPROPERTY primary key (STOCKID, PROPERTYNAME);

prompt
prompt Creating table BI_INVOICEINFORM
prompt ===============================
prompt
create table BI_INVOICEINFORM
(
  stockid       VARCHAR2(16) not null,
  invoicetype   CHAR(1),
  companyname   VARCHAR2(100),
  address       VARCHAR2(200),
  dutyparagraph VARCHAR2(32),
  bank          VARCHAR2(32),
  bankaccount   VARCHAR2(32),
  name          VARCHAR2(32),
  phone         VARCHAR2(16)
)
;
comment on column BI_INVOICEINFORM.stockid
  is '�ֵ�id';
comment on column BI_INVOICEINFORM.invoicetype
  is '��Ʊ����,0/1���ˣ���˾��';
comment on column BI_INVOICEINFORM.companyname
  is '��˾����/��λ����';
comment on column BI_INVOICEINFORM.address
  is '��ַ';
comment on column BI_INVOICEINFORM.dutyparagraph
  is '˰��';
comment on column BI_INVOICEINFORM.bank
  is '��������';
comment on column BI_INVOICEINFORM.bankaccount
  is '�����˺�';
comment on column BI_INVOICEINFORM.name
  is '��Ʊ������';
comment on column BI_INVOICEINFORM.phone
  is '�绰';

prompt
prompt Creating table BI_LOGISTICS
prompt ===========================
prompt
create table BI_LOGISTICS
(
  stockid        VARCHAR2(16) not null,
  logisticsorder VARCHAR2(16),
  company        VARCHAR2(32)
)
;
comment on column BI_LOGISTICS.stockid
  is '�ֵ�id';
comment on column BI_LOGISTICS.logisticsorder
  is '��������';
comment on column BI_LOGISTICS.company
  is '������˾';

prompt
prompt Creating table BI_OUTSTOCK
prompt ==========================
prompt
create table BI_OUTSTOCK
(
  outstockid     NUMBER(15) not null,
  stockid        VARCHAR2(16) not null,
  key            VARCHAR2(32) not null,
  deliveryperson VARCHAR2(64),
  idnumber       VARCHAR2(36),
  status         NUMBER(2) default 0 not null,
  createtime     DATE not null,
  processtime    DATE,
  address        VARCHAR2(32),
  phone          VARCHAR2(36),
  deliverystatus NUMBER(2) not null
)
;
comment on column BI_OUTSTOCK.status
  is '0 �������� 1 ������������ 2 �������';
alter table BI_OUTSTOCK
  add primary key (OUTSTOCKID);

prompt
prompt Creating table BI_PLEDGESTOCK
prompt =============================
prompt
create table BI_PLEDGESTOCK
(
  pledgestock NUMBER(10) not null,
  stockid     VARCHAR2(16) not null,
  orderid     VARCHAR2(20) not null,
  moduleid    NUMBER(2) not null,
  status      NUMBER(2),
  createtime  DATE not null,
  releasetime DATE
)
;
comment on column BI_PLEDGESTOCK.moduleid
  is '10�ۺϹ���ƽ̨
11����ϵͳ
12��ֿܲ����ϵͳ
13�ֵ�����ϵͳ
14����ϵͳ
15��������
18Ͷ���������Ʒ����ϵͳ
19���˻�Ա����ϵͳ
20�����̽���ϵͳ
21����ϵͳ
22���н��뼰����ϵͳ
23E�ֻ�
24�����¼ϵͳ
25ʵʱ�������ϵͳ
26���׿ͻ���
98demoϵͳ
99����ϵͳ';
comment on column BI_PLEDGESTOCK.status
  is '0:�ֵ�ʹ���� 1�����׳ɹ��ֵ��ͷ�״̬';
alter table BI_PLEDGESTOCK
  add constraint PK_BI_PLEDGESTOCK primary key (PLEDGESTOCK);

prompt
prompt Creating table BI_STOCK
prompt =======================
prompt
create table BI_STOCK
(
  stockid       VARCHAR2(16) not null,
  realstockcode VARCHAR2(30) not null,
  breedid       NUMBER(10) not null,
  warehouseid   VARCHAR2(30) default 0 not null,
  quantity      NUMBER(15,2) default 0 not null,
  unit          VARCHAR2(16) not null,
  ownerfirm     VARCHAR2(32) not null,
  lasttime      DATE,
  createtime    DATE,
  stockstatus   NUMBER(1) default 0 not null
)
;
comment on column BI_STOCK.lasttime
  is '���һ���޸�ʱ��';
comment on column BI_STOCK.stockstatus
  is '0:δע��ֵ�  1��ע��ֵ�  2���ѳ���ֵ�  3���Ѳ� 4����ֵ������� 5������������';
alter table BI_STOCK
  add constraint PK_BI_STOCK primary key (STOCKID);

prompt
prompt Creating table BI_STOCKCHGLOG
prompt =============================
prompt
create table BI_STOCKCHGLOG
(
  id         NUMBER(10) not null,
  stockid    VARCHAR2(16),
  srcfirm    VARCHAR2(16) not null,
  tarfirm    VARCHAR2(16) not null,
  createtime DATE
)
;
alter table BI_STOCKCHGLOG
  add constraint PK_BI_STOCKCHGLOG primary key (ID);

prompt
prompt Creating table BI_STOCKOPERATION
prompt ================================
prompt
create table BI_STOCKOPERATION
(
  stockid     VARCHAR2(16) not null,
  operationid NUMBER(2) not null
)
;
comment on column BI_STOCKOPERATION.operationid
  is '0���� 1������2�����ֵ� 3������ 4������ֵ�';
alter table BI_STOCKOPERATION
  add constraint PK_BI_STOCKOPERATION primary key (STOCKID, OPERATIONID);

prompt
prompt Creating table BI_SYSTEMPROPS
prompt =============================
prompt
create table BI_SYSTEMPROPS
(
  key          VARCHAR2(32) not null,
  value        VARCHAR2(64) not null,
  runtimevalue VARCHAR2(64),
  note         VARCHAR2(128)
)
;
comment on column BI_SYSTEMPROPS.value
  is '�����ѡ���֤��Ȳ�������';
alter table BI_SYSTEMPROPS
  add constraint PK_BI_SYSTEMPROPS primary key (KEY);

prompt
prompt Creating table BI_TRADESTOCK
prompt ============================
prompt
create table BI_TRADESTOCK
(
  tradestockid NUMBER(10) not null,
  stockid      VARCHAR2(16) not null,
  tradeno      VARCHAR2(20) not null,
  moduleid     NUMBER(2) not null,
  createtime   DATE not null,
  releasetime  DATE,
  status       NUMBER(2)
)
;
comment on column BI_TRADESTOCK.moduleid
  is '10�ۺϹ���ƽ̨
11����ϵͳ
12��ֿܲ����ϵͳ
13�ֵ�����ϵͳ
14����ϵͳ
15��������
18Ͷ���������Ʒ����ϵͳ
19���˻�Ա����ϵͳ
20�����̽���ϵͳ
21����ϵͳ
22���н��뼰����ϵͳ
23E�ֻ�
24�����¼ϵͳ
25ʵʱ�������ϵͳ
26���׿ͻ���
98demoϵͳ
99����ϵͳ';
comment on column BI_TRADESTOCK.status
  is '0:�ֵ�ʹ���� 1�����׳ɹ��ֵ��ͷ�״̬';
alter table BI_TRADESTOCK
  add constraint PK_BI_TRADESTOCK primary key (TRADESTOCKID);

prompt
prompt Creating table BI_WAREHOUSE
prompt ===========================
prompt
create table BI_WAREHOUSE
(
  id                      NUMBER(10) default 0 not null,
  warehouseid             VARCHAR2(30) default 0 not null,
  warehousename           VARCHAR2(128) default 0 not null,
  status                  NUMBER(2) default 0 not null,
  ownershipunits          VARCHAR2(128),
  registeredcapital       NUMBER(15,2) default 0 not null,
  investmentamount        NUMBER(15,2) default 0 not null,
  address                 VARCHAR2(128),
  coordinate              VARCHAR2(128),
  environmental           VARCHAR2(256),
  rank                    NUMBER(2) default 1 not null,
  testconditions          VARCHAR2(256),
  agreementdate           DATE,
  province                VARCHAR2(128),
  city                    VARCHAR2(128),
  postcode                VARCHAR2(10),
  corporaterepresentative VARCHAR2(128),
  representativephone     VARCHAR2(32),
  contactman              VARCHAR2(128),
  phone                   VARCHAR2(32),
  mobile                  VARCHAR2(32),
  fax                     VARCHAR2(32),
  hasdock                 NUMBER(2) default 1 not null,
  docktonnage             NUMBER(15,2) default 0,
  dockdailythroughput     NUMBER(15,2) default 0,
  shiptype                NUMBER(2) default 3,
  hasrailway              NUMBER(2) default 1 not null,
  railwaydailythroughput  NUMBER(15,2) default 0,
  hastanker               NUMBER(2) default 1 not null,
  tankerdailythroughput   NUMBER(15,2) default 0,
  createtime              DATE not null
)
;
comment on column BI_WAREHOUSE.status
  is '0 ���� 1 ������';
comment on column BI_WAREHOUSE.rank
  is '1 һ�Ǽ� 2 ���Ǽ� 3 ���Ǽ� 4 ���Ǽ� 5 ���Ǽ�';
comment on column BI_WAREHOUSE.hasdock
  is '0 ����ͷ 1 û����ͷ';
comment on column BI_WAREHOUSE.shiptype
  is '0 ���� 1 ���� 2 ȫ�� 3 ��֧��';
comment on column BI_WAREHOUSE.hasrailway
  is '0 ����·ר�� 1 û����·ר��';
comment on column BI_WAREHOUSE.hastanker
  is '0 ֧�� 1 ��֧��';
alter table BI_WAREHOUSE
  add constraint PK_BI_WAREHOUSE primary key (ID);

prompt
prompt Creating table BR_BROKER
prompt ========================
prompt
create table BR_BROKER
(
  brokerid      VARCHAR2(16) not null,
  password      VARCHAR2(64) not null,
  name          VARCHAR2(64) not null,
  telephone     VARCHAR2(20),
  mobile        VARCHAR2(20),
  email         VARCHAR2(20),
  address       VARCHAR2(64),
  note          CLOB,
  firmid        VARCHAR2(32),
  areaid        NUMBER(3),
  membertype    NUMBER(2) not null,
  timelimit     DATE,
  marketmanager VARCHAR2(20),
  modifytime    DATE
)
;
alter table BR_BROKER
  add constraint PK_BR_BROKER primary key (BROKERID);

prompt
prompt Creating table BR_BROKERAGE
prompt ===========================
prompt
create table BR_BROKERAGE
(
  brokerageid  VARCHAR2(32) not null,
  name         VARCHAR2(64) not null,
  idcard       VARCHAR2(32) not null,
  password     VARCHAR2(64) not null,
  telephone    VARCHAR2(20),
  mobile       VARCHAR2(20),
  email        VARCHAR2(20),
  address      VARCHAR2(64),
  postcode     VARCHAR2(16),
  note         CLOB,
  brokerid     VARCHAR2(16) not null,
  pbrokerageid VARCHAR2(32),
  creattime    DATE not null
)
;
alter table BR_BROKERAGE
  add constraint PK_BR_BROKERAGE primary key (BROKERAGEID);

prompt
prompt Creating table BR_BROKERAGEANDFIRM
prompt ==================================
prompt
create table BR_BROKERAGEANDFIRM
(
  brokerageid VARCHAR2(32) not null,
  firmid      VARCHAR2(32) not null,
  bindtype    NUMBER(2) not null,
  bindtime    DATE not null
)
;
alter table BR_BROKERAGEANDFIRM
  add constraint PK_BR_BROKERAGEANDFIRM primary key (BROKERAGEID, FIRMID);

prompt
prompt Creating table BR_BROKERAREA
prompt ============================
prompt
create table BR_BROKERAREA
(
  areaid NUMBER(3) not null,
  name   VARCHAR2(64) not null
)
;
alter table BR_BROKERAREA
  add constraint PK_BR_BROKERAREA primary key (AREAID);

prompt
prompt Creating table BR_BROKERMENU
prompt ============================
prompt
create table BR_BROKERMENU
(
  id             NUMBER(10) not null,
  parentid       NUMBER(10),
  name           VARCHAR2(128),
  icon           VARCHAR2(128),
  authorityurl   VARCHAR2(512),
  visiturl       VARCHAR2(512),
  moduleid       NUMBER(2) not null,
  seq            NUMBER(3),
  visible        NUMBER(1),
  type           NUMBER(1) not null,
  catalogid      NUMBER(4),
  iswritelog     VARCHAR2(1) default 'N',
  onlymember     NUMBER(2) default 0 not null,
  menubrokertype NUMBER(2) default 0 not null
)
;
comment on column BR_BROKERMENU.parentid
  is 'Ȩ��id';
comment on column BR_BROKERMENU.name
  is 'Ȩ������';
comment on column BR_BROKERMENU.icon
  is 'Ȩ��ʹ�õ�ͼ��';
comment on column BR_BROKERMENU.authorityurl
  is '��Ӧ��Ȩ��·��';
comment on column BR_BROKERMENU.visiturl
  is '��Ӧ����Դ·��';
comment on column BR_BROKERMENU.moduleid
  is '����ģ���';
comment on column BR_BROKERMENU.seq
  is '���';
comment on column BR_BROKERMENU.visible
  is '�Ƿ�ɼ�   �Ƿ�ɼ� 0���ɼ��� ���������ɼ�';
comment on column BR_BROKERMENU.type
  is 'Ȩ������   Ȩ������ -3��ֻ���session�����Ȩ�޵�url -2�������ж�Ȩ�޵�URL  -1�� ���˵����� 0���Ӳ˵�����  1��ҳ������ɾ�Ĳ�Ȩ��';
comment on column BR_BROKERMENU.catalogid
  is '��־��Ӧ�ķ���';
comment on column BR_BROKERMENU.iswritelog
  is '�Ƿ��Զ�д��־      �Ƿ��Զ�д��־ Y��д��־ N����д��־';
alter table BR_BROKERMENU
  add constraint PK_BR_BROKERMENU primary key (ID);
alter table BR_BROKERMENU
  add constraint CHECK_BR_BROKERMENU_TYPE
  check (TYPE in (-3,-2,-1,0,1));
alter table BR_BROKERMENU
  add constraint CHECK_BR_BROKERMENU_VISIBLE
  check (VISIBLE in (-1,0));

prompt
prompt Creating table BR_BROKERREWARD
prompt ==============================
prompt
create table BR_BROKERREWARD
(
  brokerid   VARCHAR2(16) not null,
  occurdate  DATE not null,
  moduleid   NUMBER(2) not null,
  amount     NUMBER(15,2) not null,
  paidamount NUMBER(15,5) not null,
  paydate    DATE not null
)
;
comment on table BR_BROKERREWARD
  is '�ѽ���Ӷ����ܱ�';
comment on column BR_BROKERREWARD.brokerid
  is '������id';
comment on column BR_BROKERREWARD.occurdate
  is '����ʱ��';
comment on column BR_BROKERREWARD.moduleid
  is 'ģ��id';
comment on column BR_BROKERREWARD.amount
  is 'β�����';
comment on column BR_BROKERREWARD.paidamount
  is '�׸�����';
comment on column BR_BROKERREWARD.paydate
  is '������';
alter table BR_BROKERREWARD
  add constraint PK_BR_BROKERREWARD primary key (BROKERID, OCCURDATE, MODULEID);

prompt
prompt Creating table BR_BROKERREWARDPROPS
prompt ===================================
prompt
create table BR_BROKERREWARDPROPS
(
  moduleid      NUMBER(2) not null,
  rewardtype    NUMBER(2) not null,
  brokerid      VARCHAR2(16) not null,
  commodityid   VARCHAR2(64) not null,
  rewardrate    NUMBER(6,4) not null,
  firstpayrate  NUMBER(6,4) default 0 not null,
  secondpayrate NUMBER(6,4) default 0 not null
)
;
comment on table BR_BROKERREWARDPROPS
  is '����Ӷ������';
comment on column BR_BROKERREWARDPROPS.moduleid
  is 'ģ��id -1:��ʾĬ��Ӷ������
15:����������Ʒ����ϵͳ';
comment on column BR_BROKERREWARDPROPS.rewardtype
  is 'Ӷ������ 0:����';
comment on column BR_BROKERREWARDPROPS.brokerid
  is '������id';
comment on column BR_BROKERREWARDPROPS.commodityid
  is '��Ʒ����';
comment on column BR_BROKERREWARDPROPS.rewardrate
  is '������Ӷ�����';
comment on column BR_BROKERREWARDPROPS.firstpayrate
  is '����׸�����';
comment on column BR_BROKERREWARDPROPS.secondpayrate
  is '���β�����';
alter table BR_BROKERREWARDPROPS
  add constraint PK_BR_BROKERREWARDPROPS primary key (MODULEID, REWARDTYPE, BROKERID, COMMODITYID);

prompt
prompt Creating table BR_BROKERRIGHT
prompt =============================
prompt
create table BR_BROKERRIGHT
(
  id       NUMBER(10) not null,
  brokerid VARCHAR2(16) not null
)
;
comment on table BR_BROKERRIGHT
  is 'Ȩ�޵Ľ�ɫ����';
alter table BR_BROKERRIGHT
  add constraint PK_BR_BROKERRIGHT primary key (ID, BROKERID);

prompt
prompt Creating table BR_BROKERTYPE
prompt ============================
prompt
create table BR_BROKERTYPE
(
  borkertype NUMBER(2) not null,
  brokername VARCHAR2(64) not null
)
;
alter table BR_BROKERTYPE
  add constraint PK_BR_BROKERTYPE primary key (BORKERTYPE);

prompt
prompt Creating table BR_FIRMANDBROKER
prompt ===============================
prompt
create table BR_FIRMANDBROKER
(
  firmid   VARCHAR2(32) not null,
  brokerid VARCHAR2(16) not null,
  bindtime DATE not null
)
;
alter table BR_FIRMANDBROKER
  add constraint PK_BR_FIRMANDBROKER primary key (FIRMID);

prompt
prompt Creating table BR_FIRMAPPLY
prompt ===========================
prompt
create table BR_FIRMAPPLY
(
  applyid     NUMBER(10) not null,
  userid      VARCHAR2(32) not null,
  brokerageid VARCHAR2(32),
  brokerid    VARCHAR2(16) not null,
  applydate   DATE default sysdate
)
;
comment on column BR_FIRMAPPLY.applyid
  is '����';
comment on column BR_FIRMAPPLY.userid
  is '������id';
comment on column BR_FIRMAPPLY.brokerageid
  is '�Ӽ���id';
comment on column BR_FIRMAPPLY.brokerid
  is '���ͻ�Աid';
comment on column BR_FIRMAPPLY.applydate
  is '����ʱ��';
alter table BR_FIRMAPPLY
  add constraint PK_BR_FIRMAPPLY primary key (APPLYID);

prompt
prompt Creating table BR_REWARDPARAMETERPROPS
prompt ======================================
prompt
create table BR_REWARDPARAMETERPROPS
(
  autopay       CHAR(1),
  payperiod     NUMBER(1),
  payperioddate NUMBER(3)
)
;
comment on table BR_REWARDPARAMETERPROPS
  is '��Ӷ���������';
comment on column BR_REWARDPARAMETERPROPS.autopay
  is '�Ƿ��Զ����� Y:�� N:��';
comment on column BR_REWARDPARAMETERPROPS.payperiod
  is '�������� 1:���¼��� 2:���ܼ���';
comment on column BR_REWARDPARAMETERPROPS.payperioddate
  is '����������';

prompt
prompt Creating table BR_TRADEMODULE
prompt =============================
prompt
create table BR_TRADEMODULE
(
  moduleid  NUMBER(2) not null,
  cnname    VARCHAR2(64) not null,
  enname    VARCHAR2(64),
  shortname VARCHAR2(16)
)
;
alter table BR_TRADEMODULE
  add constraint PK_BR_TRADEMODULE primary key (MODULEID);

prompt
prompt Creating table C_APPLY
prompt ======================
prompt
create table C_APPLY
(
  id          NUMBER(10) not null,
  applytype   VARCHAR2(32) not null,
  status      NUMBER(3) not null,
  content     VARCHAR2(2000) not null,
  note        VARCHAR2(1024),
  discribe    VARCHAR2(512),
  modtime     DATE,
  createtime  DATE not null,
  applyuser   VARCHAR2(32) not null,
  operatetype VARCHAR2(50) not null,
  entityclass VARCHAR2(1024) not null
)
;
comment on column C_APPLY.id
  is 'ID';
comment on column C_APPLY.applytype
  is '��������';
comment on column C_APPLY.status
  is '��ǰ״̬ 0������� 1�����ͨ�� 2����˲��� 3����������';
comment on column C_APPLY.content
  is '����';
comment on column C_APPLY.note
  is '��ע';
comment on column C_APPLY.discribe
  is '����';
comment on column C_APPLY.modtime
  is '�޸�ʱ��';
comment on column C_APPLY.createtime
  is '����ʱ��';
comment on column C_APPLY.applyuser
  is '������';
comment on column C_APPLY.operatetype
  is '�������� update;add;delete;deleteCollection';
comment on column C_APPLY.entityclass
  is 'ҵ�������';
alter table C_APPLY
  add constraint PK_C_APPLY primary key (ID);

prompt
prompt Creating table C_AUDIT
prompt ======================
prompt
create table C_AUDIT
(
  id        NUMBER(10) not null,
  applyid   NUMBER(10) not null,
  status    NUMBER(3) not null,
  audituser VARCHAR2(32) not null,
  modtime   DATE default sysdate not null
)
;
comment on column C_AUDIT.id
  is 'ID';
comment on column C_AUDIT.applyid
  is '���뵥ID';
comment on column C_AUDIT.status
  is '״̬ 1�����ͨ�� 2����������';
comment on column C_AUDIT.audituser
  is '�����';
comment on column C_AUDIT.modtime
  is '�޸�ʱ��';
alter table C_AUDIT
  add constraint PK_C_AUDIT primary key (ID);

prompt
prompt Creating table C_DEPLOY_CONFIG
prompt ==============================
prompt
create table C_DEPLOY_CONFIG
(
  moduleid       NUMBER(2) not null,
  contextname    VARCHAR2(64) not null,
  serverpic      VARCHAR2(64) not null,
  serverpath     VARCHAR2(128),
  relativepath   VARCHAR2(128) not null,
  homepageaction VARCHAR2(128),
  welcomepage    VARCHAR2(128),
  welcomepic     VARCHAR2(64),
  systype        VARCHAR2(32) not null,
  sortno         NUMBER(2) default 1 not null
)
;
comment on column C_DEPLOY_CONFIG.moduleid
  is '��ɫId';
comment on column C_DEPLOY_CONFIG.contextname
  is 'ϵͳ����';
comment on column C_DEPLOY_CONFIG.serverpic
  is '��ҳ����������ϵͳ����ƽ̨�ĵ��ͼƬ';
comment on column C_DEPLOY_CONFIG.serverpath
  is '�����ַ��eg  http://127.0.0.1:8080';
comment on column C_DEPLOY_CONFIG.relativepath
  is '����ϵͳ����������ϵͳ����ƽ̨�ĵ����ַ';
comment on column C_DEPLOY_CONFIG.homepageaction
  is '����ϵͳƽ̨��ҳ��Action';
comment on column C_DEPLOY_CONFIG.welcomepage
  is '��ת������ϵͳ��ҳ����Ե�ַ(ֻ��ǰ̨������ҳ)';
comment on column C_DEPLOY_CONFIG.welcomepic
  is '����ϵͳͷ������������ϵͳ��ҳ��ͼ��չʾ(ֻ��ǰ̨������ҳͼ��)';
comment on column C_DEPLOY_CONFIG.systype
  is 'ϵͳ���ͣ�mgr����̨  front��ǰ̨';
alter table C_DEPLOY_CONFIG
  add constraint PK_C_DELOY_CONFIG primary key (MODULEID, CONTEXTNAME);

prompt
prompt Creating table C_FRONT_MYMENU
prompt =============================
prompt
create table C_FRONT_MYMENU
(
  userid  VARCHAR2(12) not null,
  rightid NUMBER(10) not null
)
;
comment on column C_FRONT_MYMENU.userid
  is '����ԱId';
alter table C_FRONT_MYMENU
  add constraint PK_C_FRONT_MYMENU primary key (USERID, RIGHTID);

prompt
prompt Creating table C_FRONT_RIGHT
prompt ============================
prompt
create table C_FRONT_RIGHT
(
  id           NUMBER(10) not null,
  parentid     NUMBER(10),
  name         VARCHAR2(128),
  icon         VARCHAR2(128),
  authorityurl VARCHAR2(512),
  visiturl     VARCHAR2(512),
  moduleid     NUMBER(3),
  seq          NUMBER(3),
  visible      NUMBER(1),
  type         NUMBER(1) not null,
  catalogid    NUMBER(10),
  iswritelog   VARCHAR2(1) default 'N'
)
;
comment on column C_FRONT_RIGHT.id
  is ' �淶��
1����ͷ��λΪϵͳģ���
2: ������λΪһ���˵�
3��������λΪ�����˵�
4�����߰�λΪ�����˵�
5���ھ�ʮλΪҳ���е���ɾ�Ĳ�
';
comment on column C_FRONT_RIGHT.parentid
  is '������';
comment on column C_FRONT_RIGHT.name
  is 'Ȩ������';
comment on column C_FRONT_RIGHT.icon
  is 'ͼ��';
comment on column C_FRONT_RIGHT.authorityurl
  is 'Ȩ��·��';
comment on column C_FRONT_RIGHT.visiturl
  is '��ʵ·��';
comment on column C_FRONT_RIGHT.moduleid
  is 'ģ��Id';
comment on column C_FRONT_RIGHT.seq
  is '���';
comment on column C_FRONT_RIGHT.visible
  is '�Ƿ�ɼ�-1 ���ɼ�0 �ɼ�';
comment on column C_FRONT_RIGHT.type
  is '����-3:ֻ���session�����Ȩ�޵�url -2�������ж�Ȩ�޵�URL -1�� ���˵����� 0���Ӳ˵����� 1��ҳ������ɾ�Ĳ�Ȩ��';
comment on column C_FRONT_RIGHT.catalogid
  is '��־���� 0��д��־ ������Ӧ��c_logcatalog ��CATALOGID�ֶ�';
comment on column C_FRONT_RIGHT.iswritelog
  is '''Y''��д��־��''N''����д��־';
alter table C_FRONT_RIGHT
  add constraint PK_C_FRONT_RIGHT primary key (ID);
alter table C_FRONT_RIGHT
  add constraint CHECK_C_FRONT_RIGHT_TYPE
  check (TYPE in (-3,-2,-1,0,1));
alter table C_FRONT_RIGHT
  add constraint CHECK_C_FRONT_RIGHT_VISIBLE
  check (VISIBLE in (-1,0));

prompt
prompt Creating table C_FRONT_ROLE
prompt ===========================
prompt
create table C_FRONT_ROLE
(
  id          NUMBER(10) not null,
  name        VARCHAR2(32) not null,
  description VARCHAR2(256)
)
;
comment on column C_FRONT_ROLE.id
  is '��ɫId';
comment on column C_FRONT_ROLE.name
  is '��ɫ����';
comment on column C_FRONT_ROLE.description
  is '����';
alter table C_FRONT_ROLE
  add constraint PK_C_FRONT_ROLE primary key (ID);

prompt
prompt Creating table C_FRONT_ROLE_RIGHT
prompt =================================
prompt
create table C_FRONT_ROLE_RIGHT
(
  rightid NUMBER(10) not null,
  roleid  NUMBER(10) not null
)
;
comment on column C_FRONT_ROLE_RIGHT.rightid
  is 'Ȩ��Id
Ȩ��Id';
comment on column C_FRONT_ROLE_RIGHT.roleid
  is '��ɫId';
alter table C_FRONT_ROLE_RIGHT
  add constraint PK_C_FRONT_ROLE_RIGHT primary key (RIGHTID, ROLEID);

prompt
prompt Creating table C_FRONT_USER_RIGHT
prompt =================================
prompt
create table C_FRONT_USER_RIGHT
(
  rightid NUMBER(10) not null,
  userid  VARCHAR2(12) not null
)
;
comment on column C_FRONT_USER_RIGHT.rightid
  is 'Ȩ��Id
Ȩ��Id';
comment on column C_FRONT_USER_RIGHT.userid
  is '����ԱId';
alter table C_FRONT_USER_RIGHT
  add constraint PK_C_FRONT_USER_RIGHT primary key (RIGHTID, USERID);

prompt
prompt Creating table C_FRONT_USER_ROLE
prompt ================================
prompt
create table C_FRONT_USER_ROLE
(
  userid VARCHAR2(12) not null,
  roleid NUMBER(10) not null
)
;
comment on column C_FRONT_USER_ROLE.userid
  is '����ԱId';
comment on column C_FRONT_USER_ROLE.roleid
  is '��ɫId
��ɫId';
alter table C_FRONT_USER_ROLE
  add constraint PK_C_FRONT_USER_ROLE primary key (USERID, ROLEID);

prompt
prompt Creating table C_GLOBALLOG_ALL
prompt ==============================
prompt
create table C_GLOBALLOG_ALL
(
  id             NUMBER(15) not null,
  operator       VARCHAR2(32),
  operatetime    DATE default sysdate,
  operatetype    NUMBER(4),
  operateip      VARCHAR2(32),
  operatortype   VARCHAR2(32),
  mark           VARCHAR2(4000),
  operatecontent VARCHAR2(4000),
  currentvalue   VARCHAR2(4000),
  operateresult  NUMBER(1) default 0,
  logtype        NUMBER(2) default 0
)
;
comment on column C_GLOBALLOG_ALL.id
  is 'ID';
comment on column C_GLOBALLOG_ALL.operator
  is '������';
comment on column C_GLOBALLOG_ALL.operatetime
  is '����ʱ��';
comment on column C_GLOBALLOG_ALL.operatetype
  is '��������';
comment on column C_GLOBALLOG_ALL.operateip
  is '����IP';
comment on column C_GLOBALLOG_ALL.operatortype
  is '����������';
comment on column C_GLOBALLOG_ALL.mark
  is '��ʾ';
comment on column C_GLOBALLOG_ALL.operatecontent
  is '��������';
comment on column C_GLOBALLOG_ALL.currentvalue
  is '��ǰֵ';
comment on column C_GLOBALLOG_ALL.operateresult
  is '������� 1 �ɹ�  0 ʧ��';
comment on column C_GLOBALLOG_ALL.logtype
  is '0 ������1 ��̨��2 ǰ̨��3 ����';
alter table C_GLOBALLOG_ALL
  add constraint PK_C_GLOBALLOG_ALL primary key (ID);
alter table C_GLOBALLOG_ALL
  add constraint GLBLOGALL
  check (operateresult in(0,1));

prompt
prompt Creating table C_GLOBALLOG_ALL_H
prompt ================================
prompt
create table C_GLOBALLOG_ALL_H
(
  id             NUMBER(15) not null,
  operator       VARCHAR2(32),
  operatetime    DATE,
  operatetype    NUMBER(4),
  operateip      VARCHAR2(32),
  operatortype   VARCHAR2(32),
  mark           VARCHAR2(4000),
  operatecontent VARCHAR2(4000),
  currentvalue   VARCHAR2(4000),
  operateresult  NUMBER(1) default 0,
  logtype        NUMBER(2)
)
;
comment on column C_GLOBALLOG_ALL_H.id
  is 'ID';
comment on column C_GLOBALLOG_ALL_H.operator
  is '������';
comment on column C_GLOBALLOG_ALL_H.operatetime
  is '����ʱ��';
comment on column C_GLOBALLOG_ALL_H.operatetype
  is '��������';
comment on column C_GLOBALLOG_ALL_H.operateip
  is '����IP';
comment on column C_GLOBALLOG_ALL_H.operatortype
  is '����������';
comment on column C_GLOBALLOG_ALL_H.mark
  is '��ʾ';
comment on column C_GLOBALLOG_ALL_H.operatecontent
  is '��������';
comment on column C_GLOBALLOG_ALL_H.currentvalue
  is '��ǰֵ';
comment on column C_GLOBALLOG_ALL_H.operateresult
  is '������� 1 �ɹ�  0 ʧ��';
comment on column C_GLOBALLOG_ALL_H.logtype
  is '0 ������1 ��̨��2 ǰ̨��3 ����';
alter table C_GLOBALLOG_ALL_H
  add constraint GLBLOGALL_1
  check (operateresult in(0,1));

prompt
prompt Creating table C_LOGCATALOG
prompt ===========================
prompt
create table C_LOGCATALOG
(
  catalogid   NUMBER(4) not null,
  moduleid    NUMBER(2) not null,
  catalogname VARCHAR2(32)
)
;
comment on table C_LOGCATALOG
  is '��־���࣬4λ���ֵı��룬����־ģ��ID��ͷ��';
comment on column C_LOGCATALOG.catalogid
  is '��־����ID��4λ���ֵı��룬�����עNotes��';
comment on column C_LOGCATALOG.moduleid
  is '10�ۺϹ���ƽ̨
11����ϵͳ
12��ֿܲ����ϵͳ
13�ֵ�����ϵͳ
14����ϵͳ
15��������
18Ͷ���������Ʒ����ϵͳ
19���˻�Ա����ϵͳ
20�����̽���ϵͳ
21����ϵͳ
22���н��뼰����ϵͳ
23E�ֻ�
24�����¼ϵͳ
25ʵʱ�������ϵͳ
26���׿ͻ���
98demoϵͳ
99����ϵͳ';
comment on column C_LOGCATALOG.catalogname
  is '��־������';
alter table C_LOGCATALOG
  add constraint PK_C_LOGCATALOG primary key (CATALOGID);

prompt
prompt Creating table C_MARKETINFO
prompt ===========================
prompt
create table C_MARKETINFO
(
  infoname  VARCHAR2(128) not null,
  infovalue VARCHAR2(128) not null
)
;
alter table C_MARKETINFO
  add constraint PK_C_MARKETINFO primary key (INFONAME, INFOVALUE);

prompt
prompt Creating table C_MYMENU
prompt =======================
prompt
create table C_MYMENU
(
  userid  VARCHAR2(32) not null,
  rightid NUMBER(10) not null
)
;
alter table C_MYMENU
  add constraint PK_C_MYMENU primary key (USERID, RIGHTID);

prompt
prompt Creating table C_RIGHT
prompt ======================
prompt
create table C_RIGHT
(
  id           NUMBER(10) not null,
  parentid     NUMBER(10),
  name         VARCHAR2(128),
  icon         VARCHAR2(128),
  authorityurl VARCHAR2(512),
  visiturl     VARCHAR2(512),
  moduleid     NUMBER(2) not null,
  seq          NUMBER(3),
  visible      NUMBER(1),
  type         NUMBER(1) not null,
  catalogid    NUMBER(4),
  iswritelog   VARCHAR2(1) default 'N'
)
;
comment on column C_RIGHT.id
  is ' �淶��
1����ͷ��λΪϵͳģ���
2: ������λΪһ���˵�
3��������λΪ�����˵�
4�����߰�λΪ�����˵�
5���ھ�ʮλΪҳ���е���ɾ�Ĳ�
';
comment on column C_RIGHT.parentid
  is '������';
comment on column C_RIGHT.name
  is 'Ȩ������';
comment on column C_RIGHT.icon
  is 'ͼ��';
comment on column C_RIGHT.authorityurl
  is 'Ȩ��·��';
comment on column C_RIGHT.visiturl
  is '��ʵ·��';
comment on column C_RIGHT.moduleid
  is '10�ۺϹ���ƽ̨
11����ϵͳ
12��ֿܲ����ϵͳ
13�ֵ�����ϵͳ
14����ϵͳ
15��������
18Ͷ���������Ʒ����ϵͳ
19���˻�Ա����ϵͳ
20�����̽���ϵͳ
21����ϵͳ
22���н��뼰����ϵͳ
23E�ֻ�
24�����¼ϵͳ
25ʵʱ�������ϵͳ
26���׿ͻ���
98demoϵͳ
99����ϵͳ';
comment on column C_RIGHT.seq
  is '���';
comment on column C_RIGHT.visible
  is '�Ƿ�ɼ�-1 ���ɼ�0 �ɼ�';
comment on column C_RIGHT.type
  is '����-3:ֻ���session�����Ȩ�޵�url -2�������ж�Ȩ�޵�URL -1�� ���˵����� 0���Ӳ˵����� 1��ҳ������ɾ�Ĳ�Ȩ��';
comment on column C_RIGHT.catalogid
  is '��־���� 0��д��־ ������Ӧ��c_logcatalog ��CATALOGID�ֶ�';
comment on column C_RIGHT.iswritelog
  is '''Y''��д��־��''N''����д��־';
alter table C_RIGHT
  add primary key (ID);
alter table C_RIGHT
  add check (TYPE in (-3,-2,-1,0,1));
alter table C_RIGHT
  add check (VISIBLE in (-1,0));
alter table C_RIGHT
  add check (TYPE in (-3,-2,-1,0,1));
alter table C_RIGHT
  add check (VISIBLE in (-1,0));

prompt
prompt Creating table C_ROLE
prompt =====================
prompt
create table C_ROLE
(
  id          NUMBER(10) not null,
  name        VARCHAR2(32) not null,
  description VARCHAR2(256)
)
;
comment on column C_ROLE.id
  is '��ɫId';
comment on column C_ROLE.name
  is '��ɫ����';
comment on column C_ROLE.description
  is '����';
alter table C_ROLE
  add constraint PK_C_ROLE primary key (ID);

prompt
prompt Creating table C_ROLE_RIGHT
prompt ===========================
prompt
create table C_ROLE_RIGHT
(
  rightid NUMBER(10) not null,
  roleid  NUMBER(10) not null
)
;
comment on column C_ROLE_RIGHT.rightid
  is 'Ȩ��Id';
comment on column C_ROLE_RIGHT.roleid
  is '��ɫId';
alter table C_ROLE_RIGHT
  add constraint PK_C_ROLE_RIGHT primary key (RIGHTID, ROLEID);

prompt
prompt Creating table C_SUBMODULE
prompt ==========================
prompt
create table C_SUBMODULE
(
  moduleid       NUMBER(4) not null,
  cnname         VARCHAR2(64) not null,
  enname         VARCHAR2(64),
  shortname      VARCHAR2(16),
  hostip         VARCHAR2(16),
  port           NUMBER(6),
  rmidataport    NUMBER(6),
  parentmoduleid NUMBER(2) not null,
  remark         VARCHAR2(128)
)
;
comment on column C_SUBMODULE.moduleid
  is '�˱�Ϊc_trademodule�е���ģ�����ñ�ģ��ID��Ҫ��c_trademodule���е�ģ��ID�ظ�';
alter table C_SUBMODULE
  add constraint PK_C_TRADEMODULE_1 primary key (MODULEID);

prompt
prompt Creating table C_TRADEMODULE
prompt ============================
prompt
create table C_TRADEMODULE
(
  moduleid           NUMBER(2) not null,
  cnname             VARCHAR2(64) not null,
  enname             VARCHAR2(64),
  shortname          VARCHAR2(16),
  addfirmfn          VARCHAR2(36),
  updatefirmstatusfn VARCHAR2(36),
  delfirmfn          VARCHAR2(36),
  isfirmset          CHAR(1) default 'N' not null,
  hostip             VARCHAR2(16),
  port               NUMBER(6),
  rmidataport        NUMBER(6),
  isbalancecheck     CHAR(1) default 'N' not null,
  isneedbreed        CHAR(1) not null
)
;
comment on column C_TRADEMODULE.moduleid
  is '10�ۺϹ���ƽ̨
11����ϵͳ
12��ֿܲ����ϵͳ
13�ֵ�����ϵͳ
14����ϵͳ
15��������
18Ͷ���������Ʒ����ϵͳ
19���˻�Ա����ϵͳ
20�����̽���ϵͳ
21����ϵͳ
22���н��뼰����ϵͳ
23E�ֻ�
24�����¼ϵͳ
25ʵʱ�������ϵͳ
26���׿ͻ���
98demoϵͳ
99����ϵͳ';
comment on column C_TRADEMODULE.isfirmset
  is '��Y�� �� ��N�� �� (�����Ҫ�ڹ���ǰ̨�ҵ�ƽ̨����ʾ��ϵͳ������Ҫ�ڹ���ϵͳ�� spring_sys_msg.xml �������ϱ�ϵͳ��������Ϣ)';
comment on column C_TRADEMODULE.isbalancecheck
  is 'Y���� N����';
comment on column C_TRADEMODULE.isneedbreed
  is '��ϵͳ�Ƿ���Ҫ�ۺϹ���ƽ̨���ӵ���Ʒ   Y:��   N:��';
alter table C_TRADEMODULE
  add constraint PK_C_TRADEMODULE primary key (MODULEID);

prompt
prompt Creating table C_USER
prompt =====================
prompt
create table C_USER
(
  id          VARCHAR2(32) not null,
  name        VARCHAR2(32),
  password    VARCHAR2(32),
  type        VARCHAR2(20) default 'ADMIN' not null,
  description VARCHAR2(256),
  isforbid    CHAR(1) default 'N' not null,
  skin        VARCHAR2(16) default 'default' not null,
  keycode     VARCHAR2(128) default '0123456789ABCDE' not null
)
;
comment on column C_USER.id
  is '����ԱId';
comment on column C_USER.name
  is '����Ա����';
comment on column C_USER.password
  is '����';
comment on column C_USER.type
  is 'ADMIN����ͨ����Ա��ɫDEFAULT_ADMIN���߼�����Ա��ɫDEFAULT_SUPER_ADMIN��Ĭ�ϳ�������Ա��ɫ';
comment on column C_USER.description
  is '����';
comment on column C_USER.isforbid
  is 'Y������
N��������
';
comment on column C_USER.skin
  is 'Ƥ��';
comment on column C_USER.keycode
  is 'key';
alter table C_USER
  add constraint PK_C_USER primary key (ID);

prompt
prompt Creating table C_USER_RIGHT
prompt ===========================
prompt
create table C_USER_RIGHT
(
  rightid NUMBER(10) not null,
  userid  VARCHAR2(32) not null
)
;
comment on column C_USER_RIGHT.rightid
  is 'Ȩ��Id
Ȩ��Id';
comment on column C_USER_RIGHT.userid
  is '����ԱId';
alter table C_USER_RIGHT
  add constraint PK_C_USER_RIGHT primary key (RIGHTID, USERID);

prompt
prompt Creating table C_USER_ROLE
prompt ==========================
prompt
create table C_USER_ROLE
(
  userid VARCHAR2(32) not null,
  roleid NUMBER(10) not null
)
;
comment on column C_USER_ROLE.userid
  is '����ԱId';
comment on column C_USER_ROLE.roleid
  is '��ɫId';
alter table C_USER_ROLE
  add constraint PK_C_USER_ROLE primary key (USERID, ROLEID);

prompt
prompt Creating table C_XMLTEMPLATE
prompt ============================
prompt
create table C_XMLTEMPLATE
(
  id   NUMBER(12) not null,
  clob CLOB not null
)
;
alter table C_XMLTEMPLATE
  add primary key (ID);

prompt
prompt Creating table F_ACCOUNT
prompt ========================
prompt
create table F_ACCOUNT
(
  code         VARCHAR2(38) not null,
  name         VARCHAR2(64) not null,
  accountlevel NUMBER(2) not null,
  dcflag       CHAR(1) not null,
  isinit       CHAR(1) default 'Y' not null
)
;
comment on column F_ACCOUNT.code
  is '��Ŀ����';
comment on column F_ACCOUNT.name
  is '��Ŀ����';
comment on column F_ACCOUNT.accountlevel
  is '��Ŀ����';
comment on column F_ACCOUNT.dcflag
  is '��������־ D:Debit ��
C:Credit ��
';
comment on column F_ACCOUNT.isinit
  is '�Ƿ��ʼ�� Y:�ǳ�ʼ������,ҳ�治����ɾ�����޸�
N:���ǳ�ʼ������';
alter table F_ACCOUNT
  add constraint PK_F_ACCOUNT primary key (CODE);

prompt
prompt Creating table F_ACCOUNTBOOK
prompt ============================
prompt
create table F_ACCOUNTBOOK
(
  b_date     DATE not null,
  summaryno  CHAR(5) not null,
  summary    VARCHAR2(32),
  voucherno  NUMBER(10) not null,
  contractno VARCHAR2(16),
  debitcode  VARCHAR2(38) not null,
  creditcode VARCHAR2(38) not null,
  amount     NUMBER(15,2) default 0 not null
)
;
create index IX_F_ACCOUNTBOOK_BD on F_ACCOUNTBOOK (B_DATE);
create index IX_F_ACCOUNTBOOK_C on F_ACCOUNTBOOK (CREDITCODE);
create index IX_F_ACCOUNTBOOK_D on F_ACCOUNTBOOK (DEBITCODE);

prompt
prompt Creating table F_BANKCLEARLEDGERCONFIG
prompt ======================================
prompt
create table F_BANKCLEARLEDGERCONFIG
(
  ledgercode VARCHAR2(16) not null,
  feetype    NUMBER(2) not null,
  fieldsign  NUMBER(1) not null
)
;
alter table F_BANKCLEARLEDGERCONFIG
  add primary key (LEDGERCODE);

prompt
prompt Creating table F_B_BANKACCOUNT
prompt ==============================
prompt
create table F_B_BANKACCOUNT
(
  bankid       VARCHAR2(32) not null,
  account      VARCHAR2(32) not null,
  status       NUMBER(1) default 0 not null,
  accountname  VARCHAR2(100),
  bankname     VARCHAR2(128),
  bankprovince VARCHAR2(128),
  bankcity     VARCHAR2(128),
  mobile       VARCHAR2(32),
  email        VARCHAR2(128),
  cardtype     VARCHAR2(2) default 1 not null,
  card         VARCHAR2(32)
)
;
comment on table F_B_BANKACCOUNT
  is '���������ʻ���';
comment on column F_B_BANKACCOUNT.bankid
  is '���б��';
comment on column F_B_BANKACCOUNT.account
  is '�����ʺ�';
comment on column F_B_BANKACCOUNT.status
  is '״̬(0 ����,1 ����)';
comment on column F_B_BANKACCOUNT.accountname
  is '�˻���';
comment on column F_B_BANKACCOUNT.bankname
  is '��������';
comment on column F_B_BANKACCOUNT.bankprovince
  is '����ʡ��';
comment on column F_B_BANKACCOUNT.bankcity
  is '����������';
comment on column F_B_BANKACCOUNT.mobile
  is '�绰����';
comment on column F_B_BANKACCOUNT.email
  is '����';
comment on column F_B_BANKACCOUNT.cardtype
  is '�ʻ�����(1 ���֤,2����֤,3���ڻ���,4���ڱ�,5ѧԱ֤,6����֤,7��ʱ���֤,8��֯��������,9Ӫҵִ��,A����֤,B��ž�ʿ��֤,C����֤,D�������,E�۰�̨�������֤,F̨��ͨ��֤��������Ч����֤,G����ͻ����,H��ž���ְ�ɲ�֤,I�侯��ְ�ɲ�֤,J�侯ʿ��֤,X������Ч֤��,Z�غ����֤)(��Ҫ�õ��� 1��8,���� 9 �� ������û���õ�';
comment on column F_B_BANKACCOUNT.card
  is '֤������';

prompt
prompt Creating table F_B_BANKCAPITALRESULT
prompt ====================================
prompt
create table F_B_BANKCAPITALRESULT
(
  bankid     VARCHAR2(20) not null,
  firmid     VARCHAR2(20) not null,
  bankright  NUMBER(10,2) not null,
  maketright NUMBER(10,2) not null,
  reason     NUMBER,
  bdate      TIMESTAMP(6) not null
)
;
comment on table F_B_BANKCAPITALRESULT
  is '�ַֺ˶Ա�';
comment on column F_B_BANKCAPITALRESULT.bankid
  is '���б��';
comment on column F_B_BANKCAPITALRESULT.firmid
  is '�����̴���';
comment on column F_B_BANKCAPITALRESULT.bankright
  is '����Ȩ��';
comment on column F_B_BANKCAPITALRESULT.maketright
  is '�г�Ȩ��';
comment on column F_B_BANKCAPITALRESULT.reason
  is '��ƽԭ��(0��ƽ 1���ж��˻�δ���� 2�������˻�δ����)';
comment on column F_B_BANKCAPITALRESULT.bdate
  is '����ʱ��';
alter table F_B_BANKCAPITALRESULT
  add constraint PK_F_B_BANKCAPITALRESULT primary key (BANKID, FIRMID, BDATE);

prompt
prompt Creating table F_B_BANKCOMPAREINFO
prompt ==================================
prompt
create table F_B_BANKCOMPAREINFO
(
  id          NUMBER(12) not null,
  funid       VARCHAR2(100) not null,
  firmid      VARCHAR2(32),
  account     VARCHAR2(32) not null,
  type        NUMBER(1) not null,
  money       NUMBER(12,2) not null,
  comparedate DATE not null,
  note        VARCHAR2(128),
  createtime  DATE not null,
  status      NUMBER(1) not null,
  bankid      VARCHAR2(32) not null
)
;
comment on table F_B_BANKCOMPAREINFO
  is '���ж�����Ϣ��';
comment on column F_B_BANKCOMPAREINFO.id
  is '���ж�����ϢID';
comment on column F_B_BANKCOMPAREINFO.funid
  is '������ˮ��';
comment on column F_B_BANKCOMPAREINFO.firmid
  is '�����̴���';
comment on column F_B_BANKCOMPAREINFO.account
  is '�������˺�';
comment on column F_B_BANKCOMPAREINFO.type
  is '��������(0 ���,1 ����)';
comment on column F_B_BANKCOMPAREINFO.money
  is '���';
comment on column F_B_BANKCOMPAREINFO.comparedate
  is '��������';
comment on column F_B_BANKCOMPAREINFO.note
  is '��ע';
comment on column F_B_BANKCOMPAREINFO.createtime
  is '��������';
comment on column F_B_BANKCOMPAREINFO.status
  is '����״̬';
comment on column F_B_BANKCOMPAREINFO.bankid
  is '���б��';
alter table F_B_BANKCOMPAREINFO
  add constraint PK_F_B_BANKCOMPAREINFO primary key (FUNID, BANKID, COMPAREDATE);

prompt
prompt Creating table F_B_BANKQSDATE
prompt =============================
prompt
create table F_B_BANKQSDATE
(
  bankid      VARCHAR2(32) not null,
  tradedate   DATE not null,
  tradetype   NUMBER(2),
  tradestatus NUMBER(2),
  note        VARCHAR2(32),
  createdate  DATE default sysdate not null
)
;
comment on table F_B_BANKQSDATE
  is '��������ʱ���';
comment on column F_B_BANKQSDATE.bankid
  is '���б��';
comment on column F_B_BANKQSDATE.tradedate
  is '��������';
comment on column F_B_BANKQSDATE.tradetype
  is '��������';
comment on column F_B_BANKQSDATE.tradestatus
  is '����״̬(0 �ɹ�,1 ʧ��)';
comment on column F_B_BANKQSDATE.note
  is '��ע��Ϣ';
comment on column F_B_BANKQSDATE.createdate
  is '��¼����ʱ��';

prompt
prompt Creating table F_B_BANKS
prompt ========================
prompt
create table F_B_BANKS
(
  bankid              VARCHAR2(32) not null,
  bankname            VARCHAR2(64) not null,
  maxpersgltransmoney NUMBER(12,2) not null,
  maxpertransmoney    NUMBER(12,2) not null,
  maxpertranscount    NUMBER(7) not null,
  adapterclassname    VARCHAR2(50) not null,
  validflag           NUMBER(1) not null,
  maxauditmoney       NUMBER(12,2),
  begintime           VARCHAR2(8) default '00:00:00',
  endtime             VARCHAR2(8) default '23:59:59',
  control             NUMBER(2) default 0
)
;
comment on table F_B_BANKS
  is '���б�';
comment on column F_B_BANKS.bankid
  is '���б��';
comment on column F_B_BANKS.bankname
  is '��������';
comment on column F_B_BANKS.maxpersgltransmoney
  is '�������ת�˽��';
comment on column F_B_BANKS.maxpertransmoney
  is 'ÿ�����ת�˽��';
comment on column F_B_BANKS.maxpertranscount
  is 'ÿ�����ת�˴���';
comment on column F_B_BANKS.adapterclassname
  is '������ʵ��������';
comment on column F_B_BANKS.validflag
  is '����״̬(0 ����,1 ������)';
comment on column F_B_BANKS.maxauditmoney
  is '�������г�����˶��';
comment on column F_B_BANKS.begintime
  is '������ʼת��ʱ��';
comment on column F_B_BANKS.endtime
  is '���н���ת��ʱ��';
comment on column F_B_BANKS.control
  is '�Ƿ��ܵ������պͽ���ʱ���Լ�� (0 ��˫��Լ��,1 ����Լ��,2 �ܽ�����Լ��,3 �ܽ���ʱ��Լ��)';
alter table F_B_BANKS
  add constraint PK_F_B_BANKS primary key (BANKID);

prompt
prompt Creating table F_B_BANKTRANSFER
prompt ===============================
prompt
create table F_B_BANKTRANSFER
(
  id         NUMBER(12) not null,
  paybankid  VARCHAR2(32) not null,
  recbankid  VARCHAR2(32) not null,
  money      NUMBER(15,2) default 0.00 not null,
  moneytype  VARCHAR2(2) default 0,
  funid      VARCHAR2(100),
  maerketid  VARCHAR2(100),
  note       VARCHAR2(100),
  status     NUMBER(2) not null,
  createtime TIMESTAMP(6) not null,
  updatetime TIMESTAMP(6) not null
)
;
comment on table F_B_BANKTRANSFER
  is '��������ת�˱�';
comment on column F_B_BANKTRANSFER.paybankid
  is 'ת������ID���б��';
comment on column F_B_BANKTRANSFER.recbankid
  is 'תת������ID���б��';
comment on column F_B_BANKTRANSFER.money
  is '�����ʽ�';
comment on column F_B_BANKTRANSFER.moneytype
  is '0Ϊ�����';
comment on column F_B_BANKTRANSFER.funid
  is '������ˮ��';
comment on column F_B_BANKTRANSFER.maerketid
  is '������ˮ��';
comment on column F_B_BANKTRANSFER.status
  is '0 �ɹ�,1 ʧ��,2 ������,3 һ�����,4 �������,5 ���з�����ϢΪ��,6 ���з����г���ˮ�ź��г�������ˮ�Ų�һ��,13 �г������г��������״̬';

prompt
prompt Creating table F_B_BATCUSTFILE
prompt ==============================
prompt
create table F_B_BATCUSTFILE
(
  custacctid   VARCHAR2(32) not null,
  custname     VARCHAR2(120),
  thirdcustid  VARCHAR2(32),
  bankbalance  NUMBER(18,2),
  bankfrozen   NUMBER(18,2),
  maketbalance NUMBER(18,2),
  maketfrozen  NUMBER(18,2),
  balanceerror NUMBER(18,2),
  frozenerror  NUMBER(18,2),
  tradedate    DATE not null,
  bankid       VARCHAR2(32),
  createdate   DATE default sysdate,
  note         VARCHAR2(120)
)
;
comment on table F_B_BATCUSTFILE
  is '���˲�ƽ��¼';
comment on column F_B_BATCUSTFILE.custacctid
  is '���˺�';
comment on column F_B_BATCUSTFILE.custname
  is '����';
comment on column F_B_BATCUSTFILE.thirdcustid
  is '��Ա����';
comment on column F_B_BATCUSTFILE.bankbalance
  is '���������������';
comment on column F_B_BATCUSTFILE.bankfrozen
  is '��������󶳽����';
comment on column F_B_BATCUSTFILE.maketbalance
  is '�������������';
comment on column F_B_BATCUSTFILE.maketfrozen
  is '�������������';
comment on column F_B_BATCUSTFILE.balanceerror
  is '�����������п������-������������';
comment on column F_B_BATCUSTFILE.frozenerror
  is '�����������ж������-������������';
comment on column F_B_BATCUSTFILE.tradedate
  is '����ʱ��';
comment on column F_B_BATCUSTFILE.bankid
  is '���б��';
comment on column F_B_BATCUSTFILE.createdate
  is '��������';
comment on column F_B_BATCUSTFILE.note
  is '��ע��Ϣ';
alter table F_B_BATCUSTFILE
  add constraint PK_F_B_BATCUSTFILE primary key (CUSTACCTID, TRADEDATE);

prompt
prompt Creating table F_B_CAPITALINFO
prompt ==============================
prompt
create table F_B_CAPITALINFO
(
  id         NUMBER(12) not null,
  firmid     VARCHAR2(32) not null,
  funid      VARCHAR2(100),
  bankid     VARCHAR2(32) not null,
  debitid    VARCHAR2(32),
  creditid   VARCHAR2(32),
  type       NUMBER(2) not null,
  money      NUMBER(12,2) not null,
  operator   VARCHAR2(32),
  createtime DATE not null,
  banktime   DATE,
  status     NUMBER(2) not null,
  note       VARCHAR2(128),
  actionid   NUMBER(12) not null,
  express    NUMBER(1) default 0,
  bankname   VARCHAR2(50),
  account    VARCHAR2(21),
  createdate VARCHAR2(32) not null,
  funid2     VARCHAR2(100),
  platfirmid VARCHAR2(15)
)
;
comment on table F_B_CAPITALINFO
  is '�г���ˮ��';
comment on column F_B_CAPITALINFO.id
  is '��ˮID';
comment on column F_B_CAPITALINFO.firmid
  is '�����̴���';
comment on column F_B_CAPITALINFO.funid
  is '������ˮ��';
comment on column F_B_CAPITALINFO.bankid
  is '���б��';
comment on column F_B_CAPITALINFO.debitid
  is '��������';
comment on column F_B_CAPITALINFO.creditid
  is '�跽����';
comment on column F_B_CAPITALINFO.type
  is '��ˮ����(0 ���,1 ����,2�����������';
comment on column F_B_CAPITALINFO.money
  is '��ˮ���';
comment on column F_B_CAPITALINFO.operator
  is 'ҵ�����';
comment on column F_B_CAPITALINFO.createtime
  is '����ʱ��';
comment on column F_B_CAPITALINFO.banktime
  is '�����¼�';
comment on column F_B_CAPITALINFO.status
  is '״̬(0 �ɹ�,1 ʧ��,2 ������,3 һ�����,4 �������,5 ���з�����ϢΪ��,6 ���з����г���ˮ�ź��г�������ˮ�Ų�һ��,13 �г������г��������״̬)';
comment on column F_B_CAPITALINFO.note
  is '��ע��Ϣ';
comment on column F_B_CAPITALINFO.actionid
  is 'ҵ����ˮ';
comment on column F_B_CAPITALINFO.express
  is '�Ƿ�Ӽ�';
comment on column F_B_CAPITALINFO.bankname
  is '����ӵ�(��������)';
comment on column F_B_CAPITALINFO.account
  is '����ӵ�(�����˺�)';
comment on column F_B_CAPITALINFO.createdate
  is '����ʱ��';
comment on column F_B_CAPITALINFO.funid2
  is '��ˮ2';
alter table F_B_CAPITALINFO
  add primary key (ACTIONID);

prompt
prompt Creating table F_B_DICTIONARY
prompt =============================
prompt
create table F_B_DICTIONARY
(
  id     NUMBER(5) not null,
  type   NUMBER(5) not null,
  bankid VARCHAR2(32),
  name   VARCHAR2(128) not null,
  value  VARCHAR2(128),
  note   VARCHAR2(256) not null
)
;
comment on table F_B_DICTIONARY
  is '�ֵ��';
comment on column F_B_DICTIONARY.id
  is '�ֵ�ID';
comment on column F_B_DICTIONARY.type
  is '����';
comment on column F_B_DICTIONARY.bankid
  is '���б��';
comment on column F_B_DICTIONARY.name
  is '�ֵ���';
comment on column F_B_DICTIONARY.value
  is '�ֵ�ֵ';
comment on column F_B_DICTIONARY.note
  is '��ע';
alter table F_B_DICTIONARY
  add constraint PK_F_B_DICTIONARY primary key (ID);

prompt
prompt Creating table F_B_FEEINFO
prompt ==========================
prompt
create table F_B_FEEINFO
(
  id           NUMBER(12) not null,
  uplimit      NUMBER(12,2) not null,
  downlimit    NUMBER(12,2) not null,
  tmode        NUMBER(1) not null,
  rate         NUMBER not null,
  type         VARCHAR2(128) not null,
  createtime   DATE default SYSDATE,
  updatetime   DATE,
  userid       VARCHAR2(12) not null,
  maxratevalue NUMBER,
  minratevalue NUMBER
)
;
comment on table F_B_FEEINFO
  is '��׼���ñ�';
comment on column F_B_FEEINFO.id
  is '�����б�ID';
comment on column F_B_FEEINFO.uplimit
  is '�������';
comment on column F_B_FEEINFO.downlimit
  is '��ʼ���';
comment on column F_B_FEEINFO.tmode
  is '�������(0 �ٷֱ�,2 ����ֵ)';
comment on column F_B_FEEINFO.rate
  is '������';
comment on column F_B_FEEINFO.type
  is '�շ�����';
comment on column F_B_FEEINFO.createtime
  is '��¼ʱ��';
comment on column F_B_FEEINFO.updatetime
  is '�޸�ʱ��';
comment on column F_B_FEEINFO.userid
  is '�û�ID(��¼��,������,����)';
comment on column F_B_FEEINFO.maxratevalue
  is '�����';
comment on column F_B_FEEINFO.minratevalue
  is '��С���';
alter table F_B_FEEINFO
  add constraint PK_F_B_FEEINFO primary key (UPLIMIT, DOWNLIMIT, USERID, TYPE);

prompt
prompt Creating table F_B_FFHD
prompt =======================
prompt
create table F_B_FFHD
(
  bankid      VARCHAR2(32) not null,
  tradedate   DATE not null,
  firmid      VARCHAR2(32) not null,
  account     VARCHAR2(32) not null,
  currency    VARCHAR2(10) default '001' not null,
  type        NUMBER(2) default 0 not null,
  reasion     NUMBER(2) default 0 not null,
  balancem    NUMBER(15,2),
  cashm       NUMBER(15,2),
  billm       NUMBER(15,2),
  usebalancem NUMBER(15,2),
  frozencashm NUMBER(15,2),
  frozenloanm NUMBER(15,2),
  balanceb    NUMBER(15,2),
  cashb       NUMBER(15,2),
  billb       NUMBER(15,2),
  usebalanceb NUMBER(15,2),
  frozencashb NUMBER(15,2),
  frozenloanb NUMBER(15,2),
  createdate  DATE default sysdate not null
)
;
comment on table F_B_FFHD
  is '�ַֺ˶Ա�';
comment on column F_B_FFHD.bankid
  is '���б��';
comment on column F_B_FFHD.tradedate
  is '��������';
comment on column F_B_FFHD.firmid
  is '�����̱��';
comment on column F_B_FFHD.account
  is '�����������˺�';
comment on column F_B_FFHD.currency
  is '�ұ� (001������� 013���۱� 014����Ԫ)';
comment on column F_B_FFHD.type
  is '�����ʶ (0���� 1����)';
comment on column F_B_FFHD.reasion
  is '��ƽԭ�� (0:��ƽ 1:���ж��ʽ����˻�δ���� 2:�г��˽����̴��벻����)';
comment on column F_B_FFHD.balancem
  is '�г���Ȩ��';
comment on column F_B_FFHD.cashm
  is '�г��ֽ�Ȩ��';
comment on column F_B_FFHD.billm
  is '�г�Ʊ��Ȩ��';
comment on column F_B_FFHD.usebalancem
  is '�г������ʽ�';
comment on column F_B_FFHD.frozencashm
  is '�г�ռ���ֽ�';
comment on column F_B_FFHD.frozenloanm
  is '�г�ռ�ô�����';
comment on column F_B_FFHD.balanceb
  is '������Ȩ��';
comment on column F_B_FFHD.cashb
  is '�����ֽ�Ȩ��';
comment on column F_B_FFHD.billb
  is '����Ʊ��Ȩ��';
comment on column F_B_FFHD.usebalanceb
  is '���п����ʽ�';
comment on column F_B_FFHD.frozencashb
  is '����ռ���ֽ�';
comment on column F_B_FFHD.frozenloanb
  is '����ռ�ô�����';
comment on column F_B_FFHD.createdate
  is '����ʱ��';
alter table F_B_FFHD
  add constraint PK_F_B_FFHD primary key (BANKID, TRADEDATE, FIRMID);

prompt
prompt Creating table F_B_FIRMBALANCE
prompt ==============================
prompt
create table F_B_FIRMBALANCE
(
  custacctid    VARCHAR2(32) not null,
  custname      VARCHAR2(120),
  thirdcustid   VARCHAR2(32),
  status        NUMBER(2),
  type          NUMBER(2),
  istruecont    NUMBER(2),
  balance       NUMBER(18,2),
  usrbalance    NUMBER(18,2),
  frozenbalance NUMBER(18,2),
  interest      NUMBER(18,2),
  bankid        VARCHAR2(32),
  tradedate     DATE not null,
  createdate    DATE
)
;
comment on table F_B_FIRMBALANCE
  is '��Ա����¼';
comment on column F_B_FIRMBALANCE.custacctid
  is '���˺�';
comment on column F_B_FIRMBALANCE.custname
  is '�˻���';
comment on column F_B_FIRMBALANCE.thirdcustid
  is '��Ա����';
comment on column F_B_FIRMBALANCE.status
  is '״̬(1������  2���˳�  3����ȷ��)';
comment on column F_B_FIRMBALANCE.type
  is '�˺�����(1����ͨ��Ա���˺�  2���������˺�  3�����������˺�  4����Ϣ���˺�  6���������˺�)';
comment on column F_B_FIRMBALANCE.istruecont
  is '�Ƿ�ʵ���˺�(Ĭ��Ϊ 1�������˺�)';
comment on column F_B_FIRMBALANCE.balance
  is '�ܶ�';
comment on column F_B_FIRMBALANCE.usrbalance
  is '�������';
comment on column F_B_FIRMBALANCE.frozenbalance
  is '�����ʽ�';
comment on column F_B_FIRMBALANCE.interest
  is '��Ϣ����';
comment on column F_B_FIRMBALANCE.bankid
  is '���д���';
comment on column F_B_FIRMBALANCE.tradedate
  is '��������';
comment on column F_B_FIRMBALANCE.createdate
  is '��Ϣ����ʱ��';
alter table F_B_FIRMBALANCE
  add constraint PK_F_B_FIRMBALANCE primary key (CUSTACCTID, TRADEDATE);

prompt
prompt Creating table F_B_FIRMBALANCEERROR
prompt ===================================
prompt
create table F_B_FIRMBALANCEERROR
(
  trandatetime    DATE not null,
  counterid       VARCHAR2(12),
  supacctid       VARCHAR2(32),
  funccode        VARCHAR2(4),
  custacctid      VARCHAR2(32) not null,
  custname        VARCHAR2(120),
  thirdcustid     VARCHAR2(32),
  thirdlogno      VARCHAR2(20),
  ccycode         VARCHAR2(3),
  freezeamount    NUMBER(18,2),
  unfreezeamount  NUMBER(18,2),
  addtranamount   NUMBER(18,2),
  cuttranamount   NUMBER(18,2),
  profitamount    NUMBER(18,2),
  lossamount      NUMBER(18,2),
  tranhandfee     NUMBER(18,2),
  trancount       NUMBER(30),
  newbalance      NUMBER(18,2),
  newfreezeamount NUMBER(18,2),
  note            VARCHAR2(120),
  reserve         VARCHAR2(120),
  rspcode         VARCHAR2(6),
  rspmsg          VARCHAR2(256),
  bankid          VARCHAR2(32),
  createtime      DATE
)
;
comment on table F_B_FIRMBALANCEERROR
  is '���ж���ʧ���ļ�';
comment on column F_B_FIRMBALANCEERROR.trandatetime
  is '����ʱ��';
comment on column F_B_FIRMBALANCEERROR.counterid
  is '����Ա';
comment on column F_B_FIRMBALANCEERROR.supacctid
  is '�ʽ�����ʺ�';
comment on column F_B_FIRMBALANCEERROR.funccode
  is '���ܴ���';
comment on column F_B_FIRMBALANCEERROR.custacctid
  is '���˻��˺�';
comment on column F_B_FIRMBALANCEERROR.custname
  is '���˻�����';
comment on column F_B_FIRMBALANCEERROR.thirdcustid
  is '��������Ա����';
comment on column F_B_FIRMBALANCEERROR.thirdlogno
  is '��������ˮ��';
comment on column F_B_FIRMBALANCEERROR.ccycode
  is '����';
comment on column F_B_FIRMBALANCEERROR.freezeamount
  is '�����ܶ����ʽ�';
comment on column F_B_FIRMBALANCEERROR.unfreezeamount
  is '�����ܽⶳ�ʽ�';
comment on column F_B_FIRMBALANCEERROR.addtranamount
  is '����ɽ����ܻ���(����)';
comment on column F_B_FIRMBALANCEERROR.cuttranamount
  is '����ɽ����ܻ���(��)';
comment on column F_B_FIRMBALANCEERROR.profitamount
  is 'ӯ���ܽ��';
comment on column F_B_FIRMBALANCEERROR.lossamount
  is '�����ܽ��';
comment on column F_B_FIRMBALANCEERROR.tranhandfee
  is '�����̵���Ӧ������������������';
comment on column F_B_FIRMBALANCEERROR.trancount
  is '���콻���ܱ���';
comment on column F_B_FIRMBALANCEERROR.newbalance
  is '�����������µĽ����̿��ý��';
comment on column F_B_FIRMBALANCEERROR.newfreezeamount
  is '�����������µĶ����ʽ�';
comment on column F_B_FIRMBALANCEERROR.note
  is '˵��';
comment on column F_B_FIRMBALANCEERROR.reserve
  is '������';
comment on column F_B_FIRMBALANCEERROR.rspcode
  is '������';
comment on column F_B_FIRMBALANCEERROR.rspmsg
  is 'Ӧ������';
comment on column F_B_FIRMBALANCEERROR.bankid
  is '���д���';
comment on column F_B_FIRMBALANCEERROR.createtime
  is '��Ϣ����ʱ��';
alter table F_B_FIRMBALANCEERROR
  add constraint PK_F_B_FIRMBALANCEERROR primary key (TRANDATETIME, CUSTACCTID);

prompt
prompt Creating table F_B_FIRMIDANDACCOUNT
prompt ===================================
prompt
create table F_B_FIRMIDANDACCOUNT
(
  bankid       VARCHAR2(32) not null,
  firmid       VARCHAR2(32) not null,
  account      VARCHAR2(32) not null,
  account1     VARCHAR2(32),
  status       NUMBER(1) default 0 not null,
  accountname  VARCHAR2(100),
  bankname     VARCHAR2(128),
  bankprovince VARCHAR2(128),
  bankcity     VARCHAR2(128),
  mobile       VARCHAR2(32),
  email        VARCHAR2(128),
  isopen       NUMBER(1) default 1 not null,
  cardtype     VARCHAR2(2) default 1 not null,
  card         VARCHAR2(32),
  frozenfuns   NUMBER(15,2) default 0.00 not null,
  accountname1 VARCHAR2(100),
  opentime     DATE,
  deltime      DATE,
  inmarketcode VARCHAR2(120)
)
;
comment on table F_B_FIRMIDANDACCOUNT
  is '�����������˺Ŷ�Ӧ��';
comment on column F_B_FIRMIDANDACCOUNT.bankid
  is '���б��';
comment on column F_B_FIRMIDANDACCOUNT.firmid
  is '�����̴���';
comment on column F_B_FIRMIDANDACCOUNT.account
  is '�����ʺ�';
comment on column F_B_FIRMIDANDACCOUNT.account1
  is '�����ڲ��˺�';
comment on column F_B_FIRMIDANDACCOUNT.status
  is '״̬(0 ����,1 ����)';
comment on column F_B_FIRMIDANDACCOUNT.accountname
  is '�˻���';
comment on column F_B_FIRMIDANDACCOUNT.bankname
  is '��������';
comment on column F_B_FIRMIDANDACCOUNT.bankprovince
  is '����ʡ��';
comment on column F_B_FIRMIDANDACCOUNT.bankcity
  is '����������';
comment on column F_B_FIRMIDANDACCOUNT.mobile
  is '�绰����';
comment on column F_B_FIRMIDANDACCOUNT.email
  is '����';
comment on column F_B_FIRMIDANDACCOUNT.isopen
  is '�Ƿ���ǩԼ(0 δǩԼ,1 ��ǩԼ)';
comment on column F_B_FIRMIDANDACCOUNT.cardtype
  is '--�ʻ�����(1 ���֤,2����֤,3���ڻ���,4���ڱ�,5ѧԱ֤,6����֤,7��ʱ���֤,8��֯��������,9Ӫҵִ��,A����֤,B��ž�ʿ��֤,C����֤,D�������,E�۰�̨�������֤,F̨��ͨ��֤��������Ч����֤,G����ͻ����,H��ž���ְ�ɲ�֤,I�侯��ְ�ɲ�֤,J�侯ʿ��֤,X������Ч֤��,Z�غ����֤)(��Ҫ�õ��� 1��8,���� 9 �� ������û���õ�)';
comment on column F_B_FIRMIDANDACCOUNT.card
  is '֤������';
comment on column F_B_FIRMIDANDACCOUNT.frozenfuns
  is '�����ʽ�';
comment on column F_B_FIRMIDANDACCOUNT.accountname1
  is '�����ڲ��˻�����';
comment on column F_B_FIRMIDANDACCOUNT.opentime
  is '����ʱ��';
comment on column F_B_FIRMIDANDACCOUNT.inmarketcode
  is '����������Э���';
alter table F_B_FIRMIDANDACCOUNT
  add constraint PK_F_B_FIRMIDANDACCOUNT primary key (BANKID, FIRMID);

prompt
prompt Creating table F_B_FIRMKXH
prompt ==========================
prompt
create table F_B_FIRMKXH
(
  funid        VARCHAR2(32) not null,
  status       NUMBER(2) not null,
  account1     VARCHAR2(32) not null,
  type         NUMBER(1) not null,
  account1name VARCHAR2(120) not null,
  firmid       VARCHAR2(32) not null,
  tradedate    DATE not null,
  counterid    VARCHAR2(12),
  bankid       VARCHAR2(32),
  createdate   DATE default sysdate    --��¼��������
)
;
comment on table F_B_FIRMKXH
  is '�����Ա��������Ϣ��';
comment on column F_B_FIRMKXH.funid
  is '����ǰ����ˮ��';
comment on column F_B_FIRMKXH.status
  is '����״̬(1������ 2������ 3����ȷ��)';
comment on column F_B_FIRMKXH.account1
  is '��Ա���˺�';
comment on column F_B_FIRMKXH.type
  is '���˻�����';
comment on column F_B_FIRMKXH.account1name
  is '���˻�����';
comment on column F_B_FIRMKXH.firmid
  is '�����̴���';
comment on column F_B_FIRMKXH.tradedate
  is '��������';
comment on column F_B_FIRMKXH.counterid
  is '������Ա��';
comment on column F_B_FIRMKXH.bankid
  is '���д���';
comment on column F_B_FIRMKXH.createdate
  is '��¼��������';
alter table F_B_FIRMKXH
  add constraint PK_F_B_FIRMKXH primary key (FUNID, TRADEDATE);

prompt
prompt Creating table F_B_FIRMTRADESTATUS
prompt ==================================
prompt
create table F_B_FIRMTRADESTATUS
(
  bankid      VARCHAR2(20) not null,
  dealid      VARCHAR2(20) not null,
  cobrn       VARCHAR2(20),
  txdate      VARCHAR2(20) not null,
  bankacc     VARCHAR2(32) not null,
  fundacc     VARCHAR2(32) not null,
  custname    VARCHAR2(100) not null,
  curcode     VARCHAR2(10) not null,
  status      VARCHAR2(10) not null,
  comparedate DATE not null
)
;
comment on table F_B_FIRMTRADESTATUS
  is '�ͻ�Э��״̬�����������˱�';
comment on column F_B_FIRMTRADESTATUS.bankid
  is '����id';
comment on column F_B_FIRMTRADESTATUS.dealid
  is '�г���֯��������';
comment on column F_B_FIRMTRADESTATUS.cobrn
  is '������������';
comment on column F_B_FIRMTRADESTATUS.txdate
  is '��������';
comment on column F_B_FIRMTRADESTATUS.bankacc
  is '�����˺�';
comment on column F_B_FIRMTRADESTATUS.fundacc
  is '�����̴���';
comment on column F_B_FIRMTRADESTATUS.custname
  is '����������';
comment on column F_B_FIRMTRADESTATUS.curcode
  is '����';
comment on column F_B_FIRMTRADESTATUS.status
  is '״̬';
comment on column F_B_FIRMTRADESTATUS.comparedate
  is '��������';
alter table F_B_FIRMTRADESTATUS
  add constraint F_B_FIRMTRADESTATUS primary key (BANKID, BANKACC, COMPAREDATE);

prompt
prompt Creating table F_B_FIRMUSER
prompt ===========================
prompt
create table F_B_FIRMUSER
(
  firmid              VARCHAR2(32) not null,
  name                VARCHAR2(64),
  maxpersgltransmoney NUMBER(12,2),
  maxpertransmoney    NUMBER(12,2),
  maxpertranscount    NUMBER(7),
  status              NUMBER(1) not null,
  registerdate        DATE not null,
  logoutdate          DATE,
  maxauditmoney       NUMBER(12,2),
  password            VARCHAR2(64)
)
;
comment on table F_B_FIRMUSER
  is '���нӿڲ����û���';
comment on column F_B_FIRMUSER.firmid
  is '�����̴���';
comment on column F_B_FIRMUSER.name
  is '����������';
comment on column F_B_FIRMUSER.maxpersgltransmoney
  is '�������ת�˽��';
comment on column F_B_FIRMUSER.maxpertransmoney
  is 'ÿ�����ת�˽��';
comment on column F_B_FIRMUSER.maxpertranscount
  is 'ÿ�����ת�˴���';
comment on column F_B_FIRMUSER.status
  is '������״̬(0 ��ע��,1 ���û�δע��,2ע��)';
comment on column F_B_FIRMUSER.registerdate
  is 'ע������';
comment on column F_B_FIRMUSER.logoutdate
  is 'ע������';
comment on column F_B_FIRMUSER.maxauditmoney
  is '��˶��';
comment on column F_B_FIRMUSER.password
  is '����';
alter table F_B_FIRMUSER
  add constraint PK_F_B_FIRMUSER primary key (FIRMID);

prompt
prompt Creating table F_B_HXQS
prompt =======================
prompt
create table F_B_HXQS
(
  bankid     VARCHAR2(32) not null,
  firmid     VARCHAR2(32) not null,
  tradedate  DATE not null,
  money      NUMBER(15,2) not null,
  type       NUMBER(2) not null,
  tradetype  NUMBER(2) not null,
  note       VARCHAR2(120),
  createdate DATE default sysdate not null,
  status     NUMBER(2)
)
;
comment on table F_B_HXQS
  is '��ӻ��������';
comment on column F_B_HXQS.bankid
  is '���б��';
comment on column F_B_HXQS.firmid
  is '�����̱��';
comment on column F_B_HXQS.tradedate
  is '��������';
comment on column F_B_HXQS.money
  is '���';
comment on column F_B_HXQS.type
  is '�����ʾ (1:�裬�ʽ���� 2:�����ʽ�����)';
comment on column F_B_HXQS.tradetype
  is '�ʽ�����';
comment on column F_B_HXQS.note
  is '��ע��Ϣ';
comment on column F_B_HXQS.createdate
  is '����д��ʱ��';
comment on column F_B_HXQS.status
  is '��ǰ״̬(0:�ɹ� 1:ʧ�� 2:���δ֪)';
alter table F_B_HXQS
  add constraint PK_F_B_HXQS primary key (BANKID, FIRMID, TRADEDATE);

prompt
prompt Creating table F_B_INTERFACELOG
prompt ===============================
prompt
create table F_B_INTERFACELOG
(
  logid      NUMBER(12) not null,
  bankid     VARCHAR2(32) not null,
  launcher   NUMBER(2) not null,
  type       NUMBER(2) not null,
  contact    VARCHAR2(32),
  account    VARCHAR2(32),
  beginmsg   VARCHAR2(512),
  endmsg     VARCHAR2(512),
  result     NUMBER(2) default 0 not null,
  createtime DATE default sysdate not null
)
;
comment on column F_B_INTERFACELOG.bankid
  is '���д���
���д���';
comment on column F_B_INTERFACELOG.launcher
  is '����
0 �г�
1 ����';
comment on column F_B_INTERFACELOG.type
  is '��������
1 ǩ��
2 ǩ��
3 ǩԼ
4 ��Լ
5 ��ѯ���
6 ����
7 ���
8 ����';
alter table F_B_INTERFACELOG
  add constraint PK_F_B_INTERFACELOG primary key (LOGID);

prompt
prompt Creating table F_B_LOG
prompt ======================
prompt
create table F_B_LOG
(
  logid      NUMBER not null,
  logopr     VARCHAR2(50) not null,
  logcontent VARCHAR2(4000) not null,
  logdate    DATE not null,
  logip      VARCHAR2(20)
)
;
comment on table F_B_LOG
  is '���нӿڲ��ֲ�����ָ��';
comment on column F_B_LOG.logid
  is '��־���';
comment on column F_B_LOG.logopr
  is '����Ա';
comment on column F_B_LOG.logcontent
  is '��������';
comment on column F_B_LOG.logdate
  is '��־��¼����';
comment on column F_B_LOG.logip
  is '��־��¼��¼����';
alter table F_B_LOG
  add constraint PK_F_B_LOG primary key (LOGID);

prompt
prompt Creating table F_B_MAKETMONEY
prompt =============================
prompt
create table F_B_MAKETMONEY
(
  id         NUMBER(15) not null,
  bankid     VARCHAR2(32) not null,
  banknumber VARCHAR2(50),
  type       NUMBER(2) not null,
  adddelt    NUMBER(2) not null,
  money      NUMBER(15,2) not null,
  note       VARCHAR2(120),
  createtime DATE default sysdate   --����ʱ��
)
;
comment on table F_B_MAKETMONEY
  is '����г������ʽ���Ϣ��';
comment on column F_B_MAKETMONEY.id
  is '�����ʽ���';
comment on column F_B_MAKETMONEY.bankid
  is '���б��';
comment on column F_B_MAKETMONEY.banknumber
  is ' ����ת�˺�';
comment on column F_B_MAKETMONEY.type
  is '�ʽ����� (1:������,2:��Ϣ)';
comment on column F_B_MAKETMONEY.adddelt
  is '���ӡ������ʽ�(1:���� 2:����)';
comment on column F_B_MAKETMONEY.money
  is '���ӡ����ٽ����';
comment on column F_B_MAKETMONEY.note
  is '��ע��Ϣ';
comment on column F_B_MAKETMONEY.createtime
  is '����ʱ��';
alter table F_B_MAKETMONEY
  add constraint PK_F_B_MAKETMONEY primary key (ID);

prompt
prompt Creating table F_B_MARGINS
prompt ==========================
prompt
create table F_B_MARGINS
(
  serial_id     VARCHAR2(15) not null,
  bargain_code  VARCHAR2(10) not null,
  trade_type    VARCHAR2(1),
  trade_money   NUMBER(15,2),
  member_code   VARCHAR2(32),
  member_name   VARCHAR2(120),
  trade_date    DATE,
  good_code     VARCHAR2(10),
  good_name     VARCHAR2(120),
  good_quantity NUMBER(15),
  flag          VARCHAR2(1),
  bankid        VARCHAR2(32) not null,
  createdate    DATE,
  note          VARCHAR2(120)
)
;
comment on table F_B_MARGINS
  is '�������ʽ𶳽�ⶳ��';
comment on column F_B_MARGINS.serial_id
  is 'ҵ����ˮ��';
comment on column F_B_MARGINS.bargain_code
  is '�ɽ���ͬ��';
comment on column F_B_MARGINS.trade_type
  is '�������� (1 ���᣻2 �ⶳ)';
comment on column F_B_MARGINS.trade_money
  is '���׽��';
comment on column F_B_MARGINS.member_code
  is '���׻�Ա��';
comment on column F_B_MARGINS.member_name
  is '���׻�Ա����';
comment on column F_B_MARGINS.trade_date
  is '��������';
comment on column F_B_MARGINS.good_code
  is '��Ʒ���';
comment on column F_B_MARGINS.good_name
  is '��Ʒ����';
comment on column F_B_MARGINS.good_quantity
  is '��Ʒ����';
comment on column F_B_MARGINS.flag
  is '����״̬ (N δ���ͣ�F ���д���ʧ�ܣ�Y ���д���ɹ�)';
comment on column F_B_MARGINS.bankid
  is '���б��';
comment on column F_B_MARGINS.createdate
  is '����ʱ��';
comment on column F_B_MARGINS.note
  is '�ʽ𶳽�ⶳ��ע�ֶ�';
alter table F_B_MARGINS
  add constraint PK_F_B_MARGINS primary key (SERIAL_ID, BARGAIN_CODE, BANKID);

prompt
prompt Creating table F_B_PLATFORMMSG
prompt ==============================
prompt
create table F_B_PLATFORMMSG
(
  firmid     VARCHAR2(15) not null,
  platfirmid VARCHAR2(15) not null
)
;
alter table F_B_PLATFORMMSG
  add constraint F_B_PLATFORMMSG_PRIMARY primary key (FIRMID);

prompt
prompt Creating table F_B_PROPERBALANCE
prompt ================================
prompt
create table F_B_PROPERBALANCE
(
  bankid     VARCHAR2(20) not null,
  allmoney   NUMBER not null,
  gongmoney  NUMBER not null,
  othermoney NUMBER not null,
  bdate      TIMESTAMP(6) not null
)
;
comment on table F_B_PROPERBALANCE
  is '�ܷ�ƽ���';
comment on column F_B_PROPERBALANCE.bankid
  is '���б��';
comment on column F_B_PROPERBALANCE.allmoney
  is '���ʽ�';
comment on column F_B_PROPERBALANCE.gongmoney
  is '�������ʽ�';
comment on column F_B_PROPERBALANCE.othermoney
  is '�������ʽ�';
comment on column F_B_PROPERBALANCE.bdate
  is '����ʱ��';

prompt
prompt Creating table F_B_QSRESULT
prompt ===========================
prompt
create table F_B_QSRESULT
(
  resultid   NUMBER(12) not null,
  bankid     VARCHAR2(32) not null,
  bankname   VARCHAR2(120),
  firmid     VARCHAR2(32),
  firmname   VARCHAR2(120),
  account    VARCHAR2(20),
  account1   VARCHAR2(20),
  kymoneym   NUMBER(18,2),
  kymoneyb   NUMBER(18,2),
  djmoneym   NUMBER(18,2),
  djmoneyb   NUMBER(18,2),
  zckymoney  NUMBER(18,2),
  zcdjmoney  NUMBER(18,2),
  moneym     NUMBER(18,2),
  moneyb     NUMBER(18,2),
  zcmoney    NUMBER(18,2),
  createdate DATE default sysdate,
  tradedate  DATE not null,
  status     NUMBER(2) not null,
  note       VARCHAR2(120)
)
;
comment on table F_B_QSRESULT
  is '���˲�ƽ��¼��Ϣ';
comment on column F_B_QSRESULT.resultid
  is '��ˮ���';
comment on column F_B_QSRESULT.bankid
  is '���б��';
comment on column F_B_QSRESULT.bankname
  is '��������';
comment on column F_B_QSRESULT.firmid
  is '�����̴���';
comment on column F_B_QSRESULT.firmname
  is '����������';
comment on column F_B_QSRESULT.account
  is '�����˺�';
comment on column F_B_QSRESULT.account1
  is '���˺�';
comment on column F_B_QSRESULT.kymoneym
  is '�г��������';
comment on column F_B_QSRESULT.kymoneyb
  is '���п������';
comment on column F_B_QSRESULT.djmoneym
  is '�г������ʽ�';
comment on column F_B_QSRESULT.djmoneyb
  is '���ж����ʽ�';
comment on column F_B_QSRESULT.zckymoney
  is '�����ʽ�����';
comment on column F_B_QSRESULT.zcdjmoney
  is '�����ʽ�����';
comment on column F_B_QSRESULT.moneym
  is '�г�Ȩ��';
comment on column F_B_QSRESULT.moneyb
  is '����Ȩ��';
comment on column F_B_QSRESULT.zcmoney
  is 'Ȩ������';
comment on column F_B_QSRESULT.createdate
  is '��¼����ʱ��';
comment on column F_B_QSRESULT.tradedate
  is '��������';
comment on column F_B_QSRESULT.status
  is '����״̬(0:�ɹ���1:ʧ�ܡ�2:�������ȡ�3:�������ȡ�4:�����ȡ�6:�˺��ʽ��쳣)';
comment on column F_B_QSRESULT.note
  is '��ע��Ϣ';
alter table F_B_QSRESULT
  add constraint PK_F_B_QSRESULT primary key (RESULTID);

prompt
prompt Creating table F_B_QUANYI
prompt =========================
prompt
create table F_B_QUANYI
(
  id                 NUMBER(12) not null,
  firmid             VARCHAR2(32) not null,
  venduebalance      NUMBER(12,2) not null,
  zcjsbalance        NUMBER(12,2) not null,
  timebargainbalance NUMBER(12,2) not null,
  avilablebalance    NUMBER(12,2) not null,
  bankbalance        NUMBER(12,2) not null,
  payment            NUMBER(12,2) not null,
  income             NUMBER(12,2) not null,
  fee                NUMBER(12,2) not null,
  jie                NUMBER(12,2) not null,
  dai                NUMBER(12,2) not null,
  dealtime           DATE not null
)
;
comment on table F_B_QUANYI
  is '����Ȩ���';
comment on column F_B_QUANYI.id
  is '��ID';
comment on column F_B_QUANYI.firmid
  is '�����̴���';
comment on column F_B_QUANYI.venduebalance
  is '���۲���ռ�ñ�֤��';
comment on column F_B_QUANYI.zcjsbalance
  is '���Ʋ���ռ�ñ�֤��';
comment on column F_B_QUANYI.timebargainbalance
  is '��Զ�ڲ���Ȩ��';
comment on column F_B_QUANYI.avilablebalance
  is '�������';
comment on column F_B_QUANYI.bankbalance
  is '�������';
comment on column F_B_QUANYI.payment
  is '�ջ���';
comment on column F_B_QUANYI.income
  is '������';
comment on column F_B_QUANYI.fee
  is '������';
comment on column F_B_QUANYI.jie
  is '�Ӵ����';
comment on column F_B_QUANYI.dai
  is '������';
comment on column F_B_QUANYI.dealtime
  is '��¼����';
alter table F_B_QUANYI
  add primary key (ID);

prompt
prompt Creating table F_B_RGSTCAPITALVALUE
prompt ===================================
prompt
create table F_B_RGSTCAPITALVALUE
(
  id          NUMBER(12) not null,
  actionid    NUMBER(12) not null,
  firmid      VARCHAR2(32) not null,
  account     VARCHAR2(32) not null,
  bankid      VARCHAR2(32) not null,
  type        NUMBER(2) not null,
  createtime  DATE not null,
  banktime    DATE,
  status      NUMBER(2) not null,
  accountname VARCHAR2(32) not null,
  cardtype    VARCHAR2(2) default 1 not null,
  card        VARCHAR2(32),
  note        VARCHAR2(128)
)
;
comment on column F_B_RGSTCAPITALVALUE.id
  is '��¼��ˮ��';
comment on column F_B_RGSTCAPITALVALUE.actionid
  is '�г���ˮ��';
comment on column F_B_RGSTCAPITALVALUE.firmid
  is '�����̴���';
comment on column F_B_RGSTCAPITALVALUE.account
  is 'ǩԼЭ���';
comment on column F_B_RGSTCAPITALVALUE.bankid
  is '���д���';
comment on column F_B_RGSTCAPITALVALUE.type
  is '��ˮ���� 1ǩԼ  2��Լ';
comment on column F_B_RGSTCAPITALVALUE.createtime
  is '����ʱ��';
comment on column F_B_RGSTCAPITALVALUE.banktime
  is '���ʱ��';
comment on column F_B_RGSTCAPITALVALUE.status
  is '��ˮ״̬ 0�ɹ� 1ʧ�� 2������';
comment on column F_B_RGSTCAPITALVALUE.accountname
  is '����';
comment on column F_B_RGSTCAPITALVALUE.cardtype
  is '֤������';
comment on column F_B_RGSTCAPITALVALUE.card
  is '֤����';
comment on column F_B_RGSTCAPITALVALUE.note
  is '��ע';
alter table F_B_RGSTCAPITALVALUE
  add constraint PK_F_B_RGSTCAPITALVALUE primary key (FIRMID, BANKID, TYPE, CREATETIME);

prompt
prompt Creating table F_B_TRADEDATA
prompt ============================
prompt
create table F_B_TRADEDATA
(
  firmid           VARCHAR2(32) not null,
  account1         VARCHAR2(32),
  money            NUMBER(12,2) default 1 not null,
  type             NUMBER(2) not null,
  status           NUMBER(2) not null,
  transferdate     DATE not null,
  accountname1     VARCHAR2(100),
  actionid         VARCHAR2(32) not null,
  funid            VARCHAR2(32),
  compareresult    NUMBER(1) default 2 not null,
  banktime         VARCHAR2(32),
  realtransferdate VARCHAR2(32),
  sendperson       VARCHAR2(32)
)
;
comment on table F_B_TRADEDATA
  is '�������ݱ�';
comment on column F_B_TRADEDATA.firmid
  is '������id';
comment on column F_B_TRADEDATA.account1
  is '�����˺� [��Ӧ�����������ʺŶ�Ӧ����ڲ��ʺ�]';
comment on column F_B_TRADEDATA.money
  is '�䶯���';
comment on column F_B_TRADEDATA.type
  is '����(0��Ȩ����  1��Ȩ���  2���ջ���  3��������   4�������� 5�� �ʽ���� 6�� �ʽ����)';
comment on column F_B_TRADEDATA.status
  is '���ͽ��(1��δ����   0�����ͳɹ�)';
comment on column F_B_TRADEDATA.transferdate
  is 'Ӧ����ʱ��';
comment on column F_B_TRADEDATA.accountname1
  is '�����˺�����';
comment on column F_B_TRADEDATA.actionid
  is '�г���ˮ��';
comment on column F_B_TRADEDATA.funid
  is '������ˮ��';
comment on column F_B_TRADEDATA.compareresult
  is '����ת��';
comment on column F_B_TRADEDATA.banktime
  is '����ʱ��';
comment on column F_B_TRADEDATA.realtransferdate
  is 'ʵ�ʷ���ʱ��';
comment on column F_B_TRADEDATA.sendperson
  is '������';
alter table F_B_TRADEDATA
  add primary key (ACTIONID);

prompt
prompt Creating table F_B_TRADEDETAILACC
prompt =================================
prompt
create table F_B_TRADEDETAILACC
(
  batchno     VARCHAR2(20) not null,
  bankid      VARCHAR2(20) not null,
  dealid      VARCHAR2(20) not null,
  cobrn       VARCHAR2(20),
  txdate      VARCHAR2(20),
  txtime      VARCHAR2(20),
  bkserial    VARCHAR2(32) not null,
  coserial    VARCHAR2(32) not null,
  bankacc     VARCHAR2(32) not null,
  fundacc     VARCHAR2(32) not null,
  custname    VARCHAR2(100) not null,
  txopt       VARCHAR2(20) not null,
  txcode      VARCHAR2(20) not null,
  curcode     VARCHAR2(20) not null,
  comparedate DATE not null
)
;
comment on table F_B_TRADEDETAILACC
  is '�˻��ཻ�׶�����ϸ��';
comment on column F_B_TRADEDETAILACC.batchno
  is '�������';
comment on column F_B_TRADEDETAILACC.bankid
  is '����id';
comment on column F_B_TRADEDETAILACC.dealid
  is '�г���֯��������';
comment on column F_B_TRADEDETAILACC.cobrn
  is '��������������';
comment on column F_B_TRADEDETAILACC.txdate
  is '��������';
comment on column F_B_TRADEDETAILACC.txtime
  is '����ʱ��';
comment on column F_B_TRADEDETAILACC.bkserial
  is '������ˮ';
comment on column F_B_TRADEDETAILACC.coserial
  is '�г���ˮ';
comment on column F_B_TRADEDETAILACC.bankacc
  is '�����˺�';
comment on column F_B_TRADEDETAILACC.fundacc
  is '�����̴���';
comment on column F_B_TRADEDETAILACC.custname
  is '����������';
comment on column F_B_TRADEDETAILACC.txopt
  is '���׷���';
comment on column F_B_TRADEDETAILACC.txcode
  is '��������';
comment on column F_B_TRADEDETAILACC.curcode
  is '����';
comment on column F_B_TRADEDETAILACC.comparedate
  is '��������';
alter table F_B_TRADEDETAILACC
  add constraint F_B_TRADEDETAILACC primary key (BANKID, BKSERIAL, COMPAREDATE);

prompt
prompt Creating table F_B_TRADELIST
prompt ============================
prompt
create table F_B_TRADELIST
(
  trade_money   NUMBER(15,2),
  trade_type    VARCHAR2(2),
  b_member_code VARCHAR2(6),
  b_member_name VARCHAR2(120),
  s_member_code VARCHAR2(6),
  s_member_name VARCHAR2(120),
  trade_date    DATE,
  bargain_code  VARCHAR2(20) not null,
  serial_id     VARCHAR2(15) not null,
  good_code     VARCHAR2(10),
  good_name     VARCHAR2(100),
  good_quantity NUMBER(15),
  flag          VARCHAR2(1),
  bankid        VARCHAR2(32) not null,
  createdate    DATE,
  note          VARCHAR2(120)
)
;
comment on table F_B_TRADELIST
  is '������Ȩ������';
comment on column F_B_TRADELIST.trade_money
  is '������';
comment on column F_B_TRADELIST.trade_type
  is '��������(1 ���ӯ���������ѣ�2 ���������ѣ�3 ���������ѣ�4 ������5 ����������)';
comment on column F_B_TRADELIST.b_member_code
  is '�򷽻�Ա��';
comment on column F_B_TRADELIST.b_member_name
  is '�򷽻�Ա����';
comment on column F_B_TRADELIST.s_member_code
  is '������Ա��';
comment on column F_B_TRADELIST.s_member_name
  is '�򷽻�Ա����';
comment on column F_B_TRADELIST.trade_date
  is '��������';
comment on column F_B_TRADELIST.bargain_code
  is '�ɽ���ͬ��';
comment on column F_B_TRADELIST.serial_id
  is '������ˮ��';
comment on column F_B_TRADELIST.good_code
  is '������';
comment on column F_B_TRADELIST.good_name
  is '��������';
comment on column F_B_TRADELIST.good_quantity
  is '��������';
comment on column F_B_TRADELIST.flag
  is '����״̬ (N δ���ͣ�F ���д���ʧ�ܣ�Y ���д���ɹ�)';
comment on column F_B_TRADELIST.bankid
  is '���б��';
comment on column F_B_TRADELIST.createdate
  is '����ʱ��';
comment on column F_B_TRADELIST.note
  is '������Ȩ������ע�ֶ�';
alter table F_B_TRADELIST
  add constraint PK_F_B_TRADELIST primary key (BARGAIN_CODE, SERIAL_ID, BANKID);

prompt
prompt Creating table F_B_TRANSMONEYOBJ
prompt ================================
prompt
create table F_B_TRANSMONEYOBJ
(
  id        NUMBER(5) not null,
  classname VARCHAR2(32) not null,
  note      VARCHAR2(256) not null
)
;
comment on table F_B_TRANSMONEYOBJ
  is '�ʽ�ת�����';
comment on column F_B_TRANSMONEYOBJ.id
  is '���';
comment on column F_B_TRANSMONEYOBJ.classname
  is 'ҵ��ʵ����';
comment on column F_B_TRANSMONEYOBJ.note
  is '��ע';

prompt
prompt Creating table F_B_ZFPH
prompt =======================
prompt
create table F_B_ZFPH
(
  bankid             VARCHAR2(32) not null,
  tradedate          DATE default sysdate not null,
  currency           VARCHAR2(10) default '001' not null,
  type               NUMBER(2) default 0 not null,
  lastaccountbalance NUMBER(15,2) default 0 not null,
  accountbalance     NUMBER(15,2) default 0 not null,
  result             NUMBER(2) default 0 not null,
  createdate         DATE default sysdate not null
)
;
comment on table F_B_ZFPH
  is '�ܷ�ƽ���';
comment on column F_B_ZFPH.bankid
  is '���б��';
comment on column F_B_ZFPH.tradedate
  is '��������';
comment on column F_B_ZFPH.currency
  is '�ұ� (001������� 013���۱� 014����Ԫ)';
comment on column F_B_ZFPH.type
  is ' �����ʶ��0���� 1���㣩';
comment on column F_B_ZFPH.lastaccountbalance
  is '�ʽ�����ϸ�˻�������';
comment on column F_B_ZFPH.accountbalance
  is '�ʽ�����˺Ž��';
comment on column F_B_ZFPH.result
  is '�ֶܷ��˽��(0��ƽ 1����ƽ)';
comment on column F_B_ZFPH.createdate
  is '����ʱ��';
alter table F_B_ZFPH
  add constraint PK_F_B_ZFPH primary key (BANKID, TRADEDATE);

prompt
prompt Creating table F_CLEARSTATUS
prompt ============================
prompt
create table F_CLEARSTATUS
(
  actionid   NUMBER(3) not null,
  actionnote VARCHAR2(32) not null,
  status     CHAR(1) not null,
  finishtime DATE
)
;
comment on column F_CLEARSTATUS.status
  is 'Y:���
N:δִ��';
alter table F_CLEARSTATUS
  add constraint PK_F_CLEARSTATUS primary key (ACTIONID);

prompt
prompt Creating table F_CLIENTLEDGER
prompt =============================
prompt
create table F_CLIENTLEDGER
(
  b_date DATE not null,
  firmid VARCHAR2(32) not null,
  code   VARCHAR2(16) not null,
  value  NUMBER(15,2) not null
)
;
alter table F_CLIENTLEDGER
  add constraint PK_F_CLIENTLEDGER primary key (B_DATE, FIRMID, CODE);

prompt
prompt Creating table F_DAILYBALANCE
prompt =============================
prompt
create table F_DAILYBALANCE
(
  b_date         DATE not null,
  accountcode    VARCHAR2(38) not null,
  lastdaybalance NUMBER(15,2),
  debitamount    NUMBER(15,2),
  creditamount   NUMBER(15,2),
  todaybalance   NUMBER(15,2)
)
;
alter table F_DAILYBALANCE
  add constraint PK_F_DAILYBALANCE primary key (B_DATE, ACCOUNTCODE);

prompt
prompt Creating table F_FIRMBALANCE
prompt ============================
prompt
create table F_FIRMBALANCE
(
  b_date           DATE not null,
  firmid           VARCHAR2(32) not null,
  lastbalance      NUMBER(15,2) default 0 not null,
  todaybalance     NUMBER(15,2) default 0 not null,
  lastwarranty     NUMBER(15,2) not null,
  todaywarranty    NUMBER(15,2) not null,
  lastsettlemargin NUMBER(15,2) default 0 not null,
  settlemargin     NUMBER(15,2) default 0 not null
)
;
alter table F_FIRMBALANCE
  add constraint PK_F_H_FIRMBALANCE primary key (B_DATE, FIRMID);

prompt
prompt Creating table F_FIRMCLEARFUNDS
prompt ===============================
prompt
create table F_FIRMCLEARFUNDS
(
  b_date            DATE not null,
  firmid            VARCHAR2(32) not null,
  balance           NUMBER(15,2) default 0 not null,
  rightsfrozenfunds NUMBER(15,2) default 0 not null,
  rights            NUMBER(15,2) default 0 not null,
  firmfee           NUMBER(15,2) default 0 not null,
  marketfee         NUMBER(15,2) default 0 not null
)
;
alter table F_FIRMCLEARFUNDS
  add constraint PK_F_FIRMCLEARFUNDS primary key (B_DATE, FIRMID);

prompt
prompt Creating table F_FIRMFUNDS
prompt ==========================
prompt
create table F_FIRMFUNDS
(
  firmid           VARCHAR2(32) not null,
  balance          NUMBER(15,2) default 0 not null,
  frozenfunds      NUMBER(15,2) default 0 not null,
  lastbalance      NUMBER(15,2) default 0 not null,
  lastwarranty     NUMBER(15,2) default 0 not null,
  settlemargin     NUMBER(15,2) default 0 not null,
  lastsettlemargin NUMBER(15,2) default 0 not null
)
;
comment on column F_FIRMFUNDS.firmid
  is '������ID';
comment on column F_FIRMFUNDS.balance
  is '�ʽ����';
comment on column F_FIRMFUNDS.frozenfunds
  is '�����ʽ�';
comment on column F_FIRMFUNDS.lastbalance
  is '����������';
comment on column F_FIRMFUNDS.lastwarranty
  is '������㵣����';
comment on column F_FIRMFUNDS.settlemargin
  is '���ձ�֤��';
comment on column F_FIRMFUNDS.lastsettlemargin
  is '���ս��ձ�֤��';
alter table F_FIRMFUNDS
  add constraint PK_F_FIRMFUNDS primary key (FIRMID);

prompt
prompt Creating table F_FIRMRIGHTSCOMPUTEFUNDS
prompt =======================================
prompt
create table F_FIRMRIGHTSCOMPUTEFUNDS
(
  b_date      DATE not null,
  firmid      VARCHAR2(32) not null,
  code        VARCHAR2(16) not null,
  lastbalance NUMBER(15,2) default 0 not null,
  balance     NUMBER(15,2) default 0 not null
)
;
alter table F_FIRMRIGHTSCOMPUTEFUNDS
  add constraint PK_F_FIRMRIGHTSCOMPUTEFUNDS primary key (B_DATE, FIRMID, CODE);

prompt
prompt Creating table F_FROZENFUNDFLOW
prompt ===============================
prompt
create table F_FROZENFUNDFLOW
(
  fundflowid NUMBER(10) not null,
  firmid     VARCHAR2(32) not null,
  amount     NUMBER(15,2) default 0 not null,
  moduleid   CHAR(2) not null,
  createtime DATE not null
)
;
comment on column F_FROZENFUNDFLOW.moduleid
  is '10�ۺϹ���ƽ̨
11����ϵͳ
13�ֵ�����ϵͳ
14����ϵͳ
15��������
18Ͷ���������Ʒ����ϵͳ
20�����̽���ϵͳ
21����ϵͳ
22���н��뼰����ϵͳ
23E�ֻ�';
comment on column F_FROZENFUNDFLOW.createtime
  is '����ʱ��';
alter table F_FROZENFUNDFLOW
  add constraint PK_FROZENFUNDFLOW primary key (FUNDFLOWID);

prompt
prompt Creating table F_FROZENFUNDS
prompt ============================
prompt
create table F_FROZENFUNDS
(
  moduleid    CHAR(2) not null,
  firmid      VARCHAR2(32) not null,
  frozenfunds NUMBER(15,2) not null
)
;
comment on table F_FROZENFUNDS
  is '��������ĳ��ģ�鶳����ʽ��';
comment on column F_FROZENFUNDS.moduleid
  is '10�ۺϹ���ƽ̨
11����ϵͳ
13�ֵ�����ϵͳ
14����ϵͳ
15��������
18Ͷ���������Ʒ����ϵͳ
20�����̽���ϵͳ
21����ϵͳ
22���н��뼰����ϵͳ
23E�ֻ�';
comment on column F_FROZENFUNDS.firmid
  is '������';
comment on column F_FROZENFUNDS.frozenfunds
  is '�����ʽ�';
alter table F_FROZENFUNDS
  add constraint PK_F_FROZENFUNDS primary key (MODULEID, FIRMID);

prompt
prompt Creating table F_FUNDFLOW
prompt =========================
prompt
create table F_FUNDFLOW
(
  fundflowid   NUMBER(10) not null,
  firmid       VARCHAR2(32) not null,
  oprcode      CHAR(5) not null,
  contractno   VARCHAR2(16),
  commodityid  VARCHAR2(16),
  amount       NUMBER(15,2) default 0 not null,
  balance      NUMBER(15,2) default 0 not null,
  appendamount NUMBER(15,2),
  voucherno    NUMBER(10),
  createtime   DATE not null,
  b_date       DATE
)
;
comment on column F_FUNDFLOW.createtime
  is '����ʱ��';
alter table F_FUNDFLOW
  add constraint PK_F_FUNDFLOW primary key (FUNDFLOWID);

prompt
prompt Creating table F_H_FROZENFUNDFLOW
prompt =================================
prompt
create table F_H_FROZENFUNDFLOW
(
  fundflowid NUMBER(10) not null,
  firmid     VARCHAR2(32) not null,
  amount     NUMBER(15,2) default 0 not null,
  moduleid   CHAR(2) not null,
  createtime DATE not null
)
;
comment on column F_H_FROZENFUNDFLOW.moduleid
  is '10�ۺϹ���ƽ̨
11����ϵͳ
13�ֵ�����ϵͳ
14����ϵͳ
15��������
18Ͷ���������Ʒ����ϵͳ
20�����̽���ϵͳ
21����ϵͳ
22���н��뼰����ϵͳ
23E�ֻ�';
comment on column F_H_FROZENFUNDFLOW.createtime
  is '����ʱ��';
alter table F_H_FROZENFUNDFLOW
  add constraint PK_H_FROZENFUNDFLOW primary key (FUNDFLOWID);

prompt
prompt Creating table F_H_FUNDFLOW
prompt ===========================
prompt
create table F_H_FUNDFLOW
(
  fundflowid   NUMBER(10) not null,
  firmid       VARCHAR2(32) not null,
  oprcode      CHAR(5) not null,
  contractno   VARCHAR2(16),
  commodityid  VARCHAR2(16),
  amount       NUMBER(15,2) default 0 not null,
  balance      NUMBER(15,2) default 0 not null,
  appendamount NUMBER(15,2),
  voucherno    NUMBER(10) not null,
  createtime   DATE not null,
  b_date       DATE not null
)
;
comment on column F_H_FUNDFLOW.balance
  is '��ǰ�ʻ��ʽ��������Ǹ�����';
comment on column F_H_FUNDFLOW.createtime
  is '����ʱ��';
alter table F_H_FUNDFLOW
  add constraint PK_F_H_FUNDFLOW primary key (FUNDFLOWID);

prompt
prompt Creating table F_LEDGERFIELD
prompt ============================
prompt
create table F_LEDGERFIELD
(
  code      VARCHAR2(16) not null,
  name      VARCHAR2(32) not null,
  fieldsign NUMBER(1) not null,
  moduleid  CHAR(2) not null,
  ordernum  NUMBER(5) not null,
  isinit    CHAR(1) default 'Y' not null
)
;
comment on column F_LEDGERFIELD.code
  is '�����ֶδ���';
comment on column F_LEDGERFIELD.name
  is '�����ֶ�����';
comment on column F_LEDGERFIELD.fieldsign
  is '1������ -1������';
comment on column F_LEDGERFIELD.moduleid
  is '10�ۺϹ���ƽ̨
11����ϵͳ
13�ֵ�����ϵͳ
14����ϵͳ
15��������
18Ͷ���������Ʒ����ϵͳ
20�����̽���ϵͳ
21����ϵͳ
22���н��뼰����ϵͳ
23E�ֻ�';
comment on column F_LEDGERFIELD.ordernum
  is '�����,ǰ��λģ��ź���λ�����
';
comment on column F_LEDGERFIELD.isinit
  is 'Y:�ǳ�ʼ������,ҳ�治����ɾ�����޸�
N:���ǳ�ʼ������';
alter table F_LEDGERFIELD
  add constraint PK_F_LEDGERFIELD primary key (CODE);

prompt
prompt Creating table F_LOG
prompt ====================
prompt
create table F_LOG
(
  occurtime   DATE not null,
  type        VARCHAR2(8) not null,
  userid      VARCHAR2(16) not null,
  description VARCHAR2(128) not null
)
;
comment on table F_LOG
  is '������־��';
comment on column F_LOG.type
  is 'info����Ϣ
alert������
error������
sysinfo��ϵͳ��Ϣ';

prompt
prompt Creating table F_SUMMARY
prompt ========================
prompt
create table F_SUMMARY
(
  summaryno      CHAR(5) not null,
  summary        VARCHAR2(32) not null,
  ledgeritem     VARCHAR2(16),
  funddcflag     CHAR(1) default 'N' not null,
  accountcodeopp VARCHAR2(16),
  appendaccount  CHAR(1) default 'N' not null,
  isinit         CHAR(1) default 'Y' not null
)
;
comment on column F_SUMMARY.summaryno
  is 'ժҪ��';
comment on column F_SUMMARY.summary
  is 'ժҪ����';
comment on column F_SUMMARY.ledgeritem
  is '��������';
comment on column F_SUMMARY.funddcflag
  is '��ƾ֤����漰�������ʽ������ʽ�Ǵ��� C�������ʽ�ǽ跽 D��
���漰�������ʽ�N';
comment on column F_SUMMARY.accountcodeopp
  is '�Է���Ŀ���룬���ڵ���ƾ֤';
comment on column F_SUMMARY.appendaccount
  is '�����˵�,�����ʽ����䶯�⣬���и��ӵĲ����˻��䶯��
T����ֵ˰ Tax
W�������� Warranty
S�����ձ�֤�� SettleMargin
N���޸���';
comment on column F_SUMMARY.isinit
  is 'Y:�ǳ�ʼ������,ҳ�治����ɾ�����޸�
N:���ǳ�ʼ������';
alter table F_SUMMARY
  add primary key (SUMMARYNO);

prompt
prompt Creating table F_SYSTEMSTATUS
prompt =============================
prompt
create table F_SYSTEMSTATUS
(
  b_date    DATE not null,
  status    NUMBER(2) not null,
  note      VARCHAR2(256),
  cleartime DATE,
  isclear   NUMBER(2) default 0 not null
)
;
comment on column F_SYSTEMSTATUS.status
  is '0:δ����״̬
1:������
2:�������';
alter table F_SYSTEMSTATUS
  add constraint PK_F_SYSTEMSTATUS primary key (B_DATE);

prompt
prompt Creating table F_VOUCHER
prompt ========================
prompt
create table F_VOUCHER
(
  voucherno  NUMBER(10) not null,
  b_date     DATE,
  summaryno  CHAR(5) not null,
  summary    VARCHAR2(32),
  note       VARCHAR2(128),
  inputuser  VARCHAR2(16) not null,
  inputtime  TIMESTAMP(6),
  auditor    VARCHAR2(16),
  audittime  TIMESTAMP(6),
  auditnote  VARCHAR2(128),
  status     VARCHAR2(16),
  contractno VARCHAR2(16),
  fundflowid NUMBER(10)
)
;
comment on column F_VOUCHER.status
  is 'editing   �༭״̬
auditing  �����
audited   �����
accounted �Ѽ���';
create index IX_F_VOUCHER_CONTRACTNO on F_VOUCHER (CONTRACTNO);
create index IX_F_VOUCHER_STATUS on F_VOUCHER (STATUS);
create unique index UK_F_VOUCHER on F_VOUCHER (FUNDFLOWID);
alter table F_VOUCHER
  add constraint PK_F_VOUCHER primary key (VOUCHERNO);

prompt
prompt Creating table F_VOUCHERENTRY
prompt =============================
prompt
create table F_VOUCHERENTRY
(
  entryid      NUMBER(10) not null,
  entrysummary VARCHAR2(32),
  voucherno    NUMBER(10) not null,
  accountcode  VARCHAR2(38) not null,
  debitamount  NUMBER(15,2) not null,
  creditamount NUMBER(15,2) not null
)
;
create index IX_F_VOUCHERENTRY on F_VOUCHERENTRY (VOUCHERNO);
alter table F_VOUCHERENTRY
  add constraint PK_F_VOUCHERENTRY primary key (ENTRYID);

prompt
prompt Creating table F_VOUCHERMODEL
prompt =============================
prompt
create table F_VOUCHERMODEL
(
  code           VARCHAR2(16) not null,
  name           VARCHAR2(64),
  summaryno      CHAR(5) not null,
  debitcode      VARCHAR2(38) not null,
  creditcode     VARCHAR2(38) not null,
  needcontractno CHAR(1) not null,
  note           VARCHAR2(128)
)
;
comment on table F_VOUCHERMODEL
  is '���ڿ�ݴ����ֹ�ƾ֤��ģ��';
alter table F_VOUCHERMODEL
  add constraint PK_F_VOUCHERMODEL primary key (CODE);

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
  delivery_id      VARCHAR2(32) not null,
  delivery_method  VARCHAR2(32),
  apply_date       DATE,
  insurance        NUMBER(12,2),
  trustee_fee      NUMBER(12,2),
  warehousing_fee  NUMBER(12,2),
  delivery_fee     NUMBER(12,2),
  registration_fee NUMBER(12,2),
  cancellation_fee NUMBER(12,2)
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
comment on column IPO_DELIVERY_COST.registration_fee
  is 'ע���';
comment on column IPO_DELIVERY_COST.cancellation_fee
  is 'ע����';
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
  id            NUMBER not null,
  userid        VARCHAR2(32) not null,
  commodityname VARCHAR2(32) not null,
  startnumber   NUMBER,
  pcounts       NUMBER(8),
  ptime         TIMESTAMP(6),
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
  trademoney       NUMBER(15,2),
  order_id         VARCHAR2(32)
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
comment on column IPO_FIRMREWARDDEAIL.order_id
  is '��������';
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
comment on table IPO_NUMBEROFRECORDS
  is '��¼��ű�';
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
  unfreezefees     NUMBER(15,2),
  successcounts    NUMBER(8)
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
comment on column IPO_ORDER.successcounts
  is '��ǩ����';
alter table IPO_ORDER
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
prompt Creating table IPO_PUBLISHER_POSITION
prompt =====================================
prompt
create table IPO_PUBLISHER_POSITION
(
  positionid     NUMBER not null,
  publisherid    VARCHAR2(32),
  commodityid    VARCHAR2(32),
  totalvalue     NUMBER(32,2),
  pubposition    NUMBER(16),
  salecounts     NUMBER(16),
  totalcounts    NUMBER(16),
  status         NUMBER(1),
  creater        VARCHAR2(32),
  createdate     DATE,
  updater        VARCHAR2(32),
  updatedate     DATE,
  storageid      VARCHAR2(32),
  subscricounts  NUMBER(16),
  subscriberatio NUMBER(10,2)
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
comment on column IPO_PUBLISHER_POSITION.subscriberatio
  is '�������Ϲ��Żݱ���';
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
prompt Creating table IPO_RF_FIRMHOLDSUM
prompt =================================
prompt
create table IPO_RF_FIRMHOLDSUM
(
  cleardate    DATE not null,
  firmid       VARCHAR2(32) not null,
  commodityid  VARCHAR2(16) not null,
  bs_flag      NUMBER(2) not null,
  holdqty      NUMBER(10) not null,
  holdfunds    NUMBER(15,2) not null,
  floatingloss NUMBER(15,2) not null,
  evenprice    NUMBER(16,6) not null,
  holdmargin   NUMBER(15,2) default 0 not null,
  gageqty      NUMBER(10) default 0 not null,
  holdassure   NUMBER(15,2) default 0 not null
)
;
comment on table IPO_RF_FIRMHOLDSUM
  is '�ֱֲ���ÿ����ʷ��';
comment on column IPO_RF_FIRMHOLDSUM.cleardate
  is '����ʱ��';
comment on column IPO_RF_FIRMHOLDSUM.firmid
  is '������id';
comment on column IPO_RF_FIRMHOLDSUM.commodityid
  is '��Ʒid';
comment on column IPO_RF_FIRMHOLDSUM.bs_flag
  is '������־';
comment on column IPO_RF_FIRMHOLDSUM.holdqty
  is '�ֲ���';
comment on column IPO_RF_FIRMHOLDSUM.holdfunds
  is '�ֲֽ��';
comment on column IPO_RF_FIRMHOLDSUM.floatingloss
  is '����ӯ��';
comment on column IPO_RF_FIRMHOLDSUM.evenprice
  is '�ֲ־���';
comment on column IPO_RF_FIRMHOLDSUM.holdmargin
  is '��֤��';
comment on column IPO_RF_FIRMHOLDSUM.gageqty
  is '�ֶ�����';
comment on column IPO_RF_FIRMHOLDSUM.holdassure
  is '�ֲֵ�����';
alter table IPO_RF_FIRMHOLDSUM
  add constraint PK_IPO_RF_FIRMHOLDSUM primary key (CLEARDATE, FIRMID, COMMODITYID, BS_FLAG);

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
  rationcounts          NUMBER(12),
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
prompt Creating table IPO_STOCK_FREEZE
prompt ===============================
prompt
create table IPO_STOCK_FREEZE
(
  application_id NUMBER not null,
  commodityid    NVARCHAR2(16) not null,
  customerid     NVARCHAR2(40) not null,
  state          NUMBER(3) default 0 not null,
  freeze_number  NUMBER not null,
  createtime     DATE not null,
  reviewtime     DATE,
  operator       NVARCHAR2(40),
  freezereason   VARCHAR2(255) not null
)
;
comment on column IPO_STOCK_FREEZE.application_id
  is '������';
comment on column IPO_STOCK_FREEZE.commodityid
  is '��Ʒ����';
comment on column IPO_STOCK_FREEZE.customerid
  is '������ID';
comment on column IPO_STOCK_FREEZE.state
  is '״̬';
comment on column IPO_STOCK_FREEZE.freeze_number
  is '��������';
comment on column IPO_STOCK_FREEZE.createtime
  is '����ʱ��';
comment on column IPO_STOCK_FREEZE.reviewtime
  is '����ʱ��';
comment on column IPO_STOCK_FREEZE.operator
  is '������';
alter table IPO_STOCK_FREEZE
  add constraint PK_IPO_STOCK_FREEZE primary key (APPLICATION_ID);

prompt
prompt Creating table IPO_STOCK_TRANSFERRECORDS
prompt ========================================
prompt
create table IPO_STOCK_TRANSFERRECORDS
(
  application_id    NUMBER not null,
  commodityid       NVARCHAR2(16) not null,
  customerid_apply  NVARCHAR2(40) not null,
  customerid_accept NVARCHAR2(40) not null,
  transfer_number   NUMBER not null,
  state             NUMBER(3) default 0 not null,
  remarks           NVARCHAR2(40),
  createtime        DATE not null,
  reviewtime        DATE,
  operator          NVARCHAR2(40)
)
;
comment on column IPO_STOCK_TRANSFERRECORDS.application_id
  is '������';
comment on column IPO_STOCK_TRANSFERRECORDS.commodityid
  is '��Ʒ����';
comment on column IPO_STOCK_TRANSFERRECORDS.customerid_apply
  is '��������������̴���';
comment on column IPO_STOCK_TRANSFERRECORDS.customerid_accept
  is '���ܹ����������̴���';
comment on column IPO_STOCK_TRANSFERRECORDS.transfer_number
  is '��������';
comment on column IPO_STOCK_TRANSFERRECORDS.state
  is '״̬';
comment on column IPO_STOCK_TRANSFERRECORDS.remarks
  is '��ע';
comment on column IPO_STOCK_TRANSFERRECORDS.createtime
  is '����ʱ��';
comment on column IPO_STOCK_TRANSFERRECORDS.reviewtime
  is '���ʱ��';
comment on column IPO_STOCK_TRANSFERRECORDS.operator
  is '������';
alter table IPO_STOCK_TRANSFERRECORDS
  add constraint PK_IPO_STOCK_TRANSFERRECORDS primary key (APPLICATION_ID);

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
  amount      NUMBER(16,2),
  remark      VARCHAR2(200),
  create_user VARCHAR2(32),
  create_date DATE,
  update_user VARCHAR2(32),
  update_date DATE,
  brokerid    VARCHAR2(32)
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
comment on column IPO_UNDERWRITER_DEPOSIT.create_user
  is '������';
comment on column IPO_UNDERWRITER_DEPOSIT.create_date
  is '����ʱ��';
comment on column IPO_UNDERWRITER_DEPOSIT.update_user
  is '�޸���';
comment on column IPO_UNDERWRITER_DEPOSIT.update_date
  is '�޸�ʱ��';
comment on column IPO_UNDERWRITER_DEPOSIT.brokerid
  is '������Ա���';
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
  subscribeprice  NUMBER(15,2),
  state           NUMBER(1) not null
)
;
comment on column IPO_UNDERWRITER_SUBSCRIBE.subscribeid
  is '����,seq_ipo_underwriter_sub';
comment on column IPO_UNDERWRITER_SUBSCRIBE.underwriterid
  is '������ԱID';
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
comment on column IPO_UNDERWRITER_SUBSCRIBE.state
  is '����״̬��1��δ���� 2���Ѵ���';
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

prompt
prompt Creating table L_AUCONFIG
prompt =========================
prompt
create table L_AUCONFIG
(
  configid    NUMBER(6) not null,
  hostip      VARCHAR2(20),
  port        NUMBER(6) not null,
  dataport    NUMBER(6),
  servicename VARCHAR2(32) not null,
  logonmode   NUMBER(2) default 1 not null,
  sysname     VARCHAR2(32) not null
)
;
comment on column L_AUCONFIG.logonmode
  is '1 ����;2 ������';
comment on column L_AUCONFIG.sysname
  is 'ǰ̨��front
��̨��mgr
�ֿ�ˣ�warehouse
��Ա�ˣ�broker';
alter table L_AUCONFIG
  add constraint PK_L_AUCONFIG primary key (CONFIGID);

prompt
prompt Creating table L_DICTIONARY
prompt ===========================
prompt
create table L_DICTIONARY
(
  key   VARCHAR2(32) not null,
  name  VARCHAR2(128),
  value VARCHAR2(64) not null,
  note  VARCHAR2(1924)
)
;
alter table L_DICTIONARY
  add constraint PK_L_DICTIONARY primary key (KEY);

prompt
prompt Creating table L_MODULEANDAU
prompt ============================
prompt
create table L_MODULEANDAU
(
  moduleid NUMBER(2) not null,
  configid NUMBER(6) not null
)
;
alter table L_MODULEANDAU
  add primary key (MODULEID, CONFIGID);

prompt
prompt Creating table M_AGENTTRADER
prompt ============================
prompt
create table M_AGENTTRADER
(
  agenttraderid VARCHAR2(40) not null,
  name          VARCHAR2(16),
  password      VARCHAR2(64) not null,
  type          NUMBER(2) default 0 not null,
  status        NUMBER(2) default 0 not null,
  operatefirm   CLOB,
  createtime    DATE default sysdate,
  modifytime    DATE
)
;
comment on table M_AGENTTRADER
  is '��Ϊί��Ա��';
comment on column M_AGENTTRADER.type
  is '0 ��Ϊί��Ա
1 ǿƽԱ';
comment on column M_AGENTTRADER.status
  is '0 ����
1 ��ֹ��½';
comment on column M_AGENTTRADER.operatefirm
  is '�ձ�ʾ����
���������ö��ŷָ����� 0001,0002,0003';
comment on column M_AGENTTRADER.modifytime
  is '���һ���޸�ʱ��';
alter table M_AGENTTRADER
  add constraint PK_M_CONSIGNER primary key (AGENTTRADERID);

prompt
prompt Creating table M_BREED
prompt ======================
prompt
create table M_BREED
(
  breedid      NUMBER(10) not null,
  breedname    VARCHAR2(32) not null,
  unit         VARCHAR2(16) not null,
  trademode    NUMBER(1) default 1 not null,
  categoryid   NUMBER(10) not null,
  status       NUMBER(1) default 1,
  picture      BLOB,
  belongmodule VARCHAR2(30),
  sortno       NUMBER(10)
)
;
comment on column M_BREED.trademode
  is '����ģʽ 1�����ű��Ͻ�ģʽ 2����֤��ģʽ';
comment on column M_BREED.status
  is '1������ 2����ɾ��';
comment on column M_BREED.belongmodule
  is '��������ģ�� ��|�ָ�';
alter table M_BREED
  add constraint PK_M_BREED primary key (BREEDID);

prompt
prompt Creating table M_BREEDPROPS
prompt ===========================
prompt
create table M_BREEDPROPS
(
  breedid       NUMBER(10) not null,
  propertyid    NUMBER(10) not null,
  propertyvalue VARCHAR2(64) not null,
  sortno        NUMBER(10) not null
)
;
comment on table M_BREEDPROPS
  is 'Ʒ����Ӧ������ֵ�б�����Щ����������Ʒ�������Ա�
';
alter table M_BREEDPROPS
  add constraint PK_M_BREEDPROPS primary key (BREEDID, PROPERTYID, PROPERTYVALUE);

prompt
prompt Creating table M_CATEGORY
prompt =========================
prompt
create table M_CATEGORY
(
  categoryid       NUMBER(10) not null,
  categoryname     VARCHAR2(64) not null,
  note             VARCHAR2(256),
  type             VARCHAR2(64) not null,
  sortno           NUMBER(10) not null,
  parentcategoryid NUMBER(10),
  status           NUMBER(1) default 1,
  isoffset         CHAR(1) default 'Y' not null,
  offsetrate       NUMBER(5,4) default 0.05 not null,
  belongmodule     VARCHAR2(30)
)
;
comment on column M_CATEGORY.type
  is 'breed��Ʒ��
category������
leaf��Ҷ�ӽڵ�';
comment on column M_CATEGORY.status
  is '1������ 2����ɾ��';
comment on column M_CATEGORY.isoffset
  is 'Y:��Ʒ�ֿ��ܳ������� N:��Ʒ�ֲ����ܳ�������';
comment on column M_CATEGORY.offsetrate
  is '����������ֱ�<1';
comment on column M_CATEGORY.belongmodule
  is '��������ģ�� ��|�ָ�';
alter table M_CATEGORY
  add constraint PK_M_CATEGORY primary key (CATEGORYID);

prompt
prompt Creating table M_CERTIFICATETYPE
prompt ================================
prompt
create table M_CERTIFICATETYPE
(
  code      NUMBER(2) not null,
  name      VARCHAR2(32) not null,
  isvisibal CHAR(1) default 'Y' not null,
  sortno    NUMBER(2) default 0 not null
)
;
comment on column M_CERTIFICATETYPE.isvisibal
  is 'Y ��ʾ N ����ʾ';
alter table M_CERTIFICATETYPE
  add constraint PK_M_CERTIFICATETYPE primary key (CODE);

prompt
prompt Creating table M_ERRORLOGINLOG
prompt ==============================
prompt
create table M_ERRORLOGINLOG
(
  traderid  VARCHAR2(40) not null,
  logindate DATE not null,
  moduleid  NUMBER(2) not null,
  ip        VARCHAR2(32) not null
)
;
comment on column M_ERRORLOGINLOG.moduleid
  is '10�ۺϹ���ƽ̨
11����ϵͳ
12��ֿܲ����ϵͳ
13�ֵ�����ϵͳ
14����ϵͳ
15��������
18Ͷ���������Ʒ����ϵͳ
19���˻�Ա����ϵͳ
20�����̽���ϵͳ
21����ϵͳ
22���н��뼰����ϵͳ
23E�ֻ�
24�����¼ϵͳ
25ʵʱ�������ϵͳ
26���׿ͻ���
98demoϵͳ
99����ϵͳ';

prompt
prompt Creating table M_FIRM
prompt =====================
prompt
create table M_FIRM
(
  firmid                  VARCHAR2(32) not null,
  name                    VARCHAR2(32) not null,
  fullname                VARCHAR2(128),
  type                    NUMBER(2) not null,
  contactman              VARCHAR2(32) not null,
  certificatetype         NUMBER(2) not null,
  certificateno           VARCHAR2(32) not null,
  phone                   VARCHAR2(32),
  mobile                  NUMBER(12) not null,
  fax                     VARCHAR2(16),
  address                 VARCHAR2(128),
  postcode                VARCHAR2(16),
  email                   VARCHAR2(64),
  zonecode                VARCHAR2(16) default 'none',
  industrycode            VARCHAR2(16) default 'none',
  firmcategoryid          NUMBER(10) default -1 not null,
  organizationcode        VARCHAR2(9),
  corporaterepresentative VARCHAR2(32),
  note                    VARCHAR2(1024),
  extenddata              VARCHAR2(4000),
  createtime              DATE default sysdate not null,
  modifytime              DATE,
  status                  CHAR(1) default 'N' not null,
  applyid                 NUMBER(10)
)
;
comment on column M_FIRM.type
  is '1������
2������
3������';
comment on column M_FIRM.firmcategoryid
  is '-1 ��ʾδ����';
comment on column M_FIRM.status
  is 'N������ Normal
D������ Disable
E��ע�� Erase';
alter table M_FIRM
  add constraint PK_M_FIRM primary key (FIRMID);

prompt
prompt Creating table M_FIRMCATEGORY
prompt =============================
prompt
create table M_FIRMCATEGORY
(
  id        NUMBER(10) not null,
  name      VARCHAR2(128) default 'δ����' not null,
  note      VARCHAR2(128),
  isvisibal CHAR(1) default 'Y' not null,
  sortno    NUMBER(2) default 0 not null
)
;
comment on column M_FIRMCATEGORY.isvisibal
  is 'Y ��ʾ N ����ʾ';
alter table M_FIRMCATEGORY
  add constraint PK_M_FIRMCATEGORY primary key (ID);

prompt
prompt Creating table M_FIRMMODULE
prompt ===========================
prompt
create table M_FIRMMODULE
(
  moduleid NUMBER(2) not null,
  firmid   VARCHAR2(32) not null,
  enabled  CHAR(1) default 'N' not null
)
;
comment on table M_FIRMMODULE
  is '�������ڸ�������ģ���Ƿ����';
comment on column M_FIRMMODULE.moduleid
  is '10�ۺϹ���ƽ̨
11����ϵͳ
12��ֿܲ����ϵͳ
13�ֵ�����ϵͳ
14����ϵͳ
15��������
18Ͷ���������Ʒ����ϵͳ
19���˻�Ա����ϵͳ
20�����̽���ϵͳ
21����ϵͳ
22���н��뼰����ϵͳ
23E�ֻ�
24�����¼ϵͳ
25ʵʱ�������ϵͳ
26���׿ͻ���
98demoϵͳ
99����ϵͳ';
comment on column M_FIRMMODULE.enabled
  is 'Y������  N������';
alter table M_FIRMMODULE
  add constraint PK_M_FIRMMODULE primary key (MODULEID, FIRMID);

prompt
prompt Creating table M_FIRM_APPLY
prompt ===========================
prompt
create table M_FIRM_APPLY
(
  applyid                 NUMBER(10) not null,
  userid                  VARCHAR2(32) not null,
  password                VARCHAR2(32),
  name                    VARCHAR2(32) not null,
  fullname                VARCHAR2(128),
  type                    NUMBER(2),
  contactman              VARCHAR2(32),
  certificatetype         NUMBER(2),
  certificateno           VARCHAR2(32),
  phone                   VARCHAR2(32),
  mobile                  NUMBER(12),
  fax                     VARCHAR2(16),
  address                 VARCHAR2(128),
  postcode                VARCHAR2(16),
  email                   VARCHAR2(64),
  zonecode                VARCHAR2(16) default 'none',
  industrycode            VARCHAR2(16) default 'none',
  organizationcode        VARCHAR2(9),
  corporaterepresentative VARCHAR2(32),
  note                    VARCHAR2(1024),
  extenddata              VARCHAR2(4000),
  createtime              DATE default sysdate not null,
  modifytime              DATE,
  status                  NUMBER(1) default 0 not null,
  auditnote               VARCHAR2(256),
  brokerid                VARCHAR2(32),
  picture                 BLOB,
  picturecs               BLOB,
  pictureos               BLOB,
  yingyepic               BLOB,
  shuiwupic               BLOB,
  zuzhipic                BLOB,
  kaihupic                BLOB
)
;
comment on column M_FIRM_APPLY.type
  is '1������
2������
3������';
comment on column M_FIRM_APPLY.status
  is '0�������
1�����ͨ��
2����˲�ͨ��';
alter table M_FIRM_APPLY
  add constraint PK_M_FIRM_APPLY primary key (APPLYID);

prompt
prompt Creating table M_INDUSTRY
prompt =========================
prompt
create table M_INDUSTRY
(
  code      VARCHAR2(16) not null,
  name      VARCHAR2(32) not null,
  isvisibal CHAR(1) default 'Y' not null,
  sortno    NUMBER(2) default 0 not null
)
;
comment on column M_INDUSTRY.isvisibal
  is 'Y ��ʾ N ����ʾ';
alter table M_INDUSTRY
  add constraint PK_M_INDUSTRY primary key (CODE);

prompt
prompt Creating table M_MESSAGE
prompt ========================
prompt
create table M_MESSAGE
(
  messageid    NUMBER(10) not null,
  message      VARCHAR2(256) not null,
  recievertype NUMBER(2) not null,
  traderid     VARCHAR2(40),
  createtime   DATE,
  userid       VARCHAR2(32) not null
)
;
comment on column M_MESSAGE.recievertype
  is '���������ͣ�1 ���߽���Ա 2 ���߹���Ա 3 �����û� 4 ָ������Ա 5 ָ������Ա';
comment on column M_MESSAGE.userid
  is '����ԱId';
alter table M_MESSAGE
  add constraint PK_M_MESSAGE primary key (MESSAGEID);

prompt
prompt Creating table M_NOTICE
prompt =======================
prompt
create table M_NOTICE
(
  noticeid   NUMBER(10) not null,
  title      VARCHAR2(64) not null,
  content    VARCHAR2(4000),
  createtime DATE,
  userid     VARCHAR2(32) not null
)
;
comment on column M_NOTICE.userid
  is '����ԱId';
alter table M_NOTICE
  add constraint PK_M_NOTICE primary key (NOTICEID);

prompt
prompt Creating table M_PROCEDURES_ERRORCODE
prompt =====================================
prompt
create table M_PROCEDURES_ERRORCODE
(
  moduleid  NUMBER(2) not null,
  errorcode NUMBER(12) not null,
  errorinfo VARCHAR2(1024)
)
;
comment on table M_PROCEDURES_ERRORCODE
  is '����������޸�ɾ���洢�Ĵ������¼';
comment on column M_PROCEDURES_ERRORCODE.moduleid
  is '10�ۺϹ���ƽ̨
11����ϵͳ
12��ֿܲ����ϵͳ
13�ֵ�����ϵͳ
14����ϵͳ
15��������
18Ͷ���������Ʒ����ϵͳ
19���˻�Ա����ϵͳ
20�����̽���ϵͳ
21����ϵͳ
22���н��뼰����ϵͳ
23E�ֻ�
24�����¼ϵͳ
25ʵʱ�������ϵͳ
26���׿ͻ���
98demoϵͳ
99����ϵͳ';
alter table M_PROCEDURES_ERRORCODE
  add constraint PK_M_TRADERMODULE_1 primary key (MODULEID, ERRORCODE);

prompt
prompt Creating table M_PROPERTY
prompt =========================
prompt
create table M_PROPERTY
(
  propertyid     NUMBER(10) not null,
  categoryid     NUMBER(10) not null,
  propertyname   VARCHAR2(64) not null,
  hasvaluedict   CHAR(1) not null,
  stockcheck     CHAR(1) not null,
  searchable     CHAR(1) not null,
  sortno         NUMBER(10) not null,
  isnecessary    CHAR(1) default 'Y' not null,
  fieldtype      NUMBER(2) default 0 not null,
  propertytypeid NUMBER(15) not null
)
;
comment on column M_PROPERTY.hasvaluedict
  is 'Y����ֵ�ֵ�  N����ֵ�ֵ�';
comment on column M_PROPERTY.stockcheck
  is 'Y�����  N������� M������ȫ���(ѡ����ֵ��ƥ������֮һ)';
comment on column M_PROPERTY.searchable
  is 'Y�������б����� N������������';
comment on column M_PROPERTY.isnecessary
  is 'Y�������N��ѡ����';
comment on column M_PROPERTY.fieldtype
  is '0���ַ�����1������';
create index UK_M_PROPERTY on M_PROPERTY (CATEGORYID, PROPERTYNAME);
alter table M_PROPERTY
  add constraint PK_M_PROPERTY primary key (PROPERTYID);

prompt
prompt Creating table M_PROPERTYTYPE
prompt =============================
prompt
create table M_PROPERTYTYPE
(
  propertytypeid NUMBER(15) not null,
  name           VARCHAR2(64) not null,
  status         NUMBER(2) default 0 not null,
  sortno         NUMBER(2) not null
)
;
comment on column M_PROPERTYTYPE.status
  is '0 �ɼ� 1 ���ɼ�';
alter table M_PROPERTYTYPE
  add constraint PK_M_PROPERTYTYPE primary key (PROPERTYTYPEID);

prompt
prompt Creating table M_SYSTEMPROPS
prompt ============================
prompt
create table M_SYSTEMPROPS
(
  key          VARCHAR2(32) not null,
  value        VARCHAR2(64) not null,
  runtimevalue VARCHAR2(64),
  note         VARCHAR2(128),
  firmidlength VARCHAR2(32) default '15' not null
)
;
comment on column M_SYSTEMPROPS.value
  is '�����ѡ���֤��Ȳ�������';
alter table M_SYSTEMPROPS
  add constraint PK_M_SYSTEMPROPS primary key (KEY);

prompt
prompt Creating table M_TRADER
prompt =======================
prompt
create table M_TRADER
(
  traderid       VARCHAR2(40) not null,
  firmid         VARCHAR2(32) not null,
  name           VARCHAR2(32) not null,
  userid         VARCHAR2(32),
  password       VARCHAR2(32) not null,
  forcechangepwd NUMBER(1) default 1 not null,
  status         CHAR(1) default 'N' not null,
  type           CHAR(1) not null,
  createtime     DATE default sysdate,
  modifytime     DATE,
  keycode        VARCHAR2(32),
  enablekey      CHAR(1) not null,
  trustkey       VARCHAR2(64),
  lastip         VARCHAR2(16),
  lasttime       DATE,
  skin           VARCHAR2(16) default 'default' not null
)
;
comment on table M_TRADER
  is '����Ա��ÿ���������и��뽻����ID��ͬ�Ľ���Ա��ΪĬ�Ͻ���Ա������ɾ����';
comment on column M_TRADER.forcechangepwd
  is '0����
1����';
comment on column M_TRADER.status
  is 'N������ Normal
D������ Disable';
comment on column M_TRADER.type
  is 'A������Ա
N��һ�㽻��Ա';
comment on column M_TRADER.modifytime
  is '���һ���޸�ʱ��';
comment on column M_TRADER.enablekey
  is 'Y������
N��������';
comment on column M_TRADER.trustkey
  is '�ͻ��˵�¼�ɹ����ڱ��غͷ���˼�¼һ������Key�����������Դ�����';
alter table M_TRADER
  add constraint PK_M_TRADER primary key (TRADERID);

prompt
prompt Creating table M_TRADERMODULE
prompt =============================
prompt
create table M_TRADERMODULE
(
  moduleid NUMBER(2) not null,
  traderid VARCHAR2(40) not null,
  enabled  CHAR(1) default 'N' not null
)
;
comment on table M_TRADERMODULE
  is '����Ա�ڸ�������ģ���Ƿ����';
comment on column M_TRADERMODULE.moduleid
  is '10�ۺϹ���ƽ̨
11����ϵͳ
12��ֿܲ����ϵͳ
13�ֵ�����ϵͳ
14����ϵͳ
15��������
18Ͷ���������Ʒ����ϵͳ
19���˻�Ա����ϵͳ
20�����̽���ϵͳ
21����ϵͳ
22���н��뼰����ϵͳ
23E�ֻ�
24�����¼ϵͳ
25ʵʱ�������ϵͳ
26���׿ͻ���
98demoϵͳ
99����ϵͳ';
comment on column M_TRADERMODULE.enabled
  is 'Y������  N������';
alter table M_TRADERMODULE
  add constraint PK_M_TRADERMODULE primary key (MODULEID, TRADERID);

prompt
prompt Creating table M_ZONE
prompt =====================
prompt
create table M_ZONE
(
  code      VARCHAR2(16) not null,
  name      VARCHAR2(32) not null,
  isvisibal CHAR(1) default 'Y' not null,
  sortno    NUMBER(2) default 0 not null
)
;
comment on column M_ZONE.isvisibal
  is 'Y ��ʾ N ����ʾ';
alter table M_ZONE
  add constraint PK_M_ZONE primary key (CODE);

prompt
prompt Creating table SYS_FIRM_PERMISSION
prompt ==================================
prompt
create table SYS_FIRM_PERMISSION
(
  id     NUMBER not null,
  firmid VARCHAR2(16),
  modeid VARCHAR2(16)
)
;
comment on table SYS_FIRM_PERMISSION
  is '�����̽���ϵͳȨ��';
comment on column SYS_FIRM_PERMISSION.firmid
  is '������id';
comment on column SYS_FIRM_PERMISSION.modeid
  is 'Ȩ��ϵͳ';
alter table SYS_FIRM_PERMISSION
  add constraint PK_SYS_FIRM_PERMISSION primary key (ID);

prompt
prompt Creating table S_OTC
prompt ====================
prompt
create table S_OTC
(
  settlementdata VARCHAR2(32),
  c_num          VARCHAR2(32),
  c_name         VARCHAR2(32),
  mechanism      VARCHAR2(32),
  juj            VARCHAR2(32),
  cust_account   VARCHAR2(32),
  customername   VARCHAR2(32),
  cust_jp        VARCHAR2(32),
  cust_cj        VARCHAR2(32),
  cust_wt        VARCHAR2(32),
  cust_cc        VARCHAR2(32),
  cust_cjtime    VARCHAR2(32),
  commodityname  VARCHAR2(32),
  cust_cjnum     VARCHAR2(32),
  cust_cjje      VARCHAR2(32),
  cust_sellfx    VARCHAR2(32),
  cust_jcj       VARCHAR2(32),
  cust_ccj       VARCHAR2(32),
  cust_pcj       VARCHAR2(32),
  cust_pcyk      VARCHAR2(32),
  cust_sjyk      VARCHAR2(32),
  cust_sxf       VARCHAR2(32),
  cjtype         VARCHAR2(32),
  cztype         VARCHAR2(32),
  czoptr         VARCHAR2(32)
)
;

prompt
prompt Creating table S_OTC2
prompt =====================
prompt
create table S_OTC2
(
  custname   VARCHAR2(32),
  cust_other VARCHAR2(32)
)
;

prompt
prompt Creating table S_OTCBY10
prompt ========================
prompt
create table S_OTCBY10
(
  custname   VARCHAR2(32),
  cust_other VARCHAR2(32)
)
;

prompt
prompt Creating table S_OTCBY100
prompt =========================
prompt
create table S_OTCBY100
(
  custname   VARCHAR2(32),
  cust_other VARCHAR2(32)
)
;

prompt
prompt Creating table S_OTCBY150
prompt =========================
prompt
create table S_OTCBY150
(
  custname   VARCHAR2(32),
  cust_other VARCHAR2(32)
)
;

prompt
prompt Creating table S_OTCBY50
prompt ========================
prompt
create table S_OTCBY50
(
  custname   VARCHAR2(32),
  cust_other VARCHAR2(32)
)
;

prompt
prompt Creating table S_OTCCSY10
prompt =========================
prompt
create table S_OTCCSY10
(
  custname   VARCHAR2(32),
  cust_other VARCHAR2(32)
)
;

prompt
prompt Creating table S_OTCCSY25
prompt =========================
prompt
create table S_OTCCSY25
(
  custname   VARCHAR2(32),
  cust_other VARCHAR2(32)
)
;

prompt
prompt Creating table S_OTCCSY50
prompt =========================
prompt
create table S_OTCCSY50
(
  custname   VARCHAR2(32),
  cust_other VARCHAR2(32)
)
;

prompt
prompt Creating table S_OTCN1000
prompt =========================
prompt
create table S_OTCN1000
(
  custname   VARCHAR2(32),
  cust_other VARCHAR2(32)
)
;

prompt
prompt Creating table S_OTCT1
prompt ======================
prompt
create table S_OTCT1
(
  custname   VARCHAR2(32),
  cust_other VARCHAR2(32)
)
;

prompt
prompt Creating table S_OTCT10
prompt =======================
prompt
create table S_OTCT10
(
  custname   VARCHAR2(32),
  cust_other VARCHAR2(32)
)
;

prompt
prompt Creating table S_OTCT5
prompt ======================
prompt
create table S_OTCT5
(
  custname   VARCHAR2(32),
  cust_other VARCHAR2(32)
)
;

prompt
prompt Creating table TM_TRADEMONITOR
prompt ==============================
prompt
create table TM_TRADEMONITOR
(
  id           NUMBER(15) not null,
  moduleid     NUMBER(2) not null,
  type         VARCHAR2(256) not null,
  num          NUMBER(15) not null,
  datetime     DATE not null,
  categorytype VARCHAR2(256)
)
;
alter table TM_TRADEMONITOR
  add constraint PK_TM_TRADEMONITOR primary key (ID);

prompt
prompt Creating table TM_TRADEMONITOR_H
prompt ================================
prompt
create table TM_TRADEMONITOR_H
(
  id           NUMBER(15) not null,
  moduleid     NUMBER(2) not null,
  type         VARCHAR2(256) not null,
  num          NUMBER(15) not null,
  datetime     DATE not null,
  categorytype VARCHAR2(256)
)
;
alter table TM_TRADEMONITOR_H
  add constraint PK_TM_TRADEMONITOR_H primary key (ID);

prompt
prompt Creating table T_APPLY
prompt ======================
prompt
create table T_APPLY
(
  id          NUMBER(10) not null,
  applytype   NUMBER(4) not null,
  status      NUMBER(4) not null,
  proposer    VARCHAR2(64) not null,
  applytime   DATE default sysdate not null,
  approver    VARCHAR2(64),
  approvetime DATE,
  content     SYS.XMLTYPE not null,
  note        VARCHAR2(1024)
)
;
alter table T_APPLY
  add constraint T_APPLY_PK primary key (ID);

prompt
prompt Creating table T_A_BREED
prompt ========================
prompt
create table T_A_BREED
(
  breedid               NUMBER(10) not null,
  breedname             VARCHAR2(32) not null,
  sortid                NUMBER(10) not null,
  contractfactor        NUMBER(12,2),
  minpricemove          NUMBER(10,2) not null,
  spreadalgr            NUMBER(1) not null,
  spreaduplmt           NUMBER(10,2) not null,
  spreaddownlmt         NUMBER(10,2) not null,
  feealgr               NUMBER(1) not null,
  feerate_b             NUMBER(15,9) not null,
  feerate_s             NUMBER(15,9) not null,
  marginalgr            NUMBER(1) not null,
  marginrate_b          NUMBER(10,4) default 0 not null,
  marginrate_s          NUMBER(10,4) default 0 not null,
  marginassure_b        NUMBER(10,4) default 0 not null,
  marginassure_s        NUMBER(10,4) default 0 not null,
  todayclosefeerate_b   NUMBER(15,9) default 0 not null,
  todayclosefeerate_s   NUMBER(15,9) default 0 not null,
  historyclosefeerate_b NUMBER(15,9) default 0 not null,
  historyclosefeerate_s NUMBER(15,9) default 0 not null,
  limitcmdtyqty         NUMBER(10) default -1 not null,
  settlefeealgr         NUMBER(1) not null,
  settlefeerate_b       NUMBER(15,9) default 0 not null,
  settlefeerate_s       NUMBER(15,9) default 0 not null,
  forceclosefeealgr     NUMBER(1) not null,
  forceclosefeerate_b   NUMBER(15,9) default 0 not null,
  forceclosefeerate_s   NUMBER(15,9) default 0 not null,
  settlemarginalgr_b    NUMBER(1) not null,
  settlemarginrate_b    NUMBER(10,4) default 0 not null,
  settlemarginalgr_s    NUMBER(1) not null,
  settlemarginrate_s    NUMBER(10,4) default 0 not null,
  addedtax              NUMBER(10,4) default 0 not null,
  marginpricetype       NUMBER(1) default 0 not null,
  lowestsettlefee       NUMBER(15,2) default 0 not null,
  limitbreedqty         NUMBER(10) default -1 not null,
  firmcleanqty          NUMBER(10) default -1 not null,
  firmmaxholdqty        NUMBER(10) default -1 not null,
  marginitem1           NUMBER(15,2),
  marginitem2           NUMBER(15,2),
  marginitem3           NUMBER(15,2),
  marginitem4           NUMBER(15,2),
  marginitem1_s         NUMBER(15,2),
  marginitem2_s         NUMBER(15,2),
  marginitem3_s         NUMBER(15,2),
  marginitem4_s         NUMBER(15,2),
  marginitemassure1     NUMBER(15,2),
  marginitemassure2     NUMBER(15,2),
  marginitemassure3     NUMBER(15,2),
  marginitemassure4     NUMBER(15,2),
  marginitemassure1_s   NUMBER(15,2),
  marginitemassure2_s   NUMBER(15,2),
  marginitemassure3_s   NUMBER(15,2),
  marginitemassure4_s   NUMBER(15,2),
  orderprivilege        NUMBER(6) default 101 not null,
  payoutalgr            NUMBER(1) not null,
  payoutrate            NUMBER(10,4) default 0 not null,
  addedtaxfactor        NUMBER(13,10) default 0 not null,
  marginitem5           NUMBER(15,2),
  marginitem5_s         NUMBER(15,2),
  marginitemassure5     NUMBER(15,2),
  marginitemassure5_s   NUMBER(15,2),
  settlepricetype       NUMBER(2) default 0 not null,
  beforedays            NUMBER(4),
  specsettleprice       NUMBER(10,2),
  firmmaxholdqtyalgr    NUMBER(1) default 2 not null,
  startpercentqty       NUMBER(10) default 0 not null,
  maxpercentlimit       NUMBER(7,4) default 0 not null,
  onemaxholdqty         NUMBER(10) default -1 not null,
  minquantitymove       NUMBER(3) default 1 not null,
  contractfactorname    VARCHAR2(10),
  delayrecouprate       NUMBER(7,5) default 0 not null,
  settleway             NUMBER(2) default 0 not null,
  delayfeeway           NUMBER(2) default 1 not null,
  maxfeerate            NUMBER(15,9),
  minsettlemoveqty      NUMBER(5) default 1 not null,
  breedtrademode        NUMBER(2) default 0 not null,
  storerecouprate       NUMBER(7,5) default 0 not null,
  minsettleqty          NUMBER(10) default 1 not null,
  delayrecouprate_s     NUMBER(7,5) default 0 not null,
  delaysettlepricetype  NUMBER(2) default 0,
  aheadsettlepricetype  NUMBER(2) default 0,
  settlemargintype      NUMBER(2) default 0,
  beforedays_m          NUMBER(2) default 0,
  sideholdlimitqty      NUMBER(10) default -1,
  holddayslimit         NUMBER(1) default 0 not null,
  maxholdpositionday    NUMBER(10)
)
;
alter table T_A_BREED
  add constraint PK_T_A_BREED primary key (BREEDID);

prompt
prompt Creating table T_A_BREEDTRADEPROP
prompt =================================
prompt
create table T_A_BREEDTRADEPROP
(
  breedid    NUMBER(10) not null,
  sectionid  NUMBER(4) not null,
  modifytime DATE not null
)
;
alter table T_A_BREEDTRADEPROP
  add constraint PK_T_A_BREEDTRADEPROP primary key (BREEDID, SECTIONID);

prompt
prompt Creating table T_A_BREED_BAK_20160105
prompt =====================================
prompt
create table T_A_BREED_BAK_20160105
(
  breedid               NUMBER(10) not null,
  breedname             VARCHAR2(32) not null,
  sortid                NUMBER(10) not null,
  contractfactor        NUMBER(12,2),
  minpricemove          NUMBER(10,2) not null,
  spreadalgr            NUMBER(1) not null,
  spreaduplmt           NUMBER(10,2) not null,
  spreaddownlmt         NUMBER(10,2) not null,
  feealgr               NUMBER(1) not null,
  feerate_b             NUMBER(15,9) not null,
  feerate_s             NUMBER(15,9) not null,
  marginalgr            NUMBER(1) not null,
  marginrate_b          NUMBER(10,4) not null,
  marginrate_s          NUMBER(10,4) not null,
  marginassure_b        NUMBER(10,4) not null,
  marginassure_s        NUMBER(10,4) not null,
  todayclosefeerate_b   NUMBER(15,9) not null,
  todayclosefeerate_s   NUMBER(15,9) not null,
  historyclosefeerate_b NUMBER(15,9) not null,
  historyclosefeerate_s NUMBER(15,9) not null,
  limitcmdtyqty         NUMBER(10) not null,
  settlefeealgr         NUMBER(1) not null,
  settlefeerate_b       NUMBER(15,9) not null,
  settlefeerate_s       NUMBER(15,9) not null,
  forceclosefeealgr     NUMBER(1) not null,
  forceclosefeerate_b   NUMBER(15,9) not null,
  forceclosefeerate_s   NUMBER(15,9) not null,
  settlemarginalgr_b    NUMBER(1) not null,
  settlemarginrate_b    NUMBER(10,4) not null,
  settlemarginalgr_s    NUMBER(1) not null,
  settlemarginrate_s    NUMBER(10,4) not null,
  addedtax              NUMBER(10,4) not null,
  marginpricetype       NUMBER(1) not null,
  lowestsettlefee       NUMBER(15,2) not null,
  limitbreedqty         NUMBER(10) not null,
  firmcleanqty          NUMBER(10) not null,
  firmmaxholdqty        NUMBER(10) not null,
  marginitem1           NUMBER(15,2),
  marginitem2           NUMBER(15,2),
  marginitem3           NUMBER(15,2),
  marginitem4           NUMBER(15,2),
  marginitem1_s         NUMBER(15,2),
  marginitem2_s         NUMBER(15,2),
  marginitem3_s         NUMBER(15,2),
  marginitem4_s         NUMBER(15,2),
  marginitemassure1     NUMBER(15,2),
  marginitemassure2     NUMBER(15,2),
  marginitemassure3     NUMBER(15,2),
  marginitemassure4     NUMBER(15,2),
  marginitemassure1_s   NUMBER(15,2),
  marginitemassure2_s   NUMBER(15,2),
  marginitemassure3_s   NUMBER(15,2),
  marginitemassure4_s   NUMBER(15,2),
  orderprivilege        NUMBER(6) not null,
  payoutalgr            NUMBER(1) not null,
  payoutrate            NUMBER(10,4) not null,
  addedtaxfactor        NUMBER(13,10) not null,
  marginitem5           NUMBER(15,2),
  marginitem5_s         NUMBER(15,2),
  marginitemassure5     NUMBER(15,2),
  marginitemassure5_s   NUMBER(15,2),
  settlepricetype       NUMBER(2) not null,
  beforedays            NUMBER(4),
  specsettleprice       NUMBER(10,2),
  firmmaxholdqtyalgr    NUMBER(1) not null,
  startpercentqty       NUMBER(10) not null,
  maxpercentlimit       NUMBER(7,4) not null,
  onemaxholdqty         NUMBER(10) not null,
  minquantitymove       NUMBER(3) not null,
  contractfactorname    VARCHAR2(10),
  delayrecouprate       NUMBER(7,5) not null,
  settleway             NUMBER(2) not null,
  delayfeeway           NUMBER(2) not null,
  maxfeerate            NUMBER(15,9),
  minsettlemoveqty      NUMBER(5) not null,
  breedtrademode        NUMBER(2) not null,
  storerecouprate       NUMBER(7,5) not null,
  minsettleqty          NUMBER(10) not null,
  delayrecouprate_s     NUMBER(7,5) not null,
  delaysettlepricetype  NUMBER(2),
  aheadsettlepricetype  NUMBER(2),
  settlemargintype      NUMBER(2),
  beforedays_m          NUMBER(2),
  sideholdlimitqty      NUMBER(10),
  holddayslimit         NUMBER(1) not null,
  maxholdpositionday    NUMBER(10)
)
;

prompt
prompt Creating table T_A_CMDTYSORT
prompt ============================
prompt
create table T_A_CMDTYSORT
(
  sortid   NUMBER(10) not null,
  sortname VARCHAR2(30) not null
)
;
alter table T_A_CMDTYSORT
  add constraint PK_T_A_CMDTYSORT primary key (SORTID);

prompt
prompt Creating table T_A_COMMODITYSETTLEPROP
prompt ======================================
prompt
create table T_A_COMMODITYSETTLEPROP
(
  commodityid VARCHAR2(16) not null,
  sectionid   NUMBER(4) not null,
  modifytime  DATE not null
)
;
alter table T_A_COMMODITYSETTLEPROP
  add constraint PK_T_A_COMMODITYSETTLEPROP primary key (COMMODITYID, SECTIONID);

prompt
prompt Creating table T_A_COMMODITYTRADEPROP
prompt =====================================
prompt
create table T_A_COMMODITYTRADEPROP
(
  commodityid VARCHAR2(16) not null,
  sectionid   NUMBER(4) not null,
  modifytime  DATE not null
)
;
alter table T_A_COMMODITYTRADEPROP
  add constraint PK_T_A_COMMODITYTRADEPROP primary key (COMMODITYID, SECTIONID);

prompt
prompt Creating table T_A_DAYSECTION
prompt =============================
prompt
create table T_A_DAYSECTION
(
  weekday    NUMBER(2) not null,
  sectionid  NUMBER(4) not null,
  status     NUMBER(2) default 0 not null,
  modifytime DATE not null
)
;
alter table T_A_DAYSECTION
  add constraint PK_T_A_DAYSECTION primary key (WEEKDAY, SECTIONID);

prompt
prompt Creating table T_A_DELAYTRADETIME
prompt =================================
prompt
create table T_A_DELAYTRADETIME
(
  sectionid  NUMBER(4) not null,
  name       VARCHAR2(20),
  starttime  VARCHAR2(10) not null,
  endtime    VARCHAR2(10) not null,
  type       NUMBER(2) default 0 not null,
  status     NUMBER(2) not null,
  modifytime DATE not null
)
;
alter table T_A_DELAYTRADETIME
  add constraint PK_T_A_DELAYTRADETIME primary key (SECTIONID);

prompt
prompt Creating table T_A_FIRMBREEDFEE
prompt ===============================
prompt
create table T_A_FIRMBREEDFEE
(
  firmid                VARCHAR2(32) not null,
  breedid               NUMBER(10) not null,
  feealgr               NUMBER(1) not null,
  feerate_b             NUMBER(15,9) not null,
  feerate_s             NUMBER(15,9) not null,
  todayclosefeerate_b   NUMBER(15,9) default 0 not null,
  todayclosefeerate_s   NUMBER(15,9) default 0 not null,
  historyclosefeerate_b NUMBER(15,9) default 0 not null,
  historyclosefeerate_s NUMBER(15,9) default 0 not null,
  forceclosefeealgr     NUMBER(1) not null,
  forceclosefeerate_b   NUMBER(15,9) default 0 not null,
  forceclosefeerate_s   NUMBER(15,9) default 0 not null,
  modifytime            DATE not null
)
;
alter table T_A_FIRMBREEDFEE
  add constraint PK_T_A_FIRMBREEDFEE primary key (FIRMID, BREEDID);

prompt
prompt Creating table T_A_FIRMBREEDMARGIN
prompt ==================================
prompt
create table T_A_FIRMBREEDMARGIN
(
  firmid              VARCHAR2(32) not null,
  breedid             NUMBER(10) not null,
  marginalgr          NUMBER(1) not null,
  marginrate_b        NUMBER(10,4) default 0 not null,
  marginrate_s        NUMBER(10,4) default 0 not null,
  marginitem1         NUMBER(15,2),
  marginitem2         NUMBER(15,2),
  marginitem3         NUMBER(15,2),
  marginitem4         NUMBER(15,2),
  marginitem1_s       NUMBER(15,2),
  marginitem2_s       NUMBER(15,2),
  marginitem3_s       NUMBER(15,2),
  marginitem4_s       NUMBER(15,2),
  marginassure_b      NUMBER(10,4) default 0 not null,
  marginassure_s      NUMBER(10,4) default 0 not null,
  marginitemassure1   NUMBER(15,2),
  marginitemassure2   NUMBER(15,2),
  marginitemassure3   NUMBER(15,2),
  marginitemassure4   NUMBER(15,2),
  marginitemassure1_s NUMBER(15,2),
  marginitemassure2_s NUMBER(15,2),
  marginitemassure3_s NUMBER(15,2),
  marginitemassure4_s NUMBER(15,2),
  modifytime          DATE not null,
  marginitem5         NUMBER(15,2),
  marginitem5_s       NUMBER(15,2),
  marginitemassure5   NUMBER(15,2),
  marginitemassure5_s NUMBER(15,2)
)
;
alter table T_A_FIRMBREEDMARGIN
  add constraint PK_T_A_FIRMBREEDMARGIN primary key (FIRMID, BREEDID);

prompt
prompt Creating table T_A_FIRMBREEDMAXHOLDQTY
prompt ======================================
prompt
create table T_A_FIRMBREEDMAXHOLDQTY
(
  firmid          VARCHAR2(32) not null,
  breedid         NUMBER(10) not null,
  maxholdqty      NUMBER(10) default -1 not null,
  cleanmaxholdqty NUMBER(10) default -1 not null,
  modifytime      DATE not null
)
;
alter table T_A_FIRMBREEDMAXHOLDQTY
  add constraint PK_T_A_FIRMBREEDMAXHOLDQTY primary key (FIRMID, BREEDID);

prompt
prompt Creating table T_A_FIRMBREEDSETTLEFEE
prompt =====================================
prompt
create table T_A_FIRMBREEDSETTLEFEE
(
  firmid          VARCHAR2(32) not null,
  breedid         NUMBER(10) not null,
  settlefeealgr   NUMBER(1) not null,
  settlefeerate_b NUMBER(15,9) default 0 not null,
  settlefeerate_s NUMBER(15,9) default 0 not null,
  modifytime      DATE not null
)
;
alter table T_A_FIRMBREEDSETTLEFEE
  add constraint PK_T_A_FIRMBREEDSETTLEFEE primary key (FIRMID, BREEDID);

prompt
prompt Creating table T_A_FIRMBREEDSETTLEMARGIN
prompt ========================================
prompt
create table T_A_FIRMBREEDSETTLEMARGIN
(
  firmid             VARCHAR2(32) not null,
  breedid            NUMBER(10) not null,
  settlemarginalgr_b NUMBER(1) not null,
  settlemarginrate_b NUMBER(10,4) default 0 not null,
  settlemarginalgr_s NUMBER(1) not null,
  settlemarginrate_s NUMBER(10,4) default 0 not null,
  payoutalgr         NUMBER(1) not null,
  payoutrate         NUMBER(10,4) default 0 not null,
  modifytime         DATE not null
)
;
alter table T_A_FIRMBREEDSETTLEMARGIN
  add constraint PK_T_A_FIRMBREEDSETTLEMARGIN primary key (FIRMID, BREEDID);

prompt
prompt Creating table T_A_FIRMFEE
prompt ==========================
prompt
create table T_A_FIRMFEE
(
  firmid                VARCHAR2(32) not null,
  commodityid           VARCHAR2(16) not null,
  feealgr               NUMBER(1) not null,
  feerate_b             NUMBER(15,9) not null,
  feerate_s             NUMBER(15,9) not null,
  todayclosefeerate_b   NUMBER(15,9) default 0 not null,
  todayclosefeerate_s   NUMBER(15,9) default 0 not null,
  historyclosefeerate_b NUMBER(15,9) default 0 not null,
  historyclosefeerate_s NUMBER(15,9) default 0 not null,
  forceclosefeealgr     NUMBER(1) not null,
  forceclosefeerate_b   NUMBER(15,9) default 0 not null,
  forceclosefeerate_s   NUMBER(15,9) default 0 not null,
  modifytime            DATE not null
)
;
alter table T_A_FIRMFEE
  add constraint PK_T_A_FIRMFEE primary key (FIRMID, COMMODITYID);

prompt
prompt Creating table T_A_FIRMMARGIN
prompt =============================
prompt
create table T_A_FIRMMARGIN
(
  firmid              VARCHAR2(32) not null,
  commodityid         VARCHAR2(16) not null,
  marginalgr          NUMBER(1) not null,
  marginrate_b        NUMBER(10,4) default 0 not null,
  marginrate_s        NUMBER(10,4) default 0 not null,
  marginitem1         NUMBER(15,2),
  marginitem2         NUMBER(15,2),
  marginitem3         NUMBER(15,2),
  marginitem4         NUMBER(15,2),
  marginitem1_s       NUMBER(15,2),
  marginitem2_s       NUMBER(15,2),
  marginitem3_s       NUMBER(15,2),
  marginitem4_s       NUMBER(15,2),
  marginassure_b      NUMBER(10,4) default 0 not null,
  marginassure_s      NUMBER(10,4) default 0 not null,
  marginitemassure1   NUMBER(15,2),
  marginitemassure2   NUMBER(15,2),
  marginitemassure3   NUMBER(15,2),
  marginitemassure4   NUMBER(15,2),
  marginitemassure1_s NUMBER(15,2),
  marginitemassure2_s NUMBER(15,2),
  marginitemassure3_s NUMBER(15,2),
  marginitemassure4_s NUMBER(15,2),
  modifytime          DATE not null,
  marginitem5         NUMBER(15,2),
  marginitem5_s       NUMBER(15,2),
  marginitemassure5   NUMBER(15,2),
  marginitemassure5_s NUMBER(15,2)
)
;
alter table T_A_FIRMMARGIN
  add constraint PK_T_A_FIRMMARGIN primary key (FIRMID, COMMODITYID);

prompt
prompt Creating table T_A_FIRMMAXHOLDQTY
prompt =================================
prompt
create table T_A_FIRMMAXHOLDQTY
(
  firmid          VARCHAR2(32) not null,
  commodityid     VARCHAR2(16) not null,
  maxholdqty      NUMBER(10) default -1 not null,
  cleanmaxholdqty NUMBER(10) default -1 not null,
  modifytime      DATE not null
)
;
alter table T_A_FIRMMAXHOLDQTY
  add constraint PK_T_A_FIRMMAXHOLDQTY primary key (FIRMID, COMMODITYID);

prompt
prompt Creating table T_A_FIRMSETTLEFEE
prompt ================================
prompt
create table T_A_FIRMSETTLEFEE
(
  firmid          VARCHAR2(32) not null,
  commodityid     VARCHAR2(16) not null,
  settlefeealgr   NUMBER(1) not null,
  settlefeerate_b NUMBER(15,9) default 0 not null,
  settlefeerate_s NUMBER(15,9) default 0 not null,
  modifytime      DATE not null
)
;
alter table T_A_FIRMSETTLEFEE
  add constraint PK_T_A_FIRMSETTLEFEE primary key (FIRMID, COMMODITYID);

prompt
prompt Creating table T_A_FIRMSETTLEMARGIN
prompt ===================================
prompt
create table T_A_FIRMSETTLEMARGIN
(
  firmid             VARCHAR2(32) not null,
  commodityid        VARCHAR2(16) not null,
  settlemarginalgr_b NUMBER(1) not null,
  settlemarginrate_b NUMBER(10,4) default 0 not null,
  settlemarginalgr_s NUMBER(1) not null,
  settlemarginrate_s NUMBER(10,4) default 0 not null,
  payoutalgr         NUMBER(1) not null,
  payoutrate         NUMBER(10,4) default 0 not null,
  modifytime         DATE not null
)
;
alter table T_A_FIRMSETTLEMARGIN
  add constraint PK_T_A_FIRMSETTLEMARGIN primary key (FIRMID, COMMODITYID);

prompt
prompt Creating table T_A_MARKET
prompt =========================
prompt
create table T_A_MARKET
(
  marketcode              CHAR(2) not null,
  marketname              VARCHAR2(64),
  status                  NUMBER(2) default 1 not null,
  shortname               VARCHAR2(20),
  runmode                 NUMBER(2) default 1 not null,
  settlemode              NUMBER(2) default 0 not null,
  marginfbflag            NUMBER(1) default 0 not null,
  floatinglosscomputetype NUMBER(1) default 0 not null,
  closealgr               NUMBER(2) default 0 not null,
  tradepricealgr          NUMBER(2) default 0 not null,
  tradeflowtype           NUMBER(2) default 0 not null,
  floatingprofitsubtax    NUMBER(1) default 0 not null,
  gagemode                NUMBER(2) default 0 not null,
  tradetimetype           NUMBER(2) default 0 not null,
  delayquoshowtype        NUMBER(2) default 1 not null,
  neutralfeeway           NUMBER(2) default 0 not null,
  delayneedbill           NUMBER(2) default 0 not null,
  neutralflag             NUMBER(2) default 0 not null,
  neutralmatchpriority    NUMBER(2) default 0 not null,
  quotationtwoside        NUMBER(2) default 2 not null,
  asmargintype            NUMBER(2) default 0,
  delayorderispure        NUMBER(1) default 0 not null,
  chargedelayfeetype      NUMBER(2) default 0 not null
)
;
comment on column T_A_MARKET.marketcode
  is '�г�����';
comment on column T_A_MARKET.marketname
  is '�г�����';
comment on column T_A_MARKET.status
  is '״̬';
comment on column T_A_MARKET.runmode
  is '����ģʽ';
comment on column T_A_MARKET.settlemode
  is '����ģʽ';
comment on column T_A_MARKET.floatinglosscomputetype
  is '�������㷽ʽ';
comment on column T_A_MARKET.closealgr
  is 'ƽ���㷨';
comment on column T_A_MARKET.tradepricealgr
  is '�ɽ����㷨';
comment on column T_A_MARKET.tradeflowtype
  is 'д�ɽ���ˮ����';
comment on column T_A_MARKET.floatingprofitsubtax
  is '����ӯ���Ƿ��˰';
comment on column T_A_MARKET.gagemode
  is '�ֶ�ģʽ';
comment on column T_A_MARKET.tradetimetype
  is '����ʱ������';
comment on column T_A_MARKET.delayquoshowtype
  is '���ڽ���������ʾ����';
comment on column T_A_MARKET.neutralfeeway
  is '�����ֽ�����������ȡ��ʽ';
comment on column T_A_MARKET.delayneedbill
  is '���ڽ����Ƿ���Ҫ�ֵ�';
comment on column T_A_MARKET.neutralflag
  is '���������ñ�־ 0�����ã�1����';
comment on column T_A_MARKET.neutralmatchpriority
  is '�����ִ�����ȼ�';
comment on column T_A_MARKET.quotationtwoside
  is '���鵥˫��';
comment on column T_A_MARKET.asmargintype
  is '��ǰ�����Ƿ���ȡ��֤��';
comment on column T_A_MARKET.delayorderispure
  is '�����걨�Ƿ񰴾��������걨 0����1����';
comment on column T_A_MARKET.chargedelayfeetype
  is '��ȡ���ڲ��������� 0��������������ȡ��Ĭ�ϣ���1�������߶���������ȡ��';
alter table T_A_MARKET
  add constraint PK_T_A_MARKET primary key (MARKETCODE);

prompt
prompt Creating table T_A_NOTTRADEDAY
prompt ==============================
prompt
create table T_A_NOTTRADEDAY
(
  id         NUMBER(10) not null,
  week       VARCHAR2(30),
  day        VARCHAR2(1024),
  modifytime DATE not null
)
;
alter table T_A_NOTTRADEDAY
  add constraint PK_T_A_NOTTRADEDAY primary key (ID);

prompt
prompt Creating table T_A_SETTLEPRIVILEGE
prompt ==================================
prompt
create table T_A_SETTLEPRIVILEGE
(
  id              NUMBER(15) not null,
  type            NUMBER(2) not null,
  typeid          VARCHAR2(16) not null,
  kind            NUMBER(2),
  kindid          VARCHAR2(24),
  privilegecode_b NUMBER(6) not null,
  privilegecode_s NUMBER(6) not null
)
;
alter table T_A_SETTLEPRIVILEGE
  add constraint PK_T_A_SETTLEPRIVILEGE primary key (ID);

prompt
prompt Creating table T_A_TARIFF
prompt =========================
prompt
create table T_A_TARIFF
(
  tariffid              VARCHAR2(6) not null,
  commodityid           VARCHAR2(16) not null,
  tariffname            VARCHAR2(32) not null,
  tariffrate            NUMBER(10,2) not null,
  feealgr               NUMBER(1) not null,
  feerate_b             NUMBER(15,9) not null,
  feerate_s             NUMBER(15,9) not null,
  todayclosefeerate_b   NUMBER(15,9) not null,
  todayclosefeerate_s   NUMBER(15,9) not null,
  historyclosefeerate_b NUMBER(15,9) not null,
  historyclosefeerate_s NUMBER(15,9) not null,
  forceclosefeealgr     NUMBER(1) not null,
  forceclosefeerate_b   NUMBER(15,9) not null,
  forceclosefeerate_s   NUMBER(15,9) not null,
  createtime            DATE default sysdate not null,
  createuser            VARCHAR2(32),
  modifytime            DATE default sysdate not null
)
;
alter table T_A_TARIFF
  add constraint PK_T_A_TARIFF primary key (TARIFFID, COMMODITYID);

prompt
prompt Creating table T_A_TRADEPRIVILEGE
prompt =================================
prompt
create table T_A_TRADEPRIVILEGE
(
  id              NUMBER(15) not null,
  type            NUMBER(2) not null,
  typeid          VARCHAR2(40) not null,
  kind            NUMBER(2),
  kindid          VARCHAR2(24),
  privilegecode_b NUMBER(6) not null,
  privilegecode_s NUMBER(6)
)
;
alter table T_A_TRADEPRIVILEGE
  add constraint PK_T_A_TRADEPRIVILEGE primary key (ID);

prompt
prompt Creating table T_A_TRADETIME
prompt ============================
prompt
create table T_A_TRADETIME
(
  sectionid    NUMBER(4) not null,
  name         VARCHAR2(20),
  starttime    VARCHAR2(10) not null,
  endtime      VARCHAR2(10) not null,
  status       NUMBER(2) not null,
  gatherbid    NUMBER(1) default 0 not null,
  bidstarttime VARCHAR2(10),
  bidendtime   VARCHAR2(10),
  modifytime   DATE not null,
  startdate    VARCHAR2(16),
  enddate      VARCHAR2(16),
  bidstartdate VARCHAR2(16),
  bidenddate   VARCHAR2(16)
)
;
alter table T_A_TRADETIME
  add constraint PK_T_A_TRADETIME primary key (SECTIONID);

prompt
prompt Creating table T_BALANCESTATUS
prompt ==============================
prompt
create table T_BALANCESTATUS
(
  b_date    DATE not null,
  status    NUMBER(2) not null,
  note      VARCHAR2(256),
  cleartime DATE
)
;
alter table T_BALANCESTATUS
  add constraint PK_B_DATE primary key (B_DATE);

prompt
prompt Creating table T_BILLFROZEN
prompt ===========================
prompt
create table T_BILLFROZEN
(
  id            NUMBER(15) not null,
  operation     VARCHAR2(20),
  billid        VARCHAR2(32) not null,
  operationtype NUMBER(2),
  modifytime    DATE not null
)
;
alter table T_BILLFROZEN
  add constraint PK_T_BILLFROZEN primary key (ID);

prompt
prompt Creating table T_BR_FIRMREWARDDEAIL
prompt ===================================
prompt
create table T_BR_FIRMREWARDDEAIL
(
  firmid           VARCHAR2(32) not null,
  commodityid      VARCHAR2(16) not null,
  cleardate        DATE not null,
  rewardtype       NUMBER(2) not null,
  brokerid         VARCHAR2(16) not null,
  brokername       VARCHAR2(128),
  firstpay         NUMBER(15,2) not null,
  secondpay        NUMBER(15,2) not null,
  reward           NUMBER(15,2) not null,
  marketreward     NUMBER(15,2) not null,
  brokereachdivide NUMBER(15,2) not null,
  quantity         NUMBER(10) not null,
  trademoney       NUMBER(15,2) not null,
  brokerageid      VARCHAR2(32),
  brokeragename    VARCHAR2(64)
)
;
comment on table T_BR_FIRMREWARDDEAIL
  is '������Ӷ����ϸ��';
comment on column T_BR_FIRMREWARDDEAIL.firmid
  is '������id';
comment on column T_BR_FIRMREWARDDEAIL.commodityid
  is '��Ʒ����';
comment on column T_BR_FIRMREWARDDEAIL.cleardate
  is '��������';
comment on column T_BR_FIRMREWARDDEAIL.rewardtype
  is '�������� 0:����';
comment on column T_BR_FIRMREWARDDEAIL.brokerid
  is '������id';
comment on column T_BR_FIRMREWARDDEAIL.brokername
  is '����������';
comment on column T_BR_FIRMREWARDDEAIL.firstpay
  is '�׿�';
comment on column T_BR_FIRMREWARDDEAIL.secondpay
  is 'β��';
comment on column T_BR_FIRMREWARDDEAIL.reward
  is '������ʵ��������';
comment on column T_BR_FIRMREWARDDEAIL.marketreward
  is '������ʵ��������';
comment on column T_BR_FIRMREWARDDEAIL.brokereachdivide
  is '�����������м����������ѷֳ�';
comment on column T_BR_FIRMREWARDDEAIL.quantity
  is '��������';
comment on column T_BR_FIRMREWARDDEAIL.trademoney
  is '���׶�';
comment on column T_BR_FIRMREWARDDEAIL.brokerageid
  is '������ֱ���Ӽ��̴���';
comment on column T_BR_FIRMREWARDDEAIL.brokeragename
  is '������ֱ���Ӽ�������';
alter table T_BR_FIRMREWARDDEAIL
  add constraint PK_T_BR_FIRMREWARDDEAIL primary key (FIRMID, COMMODITYID, CLEARDATE, REWARDTYPE);

prompt
prompt Creating table T_CLEARSTATUS
prompt ============================
prompt
create table T_CLEARSTATUS
(
  actionid   NUMBER(3) not null,
  actionnote VARCHAR2(32) not null,
  status     CHAR(1) not null,
  finishtime DATE
)
;
alter table T_CLEARSTATUS
  add constraint PK_ACTIONID primary key (ACTIONID);

prompt
prompt Creating table T_COMMODITY
prompt ==========================
prompt
create table T_COMMODITY
(
  commodityid           VARCHAR2(16) not null,
  name                  VARCHAR2(32) not null,
  sortid                NUMBER(10) not null,
  status                NUMBER(2) not null,
  contractfactor        NUMBER(12,2) not null,
  minpricemove          NUMBER(10,2) not null,
  breedid               NUMBER(10) not null,
  spreadalgr            NUMBER(1) not null,
  spreaduplmt           NUMBER(10,2) not null,
  spreaddownlmt         NUMBER(10,2) not null,
  feealgr               NUMBER(1) not null,
  feerate_b             NUMBER(15,9) not null,
  feerate_s             NUMBER(15,9) not null,
  marginalgr            NUMBER(1) not null,
  marginrate_b          NUMBER(10,4) default 0 not null,
  marginrate_s          NUMBER(10,4) default 0 not null,
  marketdate            DATE,
  settledate            DATE not null,
  settledate1           DATE,
  marginitem1           NUMBER(15,2),
  settledate2           DATE,
  marginitem2           NUMBER(15,2),
  settledate3           DATE,
  marginitem3           NUMBER(15,2),
  settledate4           DATE,
  marginitem4           NUMBER(15,2),
  lastprice             NUMBER(10,2) not null,
  marginitem1_s         NUMBER(15,2),
  marginitem2_s         NUMBER(15,2),
  marginitem3_s         NUMBER(15,2),
  marginitem4_s         NUMBER(15,2),
  marginassure_b        NUMBER(10,4) default 0 not null,
  marginassure_s        NUMBER(10,4) default 0 not null,
  marginitemassure1     NUMBER(15,2),
  marginitemassure2     NUMBER(15,2),
  marginitemassure3     NUMBER(15,2),
  marginitemassure4     NUMBER(15,2),
  marginitemassure1_s   NUMBER(15,2),
  marginitemassure2_s   NUMBER(15,2),
  marginitemassure3_s   NUMBER(15,2),
  marginitemassure4_s   NUMBER(15,2),
  todayclosefeerate_b   NUMBER(15,9) default 0 not null,
  todayclosefeerate_s   NUMBER(15,9) default 0 not null,
  historyclosefeerate_b NUMBER(15,9) default 0 not null,
  historyclosefeerate_s NUMBER(15,9) default 0 not null,
  limitcmdtyqty         NUMBER(10) default -1 not null,
  settlefeealgr         NUMBER(1) not null,
  settlefeerate_b       NUMBER(15,9) default 0 not null,
  settlefeerate_s       NUMBER(15,9) default 0 not null,
  forceclosefeealgr     NUMBER(1) not null,
  forceclosefeerate_b   NUMBER(15,9) default 0 not null,
  forceclosefeerate_s   NUMBER(15,9) default 0 not null,
  settlemarginalgr_b    NUMBER(1) not null,
  settlemarginrate_b    NUMBER(10,4) default 0 not null,
  settlemarginalgr_s    NUMBER(1) not null,
  settlemarginrate_s    NUMBER(10,4) default 0 not null,
  reservecount          NUMBER(10) default 0 not null,
  addedtax              NUMBER(10,4) default 0 not null,
  marginpricetype       NUMBER(1) default 0 not null,
  lowestsettlefee       NUMBER(15,2) default 0 not null,
  firmcleanqty          NUMBER(10) default -1 not null,
  firmmaxholdqty        NUMBER(10) default -1 not null,
  payoutalgr            NUMBER(1) not null,
  payoutrate            NUMBER(10,4) default 0 not null,
  addedtaxfactor        NUMBER(13,10) default 0 not null,
  settledate5           DATE,
  marginitem5           NUMBER(15,2),
  marginitem5_s         NUMBER(15,2),
  marginitemassure5     NUMBER(15,2),
  marginitemassure5_s   NUMBER(15,2),
  settlepricetype       NUMBER(2) default 0 not null,
  beforedays            NUMBER(4),
  specsettleprice       NUMBER(10,2),
  orderprivilege_b      NUMBER(6) default 101 not null,
  orderprivilege_s      NUMBER(6) default 101 not null,
  firmmaxholdqtyalgr    NUMBER(1) default 2 not null,
  startpercentqty       NUMBER(10) default 0 not null,
  maxpercentlimit       NUMBER(7,4) default 0 not null,
  onemaxholdqty         NUMBER(10) default -1 not null,
  minquantitymove       NUMBER(3) default 1 not null,
  delayrecouprate       NUMBER(7,5) default 0 not null,
  settleway             NUMBER(2) default 0 not null,
  delayfeeway           NUMBER(2) default 1 not null,
  maxfeerate            NUMBER(15,9),
  minsettlemoveqty      NUMBER(5) default 1 not null,
  storerecouprate       NUMBER(7,5) default 0 not null,
  minsettleqty          NUMBER(10) default 1 not null,
  delayrecouprate_s     NUMBER(7,5) default 0 not null,
  aheadsettlepricetype  NUMBER(2) default 0,
  delaysettlepricetype  NUMBER(2) default 0,
  settlemargintype      NUMBER(2) default 0,
  beforedays_m          NUMBER(2) default 0,
  sideholdlimitqty      NUMBER(10) default -1,
  holddayslimit         NUMBER(1) default 0 not null,
  maxholdpositionday    NUMBER(10),
  taxinclusive          NUMBER(1) default 1
)
;
comment on column T_COMMODITY.commodityid
  is '��������Ʒ���룩';
comment on column T_COMMODITY.name
  is '��Ʒ����';
comment on column T_COMMODITY.sortid
  is '��Ʒ����ID';
comment on column T_COMMODITY.status
  is '״̬';
comment on column T_COMMODITY.contractfactor
  is '��Լ����';
comment on column T_COMMODITY.minpricemove
  is '��С��λ�䶯';
comment on column T_COMMODITY.breedid
  is '��ƷƷ��';
comment on column T_COMMODITY.spreadalgr
  is '�ǵ����㷨';
comment on column T_COMMODITY.spreaduplmt
  is '�Ƿ�����';
comment on column T_COMMODITY.spreaddownlmt
  is '��������';
comment on column T_COMMODITY.feealgr
  is '�������㷨';
comment on column T_COMMODITY.feerate_b
  is '������ϵ��';
comment on column T_COMMODITY.feerate_s
  is '������ϵ��';
comment on column T_COMMODITY.marginalgr
  is '��֤���㷨';
comment on column T_COMMODITY.marginrate_b
  is '���ױ�֤��ϵ��';
comment on column T_COMMODITY.marginrate_s
  is '���ױ�֤��ϵ��';
comment on column T_COMMODITY.marketdate
  is '��������';
comment on column T_COMMODITY.settledate
  is '��������';
comment on column T_COMMODITY.settledate1
  is '�����������1';
comment on column T_COMMODITY.marginitem1
  is '��֤�����1';
comment on column T_COMMODITY.settledate2
  is '�����������2';
comment on column T_COMMODITY.marginitem2
  is '��֤�����2';
comment on column T_COMMODITY.settledate3
  is '�����������3';
comment on column T_COMMODITY.marginitem3
  is '��֤�����3 �����µ�ʮ�����׿��׼';
comment on column T_COMMODITY.settledate4
  is '�����������4';
comment on column T_COMMODITY.marginitem4
  is '��֤�����4';
comment on column T_COMMODITY.lastprice
  is '�۸�';
comment on column T_COMMODITY.marginitem1_s
  is '����֤�����1';
comment on column T_COMMODITY.marginitem2_s
  is '����֤�����2';
comment on column T_COMMODITY.marginitem3_s
  is '����֤�����3';
comment on column T_COMMODITY.marginitem4_s
  is '����֤�����4';
comment on column T_COMMODITY.marginassure_b
  is '������ϵ��';
comment on column T_COMMODITY.marginassure_s
  is '��������ϵ��';
comment on column T_COMMODITY.marginitemassure1
  is '�򵣱������1';
comment on column T_COMMODITY.marginitemassure2
  is '�򵣱������2';
comment on column T_COMMODITY.marginitemassure3
  is '�򵣱������3';
comment on column T_COMMODITY.marginitemassure4
  is '�򵣱������4';
comment on column T_COMMODITY.marginitemassure1_s
  is '�����������1';
comment on column T_COMMODITY.marginitemassure2_s
  is '�����������2';
comment on column T_COMMODITY.marginitemassure3_s
  is '�����������3';
comment on column T_COMMODITY.marginitemassure4_s
  is '�����������4';
comment on column T_COMMODITY.todayclosefeerate_b
  is '�񿪽�ƽ��������ϵ��';
comment on column T_COMMODITY.todayclosefeerate_s
  is '�񿪽�ƽ��������ϵ��';
comment on column T_COMMODITY.historyclosefeerate_b
  is 'ҹ��ƽ����������ϵ��';
comment on column T_COMMODITY.historyclosefeerate_s
  is '��ҹ��ƽ����������ϵ��';
comment on column T_COMMODITY.limitcmdtyqty
  is '��Ʒ�������� ����������Ʒ���ܶ��������ܴ��ڴ�ֵ��-1��ʾ������';
comment on column T_COMMODITY.settlefeealgr
  is '�����������㷨';
comment on column T_COMMODITY.settlefeerate_b
  is '������������ϵ��';
comment on column T_COMMODITY.settlefeerate_s
  is '����������ϵ��';
comment on column T_COMMODITY.forceclosefeealgr
  is 'Ϊת���������㷨';
comment on column T_COMMODITY.forceclosefeerate_b
  is '��Ϊת����������ϵ��';
comment on column T_COMMODITY.forceclosefeerate_s
  is '��Ϊת����������ϵ��';
comment on column T_COMMODITY.settlemarginalgr_b
  is '���ձ�֤���㷨';
comment on column T_COMMODITY.settlemarginrate_b
  is '���ձ�֤����ϵ��';
comment on column T_COMMODITY.settlemarginalgr_s
  is '�����ձ�֤���㷨';
comment on column T_COMMODITY.settlemarginrate_s
  is '���ձ�֤����ϵ��';
comment on column T_COMMODITY.reservecount
  is '���鶩����';
comment on column T_COMMODITY.addedtax
  is '��ֵ˰��';
comment on column T_COMMODITY.marginpricetype
  is '��֤����㷽ʽ';
comment on column T_COMMODITY.lowestsettlefee
  is '������������ͽ��';
comment on column T_COMMODITY.firmcleanqty
  is '�����̾�������';
comment on column T_COMMODITY.firmmaxholdqty
  is '���ֲ���';
comment on column T_COMMODITY.payoutalgr
  is '���ջ����㷨';
comment on column T_COMMODITY.payoutrate
  is '�ջ���ϵ��';
comment on column T_COMMODITY.addedtaxfactor
  is '��ֵ˰ϵ��';
comment on column T_COMMODITY.settledate5
  is '�����������5';
comment on column T_COMMODITY.marginitem5
  is '��֤�����5';
comment on column T_COMMODITY.marginitem5_s
  is '��֤�����5';
comment on column T_COMMODITY.marginitemassure5
  is '�򵣱������5';
comment on column T_COMMODITY.marginitemassure5_s
  is '�����������5';
comment on column T_COMMODITY.settlepricetype
  is '���ռۼ��㷽ʽ';
comment on column T_COMMODITY.beforedays
  is '���㽻�ռ۵���ǰ��';
comment on column T_COMMODITY.specsettleprice
  is '�ս����';
comment on column T_COMMODITY.orderprivilege_b
  is '��ί��Ȩ��';
comment on column T_COMMODITY.orderprivilege_s
  is '����ί��Ȩ��';
comment on column T_COMMODITY.firmmaxholdqtyalgr
  is '�����̶����������㷨';
comment on column T_COMMODITY.startpercentqty
  is '��Ʒ�ٷֱȷ�ֵ��';
comment on column T_COMMODITY.maxpercentlimit
  is '�����̶��������ٷֱ�';
comment on column T_COMMODITY.onemaxholdqty
  is '�������ί����';
comment on column T_COMMODITY.minquantitymove
  is '��С�䶯����';
comment on column T_COMMODITY.delayrecouprate
  is '�����ڲ�������';
comment on column T_COMMODITY.settleway
  is '���շ�ʽ 0����Զ�� 1�������ֻ� 2��ר������';
comment on column T_COMMODITY.delayfeeway
  is '���ڷ���ȡ��ʽ';
comment on column T_COMMODITY.maxfeerate
  is '�����������ϵ��';
comment on column T_COMMODITY.minsettlemoveqty
  is '��С���λ';
comment on column T_COMMODITY.storerecouprate
  is '�ִ���������';
comment on column T_COMMODITY.minsettleqty
  is '��С��������';
comment on column T_COMMODITY.delayrecouprate_s
  is '�������ڲ�������';
comment on column T_COMMODITY.aheadsettlepricetype
  is '��ǰ���ս��ռ۸�����';
comment on column T_COMMODITY.delaysettlepricetype
  is '��Ʒ���߶��������� 0���Խ������Ϊ���ռ۸�  ��1���Զ�������Ϊ���ռ۸�';
comment on column T_COMMODITY.settlemargintype
  is '���ձ�֤����㷽ʽ';
comment on column T_COMMODITY.beforedays_m
  is '��ǰ���ռ��㽻�ձ�֤���';
comment on column T_COMMODITY.sideholdlimitqty
  is '��Ʒ���߶���������';
comment on column T_COMMODITY.holddayslimit
  is '�Ƿ����óֲ���������';
comment on column T_COMMODITY.maxholdpositionday
  is '��ֲ�����';
alter table T_COMMODITY
  add primary key (COMMODITYID);

prompt
prompt Creating table T_COMMODITY_BAK_20160105
prompt =======================================
prompt
create table T_COMMODITY_BAK_20160105
(
  commodityid           VARCHAR2(16) not null,
  name                  VARCHAR2(32) not null,
  sortid                NUMBER(10) not null,
  status                NUMBER(2) not null,
  contractfactor        NUMBER(12,2) not null,
  minpricemove          NUMBER(10,2) not null,
  breedid               NUMBER(10) not null,
  spreadalgr            NUMBER(1) not null,
  spreaduplmt           NUMBER(10,2) not null,
  spreaddownlmt         NUMBER(10,2) not null,
  feealgr               NUMBER(1) not null,
  feerate_b             NUMBER(15,9) not null,
  feerate_s             NUMBER(15,9) not null,
  marginalgr            NUMBER(1) not null,
  marginrate_b          NUMBER(10,4) not null,
  marginrate_s          NUMBER(10,4) not null,
  marketdate            DATE,
  settledate            DATE not null,
  settledate1           DATE,
  marginitem1           NUMBER(15,2),
  settledate2           DATE,
  marginitem2           NUMBER(15,2),
  settledate3           DATE,
  marginitem3           NUMBER(15,2),
  settledate4           DATE,
  marginitem4           NUMBER(15,2),
  lastprice             NUMBER(10,2) not null,
  marginitem1_s         NUMBER(15,2),
  marginitem2_s         NUMBER(15,2),
  marginitem3_s         NUMBER(15,2),
  marginitem4_s         NUMBER(15,2),
  marginassure_b        NUMBER(10,4) not null,
  marginassure_s        NUMBER(10,4) not null,
  marginitemassure1     NUMBER(15,2),
  marginitemassure2     NUMBER(15,2),
  marginitemassure3     NUMBER(15,2),
  marginitemassure4     NUMBER(15,2),
  marginitemassure1_s   NUMBER(15,2),
  marginitemassure2_s   NUMBER(15,2),
  marginitemassure3_s   NUMBER(15,2),
  marginitemassure4_s   NUMBER(15,2),
  todayclosefeerate_b   NUMBER(15,9) not null,
  todayclosefeerate_s   NUMBER(15,9) not null,
  historyclosefeerate_b NUMBER(15,9) not null,
  historyclosefeerate_s NUMBER(15,9) not null,
  limitcmdtyqty         NUMBER(10) not null,
  settlefeealgr         NUMBER(1) not null,
  settlefeerate_b       NUMBER(15,9) not null,
  settlefeerate_s       NUMBER(15,9) not null,
  forceclosefeealgr     NUMBER(1) not null,
  forceclosefeerate_b   NUMBER(15,9) not null,
  forceclosefeerate_s   NUMBER(15,9) not null,
  settlemarginalgr_b    NUMBER(1) not null,
  settlemarginrate_b    NUMBER(10,4) not null,
  settlemarginalgr_s    NUMBER(1) not null,
  settlemarginrate_s    NUMBER(10,4) not null,
  reservecount          NUMBER(10) not null,
  addedtax              NUMBER(10,4) not null,
  marginpricetype       NUMBER(1) not null,
  lowestsettlefee       NUMBER(15,2) not null,
  firmcleanqty          NUMBER(10) not null,
  firmmaxholdqty        NUMBER(10) not null,
  payoutalgr            NUMBER(1) not null,
  payoutrate            NUMBER(10,4) not null,
  addedtaxfactor        NUMBER(13,10) not null,
  settledate5           DATE,
  marginitem5           NUMBER(15,2),
  marginitem5_s         NUMBER(15,2),
  marginitemassure5     NUMBER(15,2),
  marginitemassure5_s   NUMBER(15,2),
  settlepricetype       NUMBER(2) not null,
  beforedays            NUMBER(4),
  specsettleprice       NUMBER(10,2),
  orderprivilege_b      NUMBER(6) not null,
  orderprivilege_s      NUMBER(6) not null,
  firmmaxholdqtyalgr    NUMBER(1) not null,
  startpercentqty       NUMBER(10) not null,
  maxpercentlimit       NUMBER(7,4) not null,
  onemaxholdqty         NUMBER(10) not null,
  minquantitymove       NUMBER(3) not null,
  delayrecouprate       NUMBER(7,5) not null,
  settleway             NUMBER(2) not null,
  delayfeeway           NUMBER(2) not null,
  maxfeerate            NUMBER(15,9),
  minsettlemoveqty      NUMBER(5) not null,
  storerecouprate       NUMBER(7,5) not null,
  minsettleqty          NUMBER(10) not null,
  delayrecouprate_s     NUMBER(7,5) not null,
  aheadsettlepricetype  NUMBER(2),
  delaysettlepricetype  NUMBER(2),
  settlemargintype      NUMBER(2),
  beforedays_m          NUMBER(2),
  sideholdlimitqty      NUMBER(10),
  holddayslimit         NUMBER(1) not null,
  maxholdpositionday    NUMBER(10),
  taxinclusive          NUMBER(1)
)
;

prompt
prompt Creating table T_CONDITIONORDER
prompt ===============================
prompt
create table T_CONDITIONORDER
(
  a_orderno            NUMBER(15) not null,
  commodityid          VARCHAR2(16) not null,
  customerid           VARCHAR2(40) not null,
  traderid             VARCHAR2(40) not null,
  bs_flag              NUMBER(2) not null,
  ordertype            NUMBER(2) not null,
  price                NUMBER(10,2) not null,
  quantity             NUMBER(10) not null,
  conditiontype        NUMBER(2),
  conditionoperation   NUMBER(2),
  conditionprice       NUMBER(10,2) not null,
  conditioncommodityid VARCHAR2(16) not null,
  firmid               VARCHAR2(32) not null,
  retcode              NUMBER(4),
  updatetime           TIMESTAMP(6),
  validdate            DATE,
  sendstatus           NUMBER(2) default 0 not null,
  successtime          TIMESTAMP(6)
)
;
alter table T_CONDITIONORDER
  add constraint PK_T_CONDITIONORDER primary key (A_ORDERNO);

prompt
prompt Creating table T_CURMINNO
prompt =========================
prompt
create table T_CURMINNO
(
  tradedate NUMBER(10) not null,
  a_orderno NUMBER(15) default 0 not null,
  a_tradeno NUMBER(15) default 0 not null,
  a_holdno  NUMBER(15) default 0 not null
)
;
alter table T_CURMINNO
  add constraint PK_T_CURMINNO primary key (TRADEDATE);

prompt
prompt Creating table T_CUSTOMER
prompt =========================
prompt
create table T_CUSTOMER
(
  customerid VARCHAR2(40) not null,
  firmid     VARCHAR2(32) not null,
  code       VARCHAR2(6) not null,
  name       VARCHAR2(16),
  status     NUMBER(2) default 0 not null,
  createtime DATE not null,
  modifytime DATE
)
;
create unique index UK_T_CUSTOMER on T_CUSTOMER (FIRMID, CODE);
alter table T_CUSTOMER
  add constraint PK_T_CUSTOMER primary key (CUSTOMERID);

prompt
prompt Creating table T_CUSTOMERHOLDSUM
prompt ================================
prompt
create table T_CUSTOMERHOLDSUM
(
  customerid    VARCHAR2(40) not null,
  commodityid   VARCHAR2(16) not null,
  bs_flag       NUMBER(2) not null,
  holdqty       NUMBER(10) not null,
  holdfunds     NUMBER(15,2) not null,
  floatingloss  NUMBER(15,2) not null,
  evenprice     NUMBER(16,6) not null,
  frozenqty     NUMBER(10) not null,
  holdmargin    NUMBER(15,2) default 0 not null,
  gageqty       NUMBER(10) default 0 not null,
  holdassure    NUMBER(15,2) default 0 not null,
  firmid        VARCHAR2(32) not null,
  gagefrozenqty NUMBER(10) default 0 not null
)
;
comment on column T_CUSTOMERHOLDSUM.customerid
  is '�������׿ͻ�ID';
comment on column T_CUSTOMERHOLDSUM.commodityid
  is '��Ʒ����';
comment on column T_CUSTOMERHOLDSUM.bs_flag
  is '������־ 1:�� buy��2:�� sell';
comment on column T_CUSTOMERHOLDSUM.holdqty
  is '�ֲ�����';
comment on column T_CUSTOMERHOLDSUM.holdfunds
  is '�ֲֽ��';
comment on column T_CUSTOMERHOLDSUM.floatingloss
  is '����ӯ��';
comment on column T_CUSTOMERHOLDSUM.evenprice
  is '�ֲ־���';
comment on column T_CUSTOMERHOLDSUM.frozenqty
  is '��������';
comment on column T_CUSTOMERHOLDSUM.holdmargin
  is 'ʵʱ��֤��';
comment on column T_CUSTOMERHOLDSUM.gageqty
  is '�ֶ�����';
comment on column T_CUSTOMERHOLDSUM.holdassure
  is '�ֲֵ�����';
comment on column T_CUSTOMERHOLDSUM.firmid
  is '������ID';
comment on column T_CUSTOMERHOLDSUM.gagefrozenqty
  is '�ֶ���������';
create index IX_T_CUSTOMERHOLDSUM on T_CUSTOMERHOLDSUM (FIRMID, COMMODITYID, BS_FLAG);
alter table T_CUSTOMERHOLDSUM
  add constraint PK_T_CUSTOMERHOLDSUM primary key (CUSTOMERID, COMMODITYID, BS_FLAG);

prompt
prompt Creating table T_DBLOG
prompt ======================
prompt
create table T_DBLOG
(
  err_date  DATE not null,
  name_proc VARCHAR2(30),
  err_code  NUMBER(10),
  err_msg   VARCHAR2(200)
)
;

prompt
prompt Creating table T_DELAYORDERS
prompt ============================
prompt
create table T_DELAYORDERS
(
  a_orderno      NUMBER(15) not null,
  commodityid    VARCHAR2(16) not null,
  customerid     VARCHAR2(40) not null,
  traderid       VARCHAR2(40),
  bs_flag        NUMBER(2) not null,
  delayordertype NUMBER(2) not null,
  status         NUMBER(2) not null,
  withdrawtype   NUMBER(2),
  quantity       NUMBER(10) not null,
  price          NUMBER(10,2),
  tradeqty       NUMBER(10) default 0,
  frozenfunds    NUMBER(15,2) default 0,
  unfrozenfunds  NUMBER(15,2) default 0,
  ordertime      DATE not null,
  withdrawtime   DATE,
  ordererip      VARCHAR2(64),
  signature      VARCHAR2(256),
  firmid         VARCHAR2(32) not null,
  consignerid    VARCHAR2(10),
  withdrawerid   VARCHAR2(40)
)
;
alter table T_DELAYORDERS
  add constraint PK_T_DELAYORDERS primary key (A_ORDERNO);

prompt
prompt Creating table T_DELAYQUOTATION
prompt ===============================
prompt
create table T_DELAYQUOTATION
(
  commodityid       VARCHAR2(16) not null,
  buysettleqty      NUMBER(10) not null,
  sellsettleqty     NUMBER(10) not null,
  buyneutralqty     NUMBER(10) not null,
  sellneutralqty    NUMBER(10) not null,
  createtime        DATE,
  neutralside       NUMBER(2) default 0 not null,
  delaycleanholdqty NUMBER(10) default 0 not null
)
;
alter table T_DELAYQUOTATION
  add constraint PK_T_DELAYQUOTATION primary key (COMMODITYID);

prompt
prompt Creating table T_DELAYSTATUS
prompt ============================
prompt
create table T_DELAYSTATUS
(
  tradedate   DATE not null,
  status      NUMBER(2) default 3 not null,
  sectionid   NUMBER(4),
  note        VARCHAR2(256),
  recovertime VARCHAR2(10)
)
;
comment on column T_DELAYSTATUS.tradedate
  is '��������';
comment on column T_DELAYSTATUS.status
  is '״̬ 0:��ʼ�����,1:�����걨,2:�ڼ���Ϣ,3:�������걨,4:��ͣ����,5:���׽���';
comment on column T_DELAYSTATUS.sectionid
  is '���׽ڱ��';
comment on column T_DELAYSTATUS.note
  is '��ע';
comment on column T_DELAYSTATUS.recovertime
  is '��ͣ���Զ��ָ�ʱ��';
alter table T_DELAYSTATUS
  add constraint PK_T_DELAYSTATUS primary key (TRADEDATE);

prompt
prompt Creating table T_DELAYTRADE
prompt ===========================
prompt
create table T_DELAYTRADE
(
  a_tradeno      NUMBER(15) not null,
  a_orderno      NUMBER(15) not null,
  tradetime      DATE not null,
  customerid     VARCHAR2(40) not null,
  commodityid    VARCHAR2(16) not null,
  bs_flag        NUMBER(2) not null,
  delayordertype NUMBER(2) not null,
  quantity       NUMBER(10) not null,
  tradetype      NUMBER(2) not null,
  firmid         VARCHAR2(32) not null
)
;
alter table T_DELAYTRADE
  add constraint PK_T_DELAYTRADE primary key (A_TRADENO);

prompt
prompt Creating table T_D_DELAYORDERLOG
prompt ================================
prompt
create table T_D_DELAYORDERLOG
(
  id           NUMBER(15) not null,
  firmid       VARCHAR2(32) not null,
  ordertype    NUMBER(2) not null,
  commodityid  VARCHAR2(16) not null,
  a_holdno     NUMBER(15) not null,
  settleprice  NUMBER(15) not null,
  quantity     NUMBER(15,2) not null,
  settlemargin NUMBER(15,2) default 0 not null,
  trademargin  NUMBER(15,2) not null,
  payout       NUMBER(15) not null,
  actiontime   DATE not null,
  expandxml    VARCHAR2(65)
)
;
alter table T_D_DELAYORDERLOG
  add constraint PK_T_D_DELAYORDERLOG primary key (ID);

prompt
prompt Creating table T_D_DELAYORDERSUMLOG
prompt ===================================
prompt
create table T_D_DELAYORDERSUMLOG
(
  id           NUMBER(15) not null,
  firmid       VARCHAR2(32) not null,
  ordertype    NUMBER(2) not null,
  commodityid  VARCHAR2(16) not null,
  settleprice  NUMBER(15,2) not null,
  quantity     NUMBER(15,2) not null,
  settlemargin NUMBER(15,2) default 0 not null,
  trademargin  NUMBER(15,2) not null,
  payout       NUMBER(15) not null,
  a_funds      NUMBER(15,2) not null,
  f_funds      NUMBER(15,2) not null,
  actiontime   DATE not null,
  expandxml    VARCHAR2(64)
)
;
alter table T_D_DELAYORDERSUMLOG
  add constraint PK_T_D_DELAYORDERSUMLOG primary key (ID);

prompt
prompt Creating table T_E_APPLYAHEADSETTLE
prompt ===================================
prompt
create table T_E_APPLYAHEADSETTLE
(
  applyid      VARCHAR2(15) not null,
  commodityid  VARCHAR2(16) not null,
  customerid_s VARCHAR2(40),
  customerid_b VARCHAR2(40),
  price        NUMBER(10,2),
  quantity     NUMBER(10) not null,
  status       NUMBER(2) not null,
  createtime   DATE not null,
  creator      VARCHAR2(20) not null,
  remark1      VARCHAR2(256),
  modifytime   DATE,
  modifier     VARCHAR2(20),
  remark2      VARCHAR2(256)
)
;
alter table T_E_APPLYAHEADSETTLE
  add constraint PK_T_E_APPLYAHEADSETTLE_1 primary key (APPLYID);

prompt
prompt Creating table T_E_APPLYGAGE
prompt ============================
prompt
create table T_E_APPLYGAGE
(
  applyid     NUMBER(15) not null,
  commodityid VARCHAR2(16) not null,
  firmid      VARCHAR2(32) not null,
  customerid  VARCHAR2(40) not null,
  quantity    NUMBER(10) not null,
  applytype   NUMBER(2) not null,
  status      NUMBER(2) not null,
  createtime  DATE not null,
  creator     VARCHAR2(20) not null,
  remark1     VARCHAR2(256),
  modifytime  DATE,
  modifier    VARCHAR2(20),
  remark2     VARCHAR2(256)
)
;
alter table T_E_APPLYGAGE
  add constraint PK_T_E_APPLYGAGE primary key (APPLYID);

prompt
prompt Creating table T_E_APPLYTREATYSETTLE
prompt ====================================
prompt
create table T_E_APPLYTREATYSETTLE
(
  applyid      NUMBER(15) not null,
  commodityid  VARCHAR2(16) not null,
  customerid_s VARCHAR2(40),
  customerid_b VARCHAR2(40),
  price        NUMBER(10,2),
  quantity     NUMBER(10) not null,
  status       NUMBER(2) not null,
  createtime   DATE not null,
  creator      VARCHAR2(20) not null,
  remark1      VARCHAR2(256),
  modifytime   DATE,
  modifier     VARCHAR2(20),
  remark2      VARCHAR2(256)
)
;
alter table T_E_APPLYTREATYSETTLE
  add constraint PK_T_E_APPLYTREATYSETTLE primary key (APPLYID);

prompt
prompt Creating table T_E_DEDUCTDETAIL
prompt ===============================
prompt
create table T_E_DEDUCTDETAIL
(
  deductid        NUMBER(10) not null,
  customerid      VARCHAR2(40) not null,
  wl              CHAR(1),
  buyqty          NUMBER(10),
  sellqty         NUMBER(10),
  buykeepqty      NUMBER(10),
  sellkeepqty     NUMBER(10),
  pureholdqty     NUMBER(10),
  pl              NUMBER(15,2),
  pl_ratio        NUMBER(10,3),
  counteractqty   NUMBER(10),
  orderqty        NUMBER(10),
  deductableqty   NUMBER(10),
  estimateqty     NUMBER(10,2),
  deductqty       NUMBER(10),
  deductedqty     NUMBER(10),
  counteractedqty NUMBER(10)
)
;
alter table T_E_DEDUCTDETAIL
  add constraint PK_T_E_DEDUCTDETAIL primary key (DEDUCTID, CUSTOMERID);

prompt
prompt Creating table T_E_DEDUCTKEEP
prompt =============================
prompt
create table T_E_DEDUCTKEEP
(
  deductid   NUMBER(10) not null,
  bs_flag    NUMBER(2) not null,
  customerid VARCHAR2(40) not null,
  keepqty    NUMBER(10) not null
)
;
alter table T_E_DEDUCTKEEP
  add constraint PK_T_E_DEDUCTKEEP primary key (DEDUCTID, BS_FLAG, CUSTOMERID);

prompt
prompt Creating table T_E_DEDUCTPOSITION
prompt =================================
prompt
create table T_E_DEDUCTPOSITION
(
  deductid       NUMBER(10) not null,
  deductdate     DATE not null,
  commodityid    VARCHAR2(16) not null,
  deductstatus   CHAR(1) default 'N' not null,
  deductprice    NUMBER(10,2) not null,
  loserbsflag    NUMBER(1) not null,
  losermode      NUMBER(1) not null,
  lossrate       NUMBER(5,2) not null,
  selfcounteract NUMBER(1) not null,
  profitlvl1     NUMBER(5,3) default 0 not null,
  profitlvl2     NUMBER(5,3) default 0 not null,
  profitlvl3     NUMBER(5,3) default 0 not null,
  profitlvl4     NUMBER(5,3) default 0 not null,
  profitlvl5     NUMBER(5,3) default 0 not null,
  exectime       DATE,
  alert          VARCHAR2(1024)
)
;
alter table T_E_DEDUCTPOSITION
  add constraint PK_T_E_DEDUCTPOSITION primary key (DEDUCTID);

prompt
prompt Creating table T_E_DIRECTFIRMBREED
prompt ==================================
prompt
create table T_E_DIRECTFIRMBREED
(
  firmid  VARCHAR2(32) not null,
  breedid NUMBER(10) not null
)
;
alter table T_E_DIRECTFIRMBREED
  add constraint PK_T_E_DIRECTFIRMBREED primary key (FIRMID, BREEDID);

prompt
prompt Creating table T_E_GAGEBILL
prompt ===========================
prompt
create table T_E_GAGEBILL
(
  id          NUMBER(20) not null,
  firmid      VARCHAR2(32) not null,
  commodityid VARCHAR2(16) not null,
  quantity    NUMBER(10) not null,
  remark      VARCHAR2(256),
  createtime  DATE not null,
  modifytime  DATE not null
)
;
alter table T_E_GAGEBILL
  add constraint PK_T_E_GAGEBILL primary key (ID);

prompt
prompt Creating table T_E_HISGAGEBILL
prompt ==============================
prompt
create table T_E_HISGAGEBILL
(
  cleardate   DATE not null,
  id          NUMBER(20) not null,
  firmid      VARCHAR2(32) not null,
  commodityid VARCHAR2(16) not null,
  quantity    NUMBER(10) not null,
  remark      VARCHAR2(256),
  createtime  DATE not null,
  modifytime  DATE not null
)
;
alter table T_E_HISGAGEBILL
  add constraint PK_T_E_HISGAGEBILL primary key (CLEARDATE, ID);

prompt
prompt Creating table T_E_PLEDGE
prompt =========================
prompt
create table T_E_PLEDGE
(
  id         NUMBER(15) not null,
  billid     VARCHAR2(32) not null,
  billfund   NUMBER(15,2) default 0 not null,
  firmid     VARCHAR2(32) not null,
  breedname  VARCHAR2(32) not null,
  quantity   NUMBER(10) not null,
  createtime DATE not null,
  creator    VARCHAR2(20) not null,
  modifytime DATE,
  modifier   VARCHAR2(20),
  status     NUMBER(2) default 0 not null,
  type       NUMBER(2) not null
)
;
alter table T_E_PLEDGE
  add constraint PK_T_E_PLEDGE primary key (ID);

prompt
prompt Creating table T_FIRM
prompt =====================
prompt
create table T_FIRM
(
  firmid              VARCHAR2(32) not null,
  status              NUMBER(2) not null,
  maxholdqty          NUMBER(10) default -1 not null,
  mincleardeposit     NUMBER(15,2) default 0 not null,
  maxoverdraft        NUMBER(15,2) default 0 not null,
  virtualfunds        NUMBER(15,2) default 0 not null,
  runtimefl           NUMBER(15,2) default 0 not null,
  clearfl             NUMBER(15,2) default 0 not null,
  runtimemargin       NUMBER(15,2) default 0 not null,
  clearmargin         NUMBER(15,2) default 0 not null,
  runtimeassure       NUMBER(15,2) default 0 not null,
  clearassure         NUMBER(15,2) default 0 not null,
  runtimesettlemargin NUMBER(15,2) default 0 not null,
  clearsettlemargin   NUMBER(15,2) default 0 not null,
  tariffid            VARCHAR2(6) default 'none' not null,
  modifytime          DATE not null
)
;
comment on column T_FIRM.firmid
  is '������ID';
comment on column T_FIRM.status
  is '״̬';
comment on column T_FIRM.maxholdqty
  is '���ֲ���';
comment on column T_FIRM.mincleardeposit
  is '��ͽ���׼����';
comment on column T_FIRM.maxoverdraft
  is '���͸֧���';
comment on column T_FIRM.virtualfunds
  is '�����ʽ�';
comment on column T_FIRM.runtimefl
  is '��ʱ����';
comment on column T_FIRM.clearfl
  is '���㸡��';
comment on column T_FIRM.runtimemargin
  is '��ʱ���ױ�֤��';
comment on column T_FIRM.clearmargin
  is '���㽻�ױ�֤��';
comment on column T_FIRM.runtimeassure
  is '��ʱ������';
comment on column T_FIRM.clearassure
  is '���㵣����';
comment on column T_FIRM.runtimesettlemargin
  is '���ս��ձ�֤��';
comment on column T_FIRM.clearsettlemargin
  is '���ս��ձ�֤��';
comment on column T_FIRM.tariffid
  is '�ײ�ID';
comment on column T_FIRM.modifytime
  is '�޸�ʱ��';
alter table T_FIRM
  add constraint PK_T_FIRM primary key (FIRMID);

prompt
prompt Creating table T_FIRMHOLDSUM
prompt ============================
prompt
create table T_FIRMHOLDSUM
(
  firmid       VARCHAR2(32) not null,
  commodityid  VARCHAR2(16) not null,
  bs_flag      NUMBER(2) not null,
  holdqty      NUMBER(10) not null,
  holdfunds    NUMBER(15,2) not null,
  floatingloss NUMBER(15,2) not null,
  evenprice    NUMBER(16,6) not null,
  holdmargin   NUMBER(15,2) default 0 not null,
  gageqty      NUMBER(10) default 0 not null,
  holdassure   NUMBER(15,2) default 0 not null
)
;
comment on table T_FIRMHOLDSUM
  is '�����ֲֻ̳���';
comment on column T_FIRMHOLDSUM.firmid
  is '������ID';
comment on column T_FIRMHOLDSUM.commodityid
  is '��Ʒ����';
comment on column T_FIRMHOLDSUM.bs_flag
  is '������־';
comment on column T_FIRMHOLDSUM.holdqty
  is '�ֲ�����';
comment on column T_FIRMHOLDSUM.holdfunds
  is '�ֽ��';
comment on column T_FIRMHOLDSUM.floatingloss
  is '����ӯ��';
comment on column T_FIRMHOLDSUM.evenprice
  is '�ֲ־���';
comment on column T_FIRMHOLDSUM.holdmargin
  is 'ʵʱ��֤��';
comment on column T_FIRMHOLDSUM.gageqty
  is '�ֶ�����';
comment on column T_FIRMHOLDSUM.holdassure
  is '�ֲֵ�����';
alter table T_FIRMHOLDSUM
  add constraint PK_T_FIRMHOLDSUM primary key (FIRMID, COMMODITYID, BS_FLAG);

prompt
prompt Creating table T_HOLDFROZEN
prompt ===========================
prompt
create table T_HOLDFROZEN
(
  id          NUMBER(20) not null,
  operation   VARCHAR2(20),
  firmid      VARCHAR2(32) not null,
  customerid  VARCHAR2(40) not null,
  commodityid VARCHAR2(16) not null,
  bs_flag     NUMBER(2) not null,
  frozentype  NUMBER(2),
  frozenqty   NUMBER(15) default 0 not null,
  frozentime  TIMESTAMP(6)
)
;
alter table T_HOLDFROZEN
  add constraint PK_T_HOLDFROZEN primary key (ID);

prompt
prompt Creating table T_HOLDPOSITION
prompt =============================
prompt
create table T_HOLDPOSITION
(
  a_holdno     NUMBER(15) not null,
  a_tradeno    NUMBER(15) not null,
  customerid   VARCHAR2(40) not null,
  commodityid  VARCHAR2(16) not null,
  bs_flag      NUMBER(2) not null,
  price        NUMBER(10,2) not null,
  holdqty      NUMBER(10) not null,
  openqty      NUMBER(10) not null,
  holdtime     DATE not null,
  holdmargin   NUMBER(15,2) default 0 not null,
  firmid       VARCHAR2(32) not null,
  gageqty      NUMBER(10) default 0 not null,
  holdassure   NUMBER(15,2) default 0 not null,
  floatingloss NUMBER(15,2) default 0 not null,
  holdtype     NUMBER(2) default 1 not null,
  atcleardate  DATE default trunc(sysdate) not null,
  deadline     DATE,
  remainday    NUMBER(10)
)
;
comment on column T_HOLDPOSITION.a_holdno
  is '�ֲֵ���';
comment on column T_HOLDPOSITION.a_tradeno
  is '�ɽ���';
comment on column T_HOLDPOSITION.customerid
  is '���׿ͻ�ID';
comment on column T_HOLDPOSITION.commodityid
  is '��Ʒ����';
comment on column T_HOLDPOSITION.bs_flag
  is '������־';
comment on column T_HOLDPOSITION.price
  is '�۸�';
comment on column T_HOLDPOSITION.holdqty
  is '�ֲ����� ';
comment on column T_HOLDPOSITION.openqty
  is '��������';
comment on column T_HOLDPOSITION.holdtime
  is '�ֲ�ʱ�䣨��ȷ���룩';
comment on column T_HOLDPOSITION.holdmargin
  is 'ʵʱ��֤��';
comment on column T_HOLDPOSITION.firmid
  is '������ID';
comment on column T_HOLDPOSITION.gageqty
  is '�ֶ�����';
comment on column T_HOLDPOSITION.holdassure
  is '�ֲֵ�����';
comment on column T_HOLDPOSITION.floatingloss
  is '���������ʽ�';
comment on column T_HOLDPOSITION.holdtype
  is '�ֲ�����';
comment on column T_HOLDPOSITION.atcleardate
  is '����������������';
comment on column T_HOLDPOSITION.deadline
  is '��������';
comment on column T_HOLDPOSITION.remainday
  is '��������';
create index IX_T_HOLDPOSITION on T_HOLDPOSITION (CUSTOMERID, COMMODITYID, BS_FLAG);
create index IX_T_HOLDPOSITION_F_C_B on T_HOLDPOSITION (FIRMID, COMMODITYID, BS_FLAG);
alter table T_HOLDPOSITION
  add constraint PK_T_HOLDPOSITION primary key (A_HOLDNO);

prompt
prompt Creating table T_H_COMMODITY
prompt ============================
prompt
create table T_H_COMMODITY
(
  cleardate             DATE not null,
  commodityid           VARCHAR2(16) not null,
  name                  VARCHAR2(32) not null,
  sortid                NUMBER(10) not null,
  status                NUMBER(2) not null,
  contractfactor        NUMBER(12,2) not null,
  minpricemove          NUMBER(10,2) not null,
  breedid               NUMBER(10) not null,
  spreadalgr            NUMBER(1) not null,
  spreaduplmt           NUMBER(10,2) not null,
  spreaddownlmt         NUMBER(10,2) not null,
  feealgr               NUMBER(1) not null,
  feerate_b             NUMBER(15,9) not null,
  feerate_s             NUMBER(15,9) not null,
  marginalgr            NUMBER(1) not null,
  marginrate_b          NUMBER(10,4) default 0 not null,
  marginrate_s          NUMBER(10,4) default 0 not null,
  marketdate            DATE,
  settledate            DATE not null,
  settledate1           DATE,
  marginitem1           NUMBER(15,2),
  settledate2           DATE,
  marginitem2           NUMBER(15,2),
  settledate3           DATE,
  marginitem3           NUMBER(15,2),
  settledate4           DATE,
  marginitem4           NUMBER(15,2),
  lastprice             NUMBER(10,2) not null,
  marginitem1_s         NUMBER(15,2),
  marginitem2_s         NUMBER(15,2),
  marginitem3_s         NUMBER(15,2),
  marginitem4_s         NUMBER(15,2),
  marginassure_b        NUMBER(10,4) default 0 not null,
  marginassure_s        NUMBER(10,4) default 0 not null,
  marginitemassure1     NUMBER(15,2),
  marginitemassure2     NUMBER(15,2),
  marginitemassure3     NUMBER(15,2),
  marginitemassure4     NUMBER(15,2),
  marginitemassure1_s   NUMBER(15,2),
  marginitemassure2_s   NUMBER(15,2),
  marginitemassure3_s   NUMBER(15,2),
  marginitemassure4_s   NUMBER(15,2),
  todayclosefeerate_b   NUMBER(15,9) default 0 not null,
  todayclosefeerate_s   NUMBER(15,9) default 0 not null,
  historyclosefeerate_b NUMBER(15,9) default 0 not null,
  historyclosefeerate_s NUMBER(15,9) default 0 not null,
  limitcmdtyqty         NUMBER(10) default -1 not null,
  settlefeealgr         NUMBER(1) not null,
  settlefeerate_b       NUMBER(15,9) default 0 not null,
  settlefeerate_s       NUMBER(15,9) default 0 not null,
  forceclosefeealgr     NUMBER(1) not null,
  forceclosefeerate_b   NUMBER(15,9) default 0 not null,
  forceclosefeerate_s   NUMBER(15,9) default 0 not null,
  settlemarginalgr_b    NUMBER(1) not null,
  settlemarginrate_b    NUMBER(10,4) default 0 not null,
  settlemarginalgr_s    NUMBER(1) not null,
  settlemarginrate_s    NUMBER(10,4) default 0 not null,
  reservecount          NUMBER(10) default 0 not null,
  addedtax              NUMBER(10,4) default 0 not null,
  marginpricetype       NUMBER(1) default 0 not null,
  lowestsettlefee       NUMBER(15,2) default 0 not null,
  firmcleanqty          NUMBER(10) default -1 not null,
  firmmaxholdqty        NUMBER(10) default -1 not null,
  payoutalgr            NUMBER(1) not null,
  payoutrate            NUMBER(10,4) default 0 not null,
  addedtaxfactor        NUMBER(13,10) default 0 not null,
  settledate5           DATE,
  marginitem5           NUMBER(15,2),
  marginitem5_s         NUMBER(15,2),
  marginitemassure5     NUMBER(15,2),
  marginitemassure5_s   NUMBER(15,2),
  settlepricetype       NUMBER(2) default 0 not null,
  beforedays            NUMBER(4),
  specsettleprice       NUMBER(10,2),
  orderprivilege_b      NUMBER(6) default 101 not null,
  orderprivilege_s      NUMBER(6) default 101 not null,
  firmmaxholdqtyalgr    NUMBER(1) default 2 not null,
  startpercentqty       NUMBER(10) default 0 not null,
  maxpercentlimit       NUMBER(7,4) default 0 not null,
  onemaxholdqty         NUMBER(10) default -1 not null,
  minquantitymove       NUMBER(3) default 1 not null,
  delayrecouprate       NUMBER(7,5) default 0 not null,
  settleway             NUMBER(2) default 0 not null,
  delayfeeway           NUMBER(2) default 1 not null,
  maxfeerate            NUMBER(15,9),
  minsettlemoveqty      NUMBER(5) default 1 not null,
  storerecouprate       NUMBER(7,5) default 0 not null,
  minsettleqty          NUMBER(10) default 1 not null,
  delayrecouprate_s     NUMBER(7,5) default 0 not null,
  aheadsettlepricetype  NUMBER(2) default 0,
  delaysettlepricetype  NUMBER(2) default 0,
  settlemargintype      NUMBER(2) default 0,
  beforedays_m          NUMBER(2) default 0,
  sideholdlimitqty      NUMBER(10) default -1,
  holddayslimit         NUMBER(1) default 0 not null,
  maxholdpositionday    NUMBER(10),
  taxinclusive          NUMBER(1)
)
;
alter table T_H_COMMODITY
  add constraint PK_T_H_COMMODITY primary key (CLEARDATE, COMMODITYID);

prompt
prompt Creating table T_H_CONDITIONORDER
prompt =================================
prompt
create table T_H_CONDITIONORDER
(
  cleardate            DATE not null,
  a_orderno            NUMBER(15) not null,
  commodityid          VARCHAR2(16) not null,
  customerid           VARCHAR2(40) not null,
  traderid             VARCHAR2(40) not null,
  bs_flag              NUMBER(2) not null,
  ordertype            NUMBER(2) not null,
  price                NUMBER(10,2) not null,
  quantity             NUMBER(10) not null,
  conditiontype        NUMBER(2),
  conditionoperation   NUMBER(2),
  conditionprice       NUMBER(10,2) not null,
  conditioncommodityid VARCHAR2(16) not null,
  firmid               VARCHAR2(32) not null,
  retcode              NUMBER(4),
  updatetime           TIMESTAMP(6),
  validdate            DATE,
  sendstatus           NUMBER(2) default 0 not null,
  successtime          TIMESTAMP(6)
)
;
alter table T_H_CONDITIONORDER
  add constraint PK_T_H_CONDITIONORDER primary key (CLEARDATE, A_ORDERNO);

prompt
prompt Creating table T_H_CUSTOMERHOLDSUM
prompt ==================================
prompt
create table T_H_CUSTOMERHOLDSUM
(
  cleardate     DATE not null,
  customerid    VARCHAR2(40) not null,
  commodityid   VARCHAR2(16) not null,
  bs_flag       NUMBER(2) not null,
  holdqty       NUMBER(10) not null,
  holdfunds     NUMBER(15,2) not null,
  floatingloss  NUMBER(15,2) not null,
  evenprice     NUMBER(16,6) not null,
  frozenqty     NUMBER(10) not null,
  holdmargin    NUMBER(15,2) default 0 not null,
  gageqty       NUMBER(10) default 0 not null,
  holdassure    NUMBER(15,2) default 0 not null,
  firmid        VARCHAR2(32) not null,
  gagefrozenqty NUMBER(10) default 0 not null
)
;
alter table T_H_CUSTOMERHOLDSUM
  add constraint PK_T_H_CUSTOMERHOLDSUM primary key (CLEARDATE, CUSTOMERID, COMMODITYID, BS_FLAG);

prompt
prompt Creating table T_H_DELAYORDERS
prompt ==============================
prompt
create table T_H_DELAYORDERS
(
  cleardate      DATE not null,
  a_orderno      NUMBER(15) not null,
  commodityid    VARCHAR2(16) not null,
  customerid     VARCHAR2(40) not null,
  traderid       VARCHAR2(40),
  bs_flag        NUMBER(2) not null,
  delayordertype NUMBER(2) not null,
  status         NUMBER(2) not null,
  withdrawtype   NUMBER(2),
  quantity       NUMBER(10) not null,
  price          NUMBER(10,2),
  tradeqty       NUMBER(10) default 0,
  frozenfunds    NUMBER(15,2) default 0,
  unfrozenfunds  NUMBER(15,2) default 0,
  ordertime      DATE not null,
  withdrawtime   DATE,
  ordererip      VARCHAR2(64),
  signature      VARCHAR2(256),
  firmid         VARCHAR2(32) not null,
  consignerid    VARCHAR2(10),
  withdrawerid   VARCHAR2(40)
)
;
alter table T_H_DELAYORDERS
  add constraint PK_T_H_DELAYORDERS primary key (CLEARDATE, A_ORDERNO);

prompt
prompt Creating table T_H_DELAYQUOTATION
prompt =================================
prompt
create table T_H_DELAYQUOTATION
(
  cleardate         DATE not null,
  commodityid       VARCHAR2(16) not null,
  buysettleqty      NUMBER(10) not null,
  sellsettleqty     NUMBER(10) not null,
  buyneutralqty     NUMBER(10) not null,
  sellneutralqty    NUMBER(10) not null,
  createtime        DATE,
  neutralside       NUMBER(2) default 0 not null,
  delaycleanholdqty NUMBER(10) default 0 not null
)
;
alter table T_H_DELAYQUOTATION
  add constraint PK_T_H_DELAYQUOTATION primary key (CLEARDATE, COMMODITYID);

prompt
prompt Creating table T_H_DELAYTRADE
prompt =============================
prompt
create table T_H_DELAYTRADE
(
  cleardate      DATE not null,
  a_tradeno      NUMBER(15) not null,
  a_orderno      NUMBER(15) not null,
  tradetime      DATE not null,
  customerid     VARCHAR2(40) not null,
  commodityid    VARCHAR2(16) not null,
  bs_flag        NUMBER(2) not null,
  delayordertype NUMBER(2) not null,
  quantity       NUMBER(10) not null,
  tradetype      NUMBER(2) not null,
  firmid         VARCHAR2(32) not null
)
;
alter table T_H_DELAYTRADE
  add constraint PK_T_H_DELAYTRADE primary key (CLEARDATE, A_TRADENO);

prompt
prompt Creating table T_H_DIRECTFIRMBREED
prompt ==================================
prompt
create table T_H_DIRECTFIRMBREED
(
  deletedate DATE not null,
  firmid     VARCHAR2(32) not null,
  breedid    NUMBER(10) not null
)
;
alter table T_H_DIRECTFIRMBREED
  add constraint PK_T_H_DIRECTFIRMBREED primary key (DELETEDATE, FIRMID, BREEDID);

prompt
prompt Creating table T_H_FIRM
prompt =======================
prompt
create table T_H_FIRM
(
  cleardate           DATE not null,
  firmid              VARCHAR2(32) not null,
  status              NUMBER(2) not null,
  maxholdqty          NUMBER(10) default -1 not null,
  mincleardeposit     NUMBER(15,2) default 0 not null,
  maxoverdraft        NUMBER(15,2) default 0 not null,
  virtualfunds        NUMBER(15,2) default 0 not null,
  runtimefl           NUMBER(15,2) default 0 not null,
  clearfl             NUMBER(15,2) default 0 not null,
  runtimemargin       NUMBER(15,2) default 0 not null,
  clearmargin         NUMBER(15,2) default 0 not null,
  runtimeassure       NUMBER(15,2) default 0 not null,
  clearassure         NUMBER(15,2) default 0 not null,
  runtimesettlemargin NUMBER(15,2) default 0 not null,
  clearsettlemargin   NUMBER(15,2) default 0 not null,
  tariffid            VARCHAR2(6) default 'none' not null,
  modifytime          DATE not null
)
;
alter table T_H_FIRM
  add constraint PK_T_H_FIRM primary key (CLEARDATE, FIRMID);

prompt
prompt Creating table T_H_FIRMFEE
prompt ==========================
prompt
create table T_H_FIRMFEE
(
  cleardate             DATE not null,
  firmid                VARCHAR2(32) not null,
  commodityid           VARCHAR2(16) not null,
  feealgr               NUMBER(1) not null,
  feerate_b             NUMBER(15,9) not null,
  feerate_s             NUMBER(15,9) not null,
  todayclosefeerate_b   NUMBER(15,9) default 0 not null,
  todayclosefeerate_s   NUMBER(15,9) default 0 not null,
  historyclosefeerate_b NUMBER(15,9) default 0 not null,
  historyclosefeerate_s NUMBER(15,9) default 0 not null,
  forceclosefeealgr     NUMBER(1) not null,
  forceclosefeerate_b   NUMBER(15,9) default 0 not null,
  forceclosefeerate_s   NUMBER(15,9) default 0 not null,
  modifytime            DATE not null
)
;
alter table T_H_FIRMFEE
  add constraint PK_T_H_FIRMFEE primary key (CLEARDATE, FIRMID, COMMODITYID);

prompt
prompt Creating table T_H_FIRMHOLDSUM
prompt ==============================
prompt
create table T_H_FIRMHOLDSUM
(
  cleardate    DATE not null,
  firmid       VARCHAR2(32) not null,
  commodityid  VARCHAR2(16) not null,
  bs_flag      NUMBER(2) not null,
  holdqty      NUMBER(10) not null,
  holdfunds    NUMBER(15,2) not null,
  floatingloss NUMBER(15,2) not null,
  evenprice    NUMBER(16,6) not null,
  holdmargin   NUMBER(15,2) default 0 not null,
  gageqty      NUMBER(10) default 0 not null,
  holdassure   NUMBER(15,2) default 0 not null
)
;
alter table T_H_FIRMHOLDSUM
  add constraint PK_T_H_FIRMHOLDSUM primary key (CLEARDATE, FIRMID, COMMODITYID, BS_FLAG);

prompt
prompt Creating table T_H_FIRMMARGIN
prompt =============================
prompt
create table T_H_FIRMMARGIN
(
  cleardate           DATE not null,
  firmid              VARCHAR2(32) not null,
  commodityid         VARCHAR2(16) not null,
  marginalgr          NUMBER(1) not null,
  marginrate_b        NUMBER(10,4) default 0 not null,
  marginrate_s        NUMBER(10,4) default 0 not null,
  marginitem1         NUMBER(15,2),
  marginitem2         NUMBER(15,2),
  marginitem3         NUMBER(15,2),
  marginitem4         NUMBER(15,2),
  marginitem1_s       NUMBER(15,2),
  marginitem2_s       NUMBER(15,2),
  marginitem3_s       NUMBER(15,2),
  marginitem4_s       NUMBER(15,2),
  marginassure_b      NUMBER(10,4) default 0 not null,
  marginassure_s      NUMBER(10,4) default 0 not null,
  marginitemassure1   NUMBER(15,2),
  marginitemassure2   NUMBER(15,2),
  marginitemassure3   NUMBER(15,2),
  marginitemassure4   NUMBER(15,2),
  marginitemassure1_s NUMBER(15,2),
  marginitemassure2_s NUMBER(15,2),
  marginitemassure3_s NUMBER(15,2),
  marginitemassure4_s NUMBER(15,2),
  modifytime          DATE not null,
  marginitem5         NUMBER(15,2),
  marginitem5_s       NUMBER(15,2),
  marginitemassure5   NUMBER(15,2),
  marginitemassure5_s NUMBER(15,2)
)
;
alter table T_H_FIRMMARGIN
  add constraint PK_T_H_FIRMMARGIN primary key (CLEARDATE, FIRMID, COMMODITYID);

prompt
prompt Creating table T_H_FIRMSETTLEFEE
prompt ================================
prompt
create table T_H_FIRMSETTLEFEE
(
  cleardate       DATE not null,
  firmid          VARCHAR2(32) not null,
  commodityid     VARCHAR2(16) not null,
  settlefeealgr   NUMBER(1) not null,
  settlefeerate_b NUMBER(15,9) default 0 not null,
  settlefeerate_s NUMBER(15,9) default 0 not null,
  modifytime      DATE not null
)
;
alter table T_H_FIRMSETTLEFEE
  add constraint PK_T_H_FIRMSETTLEFEE primary key (CLEARDATE, FIRMID, COMMODITYID);

prompt
prompt Creating table T_H_FIRMSETTLEMARGIN
prompt ===================================
prompt
create table T_H_FIRMSETTLEMARGIN
(
  cleardate          DATE not null,
  firmid             VARCHAR2(32) not null,
  commodityid        VARCHAR2(16) not null,
  settlemarginalgr_b NUMBER(1) not null,
  settlemarginrate_b NUMBER(10,4) default 0 not null,
  settlemarginalgr_s NUMBER(1) not null,
  settlemarginrate_s NUMBER(10,4) default 0 not null,
  payoutalgr         NUMBER(1) not null,
  payoutrate         NUMBER(10,4) default 0 not null,
  modifytime         DATE not null
)
;
alter table T_H_FIRMSETTLEMARGIN
  add constraint PK_T_H_FIRMSETTLEMARGIN primary key (CLEARDATE, FIRMID, COMMODITYID);

prompt
prompt Creating table T_H_HOLDPOSITION
prompt ===============================
prompt
create table T_H_HOLDPOSITION
(
  cleardate    DATE not null,
  a_holdno     NUMBER(15) not null,
  a_tradeno    NUMBER(15) not null,
  customerid   VARCHAR2(40) not null,
  commodityid  VARCHAR2(16) not null,
  bs_flag      NUMBER(2) not null,
  price        NUMBER(10,2) not null,
  holdqty      NUMBER(10) not null,
  openqty      NUMBER(10) not null,
  holdtime     DATE not null,
  holdmargin   NUMBER(15,2) default 0 not null,
  firmid       VARCHAR2(32) not null,
  gageqty      NUMBER(10) default 0 not null,
  holdassure   NUMBER(15,2) default 0 not null,
  floatingloss NUMBER(15,2) default 0 not null,
  holdtype     NUMBER(2) default 1 not null,
  atcleardate  DATE default trunc(sysdate) not null,
  deadline     DATE,
  remainday    NUMBER(10)
)
;
alter table T_H_HOLDPOSITION
  add constraint PK_T_H_HOLDPOSITION primary key (CLEARDATE, A_HOLDNO);

prompt
prompt Creating table T_H_MARKET
prompt =========================
prompt
create table T_H_MARKET
(
  cleardate               DATE not null,
  marketcode              CHAR(2) not null,
  marketname              VARCHAR2(64),
  status                  NUMBER(2) default 1 not null,
  shortname               VARCHAR2(20),
  runmode                 NUMBER(2) default 1 not null,
  settlemode              NUMBER(2) default 0 not null,
  marginfbflag            NUMBER(1) default 0 not null,
  floatinglosscomputetype NUMBER(1) default 0 not null,
  closealgr               NUMBER(2) default 0 not null,
  tradepricealgr          NUMBER(2) default 0 not null,
  tradeflowtype           NUMBER(2) default 0 not null,
  floatingprofitsubtax    NUMBER(1) default 0 not null,
  gagemode                NUMBER(2) default 0 not null,
  tradetimetype           NUMBER(2) default 0 not null,
  delayquoshowtype        NUMBER(2) default 1 not null,
  neutralfeeway           NUMBER(2) default 0 not null,
  delayneedbill           NUMBER(2) default 0 not null,
  neutralflag             NUMBER(2) default 0 not null,
  neutralmatchpriority    NUMBER(2) default 0 not null,
  quotationtwoside        NUMBER(2) default 2 not null,
  asmargintype            NUMBER(2) default 0,
  delayorderispure        NUMBER(1) default 0 not null,
  chargedelayfeetype      NUMBER(2) default 0 not null
)
;
alter table T_H_MARKET
  add constraint PK_T_H_MARKET primary key (CLEARDATE, MARKETCODE);

prompt
prompt Creating table T_H_ORDERS
prompt =========================
prompt
create table T_H_ORDERS
(
  cleardate        DATE not null,
  a_orderno        NUMBER(15) not null,
  a_orderno_w      NUMBER(15),
  commodityid      VARCHAR2(16) not null,
  customerid       VARCHAR2(40) not null,
  traderid         VARCHAR2(40),
  bs_flag          NUMBER(2),
  ordertype        NUMBER(2) not null,
  status           NUMBER(2) not null,
  withdrawtype     NUMBER(2),
  failcode         NUMBER(3),
  quantity         NUMBER(10),
  price            NUMBER(10,2),
  closemode        NUMBER(2),
  specprice        NUMBER(10,2),
  timeflag         NUMBER(1),
  tradeqty         NUMBER(10),
  frozenfunds      NUMBER(15,2),
  unfrozenfunds    NUMBER(15,2),
  ordertime        DATE,
  withdrawtime     DATE,
  ordererip        VARCHAR2(64),
  signature        VARCHAR2(256),
  closeflag        NUMBER(1),
  firmid           VARCHAR2(32) not null,
  consignerid      VARCHAR2(10),
  withdrawerid     VARCHAR2(40),
  updatetime       TIMESTAMP(6) default systimestamp,
  billtradetype    NUMBER(2) default 0 not null,
  specialorderflag NUMBER(2) default 0
)
;
alter table T_H_ORDERS
  add constraint PK_T_H_ORDERS primary key (CLEARDATE, A_ORDERNO);

prompt
prompt Creating table T_H_QUOTATION
prompt ============================
prompt
create table T_H_QUOTATION
(
  cleardate          DATE not null,
  commodityid        VARCHAR2(16) not null,
  yesterbalanceprice NUMBER(12,4) default 0 not null,
  closeprice         NUMBER(12,4) default 0 not null,
  openprice          NUMBER(12,4) default 0 not null,
  highprice          NUMBER(12,4) default 0 not null,
  lowprice           NUMBER(12,4) default 0 not null,
  curprice           NUMBER(12,4) default 0 not null,
  curamount          NUMBER(10) default 0 not null,
  openamount         NUMBER(10) default 0 not null,
  buyopenamount      NUMBER(10) default 0 not null,
  sellopenamount     NUMBER(10) default 0 not null,
  closeamount        NUMBER(10) default 0 not null,
  buycloseamount     NUMBER(10) default 0 not null,
  sellcloseamount    NUMBER(10) default 0 not null,
  reservecount       NUMBER(10) default 0 not null,
  reservechange      NUMBER(10) default 0 not null,
  price              NUMBER(12,4) default 0 not null,
  totalmoney         NUMBER(15,2) default 0 not null,
  totalamount        NUMBER(10) default 0 not null,
  spread             NUMBER(12,4) default 0 not null,
  buyprice1          NUMBER(12,4) default 0 not null,
  sellprice1         NUMBER(12,4) default 0 not null,
  buyamount1         NUMBER(10) default 0 not null,
  sellamount1        NUMBER(10) default 0 not null,
  buyprice2          NUMBER(12,4) default 0,
  sellprice2         NUMBER(12,4) default 0,
  buyamount2         NUMBER(10) default 0,
  sellamount2        NUMBER(10) default 0,
  buyprice3          NUMBER(12,4) default 0,
  sellprice3         NUMBER(12,4) default 0,
  buyamount3         NUMBER(10) default 0,
  sellamount3        NUMBER(10) default 0,
  buyprice4          NUMBER(12,4) default 0,
  sellprice4         NUMBER(12,4) default 0,
  buyamount4         NUMBER(10) default 0,
  sellamount4        NUMBER(10) default 0,
  buyprice5          NUMBER(12,4) default 0,
  sellprice5         NUMBER(12,4) default 0,
  buyamount5         NUMBER(10) default 0,
  sellamount5        NUMBER(10) default 0,
  buyprice6          NUMBER(12,4) default 0,
  sellprice6         NUMBER(12,4) default 0,
  buyamount6         NUMBER(10) default 0,
  sellamount6        NUMBER(10) default 0,
  buyprice7          NUMBER(12,4) default 0,
  sellprice7         NUMBER(12,4) default 0,
  buyamount7         NUMBER(10) default 0,
  sellamount7        NUMBER(10) default 0,
  buyprice8          NUMBER(12,4) default 0,
  sellprice8         NUMBER(12,4) default 0,
  buyamount8         NUMBER(10) default 0,
  sellamount8        NUMBER(10) default 0,
  buyprice9          NUMBER(12,4) default 0,
  sellprice9         NUMBER(12,4) default 0,
  buyamount9         NUMBER(10) default 0,
  sellamount9        NUMBER(10) default 0,
  buyprice10         NUMBER(12,4) default 0,
  sellprice10        NUMBER(12,4) default 0,
  buyamount10        NUMBER(10) default 0,
  sellamount         NUMBER(10) default 0,
  outamount          NUMBER(10) default 0,
  inamount           NUMBER(10) default 0,
  tradecue           NUMBER(10) default 0,
  no                 NUMBER(10) default 0,
  createtime         TIMESTAMP(6)
)
;
alter table T_H_QUOTATION
  add constraint PK_T_H_QUOTATION primary key (CLEARDATE, COMMODITYID);

prompt
prompt Creating table T_H_TRADE
prompt ========================
prompt
create table T_H_TRADE
(
  cleardate        DATE not null,
  a_tradeno        NUMBER(15) not null,
  m_tradeno        NUMBER(15) not null,
  a_orderno        NUMBER(15),
  a_tradeno_closed NUMBER(15),
  tradetime        DATE,
  customerid       VARCHAR2(32) not null,
  commodityid      VARCHAR2(16) not null,
  bs_flag          NUMBER(2) not null,
  ordertype        NUMBER(2) not null,
  price            NUMBER(10,2) not null,
  quantity         NUMBER(10),
  close_pl         NUMBER(15,2),
  tradefee         NUMBER(15,2),
  tradetype        NUMBER(2) not null,
  holdprice        NUMBER(10,2),
  holdtime         DATE,
  firmid           VARCHAR2(32) not null,
  closeaddedtax    NUMBER(15,2) default 0,
  m_tradeno_opp    NUMBER(15) not null,
  atcleardate      DATE default trunc(sysdate) not null,
  tradeatcleardate DATE default trunc(sysdate) not null,
  oppfirmid        VARCHAR2(32) not null
)
;
alter table T_H_TRADE
  add constraint PK_T_H_TRADE primary key (CLEARDATE, A_TRADENO);

prompt
prompt Creating table T_MATCHSETTLEHOLDRELEVANCE
prompt =========================================
prompt
create table T_MATCHSETTLEHOLDRELEVANCE
(
  matchid      VARCHAR2(12) not null,
  settleid     NUMBER(15) not null,
  quantity     NUMBER(10) default 0 not null,
  price        NUMBER(15,2) default 0 not null,
  settlepayout NUMBER(15,2) not null,
  settlemargin NUMBER(15,2) not null
)
;
alter table T_MATCHSETTLEHOLDRELEVANCE
  add constraint PK_T_MATCHSETTLEHOLDRELEVANCE primary key (MATCHID, SETTLEID);

prompt
prompt Creating table T_ORDERS
prompt =======================
prompt
create table T_ORDERS
(
  a_orderno        NUMBER(15) not null,
  a_orderno_w      NUMBER(15),
  commodityid      VARCHAR2(16) not null,
  customerid       VARCHAR2(40) not null,
  traderid         VARCHAR2(40),
  bs_flag          NUMBER(2),
  ordertype        NUMBER(2) not null,
  status           NUMBER(2) not null,
  withdrawtype     NUMBER(2),
  failcode         NUMBER(3),
  quantity         NUMBER(10),
  price            NUMBER(10,2),
  closemode        NUMBER(2),
  specprice        NUMBER(10,2),
  timeflag         NUMBER(1),
  tradeqty         NUMBER(10),
  frozenfunds      NUMBER(15,2),
  unfrozenfunds    NUMBER(15,2),
  ordertime        DATE,
  withdrawtime     DATE,
  ordererip        VARCHAR2(64),
  signature        VARCHAR2(256),
  closeflag        NUMBER(1),
  firmid           VARCHAR2(32) not null,
  consignerid      VARCHAR2(10),
  withdrawerid     VARCHAR2(40),
  updatetime       TIMESTAMP(6) default systimestamp,
  billtradetype    NUMBER(2) default 0 not null,
  specialorderflag NUMBER(2) default 0
)
;
comment on column T_ORDERS.a_orderno
  is '����';
comment on column T_ORDERS.a_orderno_w
  is 'ί�е���';
comment on column T_ORDERS.commodityid
  is '��Ʒ����';
comment on column T_ORDERS.customerid
  is '���׿ͻ�ID';
comment on column T_ORDERS.traderid
  is '����ԱID';
comment on column T_ORDERS.bs_flag
  is '������־';
comment on column T_ORDERS.ordertype
  is 'ί������';
comment on column T_ORDERS.status
  is '״̬';
comment on column T_ORDERS.withdrawtype
  is '��������';
comment on column T_ORDERS.failcode
  is 'ί��ʧ�ܴ���';
comment on column T_ORDERS.quantity
  is '����';
comment on column T_ORDERS.price
  is 'ί�м۸�';
comment on column T_ORDERS.closemode
  is 'ƽ�ַ�ʽ';
comment on column T_ORDERS.specprice
  is '�۸�';
comment on column T_ORDERS.timeflag
  is 'ָ��ʱ���־';
comment on column T_ORDERS.tradeqty
  is '�ѳɽ�����';
comment on column T_ORDERS.frozenfunds
  is '�����ʽ�';
comment on column T_ORDERS.unfrozenfunds
  is '�ⶳ�ʽ�����';
comment on column T_ORDERS.ordertime
  is 'ί��ʱ��';
comment on column T_ORDERS.withdrawtime
  is '����ʱ��';
comment on column T_ORDERS.ordererip
  is 'ί����IP';
comment on column T_ORDERS.signature
  is '��������';
comment on column T_ORDERS.closeflag
  is 'ƽ�ֱ�־';
comment on column T_ORDERS.firmid
  is '������ID';
comment on column T_ORDERS.consignerid
  is 'ί��ԱID';
comment on column T_ORDERS.withdrawerid
  is '����ԱID';
comment on column T_ORDERS.updatetime
  is '����ʱ��';
comment on column T_ORDERS.billtradetype
  is '�ֵ���������';
comment on column T_ORDERS.specialorderflag
  is '�������';
create index IX_T_ORDERS on T_ORDERS (FIRMID);
alter table T_ORDERS
  add constraint PK_T_ORDERS primary key (A_ORDERNO);

prompt
prompt Creating table T_QUOTATION
prompt ==========================
prompt
create table T_QUOTATION
(
  commodityid        VARCHAR2(16) not null,
  yesterbalanceprice NUMBER(12,4) default 0 not null,
  closeprice         NUMBER(12,4) default 0 not null,
  openprice          NUMBER(12,4) default 0 not null,
  highprice          NUMBER(12,4) default 0 not null,
  lowprice           NUMBER(12,4) default 0 not null,
  curprice           NUMBER(12,4) default 0 not null,
  curamount          NUMBER(10) default 0 not null,
  openamount         NUMBER(10) default 0 not null,
  buyopenamount      NUMBER(10) default 0 not null,
  sellopenamount     NUMBER(10) default 0 not null,
  closeamount        NUMBER(10) default 0 not null,
  buycloseamount     NUMBER(10) default 0 not null,
  sellcloseamount    NUMBER(10) default 0 not null,
  reservecount       NUMBER(10) default 0 not null,
  reservechange      NUMBER(10) default 0 not null,
  price              NUMBER(12,4) default 0 not null,
  totalmoney         NUMBER(15,2) default 0 not null,
  totalamount        NUMBER(10) default 0 not null,
  spread             NUMBER(12,4) default 0 not null,
  buyprice1          NUMBER(12,4) default 0 not null,
  sellprice1         NUMBER(12,4) default 0 not null,
  buyamount1         NUMBER(10) default 0 not null,
  sellamount1        NUMBER(10) default 0 not null,
  buyprice2          NUMBER(12,4) default 0,
  sellprice2         NUMBER(12,4) default 0,
  buyamount2         NUMBER(10) default 0,
  sellamount2        NUMBER(10) default 0,
  buyprice3          NUMBER(12,4) default 0,
  sellprice3         NUMBER(12,4) default 0,
  buyamount3         NUMBER(10) default 0,
  sellamount3        NUMBER(10) default 0,
  buyprice4          NUMBER(12,4) default 0,
  sellprice4         NUMBER(12,4) default 0,
  buyamount4         NUMBER(10) default 0,
  sellamount4        NUMBER(10) default 0,
  buyprice5          NUMBER(12,4) default 0,
  sellprice5         NUMBER(12,4) default 0,
  buyamount5         NUMBER(10) default 0,
  sellamount5        NUMBER(10) default 0,
  buyprice6          NUMBER(12,4) default 0,
  sellprice6         NUMBER(12,4) default 0,
  buyamount6         NUMBER(10) default 0,
  sellamount6        NUMBER(10) default 0,
  buyprice7          NUMBER(12,4) default 0,
  sellprice7         NUMBER(12,4) default 0,
  buyamount7         NUMBER(10) default 0,
  sellamount7        NUMBER(10) default 0,
  buyprice8          NUMBER(12,4) default 0,
  sellprice8         NUMBER(12,4) default 0,
  buyamount8         NUMBER(10) default 0,
  sellamount8        NUMBER(10) default 0,
  buyprice9          NUMBER(12,4) default 0,
  sellprice9         NUMBER(12,4) default 0,
  buyamount9         NUMBER(10) default 0,
  sellamount9        NUMBER(10) default 0,
  buyprice10         NUMBER(12,4) default 0,
  sellprice10        NUMBER(12,4) default 9,
  buyamount10        NUMBER(10) default 0,
  sellamount10       NUMBER(10) default 0,
  outamount          NUMBER(10) default 0,
  inamount           NUMBER(10) default 0,
  tradecue           NUMBER(10) default 0,
  no                 NUMBER(10) default 0,
  createtime         TIMESTAMP(6)
)
;
comment on column T_QUOTATION.commodityid
  is '��Ʒ����';
comment on column T_QUOTATION.yesterbalanceprice
  is '������';
comment on column T_QUOTATION.closeprice
  is '�����̼�';
comment on column T_QUOTATION.openprice
  is '���г�';
comment on column T_QUOTATION.highprice
  is '��߼�';
comment on column T_QUOTATION.lowprice
  is '��ͼ�';
comment on column T_QUOTATION.curprice
  is '���¼�';
comment on column T_QUOTATION.curamount
  is '���¼�����Ӧ�ĳɽ���';
comment on column T_QUOTATION.openamount
  is '����';
comment on column T_QUOTATION.buyopenamount
  is '�򿪲�';
comment on column T_QUOTATION.sellopenamount
  is '������';
comment on column T_QUOTATION.closeamount
  is 'ƽ��';
comment on column T_QUOTATION.buycloseamount
  is '��ƽ��';
comment on column T_QUOTATION.sellcloseamount
  is '��ƽ��';
comment on column T_QUOTATION.reservecount
  is '���鶩����';
comment on column T_QUOTATION.reservechange
  is '�ֲ�';
comment on column T_QUOTATION.price
  is '�����';
comment on column T_QUOTATION.totalmoney
  is '�ܳɽ���';
comment on column T_QUOTATION.totalamount
  is '�ܳɽ���';
comment on column T_QUOTATION.spread
  is '�ǵ�';
comment on column T_QUOTATION.buyprice1
  is '�����1';
comment on column T_QUOTATION.sellprice1
  is '������1';
comment on column T_QUOTATION.buyamount1
  is '������1';
comment on column T_QUOTATION.sellamount1
  is '������1';
comment on column T_QUOTATION.buyprice2
  is '�����2';
comment on column T_QUOTATION.sellprice2
  is '������2';
comment on column T_QUOTATION.buyamount2
  is '������2';
comment on column T_QUOTATION.sellamount2
  is '������2';
comment on column T_QUOTATION.buyprice3
  is '�����3';
comment on column T_QUOTATION.sellprice3
  is '������3';
comment on column T_QUOTATION.buyamount3
  is '������3';
comment on column T_QUOTATION.sellamount3
  is '������3';
comment on column T_QUOTATION.buyprice4
  is '�����4';
comment on column T_QUOTATION.sellprice4
  is '������4';
comment on column T_QUOTATION.buyamount4
  is '������4';
comment on column T_QUOTATION.sellamount4
  is '������4';
comment on column T_QUOTATION.buyprice5
  is '�����5';
comment on column T_QUOTATION.sellprice5
  is '������5';
comment on column T_QUOTATION.buyamount5
  is '������5';
comment on column T_QUOTATION.sellamount5
  is '������5';
comment on column T_QUOTATION.buyprice6
  is '�����6';
comment on column T_QUOTATION.sellprice6
  is '������6';
comment on column T_QUOTATION.buyamount6
  is '������6';
comment on column T_QUOTATION.sellamount6
  is '������6';
comment on column T_QUOTATION.buyprice7
  is '�����7';
comment on column T_QUOTATION.sellprice7
  is '������7';
comment on column T_QUOTATION.buyamount7
  is '������7';
comment on column T_QUOTATION.sellamount7
  is '������7';
comment on column T_QUOTATION.buyprice8
  is '�����8';
comment on column T_QUOTATION.sellprice8
  is '������8';
comment on column T_QUOTATION.buyamount8
  is '������8';
comment on column T_QUOTATION.sellamount8
  is '������8';
comment on column T_QUOTATION.buyprice9
  is '�����9';
comment on column T_QUOTATION.sellprice9
  is '������9';
comment on column T_QUOTATION.buyamount9
  is '������9';
comment on column T_QUOTATION.sellamount9
  is '������9';
comment on column T_QUOTATION.buyprice10
  is '�����10';
comment on column T_QUOTATION.sellprice10
  is '������10';
comment on column T_QUOTATION.buyamount10
  is '������10';
comment on column T_QUOTATION.sellamount10
  is '������10';
comment on column T_QUOTATION.outamount
  is '����';
comment on column T_QUOTATION.inamount
  is '����';
comment on column T_QUOTATION.tradecue
  is '������ʾ';
comment on column T_QUOTATION.no
  is '�����ֶ�';
comment on column T_QUOTATION.createtime
  is '����ʱ��';
alter table T_QUOTATION
  add constraint PK_T_QUOTATION primary key (COMMODITYID);

prompt
prompt Creating table T_RMICONF
prompt ========================
prompt
create table T_RMICONF
(
  serviceid   NUMBER(2) not null,
  cnname      VARCHAR2(64),
  ename       VARCHAR2(64),
  hostip      VARCHAR2(16) not null,
  port        NUMBER(6) not null,
  rmidataport NUMBER(6) not null,
  enabled     CHAR(1) not null
)
;
alter table T_RMICONF
  add constraint PK_T_RMICONF primary key (SERVICEID);

prompt
prompt Creating table T_SETTLEANDHOLD
prompt ==============================
prompt
create table T_SETTLEANDHOLD
(
  settleholdpositionid NUMBER(15),
  matchid              VARCHAR2(12),
  tax                  NUMBER(15,2),
  bs_flag              NUMBER(2)
)
;
comment on column T_SETTLEANDHOLD.settleholdpositionid
  is '���ս��׿ͻ��ֲ���ϸ��id';
comment on column T_SETTLEANDHOLD.matchid
  is '������Ա��';
comment on column T_SETTLEANDHOLD.tax
  is '˰��';
comment on column T_SETTLEANDHOLD.bs_flag
  is '�������1��2��';

prompt
prompt Creating table T_SETTLECOMMODITY
prompt ================================
prompt
create table T_SETTLECOMMODITY
(
  settleprocessdate     DATE not null,
  commodityid           VARCHAR2(16) not null,
  name                  VARCHAR2(32) not null,
  sortid                NUMBER(10) not null,
  status                NUMBER(2) not null,
  contractfactor        NUMBER(12,2) not null,
  minpricemove          NUMBER(10,2) not null,
  breedid               NUMBER(10) not null,
  spreadalgr            NUMBER(1) not null,
  spreaduplmt           NUMBER(10,2) not null,
  spreaddownlmt         NUMBER(10,2) not null,
  feealgr               NUMBER(1) not null,
  feerate_b             NUMBER(15,9) not null,
  feerate_s             NUMBER(15,9) not null,
  marginalgr            NUMBER(1) not null,
  marginrate_b          NUMBER(10,4) default 0 not null,
  marginrate_s          NUMBER(10,4) default 0 not null,
  marketdate            DATE,
  settledate            DATE not null,
  settledate1           DATE,
  marginitem1           NUMBER(15,2),
  settledate2           DATE,
  marginitem2           NUMBER(15,2),
  settledate3           DATE,
  marginitem3           NUMBER(15,2),
  settledate4           DATE,
  marginitem4           NUMBER(15,2),
  lastprice             NUMBER(10,2) not null,
  marginitem1_s         NUMBER(15,2),
  marginitem2_s         NUMBER(15,2),
  marginitem3_s         NUMBER(15,2),
  marginitem4_s         NUMBER(15,2),
  marginassure_b        NUMBER(10,4) default 0 not null,
  marginassure_s        NUMBER(10,4) default 0 not null,
  marginitemassure1     NUMBER(15,2),
  marginitemassure2     NUMBER(15,2),
  marginitemassure3     NUMBER(15,2),
  marginitemassure4     NUMBER(15,2),
  marginitemassure1_s   NUMBER(15,2),
  marginitemassure2_s   NUMBER(15,2),
  marginitemassure3_s   NUMBER(15,2),
  marginitemassure4_s   NUMBER(15,2),
  todayclosefeerate_b   NUMBER(15,9) default 0 not null,
  todayclosefeerate_s   NUMBER(15,9) default 0 not null,
  historyclosefeerate_b NUMBER(15,9) default 0 not null,
  historyclosefeerate_s NUMBER(15,9) default 0 not null,
  limitcmdtyqty         NUMBER(10) default -1 not null,
  settlefeealgr         NUMBER(1) not null,
  settlefeerate_b       NUMBER(15,9) default 0 not null,
  settlefeerate_s       NUMBER(15,9) default 0 not null,
  forceclosefeealgr     NUMBER(1) not null,
  forceclosefeerate_b   NUMBER(15,9) default 0 not null,
  forceclosefeerate_s   NUMBER(15,9) default 0 not null,
  settlemarginalgr_b    NUMBER(1) not null,
  settlemarginrate_b    NUMBER(10,4) default 0 not null,
  settlemarginalgr_s    NUMBER(1) not null,
  settlemarginrate_s    NUMBER(10,4) default 0 not null,
  reservecount          NUMBER(10) default 0 not null,
  addedtax              NUMBER(10,4) default 0 not null,
  marginpricetype       NUMBER(1) default 0 not null,
  lowestsettlefee       NUMBER(15,2) default 0 not null,
  firmcleanqty          NUMBER(10) default -1 not null,
  firmmaxholdqty        NUMBER(10) default -1 not null,
  payoutalgr            NUMBER(1) not null,
  payoutrate            NUMBER(10,4) default 0 not null,
  addedtaxfactor        NUMBER(13,10) default 0 not null,
  settledate5           DATE,
  marginitem5           NUMBER(15,2),
  marginitem5_s         NUMBER(15,2),
  marginitemassure5     NUMBER(15,2),
  marginitemassure5_s   NUMBER(15,2),
  settlepricetype       NUMBER(2) default 0 not null,
  beforedays            NUMBER(4),
  specsettleprice       NUMBER(10,2),
  orderprivilege_b      NUMBER(6) default 101 not null,
  orderprivilege_s      NUMBER(6) default 101 not null,
  firmmaxholdqtyalgr    NUMBER(1) default 2 not null,
  startpercentqty       NUMBER(10) default 0 not null,
  maxpercentlimit       NUMBER(7,4) default 0 not null,
  onemaxholdqty         NUMBER(10) default -1 not null,
  minquantitymove       NUMBER(3) default 1 not null,
  delayrecouprate       NUMBER(7,5) default 0 not null,
  settleway             NUMBER(2) default 0 not null,
  delayfeeway           NUMBER(2) default 1 not null,
  maxfeerate            NUMBER(15,9),
  minsettlemoveqty      NUMBER(5) default 1 not null,
  storerecouprate       NUMBER(7,5) default 0 not null,
  minsettleqty          NUMBER(10) default 1 not null,
  delayrecouprate_s     NUMBER(7,5) default 0 not null,
  aheadsettlepricetype  NUMBER(2) default 0,
  delaysettlepricetype  NUMBER(2) default 0,
  settlemargintype      NUMBER(2) default 0,
  beforedays_m          NUMBER(2) default 0,
  sideholdlimitqty      NUMBER(10) default -1,
  holddayslimit         NUMBER(1) default 0 not null,
  maxholdpositionday    NUMBER(10),
  taxinclusive          NUMBER(1)
)
;
alter table T_SETTLECOMMODITY
  add primary key (SETTLEPROCESSDATE, COMMODITYID);

prompt
prompt Creating table T_SETTLEHOLDPOSITION
prompt ===================================
prompt
create table T_SETTLEHOLDPOSITION
(
  id                      NUMBER(15) not null,
  settleprocessdate       DATE not null,
  a_holdno                NUMBER(15) not null,
  a_tradeno               NUMBER(15) not null,
  customerid              VARCHAR2(40) not null,
  commodityid             VARCHAR2(16) not null,
  bs_flag                 NUMBER(2) not null,
  price                   NUMBER(10,2) not null,
  holdqty                 NUMBER(10) not null,
  openqty                 NUMBER(10) not null,
  holdtime                DATE not null,
  holdmargin              NUMBER(15,2) default 0 not null,
  firmid                  VARCHAR2(32) not null,
  gageqty                 NUMBER(10) default 0 not null,
  holdassure              NUMBER(15,2) default 0 not null,
  floatingloss            NUMBER(15,2) default 0 not null,
  settlemargin            NUMBER(15,2) default 0 not null,
  payout                  NUMBER(15,2) default 0 not null,
  settlefee               NUMBER(15,2) default 0 not null,
  settle_pl               NUMBER(15,2) default 0 not null,
  settleaddedtax          NUMBER(15,2) default 0 not null,
  settleprice             NUMBER(16,6) not null,
  settletype              NUMBER(2) not null,
  holdtype                NUMBER(2) default 1 not null,
  atcleardate             DATE default trunc(sysdate) not null,
  matchquantity           NUMBER(10) default 0,
  matchstatus             NUMBER(2) default 0 not null,
  happenmatchqty          NUMBER(10) default 0 not null,
  happenmatchpayout       NUMBER(15,2) default 0 not null,
  happenmatchsettlemargin NUMBER(15,2) default 0 not null
)
;
create index IX_T_SETTLEHOLDPOSITION on T_SETTLEHOLDPOSITION (SETTLEPROCESSDATE, COMMODITYID);
alter table T_SETTLEHOLDPOSITION
  add constraint PK_T_SETTLEHOLDPOSITION primary key (ID);

prompt
prompt Creating table T_SETTLEMATCH
prompt ============================
prompt
create table T_SETTLEMATCH
(
  matchid        VARCHAR2(12) not null,
  commodityid    VARCHAR2(16) not null,
  contractfactor NUMBER(12,2) not null,
  quantity       NUMBER(10) not null,
  hl_amount      NUMBER(15,2) default 0 not null,
  status         NUMBER(2) default 0 not null,
  result         NUMBER(1) not null,
  settletype     NUMBER(2) not null,
  firmid_b       VARCHAR2(32) not null,
  buyprice       NUMBER(15,6) not null,
  buypayout_ref  NUMBER(15,2) default 0 not null,
  buypayout      NUMBER(15,2) default 0 not null,
  buymargin      NUMBER(15,2) default 0 not null,
  takepenalty_b  NUMBER(15,2) default 0 not null,
  paypenalty_b   NUMBER(15,2) default 0 not null,
  settlepl_b     NUMBER(15,2) default 0 not null,
  firmid_s       VARCHAR2(32) not null,
  sellprice      NUMBER(15,6) not null,
  sellincome_ref NUMBER(15,2) default 0 not null,
  sellincome     NUMBER(15,2) default 0 not null,
  sellmargin     NUMBER(15,2) default 0 not null,
  takepenalty_s  NUMBER(15,2) default 0 not null,
  paypenalty_s   NUMBER(15,2) default 0 not null,
  settlepl_s     NUMBER(15,2) default 0 not null,
  createtime     DATE not null,
  modifytime     DATE not null,
  settledate     DATE not null,
  modifier       VARCHAR2(64),
  istransfer     NUMBER(2) default 0 not null,
  buytax         NUMBER(15,2) default 0,
  taxincluesive  NUMBER(1) default 0
)
;
comment on column T_SETTLEMATCH.buytax
  is '����˰��';
comment on column T_SETTLEMATCH.taxincluesive
  is '��Ʒ�Ƿ�˰,0Ĭ�Ϻ�˰��1Ϊ����˰';
alter table T_SETTLEMATCH
  add primary key (MATCHID);

prompt
prompt Creating table T_SETTLEMATCHFUNDMANAGE
prompt ======================================
prompt
create table T_SETTLEMATCHFUNDMANAGE
(
  id          NUMBER(15) not null,
  matchid     VARCHAR2(12) not null,
  firmid      VARCHAR2(32) not null,
  summaryno   VARCHAR2(5) not null,
  amount      NUMBER(15,2) not null,
  operatedate DATE not null,
  commodityid VARCHAR2(16)
)
;

prompt
prompt Creating table T_SETTLEMATCHLOG
prompt ===============================
prompt
create table T_SETTLEMATCHLOG
(
  id         NUMBER(20) not null,
  matchid    VARCHAR2(12) not null,
  operator   VARCHAR2(32) not null,
  operatelog VARCHAR2(2048) not null,
  updatetime TIMESTAMP(6)
)
;
alter table T_SETTLEMATCHLOG
  add constraint PK_T_SETTLEMATCHLOG primary key (ID);

prompt
prompt Creating table T_SETTLEPROPS
prompt ============================
prompt
create table T_SETTLEPROPS
(
  id            NUMBER(15) not null,
  commodityid   VARCHAR2(16) not null,
  propertyname  VARCHAR2(64) not null,
  propertyvalue VARCHAR2(1000),
  note          VARCHAR2(2000)
)
;
alter table T_SETTLEPROPS
  add constraint PK_T_SETTLEPROPS primary key (ID);

prompt
prompt Creating table T_SPECFROZENHOLD
prompt ===============================
prompt
create table T_SPECFROZENHOLD
(
  id        NUMBER(15) not null,
  a_holdno  NUMBER(15) not null,
  a_orderno NUMBER(15),
  frozenqty NUMBER(10) not null
)
;
alter table T_SPECFROZENHOLD
  add constraint PK_T_SPECFROZENHOLD primary key (ID);

prompt
prompt Creating table T_SUBSYSTEM
prompt ==========================
prompt
create table T_SUBSYSTEM
(
  moduleid NUMBER(2) not null,
  enabled  CHAR(1) not null
)
;
alter table T_SUBSYSTEM
  add constraint PK_T_SUBSYSTEM primary key (MODULEID);

prompt
prompt Creating table T_SYSTEMSTATUS
prompt =============================
prompt
create table T_SYSTEMSTATUS
(
  tradedate   DATE not null,
  status      NUMBER(2) default 3 not null,
  sectionid   NUMBER(4),
  note        VARCHAR2(256),
  recovertime VARCHAR2(10)
)
;
alter table T_SYSTEMSTATUS
  add constraint PK_T_SYSTEMSTATUS primary key (TRADEDATE);

prompt
prompt Creating table T_TRADE
prompt ======================
prompt
create table T_TRADE
(
  a_tradeno        NUMBER(15) not null,
  m_tradeno        NUMBER(15) not null,
  a_orderno        NUMBER(15),
  a_tradeno_closed NUMBER(15),
  tradetime        DATE,
  customerid       VARCHAR2(40) not null,
  commodityid      VARCHAR2(16) not null,
  bs_flag          NUMBER(2) not null,
  ordertype        NUMBER(2) not null,
  price            NUMBER(10,2) not null,
  quantity         NUMBER(10),
  close_pl         NUMBER(15,2),
  tradefee         NUMBER(15,2),
  tradetype        NUMBER(2) not null,
  holdprice        NUMBER(10,2),
  holdtime         DATE,
  firmid           VARCHAR2(32) not null,
  closeaddedtax    NUMBER(15,2) default 0,
  m_tradeno_opp    NUMBER(15) not null,
  atcleardate      DATE default trunc(sysdate) not null,
  tradeatcleardate DATE default trunc(sysdate) not null,
  oppfirmid        VARCHAR2(32) not null
)
;
comment on column T_TRADE.a_tradeno
  is '�ɽ���';
comment on column T_TRADE.a_orderno
  is 'ί�е���';
comment on column T_TRADE.tradetime
  is '�ɽ�ʱ��';
comment on column T_TRADE.customerid
  is '���׿ͻ�ID';
comment on column T_TRADE.commodityid
  is '��Ʒ����';
comment on column T_TRADE.bs_flag
  is '������־ 1:�� buy 2:�� sell';
comment on column T_TRADE.ordertype
  is 'ί������';
comment on column T_TRADE.price
  is '�۸�';
comment on column T_TRADE.quantity
  is '����';
comment on column T_TRADE.close_pl
  is 'ƽ��ӯ��';
comment on column T_TRADE.tradefee
  is '��������';
comment on column T_TRADE.tradetype
  is '�ɽ�����';
comment on column T_TRADE.holdprice
  is '�����۸�';
comment on column T_TRADE.holdtime
  is '����ʱ��';
comment on column T_TRADE.firmid
  is '������ID';
comment on column T_TRADE.closeaddedtax
  is 'ƽ����ֵ˰';
create index IX_T_TRADE on T_TRADE (M_TRADENO);
alter table T_TRADE
  add constraint PK_T_TRADE primary key (A_TRADENO);

prompt
prompt Creating table T_TRADEDAYS
prompt ==========================
prompt
create table T_TRADEDAYS
(
  day DATE not null
)
;
alter table T_TRADEDAYS
  add constraint PK_T_TRADEDAYS primary key (DAY);

prompt
prompt Creating table T_TRADER
prompt =======================
prompt
create table T_TRADER
(
  traderid    VARCHAR2(40) not null,
  operatecode VARCHAR2(2048),
  modifytime  DATE not null
)
;
alter table T_TRADER
  add constraint PK_T_TRADER primary key (TRADERID);

prompt
prompt Creating table T_UNTRADETRANSFER
prompt ================================
prompt
create table T_UNTRADETRANSFER
(
  transferid   NUMBER(10) not null,
  customerid_s VARCHAR2(40) not null,
  customerid_b VARCHAR2(40) not null,
  commodityid  VARCHAR2(16) not null,
  bs_flag      NUMBER(2) not null,
  type         NUMBER(2) not null,
  quantity     NUMBER(10) default 0 not null,
  status       NUMBER(2) default 0 not null,
  createtime   DATE default sysdate not null,
  modifytime   DATE default sysdate not null
)
;
alter table T_UNTRADETRANSFER
  add constraint PK_T_UNTRADETRANSFER primary key (TRANSFERID);

prompt
prompt Creating table T_VALIDGAGEBILL
prompt ==============================
prompt
create table T_VALIDGAGEBILL
(
  firmid      VARCHAR2(32) not null,
  commodityid VARCHAR2(16) not null,
  quantity    NUMBER(10) not null,
  frozenqty   NUMBER(10) not null
)
;
alter table T_VALIDGAGEBILL
  add constraint PK_T_VALIDGAGEBILL primary key (FIRMID, COMMODITYID);

prompt
prompt Creating table V_BARGAIN
prompt ========================
prompt
create table V_BARGAIN
(
  contractid     NUMBER(10) not null,
  tradepartition NUMBER(3) default 1 not null,
  section        NUMBER(5) not null,
  submitid       NUMBER(12) not null,
  code           VARCHAR2(64) not null,
  commodityid    VARCHAR2(64) not null,
  price          NUMBER(12,2) not null,
  amount         NUMBER(16,6) not null,
  userid         VARCHAR2(32) not null,
  tradetime      DATE default trunc(sysdate),
  b_bail         NUMBER(12,2) default 0 not null,
  s_bail         NUMBER(12,2) default 0 not null,
  b_poundage     NUMBER(12,2) default 0 not null,
  s_poundage     NUMBER(12,2) default 0 not null
)
;
alter table V_BARGAIN
  add primary key (CONTRACTID);

prompt
prompt Creating table V_COMMEXT
prompt ========================
prompt
create table V_COMMEXT
(
  id          NUMBER(10) not null,
  code        VARCHAR2(64) not null,
  attributeid NUMBER(10) not null,
  attribute   VARCHAR2(64) not null,
  value       VARCHAR2(128) not null
)
;
alter table V_COMMEXT
  add primary key (ID);

prompt
prompt Creating table V_COMMODITY
prompt ==========================
prompt
create table V_COMMODITY
(
  code               VARCHAR2(64) not null,
  tradepartition     NUMBER(3) default 1 not null,
  firsttime          DATE not null,
  commodityid        VARCHAR2(128) not null,
  createtime         DATE not null,
  status             NUMBER(3) default 2 not null,
  breedid            NUMBER(10) not null,
  splitid            VARCHAR2(512) default 0 not null,
  userid             VARCHAR2(32) not null,
  amount             NUMBER(16,6) not null,
  tradeunit          NUMBER(16,6) default 0.000001 not null,
  minamount          NUMBER(16,6) not null,
  maxamount          NUMBER(16,6) not null,
  flowamountalgr     NUMBER(2) default 0 not null,
  flowamount         NUMBER(16,6) default 0.000001 not null,
  beginprice         NUMBER(15,2) not null,
  alertprice         NUMBER(15,2) default -1,
  stepprice          NUMBER(15,2) not null,
  maxstepprice       NUMBER(15,2) not null,
  marginalgr         NUMBER(2) not null,
  b_security         NUMBER(15,4) not null,
  s_security         NUMBER(15,4) not null,
  feealgr            NUMBER(2) not null,
  b_fee              NUMBER(15,5) not null,
  s_fee              NUMBER(15,5) not null,
  authorization      NUMBER(2) default 0 not null,
  isorder            NUMBER(2) default 0 not null,
  bs_flag            NUMBER(2),
  tendertradeconfirm NUMBER(2) default 0 not null,
  auditstatus        NUMBER(2) default 0 not null,
  audituser          VARCHAR2(128),
  audittime          DATE,
  remark             VARCHAR2(256)
)
;
alter table V_COMMODITY
  add primary key (CODE);

prompt
prompt Creating table V_COMMODITYPARAMS
prompt ================================
prompt
create table V_COMMODITYPARAMS
(
  tradepartition NUMBER(3) default 1 not null,
  breedid        NUMBER(10) not null,
  tradeunit      NUMBER(16,6) not null,
  minamount      NUMBER(16,6) not null,
  maxamount      NUMBER(16,6) not null,
  stepprice      NUMBER(15,2) not null,
  maxstepprice   NUMBER(15,2) not null,
  marginalgr     NUMBER(2) not null,
  b_security     NUMBER(15,4) not null,
  s_security     NUMBER(15,4) not null,
  feealgr        NUMBER(2) not null,
  b_fee          NUMBER(15,5) not null,
  s_fee          NUMBER(15,5) not null,
  flowamountalgr NUMBER(2) default 0 not null,
  flowamount     NUMBER(16,6) default 0.000001 not null
)
;
alter table V_COMMODITYPARAMS
  add primary key (TRADEPARTITION, BREEDID);

prompt
prompt Creating table V_COMMODITYSELF
prompt ==============================
prompt
create table V_COMMODITYSELF
(
  partitionid NUMBER(3) not null,
  usercode    VARCHAR2(32) not null,
  code        VARCHAR2(64) not null,
  time        DATE not null
)
;
alter table V_COMMODITYSELF
  add primary key (PARTITIONID, USERCODE, CODE);

prompt
prompt Creating table V_CONTRACTTEMPLET
prompt ================================
prompt
create table V_CONTRACTTEMPLET
(
  id      NUMBER(5) not null,
  breedid NUMBER(10) not null,
  name    VARCHAR2(128),
  templet CLOB not null
)
;
alter table V_CONTRACTTEMPLET
  add primary key (ID);

prompt
prompt Creating table V_CURCOMMODITY
prompt =============================
prompt
create table V_CURCOMMODITY
(
  code           VARCHAR2(64) not null,
  tradepartition NUMBER(3) default 1 not null,
  commodityid    VARCHAR2(128) not null,
  section        NUMBER(3),
  bargaintype    NUMBER(2) default 0 not null,
  modifytime     DATE not null
)
;
alter table V_CURCOMMODITY
  add primary key (CODE);

prompt
prompt Creating table V_CURSUBMIT
prompt ==========================
prompt
create table V_CURSUBMIT
(
  id             NUMBER(12) not null,
  tradepartition NUMBER(3) default 1 not null,
  code           VARCHAR2(64) not null,
  price          NUMBER(12,2) default 0 not null,
  amount         NUMBER(16,6) default 0 not null,
  traderid       VARCHAR2(40) not null,
  userid         VARCHAR2(32) not null,
  submittime     DATE not null,
  ordertype      NUMBER(3) not null,
  validamount    NUMBER(16,6) default 0 not null,
  modifytime     TIMESTAMP(6) default systimestamp(6),
  frozenmargin   NUMBER(15,2) default 0 not null,
  frozenfee      NUMBER(15,2) default 0 not null,
  unfrozenmargin NUMBER(15,2) default 0 not null,
  unfrozenfee    NUMBER(15,2) default 0 not null,
  withdrawtype   NUMBER(2)
)
;
alter table V_CURSUBMIT
  add primary key (ID);

prompt
prompt Creating table V_CURSUBMITTENDER
prompt ================================
prompt
create table V_CURSUBMITTENDER
(
  id             NUMBER(12) not null,
  tradepartition NUMBER(3) default 1 not null,
  code           VARCHAR2(64) not null,
  price          NUMBER(12,2) default 0 not null,
  amount         NUMBER(16,6) default 0 not null,
  traderid       VARCHAR2(40) not null,
  userid         VARCHAR2(32) not null,
  submittime     DATE not null,
  ordertype      NUMBER(3) not null,
  validamount    NUMBER(16,6) default 0 not null,
  modifytime     TIMESTAMP(6) default systimestamp(6),
  frozenmargin   NUMBER(15,2) default 0 not null,
  frozenfee      NUMBER(15,2) default 0 not null,
  unfrozenmargin NUMBER(15,2) default 0 not null,
  unfrozenfee    NUMBER(15,2) default 0 not null,
  withdrawtype   NUMBER(2)
)
;
alter table V_CURSUBMITTENDER
  add primary key (ID);

prompt
prompt Creating table V_CURSUBMITTENDERPLAN
prompt ====================================
prompt
create table V_CURSUBMITTENDERPLAN
(
  id             NUMBER(12) not null,
  tradepartition NUMBER(3) default 1 not null,
  code           VARCHAR2(64) not null,
  price          NUMBER(12,2) default 0 not null,
  amount         NUMBER(16,6) default 0 not null,
  confirmamount  NUMBER(16,6) default 0 not null,
  traderid       VARCHAR2(40) not null,
  userid         VARCHAR2(32) not null,
  submittime     DATE not null,
  ordertype      NUMBER(3) not null,
  validamount    NUMBER(16,6) default 0 not null,
  modifytime     TIMESTAMP(6) default systimestamp(6),
  frozenmargin   NUMBER(15,2) default 0 not null,
  frozenfee      NUMBER(15,2) default 0 not null,
  unfrozenmargin NUMBER(15,2) default 0 not null,
  unfrozenfee    NUMBER(15,2) default 0 not null,
  withdrawtype   NUMBER(2)
)
;
alter table V_CURSUBMITTENDERPLAN
  add primary key (ID);

prompt
prompt Creating table V_FIRMSPECIALFEE
prompt ===============================
prompt
create table V_FIRMSPECIALFEE
(
  usercode   VARCHAR2(32) not null,
  breedid    NUMBER(10) not null,
  bs_flag    NUMBER(2) not null,
  feealgr    NUMBER(2) not null,
  fee        NUMBER(15,5) default 0 not null,
  updatetime TIMESTAMP(6)
)
;
alter table V_FIRMSPECIALFEE
  add primary key (USERCODE, BREEDID, BS_FLAG);

prompt
prompt Creating table V_FIRMSPECIALMARGIN
prompt ==================================
prompt
create table V_FIRMSPECIALMARGIN
(
  usercode   VARCHAR2(32) not null,
  breedid    NUMBER(10) not null,
  bs_flag    NUMBER(2) not null,
  marginalgr NUMBER(2) not null,
  margin     NUMBER(15,4) default 0 not null,
  updatetime TIMESTAMP(6)
)
;
alter table V_FIRMSPECIALMARGIN
  add primary key (USERCODE, BREEDID, BS_FLAG);

prompt
prompt Creating table V_FLOWCONTROL
prompt ============================
prompt
create table V_FLOWCONTROL
(
  tradepartition NUMBER(3) default 1 not null,
  unittype       NUMBER(2) not null,
  unitid         NUMBER(5) not null,
  breedid        NUMBER(10) not null,
  startmode      NUMBER(2) not null,
  starttime      VARCHAR2(32),
  durativetime   NUMBER(8) not null,
  countdownstart VARCHAR2(128),
  countdowntime  VARCHAR2(128),
  quartertime    NUMBER(8) default 0 not null,
  forcedendtime  VARCHAR2(32),
  ismargincount  NUMBER(2) default 0 not null
)
;
alter table V_FLOWCONTROL
  add primary key (TRADEPARTITION, UNITTYPE, UNITID);

prompt
prompt Creating table V_FUNDFROZEN
prompt ===========================
prompt
create table V_FUNDFROZEN
(
  id           NUMBER(10) not null,
  userid       VARCHAR2(32) not null,
  code         VARCHAR2(64) not null,
  frozenmargin NUMBER(15,2) default 0 not null,
  frozenfee    NUMBER(15,2) default 0 not null,
  frozentime   TIMESTAMP(6) not null
)
;
alter table V_FUNDFROZEN
  add primary key (ID);

prompt
prompt Creating table V_HISBARGAIN
prompt ===========================
prompt
create table V_HISBARGAIN
(
  tradedate      DATE not null,
  contractid     NUMBER(10) not null,
  tradepartition NUMBER(3) default 1 not null,
  section        NUMBER(5) not null,
  submitid       NUMBER(12) not null,
  code           VARCHAR2(64) not null,
  commodityid    VARCHAR2(64) not null,
  price          NUMBER(12,2) not null,
  amount         NUMBER(16,6) not null,
  userid         VARCHAR2(32) not null,
  tradetime      DATE default trunc(sysdate),
  b_bail         NUMBER(12,2) default 0 not null,
  b_unfrozenbail NUMBER(12,2) default 0 not null,
  s_bail         NUMBER(12,2) default 0 not null,
  s_unfrozenbail NUMBER(12,2) default 0 not null,
  b_poundage     NUMBER(12,2) default 0 not null,
  s_poundage     NUMBER(12,2) default 0 not null,
  status         NUMBER(3) default -1,
  result         NUMBER(2) default 0,
  b_payments     NUMBER(15,2) default 0 not null,
  s_payments     NUMBER(15,2) default 0 not null,
  b_referpayment NUMBER(15,2) default 0 not null,
  s_referpayment NUMBER(15,2) default 0 not null,
  b_dedit        NUMBER(15,2) default 0 not null,
  s_dedit        NUMBER(15,2) default 0 not null,
  processingtime TIMESTAMP(6),
  remark         VARCHAR2(500)
)
;
alter table V_HISBARGAIN
  add primary key (TRADEDATE, CONTRACTID);

prompt
prompt Creating table V_HISCOMMODITY
prompt =============================
prompt
create table V_HISCOMMODITY
(
  tradedate      DATE not null,
  code           VARCHAR2(64) not null,
  tradepartition NUMBER(3) default 1 not null,
  commodityid    VARCHAR2(128) not null,
  section        NUMBER(5),
  bargaintype    NUMBER(2) default 0 not null,
  modifytime     DATE not null
)
;
alter table V_HISCOMMODITY
  add primary key (TRADEDATE, CODE);

prompt
prompt Creating table V_HISSUBMIT
prompt ==========================
prompt
create table V_HISSUBMIT
(
  tradedate      DATE not null,
  id             NUMBER(12) not null,
  tradepartition NUMBER(3) default 1 not null,
  code           VARCHAR2(64) not null,
  price          NUMBER(12,2) default 0 not null,
  amount         NUMBER(16,6) default 0 not null,
  userid         VARCHAR2(32) not null,
  traderid       VARCHAR2(40) not null,
  submittime     DATE not null,
  ordertype      NUMBER(3) not null,
  validamount    NUMBER(16,6) default 0,
  modifytime     TIMESTAMP(0) default systimestamp(6),
  frozenmargin   NUMBER(15,2) default 0 not null,
  frozenfee      NUMBER(15,2) default 0 not null,
  unfrozenmargin NUMBER(15,2) default 0 not null,
  unfrozenfee    NUMBER(15,2) default 0 not null,
  withdrawtype   NUMBER(2)
)
;
alter table V_HISSUBMIT
  add primary key (TRADEDATE, ID);

prompt
prompt Creating table V_HISTRADEAUTHORITY
prompt ==================================
prompt
create table V_HISTRADEAUTHORITY
(
  tradedate DATE not null,
  code      VARCHAR2(64) not null,
  usercode  VARCHAR2(32) not null,
  modiftime DATE not null
)
;
alter table V_HISTRADEAUTHORITY
  add primary key (TRADEDATE, CODE, USERCODE);

prompt
prompt Creating table V_HISTRADEUSER
prompt =============================
prompt
create table V_HISTRADEUSER
(
  tradedate       DATE not null,
  usercode        VARCHAR2(32) not null,
  overdraft       NUMBER(10,2) default 0 not null,
  isentry         NUMBER(2) default 0 not null,
  tradecount      NUMBER(8) default 0 not null,
  limits          NUMBER(2) default 3 not null,
  iscontinueorder NUMBER(2) default 0 not null,
  modifytime      DATE default sysdate
)
;
alter table V_HISTRADEUSER
  add primary key (TRADEDATE, USERCODE);

prompt
prompt Creating table V_SECTIONATTRIBUTE
prompt =================================
prompt
create table V_SECTIONATTRIBUTE
(
  id            NUMBER(10) not null,
  partitionid   NUMBER(3) not null,
  unitid        NUMBER(5) not null,
  breedid       NUMBER(10) not null,
  attributeid   NUMBER(10),
  attributename VARCHAR2(128),
  num           NUMBER(10),
  updatetime    TIMESTAMP(6)
)
;
alter table V_SECTIONATTRIBUTE
  add primary key (ID);

prompt
prompt Creating table V_SYSCURSTATUS
prompt =============================
prompt
create table V_SYSCURSTATUS
(
  tradepartition NUMBER(3) default 1 not null,
  status         NUMBER(3) not null,
  section        NUMBER(8) not null,
  modifytime     DATE not null,
  starttime      DATE,
  endtime        DATE,
  isclose        NUMBER(2) default 0 not null
)
;
alter table V_SYSCURSTATUS
  add primary key (TRADEPARTITION);

prompt
prompt Creating table V_SYSLOG
prompt =======================
prompt
create table V_SYSLOG
(
  id         NUMBER(15) not null,
  userid     VARCHAR2(16) not null,
  action     NUMBER(2),
  createtime DATE,
  note       VARCHAR2(2000)
)
;
alter table V_SYSLOG
  add primary key (ID);

prompt
prompt Creating table V_SYSPARTITION
prompt =============================
prompt
create table V_SYSPARTITION
(
  partitionid           NUMBER(3) not null,
  firmlimitclass        VARCHAR2(256) not null,
  validetcommodityclass VARCHAR2(256) not null,
  traderuleclass        VARCHAR2(256) not null,
  bargainactionclass    VARCHAR2(256) not null,
  kernelengineclass     VARCHAR2(256) not null,
  countdownclass        VARCHAR2(256) not null,
  validflag             NUMBER(3) not null,
  description           VARCHAR2(128),
  trademode             NUMBER(3) not null,
  selfrate              NUMBER(10) default 0 not null,
  isshowquotation       NUMBER(2) default 0,
  maxshowqty            NUMBER(5) default 3 not null,
  countmode             NUMBER(2) default 0 not null,
  ismargincount         NUMBER(2) default 0 not null,
  issplittarget         NUMBER(2) default 0 not null,
  isshowprice           NUMBER(2) default 0 not null
)
;
alter table V_SYSPARTITION
  add primary key (PARTITIONID);

prompt
prompt Creating table V_SYSPROPERTY
prompt ============================
prompt
create table V_SYSPROPERTY
(
  tradepartition NUMBER(3) default 1 not null,
  durativetime   NUMBER(8) not null,
  spacetime      NUMBER(6) not null,
  countdownstart VARCHAR2(128) not null,
  countdowntime  VARCHAR2(128) not null,
  breedid        NUMBER(10)
)
;
alter table V_SYSPROPERTY
  add primary key (TRADEPARTITION);

prompt
prompt Creating table V_TEMPLETCLASSSET
prompt ================================
prompt
create table V_TEMPLETCLASSSET
(
  id    NUMBER(10) not null,
  class VARCHAR2(256) not null,
  type  NUMBER(2) not null,
  name  VARCHAR2(256) not null
)
;
alter table V_TEMPLETCLASSSET
  add primary key (ID);

prompt
prompt Creating table V_TRADEAUTHORITY
prompt ===============================
prompt
create table V_TRADEAUTHORITY
(
  code      VARCHAR2(64) not null,
  usercode  VARCHAR2(32) not null,
  modiftime DATE not null
)
;
alter table V_TRADEAUTHORITY
  add primary key (CODE, USERCODE);

prompt
prompt Creating table V_TRADEMODEPARAMS
prompt ================================
prompt
create table V_TRADEMODEPARAMS
(
  id   NUMBER(10) not null,
  name VARCHAR2(32) not null
)
;
alter table V_TRADEMODEPARAMS
  add primary key (ID);

prompt
prompt Creating table V_TRADEUSER
prompt ==========================
prompt
create table V_TRADEUSER
(
  usercode        VARCHAR2(32) not null,
  overdraft       NUMBER(10,2) default 0 not null,
  isentry         NUMBER(2) default 0 not null,
  tradecount      NUMBER(8) default 0 not null,
  limits          NUMBER(2) default 3 not null,
  iscontinueorder NUMBER(2) default 0 not null,
  modifytime      DATE default sysdate
)
;
alter table V_TRADEUSER
  add primary key (USERCODE);

prompt
prompt Creating table W_ERRORLOGINLOG
prompt ==============================
prompt
create table W_ERRORLOGINLOG
(
  errorloginid NUMBER(15) not null,
  userid       VARCHAR2(32) not null,
  logindate    DATE not null,
  warehouseid  VARCHAR2(32) not null,
  ip           VARCHAR2(32)
)
;
comment on column W_ERRORLOGINLOG.userid
  is '����ԱId';
alter table W_ERRORLOGINLOG
  add primary key (ERRORLOGINID);

prompt
prompt Creating table W_GLOBALLOG_ALL
prompt ==============================
prompt
create table W_GLOBALLOG_ALL
(
  id             NUMBER(15) not null,
  operator       VARCHAR2(32),
  warehouseid    VARCHAR2(32),
  operatetime    DATE default sysdate,
  operatetype    NUMBER(4),
  operateip      VARCHAR2(32),
  operatortype   VARCHAR2(32),
  mark           VARCHAR2(4000),
  operatecontent VARCHAR2(4000),
  currentvalue   VARCHAR2(4000),
  operateresult  NUMBER(1) default 0,
  logtype        NUMBER(2)
)
;
comment on column W_GLOBALLOG_ALL.id
  is 'ID';
comment on column W_GLOBALLOG_ALL.operator
  is '������';
comment on column W_GLOBALLOG_ALL.operatetime
  is '����ʱ��';
comment on column W_GLOBALLOG_ALL.operatetype
  is '��������';
comment on column W_GLOBALLOG_ALL.operateip
  is '����IP';
comment on column W_GLOBALLOG_ALL.operatortype
  is '����������';
comment on column W_GLOBALLOG_ALL.mark
  is '��ʾ';
comment on column W_GLOBALLOG_ALL.operatecontent
  is '��������';
comment on column W_GLOBALLOG_ALL.currentvalue
  is '��ǰֵ';
comment on column W_GLOBALLOG_ALL.operateresult
  is '������� 1 �ɹ�  0 ʧ��';
alter table W_GLOBALLOG_ALL
  add primary key (ID);
alter table W_GLOBALLOG_ALL
  add constraint RC_W_GLOBALLOG_ALL
  check (operateresult in(0,1));

prompt
prompt Creating table W_GLOBALLOG_ALL_H
prompt ================================
prompt
create table W_GLOBALLOG_ALL_H
(
  id             NUMBER(15) not null,
  operator       VARCHAR2(32),
  warehouseid    VARCHAR2(32),
  operatetime    DATE,
  operatetype    NUMBER(4),
  operateip      VARCHAR2(32),
  operatortype   VARCHAR2(32),
  mark           VARCHAR2(4000),
  operatecontent VARCHAR2(4000),
  currentvalue   VARCHAR2(4000),
  operateresult  NUMBER(1) default 0,
  logtype        NUMBER(2)
)
;
comment on column W_GLOBALLOG_ALL_H.id
  is 'ID';
comment on column W_GLOBALLOG_ALL_H.operator
  is '������';
comment on column W_GLOBALLOG_ALL_H.operatetime
  is '����ʱ��';
comment on column W_GLOBALLOG_ALL_H.operatetype
  is '��������';
comment on column W_GLOBALLOG_ALL_H.operateip
  is '����IP';
comment on column W_GLOBALLOG_ALL_H.operatortype
  is '����������';
comment on column W_GLOBALLOG_ALL_H.mark
  is '��ʾ';
comment on column W_GLOBALLOG_ALL_H.operatecontent
  is '��������';
comment on column W_GLOBALLOG_ALL_H.currentvalue
  is '��ǰֵ';
comment on column W_GLOBALLOG_ALL_H.operateresult
  is '������� 1 �ɹ�  0 ʧ��';
alter table W_GLOBALLOG_ALL_H
  add constraint RC_W_GLOBALLOG_ALL_H
  check (operateresult in(0,1));

prompt
prompt Creating table W_LOGCATALOG
prompt ===========================
prompt
create table W_LOGCATALOG
(
  catalogid   NUMBER(4) not null,
  moduleid    NUMBER(2) not null,
  catalogname VARCHAR2(32)
)
;
comment on table W_LOGCATALOG
  is '��־���࣬4λ���ֵı��룬����־ģ��ID��ͷ��';
comment on column W_LOGCATALOG.catalogid
  is '��־����ID��4λ���ֵı��룬�����עNotes��';
comment on column W_LOGCATALOG.catalogname
  is '��־������';
alter table W_LOGCATALOG
  add primary key (CATALOGID);

prompt
prompt Creating table W_MYMENU
prompt =======================
prompt
create table W_MYMENU
(
  userid  VARCHAR2(32) not null,
  rightid NUMBER(10) not null
)
;
alter table W_MYMENU
  add primary key (USERID, RIGHTID);

prompt
prompt Creating table W_RIGHT
prompt ======================
prompt
create table W_RIGHT
(
  id           NUMBER(10) not null,
  parentid     NUMBER(10),
  name         VARCHAR2(128),
  moduleid     NUMBER(2) not null,
  icon         VARCHAR2(128),
  authorityurl VARCHAR2(512),
  visiturl     VARCHAR2(512),
  seq          NUMBER(3),
  visible      NUMBER(1),
  type         NUMBER(1) not null,
  catalogid    NUMBER(4),
  iswritelog   VARCHAR2(1) default 'N'
)
;
comment on column W_RIGHT.id
  is ' �淶��
1����ͷ��λΪϵͳģ���
2: ������λΪһ���˵�
3��������λΪ�����˵�
4�����߰�λΪ�����˵�
5���ھ�ʮλΪҳ���е���ɾ�Ĳ�
';
comment on column W_RIGHT.parentid
  is '������';
comment on column W_RIGHT.name
  is 'Ȩ������';
comment on column W_RIGHT.icon
  is 'ͼ��';
comment on column W_RIGHT.authorityurl
  is 'Ȩ��·��';
comment on column W_RIGHT.visiturl
  is '��ʵ·��';
comment on column W_RIGHT.seq
  is '���';
comment on column W_RIGHT.visible
  is '�Ƿ�ɼ�-1 ���ɼ�0 �ɼ�';
comment on column W_RIGHT.type
  is '����-3:ֻ���session�����Ȩ�޵�url -2�������ж�Ȩ�޵�URL -1�� ���˵����� 0���Ӳ˵����� 1��ҳ������ɾ�Ĳ�Ȩ��';
comment on column W_RIGHT.catalogid
  is '��־���� 0��д��־ ������Ӧ��w_logcatalog ��CATALOGID�ֶ�';
comment on column W_RIGHT.iswritelog
  is '''Y''��д��־��''N''����д��־';
alter table W_RIGHT
  add primary key (ID);
alter table W_RIGHT
  add constraint CHECK_W_RIGHT_TYPE
  check (TYPE in (-3,-2,-1,0,1));
alter table W_RIGHT
  add constraint CHECK_W_RIGHT_VISIBLE
  check (VISIBLE in (-1,0));

prompt
prompt Creating table W_ROLE
prompt =====================
prompt
create table W_ROLE
(
  id          NUMBER(10) not null,
  name        VARCHAR2(32) not null,
  warehouseid VARCHAR2(32) not null,
  description VARCHAR2(256)
)
;
comment on column W_ROLE.id
  is '��ɫId';
comment on column W_ROLE.name
  is '��ɫ����';
comment on column W_ROLE.description
  is '����';
alter table W_ROLE
  add primary key (ID);

prompt
prompt Creating table W_ROLE_RIGHT
prompt ===========================
prompt
create table W_ROLE_RIGHT
(
  rightid NUMBER(10) not null,
  roleid  NUMBER(10) not null
)
;
comment on column W_ROLE_RIGHT.rightid
  is 'Ȩ��Id';
comment on column W_ROLE_RIGHT.roleid
  is '��ɫId';
alter table W_ROLE_RIGHT
  add primary key (RIGHTID, ROLEID);

prompt
prompt Creating table W_TRADEMODULE
prompt ============================
prompt
create table W_TRADEMODULE
(
  moduleid           NUMBER(2) not null,
  cnname             VARCHAR2(64) not null,
  enname             VARCHAR2(64),
  shortname          VARCHAR2(16),
  addfirmfn          VARCHAR2(36),
  updatefirmstatusfn VARCHAR2(36),
  delfirmfn          VARCHAR2(36),
  isfirmset          CHAR(1) default 'N' not null,
  hostip             VARCHAR2(16),
  port               NUMBER(6),
  rmidataport        NUMBER(6),
  isbalancecheck     CHAR(1) default 'N' not null,
  isneedbreed        CHAR(1) not null
)
;
comment on column W_TRADEMODULE.moduleid
  is '10�ۺϹ���ƽ̨
11����ϵͳ
12��ֿܲ����ϵͳ
13�ֵ�����ϵͳ
14����ϵͳ
15��������
18Ͷ���������Ʒ����ϵͳ
19���˻�Ա����ϵͳ
20�����̽���ϵͳ
21����ϵͳ
22���н��뼰����ϵͳ
23E�ֻ�
24�����¼ϵͳ
25ʵʱ�������ϵͳ
26���׿ͻ���
98demoϵͳ
99����ϵͳ';
comment on column W_TRADEMODULE.isfirmset
  is '��Y�� �� ��N�� �� (�����Ҫ�ڹ���ǰ̨�ҵ�ƽ̨����ʾ��ϵͳ������Ҫ�ڹ���ϵͳ�� spring_sys_msg.xml �������ϱ�ϵͳ��������Ϣ)';
comment on column W_TRADEMODULE.isbalancecheck
  is 'Y���� N����';
comment on column W_TRADEMODULE.isneedbreed
  is '��ϵͳ�Ƿ���Ҫ�ۺϹ���ƽ̨���ӵ���Ʒ   Y:��   N:��';
alter table W_TRADEMODULE
  add primary key (MODULEID);

prompt
prompt Creating table W_USER
prompt =====================
prompt
create table W_USER
(
  userid      VARCHAR2(32) not null,
  warehouseid VARCHAR2(32) not null,
  name        VARCHAR2(32),
  password    VARCHAR2(32),
  type        VARCHAR2(20) default 'ADMIN' not null,
  description VARCHAR2(256),
  isforbid    CHAR(1) default 'N' not null,
  skin        VARCHAR2(16) default 'default' not null,
  keycode     VARCHAR2(128) default '0123456789ABCDE' not null
)
;
comment on column W_USER.userid
  is '����ԱId';
comment on column W_USER.name
  is '����Ա����';
comment on column W_USER.password
  is '����';
comment on column W_USER.type
  is 'ADMIN����ͨ����Ա��ɫDEFAULT_ADMIN���߼�����Ա��ɫDEFAULT_SUPER_ADMIN��Ĭ�ϳ�������Ա��ɫ';
comment on column W_USER.description
  is '����';
comment on column W_USER.isforbid
  is 'Y������
N��������
';
comment on column W_USER.skin
  is 'Ƥ��';
comment on column W_USER.keycode
  is 'key';
alter table W_USER
  add primary key (USERID);

prompt
prompt Creating table W_USER_RIGHT
prompt ===========================
prompt
create table W_USER_RIGHT
(
  rightid NUMBER(10) not null,
  userid  VARCHAR2(32) not null
)
;
comment on column W_USER_RIGHT.rightid
  is 'Ȩ��Id
Ȩ��Id';
comment on column W_USER_RIGHT.userid
  is '����ԱId';
alter table W_USER_RIGHT
  add primary key (RIGHTID, USERID);

prompt
prompt Creating table W_USER_ROLE
prompt ==========================
prompt
create table W_USER_ROLE
(
  userid VARCHAR2(32) not null,
  roleid NUMBER(10) not null
)
;
comment on column W_USER_ROLE.userid
  is '����ԱId';
comment on column W_USER_ROLE.roleid
  is '��ɫId';
alter table W_USER_ROLE
  add primary key (USERID, ROLEID);


spool off
