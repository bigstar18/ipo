/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     2015/12/22 15:16:32                          */
/*==============================================================*/


DROP TABLE IPO_SPO CASCADE CONSTRAINTS;

/*==============================================================*/
/* Table: IPO_SPO                                               */
/*==============================================================*/
CREATE TABLE IPO_SPO 
(
   SPO_ID               VARCHAR2(32)         NOT NULL,
   COMMUNITY_ID         VARCHAR2(32)         NOT NULL,
   SPO_COUNTS           NUMBER(12)           NOT NULL,
   SPO_PRICE            NUMBER(12,2)         NOT NULL,
   RATION_COUNTS        NUMBER(12)           NOT NULL,
   RATION_REPAYMENT     NUMBER(12,2),
   RATION_POUNDAGE      NUMBER(12,2),
   REGISTER_DATE        DATE                 NOT NULL,
   SPO_DATE             DATE                 NOT NULL,
   IPO_DATE             DATE                 NOT NULL,
   RATION_SATE          NUMBER(8)            NOT NULL,
   RATION_TYPE          VARCHAR2(32)         NOT NULL,
   FIRM_ID              VARCHAR2(32),
   CONSTRAINT PK_IPO_SPO PRIMARY KEY (SPO_ID)
);

