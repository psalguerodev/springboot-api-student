package me.psalguero.student.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.psalguero.student.beans.request.AbstractBodyBean;
import me.psalguero.student.beans.response.AbstractHeaderBean;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractMessageBean<H extends AbstractHeaderBean, B extends AbstractBodyBean>
        implements Serializable {

    private static final long serialVersionUID = -2838413102856993626L;

    @JsonProperty("header")
    private H header;

    @JsonProperty("body")
    private B body;

    public AbstractMessageBean(H header){
        this.header = header;
    }

}
