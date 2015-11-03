/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     2015/10/31 20:43:48                          */
/*==============================================================*/


drop table IPO_COMMODITY cascade constraints;

drop table IPO_DISTRIBUTION cascade constraints;

drop table IPO_NUMBEROFRECORDS cascade constraints;

drop table IPO_ORDER cascade constraints;

/*==============================================================*/
/* Table: IPO_COMMODITY                                         */
/*==============================================================*/
create table IPO_COMMODITY 
(
   ID                   VARCHAR(32)          not null,
   COMMODITYID          VARCHAR(32)          not null,
   COMMODITYNAME        VARCHAR(32)          not null,
   PRICE                NUMBER(11,3)         not null,
   UNITS                NUMBER               not null,
   COUNTS               NUMBER               not null,
   STARTTIME            DATE                 not null,
   ENDTIME              DATE                 not null,
   constraint PK_IPO_COMMODITY primary key (ID)
);

comment on table IPO_COMMODITY is
'��Ʒ�б�';

comment on column IPO_COMMODITY.COMMODITYID is
'��Ʒ���';

comment on column IPO_COMMODITY.COMMODITYNAME is
'��Ʒ����';

comment on column IPO_COMMODITY.PRICE is
'���ۼ�';

comment on column IPO_COMMODITY.UNITS is
'���۵�λ';

comment on column IPO_COMMODITY.COUNTS is
'��������';

comment on column IPO_COMMODITY.STARTTIME is
'��ʼʱ��';

comment on column IPO_COMMODITY.ENDTIME is
'����ʱ��';

/*==============================================================*/
/* Table: IPO_DISTRIBUTION                                      */
/*==============================================================*/
create table IPO_DISTRIBUTION 
(
   ID                   VARCHAR(32)          not null,
   USERID               VARCHAR(32)          not null,
   COMMODITYNAME        VARCHAR(12)          not null,
   STARTNUMBER          NUMBER               not null,
   PCOUNTS              INT                  not null,
   PTIME                TIMESTAMP            not null,
   ZCOUNTS              NUMBER,
   NUMBERS              BLOB,
   constraint PK_IPO_DISTRIBUTION primary key (ID)
);

comment on table IPO_DISTRIBUTION is
'��ţ���ǩ���';

comment on column IPO_DISTRIBUTION.USERID is
'�ͻ����';

comment on column IPO_DISTRIBUTION.COMMODITYNAME is
'��Ʒ����';

comment on column IPO_DISTRIBUTION.STARTNUMBER is
'��ʼ���';

comment on column IPO_DISTRIBUTION.PCOUNTS is
'�������';

comment on column IPO_DISTRIBUTION.PTIME is
'���ʱ��';

comment on column IPO_DISTRIBUTION.ZCOUNTS is
'��ǩ����';

comment on column IPO_DISTRIBUTION.NUMBERS is
'��ǩ����';

/*==============================================================*/
/* Table: IPO_NUMBEROFRECORDS                                   */
/*==============================================================*/
create table IPO_NUMBEROFRECORDS 
(
   ID                   VARCHAR(32)          not null,
   COMMODITYID          VARCHAR(32),
   COUNTS               NUMBER,
   NOWTIME              TIMESTAMP            
);

comment on column IPO_NUMBEROFRECORDS.COMMODITYID is
'��Ʒ���';

comment on column IPO_NUMBEROFRECORDS.COUNTS is
'�������';

comment on column IPO_NUMBEROFRECORDS.NOWTIME is
'ʱ��';

/*==============================================================*/
/* Table: IPO_ORDER                                             */
/*==============================================================*/
create table IPO_ORDER 
(
   ORDERID              VARCHAR(32)          not null,
   USERID               VARCHAR(32)          not null,
   USERNAME             VARCHAR(12),
   COMMODITYID          VARCHAR(12)          not null,
   COMMODITYNAME        VARCHAR(12)          not null,
   COUNTS               NUMBER               not null,
   CREATETIME           TIMESTAMP            not null,
   FROZENFUNDS          NUMBER(15,2)         not null,
   constraint PK_IPO_ORDER primary key (ORDERID)
);

comment on table IPO_ORDER is
'������';

comment on column IPO_ORDER.USERID is
'�ͻ����';

comment on column IPO_ORDER.USERNAME is
'�ͻ�����';

comment on column IPO_ORDER.COMMODITYID is
'��Ʒ���';

comment on column IPO_ORDER.COMMODITYNAME is
'��Ʒ����';

comment on column IPO_ORDER.COUNTS is
'�ͻ��깺��';

comment on column IPO_ORDER.CREATETIME is
'�깺ʱ��';

comment on column IPO_ORDER.FROZENFUNDS is
'�ʽ𶳽�';

