package cn.zhouxp.common.model;

/**
 * @author wanghaunghuang
 * @create 2020-04-28 14:59
 */

public class SearchCon {
    private String findDate;
    private String container;
    private String flowerNo;
    private Integer finish;

    public void setFindDate(String findDate) { this.findDate = findDate; } public void setContainer(String container) { this.container = container; } public void setFlowerNo(String flowerNo) { this.flowerNo = flowerNo; } public void setFinish(Integer finish) { this.finish = finish; } public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof SearchCon)) return false;  SearchCon other = (SearchCon)o; if (!other.canEqual(this)) return false;  Object this$findDate = getFindDate(), other$findDate = other.getFindDate(); if ((this$findDate == null) ? (other$findDate != null) : !this$findDate.equals(other$findDate)) return false;  Object this$container = getContainer(), other$container = other.getContainer(); if ((this$container == null) ? (other$container != null) : !this$container.equals(other$container)) return false;  Object this$flowerNo = getFlowerNo(), other$flowerNo = other.getFlowerNo(); if ((this$flowerNo == null) ? (other$flowerNo != null) : !this$flowerNo.equals(other$flowerNo)) return false;  Object this$finish = getFinish(), other$finish = other.getFinish(); return !((this$finish == null) ? (other$finish != null) : !this$finish.equals(other$finish)); } protected boolean canEqual(Object other) { return other instanceof SearchCon; } public int hashCode() { int PRIME = 59, result = 1; Object $findDate = getFindDate(); result = result * 59 + (($findDate == null) ? 43 : $findDate.hashCode()); Object $container = getContainer(); result = result * 59 + (($container == null) ? 43 : $container.hashCode()); Object $flowerNo = getFlowerNo(); result = result * 59 + (($flowerNo == null) ? 43 : $flowerNo.hashCode()); Object $finish = getFinish(); return result * 59 + (($finish == null) ? 43 : $finish.hashCode()); } public String toString() { return "SearchCon(findDate=" + getFindDate() + ", container=" + getContainer() + ", flowerNo=" + getFlowerNo() + ", finish=" + getFinish() + ")"; }

    public String getFindDate() { return this.findDate; }
    public String getContainer() { return this.container; }
    public String getFlowerNo() { return this.flowerNo; }
    public Integer getFinish() { return this.finish; }
}
