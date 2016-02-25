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
  trademoney       NUMBER(15,2)
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
  unfreezefees     NUMBER(15,2)
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
  is '客户编号';
comment on column IPO_ORDER_H.username
  is '客户姓名';
comment on column IPO_ORDER_H.commodityid
  is '商品编号';
comment on column IPO_ORDER_H.commodityname
  is '商品名称';
comment on column IPO_ORDER_H.counts
  is '客户申购数';
comment on column IPO_ORDER_H.createtime
  is '申购时间';
comment on column IPO_ORDER_H.frozenfunds
  is '资金冻结';
comment on column IPO_ORDER_H.commodity_id
  is '发售id';
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
  is '持仓流水表';
comment on column IPO_POSITION.positionid
  is '持仓单号';
comment on column IPO_POSITION.firmid
  is '交易商id';
comment on column IPO_POSITION.position
  is '持仓量';
comment on column IPO_POSITION.commodityid
  is '商品id';
comment on column IPO_POSITION.position_price
  is '持仓价';
comment on column IPO_POSITION.position_unit
  is '持仓单位';
comment on column IPO_POSITION.operation_time
  is '操作日期';
comment on column IPO_POSITION.commodityname
  is '商品名称';
comment on column IPO_POSITION.reduction_num
  is '预减持数量';
comment on column IPO_POSITION.reduction_date
  is '预减持日期';
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
  is '持仓单号';
comment on column IPO_POSITION_HIS.firmid
  is '交易商id';
comment on column IPO_POSITION_HIS.position
  is '持仓量';
comment on column IPO_POSITION_HIS.commodityid
  is '商品id';
comment on column IPO_POSITION_HIS.commodityname
  is '商品名称';
comment on column IPO_POSITION_HIS.position_price
  is '持仓价';
comment on column IPO_POSITION_HIS.position_unit
  is '持仓单位';
comment on column IPO_POSITION_HIS.reduction_num
  is '预减持数量';
comment on column IPO_POSITION_HIS.reduction_date
  is '预减持日期';
comment on column IPO_POSITION_HIS.create_user
  is '创建人';
comment on column IPO_POSITION_HIS.create_date
  is '创建时间';

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
  is '承销商押金';
comment on column IPO_UNDERWRITER_DEPOSIT.id
  is '主键,SEQ_ipo_underwriter_deposit';
comment on column IPO_UNDERWRITER_DEPOSIT.amount
  is '预付款金额';
comment on column IPO_UNDERWRITER_DEPOSIT.remark
  is '备注';
comment on column IPO_UNDERWRITER_DEPOSIT.delete_flag
  is '删除标记 0:有效 1:无效';
comment on column IPO_UNDERWRITER_DEPOSIT.create_user
  is '创建人';
comment on column IPO_UNDERWRITER_DEPOSIT.create_date
  is '创建时间';
comment on column IPO_UNDERWRITER_DEPOSIT.update_user
  is '修改人';
comment on column IPO_UNDERWRITER_DEPOSIT.update_date
  is '修改时间';
comment on column IPO_UNDERWRITER_DEPOSIT.state
  is '1: 未冻结；2：已冻结；3：已扣款s';
comment on column IPO_UNDERWRITER_DEPOSIT.subscribeid
  is '承销设置主键';
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
  is '主键,seq_ipo_underwriter_sub';
comment on column IPO_UNDERWRITER_SUBSCRIBE.underwriterid
  is '承销商ID';
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


spool off
