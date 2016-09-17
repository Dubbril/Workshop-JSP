package model;

public class Page {

    private int numItem;
    private int pageNo;
    private int pageSize;

    public Page(int numItem, int pageNo, int pageSize) {
        this.numItem = numItem;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public int getFromIndex() {
        return pageNo * pageSize;
    }

    public int getToIndex() {
        return Math.min((pageNo + 1) * pageSize, numItem);
    }

    public int size() {
        return (int) Math.ceil((double) numItem / pageSize);
    }

    public int getNumItem() {
        return numItem;
    }

    public void setNumItem(int numItem) {
        this.numItem = numItem;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

}
