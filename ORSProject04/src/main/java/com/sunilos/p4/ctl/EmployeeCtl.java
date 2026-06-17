package com.sunilos.p4.ctl;

import com.sunilos.p4.bean.EmployeeBean;
import com.sunilos.p4.model.EmployeeModel;
import com.sunilos.p4.util.DataUtility;
import com.sunilos.p4.util.DataValidator;
import com.sunilos.p4.util.PropertyReader;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
@WebServlet("/ctl/EmployeeCtl")
public class EmployeeCtl extends BaseCtl<EmployeeBean, EmployeeModel>{
	
	@Override
	protected boolean validate(HttpServletRequest request) {
		
		boolean pass = true;
		
		if(DataValidator.isNull(request.getParameter("employeeName"))) {
			request.setAttribute("employeeName", PropertyReader.getValue("error.require", "EmployeeName"));
			pass = false;
		}
		
		if(DataValidator.isNull(request.getParameter("company"))) {
			request.setAttribute("company", PropertyReader.getValue("error.require", "Company"));
			pass = false;
			
		}
		
		if(DataValidator.isNull(request.getParameter("salary"))) {
			request.setAttribute("salary", PropertyReader.getValue("error.require", "Salary"));
			pass = false;
		}
		
		if(DataValidator.isNull(request.getParameter("dob"))) {
			request.setAttribute("dob", PropertyReader.getValue("error.require", "Dob"));
			pass = false;
		}
		return pass;
		
	}
	
	@Override
	protected EmployeeBean populateBean(HttpServletRequest request) {
		EmployeeBean bean = new EmployeeBean();
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setEmployeeName(DataUtility.getStringData(request.getParameter("employeeName")));
		bean.setCompany(DataUtility.getStringData(request.getParameter("company")));
		bean.setSalary(DataUtility.getStringData(request.getParameter("salary")));
		bean.setDob(DataUtility.getDate(request.getParameter("dob")));
		
		populateDTO(bean, request);
		return bean;
	}

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getView(String op) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected EmployeeModel getModel() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
