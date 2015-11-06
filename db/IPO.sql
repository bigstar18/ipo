
-- ----------------------------
-- Table structure for IPO_BALLOTNO_INFO
-- ----------------------------
DROP TABLE "TRADE_GNNT"."IPO_BALLOTNO_INFO";
CREATE TABLE "TRADE_GNNT"."IPO_BALLOTNO_INFO" (
"ID" NUMBER NOT NULL ,
"COMMODITYID" VARCHAR2(32 BYTE) NOT NULL ,
"BALLOTNOSTARTLEN" NUMBER NOT NULL ,
"BALLOTNOENDLEN" NUMBER NOT NULL ,
"BALLOTNO" VARCHAR2(32 BYTE) NULL ,
"CREATETIME" DATE NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "TRADE_GNNT"."IPO_BALLOTNO_INFO" IS '????????????';

-- ----------------------------
-- Indexes structure for table IPO_BALLOTNO_INFO
-- ----------------------------

-- ----------------------------
-- Checks structure for table IPO_BALLOTNO_INFO
-- ----------------------------
ALTER TABLE "TRADE_GNNT"."IPO_BALLOTNO_INFO" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TRADE_GNNT"."IPO_BALLOTNO_INFO" ADD CHECK ("COMMODITYID" IS NOT NULL);
ALTER TABLE "TRADE_GNNT"."IPO_BALLOTNO_INFO" ADD CHECK ("BALLOTNOSTARTLEN" IS NOT NULL);
ALTER TABLE "TRADE_GNNT"."IPO_BALLOTNO_INFO" ADD CHECK ("BALLOTNOENDLEN" IS NOT NULL);
ALTER TABLE "TRADE_GNNT"."IPO_BALLOTNO_INFO" ADD CHECK ("CREATETIME" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table IPO_BALLOTNO_INFO
-- ----------------------------
ALTER TABLE "TRADE_GNNT"."IPO_BALLOTNO_INFO" ADD PRIMARY KEY ("ID");










-- ----------------------------
-- Table structure for IPO_COMMODITY
-- ----------------------------
DROP TABLE "TRADE_GNNT"."IPO_COMMODITY";
CREATE TABLE "TRADE_GNNT"."IPO_COMMODITY" (
"ID" NUMBER(8) NOT NULL ,
"COMMODITYID" VARCHAR2(32 BYTE) NOT NULL ,
"COMMODITYNAME" VARCHAR2(32 BYTE) NOT NULL ,
"PRICE" NUMBER(11,3) NOT NULL ,
"UNITS" NUMBER NOT NULL ,
"COUNTS" NUMBER NOT NULL ,
"STARTTIME" DATE NOT NULL ,
"ENDTIME" DATE NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "TRADE_GNNT"."IPO_COMMODITY" IS '��Ʒ�б�';
COMMENT ON COLUMN "TRADE_GNNT"."IPO_COMMODITY"."COMMODITYID" IS '��Ʒ���';
COMMENT ON COLUMN "TRADE_GNNT"."IPO_COMMODITY"."COMMODITYNAME" IS '��Ʒ����';
COMMENT ON COLUMN "TRADE_GNNT"."IPO_COMMODITY"."PRICE" IS '���ۼ�';
COMMENT ON COLUMN "TRADE_GNNT"."IPO_COMMODITY"."UNITS" IS '���۵�λ';
COMMENT ON COLUMN "TRADE_GNNT"."IPO_COMMODITY"."COUNTS" IS '��������';
COMMENT ON COLUMN "TRADE_GNNT"."IPO_COMMODITY"."STARTTIME" IS '��ʼʱ��';
COMMENT ON COLUMN "TRADE_GNNT"."IPO_COMMODITY"."ENDTIME" IS '����ʱ��';

-- ----------------------------
-- Indexes structure for table IPO_COMMODITY
-- ----------------------------

-- ----------------------------
-- Checks structure for table IPO_COMMODITY
-- ----------------------------
ALTER TABLE "TRADE_GNNT"."IPO_COMMODITY" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TRADE_GNNT"."IPO_COMMODITY" ADD CHECK ("COMMODITYID" IS NOT NULL);
ALTER TABLE "TRADE_GNNT"."IPO_COMMODITY" ADD CHECK ("COMMODITYNAME" IS NOT NULL);
ALTER TABLE "TRADE_GNNT"."IPO_COMMODITY" ADD CHECK ("PRICE" IS NOT NULL);
ALTER TABLE "TRADE_GNNT"."IPO_COMMODITY" ADD CHECK ("UNITS" IS NOT NULL);
ALTER TABLE "TRADE_GNNT"."IPO_COMMODITY" ADD CHECK ("COUNTS" IS NOT NULL);
ALTER TABLE "TRADE_GNNT"."IPO_COMMODITY" ADD CHECK ("STARTTIME" IS NOT NULL);
ALTER TABLE "TRADE_GNNT"."IPO_COMMODITY" ADD CHECK ("ENDTIME" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table IPO_COMMODITY
-- ----------------------------
ALTER TABLE "TRADE_GNNT"."IPO_COMMODITY" ADD PRIMARY KEY ("ID");











-- ----------------------------
-- Table structure for IPO_DISTRIBUTION
-- ----------------------------
DROP TABLE "TRADE_GNNT"."IPO_DISTRIBUTION";
CREATE TABLE "TRADE_GNNT"."IPO_DISTRIBUTION" (
"ID" NUMBER(8) NOT NULL ,
"USERID" VARCHAR2(32 BYTE) NOT NULL ,
"COMMODITYNAME" VARCHAR2(32 BYTE) NOT NULL ,
"STARTNUMBER" NUMBER NOT NULL ,
"PCOUNTS" NUMBER(8) NOT NULL ,
"PTIME" TIMESTAMP(6)  NOT NULL ,
"ZCOUNTS" NUMBER(8) NULL ,
"NUMBERS" BLOB NULL ,
"COMMODITYID" VARCHAR2(32 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "TRADE_GNNT"."IPO_DISTRIBUTION" IS '��ţ���ǩ���';
COMMENT ON COLUMN "TRADE_GNNT"."IPO_DISTRIBUTION"."USERID" IS '�ͻ����';
COMMENT ON COLUMN "TRADE_GNNT"."IPO_DISTRIBUTION"."COMMODITYNAME" IS '��Ʒ����';
COMMENT ON COLUMN "TRADE_GNNT"."IPO_DISTRIBUTION"."STARTNUMBER" IS '��ʼ���';
COMMENT ON COLUMN "TRADE_GNNT"."IPO_DISTRIBUTION"."PCOUNTS" IS '�������';
COMMENT ON COLUMN "TRADE_GNNT"."IPO_DISTRIBUTION"."PTIME" IS '���ʱ��';
COMMENT ON COLUMN "TRADE_GNNT"."IPO_DISTRIBUTION"."ZCOUNTS" IS '��ǩ����';
COMMENT ON COLUMN "TRADE_GNNT"."IPO_DISTRIBUTION"."NUMBERS" IS '��ǩ����';
COMMENT ON COLUMN "TRADE_GNNT"."IPO_DISTRIBUTION"."COMMODITYID" IS '��Ʒ���';

-- ----------------------------
-- Indexes structure for table IPO_DISTRIBUTION
-- ----------------------------

-- ----------------------------
-- Checks structure for table IPO_DISTRIBUTION
-- ----------------------------
ALTER TABLE "TRADE_GNNT"."IPO_DISTRIBUTION" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TRADE_GNNT"."IPO_DISTRIBUTION" ADD CHECK ("USERID" IS NOT NULL);
ALTER TABLE "TRADE_GNNT"."IPO_DISTRIBUTION" ADD CHECK ("COMMODITYNAME" IS NOT NULL);
ALTER TABLE "TRADE_GNNT"."IPO_DISTRIBUTION" ADD CHECK ("STARTNUMBER" IS NOT NULL);
ALTER TABLE "TRADE_GNNT"."IPO_DISTRIBUTION" ADD CHECK ("PCOUNTS" IS NOT NULL);
ALTER TABLE "TRADE_GNNT"."IPO_DISTRIBUTION" ADD CHECK ("PTIME" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table IPO_DISTRIBUTION
-- ----------------------------
ALTER TABLE "TRADE_GNNT"."IPO_DISTRIBUTION" ADD PRIMARY KEY ("ID");











-- ----------------------------
-- Table structure for IPO_NUMBEROFRECORDS
-- ----------------------------
DROP TABLE "TRADE_GNNT"."IPO_NUMBEROFRECORDS";
CREATE TABLE "TRADE_GNNT"."IPO_NUMBEROFRECORDS" (
"ID" NUMBER(8) NOT NULL ,
"COMMODITYID" VARCHAR2(32 BYTE) NULL ,
"COUNTS" NUMBER NULL ,
"NOWTIME" TIMESTAMP(6)  NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "TRADE_GNNT"."IPO_NUMBEROFRECORDS"."COMMODITYID" IS '��Ʒ���';
COMMENT ON COLUMN "TRADE_GNNT"."IPO_NUMBEROFRECORDS"."COUNTS" IS '�������';
COMMENT ON COLUMN "TRADE_GNNT"."IPO_NUMBEROFRECORDS"."NOWTIME" IS 'ʱ��';

-- ----------------------------
-- Indexes structure for table IPO_NUMBEROFRECORDS
-- ----------------------------

-- ----------------------------
-- Checks structure for table IPO_NUMBEROFRECORDS
-- ----------------------------
ALTER TABLE "TRADE_GNNT"."IPO_NUMBEROFRECORDS" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table IPO_NUMBEROFRECORDS
-- ----------------------------
ALTER TABLE "TRADE_GNNT"."IPO_NUMBEROFRECORDS" ADD PRIMARY KEY ("ID");









-- ----------------------------
-- Table structure for IPO_NUMBEROFRECORDS_H
-- ----------------------------
DROP TABLE "TRADE_GNNT"."IPO_NUMBEROFRECORDS_H";
CREATE TABLE "TRADE_GNNT"."IPO_NUMBEROFRECORDS_H" (
"ID" NUMBER(8) NOT NULL ,
"COMMODITYID" VARCHAR2(32 BYTE) NULL ,
"COUNST" NUMBER NULL ,
"NOWTIME" TIMESTAMP(6)  NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "TRADE_GNNT"."IPO_NUMBEROFRECORDS_H"."ID" IS 'ID';
COMMENT ON COLUMN "TRADE_GNNT"."IPO_NUMBEROFRECORDS_H"."COMMODITYID" IS '��Ʒ����';
COMMENT ON COLUMN "TRADE_GNNT"."IPO_NUMBEROFRECORDS_H"."NOWTIME" IS 'ʱ��';

-- ----------------------------
-- Indexes structure for table IPO_NUMBEROFRECORDS_H
-- ----------------------------

-- ----------------------------
-- Checks structure for table IPO_NUMBEROFRECORDS_H
-- ----------------------------
ALTER TABLE "TRADE_GNNT"."IPO_NUMBEROFRECORDS_H" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table IPO_NUMBEROFRECORDS_H
-- ----------------------------
ALTER TABLE "TRADE_GNNT"."IPO_NUMBEROFRECORDS_H" ADD PRIMARY KEY ("ID");







-- ----------------------------
-- Table structure for IPO_ORDER
-- ----------------------------
DROP TABLE "TRADE_GNNT"."IPO_ORDER";
CREATE TABLE "TRADE_GNNT"."IPO_ORDER" (
"ORDERID" NUMBER NOT NULL ,
"USERID" VARCHAR2(32 BYTE) NOT NULL ,
"USERNAME" VARCHAR2(12 BYTE) NULL ,
"COMMODITYID" VARCHAR2(12 BYTE) NOT NULL ,
"COMMODITYNAME" VARCHAR2(12 BYTE) NOT NULL ,
"COUNTS" NUMBER NOT NULL ,
"CREATETIME" TIMESTAMP(6)  NOT NULL ,
"FROZENFUNDS" NUMBER(15,2) NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "TRADE_GNNT"."IPO_ORDER" IS '������';
COMMENT ON COLUMN "TRADE_GNNT"."IPO_ORDER"."USERID" IS '�ͻ����';
COMMENT ON COLUMN "TRADE_GNNT"."IPO_ORDER"."USERNAME" IS '�ͻ�����';
COMMENT ON COLUMN "TRADE_GNNT"."IPO_ORDER"."COMMODITYID" IS '��Ʒ���';
COMMENT ON COLUMN "TRADE_GNNT"."IPO_ORDER"."COMMODITYNAME" IS '��Ʒ����';
COMMENT ON COLUMN "TRADE_GNNT"."IPO_ORDER"."COUNTS" IS '�ͻ��깺��';
COMMENT ON COLUMN "TRADE_GNNT"."IPO_ORDER"."CREATETIME" IS '�깺ʱ��';
COMMENT ON COLUMN "TRADE_GNNT"."IPO_ORDER"."FROZENFUNDS" IS '�ʽ𶳽�';

-- ----------------------------
-- Indexes structure for table IPO_ORDER
-- ----------------------------

-- ----------------------------
-- Checks structure for table IPO_ORDER
-- ----------------------------
ALTER TABLE "TRADE_GNNT"."IPO_ORDER" ADD CHECK ("ORDERID" IS NOT NULL);
ALTER TABLE "TRADE_GNNT"."IPO_ORDER" ADD CHECK ("USERID" IS NOT NULL);
ALTER TABLE "TRADE_GNNT"."IPO_ORDER" ADD CHECK ("COMMODITYID" IS NOT NULL);
ALTER TABLE "TRADE_GNNT"."IPO_ORDER" ADD CHECK ("COMMODITYNAME" IS NOT NULL);
ALTER TABLE "TRADE_GNNT"."IPO_ORDER" ADD CHECK ("COUNTS" IS NOT NULL);
ALTER TABLE "TRADE_GNNT"."IPO_ORDER" ADD CHECK ("CREATETIME" IS NOT NULL);
ALTER TABLE "TRADE_GNNT"."IPO_ORDER" ADD CHECK ("FROZENFUNDS" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table IPO_ORDER
-- ----------------------------
ALTER TABLE "TRADE_GNNT"."IPO_ORDER" ADD PRIMARY KEY ("ORDERID");








-- ----------------------------
-- Table structure for IPO_ORDER_H
-- ----------------------------
DROP TABLE "TRADE_GNNT"."IPO_ORDER_H";
CREATE TABLE "TRADE_GNNT"."IPO_ORDER_H" (
"ORDERID" NUMBER NOT NULL ,
"USERID" VARCHAR2(32 BYTE) NOT NULL ,
"USERNAME" VARCHAR2(12 BYTE) NULL ,
"COMMODITYID" VARCHAR2(12 BYTE) NOT NULL ,
"COMMODITYNAME" VARCHAR2(12 BYTE) NOT NULL ,
"COUNTS" NUMBER NOT NULL ,
"CREATETIME" TIMESTAMP(6)  NOT NULL ,
"FROZENFUNDS" NUMBER(15,2) NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "TRADE_GNNT"."IPO_ORDER_H"."USERID" IS '�ͻ����';
COMMENT ON COLUMN "TRADE_GNNT"."IPO_ORDER_H"."USERNAME" IS '�ͻ�����';
COMMENT ON COLUMN "TRADE_GNNT"."IPO_ORDER_H"."COMMODITYID" IS '��Ʒ���';
COMMENT ON COLUMN "TRADE_GNNT"."IPO_ORDER_H"."COMMODITYNAME" IS '��Ʒ����';
COMMENT ON COLUMN "TRADE_GNNT"."IPO_ORDER_H"."COUNTS" IS '�ͻ��깺��';
COMMENT ON COLUMN "TRADE_GNNT"."IPO_ORDER_H"."CREATETIME" IS '�깺ʱ��';
COMMENT ON COLUMN "TRADE_GNNT"."IPO_ORDER_H"."FROZENFUNDS" IS '�ʽ𶳽�';

-- ----------------------------
-- Indexes structure for table IPO_ORDER_H
-- ----------------------------

-- ----------------------------
-- Checks structure for table IPO_ORDER_H
-- ----------------------------
ALTER TABLE "TRADE_GNNT"."IPO_ORDER_H" ADD CHECK ("ORDERID" IS NOT NULL);
ALTER TABLE "TRADE_GNNT"."IPO_ORDER_H" ADD CHECK ("USERID" IS NOT NULL);
ALTER TABLE "TRADE_GNNT"."IPO_ORDER_H" ADD CHECK ("COMMODITYID" IS NOT NULL);
ALTER TABLE "TRADE_GNNT"."IPO_ORDER_H" ADD CHECK ("COMMODITYNAME" IS NOT NULL);
ALTER TABLE "TRADE_GNNT"."IPO_ORDER_H" ADD CHECK ("COUNTS" IS NOT NULL);
ALTER TABLE "TRADE_GNNT"."IPO_ORDER_H" ADD CHECK ("CREATETIME" IS NOT NULL);
ALTER TABLE "TRADE_GNNT"."IPO_ORDER_H" ADD CHECK ("FROZENFUNDS" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table IPO_ORDER_H
-- ----------------------------
ALTER TABLE "TRADE_GNNT"."IPO_ORDER_H" ADD PRIMARY KEY ("ORDERID");









-- ----------------------------
-- Table structure for L_MODULEANDAU
-- ----------------------------
DROP TABLE "TRADE_GNNT"."L_MODULEANDAU";
CREATE TABLE "TRADE_GNNT"."L_MODULEANDAU" (
"MODULEID" NUMBER(2) NOT NULL ,
"CONFIGID" NUMBER(6) NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of L_MODULEANDAU
-- ----------------------------
INSERT INTO "TRADE_GNNT"."L_MODULEANDAU" VALUES ('10', '199001');
INSERT INTO "TRADE_GNNT"."L_MODULEANDAU" VALUES ('10', '210001');
INSERT INTO "TRADE_GNNT"."L_MODULEANDAU" VALUES ('10', '399001');
INSERT INTO "TRADE_GNNT"."L_MODULEANDAU" VALUES ('11', '199001');
INSERT INTO "TRADE_GNNT"."L_MODULEANDAU" VALUES ('11', '211001');
INSERT INTO "TRADE_GNNT"."L_MODULEANDAU" VALUES ('12', '499001');
INSERT INTO "TRADE_GNNT"."L_MODULEANDAU" VALUES ('13', '199001');
INSERT INTO "TRADE_GNNT"."L_MODULEANDAU" VALUES ('13', '213001');
INSERT INTO "TRADE_GNNT"."L_MODULEANDAU" VALUES ('14', '199001');
INSERT INTO "TRADE_GNNT"."L_MODULEANDAU" VALUES ('14', '214001');
INSERT INTO "TRADE_GNNT"."L_MODULEANDAU" VALUES ('15', '199001');
INSERT INTO "TRADE_GNNT"."L_MODULEANDAU" VALUES ('15', '215001');
INSERT INTO "TRADE_GNNT"."L_MODULEANDAU" VALUES ('15', '399001');
INSERT INTO "TRADE_GNNT"."L_MODULEANDAU" VALUES ('18', '199001');
INSERT INTO "TRADE_GNNT"."L_MODULEANDAU" VALUES ('18', '218001');
INSERT INTO "TRADE_GNNT"."L_MODULEANDAU" VALUES ('18', '399001');
INSERT INTO "TRADE_GNNT"."L_MODULEANDAU" VALUES ('18', '499001');
INSERT INTO "TRADE_GNNT"."L_MODULEANDAU" VALUES ('19', '199001');
INSERT INTO "TRADE_GNNT"."L_MODULEANDAU" VALUES ('21', '199001');
INSERT INTO "TRADE_GNNT"."L_MODULEANDAU" VALUES ('21', '221001');
INSERT INTO "TRADE_GNNT"."L_MODULEANDAU" VALUES ('28', '199001');
INSERT INTO "TRADE_GNNT"."L_MODULEANDAU" VALUES ('28', '228001');
INSERT INTO "TRADE_GNNT"."L_MODULEANDAU" VALUES ('29', '199001');
INSERT INTO "TRADE_GNNT"."L_MODULEANDAU" VALUES ('30', '199001');
INSERT INTO "TRADE_GNNT"."L_MODULEANDAU" VALUES ('30', '230001');
INSERT INTO "TRADE_GNNT"."L_MODULEANDAU" VALUES ('40', '199001');
INSERT INTO "TRADE_GNNT"."L_MODULEANDAU" VALUES ('40', '223001');
INSERT INTO "TRADE_GNNT"."L_MODULEANDAU" VALUES ('98', '199001');
INSERT INTO "TRADE_GNNT"."L_MODULEANDAU" VALUES ('98', '298001');
INSERT INTO "TRADE_GNNT"."L_MODULEANDAU" VALUES ('99', '199001');
INSERT INTO "TRADE_GNNT"."L_MODULEANDAU" VALUES ('99', '299001');
INSERT INTO "TRADE_GNNT"."L_MODULEANDAU" VALUES ('99', '399001');
INSERT INTO "TRADE_GNNT"."L_MODULEANDAU" VALUES ('99', '499001');

-- ----------------------------
-- Indexes structure for table L_MODULEANDAU
-- ----------------------------

-- ----------------------------
-- Checks structure for table L_MODULEANDAU
-- ----------------------------
ALTER TABLE "TRADE_GNNT"."L_MODULEANDAU" ADD CHECK ("MODULEID" IS NOT NULL);
ALTER TABLE "TRADE_GNNT"."L_MODULEANDAU" ADD CHECK ("CONFIGID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table L_MODULEANDAU
-- ----------------------------
ALTER TABLE "TRADE_GNNT"."L_MODULEANDAU" ADD PRIMARY KEY ("MODULEID", "CONFIGID");







/*
Navicat Oracle Data Transfer
Oracle Client Version : 12.1.0.2.0

Source Server         : 10.0.100.183_1521_gnnt
Source Server Version : 110200
Source Host           : 10.0.100.183:1521
Source Schema         : TRADE_GNNT

Target Server Type    : ORACLE
Target Server Version : 110200
File Encoding         : 65001

Date: 2015-11-03 09:28:55
*/


-- ----------------------------
-- Table structure for C_TRADEMODULE
-- ----------------------------
DROP TABLE "TRADE_GNNT"."C_TRADEMODULE";
CREATE TABLE "TRADE_GNNT"."C_TRADEMODULE" (
"MODULEID" NUMBER(2) NOT NULL ,
"CNNAME" VARCHAR2(64 BYTE) NOT NULL ,
"ENNAME" VARCHAR2(64 BYTE) NULL ,
"SHORTNAME" VARCHAR2(16 BYTE) NULL ,
"ADDFIRMFN" VARCHAR2(36 BYTE) NULL ,
"UPDATEFIRMSTATUSFN" VARCHAR2(36 BYTE) NULL ,
"DELFIRMFN" VARCHAR2(36 BYTE) NULL ,
"ISFIRMSET" CHAR(1 BYTE) DEFAULT 'N'  NOT NULL ,
"HOSTIP" VARCHAR2(16 BYTE) NULL ,
"PORT" NUMBER(6) NULL ,
"RMIDATAPORT" NUMBER(6) NULL ,
"ISBALANCECHECK" CHAR(1 BYTE) DEFAULT 'N'  NOT NULL ,
"ISNEEDBREED" CHAR(1 BYTE) NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "TRADE_GNNT"."C_TRADEMODULE"."MODULEID" IS '10�ۺϹ���ƽ̨
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
COMMENT ON COLUMN "TRADE_GNNT"."C_TRADEMODULE"."ISFIRMSET" IS '��Y�� �� ��N�� �� (�����Ҫ�ڹ���ǰ̨�ҵ�ƽ̨����ʾ��ϵͳ������Ҫ�ڹ���ϵͳ�� spring_sys_msg.xml �������ϱ�ϵͳ��������Ϣ)';
COMMENT ON COLUMN "TRADE_GNNT"."C_TRADEMODULE"."ISBALANCECHECK" IS 'Y���� N����';
COMMENT ON COLUMN "TRADE_GNNT"."C_TRADEMODULE"."ISNEEDBREED" IS '��ϵͳ�Ƿ���Ҫ�ۺϹ���ƽ̨���ӵ���Ʒ   Y:��   N:��';

-- ----------------------------
-- Records of C_TRADEMODULE
-- ----------------------------
INSERT INTO "TRADE_GNNT"."C_TRADEMODULE" VALUES ('10', '�ۺϹ���ƽ̨', 'integrated', '�ۺϹ���ƽ̨', null, null, null, 'Y', null, null, null, 'N', 'N');
INSERT INTO "TRADE_GNNT"."C_TRADEMODULE" VALUES ('11', '����ϵͳ', 'finance', '����ϵͳ', 'FN_F_firmADD', 'FN_F_FirmToStatus', 'FN_F_FirmDel', 'Y', null, null, null, 'N', 'N');
INSERT INTO "TRADE_GNNT"."C_TRADEMODULE" VALUES ('13', '�ֵ�����ϵͳ', 'bill', '�ֵ�����ϵͳ', 'FN_BI_firmADD', null, 'FN_BI_FirmDel', 'Y', '10.0.100.181', '20371', '20372', 'Y', 'N');
INSERT INTO "TRADE_GNNT"."C_TRADEMODULE" VALUES ('28', '���нӿ�', 'bank', '���нӿ�', 'FN_F_B_firmADD', null, 'FN_F_B_FirmDEL', 'Y', null, '20571', '20572', 'N', 'N');
INSERT INTO "TRADE_GNNT"."C_TRADEMODULE" VALUES ('32', '�����¼ϵͳ', 'activeuser', '�����¼ϵͳ', null, null, null, 'N', null, null, null, 'N', 'N');
INSERT INTO "TRADE_GNNT"."C_TRADEMODULE" VALUES ('12', '�ֿ����ϵͳ', 'warehouse', '�ֿ����ϵͳ', null, null, null, 'N', null, null, null, 'N', 'N');
INSERT INTO "TRADE_GNNT"."C_TRADEMODULE" VALUES ('19', '���˻�Ա����ϵͳ', 'broker', '���˻�Ա����ϵͳ', 'FN_BR_firmADD', null, null, 'N', null, null, null, 'N', 'N');
INSERT INTO "TRADE_GNNT"."C_TRADEMODULE" VALUES ('15', '��������ϵͳ', 'timebargain', '��������ϵͳ', 'FN_T_firmADD', null, 'FN_T_FirmDel', 'Y', '10.0.100.181', '20671', '20672', 'Y', 'Y');
INSERT INTO "TRADE_GNNT"."C_TRADEMODULE" VALUES ('99', '����ϵͳ', 'common', '����ϵͳ', null, null, null, 'N', '10.0.100.181', '20171', '20172', 'Y', 'N');
INSERT INTO "TRADE_GNNT"."C_TRADEMODULE" VALUES ('21', '����ϵͳ', 'vendue', '���۹���ϵͳ', 'FN_V_FirmAdd', null, 'FN_V_FirmDel', 'Y', '10.0.100.181', '20871', '20872', 'Y', 'Y');
INSERT INTO "TRADE_GNNT"."C_TRADEMODULE" VALUES ('40', 'IPO', 'ipo', 'IPO', null, null, null, 'Y', null, null, null, 'N', 'N');

-- ----------------------------
-- Indexes structure for table C_TRADEMODULE
-- ----------------------------

-- ----------------------------
-- Checks structure for table C_TRADEMODULE
-- ----------------------------
ALTER TABLE "TRADE_GNNT"."C_TRADEMODULE" ADD CHECK ("MODULEID" IS NOT NULL);
ALTER TABLE "TRADE_GNNT"."C_TRADEMODULE" ADD CHECK ("CNNAME" IS NOT NULL);
ALTER TABLE "TRADE_GNNT"."C_TRADEMODULE" ADD CHECK ("ISFIRMSET" IS NOT NULL);
ALTER TABLE "TRADE_GNNT"."C_TRADEMODULE" ADD CHECK ("ISBALANCECHECK" IS NOT NULL);
ALTER TABLE "TRADE_GNNT"."C_TRADEMODULE" ADD CHECK ("ISNEEDBREED" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table C_TRADEMODULE
-- ----------------------------
ALTER TABLE "TRADE_GNNT"."C_TRADEMODULE" ADD PRIMARY KEY ("MODULEID");








/*
Navicat Oracle Data Transfer
Oracle Client Version : 12.1.0.2.0

Source Server         : 10.0.100.183_1521_gnnt
Source Server Version : 110200
Source Host           : 10.0.100.183:1521
Source Schema         : TRADE_GNNT

Target Server Type    : ORACLE
Target Server Version : 110200
File Encoding         : 65001

Date: 2015-11-03 09:41:46
*/


-- ----------------------------
-- Table structure for C_DEPLOY_CONFIG
-- ----------------------------
DROP TABLE "TRADE_GNNT"."C_DEPLOY_CONFIG";
CREATE TABLE "TRADE_GNNT"."C_DEPLOY_CONFIG" (
"MODULEID" NUMBER(2) NOT NULL ,
"CONTEXTNAME" VARCHAR2(64 BYTE) NOT NULL ,
"SERVERPIC" VARCHAR2(64 BYTE) NOT NULL ,
"SERVERPATH" VARCHAR2(128 BYTE) NULL ,
"RELATIVEPATH" VARCHAR2(128 BYTE) NOT NULL ,
"HOMEPAGEACTION" VARCHAR2(128 BYTE) NULL ,
"WELCOMEPAGE" VARCHAR2(128 BYTE) NULL ,
"WELCOMEPIC" VARCHAR2(64 BYTE) NULL ,
"SYSTYPE" VARCHAR2(32 BYTE) NOT NULL ,
"SORTNO" NUMBER(2) DEFAULT 1  NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "TRADE_GNNT"."C_DEPLOY_CONFIG"."MODULEID" IS '��ɫId';
COMMENT ON COLUMN "TRADE_GNNT"."C_DEPLOY_CONFIG"."CONTEXTNAME" IS 'ϵͳ����';
COMMENT ON COLUMN "TRADE_GNNT"."C_DEPLOY_CONFIG"."SERVERPIC" IS '��ҳ����������ϵͳ����ƽ̨�ĵ��ͼƬ';
COMMENT ON COLUMN "TRADE_GNNT"."C_DEPLOY_CONFIG"."SERVERPATH" IS '�����ַ��eg  http://127.0.0.1:8080';
COMMENT ON COLUMN "TRADE_GNNT"."C_DEPLOY_CONFIG"."RELATIVEPATH" IS '����ϵͳ����������ϵͳ����ƽ̨�ĵ����ַ';
COMMENT ON COLUMN "TRADE_GNNT"."C_DEPLOY_CONFIG"."HOMEPAGEACTION" IS '����ϵͳƽ̨��ҳ��Action';
COMMENT ON COLUMN "TRADE_GNNT"."C_DEPLOY_CONFIG"."WELCOMEPAGE" IS '��ת������ϵͳ��ҳ����Ե�ַ(ֻ��ǰ̨������ҳ)';
COMMENT ON COLUMN "TRADE_GNNT"."C_DEPLOY_CONFIG"."WELCOMEPIC" IS '����ϵͳͷ������������ϵͳ��ҳ��ͼ��չʾ(ֻ��ǰ̨������ҳͼ��)';
COMMENT ON COLUMN "TRADE_GNNT"."C_DEPLOY_CONFIG"."SYSTYPE" IS 'ϵͳ���ͣ�mgr����̨  front��ǰ̨';

-- ----------------------------
-- Records of C_DEPLOY_CONFIG
-- ----------------------------
INSERT INTO "TRADE_GNNT"."C_DEPLOY_CONFIG" VALUES ('40', 'ipo_mgr', 'finance_mgr.png', null, '/mgr/frame/mainframe_nohead.jsp', null, null, null, 'mgr', '40');
INSERT INTO "TRADE_GNNT"."C_DEPLOY_CONFIG" VALUES ('10', 'integrated_front', 'ico_syn.png', null, '/front/frame/mainframe.jsp', null, null, null, 'front', '10');
INSERT INTO "TRADE_GNNT"."C_DEPLOY_CONFIG" VALUES ('10', 'integrated_mgr', 'integrated_mgr.png', null, '/mgr/frame/mainframe_nohead.jsp', null, null, null, 'mgr', '10');
INSERT INTO "TRADE_GNNT"."C_DEPLOY_CONFIG" VALUES ('11', 'finance_front', 'ico_finance.png', null, '/front/frame/mainframe.jsp', null, null, null, 'front', '11');
INSERT INTO "TRADE_GNNT"."C_DEPLOY_CONFIG" VALUES ('11', 'finance_mgr', 'finance_mgr.png', null, '/mgr/frame/mainframe_nohead.jsp', null, null, null, 'mgr', '11');
INSERT INTO "TRADE_GNNT"."C_DEPLOY_CONFIG" VALUES ('13', 'bill_front', 'ico_cdsys.png', null, '/front/frame/mainframe.jsp', null, null, null, 'front', '13');
INSERT INTO "TRADE_GNNT"."C_DEPLOY_CONFIG" VALUES ('13', 'bill_mgr', 'bill_mgr.png', null, '/mgr/frame/mainframe_nohead.jsp', null, null, null, 'mgr', '13');
INSERT INTO "TRADE_GNNT"."C_DEPLOY_CONFIG" VALUES ('28', 'bank_mgr', 'bank_mgr.png', null, '/mgr/frame/mainframe_nohead.jsp', null, null, null, 'mgr', '28');
INSERT INTO "TRADE_GNNT"."C_DEPLOY_CONFIG" VALUES ('28', 'bank_front', 'ico_bank.png', null, '/front/frame/mainframe.jsp', null, null, null, 'front', '28');
INSERT INTO "TRADE_GNNT"."C_DEPLOY_CONFIG" VALUES ('29', 'tradeMonitor', 'monitor.gif', null, '/mgr/frame/mainframe_nohead.jsp', null, null, null, 'mgr', '29');
INSERT INTO "TRADE_GNNT"."C_DEPLOY_CONFIG" VALUES ('99', 'common_warehouse', 'common_mgr.gif', null, '/mgr/frame/mainframe_nohead.jsp', null, null, null, 'warehouse', '99');
INSERT INTO "TRADE_GNNT"."C_DEPLOY_CONFIG" VALUES ('12', 'integrated_warehouse', 'integrated_mgr.png', null, '/mgr/frame/mainframe_nohead.jsp', null, null, null, 'warehouse', '12');
INSERT INTO "TRADE_GNNT"."C_DEPLOY_CONFIG" VALUES ('19', 'broker_mgr', 'broker_mgr.png', null, '/mgr/frame/mainframe_nohead.jsp', null, null, null, 'mgr', '19');
INSERT INTO "TRADE_GNNT"."C_DEPLOY_CONFIG" VALUES ('10', 'integrated_broker', 'integrated_broker.png', null, '/broker/frame/mainframe_nohead.jsp', null, null, null, 'broker', '10');
INSERT INTO "TRADE_GNNT"."C_DEPLOY_CONFIG" VALUES ('15', 'timebargain_broker', 'timebargain_broker.png', null, '/broker/frame/mainframe_nohead.jsp', null, null, null, 'broker', '15');
INSERT INTO "TRADE_GNNT"."C_DEPLOY_CONFIG" VALUES ('99', 'common_broker', 'common_broker.png', null, '/broker/frame/mainframe_nohead.jsp', null, null, null, 'broker', '99');
INSERT INTO "TRADE_GNNT"."C_DEPLOY_CONFIG" VALUES ('15', 'timebargain_front', 'ico_timebargain.png', null, '/front/frame/mainframe.jsp', null, null, null, 'front', '15');
INSERT INTO "TRADE_GNNT"."C_DEPLOY_CONFIG" VALUES ('15', 'timebargain_mgr', 'timebargain_mgr.png', null, '/mgr/frame/mainframe_nohead.jsp', null, null, null, 'mgr', '15');
INSERT INTO "TRADE_GNNT"."C_DEPLOY_CONFIG" VALUES ('99', 'common_mgr', 'common_mgr.gif', null, '/mgr/frame/mainframe_nohead.jsp', null, null, null, 'mgr', '99');
INSERT INTO "TRADE_GNNT"."C_DEPLOY_CONFIG" VALUES ('99', 'common_front', 'common.gif', null, '/front/frame/mainframe.jsp', null, null, null, 'front', '99');
INSERT INTO "TRADE_GNNT"."C_DEPLOY_CONFIG" VALUES ('21', 'vendue_mgr', 'vendue_mgr.png', null, '/mgr/frame/mainframe_nohead.jsp', null, null, null, 'mgr', '21');
INSERT INTO "TRADE_GNNT"."C_DEPLOY_CONFIG" VALUES ('21', 'vendue_front', 'vendue_front.png', null, '/front/app/vendue/vendue1_nkst/submit/main.jsp', null, null, null, 'front', '21');
INSERT INTO "TRADE_GNNT"."C_DEPLOY_CONFIG" VALUES ('40', 'ipo_front', 'ico_finance.png', null, '/front/frame/mainframe.jsp', null, null, null, 'front', '40');

-- ----------------------------
-- Indexes structure for table C_DEPLOY_CONFIG
-- ----------------------------

-- ----------------------------
-- Checks structure for table C_DEPLOY_CONFIG
-- ----------------------------
ALTER TABLE "TRADE_GNNT"."C_DEPLOY_CONFIG" ADD CHECK ("MODULEID" IS NOT NULL);
ALTER TABLE "TRADE_GNNT"."C_DEPLOY_CONFIG" ADD CHECK ("CONTEXTNAME" IS NOT NULL);
ALTER TABLE "TRADE_GNNT"."C_DEPLOY_CONFIG" ADD CHECK ("SERVERPIC" IS NOT NULL);
ALTER TABLE "TRADE_GNNT"."C_DEPLOY_CONFIG" ADD CHECK ("RELATIVEPATH" IS NOT NULL);
ALTER TABLE "TRADE_GNNT"."C_DEPLOY_CONFIG" ADD CHECK ("SYSTYPE" IS NOT NULL);
ALTER TABLE "TRADE_GNNT"."C_DEPLOY_CONFIG" ADD CHECK ("SORTNO" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table C_DEPLOY_CONFIG
-- ----------------------------
ALTER TABLE "TRADE_GNNT"."C_DEPLOY_CONFIG" ADD PRIMARY KEY ("MODULEID", "CONTEXTNAME");









