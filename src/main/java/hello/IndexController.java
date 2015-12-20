package hello;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/names")
    public  String getNames(){
        ObjectMapper jsonUtil = new ObjectMapper();
       PeopleList result = new PeopleList();
        List<People> names = new ArrayList<People>();
        People people = new People();
        people.setFirstName("JACK");
        people.setLastName("ZHANG");
        people.setMiddleName("JIAN");
        names.add(people);
        names.add(people);
        result.setNames(names);
        String json ="";
        try {
//            configure(JsonGenerator.Feature.QUOTE_FIELD_NAMES,false).
            json = jsonUtil.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            json ="names: [{ firstName: \"Seattle\", middleName: \"WA\" ,lastName:”zhang”},{ firstName: \"Seattle\", middleName: \"WA\" ,lastName:”zhang”},{ firstName: \"Seattle\", middleName: \"WA\" ,lastName:”zhang”}";
        }
        return json;
//        return "names: [{ firstName: \"Seattle\", middleName: \"WA\" ,lastName:”zhang”},{ firstName: \"Seattle\", middleName: \"WA\" ,lastName:”zhang”},{ firstName: \"Seattle\", middleName: \"WA\" ,lastName:”zhang”}";
    }
}
