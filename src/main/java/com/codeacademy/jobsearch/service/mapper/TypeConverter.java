package com.codeacademy.jobsearch.service.mapper;

import com.codeacademy.jobsearch.entity.Post;
import com.codeacademy.jobsearch.entity.Type;
import com.codeacademy.jobsearch.entity.dto.PostDTO;
import org.springframework.stereotype.Component;

@Component
public class TypeConverter {

    public void convertType(PostDTO postDTO, Post post) {
        if (postDTO.getType().equalsIgnoreCase(Type.PART_TIME.name())
                || postDTO.getType().equalsIgnoreCase("part time")
                || postDTO.getType().equalsIgnoreCase("parttime")) {
            post.setType(Type.PART_TIME);
        } else if (postDTO.getType().equalsIgnoreCase(Type.FULL_TIME.name())
                || postDTO.getType().equalsIgnoreCase("full time")
                || postDTO.getType().equalsIgnoreCase("fulltime")) {
            post.setType(Type.FULL_TIME);
        } else if (postDTO.getType().equalsIgnoreCase(Type.INTERNSHIP.name())) {
            post.setType(Type.INTERNSHIP);
        } else if (postDTO.getType().equalsIgnoreCase(Type.REMOTE.name())) {
            post.setType(Type.REMOTE);
        }
    }
}
