package cn.zhouxp.customer.model;

import java.util.Date;

public class Categroy {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_categroy.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_categroy.cname
     *
     * @mbg.generated
     */
    private String cname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_categroy.isdel
     *
     * @mbg.generated
     */
    private Boolean isdel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_categroy.remarks
     *
     * @mbg.generated
     */
    private String remarks;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_categroy.opid
     *
     * @mbg.generated
     */
    private Long opid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_categroy.optime
     *
     * @mbg.generated
     */
    private Date optime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column c_categroy.id
     *
     * @return the value of c_categroy.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_categroy.id
     *
     * @param id the value for c_categroy.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column c_categroy.cname
     *
     * @return the value of c_categroy.cname
     *
     * @mbg.generated
     */
    public String getCname() {
        return cname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_categroy.cname
     *
     * @param cname the value for c_categroy.cname
     *
     * @mbg.generated
     */
    public void setCname(String cname) {
        this.cname = cname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column c_categroy.isdel
     *
     * @return the value of c_categroy.isdel
     *
     * @mbg.generated
     */
    public Boolean getIsdel() {
        return isdel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_categroy.isdel
     *
     * @param isdel the value for c_categroy.isdel
     *
     * @mbg.generated
     */
    public void setIsdel(Boolean isdel) {
        this.isdel = isdel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column c_categroy.remarks
     *
     * @return the value of c_categroy.remarks
     *
     * @mbg.generated
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_categroy.remarks
     *
     * @param remarks the value for c_categroy.remarks
     *
     * @mbg.generated
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column c_categroy.opid
     *
     * @return the value of c_categroy.opid
     *
     * @mbg.generated
     */
    public Long getOpid() {
        return opid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_categroy.opid
     *
     * @param opid the value for c_categroy.opid
     *
     * @mbg.generated
     */
    public void setOpid(Long opid) {
        this.opid = opid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column c_categroy.optime
     *
     * @return the value of c_categroy.optime
     *
     * @mbg.generated
     */
    public Date getOptime() {
        return optime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_categroy.optime
     *
     * @param optime the value for c_categroy.optime
     *
     * @mbg.generated
     */
    public void setOptime(Date optime) {
        this.optime = optime;
    }
}