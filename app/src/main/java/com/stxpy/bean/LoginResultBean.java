package com.stxpy.bean;

/**
 * Created by Administrator on 2017/1/18.
 */

public class LoginResultBean {

    /**
     * ID : 1
     * NAME : 唐志均
     * OrgID : 1
     * LogName : tzj
     * Role_ID : 1
     */

    private int ID;
    private String NAME;
    private int OrgID;
    private String LogName;
    private int Role_ID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public int getOrgID() {
        return OrgID;
    }

    public void setOrgID(int OrgID) {
        this.OrgID = OrgID;
    }

    public String getLogName() {
        return LogName;
    }

    public void setLogName(String LogName) {
        this.LogName = LogName;
    }

    public int getRole_ID() {
        return Role_ID;
    }

    public void setRole_ID(int Role_ID) {
        this.Role_ID = Role_ID;
    }
}
