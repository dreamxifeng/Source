/*    */ package cn.zhouxp.customer.domodel;
/*    */ 
/*    */ import cn.zhouxp.customer.model.Customer;
/*    */ 
/*    */ public class CustomerDo
/*    */   extends Customer
/*    */ {
/*    */   private String cateName;
/*    */   
/* 10 */   public String toString() {
    return "CustomerDo(cateName=" + getCateName() + ")";
}
    public int hashCode() { int PRIME = 59,result = 1;
    Object $cateName = getCateName();
    return result * 59 + (($cateName == null) ? 43 : $cateName.hashCode()); }
    protected boolean canEqual(Object other) {
    return other instanceof CustomerDo;
}
    public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof CustomerDo)) return false;  CustomerDo other = (CustomerDo)o; if (!other.canEqual(this)) return false;  Object this$cateName = getCateName(), other$cateName = other.getCateName(); return !((this$cateName == null) ? (other$cateName != null) : !this$cateName.equals(other$cateName)); } public void setCateName(String cateName) { this.cateName = cateName; }
/*    */   
/* 12 */   public String getCateName() { return this.cateName; }
/*    */ }
