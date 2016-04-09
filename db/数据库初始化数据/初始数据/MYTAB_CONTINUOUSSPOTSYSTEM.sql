prompt Importing table MYTAB_CONTINUOUSSPOTSYSTEM...
set feedback off
set define off
insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('W_USER_ROLE', '管理员与角色对应关系', '空表', null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('W_USER_RIGHT', '权限与管理员对应关系', '空表', null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('W_USER', '管理员表', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('W_TRADEMODULE', '各类系统参数表', '"10综合管理平台11财务系统12监管仓库管理系统13仓单管理系统14融资系统15订单交易18投资类大宗商品交易系统19加盟会员管理系统20做市商交易系统21竞价系统22银行接入及结算系统23E现货24单点登录系统25实时行情分析系统26交易客户端98demo系统99公用系统"', null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('W_ROLE_RIGHT', '角色与权限对应关系', '空表', null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('W_ROLE', '角色描述表', '空表', null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('W_RIGHT', '菜单与jsp页面对应关系', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('W_MYMENU', '不清楚', '空表', null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('W_LOGCATALOG', '日志分类说明', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('W_GLOBALLOG_ALL_H', '操作人操作日志历史', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('W_GLOBALLOG_ALL', '操作人操作日志', '空表', null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('W_ERRORLOGINLOG', '管理员登陆Ip日志', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('V_TRADEUSER', '可能限制用户业务上一些东西', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('V_TRADEMODEPARAMS', '竞价名称表', '"1 竞买2 竞卖3 招标"', null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('V_TRADEAUTHORITY', '不清楚', '空表', null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('V_TEMPLETCLASSSET', '竞价功能与java类的对应关系', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('V_SYSPROPERTY', '竞价业务持续时间、暂停时间等参数', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('V_SYSPARTITION', '竞价功能参数相关的java类', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('V_SYSLOG', '竞价操作日志表', '空表', null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('V_SYSCURSTATUS', '竞价状态参数表', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('V_SECTIONATTRIBUTE', '属性参数', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('V_HISTRADEUSER', '历史用户表', '空表', null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('V_HISTRADEAUTHORITY', '历史用户操作表', '空表', null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('V_HISSUBMIT', '用户提交数据(可能是日志)', '包含单价、数量、总价、手续费等', null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('V_HISCOMMODITY', '产品修改日志', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('V_HISBARGAIN', '用户购买产品日志', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('V_FUNDFROZEN', '用户资金冻结及可用余额', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('V_FLOWCONTROL', '交易品种开始、持续、倒计时', '难道是竞拍？？？？', null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('V_FIRMSPECIALMARGIN', 'FIRM相关的参数', '空表', null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('V_FIRMSPECIALFEE', 'FIRM相关的钱', '空表', null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('V_CURSUBMITTENDERPLAN', '客户投标提交计划（预埋单）', '空表', null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('V_CURSUBMITTENDER', '客户投标提交（下单）', '里面好多字段代表钱，但是是空表', null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('V_CURSUBMIT', '客户提交数据', '空表,是不是成交？？？', null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('V_CURCOMMODITY', '客户修改某个参数', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('V_CONTRACTTEMPLET', '不清楚', '空表', null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('V_COMMODITYSELF', '不清楚', '空表', null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('V_COMMODITYPARAMS', '商品买卖参数表', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('V_COMMODITY', '商品第一次上市配置表', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('V_COMMEXT', '商品产地、品牌、质量参数表', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('V_BARGAIN', '不清楚', '空表', null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_VALIDGAGEBILL', '有效账单参数表', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_UNTRADETRANSFER', '无交易转让', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_TRADER', '业务与操作类型对应表', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_TRADEDAYS', '业务时间', '空表', null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_TRADE', '业务流水', '空表', null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_SYSTEMSTATUS', '系统状态表', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_SUBSYSTEM', '子系统开通配置表', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_SPECFROZENHOLD', '不清楚', '空表', null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_SETTLEPROPS', '产地、品牌、颜色、拉伸系数配置表', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_SETTLEMATCHLOG', '交收配对日志', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_SETTLEMATCHFUNDMANAGE', '企业商品准备金（押金）管理？', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_SETTLEMATCH', '交收撮合匹配表', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_SETTLEHOLDPOSITION', '客户交收时持仓信息', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_SETTLECOMMODITY', '商品行情表', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_SETTLEANDHOLD', '交收交易客户持仓明细表', '空表', null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_RMICONF', '服务与IP地址对应表', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_QUOTATION', '收盘报价表', '收盘相关？', null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_ORDERS', '不清楚-可能是商品实时报价', '空表', null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_MATCHSETTLEHOLDRELEVANCE', '交收库存相关', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_H_TRADE', '客户历史报价流水？', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_H_QUOTATION', '商品历史收盘报价', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_H_ORDERS', '商品历史报价', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_H_MARKET', '历史市场参数管理', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_H_HOLDPOSITION', '客户历史持仓', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_H_FIRMSETTLEMARGIN', '公司结算保证金历史', '空表', null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_H_FIRMSETTLEFEE', '公司结算费用历史', '空表', null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_H_FIRMMARGIN', '公司利润历史', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_H_FIRMHOLDSUM', '企业(会员)历史持仓？', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_H_FIRMFEE', '公司持仓费用表', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_H_FIRM', '企业(会员)经营历史', '"最大持有数量企业持有金额最大透支"', null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_H_DIRECTFIRMBREED', '不清楚', '空表', null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_H_DELAYTRADE', '延误贸易历史', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_H_DELAYQUOTATION', '商品延期报价(交收？)历史', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_H_DELAYORDERS', '延期订货单', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_H_CUSTOMERHOLDSUM', '客户持仓历史', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_H_CONDITIONORDER', '客户、商品的一些限制', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_H_COMMODITY', '商品配置历史', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_HOLDPOSITION', '客户持仓记录', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_HOLDFROZEN', '客户商品冻结表 ', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_FIRMHOLDSUM', '公司（会员）持仓记录', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_FIRM', '公司（会员）资料属性表', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_E_PLEDGE', '公司质押表', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_E_HISGAGEBILL', '公司商品质押数量历史计账单', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_E_GAGEBILL', '公司商品质押数量计账单', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_E_DIRECTFIRMBREED', '公司与质押品种对应关系', '空表', null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_E_DEDUCTPOSITION', '扣押商品的一些属性', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_E_DEDUCTKEEP', '扣押编号与客户关系', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_E_DEDUCTDETAIL', '扣押明细表', '空表', null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_E_APPLYTREATYSETTLE', '买卖客户抵押申请？', '空表', null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_E_APPLYGAGE', '客户申请抵押商品和数量', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_E_APPLYAHEADSETTLE', '买卖客户申请提前结算', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_D_DELAYORDERSUMLOG', '会员商品延迟交割日志', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_D_DELAYORDERLOG', '会员商品延迟订单日志', '空表', null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_DELAYTRADE', '延期交易主表', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_DELAYSTATUS', '延期交易属性表', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_DELAYQUOTATION', '延迟报价', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_DELAYORDERS', '延迟订货', '空表', null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_DBLOG', '错误日志', '空表', null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_CUSTOMERHOLDSUM', '客户持仓', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_CUSTOMER', '客户与会员信息对应表', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_CURMINNO', '不清楚', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_CONDITIONORDER', '不清楚', '空表', null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_COMMODITY', '商品明细表', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_CLEARSTATUS', '业务动作状态表', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_BR_FIRMREWARDDEAIL', '公司奖励详细(返佣？)', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_BILLFROZEN', '冻结账号', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_BALANCESTATUS', '账目状态？', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_A_TRADETIME', '开关市时间', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_A_TRADEPRIVILEGE', '交易权限', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_A_TARIFF', '税费', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_A_SETTLEPRIVILEGE', '类型权限对应表', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_A_NOTTRADEDAY', '非交易时间设定', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_A_MARKET', '交易市场设定', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_A_FIRMSETTLEMARGIN', '公司(会员)结算保证金', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_A_FIRMSETTLEFEE', '公司（会员）结算费用', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_A_FIRMMAXHOLDQTY', '公司（会员）商品最高持有数量', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_A_FIRMMARGIN', '公司（会员）商品利润', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_A_FIRMFEE', '公司（会员）商品费率（手续费）？', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_A_FIRMBREEDSETTLEMARGIN', '公司（会员）结算保证金', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_A_FIRMBREEDSETTLEFEE', '公司（会员）结算费用（手续费）', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_A_FIRMBREEDMAXHOLDQTY', '公司（会员）品种最大持有数量', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_A_FIRMBREEDMARGIN', '公司（会员）利润', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_A_FIRMBREEDFEE', '公司（会员）产生费', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_A_DAYSECTION', '工作日设定', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_A_COMMODITYTRADEPROP', '商品交易参数设定', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_A_COMMODITYSETTLEPROP', '商品结算参数设定', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_A_CMDTYSORT', '不清楚', '空表', null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_A_BREEDTRADEPROP', '业务品种某个属性设定 ', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_A_BREED', '品种表', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('T_APPLY', '申请表', '空表', null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('TM_TRADEMONITOR_H', '交易监控', '空表', null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('TM_TRADEMONITOR', '交易监控', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('M_ZONE', '区县', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('M_TRADERMODULE', '业务模块', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('M_TRADER', '贸易商表', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('M_SYSTEMPROPS', '系统属性 ', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('M_PROPERTYTYPE', '属性类型定义表', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('M_PROPERTY', '属性定义表', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('M_PROCEDURES_ERRORCODE', '程序出错定义', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('M_NOTICE', '信息通知', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('M_MESSAGE', '短消息', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('M_INDUSTRY', '行业类别', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('M_FIRM_APPLY', '会员人员明细表', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('M_FIRMMODULE', '操作员使用系统模块表', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('M_FIRMCATEGORY', '企业类别', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('M_FIRM', '会员人员表', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('M_ERRORLOGINLOG', '错误登录日志', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('M_CERTIFICATETYPE', '证件类型', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('M_CATEGORY', '商品类别表', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('M_BREEDPROPS', '品种属性表', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('M_BREED', '品种明细表', null, null);

insert into MYTAB_CONTINUOUSSPOTSYSTEM (T_NAME, T_FUNCTION, T_EXPLAIN, T_REMARK)
values ('M_AGENTTRADER', '代理贸易商', null, null);
commit;

prompt Done.
