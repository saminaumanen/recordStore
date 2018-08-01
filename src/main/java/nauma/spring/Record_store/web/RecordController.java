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
	
    //recordlist frontpage
    @RequestMapping(value="/")
    public String recordList2(Model model) {	
        model.addAttribute("records", repository.findAll());
        return "recordlist";
    }

	
	//Login page @RequestMapping(value="/login")
    @RequestMapping(value="/login")
    public String login() {	
        return "login"; 
    }	
    
    //search all.
    @RequestMapping(value="/recordlist")
    public String recordList(Model model) {	
        model.addAttribute("records", repository.findAll());
        return "recordlist";
    }
    
    //save new
    @RequestMapping(value = "/add")
    public String addRecord(Model model){
    	model.addAttribute("record", new Record());
        return "addrecord";
    } 
    
    //delete
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteRecord(@PathVariable("id") Long Id, Model model) {
    	repository.delete(Id);
        return "redirect:../recordlist";
    }   
    
    //save
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Record record){
        repository.save(record);
        return "redirect:recordlist";
    }        
    
    
    @RequestMapping(value="/records", method = RequestMethod.GET)
    public @ResponseBody List<Record> recordListRest() {	
        return (List<Record>) repository.findAll();
    }    
    
	// search by id
    @RequestMapping(value="/record/{id}", method = RequestMethod.GET)
    public @ResponseBody Record findRecordRest(@PathVariable("id") Long Id) {	
    	return repository.findOne(Id);
    }    
}
