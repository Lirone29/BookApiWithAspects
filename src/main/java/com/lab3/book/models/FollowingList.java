package com.lab3.book.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

public class FollowingList {
    @JsonProperty("id")
    private Integer id = null;

    @JsonProperty("userId")
    private Long userId = null;

    @JsonProperty("otherUserId")
    private Long otherUserId = null;

    public FollowingList id(Integer id) {
        this.id = id;
        return this;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public FollowingList userId(Long userId) {
        this.userId = userId;
        return this;
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public FollowingList otherUserId(Long otherUserId) {
        this.otherUserId = otherUserId;
        return this;
    }


    public Long getOtherUserId() {
        return otherUserId;
    }

    public void setOtherUserId(Long otherUserId) {
        this.otherUserId = otherUserId;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FollowingList followingList = (FollowingList) o;
        return Objects.equals(this.id, followingList.id) &&
                Objects.equals(this.userId, followingList.userId) &&
                Objects.equals(this.otherUserId, followingList.otherUserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, otherUserId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FollowingList {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
        sb.append("    otherUserId: ").append(toIndentedString(otherUserId)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
