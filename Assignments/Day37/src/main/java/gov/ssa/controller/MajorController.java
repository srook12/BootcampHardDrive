package gov.ssa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gov.ssa.entity.Major;
import gov.ssa.service.IMajorService;

@CrossOrigin
@Controller
public class MajorController {
	@Autowired
	private IMajorService majorService;
	
	@RequestMapping(value= "/majors/list_majors", method = RequestMethod.GET)
    public ResponseEntity<List<Major>> getAllMajors() {
        return new ResponseEntity<List<Major>>(majorService.getAllMajors(), HttpStatus.OK);
    }
	
	@RequestMapping(value="/majors/list_eligible_majors/{sat}", method = RequestMethod.GET)
	public ResponseEntity<List<Major>> listEligibleMajors(@PathVariable("sat") Integer sat) {
		return new ResponseEntity<List<Major>>(majorService.listEligibleMajors(sat), HttpStatus.OK);	
	}
	
	@RequestMapping(value="/majors/major_info/{id}", method = RequestMethod.GET)
	public ResponseEntity<Major> getMajorById(@PathVariable("id") Integer id) {
		return new ResponseEntity<Major>(majorService.getMajorById(id), HttpStatus.OK);
	}

	@RequestMapping(value="/majors/add_major/{description}/{req_sat}", method = RequestMethod.GET)
	public ResponseEntity<Void> addMajor(@PathVariable("description") String description,
										 @PathVariable("req_sat") Integer req_sat) {
		try {
			Major major = new Major(description, req_sat);
						
			majorService.addMajor(major);
			
			return ResponseEntity.accepted().build();
		} catch(Exception ex) {
			return ResponseEntity.unprocessableEntity().build();
		}
	}

	
	@RequestMapping(value="/majors/update_major/{id}/{description}/{req_sat}", method = RequestMethod.GET)
	public ResponseEntity<Void> updateMajor(@PathVariable("id") Integer id,
			                                @PathVariable("description") String description,
			                                @PathVariable("req_sat") Integer req_sat) {
		try {
			Major major = majorService.getMajorById(id);
			major.setDescription(description);
			major.setReq_sat(req_sat);
				
			majorService.updateMajor(major);
			
			return ResponseEntity.noContent().build();
		} catch (Exception ex) {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@RequestMapping(value="/majors/delete_major/{id}", method = RequestMethod.GET) 
	public ResponseEntity<Void> deleteMajor(@PathVariable("id") Integer id) {
		try {
			majorService.deleteMajor(majorService.getMajorById(id));
			return ResponseEntity.noContent().build();
		} catch (Exception ex) {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
}
