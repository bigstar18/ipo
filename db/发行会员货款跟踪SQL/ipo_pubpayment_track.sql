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
  is '主键 SEQ_IPO_PUBPAYMENT_TRACK 序列生成';
comment on column IPO_PUBPAYMENT_TRACK.COMMODITYID
  is '商品代码';
comment on column IPO_PUBPAYMENT_TRACK.PAYABLES
  is '应付货款';
comment on column IPO_PUBPAYMENT_TRACK.STATUS
  is '状态  1 未付款 2 已付款';
comment on column IPO_PUBPAYMENT_TRACK.CREATEPERSON
  is '创建人';
comment on column IPO_PUBPAYMENT_TRACK.CREATEDATE
  is '创建日期';
comment on column IPO_PUBPAYMENT_TRACK.UPDATEPERSON
  is '更新人';
comment on column IPO_PUBPAYMENT_TRACK.UPDATEDATE
  is '更新日期';
comment on column IPO_PUBPAYMENT_TRACK.DELETEFLAG
  is '删除标记 0 有效 1 删除';


-- Create sequence 
create sequence SEQ_IPO_PUBPAYMENT_TRACK
minvalue 1
maxvalue 999999999999999999999999
start with 41
increment by 1
cache 20;
