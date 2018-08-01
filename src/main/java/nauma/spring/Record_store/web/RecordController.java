package nauma.spring.Record_store.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import nauma.spring.Record_store.domain.Record;
import nauma.spring.Record_store.domain.RecordRepository;


@Controller
public class RecordController {


	@Autowired
	private RecordRepository repository; 
	
    //Etusivu kirjalistalla 
    @RequestMapping(value="/")
    public String recordList2(Model model) {	
        model.addAttribute("records", repository.findAll());
        return "recordlist";
    }

	
	//Login sivusto. @RequestMapping(value="/login")
    @RequestMapping(value="/login")
    public String login() {	
        return "login"; 
    }	
    
    //Hakee kaikki kirjat.
    @RequestMapping(value="/recordlist")
    public String recordList(Model model) {	
        model.addAttribute("records", repository.findAll());
        return "recordlist";
    }
    
    //Tallennetaan uusi kirja
    @RequestMapping(value = "/add")
    public String addRecord(Model model){
    	model.addAttribute("record", new Record());
        return "addrecord";
    } 
    
    //Poistetaan kirja ID:n perusteella, joka tulee urlin mukana.
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteRecord(@PathVariable("id") Long Id, Model model) {
    	repository.delete(Id);
        return "redirect:../recordlist";
    }   
    
    //Tallennetaan kirja
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Record record){
        repository.save(record);
        return "redirect:recordlist";
    }        
    
    //Haetaan kaikki kirjat repositorystä.
    @RequestMapping(value="/records", method = RequestMethod.GET)
    public @ResponseBody List<Record> recordListRest() {	
        return (List<Record>) repository.findAll();
    }    
    
	// Hae kirja ID:n perusteella, joka lähetetään osoiterivin kautta.
    @RequestMapping(value="/record/{id}", method = RequestMethod.GET)
    public @ResponseBody Record findRecordRest(@PathVariable("id") Long Id) {	
    	return repository.findOne(Id);
    }    
}
