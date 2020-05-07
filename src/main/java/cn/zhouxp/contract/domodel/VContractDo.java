/*    */ package cn.zhouxp.contract.domodel;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class VContractDo { @Excel(name = "花号", orderNum = "0")
/*    */   private String flowerNo; @Excel(name = "日期", orderNum = "1")
/*    */   private String cdate; @Excel(name = "客户名称", orderNum = "2")
/*    */   private String customerName; @Excel(name = "柜号", orderNum = "3")
/*    */   private String container; @Excel(name = "码口", orderNum = "4")
/*    */   private Long codePortName; @Excel(name = "成品幅宽", orderNum = "5")
/*    */   private Long prouctWidthName; @Excel(name = "开剪码数", orderNum = "6")
/*    */   private Long openScissorsName; @Excel(name = "成件码数", orderNum = "7")
/*    */   private Long productName;
/* 10 */   public void setFlowerNo(String flowerNo) { this.flowerNo = flowerNo; } @Excel(name = "供应要求", orderNum = "8") private String technologyName; @Excel(name = "数量", orderNum = "9") private Integer cnumber; @Excel(name = "包装要求", orderNum = "10") private String packingName; @Excel(name = "样品", orderNum = "11") private Integer sampleName; @Excel(name = "坯布克重", orderNum = "12") private Integer greyWeight; @Excel(name = "成品克重", orderNum = "13") private Integer productWeight; @Excel(name = "唛头", orderNum = "14") private String shippingMark; @Excel(name = "边标", orderNum = "15") private String selvageMark; @Excel(name = "备注", orderNum = "16") private String remarks; public void setCdate(String cdate) { this.cdate = cdate; }
public void setCustomerName(String customerName) { this.customerName = customerName; } public void setContainer(String container) { this.container = container; } public void setCodePortName(Long codePortName) { this.codePortName = codePortName; } public void setProuctWidthName(Long prouctWidthName) { this.prouctWidthName = prouctWidthName; } public void setOpenScissorsName(Long openScissorsName) { this.openScissorsName = openScissorsName; } public void setProductName(Long productName) { this.productName = productName; } public void setTechnologyName(String technologyName) { this.technologyName = technologyName; } public void setCnumber(Integer cnumber) { this.cnumber = cnumber; }
public void setPackingName(String packingName) { this.packingName = packingName; } public void setSampleName(Integer sampleName) { this.sampleName = sampleName; } public void setGreyWeight(Integer greyWeight) { this.greyWeight = greyWeight; } public void setProductWeight(Integer productWeight) { this.productWeight = productWeight; } public void setShippingMark(String shippingMark) { this.shippingMark = shippingMark; } public void setSelvageMark(String selvageMark) { this.selvageMark = selvageMark; } public void setRemarks(String remarks) { this.remarks = remarks; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof VContractDo)) return false;  VContractDo other = (VContractDo)o; if (!other.canEqual(this)) return false;  Object this$flowerNo = getFlowerNo(), other$flowerNo = other.getFlowerNo(); if ((this$flowerNo == null) ? (other$flowerNo != null) : !this$flowerNo.equals(other$flowerNo)) return false;  Object this$cdate = getCdate(), other$cdate = other.getCdate(); if ((this$cdate == null) ? (other$cdate != null) : !this$cdate.equals(other$cdate)) return false;  Object this$customerName = getCustomerName(), other$customerName = other.getCustomerName(); if ((this$customerName == null) ? (other$customerName != null) : !this$customerName.equals(other$customerName)) return false;  Object this$container = getContainer(), other$container = other.getContainer(); if ((this$container == null) ? (other$container != null) : !this$container.equals(other$container)) return false;  Object this$codePortName = getCodePortName(), other$codePortName = other.getCodePortName(); if ((this$codePortName == null) ? (other$codePortName != null) : !this$codePortName.equals(other$codePortName)) return false;  Object this$prouctWidthName = getProuctWidthName(), other$prouctWidthName = other.getProuctWidthName(); if ((this$prouctWidthName == null) ? (other$prouctWidthName != null) : !this$prouctWidthName.equals(other$prouctWidthName)) return false;
Object this$openScissorsName = getOpenScissorsName(), other$openScissorsName = other.getOpenScissorsName(); if ((this$openScissorsName == null) ? (other$openScissorsName != null) : !this$openScissorsName.equals(other$openScissorsName)) return false;  Object this$productName = getProductName(), other$productName = other.getProductName();
if ((this$productName == null) ? (other$productName != null) : !this$productName.equals(other$productName)) return false;  Object this$technologyName = getTechnologyName(), other$technologyName = other.getTechnologyName(); if ((this$technologyName == null) ? (other$technologyName != null) : !this$technologyName.equals(other$technologyName)) return false;  Object this$cnumber = getCnumber(), other$cnumber = other.getCnumber(); if ((this$cnumber == null) ? (other$cnumber != null) : !this$cnumber.equals(other$cnumber)) return false;  Object this$packingName = getPackingName(), other$packingName = other.getPackingName(); if ((this$packingName == null) ? (other$packingName != null) : !this$packingName.equals(other$packingName)) return false;  Object this$sampleName = getSampleName(), other$sampleName = other.getSampleName(); if ((this$sampleName == null) ? (other$sampleName != null) : !this$sampleName.equals(other$sampleName)) return false;  Object this$greyWeight = getGreyWeight(), other$greyWeight = other.getGreyWeight(); if ((this$greyWeight == null) ? (other$greyWeight != null) : !this$greyWeight.equals(other$greyWeight)) return false;  Object this$productWeight = getProductWeight(), other$productWeight = other.getProductWeight(); if ((this$productWeight == null) ? (other$productWeight != null) : !this$productWeight.equals(other$productWeight)) return false;  Object this$shippingMark = getShippingMark(), other$shippingMark = other.getShippingMark(); if ((this$shippingMark == null) ? (other$shippingMark != null) : !this$shippingMark.equals(other$shippingMark)) return false;  Object this$selvageMark = getSelvageMark(), other$selvageMark = other.getSelvageMark(); if ((this$selvageMark == null) ? (other$selvageMark != null) : !this$selvageMark.equals(other$selvageMark)) return false;  Object this$remarks = getRemarks(), other$remarks = other.getRemarks(); return !((this$remarks == null) ? (other$remarks != null) : !this$remarks.equals(other$remarks)); } protected boolean canEqual(Object other) { return other instanceof VContractDo; }
public int hashCode() {
    int PRIME = 59;
    int result = 1;
    Object $flowerNo = getFlowerNo();
    result = result * 59 + (($flowerNo == null) ? 43 : $flowerNo.hashCode()); Object $cdate = getCdate(); result = result * 59 + (($cdate == null) ? 43 : $cdate.hashCode()); Object $customerName = getCustomerName(); result = result * 59 + (($customerName == null) ? 43 : $customerName.hashCode()); Object $container = getContainer(); result = result * 59 + (($container == null) ? 43 : $container.hashCode()); Object $codePortName = getCodePortName();
    result = result * 59 + (($codePortName == null) ? 43 : $codePortName.hashCode()); Object $prouctWidthName = getProuctWidthName(); result = result * 59 + (($prouctWidthName == null) ? 43 : $prouctWidthName.hashCode()); Object $openScissorsName = getOpenScissorsName(); result = result * 59 + (($openScissorsName == null) ? 43 : $openScissorsName.hashCode()); Object $productName = getProductName(); result = result * 59 + (($productName == null) ? 43 : $productName.hashCode()); Object $technologyName = getTechnologyName(); result = result * 59 + (($technologyName == null) ? 43 : $technologyName.hashCode()); Object $cnumber = getCnumber();
    result = result * 59 + (($cnumber == null) ? 43 : $cnumber.hashCode()); Object $packingName = getPackingName(); result = result * 59 + (($packingName == null) ? 43 : $packingName.hashCode()); Object $sampleName = getSampleName(); result = result * 59 + (($sampleName == null) ? 43 : $sampleName.hashCode()); Object $greyWeight = getGreyWeight(); result = result * 59 + (($greyWeight == null) ? 43 : $greyWeight.hashCode()); Object $productWeight = getProductWeight(); result = result * 59 + (($productWeight == null) ? 43 : $productWeight.hashCode()); Object $shippingMark = getShippingMark(); result = result * 59 + (($shippingMark == null) ? 43 : $shippingMark.hashCode()); Object $selvageMark = getSelvageMark(); result = result * 59 + (($selvageMark == null) ? 43 : $selvageMark.hashCode()); Object $remarks = getRemarks(); return result * 59 + (($remarks == null) ? 43 : $remarks.hashCode()); } public String toString() { return "VContractDo(flowerNo=" + getFlowerNo() + ", cdate=" + getCdate() + ", customerName=" + getCustomerName() + ", container=" + getContainer() + ", codePortName=" + getCodePortName() + ", prouctWidthName=" + getProuctWidthName() + ", openScissorsName=" + getOpenScissorsName() + ", productName=" + getProductName() + ", technologyName=" + getTechnologyName() + ", cnumber=" + getCnumber() + ", packingName=" + getPackingName() + ", sampleName=" + getSampleName() + ", greyWeight=" + getGreyWeight() + ", productWeight=" + getProductWeight() + ", shippingMark=" + getShippingMark() + ", selvageMark=" + getSelvageMark() + ", remarks=" + getRemarks() + ")"; }
/*    */ 
/*    */   
/* 13 */   public String getFlowerNo() { return this.flowerNo; }
/*    */   
/* 15 */   public String getCdate() { return this.cdate; }
/*    */   
/* 17 */   public String getCustomerName() { return this.customerName; }
/*    */   
/* 19 */   public String getContainer() { return this.container; }
/*    */ 
/*    */   
/* 22 */   public Long getCodePortName() { return this.codePortName; }
/*    */   
/* 24 */   public Long getProuctWidthName() { return this.prouctWidthName; }
/*    */   
/* 26 */   public Long getOpenScissorsName() { return this.openScissorsName; }
/*    */ 
/*    */   
/* 29 */   public Long getProductName() { return this.productName; }
/*    */ 
/*    */   
/* 32 */   public String getTechnologyName() { return this.technologyName; }
/*    */ 
/*    */   
/* 35 */   public Integer getCnumber() { return this.cnumber; }
/*    */ 
/*    */   
/* 38 */   public String getPackingName() { return this.packingName; }
/*    */ 
/*    */   
/* 41 */   public Integer getSampleName() { return this.sampleName; }
/*    */ 
/*    */   
/* 44 */   public Integer getGreyWeight() { return this.greyWeight; }
/*    */ 
/*    */   
/* 47 */   public Integer getProductWeight() { return this.productWeight; }
/*    */ 
/*    */   
/* 50 */   public String getShippingMark() { return this.shippingMark; }
/*    */ 
/*    */   
/* 53 */   public String getSelvageMark() { return this.selvageMark; }
/*    */ 
/*    */   
/* 56 */   public String getRemarks() { return this.remarks; } }

