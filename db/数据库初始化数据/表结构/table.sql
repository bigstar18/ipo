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
  is '仓单id';
comment on column BI_BUSINESSRELATIONSHIP.buyer
  is '买家';
comment on column BI_BUSINESSRELATIONSHIP.seller
  is '卖家';
comment on column BI_BUSINESSRELATIONSHIP.received
  is '收货状态0否1是';
comment on column BI_BUSINESSRELATIONSHIP.receiveddate
  is '收货时间';
comment on column BI_BUSINESSRELATIONSHIP.selltime
  is '卖出时间';

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
  is '0:申请中 1：拆单成功 2：拆单失败';
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
  is '''Y'' 有效  ''N'' 无效';
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
  is '10综合管理平台
11财务系统
12监管仓库管理系统
13仓单管理系统
14融资系统
15订单交易
18投资类大宗商品交易系统
19加盟会员管理系统
20做市商交易系统
21竞价系统
22银行接入及结算系统
23E现货
24单点登录系统
25实时行情分析系统
26交易客户端
98demo系统
99公用系统';
comment on column BI_FROZENSTOCK.status
  is '0:仓单使用中 1：仓单释放状态';
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
  is '仓单id';
comment on column BI_INVOICEINFORM.invoicetype
  is '发票类型,0/1个人（公司）';
comment on column BI_INVOICEINFORM.companyname
  is '公司名称/单位名称';
comment on column BI_INVOICEINFORM.address
  is '地址';
comment on column BI_INVOICEINFORM.dutyparagraph
  is '税号';
comment on column BI_INVOICEINFORM.bank
  is '开户银行';
comment on column BI_INVOICEINFORM.bankaccount
  is '开户账号';
comment on column BI_INVOICEINFORM.name
  is '收票人姓名';
comment on column BI_INVOICEINFORM.phone
  is '电话';

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
  is '仓单id';
comment on column BI_LOGISTICS.logisticsorder
  is '物流订单';
comment on column BI_LOGISTICS.company
  is '物流公司';

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
  is '0 出库申请 1 撤销出库申请 2 出库完成';
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
  is '10综合管理平台
11财务系统
12监管仓库管理系统
13仓单管理系统
14融资系统
15订单交易
18投资类大宗商品交易系统
19加盟会员管理系统
20做市商交易系统
21竞价系统
22银行接入及结算系统
23E现货
24单点登录系统
25实时行情分析系统
26交易客户端
98demo系统
99公用系统';
comment on column BI_PLEDGESTOCK.status
  is '0:仓单使用中 1：交易成功仓单释放状态';
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
  is '最后一次修改时间';
comment on column BI_STOCK.stockstatus
  is '0:未注册仓单  1：注册仓单  2：已出库仓单  3：已拆单 4：拆仓单处理中 5：出库申请中';
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
  is '0：拆单 1：融资2：卖仓单 3：交收 4：冻结仓单';
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
  is '手续费、保证金等参数设置';
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
  is '10综合管理平台
11财务系统
12监管仓库管理系统
13仓单管理系统
14融资系统
15订单交易
18投资类大宗商品交易系统
19加盟会员管理系统
20做市商交易系统
21竞价系统
22银行接入及结算系统
23E现货
24单点登录系统
25实时行情分析系统
26交易客户端
98demo系统
99公用系统';
comment on column BI_TRADESTOCK.status
  is '0:仓单使用中 1：交易成功仓单释放状态';
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
  is '0 可用 1 不可用';
comment on column BI_WAREHOUSE.rank
  is '1 一星级 2 二星级 3 三星级 4 四星级 5 五星级';
comment on column BI_WAREHOUSE.hasdock
  is '0 有码头 1 没有码头';
comment on column BI_WAREHOUSE.shiptype
  is '0 海伦 1 江轮 2 全部 3 不支持';
comment on column BI_WAREHOUSE.hasrailway
  is '0 有铁路专线 1 没有铁路专线';
comment on column BI_WAREHOUSE.hastanker
  is '0 支持 1 不支持';
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
  is '权限id';
comment on column BR_BROKERMENU.name
  is '权限名称';
comment on column BR_BROKERMENU.icon
  is '权限使用的图标';
comment on column BR_BROKERMENU.authorityurl
  is '对应的权限路径';
comment on column BR_BROKERMENU.visiturl
  is '对应的资源路径';
comment on column BR_BROKERMENU.moduleid
  is '所属模块号';
comment on column BR_BROKERMENU.seq
  is '序号';
comment on column BR_BROKERMENU.visible
  is '是否可见   是否可见 0：可见、 其他：不可见';
comment on column BR_BROKERMENU.type
  is '权限类型   权限类型 -3：只检查session不检查权限的url -2：无需判断权限的URL  -1： 父菜单类型 0：子菜单类型  1：页面内增删改查权限';
comment on column BR_BROKERMENU.catalogid
  is '日志对应的分类';
comment on column BR_BROKERMENU.iswritelog
  is '是否自动写日志      是否自动写日志 Y：写日志 N：不写日志';
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
  is '已结算佣金汇总表';
comment on column BR_BROKERREWARD.brokerid
  is '加盟商id';
comment on column BR_BROKERREWARD.occurdate
  is '清算时间';
comment on column BR_BROKERREWARD.moduleid
  is '模块id';
comment on column BR_BROKERREWARD.amount
  is '尾款金融';
comment on column BR_BROKERREWARD.paidamount
  is '首付款金额';
comment on column BR_BROKERREWARD.paydate
  is '付款日';
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
  is '特殊佣金设置';
comment on column BR_BROKERREWARDPROPS.moduleid
  is '模块id -1:表示默认佣金设置
15:订单大宗商品交易系统';
comment on column BR_BROKERREWARDPROPS.rewardtype
  is '佣金类型 0:交易';
comment on column BR_BROKERREWARDPROPS.brokerid
  is '加盟商id';
comment on column BR_BROKERREWARDPROPS.commodityid
  is '商品编码';
comment on column BR_BROKERREWARDPROPS.rewardrate
  is '手续费佣金比例';
comment on column BR_BROKERREWARDPROPS.firstpayrate
  is '提成首付比例';
comment on column BR_BROKERREWARDPROPS.secondpayrate
  is '提成尾款比例';
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
  is '权限的角色集合';
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
  is '主键';
comment on column BR_FIRMAPPLY.userid
  is '交易商id';
comment on column BR_FIRMAPPLY.brokerageid
  is '居间商id';
comment on column BR_FIRMAPPLY.brokerid
  is '经纪会员id';
comment on column BR_FIRMAPPLY.applydate
  is '生成时间';
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
  is '付佣金参数设置';
comment on column BR_REWARDPARAMETERPROPS.autopay
  is '是否自动付款 Y:是 N:否';
comment on column BR_REWARDPARAMETERPROPS.payperiod
  is '付款周期 1:按月计算 2:按周计算';
comment on column BR_REWARDPARAMETERPROPS.payperioddate
  is '付款周期日';

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
  is '申请类型';
comment on column C_APPLY.status
  is '当前状态 0：待审核 1：审核通过 2：审核驳回 3：撤销申请';
comment on column C_APPLY.content
  is '内容';
comment on column C_APPLY.note
  is '备注';
comment on column C_APPLY.discribe
  is '描述';
comment on column C_APPLY.modtime
  is '修改时间';
comment on column C_APPLY.createtime
  is '创建时间';
comment on column C_APPLY.applyuser
  is '申请人';
comment on column C_APPLY.operatetype
  is '操作类型 update;add;delete;deleteCollection';
comment on column C_APPLY.entityclass
  is '业务对象类';
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
  is '申请单ID';
comment on column C_AUDIT.status
  is '状态 1：审核通过 2：驳回申请';
comment on column C_AUDIT.audituser
  is '审核人';
comment on column C_AUDIT.modtime
  is '修改时间';
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
  is '角色Id';
comment on column C_DEPLOY_CONFIG.contextname
  is '系统名称';
comment on column C_DEPLOY_CONFIG.serverpic
  is '首页点击进入各个系统管理平台的点击图片';
comment on column C_DEPLOY_CONFIG.serverpath
  is '服务地址：eg  http://127.0.0.1:8080';
comment on column C_DEPLOY_CONFIG.relativepath
  is '公用系统点击进入各个系统管理平台的地相对址';
comment on column C_DEPLOY_CONFIG.homepageaction
  is '各个系统平台主页的Action';
comment on column C_DEPLOY_CONFIG.welcomepage
  is '跳转到各个系统首页的相对地址(只有前台才有主页)';
comment on column C_DEPLOY_CONFIG.welcomepic
  is '公用系统头部点击进入各个系统首页的图标展示(只有前台才有首页图标)';
comment on column C_DEPLOY_CONFIG.systype
  is '系统类型，mgr：后台  front：前台';
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
  is '管理员Id';
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
  is ' 规范：
1：开头两位为系统模块号
2: 第三四位为一级菜单
3：第五六位为二级菜单
4：第七八位为三级菜单
5：第九十位为页面中的增删改查
';
comment on column C_FRONT_RIGHT.parentid
  is '父关联';
comment on column C_FRONT_RIGHT.name
  is '权限名称';
comment on column C_FRONT_RIGHT.icon
  is '图标';
comment on column C_FRONT_RIGHT.authorityurl
  is '权限路径';
comment on column C_FRONT_RIGHT.visiturl
  is '真实路径';
comment on column C_FRONT_RIGHT.moduleid
  is '模块Id';
comment on column C_FRONT_RIGHT.seq
  is '序号';
comment on column C_FRONT_RIGHT.visible
  is '是否可见-1 不可见0 可见';
comment on column C_FRONT_RIGHT.type
  is '类型-3:只检查session不检查权限的url -2：无需判断权限的URL -1： 父菜单类型 0：子菜单类型 1：页面内增删改查权限';
comment on column C_FRONT_RIGHT.catalogid
  is '日志类型 0不写日志 其它对应表c_logcatalog 的CATALOGID字段';
comment on column C_FRONT_RIGHT.iswritelog
  is '''Y''：写日志、''N''：不写日志';
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
  is '角色Id';
comment on column C_FRONT_ROLE.name
  is '角色名称';
comment on column C_FRONT_ROLE.description
  is '描述';
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
  is '权限Id
权限Id';
comment on column C_FRONT_ROLE_RIGHT.roleid
  is '角色Id';
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
  is '权限Id
权限Id';
comment on column C_FRONT_USER_RIGHT.userid
  is '管理员Id';
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
  is '管理员Id';
comment on column C_FRONT_USER_ROLE.roleid
  is '角色Id
角色Id';
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
  is '操作人';
comment on column C_GLOBALLOG_ALL.operatetime
  is '操作时间';
comment on column C_GLOBALLOG_ALL.operatetype
  is '操作类型';
comment on column C_GLOBALLOG_ALL.operateip
  is '操作IP';
comment on column C_GLOBALLOG_ALL.operatortype
  is '操作人种类';
comment on column C_GLOBALLOG_ALL.mark
  is '标示';
comment on column C_GLOBALLOG_ALL.operatecontent
  is '操作内容';
comment on column C_GLOBALLOG_ALL.currentvalue
  is '当前值';
comment on column C_GLOBALLOG_ALL.operateresult
  is '操作结果 1 成功  0 失败';
comment on column C_GLOBALLOG_ALL.logtype
  is '0 其他，1 后台，2 前台，3 核心';
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
  is '操作人';
comment on column C_GLOBALLOG_ALL_H.operatetime
  is '操作时间';
comment on column C_GLOBALLOG_ALL_H.operatetype
  is '操作类型';
comment on column C_GLOBALLOG_ALL_H.operateip
  is '操作IP';
comment on column C_GLOBALLOG_ALL_H.operatortype
  is '操作人种类';
comment on column C_GLOBALLOG_ALL_H.mark
  is '标示';
comment on column C_GLOBALLOG_ALL_H.operatecontent
  is '操作内容';
comment on column C_GLOBALLOG_ALL_H.currentvalue
  is '当前值';
comment on column C_GLOBALLOG_ALL_H.operateresult
  is '操作结果 1 成功  0 失败';
comment on column C_GLOBALLOG_ALL_H.logtype
  is '0 其他，1 后台，2 前台，3 核心';
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
  is '日志分类，4位数字的编码，以日志模块ID开头。';
comment on column C_LOGCATALOG.catalogid
  is '日志分类ID：4位数字的编码，详见备注Notes。';
comment on column C_LOGCATALOG.moduleid
  is '10综合管理平台
11财务系统
12监管仓库管理系统
13仓单管理系统
14融资系统
15订单交易
18投资类大宗商品交易系统
19加盟会员管理系统
20做市商交易系统
21竞价系统
22银行接入及结算系统
23E现货
24单点登录系统
25实时行情分析系统
26交易客户端
98demo系统
99公用系统';
comment on column C_LOGCATALOG.catalogname
  is '日志分类名';
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
  is ' 规范：
1：开头两位为系统模块号
2: 第三四位为一级菜单
3：第五六位为二级菜单
4：第七八位为三级菜单
5：第九十位为页面中的增删改查
';
comment on column C_RIGHT.parentid
  is '父关联';
comment on column C_RIGHT.name
  is '权限名称';
comment on column C_RIGHT.icon
  is '图标';
comment on column C_RIGHT.authorityurl
  is '权限路径';
comment on column C_RIGHT.visiturl
  is '真实路径';
comment on column C_RIGHT.moduleid
  is '10综合管理平台
11财务系统
12监管仓库管理系统
13仓单管理系统
14融资系统
15订单交易
18投资类大宗商品交易系统
19加盟会员管理系统
20做市商交易系统
21竞价系统
22银行接入及结算系统
23E现货
24单点登录系统
25实时行情分析系统
26交易客户端
98demo系统
99公用系统';
comment on column C_RIGHT.seq
  is '序号';
comment on column C_RIGHT.visible
  is '是否可见-1 不可见0 可见';
comment on column C_RIGHT.type
  is '类型-3:只检查session不检查权限的url -2：无需判断权限的URL -1： 父菜单类型 0：子菜单类型 1：页面内增删改查权限';
comment on column C_RIGHT.catalogid
  is '日志类型 0不写日志 其它对应表c_logcatalog 的CATALOGID字段';
comment on column C_RIGHT.iswritelog
  is '''Y''：写日志、''N''：不写日志';
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
  is '角色Id';
comment on column C_ROLE.name
  is '角色名称';
comment on column C_ROLE.description
  is '描述';
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
  is '权限Id';
comment on column C_ROLE_RIGHT.roleid
  is '角色Id';
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
  is '此表为c_trademodule中的子模块配置表，模块ID不要与c_trademodule表中的模块ID重复';
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
  is '10综合管理平台
11财务系统
12监管仓库管理系统
13仓单管理系统
14融资系统
15订单交易
18投资类大宗商品交易系统
19加盟会员管理系统
20做市商交易系统
21竞价系统
22银行接入及结算系统
23E现货
24单点登录系统
25实时行情分析系统
26交易客户端
98demo系统
99公用系统';
comment on column C_TRADEMODULE.isfirmset
  is '‘Y’ 是 ‘N’ 否 (如果需要在公用前台我的平台中显示本系统，还需要在公用系统的 spring_sys_msg.xml 中配置上本系统的配置信息)';
comment on column C_TRADEMODULE.isbalancecheck
  is 'Y：是 N：否';
comment on column C_TRADEMODULE.isneedbreed
  is '本系统是否需要综合管理平台增加的商品   Y:是   N:否';
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
  is '管理员Id';
comment on column C_USER.name
  is '管理员名称';
comment on column C_USER.password
  is '密码';
comment on column C_USER.type
  is 'ADMIN：普通管理员角色DEFAULT_ADMIN：高级管理员角色DEFAULT_SUPER_ADMIN：默认超级管理员角色';
comment on column C_USER.description
  is '描述';
comment on column C_USER.isforbid
  is 'Y：禁用
N：不禁用
';
comment on column C_USER.skin
  is '皮肤';
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
  is '权限Id
权限Id';
comment on column C_USER_RIGHT.userid
  is '管理员Id';
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
  is '管理员Id';
comment on column C_USER_ROLE.roleid
  is '角色Id';
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
  is '科目代码';
comment on column F_ACCOUNT.name
  is '科目名称';
comment on column F_ACCOUNT.accountlevel
  is '科目级别';
comment on column F_ACCOUNT.dcflag
  is '借贷方向标志 D:Debit 借
C:Credit 贷
';
comment on column F_ACCOUNT.isinit
  is '是否初始化 Y:是初始化数据,页面不允许删除和修改
N:不是初始化数据';
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
  is '工行银行帐户表';
comment on column F_B_BANKACCOUNT.bankid
  is '银行编号';
comment on column F_B_BANKACCOUNT.account
  is '银行帐号';
comment on column F_B_BANKACCOUNT.status
  is '状态(0 可用,1 冻结)';
comment on column F_B_BANKACCOUNT.accountname
  is '账户名';
comment on column F_B_BANKACCOUNT.bankname
  is '银行名称';
comment on column F_B_BANKACCOUNT.bankprovince
  is '银行省份';
comment on column F_B_BANKACCOUNT.bankcity
  is '银行所在市';
comment on column F_B_BANKACCOUNT.mobile
  is '电话号码';
comment on column F_B_BANKACCOUNT.email
  is '邮箱';
comment on column F_B_BANKACCOUNT.cardtype
  is '帐户类型(1 身份证,2军官证,3国内护照,4户口本,5学员证,6退休证,7临时身份证,8组织机构代码,9营业执照,A警官证,B解放军士兵证,C回乡证,D外国护照,E港澳台居民身份证,F台湾通行证及其他有效旅行证,G海外客户编号,H解放军文职干部证,I武警文职干部证,J武警士兵证,X其他有效证件,Z重号身份证)(主要用的是 1、8,有用 9 的 其它还没有用的';
comment on column F_B_BANKACCOUNT.card
  is '证件号码';

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
  is '分分核对表';
comment on column F_B_BANKCAPITALRESULT.bankid
  is '银行编号';
comment on column F_B_BANKCAPITALRESULT.firmid
  is '交易商代码';
comment on column F_B_BANKCAPITALRESULT.bankright
  is '银行权益';
comment on column F_B_BANKCAPITALRESULT.maketright
  is '市场权益';
comment on column F_B_BANKCAPITALRESULT.reason
  is '不平原因(0金额不平 1银行端账户未建立 2机构端账户未建立)';
comment on column F_B_BANKCAPITALRESULT.bdate
  is '日期时间';
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
  is '银行对账信息表';
comment on column F_B_BANKCOMPAREINFO.id
  is '银行对账信息ID';
comment on column F_B_BANKCOMPAREINFO.funid
  is '银行流水号';
comment on column F_B_BANKCOMPAREINFO.firmid
  is '交易商代码';
comment on column F_B_BANKCOMPAREINFO.account
  is '交易商账号';
comment on column F_B_BANKCOMPAREINFO.type
  is '操作类型(0 入金,1 出金)';
comment on column F_B_BANKCOMPAREINFO.money
  is '金额';
comment on column F_B_BANKCOMPAREINFO.comparedate
  is '对账日期';
comment on column F_B_BANKCOMPAREINFO.note
  is '备注';
comment on column F_B_BANKCOMPAREINFO.createtime
  is '创建日期';
comment on column F_B_BANKCOMPAREINFO.status
  is '操作状态';
comment on column F_B_BANKCOMPAREINFO.bankid
  is '银行编号';
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
  is '银行清算时间表';
comment on column F_B_BANKQSDATE.bankid
  is '银行编号';
comment on column F_B_BANKQSDATE.tradedate
  is '清算日期';
comment on column F_B_BANKQSDATE.tradetype
  is '清算类型';
comment on column F_B_BANKQSDATE.tradestatus
  is '清算状态(0 成功,1 失败)';
comment on column F_B_BANKQSDATE.note
  is '备注信息';
comment on column F_B_BANKQSDATE.createdate
  is '记录创建时间';

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
  is '银行表';
comment on column F_B_BANKS.bankid
  is '银行编号';
comment on column F_B_BANKS.bankname
  is '银行名称';
comment on column F_B_BANKS.maxpersgltransmoney
  is '单笔最大转账金额';
comment on column F_B_BANKS.maxpertransmoney
  is '每日最大转账金额';
comment on column F_B_BANKS.maxpertranscount
  is '每日最大转账次数';
comment on column F_B_BANKS.adapterclassname
  is '适配器实现类名称';
comment on column F_B_BANKS.validflag
  is '银行状态(0 可用,1 不可用)';
comment on column F_B_BANKS.maxauditmoney
  is '当个银行出金审核额度';
comment on column F_B_BANKS.begintime
  is '银行起始转账时间';
comment on column F_B_BANKS.endtime
  is '银行结束转账时间';
comment on column F_B_BANKS.control
  is '是否受到交易日和交易时间的约束 (0 受双重约束,1 不受约束,2 受交易日约束,3 受交易时间约束)';
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
  is '工行银行转账表';
comment on column F_B_BANKTRANSFER.paybankid
  is '转出银行ID银行编号';
comment on column F_B_BANKTRANSFER.recbankid
  is '转转入银行ID银行编号';
comment on column F_B_BANKTRANSFER.money
  is '冻结资金';
comment on column F_B_BANKTRANSFER.moneytype
  is '0为人民币';
comment on column F_B_BANKTRANSFER.funid
  is '银行流水号';
comment on column F_B_BANKTRANSFER.maerketid
  is '银行流水号';
comment on column F_B_BANKTRANSFER.status
  is '0 成功,1 失败,2 处理中,3 一次审核,4 二次审核,5 银行返回信息为空,6 银行返回市场流水号和市场保存流水号不一致,13 市场假银行出入金待审核状态';

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
  is '对账不平记录';
comment on column F_B_BATCUSTFILE.custacctid
  is '子账号';
comment on column F_B_BATCUSTFILE.custname
  is '名称';
comment on column F_B_BATCUSTFILE.thirdcustid
  is '会员代码';
comment on column F_B_BATCUSTFILE.bankbalance
  is '银行清算后可用余额';
comment on column F_B_BATCUSTFILE.bankfrozen
  is '银行清算后冻结余额';
comment on column F_B_BATCUSTFILE.maketbalance
  is '交易网可用余额';
comment on column F_B_BATCUSTFILE.maketfrozen
  is '交易网冻结余额';
comment on column F_B_BATCUSTFILE.balanceerror
  is '可用余额差额（银行可用余额-交易网可用余额）';
comment on column F_B_BATCUSTFILE.frozenerror
  is '冻结余额差额（银行冻结余额-交易网冻结余额）';
comment on column F_B_BATCUSTFILE.tradedate
  is '交易时间';
comment on column F_B_BATCUSTFILE.bankid
  is '银行编号';
comment on column F_B_BATCUSTFILE.createdate
  is '创建日期';
comment on column F_B_BATCUSTFILE.note
  is '备注信息';
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
  is '市场流水表';
comment on column F_B_CAPITALINFO.id
  is '流水ID';
comment on column F_B_CAPITALINFO.firmid
  is '交易商代码';
comment on column F_B_CAPITALINFO.funid
  is '银行流水号';
comment on column F_B_CAPITALINFO.bankid
  is '银行编号';
comment on column F_B_CAPITALINFO.debitid
  is '贷方代码';
comment on column F_B_CAPITALINFO.creditid
  is '借方代码';
comment on column F_B_CAPITALINFO.type
  is '流水类型(0 入金,1 出金,2出入金手续费';
comment on column F_B_CAPITALINFO.money
  is '流水金额';
comment on column F_B_CAPITALINFO.operator
  is '业务代码';
comment on column F_B_CAPITALINFO.createtime
  is '创建时间';
comment on column F_B_CAPITALINFO.banktime
  is '银行事件';
comment on column F_B_CAPITALINFO.status
  is '状态(0 成功,1 失败,2 处理中,3 一次审核,4 二次审核,5 银行返回信息为空,6 银行返回市场流水号和市场保存流水号不一致,13 市场假银行出入金待审核状态)';
comment on column F_B_CAPITALINFO.note
  is '备注信息';
comment on column F_B_CAPITALINFO.actionid
  is '业务流水';
comment on column F_B_CAPITALINFO.express
  is '是否加急';
comment on column F_B_CAPITALINFO.bankname
  is '特殊加的(银行名称)';
comment on column F_B_CAPITALINFO.account
  is '特殊加的(银行账号)';
comment on column F_B_CAPITALINFO.createdate
  is '创建时间';
comment on column F_B_CAPITALINFO.funid2
  is '流水2';
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
  is '字典表';
comment on column F_B_DICTIONARY.id
  is '字典ID';
comment on column F_B_DICTIONARY.type
  is '类型';
comment on column F_B_DICTIONARY.bankid
  is '银行编号';
comment on column F_B_DICTIONARY.name
  is '字典名';
comment on column F_B_DICTIONARY.value
  is '字典值';
comment on column F_B_DICTIONARY.note
  is '备注';
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
  is '标准费用表';
comment on column F_B_FEEINFO.id
  is '费用列表ID';
comment on column F_B_FEEINFO.uplimit
  is '结束金额';
comment on column F_B_FEEINFO.downlimit
  is '起始金额';
comment on column F_B_FEEINFO.tmode
  is '计算放肆(0 百分比,2 绝对值)';
comment on column F_B_FEEINFO.rate
  is '手续费';
comment on column F_B_FEEINFO.type
  is '收费类型';
comment on column F_B_FEEINFO.createtime
  is '记录时间';
comment on column F_B_FEEINFO.updatetime
  is '修改时间';
comment on column F_B_FEEINFO.userid
  is '用户ID(记录人,交易商,银行)';
comment on column F_B_FEEINFO.maxratevalue
  is '最大金额';
comment on column F_B_FEEINFO.minratevalue
  is '最小金额';
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
  is '分分核对表';
comment on column F_B_FFHD.bankid
  is '银行编号';
comment on column F_B_FFHD.tradedate
  is '交易日期';
comment on column F_B_FFHD.firmid
  is '交易商编号';
comment on column F_B_FFHD.account
  is '交易商银行账号';
comment on column F_B_FFHD.currency
  is '币别 (001：人民币 013：港币 014：美元)';
comment on column F_B_FFHD.type
  is '钞汇标识 (0：钞 1：汇)';
comment on column F_B_FFHD.reasion
  is '不平原因 (0:金额不平 1:银行端资金存管账户未建立 2:市场端交易商代码不存在)';
comment on column F_B_FFHD.balancem
  is '市场总权益';
comment on column F_B_FFHD.cashm
  is '市场现金权益';
comment on column F_B_FFHD.billm
  is '市场票据权益';
comment on column F_B_FFHD.usebalancem
  is '市场可用资金';
comment on column F_B_FFHD.frozencashm
  is '市场占用现金';
comment on column F_B_FFHD.frozenloanm
  is '市场占用贷款金额';
comment on column F_B_FFHD.balanceb
  is '银行总权益';
comment on column F_B_FFHD.cashb
  is '银行现金权益';
comment on column F_B_FFHD.billb
  is '银行票据权益';
comment on column F_B_FFHD.usebalanceb
  is '银行可用资金';
comment on column F_B_FFHD.frozencashb
  is '银行占用现金';
comment on column F_B_FFHD.frozenloanb
  is '银行占用贷款金额';
comment on column F_B_FFHD.createdate
  is '创建时间';
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
  is '会员余额记录';
comment on column F_B_FIRMBALANCE.custacctid
  is '子账号';
comment on column F_B_FIRMBALANCE.custname
  is '账户名';
comment on column F_B_FIRMBALANCE.thirdcustid
  is '会员代码';
comment on column F_B_FIRMBALANCE.status
  is '状态(1：正常  2：退出  3：待确定)';
comment on column F_B_FIRMBALANCE.type
  is '账号属性(1：普通会员子账号  2：挂账子账号  3：手续费子账号  4：利息子账号  6：清算子账号)';
comment on column F_B_FIRMBALANCE.istruecont
  is '是否实子账号(默认为 1：虚子账号)';
comment on column F_B_FIRMBALANCE.balance
  is '总额';
comment on column F_B_FIRMBALANCE.usrbalance
  is '可用余额';
comment on column F_B_FIRMBALANCE.frozenbalance
  is '冻结资金';
comment on column F_B_FIRMBALANCE.interest
  is '利息基数';
comment on column F_B_FIRMBALANCE.bankid
  is '银行代码';
comment on column F_B_FIRMBALANCE.tradedate
  is '交易日期';
comment on column F_B_FIRMBALANCE.createdate
  is '信息创建时间';
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
  is '银行对账失败文件';
comment on column F_B_FIRMBALANCEERROR.trandatetime
  is '交易时间';
comment on column F_B_FIRMBALANCEERROR.counterid
  is '操作员';
comment on column F_B_FIRMBALANCEERROR.supacctid
  is '资金汇总帐号';
comment on column F_B_FIRMBALANCEERROR.funccode
  is '功能代码';
comment on column F_B_FIRMBALANCEERROR.custacctid
  is '子账户账号';
comment on column F_B_FIRMBALANCEERROR.custname
  is '子账户名称';
comment on column F_B_FIRMBALANCEERROR.thirdcustid
  is '交易网会员代码';
comment on column F_B_FIRMBALANCEERROR.thirdlogno
  is '交易网流水号';
comment on column F_B_FIRMBALANCEERROR.ccycode
  is '币种';
comment on column F_B_FIRMBALANCEERROR.freezeamount
  is '当天总冻结资金';
comment on column F_B_FIRMBALANCEERROR.unfreezeamount
  is '当天总解冻资金';
comment on column F_B_FIRMBALANCEERROR.addtranamount
  is '当天成交的总货款(卖方)';
comment on column F_B_FIRMBALANCEERROR.cuttranamount
  is '当天成交的总货款(买方)';
comment on column F_B_FIRMBALANCEERROR.profitamount
  is '盈利总金额';
comment on column F_B_FIRMBALANCEERROR.lossamount
  is '亏损总金额';
comment on column F_B_FIRMBALANCEERROR.tranhandfee
  is '交易商当天应付给交易网的手续费';
comment on column F_B_FIRMBALANCEERROR.trancount
  is '当天交易总比数';
comment on column F_B_FIRMBALANCEERROR.newbalance
  is '交易网端最新的交易商可用金额';
comment on column F_B_FIRMBALANCEERROR.newfreezeamount
  is '交易网端最新的冻结资金';
comment on column F_B_FIRMBALANCEERROR.note
  is '说明';
comment on column F_B_FIRMBALANCEERROR.reserve
  is '保留域';
comment on column F_B_FIRMBALANCEERROR.rspcode
  is '错误码';
comment on column F_B_FIRMBALANCEERROR.rspmsg
  is '应答描述';
comment on column F_B_FIRMBALANCEERROR.bankid
  is '银行代码';
comment on column F_B_FIRMBALANCEERROR.createtime
  is '信息创建时间';
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
  is '交易商银行账号对应表';
comment on column F_B_FIRMIDANDACCOUNT.bankid
  is '银行编号';
comment on column F_B_FIRMIDANDACCOUNT.firmid
  is '交易商代码';
comment on column F_B_FIRMIDANDACCOUNT.account
  is '银行帐号';
comment on column F_B_FIRMIDANDACCOUNT.account1
  is '银行内部账号';
comment on column F_B_FIRMIDANDACCOUNT.status
  is '状态(0 可用,1 冻结)';
comment on column F_B_FIRMIDANDACCOUNT.accountname
  is '账户名';
comment on column F_B_FIRMIDANDACCOUNT.bankname
  is '银行名称';
comment on column F_B_FIRMIDANDACCOUNT.bankprovince
  is '银行省份';
comment on column F_B_FIRMIDANDACCOUNT.bankcity
  is '银行所在市';
comment on column F_B_FIRMIDANDACCOUNT.mobile
  is '电话号码';
comment on column F_B_FIRMIDANDACCOUNT.email
  is '邮箱';
comment on column F_B_FIRMIDANDACCOUNT.isopen
  is '是否已签约(0 未签约,1 已签约)';
comment on column F_B_FIRMIDANDACCOUNT.cardtype
  is '--帐户类型(1 身份证,2军官证,3国内护照,4户口本,5学员证,6退休证,7临时身份证,8组织机构代码,9营业执照,A警官证,B解放军士兵证,C回乡证,D外国护照,E港澳台居民身份证,F台湾通行证及其他有效旅行证,G海外客户编号,H解放军文职干部证,I武警文职干部证,J武警士兵证,X其他有效证件,Z重号身份证)(主要用的是 1、8,有用 9 的 其它还没有用的)';
comment on column F_B_FIRMIDANDACCOUNT.card
  is '证件号码';
comment on column F_B_FIRMIDANDACCOUNT.frozenfuns
  is '冻结资金';
comment on column F_B_FIRMIDANDACCOUNT.accountname1
  is '银行内部账户名称';
comment on column F_B_FIRMIDANDACCOUNT.opentime
  is '开户时间';
comment on column F_B_FIRMIDANDACCOUNT.inmarketcode
  is '交易商入世协议号';
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
  createdate   DATE default sysdate    --记录创建日期
)
;
comment on table F_B_FIRMKXH
  is '当天会员开销户信息表';
comment on column F_B_FIRMKXH.funid
  is '银行前置流水号';
comment on column F_B_FIRMKXH.status
  is '交易状态(1：开户 2：销户 3：待确认)';
comment on column F_B_FIRMKXH.account1
  is '会员子账号';
comment on column F_B_FIRMKXH.type
  is '子账户性质';
comment on column F_B_FIRMKXH.account1name
  is '子账户名称';
comment on column F_B_FIRMKXH.firmid
  is '交易商代码';
comment on column F_B_FIRMKXH.tradedate
  is '交易日期';
comment on column F_B_FIRMKXH.counterid
  is '操作柜员号';
comment on column F_B_FIRMKXH.bankid
  is '银行代码';
comment on column F_B_FIRMKXH.createdate
  is '记录创建日期';
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
  is '客户协议状态（增量）对账表';
comment on column F_B_FIRMTRADESTATUS.bankid
  is '银行id';
comment on column F_B_FIRMTRADESTATUS.dealid
  is '市场组织机构代码';
comment on column F_B_FIRMTRADESTATUS.cobrn
  is '合作方机构号';
comment on column F_B_FIRMTRADESTATUS.txdate
  is '交易日期';
comment on column F_B_FIRMTRADESTATUS.bankacc
  is '银行账号';
comment on column F_B_FIRMTRADESTATUS.fundacc
  is '交易商代码';
comment on column F_B_FIRMTRADESTATUS.custname
  is '交易商姓名';
comment on column F_B_FIRMTRADESTATUS.curcode
  is '币种';
comment on column F_B_FIRMTRADESTATUS.status
  is '状态';
comment on column F_B_FIRMTRADESTATUS.comparedate
  is '对账日期';
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
  is '银行接口部分用户表';
comment on column F_B_FIRMUSER.firmid
  is '交易商代码';
comment on column F_B_FIRMUSER.name
  is '交易商名称';
comment on column F_B_FIRMUSER.maxpersgltransmoney
  is '单笔最大转账金额';
comment on column F_B_FIRMUSER.maxpertransmoney
  is '每天最大转账金额';
comment on column F_B_FIRMUSER.maxpertranscount
  is '每天最大转账次数';
comment on column F_B_FIRMUSER.status
  is '交易商状态(0 已注册,1 禁用或未注册,2注销)';
comment on column F_B_FIRMUSER.registerdate
  is '注册日期';
comment on column F_B_FIRMUSER.logoutdate
  is '注销日期';
comment on column F_B_FIRMUSER.maxauditmoney
  is '审核额度';
comment on column F_B_FIRMUSER.password
  is '密码';
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
  is '添加华夏清算表';
comment on column F_B_HXQS.bankid
  is '银行编号';
comment on column F_B_HXQS.firmid
  is '交易商编号';
comment on column F_B_HXQS.tradedate
  is '清算日期';
comment on column F_B_HXQS.money
  is '金额';
comment on column F_B_HXQS.type
  is '借贷标示 (1:借，资金减少 2:贷，资金增减)';
comment on column F_B_HXQS.tradetype
  is '资金类型';
comment on column F_B_HXQS.note
  is '备注信息';
comment on column F_B_HXQS.createdate
  is '数据写入时间';
comment on column F_B_HXQS.status
  is '当前状态(0:成功 1:失败 2:情况未知)';
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
  is '银行代码
银行代码';
comment on column F_B_INTERFACELOG.launcher
  is '发起方
0 市场
1 银行';
comment on column F_B_INTERFACELOG.type
  is '交易类型
1 签到
2 签退
3 签约
4 解约
5 查询余额
6 出金
7 入金
8 冲正';
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
  is '银行接口部分操作日指标';
comment on column F_B_LOG.logid
  is '日志编号';
comment on column F_B_LOG.logopr
  is '操作员';
comment on column F_B_LOG.logcontent
  is '操作内容';
comment on column F_B_LOG.logdate
  is '日志记录日期';
comment on column F_B_LOG.logip
  is '日志记录登录机器';
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
  createtime DATE default sysdate   --创建时间
)
;
comment on table F_B_MAKETMONEY
  is '添加市场自有资金利息表';
comment on column F_B_MAKETMONEY.id
  is '自有资金编号';
comment on column F_B_MAKETMONEY.bankid
  is '银行编号';
comment on column F_B_MAKETMONEY.banknumber
  is ' 银行转账号';
comment on column F_B_MAKETMONEY.type
  is '资金类型 (1:手续费,2:利息)';
comment on column F_B_MAKETMONEY.adddelt
  is '增加、减少资金(1:增加 2:减少)';
comment on column F_B_MAKETMONEY.money
  is '增加、减少金额额度';
comment on column F_B_MAKETMONEY.note
  is '备注信息';
comment on column F_B_MAKETMONEY.createtime
  is '创建时间';
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
  is '交易商资金冻结解冻表';
comment on column F_B_MARGINS.serial_id
  is '业务流水号';
comment on column F_B_MARGINS.bargain_code
  is '成交合同号';
comment on column F_B_MARGINS.trade_type
  is '交易类型 (1 冻结；2 解冻)';
comment on column F_B_MARGINS.trade_money
  is '交易金额';
comment on column F_B_MARGINS.member_code
  is '交易会员号';
comment on column F_B_MARGINS.member_name
  is '交易会员名称';
comment on column F_B_MARGINS.trade_date
  is '交易日期';
comment on column F_B_MARGINS.good_code
  is '商品编号';
comment on column F_B_MARGINS.good_name
  is '商品名称';
comment on column F_B_MARGINS.good_quantity
  is '商品数量';
comment on column F_B_MARGINS.flag
  is '发送状态 (N 未发送；F 银行处理失败；Y 银行处理成功)';
comment on column F_B_MARGINS.bankid
  is '银行编号';
comment on column F_B_MARGINS.createdate
  is '创建时间';
comment on column F_B_MARGINS.note
  is '资金冻结解冻表备注字段';
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
  is '总分平衡表';
comment on column F_B_PROPERBALANCE.bankid
  is '银行编号';
comment on column F_B_PROPERBALANCE.allmoney
  is '总资金';
comment on column F_B_PROPERBALANCE.gongmoney
  is '工行总资金';
comment on column F_B_PROPERBALANCE.othermoney
  is '其他行资金';
comment on column F_B_PROPERBALANCE.bdate
  is '日期时间';

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
  is '对账不平纪录信息';
comment on column F_B_QSRESULT.resultid
  is '流水编号';
comment on column F_B_QSRESULT.bankid
  is '银行编号';
comment on column F_B_QSRESULT.bankname
  is '银行名称';
comment on column F_B_QSRESULT.firmid
  is '交易商代码';
comment on column F_B_QSRESULT.firmname
  is '交易商名称';
comment on column F_B_QSRESULT.account
  is '银行账号';
comment on column F_B_QSRESULT.account1
  is '子账号';
comment on column F_B_QSRESULT.kymoneym
  is '市场可用余额';
comment on column F_B_QSRESULT.kymoneyb
  is '银行可用余额';
comment on column F_B_QSRESULT.djmoneym
  is '市场冻结资金';
comment on column F_B_QSRESULT.djmoneyb
  is '银行冻结资金';
comment on column F_B_QSRESULT.zckymoney
  is '可用资金扎差';
comment on column F_B_QSRESULT.zcdjmoney
  is '冻结资金扎差';
comment on column F_B_QSRESULT.moneym
  is '市场权益';
comment on column F_B_QSRESULT.moneyb
  is '银行权益';
comment on column F_B_QSRESULT.zcmoney
  is '权益扎差';
comment on column F_B_QSRESULT.createdate
  is '记录创建时间';
comment on column F_B_QSRESULT.tradedate
  is '交易日期';
comment on column F_B_QSRESULT.status
  is '清算状态(0:成功、1:失败、2:可用余额不等、3:冻结余额不等、4:总余额不等、6:账号资金异常)';
comment on column F_B_QSRESULT.note
  is '备注信息';
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
  is '交易权益表';
comment on column F_B_QUANYI.id
  is '表单ID';
comment on column F_B_QUANYI.firmid
  is '交易商代码';
comment on column F_B_QUANYI.venduebalance
  is '竞价部分占用保证金';
comment on column F_B_QUANYI.zcjsbalance
  is '挂牌部分占用保证金';
comment on column F_B_QUANYI.timebargainbalance
  is '中远期部分权益';
comment on column F_B_QUANYI.avilablebalance
  is '财务余额';
comment on column F_B_QUANYI.bankbalance
  is '银行余额';
comment on column F_B_QUANYI.payment
  is '收货款';
comment on column F_B_QUANYI.income
  is '付货款';
comment on column F_B_QUANYI.fee
  is '手续费';
comment on column F_B_QUANYI.jie
  is '接触金额';
comment on column F_B_QUANYI.dai
  is '贷入金额';
comment on column F_B_QUANYI.dealtime
  is '记录日期';
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
  is '记录流水号';
comment on column F_B_RGSTCAPITALVALUE.actionid
  is '市场流水号';
comment on column F_B_RGSTCAPITALVALUE.firmid
  is '交易商代码';
comment on column F_B_RGSTCAPITALVALUE.account
  is '签约协议号';
comment on column F_B_RGSTCAPITALVALUE.bankid
  is '银行代码';
comment on column F_B_RGSTCAPITALVALUE.type
  is '流水类型 1签约  2解约';
comment on column F_B_RGSTCAPITALVALUE.createtime
  is '创建时间';
comment on column F_B_RGSTCAPITALVALUE.banktime
  is '完成时间';
comment on column F_B_RGSTCAPITALVALUE.status
  is '流水状态 0成功 1失败 2处理中';
comment on column F_B_RGSTCAPITALVALUE.accountname
  is '户名';
comment on column F_B_RGSTCAPITALVALUE.cardtype
  is '证件类型';
comment on column F_B_RGSTCAPITALVALUE.card
  is '证件号';
comment on column F_B_RGSTCAPITALVALUE.note
  is '备注';
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
  is '交易数据表';
comment on column F_B_TRADEDATA.firmid
  is '交易商id';
comment on column F_B_TRADEDATA.account1
  is '交易账号 [对应交易商银行帐号对应表的内部帐号]';
comment on column F_B_TRADEDATA.money
  is '变动金额';
comment on column F_B_TRADEDATA.type
  is '类型(0：权益增  1：权益减  2：收货款  3：付货款   4：手续费 5正 资金误差 6负 资金误差)';
comment on column F_B_TRADEDATA.status
  is '发送结果(1：未发送   0：发送成功)';
comment on column F_B_TRADEDATA.transferdate
  is '应发送时间';
comment on column F_B_TRADEDATA.accountname1
  is '交易账号名称';
comment on column F_B_TRADEDATA.actionid
  is '市场流水号';
comment on column F_B_TRADEDATA.funid
  is '银行流水号';
comment on column F_B_TRADEDATA.compareresult
  is '银行转账';
comment on column F_B_TRADEDATA.banktime
  is '对账时间';
comment on column F_B_TRADEDATA.realtransferdate
  is '实际发送时间';
comment on column F_B_TRADEDATA.sendperson
  is '发送人';
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
  is '账户类交易对账明细表';
comment on column F_B_TRADEDETAILACC.batchno
  is '交易序号';
comment on column F_B_TRADEDETAILACC.bankid
  is '银行id';
comment on column F_B_TRADEDETAILACC.dealid
  is '市场组织机构代码';
comment on column F_B_TRADEDETAILACC.cobrn
  is '合作方机构代码';
comment on column F_B_TRADEDETAILACC.txdate
  is '交易日期';
comment on column F_B_TRADEDETAILACC.txtime
  is '交易时间';
comment on column F_B_TRADEDETAILACC.bkserial
  is '银行流水';
comment on column F_B_TRADEDETAILACC.coserial
  is '市场流水';
comment on column F_B_TRADEDETAILACC.bankacc
  is '银行账号';
comment on column F_B_TRADEDETAILACC.fundacc
  is '交易商代码';
comment on column F_B_TRADEDETAILACC.custname
  is '交易商姓名';
comment on column F_B_TRADEDETAILACC.txopt
  is '交易发起方';
comment on column F_B_TRADEDETAILACC.txcode
  is '交易类型';
comment on column F_B_TRADEDETAILACC.curcode
  is '币种';
comment on column F_B_TRADEDETAILACC.comparedate
  is '对账日期';
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
  is '交易商权益变更表';
comment on column F_B_TRADELIST.trade_money
  is '变更金额';
comment on column F_B_TRADELIST.trade_type
  is '交易类型(1 货款、盈亏、补偿费；2 交易手续费；3 交收手续费；4 浮亏；5 其他手续费)';
comment on column F_B_TRADELIST.b_member_code
  is '买方会员号';
comment on column F_B_TRADELIST.b_member_name
  is '买方会员名称';
comment on column F_B_TRADELIST.s_member_code
  is '卖方会员号';
comment on column F_B_TRADELIST.s_member_name
  is '买方会员名称';
comment on column F_B_TRADELIST.trade_date
  is '交易日期';
comment on column F_B_TRADELIST.bargain_code
  is '成交合同号';
comment on column F_B_TRADELIST.serial_id
  is '交易流水号';
comment on column F_B_TRADELIST.good_code
  is '货物编号';
comment on column F_B_TRADELIST.good_name
  is '货物名称';
comment on column F_B_TRADELIST.good_quantity
  is '货物数量';
comment on column F_B_TRADELIST.flag
  is '发送状态 (N 未发送；F 银行处理失败；Y 银行处理成功)';
comment on column F_B_TRADELIST.bankid
  is '银行编号';
comment on column F_B_TRADELIST.createdate
  is '创建时间';
comment on column F_B_TRADELIST.note
  is '交易商权益变更表备注字段';
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
  is '资金划转对象表';
comment on column F_B_TRANSMONEYOBJ.id
  is '序号';
comment on column F_B_TRANSMONEYOBJ.classname
  is '业务实现类';
comment on column F_B_TRANSMONEYOBJ.note
  is '备注';

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
  is '总分平衡表';
comment on column F_B_ZFPH.bankid
  is '银行编号';
comment on column F_B_ZFPH.tradedate
  is '交易日期';
comment on column F_B_ZFPH.currency
  is '币别 (001：人民币 013：港币 014：美元)';
comment on column F_B_ZFPH.type
  is ' 钞汇标识（0：钞 1：汇）';
comment on column F_B_ZFPH.lastaccountbalance
  is '资金存管明细账户余额汇总';
comment on column F_B_ZFPH.accountbalance
  is '资金汇总账号金额';
comment on column F_B_ZFPH.result
  is '总分对账结果(0：平 1：不平)';
comment on column F_B_ZFPH.createdate
  is '创建时间';
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
  is 'Y:完成
N:未执行';
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
  is '交易商ID';
comment on column F_FIRMFUNDS.balance
  is '资金余额';
comment on column F_FIRMFUNDS.frozenfunds
  is '冻结资金';
comment on column F_FIRMFUNDS.lastbalance
  is '最近结算余额';
comment on column F_FIRMFUNDS.lastwarranty
  is '最近结算担保金';
comment on column F_FIRMFUNDS.settlemargin
  is '交收保证金';
comment on column F_FIRMFUNDS.lastsettlemargin
  is '上日交收保证金';
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
  is '10综合管理平台
11财务系统
13仓单管理系统
14融资系统
15订单交易
18投资类大宗商品交易系统
20做市商交易系统
21竞价系统
22银行接入及结算系统
23E现货';
comment on column F_FROZENFUNDFLOW.createtime
  is '创建时间';
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
  is '交易商在某个模块冻结的资金表';
comment on column F_FROZENFUNDS.moduleid
  is '10综合管理平台
11财务系统
13仓单管理系统
14融资系统
15订单交易
18投资类大宗商品交易系统
20做市商交易系统
21竞价系统
22银行接入及结算系统
23E现货';
comment on column F_FROZENFUNDS.firmid
  is '交易商';
comment on column F_FROZENFUNDS.frozenfunds
  is '冻结资金';
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
  is '创建时间';
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
  is '10综合管理平台
11财务系统
13仓单管理系统
14融资系统
15订单交易
18投资类大宗商品交易系统
20做市商交易系统
21竞价系统
22银行接入及结算系统
23E现货';
comment on column F_H_FROZENFUNDFLOW.createtime
  is '创建时间';
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
  is '当前帐户资金余额（不考虑浮亏）';
comment on column F_H_FUNDFLOW.createtime
  is '创建时间';
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
  is '总账字段代码';
comment on column F_LEDGERFIELD.name
  is '总账字段名称';
comment on column F_LEDGERFIELD.fieldsign
  is '1：增项 -1：减项';
comment on column F_LEDGERFIELD.moduleid
  is '10综合管理平台
11财务系统
13仓单管理系统
14融资系统
15订单交易
18投资类大宗商品交易系统
20做市商交易系统
21竞价系统
22银行接入及结算系统
23E现货';
comment on column F_LEDGERFIELD.ordernum
  is '排序号,前两位模块号后三位排序号
';
comment on column F_LEDGERFIELD.isinit
  is 'Y:是初始化数据,页面不允许删除和修改
N:不是初始化数据';
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
  is '财务日志表';
comment on column F_LOG.type
  is 'info：信息
alert：警告
error：错误
sysinfo：系统信息';

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
  is '摘要号';
comment on column F_SUMMARY.summary
  is '摘要名称';
comment on column F_SUMMARY.ledgeritem
  is '归入总账';
comment on column F_SUMMARY.funddcflag
  is '该凭证如果涉及交易商资金，增加资金记贷方 C，减少资金记借方 D。
不涉及交易商资金：N';
comment on column F_SUMMARY.accountcodeopp
  is '对方科目代码，用于电脑凭证';
comment on column F_SUMMARY.appendaccount
  is '附加账单,除了资金发生变动外，还有附加的财务账户变动。
T：增值税 Tax
W：担保金 Warranty
S：交收保证金 SettleMargin
N：无附加';
comment on column F_SUMMARY.isinit
  is 'Y:是初始化数据,页面不允许删除和修改
N:不是初始化数据';
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
  is '0:未结算状态
1:结算中
2:结算完成';
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
  is 'editing   编辑状态
auditing  待审核
audited   已审核
accounted 已记账';
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
  is '用于快捷创建手工凭证的模板';
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
  is '摇号信息';
comment on column IPO_BALLOTNO_INFO.commodityid
  is '商品编号';
comment on column IPO_BALLOTNO_INFO.ballotnostartlen
  is '尾号起始位';
comment on column IPO_BALLOTNO_INFO.ballotnoendlen
  is '尾号结束位';
comment on column IPO_BALLOTNO_INFO.ballotno
  is '尾号';
comment on column IPO_BALLOTNO_INFO.createtime
  is '尾号创建时间';
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
  is '经纪会员提货单';
comment on column IPO_BILLOFLADING.id
  is 'ID';
comment on column IPO_BILLOFLADING.brokerid
  is '会员ID';
comment on column IPO_BILLOFLADING.brokername
  is '会员名称';
comment on column IPO_BILLOFLADING.firmid
  is '交易商id';
comment on column IPO_BILLOFLADING.commodityid
  is '商品代码';
comment on column IPO_BILLOFLADING.commodityname
  is '商品名称';
comment on column IPO_BILLOFLADING.quantity
  is '数量';
comment on column IPO_BILLOFLADING.counts
  is '件数';
comment on column IPO_BILLOFLADING.deliverytype
  is '类型';
comment on column IPO_BILLOFLADING.billofladingfee
  is '提货单手续费';
comment on column IPO_BILLOFLADING.warehousingfee
  is '仓储费';
comment on column IPO_BILLOFLADING.insurance
  is '保险费';
comment on column IPO_BILLOFLADING.trusteefee
  is '托管费';
comment on column IPO_BILLOFLADING.registrationdate
  is '注册日期';
comment on column IPO_BILLOFLADING.createtime
  is '创建时间';
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
  is '品种ID';
comment on column IPO_BREED.breedname
  is '品种姓名';
comment on column IPO_BREED.sortid
  is '分类ID(对应mbreed表的categoryid)';
comment on column IPO_BREED.contractfactor
  is '交易单位';
comment on column IPO_BREED.minpricemove
  is '最小变动价格';
comment on column IPO_BREED.spreadalgr
  is '涨跌停板算法';
comment on column IPO_BREED.spreaduplmt
  is '涨幅上限';
comment on column IPO_BREED.spreaddownlmt
  is '跌幅下线';
comment on column IPO_BREED.minquantitymove
  is '最小变动数量';
comment on column IPO_BREED.contractfactorname
  is '报价单位(对应mbreed表的unit)';
comment on column IPO_BREED.minapplynum
  is '最小申购数量';
comment on column IPO_BREED.maxapplynum
  is '最大申购数量';
comment on column IPO_BREED.minapplyquamove
  is '最小申购变动量';
comment on column IPO_BREED.publishalgr
  is '发行手续费算法(1、按百分比  2、按绝对值)';
comment on column IPO_BREED.dealerpubcharatio
  is '交易商发行手续费比例';
comment on column IPO_BREED.mktdeapubcharatio
  is '交易商发行手续费市场留存比例';
comment on column IPO_BREED.publishercharatio
  is '发行商发行手续费比例';
comment on column IPO_BREED.mktpubcharatio
  is '发行商发行手续费市场留存比例';
comment on column IPO_BREED.contractcurrency
  is '报价货币(1、元 2、美元)';
comment on column IPO_BREED.tradedays
  is 'T+N交易天数';
comment on column IPO_BREED.tradealgr
  is '交易手续费算法';
comment on column IPO_BREED.buy
  is '买入';
comment on column IPO_BREED.sell
  is '卖出';
comment on column IPO_BREED.mktbuyfeeradio
  is '买方手续费市场留存比例';
comment on column IPO_BREED.mktsellfeeradio
  is '卖方手续费市场留存比例';
comment on column IPO_BREED.warehousedailyrent
  is '仓储日租金标准';
comment on column IPO_BREED.trusteedailyrent
  is '日托管费标准';
comment on column IPO_BREED.insurancedailyrent
  is '日保险费标准';
comment on column IPO_BREED.freetrusteedays
  is '免托管天数';
comment on column IPO_BREED.deliveryunit
  is '交割单位';
comment on column IPO_BREED.deliunittocontract
  is '交割与交易单位换算';
comment on column IPO_BREED.registfeeradio
  is '注册费用比例';
comment on column IPO_BREED.mktregistfeeradio
  is '注册费市场留存比例';
comment on column IPO_BREED.cancelfeeradio
  is '注销费用比例';
comment on column IPO_BREED.mktcancelfeeradio
  is '注销费市场留存比例';
comment on column IPO_BREED.deliverycostbefore
  is '提货单费用价格提前天数';
comment on column IPO_BREED.transferfeeradio
  is '过户费用比例';
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
  is '费用配置';
comment on column IPO_CHARGE_ITEM.id
  is '费用编码';
comment on column IPO_CHARGE_ITEM.name
  is '费用名称';
comment on column IPO_CHARGE_ITEM.type
  is '费用类型,1:一次性费用,2:周期性费用';
comment on column IPO_CHARGE_ITEM.parent_id
  is '上级费用编码';
comment on column IPO_CHARGE_ITEM.sort_id
  is '排序';
comment on column IPO_CHARGE_ITEM.remark
  is '备注';
comment on column IPO_CHARGE_ITEM.delete_flag
  is '删除标记 0:有效 1:无效';
comment on column IPO_CHARGE_ITEM.leaf
  is '是否叶子节点';
comment on column IPO_CHARGE_ITEM.create_user
  is '创建人';
comment on column IPO_CHARGE_ITEM.create_date
  is '创建时间';
comment on column IPO_CHARGE_ITEM.update_user
  is '修改人';
comment on column IPO_CHARGE_ITEM.update_date
  is '修改时间';
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
  is '通用费用配置表';
comment on column IPO_CHARGE_ROLE.id
  is '主键 SEQ_IPO_CHARGE_ROLE';
comment on column IPO_CHARGE_ROLE.business_code
  is '业务代码';
comment on column IPO_CHARGE_ROLE.role_code
  is '角色代码';
comment on column IPO_CHARGE_ROLE.charge_id
  is '费用项';
comment on column IPO_CHARGE_ROLE.charge_pattern
  is '收费模式 ,1:百分比 2:固定值';
comment on column IPO_CHARGE_ROLE.amount
  is '金额';
comment on column IPO_CHARGE_ROLE.delete_flag
  is '删除标记 ,0:未删除，1:已删除';
comment on column IPO_CHARGE_ROLE.create_user
  is '创建人';
comment on column IPO_CHARGE_ROLE.create_date
  is '创建时间';
comment on column IPO_CHARGE_ROLE.update_user
  is '修改人';
comment on column IPO_CHARGE_ROLE.update_date
  is '修改时间';
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
  is '特殊费用配置表';
comment on column IPO_CHARGE_USER.id
  is '主键 SEQ_IPO_CHARGE_USER';
comment on column IPO_CHARGE_USER.business_code
  is '业务代码';
comment on column IPO_CHARGE_USER.role_code
  is '角色代码';
comment on column IPO_CHARGE_USER.user_id
  is '用户ID';
comment on column IPO_CHARGE_USER.charge_id
  is '费用项';
comment on column IPO_CHARGE_USER.charge_pattern
  is '收费模式 ,1:百分比 2:固定值';
comment on column IPO_CHARGE_USER.amount
  is '金额';
comment on column IPO_CHARGE_USER.delete_flag
  is '删除标记 ,0:未删除，1:已删除';
comment on column IPO_CHARGE_USER.create_user
  is '创建人';
comment on column IPO_CHARGE_USER.create_date
  is '创建时间';
comment on column IPO_CHARGE_USER.update_user
  is '修改人';
comment on column IPO_CHARGE_USER.update_date
  is '修改时间';
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
  is '商品编号';
comment on column IPO_COMMODITY_CONF.commodityname
  is '商品名称';
comment on column IPO_COMMODITY_CONF.price
  is '发行价';
comment on column IPO_COMMODITY_CONF.units
  is '发售单位';
comment on column IPO_COMMODITY_CONF.counts
  is '发售数量';
comment on column IPO_COMMODITY_CONF.starttime
  is '起始时间';
comment on column IPO_COMMODITY_CONF.endtime
  is '结束时间';
comment on column IPO_COMMODITY_CONF.maxapplynum
  is '申购额度（最大申购数量）';
comment on column IPO_COMMODITY_CONF.status
  is '1：未配号
2：已配号
3：已摇号
4：已结算';
comment on column IPO_COMMODITY_CONF.breedid
  is '品种编号';
comment on column IPO_COMMODITY_CONF.tradedays
  is 'T+N交易天数';
comment on column IPO_COMMODITY_CONF.codedelivery
  is '是否开启标码提货(0、开启  1、关闭)';
comment on column IPO_COMMODITY_CONF.nonissuereg
  is '非发行注册(0、是  1、否)';
comment on column IPO_COMMODITY_CONF.pubmemberid
  is '发行会员编号';
comment on column IPO_COMMODITY_CONF.minapplynum
  is '最小申购数量';
comment on column IPO_COMMODITY_CONF.minapplyquamove
  is '最小申购变动量';
comment on column IPO_COMMODITY_CONF.publishalgr
  is '发行手续费算法(1、按百分比  2、按绝对值)';
comment on column IPO_COMMODITY_CONF.dealerpubcharatio
  is '交易商发行手续费比例';
comment on column IPO_COMMODITY_CONF.mktdeapubcharatio
  is '交易商发行手续费市场留存比例';
comment on column IPO_COMMODITY_CONF.publishercharatio
  is '发行商发行手续费比例';
comment on column IPO_COMMODITY_CONF.mktpubcharatio
  is '发行商发行手续费市场留存比例';
comment on column IPO_COMMODITY_CONF.currstatus
  is '当前状态 0、有效 2、暂停交易';
comment on column IPO_COMMODITY_CONF.supervisedprice
  is '开市指导价';
comment on column IPO_COMMODITY_CONF.listingdate
  is '上市日期';
comment on column IPO_COMMODITY_CONF.lasttradate
  is '最后交易日';
comment on column IPO_COMMODITY_CONF.contractfactor
  is '交易单位';
comment on column IPO_COMMODITY_CONF.contractfactorname
  is '交易单位（量词）';
comment on column IPO_COMMODITY_CONF.mapperid
  is '对应现货商品ID';
comment on column IPO_COMMODITY_CONF.minpricemove
  is '最小变动价格';
comment on column IPO_COMMODITY_CONF.spreadalgr
  is '涨跌停板算法';
comment on column IPO_COMMODITY_CONF.spreaduplmt
  is '涨幅上线';
comment on column IPO_COMMODITY_CONF.spreaddownlmt
  is '跌幅下线';
comment on column IPO_COMMODITY_CONF.minquantitymove
  is '最小变动量';
comment on column IPO_COMMODITY_CONF.tradealgr
  is '申购手续费算法';
comment on column IPO_COMMODITY_CONF.buy
  is '买入';
comment on column IPO_COMMODITY_CONF.sell
  is '卖出';
comment on column IPO_COMMODITY_CONF.mktbuyfeeradio
  is '买方手续费市场留存比例';
comment on column IPO_COMMODITY_CONF.mktsellfeeradio
  is '卖方手续费市场留存比例';
comment on column IPO_COMMODITY_CONF.warehousedailyrent
  is '仓储日租金标准';
comment on column IPO_COMMODITY_CONF.warehousestartday
  is '仓储日租金收取起始日期';
comment on column IPO_COMMODITY_CONF.trusteedailyrent
  is '日托管费标准';
comment on column IPO_COMMODITY_CONF.insurancedailyrent
  is '日保险费标准';
comment on column IPO_COMMODITY_CONF.insurancestartday
  is '日保险费收取起始日期';
comment on column IPO_COMMODITY_CONF.freetrusteedays
  is '免托管天数';
comment on column IPO_COMMODITY_CONF.deliveryunit
  is '交割单位';
comment on column IPO_COMMODITY_CONF.deliunittocontract
  is '交割与交易单位换算';
comment on column IPO_COMMODITY_CONF.deliverystartday
  is '交货开始日期';
comment on column IPO_COMMODITY_CONF.registfeeradio
  is '注册费用比例';
comment on column IPO_COMMODITY_CONF.mktregistfeeradio
  is '注册费市场留存比例';
comment on column IPO_COMMODITY_CONF.cancelfeeradio
  is '注销费用比例';
comment on column IPO_COMMODITY_CONF.mktcancelfeeradio
  is '注销费市场留存比例';
comment on column IPO_COMMODITY_CONF.deliverycostbefore
  is '提货单费用价格提前天数';
comment on column IPO_COMMODITY_CONF.commdetails
  is '商品详细描述';
comment on column IPO_COMMODITY_CONF.transferfeeradio
  is '过户费用比例';
comment on column IPO_COMMODITY_CONF.deliveryprop
  is '是否配置交收属性 （1 是 2 否）';
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
  is '商品列表';
comment on column IPO_COMMODITY_SALE.commodityid
  is '商品编号';
comment on column IPO_COMMODITY_SALE.commodityname
  is '商品名称';
comment on column IPO_COMMODITY_SALE.price
  is '发售价';
comment on column IPO_COMMODITY_SALE.units
  is '发售单位';
comment on column IPO_COMMODITY_SALE.counts
  is '发售数量';
comment on column IPO_COMMODITY_SALE.starttime
  is '起始时间';
comment on column IPO_COMMODITY_SALE.endtime
  is '结束时间';
comment on column IPO_COMMODITY_SALE.maxapplynum
  is '申购额度';
comment on column IPO_COMMODITY_SALE.status
  is '"1";// 未配号 "2";// 配号完毕 3// 抽签完毕 31";// 抽签中 32";// 费用计算完毕 "4";// 结算完毕 "41";// 结算中';
comment on column IPO_COMMODITY_SALE.id
  is '主键';
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
  is '数据项配置表';
comment on column IPO_DATA_ITEM.code
  is '编码';
comment on column IPO_DATA_ITEM.value
  is '值';
comment on column IPO_DATA_ITEM.type
  is '类别';
comment on column IPO_DATA_ITEM.remark
  is '备注';
comment on column IPO_DATA_ITEM.delete_flag
  is '删除标记 0:有效 , 1:无效';
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
  is '扣款流水记录';
comment on column IPO_DEBITFLOW.id
  is '流水号 : SEQ_IPO_DEBITFLOW';
comment on column IPO_DEBITFLOW.business_type
  is '业务类型';
comment on column IPO_DEBITFLOW.charge_type
  is '费用类型';
comment on column IPO_DEBITFLOW.commodity_id
  is '商品编号';
comment on column IPO_DEBITFLOW.order_id
  is '单号';
comment on column IPO_DEBITFLOW.debit_state
  is '扣款状态 :1冻结成功 2 扣款成功';
comment on column IPO_DEBITFLOW.payer
  is '付款人';
comment on column IPO_DEBITFLOW.amount
  is '扣款金额';
comment on column IPO_DEBITFLOW.debit_mode
  is '扣款方式:1 线上扣款 2 线下扣款';
comment on column IPO_DEBITFLOW.debit_channel
  is '扣款渠道:1 保证金扣款 2 :现金 3:刷卡 4:支付宝 5:微信';
comment on column IPO_DEBITFLOW.debit_date
  is '扣款时间';
comment on column IPO_DEBITFLOW.remark
  is '备注';
comment on column IPO_DEBITFLOW.buy_back_flag
  is '返销标记 0:未返销 1 :已返销';
comment on column IPO_DEBITFLOW.create_user
  is '创建人';
comment on column IPO_DEBITFLOW.create_date
  is '创建时间';
comment on column IPO_DEBITFLOW.update_user
  is '修改人';
comment on column IPO_DEBITFLOW.update_date
  is '修改时间';
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
  is '经纪会员商品提货';
comment on column IPO_DELIVERY.id
  is '序号';
comment on column IPO_DELIVERY.brokerid
  is '会员ID';
comment on column IPO_DELIVERY.brokername
  is '会员名称';
comment on column IPO_DELIVERY.firmid
  is '交易商id';
comment on column IPO_DELIVERY.commodityid
  is '商品代码';
comment on column IPO_DELIVERY.commodityname
  is '商品名称';
comment on column IPO_DELIVERY.quantity
  is '数量';
comment on column IPO_DELIVERY.counts
  is '件数';
comment on column IPO_DELIVERY.deliverytype
  is '类型';
comment on column IPO_DELIVERY.transferfee
  is '过户费';
comment on column IPO_DELIVERY.postage
  is '运费';
comment on column IPO_DELIVERY.transferdate
  is '过户时间';
comment on column IPO_DELIVERY.createtime
  is '创建时间';
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
  is '提货单号';
comment on column IPO_DELIVERYORDER.commodity_id
  is '商品代码';
comment on column IPO_DELIVERYORDER.commodity_name
  is '商品名称';
comment on column IPO_DELIVERYORDER.dealer_id
  is '交易商代码';
comment on column IPO_DELIVERYORDER.dealer_name
  is '交易商名称';
comment on column IPO_DELIVERYORDER.warehouse_id
  is '仓库代码';
comment on column IPO_DELIVERYORDER.warehouse_name
  is '仓库名称';
comment on column IPO_DELIVERYORDER.delivery_quatity
  is '交割数量';
comment on column IPO_DELIVERYORDER.delivery_counts
  is '交割件数';
comment on column IPO_DELIVERYORDER.delivery_method
  is '提货方式';
comment on column IPO_DELIVERYORDER.method_id
  is '关联提货方式ID';
comment on column IPO_DELIVERYORDER.unit
  is '单位';
comment on column IPO_DELIVERYORDER.delivery_date
  is '提货日期';
comment on column IPO_DELIVERYORDER.apply_date
  is '申请日期';
comment on column IPO_DELIVERYORDER.approval_status
  is 'REGISTER("001", "注册"), MARKETPASS("002001", "市场通过"), MARKETNOPASS(
				"002002", "市场驳回"), PRINTED("003001", "已自提打印"), TRANSFERRED(
				"003002", "已货权过户"), EXPRESSCOSTSET("003003", "已设置配送费用"), CONFIRM(
				"003003001", "已确认"), WAREHOUSEPASS("004001", "仓库通过"), WAREHOUSENOPASS(
				"004002", "仓库驳回"), WAREHOUSEOUT("005", "已出库"), CANCEL("006",
				"已废除");
';
comment on column IPO_DELIVERYORDER.approvers
  is '审批人';
comment on column IPO_DELIVERYORDER.approve_date
  is '审批日期';
comment on column IPO_DELIVERYORDER.canceler
  is '撤销人';
comment on column IPO_DELIVERYORDER.cancel_date
  is '撤销日期';
comment on column IPO_DELIVERYORDER.position
  is '持仓量';
comment on column IPO_DELIVERYORDER.remarks
  is '备注';
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
  is '提货单号';
comment on column IPO_DELIVERY_COST.delivery_method
  is '提货方式';
comment on column IPO_DELIVERY_COST.apply_date
  is '申请日期';
comment on column IPO_DELIVERY_COST.insurance
  is '保险费';
comment on column IPO_DELIVERY_COST.trustee_fee
  is '托管费';
comment on column IPO_DELIVERY_COST.warehousing_fee
  is '仓储费';
comment on column IPO_DELIVERY_COST.delivery_fee
  is '提货单费用';
comment on column IPO_DELIVERY_COST.registration_fee
  is '注册费';
comment on column IPO_DELIVERY_COST.cancellation_fee
  is '注销费';
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
  is '主键';
comment on column IPO_DELIVERY_PROP.commodityid
  is '商品ID';
comment on column IPO_DELIVERY_PROP.propertyid
  is '属性ID';
comment on column IPO_DELIVERY_PROP.sortno
  is '属性值对应的key';

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
  is '配号，中签结果';
comment on column IPO_DISTRIBUTION.userid
  is '客户编号';
comment on column IPO_DISTRIBUTION.commodityname
  is '商品名称';
comment on column IPO_DISTRIBUTION.startnumber
  is '起始配号';
comment on column IPO_DISTRIBUTION.pcounts
  is '配号数量';
comment on column IPO_DISTRIBUTION.ptime
  is '配号时间';
comment on column IPO_DISTRIBUTION.zcounts
  is '中签数量';
comment on column IPO_DISTRIBUTION.numbers
  is '中签号码';
comment on column IPO_DISTRIBUTION.commodityid
  is '商品编号';
comment on column IPO_DISTRIBUTION.frozen
  is '是否冻结(1表示未冻结2表示已冻结)，3表示结算过';
comment on column IPO_DISTRIBUTION.tradingamount
  is '成交金额';
comment on column IPO_DISTRIBUTION.counterfee
  is '手续费';
comment on column IPO_DISTRIBUTION.frozendate
  is '冻结日期';
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
  is '中签规则';
comment on column IPO_DISTRIBUTION_RULE.id
  is '主键';
comment on column IPO_DISTRIBUTION_RULE.commodityid
  is '商品编号';
comment on column IPO_DISTRIBUTION_RULE.hold_ratio
  is '持仓优先中签比例';
comment on column IPO_DISTRIBUTION_RULE.purchase_ratio
  is '申购量优先中签比例';
comment on column IPO_DISTRIBUTION_RULE.maxqty
  is '单账户最大中签量';
comment on column IPO_DISTRIBUTION_RULE.create_user
  is '创建人';
comment on column IPO_DISTRIBUTION_RULE.create_date
  is '创建时间';
comment on column IPO_DISTRIBUTION_RULE.update_user
  is '修改人';
comment on column IPO_DISTRIBUTION_RULE.update_date
  is '修改时间';
comment on column IPO_DISTRIBUTION_RULE.delete_flag
  is '删除标记 0:有效 1:无效';
comment on column IPO_DISTRIBUTION_RULE.hold_unit_value
  is '持仓单位市值';

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
  is '待结算佣金明细表';
comment on column IPO_FIRMREWARDDEAIL.firmid
  is '交易商id';
comment on column IPO_FIRMREWARDDEAIL.commodityid
  is '商品编码';
comment on column IPO_FIRMREWARDDEAIL.cleardate
  is '清算日期';
comment on column IPO_FIRMREWARDDEAIL.brokerid
  is '加盟商id';
comment on column IPO_FIRMREWARDDEAIL.brokername
  is '加盟商名称';
comment on column IPO_FIRMREWARDDEAIL.firstpay
  is '首款';
comment on column IPO_FIRMREWARDDEAIL.secondpay
  is '尾款';
comment on column IPO_FIRMREWARDDEAIL.reward
  is '加盟商实得手续费';
comment on column IPO_FIRMREWARDDEAIL.marketreward
  is '交易所实得手续费';
comment on column IPO_FIRMREWARDDEAIL.brokereachdivide
  is '交易手续费中加盟商手续费分成';
comment on column IPO_FIRMREWARDDEAIL.commodityname
  is '商品名称';
comment on column IPO_FIRMREWARDDEAIL.breedid
  is '品种编码';
comment on column IPO_FIRMREWARDDEAIL.breedname
  is '品种名称';
comment on column IPO_FIRMREWARDDEAIL.business_type
  is '业务类型';
comment on column IPO_FIRMREWARDDEAIL.charge_type
  is '费用类型';
comment on column IPO_FIRMREWARDDEAIL.id
  is '主键';
comment on column IPO_FIRMREWARDDEAIL.trademoney
  is '交易额';
comment on column IPO_FIRMREWARDDEAIL.order_id
  is '订单主键';
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
  is '经纪会员商品持有';
comment on column IPO_HOLDCOMMODITY.id
  is '序号';
comment on column IPO_HOLDCOMMODITY.brokerid
  is '会员ID';
comment on column IPO_HOLDCOMMODITY.brokername
  is '会员名称';
comment on column IPO_HOLDCOMMODITY.firmid
  is '交易商id';
comment on column IPO_HOLDCOMMODITY.commodityid
  is '商品代码';
comment on column IPO_HOLDCOMMODITY.commodityname
  is '商品名称';
comment on column IPO_HOLDCOMMODITY.bs_flag
  is '买卖标志';
comment on column IPO_HOLDCOMMODITY.holdqty
  is '持有数量';
comment on column IPO_HOLDCOMMODITY.frozenqty
  is '冻结数量';
comment on column IPO_HOLDCOMMODITY.quantityavailable
  is '可用数量';
comment on column IPO_HOLDCOMMODITY.evenprice
  is '持有均价';
comment on column IPO_HOLDCOMMODITY.price
  is '现价';
comment on column IPO_HOLDCOMMODITY.holdinggainsandlosses
  is '持有盈亏';
comment on column IPO_HOLDCOMMODITY.marketvalue
  is '持有市值';
comment on column IPO_HOLDCOMMODITY.createtime
  is '创建时间';
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
  is '星期几';
comment on column IPO_NOTTRADEDAY.day
  is '日期';
comment on column IPO_NOTTRADEDAY.modifytime
  is '修改时间';
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
  is '记录配号表';
comment on column IPO_NUMBEROFRECORDS.commodityid
  is '商品编号';
comment on column IPO_NUMBEROFRECORDS.counts
  is '已配个数';
comment on column IPO_NUMBEROFRECORDS.nowtime
  is '时间';
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
  is '商品编码';
comment on column IPO_NUMBEROFRECORDS_H.nowtime
  is '时间';
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
  is '订单表';
comment on column IPO_ORDER.userid
  is '客户编号';
comment on column IPO_ORDER.username
  is '客户姓名';
comment on column IPO_ORDER.commodityid
  is '商品编号';
comment on column IPO_ORDER.commodityname
  is '商品名称';
comment on column IPO_ORDER.counts
  is '客户申购数';
comment on column IPO_ORDER.createtime
  is '申购时间';
comment on column IPO_ORDER.frozenfunds
  is '资金冻结';
comment on column IPO_ORDER.frozenst
  is '冻结状态 0 ：已冻结 1 已解冻';
comment on column IPO_ORDER.commodity_id
  is '商品发售表(ipo_commodity_sale) 的id列';
comment on column IPO_ORDER.tradealgr
  is '手续费算法（1为比例2为绝对值）';
comment on column IPO_ORDER.buy
  is '手续费比例';
comment on column IPO_ORDER.frozencounterfee
  is '冻结手续费';
comment on column IPO_ORDER.unfreezefunds
  is '解冻申购金额';
comment on column IPO_ORDER.unfreezefees
  is '解冻手续费';
comment on column IPO_ORDER.successcounts
  is '中签数量';
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
  is '出库单Id';
comment on column IPO_OUTBOUND.deliveryorderid
  is '提货单号';
comment on column IPO_OUTBOUND.outboundstate
  is '出库状态(1、申请 2、审核通过 3、审核驳回)';
comment on column IPO_OUTBOUND.outbounddate
  is '出库时间';
comment on column IPO_OUTBOUND.operatorid
  is '录入员';
comment on column IPO_OUTBOUND.auditorid
  is '审核员';
comment on column IPO_OUTBOUND.warehouseid
  is '仓库代码';
comment on column IPO_OUTBOUND.deliveryperson
  is '提货人';
comment on column IPO_OUTBOUND.sex
  is '性别';
comment on column IPO_OUTBOUND.idtype
  is '证件类型';
comment on column IPO_OUTBOUND.idnum
  is '证件号码';
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
  is '付款流水表';
comment on column IPO_PAYFLOW.id
  is '流水号 SEQ_IPO_PAYFLOW';
comment on column IPO_PAYFLOW.business_type
  is '业务类型';
comment on column IPO_PAYFLOW.charge_type
  is '费用类型';
comment on column IPO_PAYFLOW.commodity_id
  is '商品编号';
comment on column IPO_PAYFLOW.order_id
  is '单号';
comment on column IPO_PAYFLOW.pay_state
  is '付款状态 :1未付款 2 已付款';
comment on column IPO_PAYFLOW.payee
  is '收款人';
comment on column IPO_PAYFLOW.amount
  is '付款金额';
comment on column IPO_PAYFLOW.pay_mode
  is '付款方式:1 线上付款 2 线下付款';
comment on column IPO_PAYFLOW.pay_channel
  is '付款渠道:1 保证金付款 2 :现金 3:刷卡 4:支付宝 5:微信';
comment on column IPO_PAYFLOW.pay_date
  is '付款时间';
comment on column IPO_PAYFLOW.remark
  is '备注';
comment on column IPO_PAYFLOW.buy_back_flag
  is '返销标记 0:未返销 1 :已返销';
comment on column IPO_PAYFLOW.create_user
  is '创建人';
comment on column IPO_PAYFLOW.create_date
  is '创建时间';
comment on column IPO_PAYFLOW.update_user
  is '修改人';
comment on column IPO_PAYFLOW.update_date
  is '修改时间';
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
  is 'ipo持仓流水表';
comment on column IPO_POSITIONFLOW.id
  is 'ipo持仓单号';
comment on column IPO_POSITIONFLOW.firmid
  is '交易商id';
comment on column IPO_POSITIONFLOW.holdqty
  is '持仓量';
comment on column IPO_POSITIONFLOW.business_code
  is '业务类型';
comment on column IPO_POSITIONFLOW.role_code
  is '角色类型';
comment on column IPO_POSITIONFLOW.commodityid
  is '商品编码';
comment on column IPO_POSITIONFLOW.price
  is '持仓价';
comment on column IPO_POSITIONFLOW.create_user
  is '创建人';
comment on column IPO_POSITIONFLOW.create_date
  is '创建日期';
comment on column IPO_POSITIONFLOW.update_user
  is '更新人';
comment on column IPO_POSITIONFLOW.update_date
  is '更新日期';
comment on column IPO_POSITIONFLOW.state
  is '状态 1:待转现货 2:已转现货';
comment on column IPO_POSITIONFLOW.frozenqty
  is '冻结数量';
comment on column IPO_POSITIONFLOW.remark
  is '备注';
comment on column IPO_POSITIONFLOW.freeqty
  is '释放数量';
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
  is 'ipo持仓流水历史表';
comment on column IPO_POSITIONFLOW_HIS.id
  is 'ipo持仓单号';
comment on column IPO_POSITIONFLOW_HIS.firmid
  is '交易商id';
comment on column IPO_POSITIONFLOW_HIS.holdqty
  is '持仓量';
comment on column IPO_POSITIONFLOW_HIS.business_code
  is '业务类型';
comment on column IPO_POSITIONFLOW_HIS.role_code
  is '角色类型';
comment on column IPO_POSITIONFLOW_HIS.commodityid
  is '商品编码';
comment on column IPO_POSITIONFLOW_HIS.price
  is '持仓价';
comment on column IPO_POSITIONFLOW_HIS.create_user
  is '创建人';
comment on column IPO_POSITIONFLOW_HIS.create_date
  is '创建日期';
comment on column IPO_POSITIONFLOW_HIS.update_user
  is '更新人';
comment on column IPO_POSITIONFLOW_HIS.update_date
  is '更新日期';
comment on column IPO_POSITIONFLOW_HIS.state
  is '状态 1:待转现货 2:已转现货';
comment on column IPO_POSITIONFLOW_HIS.frozenqty
  is '冻结数量';
comment on column IPO_POSITIONFLOW_HIS.remark
  is '备注';
comment on column IPO_POSITIONFLOW_HIS.freeqty
  is '释放数量';
comment on column IPO_POSITIONFLOW_HIS.oper_user
  is '操作人';
comment on column IPO_POSITIONFLOW_HIS.oper_date
  is '操作日期';

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
  is '持仓减持记录';
comment on column IPO_POSITIONREDUCE.id
  is '主键';
comment on column IPO_POSITIONREDUCE.positionflow_id
  is 'ipo持仓单号';
comment on column IPO_POSITIONREDUCE.ratio
  is '减持比例';
comment on column IPO_POSITIONREDUCE.reduceqty
  is '减持数量';
comment on column IPO_POSITIONREDUCE.create_user
  is '创建人';
comment on column IPO_POSITIONREDUCE.create_date
  is '创建日期';
comment on column IPO_POSITIONREDUCE.update_user
  is '修改人';
comment on column IPO_POSITIONREDUCE.update_date
  is '修改日期';
comment on column IPO_POSITIONREDUCE.state
  is '状态 1:未减持 2:已减持';
comment on column IPO_POSITIONREDUCE.delete_flag
  is '删除标记 0:有效 1:无效';
comment on column IPO_POSITIONREDUCE.reduce_date
  is '减持日期';
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
  is '主键 SEQ_IPO_PUBLISHER_POSITION';
comment on column IPO_PUBLISHER_POSITION.publisherid
  is '发行会员代码';
comment on column IPO_PUBLISHER_POSITION.commodityid
  is '商品代码';
comment on column IPO_PUBLISHER_POSITION.totalvalue
  is '总市值';
comment on column IPO_PUBLISHER_POSITION.pubposition
  is '转持仓量';
comment on column IPO_PUBLISHER_POSITION.salecounts
  is '转发售量';
comment on column IPO_PUBLISHER_POSITION.totalcounts
  is '总量';
comment on column IPO_PUBLISHER_POSITION.status
  is '状态(1、新增 2、已冻结 3、已扣款 4、已转持仓)';
comment on column IPO_PUBLISHER_POSITION.creater
  is '创建人';
comment on column IPO_PUBLISHER_POSITION.createdate
  is '创建日期';
comment on column IPO_PUBLISHER_POSITION.updater
  is '操作人';
comment on column IPO_PUBLISHER_POSITION.updatedate
  is '操作日期';
comment on column IPO_PUBLISHER_POSITION.storageid
  is '关联入库单的主键';
comment on column IPO_PUBLISHER_POSITION.subscricounts
  is '供承销认购量';
comment on column IPO_PUBLISHER_POSITION.subscriberatio
  is '承销商认购优惠比例';
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
  is '主键 SEQ_IPO_PUBPAYMENT_TRACK 序列生成';
comment on column IPO_PUBPAYMENT_TRACK.commodityid
  is '商品代码';
comment on column IPO_PUBPAYMENT_TRACK.payables
  is '应付货款';
comment on column IPO_PUBPAYMENT_TRACK.status
  is '状态  1 未付款 2 已付款';
comment on column IPO_PUBPAYMENT_TRACK.createperson
  is '创建人';
comment on column IPO_PUBPAYMENT_TRACK.createdate
  is '创建日期';
comment on column IPO_PUBPAYMENT_TRACK.updateperson
  is '更新人';
comment on column IPO_PUBPAYMENT_TRACK.updatedate
  is '更新日期';
comment on column IPO_PUBPAYMENT_TRACK.deleteflag
  is '删除标记 0 有效 1 删除';
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
  is '经纪会员申购明细';
comment on column IPO_RELEASESUBSCRIPTION.id
  is '序号';
comment on column IPO_RELEASESUBSCRIPTION.brokerid
  is '会员ID';
comment on column IPO_RELEASESUBSCRIPTION.brokername
  is '会员名称';
comment on column IPO_RELEASESUBSCRIPTION.firmid
  is '交易商ID';
comment on column IPO_RELEASESUBSCRIPTION.commodityid
  is '商品代码';
comment on column IPO_RELEASESUBSCRIPTION.commodityname
  is '商品名称';
comment on column IPO_RELEASESUBSCRIPTION.issueprice
  is '发行定价';
comment on column IPO_RELEASESUBSCRIPTION.purchasetime
  is '申购时间';
comment on column IPO_RELEASESUBSCRIPTION.purchasequantity
  is '申购数量';
comment on column IPO_RELEASESUBSCRIPTION.purchaseamount
  is '申购金额';
comment on column IPO_RELEASESUBSCRIPTION.issuancefee
  is '发行服务费';
comment on column IPO_RELEASESUBSCRIPTION.refundablepurchaseamount
  is '退还申购金额';
comment on column IPO_RELEASESUBSCRIPTION.refundableservicefee
  is '退还发行服务费';
comment on column IPO_RELEASESUBSCRIPTION.createtime
  is '创建时间';
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
  is '持仓报表（每天历史）';
comment on column IPO_RF_FIRMHOLDSUM.cleardate
  is '创建时间';
comment on column IPO_RF_FIRMHOLDSUM.firmid
  is '交易商id';
comment on column IPO_RF_FIRMHOLDSUM.commodityid
  is '商品id';
comment on column IPO_RF_FIRMHOLDSUM.bs_flag
  is '买卖标志';
comment on column IPO_RF_FIRMHOLDSUM.holdqty
  is '持仓量';
comment on column IPO_RF_FIRMHOLDSUM.holdfunds
  is '持仓金额';
comment on column IPO_RF_FIRMHOLDSUM.floatingloss
  is '浮动盈亏';
comment on column IPO_RF_FIRMHOLDSUM.evenprice
  is '持仓均价';
comment on column IPO_RF_FIRMHOLDSUM.holdmargin
  is '保证金';
comment on column IPO_RF_FIRMHOLDSUM.gageqty
  is '抵顶数量';
comment on column IPO_RF_FIRMHOLDSUM.holdassure
  is '持仓担保金';
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
  is '主键';
comment on column IPO_SPECIALCOUNTERFEE.firmid
  is '交易商代码';
comment on column IPO_SPECIALCOUNTERFEE.commodityid
  is '商品代码';
comment on column IPO_SPECIALCOUNTERFEE.tradealgr
  is '交易手续费算法   1:比例 2：绝对值';
comment on column IPO_SPECIALCOUNTERFEE.counterfee
  is '手续费';
comment on column IPO_SPECIALCOUNTERFEE.sell
  is '（暂不用）';
comment on column IPO_SPECIALCOUNTERFEE.updatedate
  is '修改时间';
comment on column IPO_SPECIALCOUNTERFEE.userid
  is '修改人代码';
comment on column IPO_SPECIALCOUNTERFEE.counterfeetype
  is '手续费种类（暂定）1.交易买2.交易卖3.发行';
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
  is '增发id';
comment on column IPO_SPO_COMMODITYMANMAAGEMENT.commodity_id
  is '商品代码';
comment on column IPO_SPO_COMMODITYMANMAAGEMENT.spo_counts
  is '增发数量';
comment on column IPO_SPO_COMMODITYMANMAAGEMENT.spo_price
  is '增发价格';
comment on column IPO_SPO_COMMODITYMANMAAGEMENT.register_date
  is '登记日期';
comment on column IPO_SPO_COMMODITYMANMAAGEMENT.spo_date
  is '增发日期';
comment on column IPO_SPO_COMMODITYMANMAAGEMENT.ipo_date
  is '上市日期';
comment on column IPO_SPO_COMMODITYMANMAAGEMENT.spo_sate
  is '1:未增发
2:增发成功3.增发失败4：未增发（未到增发日期） 5：已配售';
comment on column IPO_SPO_COMMODITYMANMAAGEMENT.ration_type
  is '1:比例配售 2:定向配售';
comment on column IPO_SPO_COMMODITYMANMAAGEMENT.not_ration_counts
  is '未配售数量';
comment on column IPO_SPO_COMMODITYMANMAAGEMENT.success_ration_counts
  is '已配售数量';
comment on column IPO_SPO_COMMODITYMANMAAGEMENT.min_ration_counts
  is '最小配售数量';
comment on column IPO_SPO_COMMODITYMANMAAGEMENT.min_ration_proportion
  is '最小配售比例';
comment on column IPO_SPO_COMMODITYMANMAAGEMENT.rebate
  is '1:已返佣
2:未返佣';
comment on column IPO_SPO_COMMODITYMANMAAGEMENT.be_listed
  is '1:已上市
2:未上市';
comment on column IPO_SPO_COMMODITYMANMAAGEMENT.pre_placement
  is '预配售';
comment on column IPO_SPO_COMMODITYMANMAAGEMENT.positions_price
  is '持仓价格';

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
  is '配售ID';
comment on column IPO_SPO_RATION.spoid
  is '增发ID';
comment on column IPO_SPO_RATION.rationcounts
  is '配售数量';
comment on column IPO_SPO_RATION.firmid
  is '交易商ID';
comment on column IPO_SPO_RATION.operationdate
  is '操作日期';
comment on column IPO_SPO_RATION.rationloan
  is '配售货款';
comment on column IPO_SPO_RATION.servicefee
  is '服务费';
comment on column IPO_SPO_RATION.sales_allocationratio
  is '承销商分配比例';
comment on column IPO_SPO_RATION.sales_rebateratio
  is '承销商返佣比例';
comment on column IPO_SPO_RATION.firmname
  is '交易商名称';
comment on column IPO_SPO_RATION.salesid
  is '承销商代码';
comment on column IPO_SPO_RATION.ration_sate
  is '配售状态(1:未确认配售 2：已确认配售)';
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
  is '申请编号';
comment on column IPO_STOCK_FREEZE.commodityid
  is '商品代码';
comment on column IPO_STOCK_FREEZE.customerid
  is '交易商ID';
comment on column IPO_STOCK_FREEZE.state
  is '状态';
comment on column IPO_STOCK_FREEZE.freeze_number
  is '冻结数量';
comment on column IPO_STOCK_FREEZE.createtime
  is '冻结时间';
comment on column IPO_STOCK_FREEZE.reviewtime
  is '操作时间';
comment on column IPO_STOCK_FREEZE.operator
  is '操作人';
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
  is '申请编号';
comment on column IPO_STOCK_TRANSFERRECORDS.commodityid
  is '商品代码';
comment on column IPO_STOCK_TRANSFERRECORDS.customerid_apply
  is '申请过户方交易商代码';
comment on column IPO_STOCK_TRANSFERRECORDS.customerid_accept
  is '接受过户方交易商代码';
comment on column IPO_STOCK_TRANSFERRECORDS.transfer_number
  is '过户数量';
comment on column IPO_STOCK_TRANSFERRECORDS.state
  is '状态';
comment on column IPO_STOCK_TRANSFERRECORDS.remarks
  is '备注';
comment on column IPO_STOCK_TRANSFERRECORDS.createtime
  is '创建时间';
comment on column IPO_STOCK_TRANSFERRECORDS.reviewtime
  is '审核时间';
comment on column IPO_STOCK_TRANSFERRECORDS.operator
  is '操作人';
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
  is '入库单号';
comment on column IPO_STORAGE.commodityid
  is '商品代码';
comment on column IPO_STORAGE.storagenum
  is '入库件数';
comment on column IPO_STORAGE.startnum
  is '起始编码';
comment on column IPO_STORAGE.endnum
  is '结束编码';
comment on column IPO_STORAGE.operatorid
  is '录入员';
comment on column IPO_STORAGE.warehouseauditorid
  is '仓库审核员';
comment on column IPO_STORAGE.marketauditorid
  is '市场审核员';
comment on column IPO_STORAGE.storagestate
  is '入库状态(1、申请 2、仓库通过 3、仓库驳回 4、市场通过 5、市场驳回)';
comment on column IPO_STORAGE.storagedate
  is '入库时间';
comment on column IPO_STORAGE.warehouseid
  is '仓库代码';
comment on column IPO_STORAGE.mapperbillid
  is '关联仓单ID';
comment on column IPO_STORAGE.storagecounts
  is '入库数量';
comment on column IPO_STORAGE.transferstatus
  is '转持仓状态（1、新增 2、已冻结 3、已扣款 4、已转持仓）';
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
  is '交易节名称';
comment on column IPO_TRADETIME.starttime
  is '开始时间';
comment on column IPO_TRADETIME.endtime
  is '结束时间';
comment on column IPO_TRADETIME.status
  is '状态
0:有效
1:无效';
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
  is '主键';
comment on column IPO_TRADETIME_COMM.tradetimeid
  is '交易节ID';
comment on column IPO_TRADETIME_COMM.commodityid
  is '商品ID';
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
  is '托管记录 ';
comment on column IPO_TRUSTEESHIP.id
  is '主键 ,SEQ_ipo_trusteeship';
comment on column IPO_TRUSTEESHIP.apply_amount
  is '申请数量';
comment on column IPO_TRUSTEESHIP.instorage_amount
  is '入库数量';
comment on column IPO_TRUSTEESHIP.effective_amount
  is '供申购数量';
comment on column IPO_TRUSTEESHIP.position_amount
  is '持仓数量';
comment on column IPO_TRUSTEESHIP.trusteeship_commodity_id
  is '托管商品,外键 IPO_Trusteeship_commodity.id';
comment on column IPO_TRUSTEESHIP.state
  is ' 1:申请,2:撤销,3:仓库初审通过,4:仓库初审驳回,5:仓库终审通过,6:仓库终审驳回, 7:市场审核通过,8:市场审核驳回,9:已增持加仓,10:已设置预减持';
comment on column IPO_TRUSTEESHIP.price
  is '发行价';
comment on column IPO_TRUSTEESHIP.publish_charge
  is '发行手续费';
comment on column IPO_TRUSTEESHIP.delay_charge
  is '滞纳金';
comment on column IPO_TRUSTEESHIP.listing_charge
  is '挂牌费';
comment on column IPO_TRUSTEESHIP.auditing_date
  is '审核时间';
comment on column IPO_TRUSTEESHIP.create_user
  is '创建人';
comment on column IPO_TRUSTEESHIP.create_date
  is '创建时间';
comment on column IPO_TRUSTEESHIP.update_user
  is '修改人';
comment on column IPO_TRUSTEESHIP.update_date
  is '修改时间';
comment on column IPO_TRUSTEESHIP.delete_flag
  is '删除标记 0:有效 1:无效';
comment on column IPO_TRUSTEESHIP.commodity_id
  is '商品编号';
comment on column IPO_TRUSTEESHIP.warehouse_id
  is '仓库id';
comment on column IPO_TRUSTEESHIP.reduce_date
  is '减持日期';
comment on column IPO_TRUSTEESHIP.reduce_ratio
  is '减持百分比';
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
  is '托管商品';
comment on column IPO_TRUSTEESHIP_COMMODITY.id
  is '主键 SEQ_IPO_Trusteeship_commodity';
comment on column IPO_TRUSTEESHIP_COMMODITY.commodity_id
  is '商品编号';
comment on column IPO_TRUSTEESHIP_COMMODITY.plan
  is '托管计划';
comment on column IPO_TRUSTEESHIP_COMMODITY.purchase_rate
  is '申购发行比例';
comment on column IPO_TRUSTEESHIP_COMMODITY.remark
  is '备注';
comment on column IPO_TRUSTEESHIP_COMMODITY.delete_flag
  is '删除标记 0:有效 1:无效';
comment on column IPO_TRUSTEESHIP_COMMODITY.create_user
  is '创建人';
comment on column IPO_TRUSTEESHIP_COMMODITY.create_date
  is '创建时间';
comment on column IPO_TRUSTEESHIP_COMMODITY.update_user
  is '修改人';
comment on column IPO_TRUSTEESHIP_COMMODITY.update_date
  is '修改时间';
comment on column IPO_TRUSTEESHIP_COMMODITY.listing_charge_rate
  is '挂牌费比例';
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
  is '托管记录历史表 ';
comment on column IPO_TRUSTEESHIP_HIS.id
  is '主键 ,SEQ_ipo_trusteeship_his';
comment on column IPO_TRUSTEESHIP_HIS.trusteeship_id
  is '托管记录id';
comment on column IPO_TRUSTEESHIP_HIS.state
  is '1:申请,2:撤销,3:仓库初审通过,4:仓库初审驳回,5:仓库终审通过,6:仓库终审驳回, 7:市场审核通过,8:市场审核驳回,9:已增持加仓,10:已设置预减持';
comment on column IPO_TRUSTEESHIP_HIS.content
  is 'json格式记录上次操作的信息';
comment on column IPO_TRUSTEESHIP_HIS.create_user
  is '创建人';
comment on column IPO_TRUSTEESHIP_HIS.create_date
  is '创建时间';
comment on column IPO_TRUSTEESHIP_HIS.remark
  is '备注';
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
  is '托管仓库';
comment on column IPO_TRUSTEESHIP_WAREHOUSE.id
  is '主键 SEQ_IPO_Trusteeship_warehouse';
comment on column IPO_TRUSTEESHIP_WAREHOUSE.commodity_id
  is '商品编号';
comment on column IPO_TRUSTEESHIP_WAREHOUSE.warehouse_id
  is '仓库id';
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
  is '承销商押金';
comment on column IPO_UNDERWRITER_DEPOSIT.id
  is '主键,SEQ_ipo_underwriter_deposit';
comment on column IPO_UNDERWRITER_DEPOSIT.amount
  is '预付款金额';
comment on column IPO_UNDERWRITER_DEPOSIT.remark
  is '备注';
comment on column IPO_UNDERWRITER_DEPOSIT.create_user
  is '创建人';
comment on column IPO_UNDERWRITER_DEPOSIT.create_date
  is '创建时间';
comment on column IPO_UNDERWRITER_DEPOSIT.update_user
  is '修改人';
comment on column IPO_UNDERWRITER_DEPOSIT.update_date
  is '修改时间';
comment on column IPO_UNDERWRITER_DEPOSIT.brokerid
  is '承销会员编号';
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
  is '主键,seq_ipo_underwriter_sub';
comment on column IPO_UNDERWRITER_SUBSCRIBE.underwriterid
  is '承销会员ID';
comment on column IPO_UNDERWRITER_SUBSCRIBE.commodityid
  is '商品ID';
comment on column IPO_UNDERWRITER_SUBSCRIBE.subscribecounts
  is '认购数量';
comment on column IPO_UNDERWRITER_SUBSCRIBE.proportion
  is '占承销商手续费总和的比例';
comment on column IPO_UNDERWRITER_SUBSCRIBE.delete_flag
  is '删除标记 0:有效 1:无效';
comment on column IPO_UNDERWRITER_SUBSCRIBE.create_user
  is '创建人';
comment on column IPO_UNDERWRITER_SUBSCRIBE.create_date
  is '创建时间';
comment on column IPO_UNDERWRITER_SUBSCRIBE.update_user
  is '修改人';
comment on column IPO_UNDERWRITER_SUBSCRIBE.update_date
  is '修改时间';
comment on column IPO_UNDERWRITER_SUBSCRIBE.subscribeprice
  is '认购价格';
comment on column IPO_UNDERWRITER_SUBSCRIBE.state
  is '处理状态（1、未处理 2、已处理）';
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
  is '入库数量';
comment on column IPO_WAREHOUSE_STOCK.forzennum
  is '冻结数量';
comment on column IPO_WAREHOUSE_STOCK.availablenum
  is '有效数量';
comment on column IPO_WAREHOUSE_STOCK.outboundnum
  is '出库数量';
comment on column IPO_WAREHOUSE_STOCK.warehouseid
  is '仓库ID(与bi_warehouse的ID主键关联)';
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
  is '1 互踢;2 不互踢';
comment on column L_AUCONFIG.sysname
  is '前台：front
后台：mgr
仓库端：warehouse
会员端：broker';
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
  is '代为委托员表';
comment on column M_AGENTTRADER.type
  is '0 代为委托员
1 强平员';
comment on column M_AGENTTRADER.status
  is '0 正常
1 禁止登陆';
comment on column M_AGENTTRADER.operatefirm
  is '空表示所有
否则交易商用逗号分隔，如 0001,0002,0003';
comment on column M_AGENTTRADER.modifytime
  is '最后一次修改时间';
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
  is '交易模式 1：诚信保障金模式 2：保证金模式';
comment on column M_BREED.status
  is '1：正常 2：已删除';
comment on column M_BREED.belongmodule
  is '分类所属模块 以|分割';
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
  is '品名对应的属性值列表，有哪些属性来自商品分类属性表
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
  is 'breed：品种
category：分类
leaf：叶子节点';
comment on column M_CATEGORY.status
  is '1：正常 2：已删除';
comment on column M_CATEGORY.isoffset
  is 'Y:此品种可能出现损溢 N:此品种不可能出现损溢';
comment on column M_CATEGORY.offsetrate
  is '申请损益万分比<1';
comment on column M_CATEGORY.belongmodule
  is '分类所属模块 以|分割';
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
  is 'Y 显示 N 不显示';
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
  is '10综合管理平台
11财务系统
12监管仓库管理系统
13仓单管理系统
14融资系统
15订单交易
18投资类大宗商品交易系统
19加盟会员管理系统
20做市商交易系统
21竞价系统
22银行接入及结算系统
23E现货
24单点登录系统
25实时行情分析系统
26交易客户端
98demo系统
99公用系统';

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
  is '1：法人
2：代理
3：个人';
comment on column M_FIRM.firmcategoryid
  is '-1 表示未分类';
comment on column M_FIRM.status
  is 'N：正常 Normal
D：冻结 Disable
E：注销 Erase';
alter table M_FIRM
  add constraint PK_M_FIRM primary key (FIRMID);

prompt
prompt Creating table M_FIRMCATEGORY
prompt =============================
prompt
create table M_FIRMCATEGORY
(
  id        NUMBER(10) not null,
  name      VARCHAR2(128) default '未分类' not null,
  note      VARCHAR2(128),
  isvisibal CHAR(1) default 'Y' not null,
  sortno    NUMBER(2) default 0 not null
)
;
comment on column M_FIRMCATEGORY.isvisibal
  is 'Y 显示 N 不显示';
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
  is '交易商在各个交易模块是否可用';
comment on column M_FIRMMODULE.moduleid
  is '10综合管理平台
11财务系统
12监管仓库管理系统
13仓单管理系统
14融资系统
15订单交易
18投资类大宗商品交易系统
19加盟会员管理系统
20做市商交易系统
21竞价系统
22银行接入及结算系统
23E现货
24单点登录系统
25实时行情分析系统
26交易客户端
98demo系统
99公用系统';
comment on column M_FIRMMODULE.enabled
  is 'Y：启用  N：禁用';
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
  is '1：法人
2：代理
3：个人';
comment on column M_FIRM_APPLY.status
  is '0：待审核
1：审核通过
2：审核不通过';
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
  is 'Y 显示 N 不显示';
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
  is '接收人类型：1 在线交易员 2 在线管理员 3 在线用户 4 指定交易员 5 指定管理员';
comment on column M_MESSAGE.userid
  is '管理员Id';
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
  is '管理员Id';
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
  is '交易商添加修改删除存储的错误码记录';
comment on column M_PROCEDURES_ERRORCODE.moduleid
  is '10综合管理平台
11财务系统
12监管仓库管理系统
13仓单管理系统
14融资系统
15订单交易
18投资类大宗商品交易系统
19加盟会员管理系统
20做市商交易系统
21竞价系统
22银行接入及结算系统
23E现货
24单点登录系统
25实时行情分析系统
26交易客户端
98demo系统
99公用系统';
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
  is 'Y：有值字典  N：无值字典';
comment on column M_PROPERTY.stockcheck
  is 'Y：检查  N：不检查 M：不完全检查(选择多个值，匹配其中之一)';
comment on column M_PROPERTY.searchable
  is 'Y：用于列表搜索 N：不用于搜索';
comment on column M_PROPERTY.isnecessary
  is 'Y：必填项；N：选填项';
comment on column M_PROPERTY.fieldtype
  is '0：字符串；1：数字';
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
  is '0 可见 1 不可见';
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
  is '手续费、保证金等参数设置';
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
  is '交易员表，每个交易商有个与交易商ID相同的交易员作为默认交易员，不可删除。';
comment on column M_TRADER.forcechangepwd
  is '0：否
1：是';
comment on column M_TRADER.status
  is 'N：正常 Normal
D：禁用 Disable';
comment on column M_TRADER.type
  is 'A：管理员
N：一般交易员';
comment on column M_TRADER.modifytime
  is '最后一次修改时间';
comment on column M_TRADER.enablekey
  is 'Y：启用
N：不启用';
comment on column M_TRADER.trustkey
  is '客户端登录成功后，在本地和服务端记录一个信任Key，不限制重试次数。';
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
  is '交易员在各个交易模块是否可用';
comment on column M_TRADERMODULE.moduleid
  is '10综合管理平台
11财务系统
12监管仓库管理系统
13仓单管理系统
14融资系统
15订单交易
18投资类大宗商品交易系统
19加盟会员管理系统
20做市商交易系统
21竞价系统
22银行接入及结算系统
23E现货
24单点登录系统
25实时行情分析系统
26交易客户端
98demo系统
99公用系统';
comment on column M_TRADERMODULE.enabled
  is 'Y：启用  N：禁用';
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
  is 'Y 显示 N 不显示';
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
  is '交易商交易系统权限';
comment on column SYS_FIRM_PERMISSION.firmid
  is '交易商id';
comment on column SYS_FIRM_PERMISSION.modeid
  is '权限系统';
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
  is '市场代码';
comment on column T_A_MARKET.marketname
  is '市场名称';
comment on column T_A_MARKET.status
  is '状态';
comment on column T_A_MARKET.runmode
  is '运行模式';
comment on column T_A_MARKET.settlemode
  is '交收模式';
comment on column T_A_MARKET.floatinglosscomputetype
  is '浮亏计算方式';
comment on column T_A_MARKET.closealgr
  is '平仓算法';
comment on column T_A_MARKET.tradepricealgr
  is '成交价算法';
comment on column T_A_MARKET.tradeflowtype
  is '写成交流水类型';
comment on column T_A_MARKET.floatingprofitsubtax
  is '浮动盈亏是否扣税';
comment on column T_A_MARKET.gagemode
  is '抵顶模式';
comment on column T_A_MARKET.tradetimetype
  is '交易时间类型';
comment on column T_A_MARKET.delayquoshowtype
  is '延期交收行情显示类型';
comment on column T_A_MARKET.neutralfeeway
  is '中立仓交收手续费收取方式';
comment on column T_A_MARKET.delayneedbill
  is '延期交收是否需要仓单';
comment on column T_A_MARKET.neutralflag
  is '中立仓启用标志 0不启用，1启用';
comment on column T_A_MARKET.neutralmatchpriority
  is '中立仓撮合优先级';
comment on column T_A_MARKET.quotationtwoside
  is '行情单双边';
comment on column T_A_MARKET.asmargintype
  is '提前交收是否收取保证金';
comment on column T_A_MARKET.delayorderispure
  is '交收申报是否按净订货量申报 0：否，1：是';
comment on column T_A_MARKET.chargedelayfeetype
  is '收取延期补偿金类型 0：按净订货量收取（默认）；1：按单边订货总量收取；';
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
  is '待结算佣金明细表';
comment on column T_BR_FIRMREWARDDEAIL.firmid
  is '交易商id';
comment on column T_BR_FIRMREWARDDEAIL.commodityid
  is '商品编码';
comment on column T_BR_FIRMREWARDDEAIL.cleardate
  is '清算日期';
comment on column T_BR_FIRMREWARDDEAIL.rewardtype
  is '手续类型 0:交易';
comment on column T_BR_FIRMREWARDDEAIL.brokerid
  is '加盟商id';
comment on column T_BR_FIRMREWARDDEAIL.brokername
  is '加盟商名称';
comment on column T_BR_FIRMREWARDDEAIL.firstpay
  is '首款';
comment on column T_BR_FIRMREWARDDEAIL.secondpay
  is '尾款';
comment on column T_BR_FIRMREWARDDEAIL.reward
  is '加盟商实得手续费';
comment on column T_BR_FIRMREWARDDEAIL.marketreward
  is '交易所实得手续费';
comment on column T_BR_FIRMREWARDDEAIL.brokereachdivide
  is '交易手续费中加盟商手续费分成';
comment on column T_BR_FIRMREWARDDEAIL.quantity
  is '交易数量';
comment on column T_BR_FIRMREWARDDEAIL.trademoney
  is '交易额';
comment on column T_BR_FIRMREWARDDEAIL.brokerageid
  is '交易商直属居间商代码';
comment on column T_BR_FIRMREWARDDEAIL.brokeragename
  is '交易商直属居间商名称';
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
  is '主键（商品代码）';
comment on column T_COMMODITY.name
  is '商品名称';
comment on column T_COMMODITY.sortid
  is '商品分类ID';
comment on column T_COMMODITY.status
  is '状态';
comment on column T_COMMODITY.contractfactor
  is '合约因子';
comment on column T_COMMODITY.minpricemove
  is '最小价位变动';
comment on column T_COMMODITY.breedid
  is '商品品种';
comment on column T_COMMODITY.spreadalgr
  is '涨跌幅算法';
comment on column T_COMMODITY.spreaduplmt
  is '涨幅上限';
comment on column T_COMMODITY.spreaddownlmt
  is '跌幅下限';
comment on column T_COMMODITY.feealgr
  is '手续费算法';
comment on column T_COMMODITY.feerate_b
  is '手续费系数';
comment on column T_COMMODITY.feerate_s
  is '手续费系数';
comment on column T_COMMODITY.marginalgr
  is '保证金算法';
comment on column T_COMMODITY.marginrate_b
  is '交易保证金系数';
comment on column T_COMMODITY.marginrate_s
  is '交易保证金系数';
comment on column T_COMMODITY.marketdate
  is '上市日期';
comment on column T_COMMODITY.settledate
  is '交收日期';
comment on column T_COMMODITY.settledate1
  is '交收相关日期1';
comment on column T_COMMODITY.marginitem1
  is '买保证金额项1';
comment on column T_COMMODITY.settledate2
  is '交收相关日期2';
comment on column T_COMMODITY.marginitem2
  is '买保证金额项2';
comment on column T_COMMODITY.settledate3
  is '交收相关日期3';
comment on column T_COMMODITY.marginitem3
  is '买保证金额项3 交收月第十个日首款标准';
comment on column T_COMMODITY.settledate4
  is '交收相关日期4';
comment on column T_COMMODITY.marginitem4
  is '买保证金额项4';
comment on column T_COMMODITY.lastprice
  is '价格';
comment on column T_COMMODITY.marginitem1_s
  is '卖保证金额项1';
comment on column T_COMMODITY.marginitem2_s
  is '卖保证金额项2';
comment on column T_COMMODITY.marginitem3_s
  is '卖保证金额项3';
comment on column T_COMMODITY.marginitem4_s
  is '卖保证金额项4';
comment on column T_COMMODITY.marginassure_b
  is '担保金系数';
comment on column T_COMMODITY.marginassure_s
  is '卖担保金系数';
comment on column T_COMMODITY.marginitemassure1
  is '买担保金款项1';
comment on column T_COMMODITY.marginitemassure2
  is '买担保金款项2';
comment on column T_COMMODITY.marginitemassure3
  is '买担保金款项3';
comment on column T_COMMODITY.marginitemassure4
  is '买担保金款项4';
comment on column T_COMMODITY.marginitemassure1_s
  is '卖担保金款项1';
comment on column T_COMMODITY.marginitemassure2_s
  is '卖担保金款项2';
comment on column T_COMMODITY.marginitemassure3_s
  is '卖担保金款项3';
comment on column T_COMMODITY.marginitemassure4_s
  is '卖担保金款项4';
comment on column T_COMMODITY.todayclosefeerate_b
  is '今开今平买手续费系数';
comment on column T_COMMODITY.todayclosefeerate_s
  is '今开今平卖手续费系数';
comment on column T_COMMODITY.historyclosefeerate_b
  is '夜单平仓买手续费系数';
comment on column T_COMMODITY.historyclosefeerate_s
  is '隔夜单平仓卖手续费系数';
comment on column T_COMMODITY.limitcmdtyqty
  is '商品数量限制 单个交易商品的总订货量不能大于此值，-1表示不限制';
comment on column T_COMMODITY.settlefeealgr
  is '交收手续费算法';
comment on column T_COMMODITY.settlefeerate_b
  is '交收买手续费系数';
comment on column T_COMMODITY.settlefeerate_s
  is '收卖手续费系数';
comment on column T_COMMODITY.forceclosefeealgr
  is '为转让手续费算法';
comment on column T_COMMODITY.forceclosefeerate_b
  is '代为转让买手续费系数';
comment on column T_COMMODITY.forceclosefeerate_s
  is '代为转让卖手续费系数';
comment on column T_COMMODITY.settlemarginalgr_b
  is '买交收保证金算法';
comment on column T_COMMODITY.settlemarginrate_b
  is '交收保证金买系数';
comment on column T_COMMODITY.settlemarginalgr_s
  is '卖交收保证金算法';
comment on column T_COMMODITY.settlemarginrate_s
  is '交收保证金卖系数';
comment on column T_COMMODITY.reservecount
  is '行情订货量';
comment on column T_COMMODITY.addedtax
  is '增值税率';
comment on column T_COMMODITY.marginpricetype
  is '保证金计算方式';
comment on column T_COMMODITY.lowestsettlefee
  is '交收手续费最低金额';
comment on column T_COMMODITY.firmcleanqty
  is '交易商净订货量';
comment on column T_COMMODITY.firmmaxholdqty
  is '最大持仓量';
comment on column T_COMMODITY.payoutalgr
  is '交收货款算法';
comment on column T_COMMODITY.payoutrate
  is '收货款系数';
comment on column T_COMMODITY.addedtaxfactor
  is '增值税系数';
comment on column T_COMMODITY.settledate5
  is '交收相关日期5';
comment on column T_COMMODITY.marginitem5
  is '买保证金款项5';
comment on column T_COMMODITY.marginitem5_s
  is '保证金款项5';
comment on column T_COMMODITY.marginitemassure5
  is '买担保金款项5';
comment on column T_COMMODITY.marginitemassure5_s
  is '卖担保金款项5';
comment on column T_COMMODITY.settlepricetype
  is '交收价计算方式';
comment on column T_COMMODITY.beforedays
  is '计算交收价的提前日';
comment on column T_COMMODITY.specsettleprice
  is '收结算价';
comment on column T_COMMODITY.orderprivilege_b
  is '买方委托权限';
comment on column T_COMMODITY.orderprivilege_s
  is '卖方委托权限';
comment on column T_COMMODITY.firmmaxholdqtyalgr
  is '交易商订货量限制算法';
comment on column T_COMMODITY.startpercentqty
  is '商品百分比阀值量';
comment on column T_COMMODITY.maxpercentlimit
  is '交易商订货量最大百分比';
comment on column T_COMMODITY.onemaxholdqty
  is '单笔最大委托量';
comment on column T_COMMODITY.minquantitymove
  is '最小变动数量';
comment on column T_COMMODITY.delayrecouprate
  is '买方延期补偿比率';
comment on column T_COMMODITY.settleway
  is '交收方式 0：中远期 1：连续现货 2：专场交易';
comment on column T_COMMODITY.delayfeeway
  is '延期费收取方式';
comment on column T_COMMODITY.maxfeerate
  is '最大交易手续费系数';
comment on column T_COMMODITY.minsettlemoveqty
  is '最小交割单位';
comment on column T_COMMODITY.storerecouprate
  is '仓储补偿比率';
comment on column T_COMMODITY.minsettleqty
  is '最小交割数量';
comment on column T_COMMODITY.delayrecouprate_s
  is '卖方延期补偿比率';
comment on column T_COMMODITY.aheadsettlepricetype
  is '提前交收交收价格类型';
comment on column T_COMMODITY.delaysettlepricetype
  is '商品单边订货量限制 0：以结算价作为交收价格  ，1：以订立价作为交收价格';
comment on column T_COMMODITY.settlemargintype
  is '交收保证金计算方式';
comment on column T_COMMODITY.beforedays_m
  is '提前几日计算交收保证金价';
comment on column T_COMMODITY.sideholdlimitqty
  is '商品单边订货量限制';
comment on column T_COMMODITY.holddayslimit
  is '是否启用持仓天数限制';
comment on column T_COMMODITY.maxholdpositionday
  is '最长持仓天数';
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
  is '主键交易客户ID';
comment on column T_CUSTOMERHOLDSUM.commodityid
  is '商品代码';
comment on column T_CUSTOMERHOLDSUM.bs_flag
  is '买卖标志 1:买 buy，2:卖 sell';
comment on column T_CUSTOMERHOLDSUM.holdqty
  is '持仓数量';
comment on column T_CUSTOMERHOLDSUM.holdfunds
  is '持仓金额';
comment on column T_CUSTOMERHOLDSUM.floatingloss
  is '浮动盈亏';
comment on column T_CUSTOMERHOLDSUM.evenprice
  is '持仓均价';
comment on column T_CUSTOMERHOLDSUM.frozenqty
  is '冻结数量';
comment on column T_CUSTOMERHOLDSUM.holdmargin
  is '实时保证金';
comment on column T_CUSTOMERHOLDSUM.gageqty
  is '抵顶数量';
comment on column T_CUSTOMERHOLDSUM.holdassure
  is '持仓担保金';
comment on column T_CUSTOMERHOLDSUM.firmid
  is '交易商ID';
comment on column T_CUSTOMERHOLDSUM.gagefrozenqty
  is '抵顶冻结数量';
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
  is '交易日期';
comment on column T_DELAYSTATUS.status
  is '状态 0:初始化完成,1:交收申报,2:节间休息,3:中立仓申报,4:暂停交易,5:交易结束';
comment on column T_DELAYSTATUS.sectionid
  is '交易节编号';
comment on column T_DELAYSTATUS.note
  is '备注';
comment on column T_DELAYSTATUS.recovertime
  is '暂停后自动恢复时间';
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
  is '交易商ID';
comment on column T_FIRM.status
  is '状态';
comment on column T_FIRM.maxholdqty
  is '最大持仓量';
comment on column T_FIRM.mincleardeposit
  is '最低结算准备金';
comment on column T_FIRM.maxoverdraft
  is '最大透支额度';
comment on column T_FIRM.virtualfunds
  is '虚拟资金';
comment on column T_FIRM.runtimefl
  is '临时浮亏';
comment on column T_FIRM.clearfl
  is '结算浮亏';
comment on column T_FIRM.runtimemargin
  is '临时交易保证金';
comment on column T_FIRM.clearmargin
  is '结算交易保证金';
comment on column T_FIRM.runtimeassure
  is '临时担保金';
comment on column T_FIRM.clearassure
  is '结算担保金';
comment on column T_FIRM.runtimesettlemargin
  is '当日交收保证金';
comment on column T_FIRM.clearsettlemargin
  is '当日交收保证金';
comment on column T_FIRM.tariffid
  is '套餐ID';
comment on column T_FIRM.modifytime
  is '修改时间';
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
  is '交易商持仓汇总';
comment on column T_FIRMHOLDSUM.firmid
  is '交易商ID';
comment on column T_FIRMHOLDSUM.commodityid
  is '商品代码';
comment on column T_FIRMHOLDSUM.bs_flag
  is '买卖标志';
comment on column T_FIRMHOLDSUM.holdqty
  is '持仓数量';
comment on column T_FIRMHOLDSUM.holdfunds
  is '仓金额';
comment on column T_FIRMHOLDSUM.floatingloss
  is '浮动盈亏';
comment on column T_FIRMHOLDSUM.evenprice
  is '持仓均价';
comment on column T_FIRMHOLDSUM.holdmargin
  is '实时保证金';
comment on column T_FIRMHOLDSUM.gageqty
  is '抵顶数量';
comment on column T_FIRMHOLDSUM.holdassure
  is '持仓担保金';
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
  is '持仓单号';
comment on column T_HOLDPOSITION.a_tradeno
  is '成交号';
comment on column T_HOLDPOSITION.customerid
  is '交易客户ID';
comment on column T_HOLDPOSITION.commodityid
  is '商品代码';
comment on column T_HOLDPOSITION.bs_flag
  is '买卖标志';
comment on column T_HOLDPOSITION.price
  is '价格';
comment on column T_HOLDPOSITION.holdqty
  is '持仓数量 ';
comment on column T_HOLDPOSITION.openqty
  is '开仓数量';
comment on column T_HOLDPOSITION.holdtime
  is '持仓时间（精确到秒）';
comment on column T_HOLDPOSITION.holdmargin
  is '实时保证金';
comment on column T_HOLDPOSITION.firmid
  is '交易商ID';
comment on column T_HOLDPOSITION.gageqty
  is '抵顶数量';
comment on column T_HOLDPOSITION.holdassure
  is '持仓担保金';
comment on column T_HOLDPOSITION.floatingloss
  is '浮动亏损资金';
comment on column T_HOLDPOSITION.holdtype
  is '持仓类型';
comment on column T_HOLDPOSITION.atcleardate
  is '订货所属结算日期';
comment on column T_HOLDPOSITION.deadline
  is '到期日期';
comment on column T_HOLDPOSITION.remainday
  is '到期天数';
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
  is '主键';
comment on column T_ORDERS.a_orderno_w
  is '委托单号';
comment on column T_ORDERS.commodityid
  is '商品代码';
comment on column T_ORDERS.customerid
  is '交易客户ID';
comment on column T_ORDERS.traderid
  is '交易员ID';
comment on column T_ORDERS.bs_flag
  is '买卖标志';
comment on column T_ORDERS.ordertype
  is '委托类型';
comment on column T_ORDERS.status
  is '状态';
comment on column T_ORDERS.withdrawtype
  is '撤单类型';
comment on column T_ORDERS.failcode
  is '委托失败代码';
comment on column T_ORDERS.quantity
  is '数量';
comment on column T_ORDERS.price
  is '委托价格';
comment on column T_ORDERS.closemode
  is '平仓方式';
comment on column T_ORDERS.specprice
  is '价格';
comment on column T_ORDERS.timeflag
  is '指定时间标志';
comment on column T_ORDERS.tradeqty
  is '已成交数量';
comment on column T_ORDERS.frozenfunds
  is '冻结资金';
comment on column T_ORDERS.unfrozenfunds
  is '解冻资金数量';
comment on column T_ORDERS.ordertime
  is '委托时间';
comment on column T_ORDERS.withdrawtime
  is '撤单时间';
comment on column T_ORDERS.ordererip
  is '委托者IP';
comment on column T_ORDERS.signature
  is '防抵赖码';
comment on column T_ORDERS.closeflag
  is '平仓标志';
comment on column T_ORDERS.firmid
  is '交易商ID';
comment on column T_ORDERS.consignerid
  is '委托员ID';
comment on column T_ORDERS.withdrawerid
  is '撤单员ID';
comment on column T_ORDERS.updatetime
  is '更新时间';
comment on column T_ORDERS.billtradetype
  is '仓单交易类型';
comment on column T_ORDERS.specialorderflag
  is '撮合类型';
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
  is '商品代码';
comment on column T_QUOTATION.yesterbalanceprice
  is '昨结算价';
comment on column T_QUOTATION.closeprice
  is '昨收盘价';
comment on column T_QUOTATION.openprice
  is '今开市场';
comment on column T_QUOTATION.highprice
  is '最高价';
comment on column T_QUOTATION.lowprice
  is '最低价';
comment on column T_QUOTATION.curprice
  is '最新价';
comment on column T_QUOTATION.curamount
  is '最新价所对应的成交量';
comment on column T_QUOTATION.openamount
  is '开仓';
comment on column T_QUOTATION.buyopenamount
  is '买开仓';
comment on column T_QUOTATION.sellopenamount
  is '卖开仓';
comment on column T_QUOTATION.closeamount
  is '平仓';
comment on column T_QUOTATION.buycloseamount
  is '买平仓';
comment on column T_QUOTATION.sellcloseamount
  is '卖平仓';
comment on column T_QUOTATION.reservecount
  is '行情订货量';
comment on column T_QUOTATION.reservechange
  is '仓差';
comment on column T_QUOTATION.price
  is '结算价';
comment on column T_QUOTATION.totalmoney
  is '总成交额';
comment on column T_QUOTATION.totalamount
  is '总成交量';
comment on column T_QUOTATION.spread
  is '涨跌';
comment on column T_QUOTATION.buyprice1
  is '买入价1';
comment on column T_QUOTATION.sellprice1
  is '卖出价1';
comment on column T_QUOTATION.buyamount1
  is '申买量1';
comment on column T_QUOTATION.sellamount1
  is '申卖量1';
comment on column T_QUOTATION.buyprice2
  is '买入价2';
comment on column T_QUOTATION.sellprice2
  is '卖出价2';
comment on column T_QUOTATION.buyamount2
  is '申买量2';
comment on column T_QUOTATION.sellamount2
  is '申卖量2';
comment on column T_QUOTATION.buyprice3
  is '买入价3';
comment on column T_QUOTATION.sellprice3
  is '卖出价3';
comment on column T_QUOTATION.buyamount3
  is '申买量3';
comment on column T_QUOTATION.sellamount3
  is '申卖量3';
comment on column T_QUOTATION.buyprice4
  is '买入价4';
comment on column T_QUOTATION.sellprice4
  is '卖出价4';
comment on column T_QUOTATION.buyamount4
  is '申买量4';
comment on column T_QUOTATION.sellamount4
  is '申卖量4';
comment on column T_QUOTATION.buyprice5
  is '买入价5';
comment on column T_QUOTATION.sellprice5
  is '卖出价5';
comment on column T_QUOTATION.buyamount5
  is '申买量5';
comment on column T_QUOTATION.sellamount5
  is '申卖量5';
comment on column T_QUOTATION.buyprice6
  is '买入价6';
comment on column T_QUOTATION.sellprice6
  is '卖出价6';
comment on column T_QUOTATION.buyamount6
  is '申买量6';
comment on column T_QUOTATION.sellamount6
  is '申卖量6';
comment on column T_QUOTATION.buyprice7
  is '买入价7';
comment on column T_QUOTATION.sellprice7
  is '卖出价7';
comment on column T_QUOTATION.buyamount7
  is '申买量7';
comment on column T_QUOTATION.sellamount7
  is '申卖量7';
comment on column T_QUOTATION.buyprice8
  is '买入价8';
comment on column T_QUOTATION.sellprice8
  is '卖出价8';
comment on column T_QUOTATION.buyamount8
  is '申买量8';
comment on column T_QUOTATION.sellamount8
  is '申卖量8';
comment on column T_QUOTATION.buyprice9
  is '买入价9';
comment on column T_QUOTATION.sellprice9
  is '卖出价9';
comment on column T_QUOTATION.buyamount9
  is '申买量9';
comment on column T_QUOTATION.sellamount9
  is '申卖量9';
comment on column T_QUOTATION.buyprice10
  is '买入价10';
comment on column T_QUOTATION.sellprice10
  is '卖出价10';
comment on column T_QUOTATION.buyamount10
  is '申买量10';
comment on column T_QUOTATION.sellamount10
  is '申卖量10';
comment on column T_QUOTATION.outamount
  is '外盘';
comment on column T_QUOTATION.inamount
  is '内盘';
comment on column T_QUOTATION.tradecue
  is '交易提示';
comment on column T_QUOTATION.no
  is '计数字段';
comment on column T_QUOTATION.createtime
  is '创建时间';
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
  is '交收交易客户持仓明细表id';
comment on column T_SETTLEANDHOLD.matchid
  is '交收配对编号';
comment on column T_SETTLEANDHOLD.tax
  is '税费';
comment on column T_SETTLEANDHOLD.bs_flag
  is '买卖标记1买，2卖';

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
  is '交收税费';
comment on column T_SETTLEMATCH.taxincluesive
  is '商品是否含税,0默认含税，1为不含税';
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
  is '成交号';
comment on column T_TRADE.a_orderno
  is '委托单号';
comment on column T_TRADE.tradetime
  is '成交时间';
comment on column T_TRADE.customerid
  is '交易客户ID';
comment on column T_TRADE.commodityid
  is '商品代码';
comment on column T_TRADE.bs_flag
  is '买卖标志 1:买 buy 2:卖 sell';
comment on column T_TRADE.ordertype
  is '委托类型';
comment on column T_TRADE.price
  is '价格';
comment on column T_TRADE.quantity
  is '数量';
comment on column T_TRADE.close_pl
  is '平仓盈亏';
comment on column T_TRADE.tradefee
  is '手易续费';
comment on column T_TRADE.tradetype
  is '成交类型';
comment on column T_TRADE.holdprice
  is '订货价格';
comment on column T_TRADE.holdtime
  is '订货时间';
comment on column T_TRADE.firmid
  is '交易商ID';
comment on column T_TRADE.closeaddedtax
  is '平仓增值税';
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
  is '管理员Id';
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
  is '操作人';
comment on column W_GLOBALLOG_ALL.operatetime
  is '操作时间';
comment on column W_GLOBALLOG_ALL.operatetype
  is '操作类型';
comment on column W_GLOBALLOG_ALL.operateip
  is '操作IP';
comment on column W_GLOBALLOG_ALL.operatortype
  is '操作人种类';
comment on column W_GLOBALLOG_ALL.mark
  is '标示';
comment on column W_GLOBALLOG_ALL.operatecontent
  is '操作内容';
comment on column W_GLOBALLOG_ALL.currentvalue
  is '当前值';
comment on column W_GLOBALLOG_ALL.operateresult
  is '操作结果 1 成功  0 失败';
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
  is '操作人';
comment on column W_GLOBALLOG_ALL_H.operatetime
  is '操作时间';
comment on column W_GLOBALLOG_ALL_H.operatetype
  is '操作类型';
comment on column W_GLOBALLOG_ALL_H.operateip
  is '操作IP';
comment on column W_GLOBALLOG_ALL_H.operatortype
  is '操作人种类';
comment on column W_GLOBALLOG_ALL_H.mark
  is '标示';
comment on column W_GLOBALLOG_ALL_H.operatecontent
  is '操作内容';
comment on column W_GLOBALLOG_ALL_H.currentvalue
  is '当前值';
comment on column W_GLOBALLOG_ALL_H.operateresult
  is '操作结果 1 成功  0 失败';
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
  is '日志分类，4位数字的编码，以日志模块ID开头。';
comment on column W_LOGCATALOG.catalogid
  is '日志分类ID：4位数字的编码，详见备注Notes。';
comment on column W_LOGCATALOG.catalogname
  is '日志分类名';
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
  is ' 规范：
1：开头两位为系统模块号
2: 第三四位为一级菜单
3：第五六位为二级菜单
4：第七八位为三级菜单
5：第九十位为页面中的增删改查
';
comment on column W_RIGHT.parentid
  is '父关联';
comment on column W_RIGHT.name
  is '权限名称';
comment on column W_RIGHT.icon
  is '图标';
comment on column W_RIGHT.authorityurl
  is '权限路径';
comment on column W_RIGHT.visiturl
  is '真实路径';
comment on column W_RIGHT.seq
  is '序号';
comment on column W_RIGHT.visible
  is '是否可见-1 不可见0 可见';
comment on column W_RIGHT.type
  is '类型-3:只检查session不检查权限的url -2：无需判断权限的URL -1： 父菜单类型 0：子菜单类型 1：页面内增删改查权限';
comment on column W_RIGHT.catalogid
  is '日志类型 0不写日志 其它对应表w_logcatalog 的CATALOGID字段';
comment on column W_RIGHT.iswritelog
  is '''Y''：写日志、''N''：不写日志';
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
  is '角色Id';
comment on column W_ROLE.name
  is '角色名称';
comment on column W_ROLE.description
  is '描述';
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
  is '权限Id';
comment on column W_ROLE_RIGHT.roleid
  is '角色Id';
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
  is '10综合管理平台
11财务系统
12监管仓库管理系统
13仓单管理系统
14融资系统
15订单交易
18投资类大宗商品交易系统
19加盟会员管理系统
20做市商交易系统
21竞价系统
22银行接入及结算系统
23E现货
24单点登录系统
25实时行情分析系统
26交易客户端
98demo系统
99公用系统';
comment on column W_TRADEMODULE.isfirmset
  is '‘Y’ 是 ‘N’ 否 (如果需要在公用前台我的平台中显示本系统，还需要在公用系统的 spring_sys_msg.xml 中配置上本系统的配置信息)';
comment on column W_TRADEMODULE.isbalancecheck
  is 'Y：是 N：否';
comment on column W_TRADEMODULE.isneedbreed
  is '本系统是否需要综合管理平台增加的商品   Y:是   N:否';
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
  is '管理员Id';
comment on column W_USER.name
  is '管理员名称';
comment on column W_USER.password
  is '密码';
comment on column W_USER.type
  is 'ADMIN：普通管理员角色DEFAULT_ADMIN：高级管理员角色DEFAULT_SUPER_ADMIN：默认超级管理员角色';
comment on column W_USER.description
  is '描述';
comment on column W_USER.isforbid
  is 'Y：禁用
N：不禁用
';
comment on column W_USER.skin
  is '皮肤';
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
  is '权限Id
权限Id';
comment on column W_USER_RIGHT.userid
  is '管理员Id';
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
  is '管理员Id';
comment on column W_USER_ROLE.roleid
  is '角色Id';
alter table W_USER_ROLE
  add primary key (USERID, ROLEID);


spool off
