package com.lab3.book.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.core.io.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * BookPath
 */
@Validated

public class BookPath {
    @JsonProperty("additionalMetadata")
    private String additionalMetadata = null;

    @JsonProperty("file")
    private Resource file = null;

    public BookPath additionalMetadata(String additionalMetadata) {
        this.additionalMetadata = additionalMetadata;
        return this;
    }


    public String getAdditionalMetadata() {
        return additionalMetadata;
    }

    public void setAdditionalMetadata(String additionalMetadata) {
        this.additionalMetadata = additionalMetadata;
    }

    public BookPath file(Resource file) {
        this.file = file;
        return this;
    }


    public Resource getFile() {
        return file;
    }

    public void setFile(Resource file) {
        this.file = file;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BookPath bookPath = (BookPath) o;
        return Objects.equals(this.additionalMetadata, bookPath.additionalMetadata) &&
                Objects.equals(this.file, bookPath.file);
    }

    @Override
    public int hashCode() {
        return Objects.hash(additionalMetadata, file);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BookPath {\n");

        sb.append("    additionalMetadata: ").append(toIndentedString(additionalMetadata)).append("\n");
        sb.append("    file: ").append(toIndentedString(file)).append("\n");
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
