package com.dwyw.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostCreate {

    private String title;
    private String content;

    @Override
    public String toString() {
        return "PostCreate{" +
            "title='" + title + '\'' +
            ", content='" + content + '\'' +
            '}';
    }
}
