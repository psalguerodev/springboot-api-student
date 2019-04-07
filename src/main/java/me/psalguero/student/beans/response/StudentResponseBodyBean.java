package me.psalguero.student.beans.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import me.psalguero.student.beans.request.AbstractBodyBean;
import me.psalguero.student.entities.Student;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class StudentResponseBodyBean extends AbstractBodyBean {

    private static final long serialVersionUID = 4195026754723173908L;

    @JsonProperty("student")
    private Student student;
}
