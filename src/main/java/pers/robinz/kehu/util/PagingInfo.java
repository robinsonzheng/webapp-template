package pers.robinz.kehu.util;

/**
 * Created by Robinz on 2018-06-06.
 * 分页信息辅助类
 */
public class PagingInfo {
    private int offset = 0;
    private int limit = 50;
    private int totalCount = 0;
    private int page = 0;
    private int totalPage = 0;
    private int pageSize = 0;

    public int getOffset() {
        return offset;
    }

    public int getLimit() {
        return limit;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getPage() {
        return page;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public PagingInfo(int totalCount, int page, int pageSize) {
        this.totalCount = totalCount;
        this.page = page;
        this.pageSize = pageSize;
        if (this.pageSize > 0) {
            this.limit = this.pageSize;
        }
        if (this.page > 0) {
            this.offset = (this.page - 1) * this.limit;
        }
        if (this.totalCount > 0) {
            this.totalPage = this.totalCount / this.limit + ((this.totalCount % this.limit) > 0 ? 1 : 0);
        }
    }
}
