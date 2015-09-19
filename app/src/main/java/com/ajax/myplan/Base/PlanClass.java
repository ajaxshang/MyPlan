package com.ajax.myplan.Base;


/**
 * Created by ajax on 2015/7/1.
 */
public class PlanClass {
    private long rowID;
    private String details;
    private String starttime;
    private String endtime;
    private boolean isactivate;
    private boolean isday;
    private boolean isweek;
    private boolean isexpire;

    public PlanClass() {
    }

    public PlanClass(String details, String starttime, String endtime, boolean isactivate, boolean isday, boolean isweek, boolean isexpire) {
        this.details = details;
        this.starttime = starttime;
        this.endtime = endtime;
        this.isactivate = isactivate;
        this.isday = isday;
        this.isweek = isweek;
        this.isexpire = isexpire;
    }

    public long getRowID() {
        return rowID;
    }

    public void setRowID(long rowID) {
        this.rowID = rowID;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public boolean isactivate() {
        return isactivate;
    }

    public void setIsactivate(boolean isactivate) {
        this.isactivate = isactivate;
    }

    public boolean isday() {
        return isday;
    }

    public void setIsday(boolean isday) {
        this.isday = isday;
    }

    public boolean isweek() {
        return isweek;
    }

    public void setIsweek(boolean isweek) {
        this.isweek = isweek;
    }

    public boolean isexpire() {
        return isexpire;
    }

    public void setIsexpire(boolean isexpire) {
        this.isexpire = isexpire;
    }
}
