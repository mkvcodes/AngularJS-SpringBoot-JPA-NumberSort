package sorting.Controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import sorting.dao.SortDao;
import sorting.entity.SortingValues;

/**
 * @author Murali
 * Controller class for spring boot application
 *
 */
@RestController
public class SortingController {

	/**
	 * @param json
	 * @return JSON of sorted array and minimum swaps required.
	 *  
	 */
	@RequestMapping(value = "/sortnumbers", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public SortVo sorting(@RequestBody String json) {
		SortVo sortVo = null;
		try {
			SortingValues sortingValues=new SortingValues();			
			Gson gson = new Gson();
			sortVo = gson.fromJson(json, SortVo.class);
			sortingValues.setInput(sortVo.getUserValues().toString());
			Integer intArr[] = new Integer[sortVo.getUserValues().size()];
			intArr = sortVo.getUserValues().toArray(intArr);
			sortVo.setSwapNumber(Helper.minSwaps(intArr));
			Collections.sort(sortVo.getUserValues());					
			sortingValues.setOutput(sortVo.getUserValues().toString());
			sortDao.save(sortingValues);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return sortVo;

	}
	
	/**
	 * @param temp
	 * @return all values in DB as JSON
	 * 
	 */
	@RequestMapping("/findall")
	  @ResponseBody
	  public Iterable<SortingValues> findAll(String temp) {
		try {
			return sortDao.findAll();
	    }
	    catch (Exception ex) {
	    	return null;
	    }
	   
	  }

	@Autowired
	private SortDao sortDao;
}
