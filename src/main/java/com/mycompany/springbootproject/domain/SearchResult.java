/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springbootproject.domain;

import java.util.List;

/**
 *
 * @author wmfsystem
 */
public class SearchResult<T extends Object> {

    private int pageSize;
    private Long count;
    private int start;
    private List<T> values;

    public SearchResult() {
    }

    public SearchResult(int pageSize, Long count, int start, List<T> values) {
        this.pageSize = pageSize;
        this.count = count;
        this.start = start;
        this.values = values;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public List<T> getValues() {
        return values;
    }

    public void setValues(List<T> values) {
        this.values = values;
    }

}
