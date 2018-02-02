package nc.impl.gl;

import nc.bs.framework.common.NCLocator;
import nc.itf.gl.IGl_budgetMaintain;

public class AggBudgetVOService {

	private IGl_budgetMaintain service;

	public IGl_budgetMaintain getService() {

		if (null == service) {
			service = NCLocator.getInstance().lookup(IGl_budgetMaintain.class);
		}
		return service;
	}

	public void setService(IGl_budgetMaintain service) {
		this.service = service;
	}
}
