package com.platzi.jobsearch;

import java.util.List;
import java.util.Objects;

public class APIResponse {

    private Info info;

    private List<Character> results;

    @Override
    public String toString() {
        return "APIResponse{" +
                "info=" + info +
                ", results=" + results +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        APIResponse that = (APIResponse) o;
        return Objects.equals(info, that.info) && Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(info, results);
    }

    public List<Character> getResults() {
        return results;
    }
}
