package hello;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by mac on 15/12/20.
 */
public class PeopleList {

    @JsonProperty
    private List<People> names;

    public List<People> getNames() {
        return names;
    }

    public void setNames(List<People> names) {
        this.names = names;
    }
}
