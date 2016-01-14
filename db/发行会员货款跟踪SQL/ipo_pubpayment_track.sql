/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     2016/1/14 14:49:08                           */
/*==============================================================*/


DROP TABLE IPO_PUBPAYMENT_TRACK CASCADE CONSTRAINTS;

/*==============================================================*/
/* Table: IPO_PUBPAYMENT_TRACK                                  */
/*==============================================================*/
CREATE TABLE IPO_PUBPAYMENT_TRACK 
(
   TRACKID              NUMBER(10)           NOT NULL,
   COMMODITYID          VARCHAR2(32),
   PAYABLES             NUMBER(12,2),
   STATUS               NUMBER(1),
   CREATEPERSON         VARCHAR2(32),
   CREATEDATE           DATE,
   UPDATEPERSON         VARCHAR2(32),
   UPDATEDATE           DATE,
   DELETEFLAG           NUMBER(1),
   CONSTRAINT PK_IPO_PUBPAYMENT_TRACK PRIMARY KEY (TRACKID)
);

-- Add/modify columns 
alter table IPO_PUBPAYMENT_TRACK modify DELETEFLAG default 0;
-- Add comments to the columns 
comment on column IPO_PUBPAYMENT_TRACK.TRACKID
  is '���� SEQ_IPO_PUBPAYMENT_TRACK ��������';
comment on column IPO_PUBPAYMENT_TRACK.COMMODITYID
  is '��Ʒ����';
comment on column IPO_PUBPAYMENT_TRACK.PAYABLES
  is 'Ӧ������';
comment on column IPO_PUBPAYMENT_TRACK.STATUS
  is '״̬  1 δ���� 2 �Ѹ���';
comment on column IPO_PUBPAYMENT_TRACK.CREATEPERSON
  is '������';
comment on column IPO_PUBPAYMENT_TRACK.CREATEDATE
  is '��������';
comment on column IPO_PUBPAYMENT_TRACK.UPDATEPERSON
  is '������';
comment on column IPO_PUBPAYMENT_TRACK.UPDATEDATE
  is '��������';
comment on column IPO_PUBPAYMENT_TRACK.DELETEFLAG
  is 'ɾ����� 0 ��Ч 1 ɾ��';


-- Create sequence 
create sequence SEQ_IPO_PUBPAYMENT_TRACK
minvalue 1
maxvalue 999999999999999999999999
start with 41
increment by 1
cache 20;
