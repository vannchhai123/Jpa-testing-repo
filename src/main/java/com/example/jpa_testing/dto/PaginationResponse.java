package com.example.jpa_testing.dto;

import lombok.Data;

import java.util.List;

@Data
public class PaginationResponse<T> {
    private List<T> data;
    private Pagination pagination;
}
