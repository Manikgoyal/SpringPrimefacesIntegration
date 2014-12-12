package primefaces.spring.web.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import test.service.pojo.Person;
import test.service.user.mgmt.IUserMgmtService;


@ManagedBean(name="tServiceBean")
@ViewScoped
@Controller
public class TestService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Person> personList;
	
	@Autowired
	IUserMgmtService iUserMgmtService;
	
	public void populatePersonList(ActionEvent actionEvent){
		System.out.println("List=="+iUserMgmtService.getPersonList());
		
		this.personList.addAll(iUserMgmtService.getPersonList());
		
			
		
	}
	
	
	public TestService() {
		personList = new ArrayList<Person>();
		System.out.println("Bean Initialized");
	}


	public List<Person> getPersonList() {
		return personList;
	}


	public void setPersonList(List<Person> personList) {
		this.personList = personList;
	}
	
		
	
	
}
