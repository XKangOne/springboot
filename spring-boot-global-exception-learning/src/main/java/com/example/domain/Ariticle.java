package com.example.domain;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Ariticle {
    @Min(4)
    private Integer id;
    @NotEmpty(message = "文章内容不能为空")
    private String title;
    private String author;
}
