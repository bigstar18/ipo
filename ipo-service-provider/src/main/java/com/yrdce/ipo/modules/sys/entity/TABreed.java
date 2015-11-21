package com.yrdce.ipo.modules.sys.entity;

import java.math.BigDecimal;

/*
 * 品种表
 */
public class TABreed {
    private Long breedid;

    private String breedname;

    private Long sortid;

    private BigDecimal contractfactor;

    private BigDecimal minpricemove;

    private Short spreadalgr;

    private BigDecimal spreaduplmt;

    private BigDecimal spreaddownlmt;

    private Short feealgr;

    private BigDecimal feerateB;

    private BigDecimal feerateS;

    private Short marginalgr;

    private BigDecimal marginrateB;

    private BigDecimal marginrateS;

    private BigDecimal marginassureB;

    private BigDecimal marginassureS;

    private BigDecimal todayclosefeerateB;

    private BigDecimal todayclosefeerateS;

    private BigDecimal historyclosefeerateB;

    private BigDecimal historyclosefeerateS;

    private Long limitcmdtyqty;

    private Short settlefeealgr;

    private BigDecimal settlefeerateB;

    private BigDecimal settlefeerateS;

    private Short forceclosefeealgr;

    private BigDecimal forceclosefeerateB;

    private BigDecimal forceclosefeerateS;

    private Short settlemarginalgrB;

    private BigDecimal settlemarginrateB;

    private Short settlemarginalgrS;

    private BigDecimal settlemarginrateS;

    private BigDecimal addedtax;

    private Short marginpricetype;

    private BigDecimal lowestsettlefee;

    private Long limitbreedqty;

    private Long firmcleanqty;

    private Long firmmaxholdqty;

    private BigDecimal marginitem1;

    private BigDecimal marginitem2;

    private BigDecimal marginitem3;

    private BigDecimal marginitem4;

    private BigDecimal marginitem1S;

    private BigDecimal marginitem2S;

    private BigDecimal marginitem3S;

    private BigDecimal marginitem4S;

    private BigDecimal marginitemassure1;

    private BigDecimal marginitemassure2;

    private BigDecimal marginitemassure3;

    private BigDecimal marginitemassure4;

    private BigDecimal marginitemassure1S;

    private BigDecimal marginitemassure2S;

    private BigDecimal marginitemassure3S;

    private BigDecimal marginitemassure4S;

    private Integer orderprivilege;

    private Short payoutalgr;

    private BigDecimal payoutrate;

    private BigDecimal addedtaxfactor;

    private BigDecimal marginitem5;

    private BigDecimal marginitem5S;

    private BigDecimal marginitemassure5;

    private BigDecimal marginitemassure5S;

    private Short settlepricetype;

    private Short beforedays;

    private BigDecimal specsettleprice;

    private Short firmmaxholdqtyalgr;

    private Long startpercentqty;

    private BigDecimal maxpercentlimit;

    private Long onemaxholdqty;

    private Short minquantitymove;

    private String contractfactorname;

    private BigDecimal delayrecouprate;

    private Short settleway;

    private Short delayfeeway;

    private BigDecimal maxfeerate;

    private Integer minsettlemoveqty;

    private Short breedtrademode;

    private BigDecimal storerecouprate;

    private Long minsettleqty;

    private BigDecimal delayrecouprateS;

    private Short delaysettlepricetype;

    private Short aheadsettlepricetype;

    private Short settlemargintype;

    private Short beforedaysM;

    private Long sideholdlimitqty;

    private Short holddayslimit;

    private Long maxholdpositionday;

    public Long getBreedid() {
        return breedid;
    }

    public void setBreedid(Long breedid) {
        this.breedid = breedid;
    }

    public String getBreedname() {
        return breedname;
    }

    public void setBreedname(String breedname) {
        this.breedname = breedname == null ? null : breedname.trim();
    }

    public Long getSortid() {
        return sortid;
    }

    public void setSortid(Long sortid) {
        this.sortid = sortid;
    }

    public BigDecimal getContractfactor() {
        return contractfactor;
    }

    public void setContractfactor(BigDecimal contractfactor) {
        this.contractfactor = contractfactor;
    }

    public BigDecimal getMinpricemove() {
        return minpricemove;
    }

    public void setMinpricemove(BigDecimal minpricemove) {
        this.minpricemove = minpricemove;
    }

    public Short getSpreadalgr() {
        return spreadalgr;
    }

    public void setSpreadalgr(Short spreadalgr) {
        this.spreadalgr = spreadalgr;
    }

    public BigDecimal getSpreaduplmt() {
        return spreaduplmt;
    }

    public void setSpreaduplmt(BigDecimal spreaduplmt) {
        this.spreaduplmt = spreaduplmt;
    }

    public BigDecimal getSpreaddownlmt() {
        return spreaddownlmt;
    }

    public void setSpreaddownlmt(BigDecimal spreaddownlmt) {
        this.spreaddownlmt = spreaddownlmt;
    }

    public Short getFeealgr() {
        return feealgr;
    }

    public void setFeealgr(Short feealgr) {
        this.feealgr = feealgr;
    }

    public BigDecimal getFeerateB() {
        return feerateB;
    }

    public void setFeerateB(BigDecimal feerateB) {
        this.feerateB = feerateB;
    }

    public BigDecimal getFeerateS() {
        return feerateS;
    }

    public void setFeerateS(BigDecimal feerateS) {
        this.feerateS = feerateS;
    }

    public Short getMarginalgr() {
        return marginalgr;
    }

    public void setMarginalgr(Short marginalgr) {
        this.marginalgr = marginalgr;
    }

    public BigDecimal getMarginrateB() {
        return marginrateB;
    }

    public void setMarginrateB(BigDecimal marginrateB) {
        this.marginrateB = marginrateB;
    }

    public BigDecimal getMarginrateS() {
        return marginrateS;
    }

    public void setMarginrateS(BigDecimal marginrateS) {
        this.marginrateS = marginrateS;
    }

    public BigDecimal getMarginassureB() {
        return marginassureB;
    }

    public void setMarginassureB(BigDecimal marginassureB) {
        this.marginassureB = marginassureB;
    }

    public BigDecimal getMarginassureS() {
        return marginassureS;
    }

    public void setMarginassureS(BigDecimal marginassureS) {
        this.marginassureS = marginassureS;
    }

    public BigDecimal getTodayclosefeerateB() {
        return todayclosefeerateB;
    }

    public void setTodayclosefeerateB(BigDecimal todayclosefeerateB) {
        this.todayclosefeerateB = todayclosefeerateB;
    }

    public BigDecimal getTodayclosefeerateS() {
        return todayclosefeerateS;
    }

    public void setTodayclosefeerateS(BigDecimal todayclosefeerateS) {
        this.todayclosefeerateS = todayclosefeerateS;
    }

    public BigDecimal getHistoryclosefeerateB() {
        return historyclosefeerateB;
    }

    public void setHistoryclosefeerateB(BigDecimal historyclosefeerateB) {
        this.historyclosefeerateB = historyclosefeerateB;
    }

    public BigDecimal getHistoryclosefeerateS() {
        return historyclosefeerateS;
    }

    public void setHistoryclosefeerateS(BigDecimal historyclosefeerateS) {
        this.historyclosefeerateS = historyclosefeerateS;
    }

    public Long getLimitcmdtyqty() {
        return limitcmdtyqty;
    }

    public void setLimitcmdtyqty(Long limitcmdtyqty) {
        this.limitcmdtyqty = limitcmdtyqty;
    }

    public Short getSettlefeealgr() {
        return settlefeealgr;
    }

    public void setSettlefeealgr(Short settlefeealgr) {
        this.settlefeealgr = settlefeealgr;
    }

    public BigDecimal getSettlefeerateB() {
        return settlefeerateB;
    }

    public void setSettlefeerateB(BigDecimal settlefeerateB) {
        this.settlefeerateB = settlefeerateB;
    }

    public BigDecimal getSettlefeerateS() {
        return settlefeerateS;
    }

    public void setSettlefeerateS(BigDecimal settlefeerateS) {
        this.settlefeerateS = settlefeerateS;
    }

    public Short getForceclosefeealgr() {
        return forceclosefeealgr;
    }

    public void setForceclosefeealgr(Short forceclosefeealgr) {
        this.forceclosefeealgr = forceclosefeealgr;
    }

    public BigDecimal getForceclosefeerateB() {
        return forceclosefeerateB;
    }

    public void setForceclosefeerateB(BigDecimal forceclosefeerateB) {
        this.forceclosefeerateB = forceclosefeerateB;
    }

    public BigDecimal getForceclosefeerateS() {
        return forceclosefeerateS;
    }

    public void setForceclosefeerateS(BigDecimal forceclosefeerateS) {
        this.forceclosefeerateS = forceclosefeerateS;
    }

    public Short getSettlemarginalgrB() {
        return settlemarginalgrB;
    }

    public void setSettlemarginalgrB(Short settlemarginalgrB) {
        this.settlemarginalgrB = settlemarginalgrB;
    }

    public BigDecimal getSettlemarginrateB() {
        return settlemarginrateB;
    }

    public void setSettlemarginrateB(BigDecimal settlemarginrateB) {
        this.settlemarginrateB = settlemarginrateB;
    }

    public Short getSettlemarginalgrS() {
        return settlemarginalgrS;
    }

    public void setSettlemarginalgrS(Short settlemarginalgrS) {
        this.settlemarginalgrS = settlemarginalgrS;
    }

    public BigDecimal getSettlemarginrateS() {
        return settlemarginrateS;
    }

    public void setSettlemarginrateS(BigDecimal settlemarginrateS) {
        this.settlemarginrateS = settlemarginrateS;
    }

    public BigDecimal getAddedtax() {
        return addedtax;
    }

    public void setAddedtax(BigDecimal addedtax) {
        this.addedtax = addedtax;
    }

    public Short getMarginpricetype() {
        return marginpricetype;
    }

    public void setMarginpricetype(Short marginpricetype) {
        this.marginpricetype = marginpricetype;
    }

    public BigDecimal getLowestsettlefee() {
        return lowestsettlefee;
    }

    public void setLowestsettlefee(BigDecimal lowestsettlefee) {
        this.lowestsettlefee = lowestsettlefee;
    }

    public Long getLimitbreedqty() {
        return limitbreedqty;
    }

    public void setLimitbreedqty(Long limitbreedqty) {
        this.limitbreedqty = limitbreedqty;
    }

    public Long getFirmcleanqty() {
        return firmcleanqty;
    }

    public void setFirmcleanqty(Long firmcleanqty) {
        this.firmcleanqty = firmcleanqty;
    }

    public Long getFirmmaxholdqty() {
        return firmmaxholdqty;
    }

    public void setFirmmaxholdqty(Long firmmaxholdqty) {
        this.firmmaxholdqty = firmmaxholdqty;
    }

    public BigDecimal getMarginitem1() {
        return marginitem1;
    }

    public void setMarginitem1(BigDecimal marginitem1) {
        this.marginitem1 = marginitem1;
    }

    public BigDecimal getMarginitem2() {
        return marginitem2;
    }

    public void setMarginitem2(BigDecimal marginitem2) {
        this.marginitem2 = marginitem2;
    }

    public BigDecimal getMarginitem3() {
        return marginitem3;
    }

    public void setMarginitem3(BigDecimal marginitem3) {
        this.marginitem3 = marginitem3;
    }

    public BigDecimal getMarginitem4() {
        return marginitem4;
    }

    public void setMarginitem4(BigDecimal marginitem4) {
        this.marginitem4 = marginitem4;
    }

    public BigDecimal getMarginitem1S() {
        return marginitem1S;
    }

    public void setMarginitem1S(BigDecimal marginitem1S) {
        this.marginitem1S = marginitem1S;
    }

    public BigDecimal getMarginitem2S() {
        return marginitem2S;
    }

    public void setMarginitem2S(BigDecimal marginitem2S) {
        this.marginitem2S = marginitem2S;
    }

    public BigDecimal getMarginitem3S() {
        return marginitem3S;
    }

    public void setMarginitem3S(BigDecimal marginitem3S) {
        this.marginitem3S = marginitem3S;
    }

    public BigDecimal getMarginitem4S() {
        return marginitem4S;
    }

    public void setMarginitem4S(BigDecimal marginitem4S) {
        this.marginitem4S = marginitem4S;
    }

    public BigDecimal getMarginitemassure1() {
        return marginitemassure1;
    }

    public void setMarginitemassure1(BigDecimal marginitemassure1) {
        this.marginitemassure1 = marginitemassure1;
    }

    public BigDecimal getMarginitemassure2() {
        return marginitemassure2;
    }

    public void setMarginitemassure2(BigDecimal marginitemassure2) {
        this.marginitemassure2 = marginitemassure2;
    }

    public BigDecimal getMarginitemassure3() {
        return marginitemassure3;
    }

    public void setMarginitemassure3(BigDecimal marginitemassure3) {
        this.marginitemassure3 = marginitemassure3;
    }

    public BigDecimal getMarginitemassure4() {
        return marginitemassure4;
    }

    public void setMarginitemassure4(BigDecimal marginitemassure4) {
        this.marginitemassure4 = marginitemassure4;
    }

    public BigDecimal getMarginitemassure1S() {
        return marginitemassure1S;
    }

    public void setMarginitemassure1S(BigDecimal marginitemassure1S) {
        this.marginitemassure1S = marginitemassure1S;
    }

    public BigDecimal getMarginitemassure2S() {
        return marginitemassure2S;
    }

    public void setMarginitemassure2S(BigDecimal marginitemassure2S) {
        this.marginitemassure2S = marginitemassure2S;
    }

    public BigDecimal getMarginitemassure3S() {
        return marginitemassure3S;
    }

    public void setMarginitemassure3S(BigDecimal marginitemassure3S) {
        this.marginitemassure3S = marginitemassure3S;
    }

    public BigDecimal getMarginitemassure4S() {
        return marginitemassure4S;
    }

    public void setMarginitemassure4S(BigDecimal marginitemassure4S) {
        this.marginitemassure4S = marginitemassure4S;
    }

    public Integer getOrderprivilege() {
        return orderprivilege;
    }

    public void setOrderprivilege(Integer orderprivilege) {
        this.orderprivilege = orderprivilege;
    }

    public Short getPayoutalgr() {
        return payoutalgr;
    }

    public void setPayoutalgr(Short payoutalgr) {
        this.payoutalgr = payoutalgr;
    }

    public BigDecimal getPayoutrate() {
        return payoutrate;
    }

    public void setPayoutrate(BigDecimal payoutrate) {
        this.payoutrate = payoutrate;
    }

    public BigDecimal getAddedtaxfactor() {
        return addedtaxfactor;
    }

    public void setAddedtaxfactor(BigDecimal addedtaxfactor) {
        this.addedtaxfactor = addedtaxfactor;
    }

    public BigDecimal getMarginitem5() {
        return marginitem5;
    }

    public void setMarginitem5(BigDecimal marginitem5) {
        this.marginitem5 = marginitem5;
    }

    public BigDecimal getMarginitem5S() {
        return marginitem5S;
    }

    public void setMarginitem5S(BigDecimal marginitem5S) {
        this.marginitem5S = marginitem5S;
    }

    public BigDecimal getMarginitemassure5() {
        return marginitemassure5;
    }

    public void setMarginitemassure5(BigDecimal marginitemassure5) {
        this.marginitemassure5 = marginitemassure5;
    }

    public BigDecimal getMarginitemassure5S() {
        return marginitemassure5S;
    }

    public void setMarginitemassure5S(BigDecimal marginitemassure5S) {
        this.marginitemassure5S = marginitemassure5S;
    }

    public Short getSettlepricetype() {
        return settlepricetype;
    }

    public void setSettlepricetype(Short settlepricetype) {
        this.settlepricetype = settlepricetype;
    }

    public Short getBeforedays() {
        return beforedays;
    }

    public void setBeforedays(Short beforedays) {
        this.beforedays = beforedays;
    }

    public BigDecimal getSpecsettleprice() {
        return specsettleprice;
    }

    public void setSpecsettleprice(BigDecimal specsettleprice) {
        this.specsettleprice = specsettleprice;
    }

    public Short getFirmmaxholdqtyalgr() {
        return firmmaxholdqtyalgr;
    }

    public void setFirmmaxholdqtyalgr(Short firmmaxholdqtyalgr) {
        this.firmmaxholdqtyalgr = firmmaxholdqtyalgr;
    }

    public Long getStartpercentqty() {
        return startpercentqty;
    }

    public void setStartpercentqty(Long startpercentqty) {
        this.startpercentqty = startpercentqty;
    }

    public BigDecimal getMaxpercentlimit() {
        return maxpercentlimit;
    }

    public void setMaxpercentlimit(BigDecimal maxpercentlimit) {
        this.maxpercentlimit = maxpercentlimit;
    }

    public Long getOnemaxholdqty() {
        return onemaxholdqty;
    }

    public void setOnemaxholdqty(Long onemaxholdqty) {
        this.onemaxholdqty = onemaxholdqty;
    }

    public Short getMinquantitymove() {
        return minquantitymove;
    }

    public void setMinquantitymove(Short minquantitymove) {
        this.minquantitymove = minquantitymove;
    }

    public String getContractfactorname() {
        return contractfactorname;
    }

    public void setContractfactorname(String contractfactorname) {
        this.contractfactorname = contractfactorname == null ? null : contractfactorname.trim();
    }

    public BigDecimal getDelayrecouprate() {
        return delayrecouprate;
    }

    public void setDelayrecouprate(BigDecimal delayrecouprate) {
        this.delayrecouprate = delayrecouprate;
    }

    public Short getSettleway() {
        return settleway;
    }

    public void setSettleway(Short settleway) {
        this.settleway = settleway;
    }

    public Short getDelayfeeway() {
        return delayfeeway;
    }

    public void setDelayfeeway(Short delayfeeway) {
        this.delayfeeway = delayfeeway;
    }

    public BigDecimal getMaxfeerate() {
        return maxfeerate;
    }

    public void setMaxfeerate(BigDecimal maxfeerate) {
        this.maxfeerate = maxfeerate;
    }

    public Integer getMinsettlemoveqty() {
        return minsettlemoveqty;
    }

    public void setMinsettlemoveqty(Integer minsettlemoveqty) {
        this.minsettlemoveqty = minsettlemoveqty;
    }

    public Short getBreedtrademode() {
        return breedtrademode;
    }

    public void setBreedtrademode(Short breedtrademode) {
        this.breedtrademode = breedtrademode;
    }

    public BigDecimal getStorerecouprate() {
        return storerecouprate;
    }

    public void setStorerecouprate(BigDecimal storerecouprate) {
        this.storerecouprate = storerecouprate;
    }

    public Long getMinsettleqty() {
        return minsettleqty;
    }

    public void setMinsettleqty(Long minsettleqty) {
        this.minsettleqty = minsettleqty;
    }

    public BigDecimal getDelayrecouprateS() {
        return delayrecouprateS;
    }

    public void setDelayrecouprateS(BigDecimal delayrecouprateS) {
        this.delayrecouprateS = delayrecouprateS;
    }

    public Short getDelaysettlepricetype() {
        return delaysettlepricetype;
    }

    public void setDelaysettlepricetype(Short delaysettlepricetype) {
        this.delaysettlepricetype = delaysettlepricetype;
    }

    public Short getAheadsettlepricetype() {
        return aheadsettlepricetype;
    }

    public void setAheadsettlepricetype(Short aheadsettlepricetype) {
        this.aheadsettlepricetype = aheadsettlepricetype;
    }

    public Short getSettlemargintype() {
        return settlemargintype;
    }

    public void setSettlemargintype(Short settlemargintype) {
        this.settlemargintype = settlemargintype;
    }

    public Short getBeforedaysM() {
        return beforedaysM;
    }

    public void setBeforedaysM(Short beforedaysM) {
        this.beforedaysM = beforedaysM;
    }

    public Long getSideholdlimitqty() {
        return sideholdlimitqty;
    }

    public void setSideholdlimitqty(Long sideholdlimitqty) {
        this.sideholdlimitqty = sideholdlimitqty;
    }

    public Short getHolddayslimit() {
        return holddayslimit;
    }

    public void setHolddayslimit(Short holddayslimit) {
        this.holddayslimit = holddayslimit;
    }

    public Long getMaxholdpositionday() {
        return maxholdpositionday;
    }

    public void setMaxholdpositionday(Long maxholdpositionday) {
        this.maxholdpositionday = maxholdpositionday;
    }
}