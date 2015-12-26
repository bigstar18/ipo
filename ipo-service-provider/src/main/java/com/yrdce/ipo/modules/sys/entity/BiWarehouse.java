package com.yrdce.ipo.modules.sys.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 仓库表
 * 
 * @author chenjing
 *
 */
public class BiWarehouse {
	private Long id;

	private String warehouseid;

	private String warehousename;

	private Short status;

	private String ownershipunits;

	private BigDecimal registeredcapital;

	private BigDecimal investmentamount;

	private String address;

	private String coordinate;

	private String environmental;

	private Short rank;

	private String testconditions;

	private Date agreementdate;

	private String province;

	private String city;

	private String postcode;

	private String corporaterepresentative;

	private String representativephone;

	private String contactman;

	private String phone;

	private String mobile;

	private String fax;

	private Short hasdock;

	private BigDecimal docktonnage;

	private BigDecimal dockdailythroughput;

	private Short shiptype;

	private Short hasrailway;

	private BigDecimal railwaydailythroughput;

	private Short hastanker;

	private BigDecimal tankerdailythroughput;

	private Date createtime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWarehouseid() {
		return warehouseid;
	}

	public void setWarehouseid(String warehouseid) {
		this.warehouseid = warehouseid == null ? null : warehouseid.trim();
	}

	public String getWarehousename() {
		return warehousename;
	}

	public void setWarehousename(String warehousename) {
		this.warehousename = warehousename == null ? null : warehousename
				.trim();
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public String getOwnershipunits() {
		return ownershipunits;
	}

	public void setOwnershipunits(String ownershipunits) {
		this.ownershipunits = ownershipunits == null ? null : ownershipunits
				.trim();
	}

	public BigDecimal getRegisteredcapital() {
		return registeredcapital;
	}

	public void setRegisteredcapital(BigDecimal registeredcapital) {
		this.registeredcapital = registeredcapital;
	}

	public BigDecimal getInvestmentamount() {
		return investmentamount;
	}

	public void setInvestmentamount(BigDecimal investmentamount) {
		this.investmentamount = investmentamount;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	public String getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(String coordinate) {
		this.coordinate = coordinate == null ? null : coordinate.trim();
	}

	public String getEnvironmental() {
		return environmental;
	}

	public void setEnvironmental(String environmental) {
		this.environmental = environmental == null ? null : environmental
				.trim();
	}

	public Short getRank() {
		return rank;
	}

	public void setRank(Short rank) {
		this.rank = rank;
	}

	public String getTestconditions() {
		return testconditions;
	}

	public void setTestconditions(String testconditions) {
		this.testconditions = testconditions == null ? null : testconditions
				.trim();
	}

	public Date getAgreementdate() {
		return agreementdate;
	}

	public void setAgreementdate(Date agreementdate) {
		this.agreementdate = agreementdate;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province == null ? null : province.trim();
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city == null ? null : city.trim();
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode == null ? null : postcode.trim();
	}

	public String getCorporaterepresentative() {
		return corporaterepresentative;
	}

	public void setCorporaterepresentative(String corporaterepresentative) {
		this.corporaterepresentative = corporaterepresentative == null ? null
				: corporaterepresentative.trim();
	}

	public String getRepresentativephone() {
		return representativephone;
	}

	public void setRepresentativephone(String representativephone) {
		this.representativephone = representativephone == null ? null
				: representativephone.trim();
	}

	public String getContactman() {
		return contactman;
	}

	public void setContactman(String contactman) {
		this.contactman = contactman == null ? null : contactman.trim();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile == null ? null : mobile.trim();
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax == null ? null : fax.trim();
	}

	public Short getHasdock() {
		return hasdock;
	}

	public void setHasdock(Short hasdock) {
		this.hasdock = hasdock;
	}

	public BigDecimal getDocktonnage() {
		return docktonnage;
	}

	public void setDocktonnage(BigDecimal docktonnage) {
		this.docktonnage = docktonnage;
	}

	public BigDecimal getDockdailythroughput() {
		return dockdailythroughput;
	}

	public void setDockdailythroughput(BigDecimal dockdailythroughput) {
		this.dockdailythroughput = dockdailythroughput;
	}

	public Short getShiptype() {
		return shiptype;
	}

	public void setShiptype(Short shiptype) {
		this.shiptype = shiptype;
	}

	public Short getHasrailway() {
		return hasrailway;
	}

	public void setHasrailway(Short hasrailway) {
		this.hasrailway = hasrailway;
	}

	public BigDecimal getRailwaydailythroughput() {
		return railwaydailythroughput;
	}

	public void setRailwaydailythroughput(BigDecimal railwaydailythroughput) {
		this.railwaydailythroughput = railwaydailythroughput;
	}

	public Short getHastanker() {
		return hastanker;
	}

	public void setHastanker(Short hastanker) {
		this.hastanker = hastanker;
	}

	public BigDecimal getTankerdailythroughput() {
		return tankerdailythroughput;
	}

	public void setTankerdailythroughput(BigDecimal tankerdailythroughput) {
		this.tankerdailythroughput = tankerdailythroughput;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
}